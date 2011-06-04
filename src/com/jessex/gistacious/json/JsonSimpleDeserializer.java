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
	
	private JSONParser parser = new JSONParser();
	
	@Override
	public Object deserializeGistFromJson(String json) throws ParseException {
		JSONObject gistJO = (JSONObject) parser.parse(json); //Gist JSON object
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
		if (forkString != null) {
			try {
				gist.setForkOf((Gist) deserializeGistFromJson(forkString));
			} catch (ParseException pe) {
				gist.setForkOf(null);
			}
		}
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
			gist.setHistory(deserializeGistHistoryFromJson((String) 
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

	@Override
	public Object deserializeCommentFromJson(String json) 
	throws ParseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private GistChangeStatus deserializeGistChangeStatusFromJson(String csJson) 
	throws ParseException {
		JSONObject csJO = (JSONObject) parser.parse(csJson);
		return new GistChangeStatus((Integer) csJO.get("additions"),(Integer)
				csJO.get("deletions"), (Integer) csJO.get("total"));
	}
	
	private GistUser deserializeGistUserFromJson(String userJson) 
	throws ParseException {
		JSONObject userJO = (JSONObject) parser.parse(userJson);
		String user = (String) userJO.get("login");
		
		//Check if user in cache, if not parse entire thing, if so return it
		
		return new GistUser(user, (Long) userJO.get("id"), (String) 
				userJO.get("url"), (String) userJO.get("avatar_url"), 
				(String) userJO.get("gravatar_url"));
	}
	
	private List<GistFile> deserializeGistFilesFromJson(String fileJson) 
	throws ParseException {
		JSONObject obj = (JSONObject) parser.parse(fileJson);
		Collection files = obj.values(); //Isolate file value from filename key
		List<GistFile> gf = new ArrayList<GistFile>();
		
		for (Object file : files) {
			JSONObject f = (JSONObject) file;
			String content = (String) f.get("content");
			String filename = (String) f.get("filename");
			String rawUrl = (String) f.get("raw_url");
			long size = (Long) f.get("size");
			gf.add(new GistFile(filename, content, rawUrl, size));
		}
		
		return gf;
	}
	
	private List<GistHistory> deserializeGistHistoryFromJson(String historyJson) 
	throws ParseException {
		JSONArray histArray = (JSONArray) parser.parse(historyJson);
		List<GistHistory> gh = new ArrayList<GistHistory>();
		
		for (Object history : histArray) {
			JSONObject h = (JSONObject) history;
			String url = (String) h.get("url");
			String version = (String) h.get("version");
			String committedAt = (String) h.get("committed_at");
			GistChangeStatus gcs = deserializeGistChangeStatusFromJson((String) 
					h.get("change_status"));
			GistUser user = deserializeGistUserFromJson((String) h.get("user"));
			gh.add(new GistHistory(url, version, committedAt, user, gcs));
		}
		
		return gh;
	}
	
	private List<Gist> deserializeGistForksFromJson(String forkJson) 
	throws ParseException {
		JSONArray forkArray = (JSONArray) parser.parse(forkJson);
		List<Gist> gf = new ArrayList<Gist>();
		
		for (Object fork : forkArray) {
			JSONObject f = (JSONObject) fork;
			long id = (Long) f.get("id");
			String url = (String) f.get("url");
			String createdAt = (String) f.get("created_at");
			GistUser user = deserializeGistUserFromJson((String) f.get("user"));
			gf.add(new Gist(id, url, createdAt, user));
		}
		
		return gf;
	}
	


}
