package com.jessex.gistacious.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jessex.gistacious.gist.*;

public class JsonSimpleDeserializer implements JsonDeserializer {
	
	private JSONParser parser = new JSONParser(); //Parser for all JSON text
	//Cache for GistUser objects taken from JSON text
	private JsonCache<String, GistUser> userCache = new JsonUserCache(); 
	
	/**
	 * Parses and deserializes a Gist object from the provided JSON text. This
	 * Gist object does not contain all comments on said Gist, as obtaining a 
	 * given Gist's comments requires a completely separate Github API call.
	 * @param json -
	 * 			JSON text to parse
	 * @return gist -
	 * 			Gist object with related attributes and objects
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	@Override
	public Object deserializeGistFromJson(String json) {
		JSONObject gistJO = null; //Gist JSON object
		try {
			gistJO = (JSONObject) parser.parse(json); 
		} catch (ParseException pe) {
			return null;
		}
		Gist gist = new Gist(); //Primary gist object
		
		//Parse base attributes of gist from JSON
		gist.setId((Long) gistJO.get("id"));
		gist.setDescription((String) gistJO.get("description"));
		gist.setCommentCount((Integer) gistJO.get("comments"));
		gist.setPublic((Boolean) gistJO.get("public"));
		gist.setCreatedAt((String) gistJO.get("created_at"));
		gist.setUpdatedAt((String) gistJO.get("updated_at"));
		gist.setUrl((String) gistJO.get("url"));
		gist.setHtmlUrl((String) gistJO.get("html_url"));
		gist.setGitPushUrl((String) gistJO.get("git_push_url"));
		gist.setGitPullUrl((String) gistJO.get("git_pull_url"));
		
		//Parse gist that this gist was forked from, if any
		String forkString = (String) gistJO.get("fork_of");
		if (forkString != null) 
				gist.setForkOf((Gist) deserializeGistFromJson(forkString));
		else gist.setForkOf(null);
		
		//Parse user for this gist
		try {
			gist.setUser(deserializeGistUserFromJson((String) 
					gistJO.get("user")));
		} catch (ParseException pe) {
			gist.setUser(null);
		}
		
		//Parse list of commit histories for gist
		try {
			gist.setHistory(deserializeGistHistoriesFromJson((String) 
					gistJO.get("history")));
		} catch (ParseException pe) {
			gist.setHistory(null);
		}
		
		//Parse list of files in this gist
		try {
			gist.setFiles(deserializeGistFilesFromJson((String) 
					gistJO.get("files")));
		} catch (ParseException pe) {
			gist.setFiles(null);
		}
		
		//Parse list of gists forked from this gist
		try {
			gist.setForks(deserializeGistForksFromJson((String) 
					gistJO.get("forks")));
		} catch (ParseException pe) {
			gist.setForks(null);
		}
		
		return gist;
	}
	
	/**
	 * Parses and deserializes a GistChangeStatus object corresponding to a 
	 * GistHistory for some Gist from the provided JSON text.
	 * @param csJson -
	 * 			JSON text to parse
	 * @return gistChangeStatus -
	 * 			GistChangeStatus corresponding to some Gist's GistHistory
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	private GistChangeStatus deserializeGistChangeStatusFromJson(String csJson) 
	throws ParseException {
		JSONObject csJO = (JSONObject) parser.parse(csJson);
		return new GistChangeStatus((Integer) csJO.get("additions"),(Integer)
				csJO.get("deletions"), (Integer) csJO.get("total"));
	}
	
	/**
	 * Parses and deserializes a GistUser object from the provided JSON text.
	 * @param userJson -
	 * 			JSON text to parse
	 * @return gistUser -
	 * 			GistUser corresponding to some Gist
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	private GistUser deserializeGistUserFromJson(String userJson) 
	throws ParseException {
		JSONObject userJO = (JSONObject) parser.parse(userJson);
		String user = (String) userJO.get("login");
		
		//Check if user in cache, if not parse entire thing, if so return it
		GistUser gistUser = userCache.getValue(user);
		if (gistUser == null) { //User not yet in cache, so build and add it
			gistUser = new GistUser(user, (Long) userJO.get("id"), (String) 
					userJO.get("url"), (String) userJO.get("avatar_url"), 
					(String) userJO.get("gravatar_url"));
			userCache.addValue(user, gistUser);
		}
		
		return gistUser;
	}
	
	/**
	 * Parses and deserializes a list of GistFile objects from the provided 
	 * JSON text.
	 * @param fileJson -
	 * 			JSON text to parse
	 * @return gistFiles -
	 * 			list of GistFile objects corresponding to some Gist
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	private List<GistFile> deserializeGistFilesFromJson(String fileJson) 
	throws ParseException {
		JSONObject obj = (JSONObject) parser.parse(fileJson);
		Collection files = obj.values(); //Isolate file value from filename key
		List<GistFile> gistFiles = new ArrayList<GistFile>();
		
		for (Object file : files) {
			JSONObject f = (JSONObject) file;
			String content = (String) f.get("content");
			String filename = (String) f.get("filename");
			String rawUrl = (String) f.get("raw_url");
			long size = (Long) f.get("size");
			gistFiles.add(new GistFile(filename, content, rawUrl, size));
		}
		
		return gistFiles;
	}
	
	/**
	 * Parses and deserializes a list of GistHistory objects from the provided 
	 * JSON text.
	 * @param historyJson -
	 * 			JSON text to parse
	 * @return gistHistories -
	 * 			list of GistHistory objects corresponding to some Gist
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	private List<GistHistory> deserializeGistHistoriesFromJson(String 
			historyJson) throws ParseException {
		JSONArray histArray = (JSONArray) parser.parse(historyJson);
		List<GistHistory> gistHistories = new ArrayList<GistHistory>();
		
		for (Object history : histArray) {
			JSONObject h = (JSONObject) history;
			String url = (String) h.get("url");
			String version = (String) h.get("version");
			String committedAt = (String) h.get("committed_at");
			GistChangeStatus gcs = deserializeGistChangeStatusFromJson((String) 
					h.get("change_status"));
			GistUser user = deserializeGistUserFromJson((String) h.get("user"));
			gistHistories.add(new GistHistory(url, version, committedAt, 
					user, gcs));
		}
		
		return gistHistories;
	}
	
	/**
	 * Parses and deserializes a list of Gist objects from the provided JSON 
	 * text. 
	 * @param forkJson -
	 * 			JSON text to parse
	 * @return gistForks -
	 * 			list of GistFile objects forked from some other Gist
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	private List<Gist> deserializeGistForksFromJson(String forkJson) 
	throws ParseException {
		JSONArray forkArray = (JSONArray) parser.parse(forkJson);
		List<Gist> gistForks = new ArrayList<Gist>();
		
		for (Object fork : forkArray) {
			JSONObject f = (JSONObject) fork;
			long id = (Long) f.get("id");
			String url = (String) f.get("url");
			String createdAt = (String) f.get("created_at");
			GistUser user = deserializeGistUserFromJson((String) f.get("user"));
			gistForks.add(new Gist(id, url, createdAt, user));
		}
		
		return gistForks;
	}
	
	/**
	 * Parses and deserializes a GistComment object from the provided JSON text.
	 * @param json -
	 * 			JSON text to parse
	 * @return gistComment -
	 * 			GistComment corresponding to some Gist
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	@Override
	public Object deserializeCommentFromJson(String json) {
		JSONObject commentJO = null;
		try {
			commentJO = (JSONObject) parser.parse(json);
		} catch (ParseException e) {
			return null;
		}
		
		String id = (String) commentJO.get("id");
		String url = (String) commentJO.get("url");
		String body = (String) commentJO.get("body");
		String createdAt = (String) commentJO.get("created_at");
		GistUser user = null;
		try {
			user = deserializeGistUserFromJson((String) 
					commentJO.get("user"));
		} catch (ParseException e) { }
		
		return new GistComment(id, url, body, createdAt, user);
	}


}
