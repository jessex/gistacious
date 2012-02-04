package com.jessex.gistacious.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jessex.gistacious.gist.*;

/**
 * Default implementation of the {@link JsonDeserializer} interface.
 * 
 * @author jessex
 */
public class DefaultJsonDeserializer implements JsonDeserializer {
	
	private JSONParser parser = new JSONParser();
	
	private JsonCache<String, GistUser> userCache = new JsonUserCache();
	
	/** {@inheritDoc} */
	@Override
	public Gist deserializeGistFromJson(String json) {
		JSONObject gistJO = null;
		try {
			gistJO = (JSONObject) parser.parse(json); 
		} catch (ParseException pe) {
			return null;
		}
		return parseGistFromJSONObject(gistJO);
	}
		
	/**
	 * Returns a Gist object parsed from the given JSONObject.
	 * 
	 * @param gistJO JSONObject to parse
	 * @return Gist object
	 */
	private Gist parseGistFromJSONObject(JSONObject gistJO) {
		Gist gist = new Gist();
		Object temp = null;
		
		//Parse base attributes of gist from JSON
		gist.setDescription((String) gistJO.get("description"));
		gist.setCreatedAt((String) gistJO.get("created_at"));
		gist.setUpdatedAt((String) gistJO.get("updated_at"));
		gist.setUrl((String) gistJO.get("url"));
		gist.setHtmlUrl((String) gistJO.get("html_url"));
		gist.setGitPushUrl((String) gistJO.get("git_push_url"));
		gist.setGitPullUrl((String) gistJO.get("git_pull_url"));
		
		temp = gistJO.get("comments");
		if (temp != null) gist.setCommentCount((Integer) temp);
		else gist.setCommentCount(0);
		temp = gistJO.get("public");
		if (temp != null) gist.setPublic((Boolean) temp);
		else gist.setPublic(false);
		temp = gistJO.get("id");
		if (temp != null) gist.setId((Long) temp);
		else gist.setId(0L);
		
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
			gist.setHistories(deserializeGistHistoriesFromJson((String) 
					gistJO.get("history")));
		} catch (ParseException pe) {
			gist.setHistories(null);
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
	 * Parses and deserializes a GistUser object from the provided JSON text.
	 * 
	 * @param userJson JSON text to parse
	 * @return GistUser corresponding to some Gist
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	private GistUser deserializeGistUserFromJson(String userJson) 
	throws ParseException {
		JSONObject userJO = (JSONObject) parser.parse(userJson);
		String user = (String) userJO.get("login");
		
		//Check if user in cache, if not parse entire thing, if so return it
		GistUser gistUser = userCache.getValue(user);
		if (gistUser == null) {
			long id = 0L;
			Object temp = userJO.get("id");
			if (temp != null) id = (Long) temp;
			
			gistUser = new GistUser(user, id, (String) userJO.get("url"), 
					(String) userJO.get("avatar_url"), (String) 
					userJO.get("gravatar_url"));
			userCache.putValue(user, gistUser);
		}
		
		return gistUser;
	}
	
	/**
	 * Parses and deserializes a list of GistFile objects from the provided 
	 * JSON text.
	 * 
	 * @param fileJson JSON text to parse
	 * @return list of GistFile objects corresponding to some Gist
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	private List<GistFile> deserializeGistFilesFromJson(String fileJson) 
	throws ParseException {
		JSONObject obj = (JSONObject) parser.parse(fileJson);
		Collection<?> files = obj.values(); 
		List<GistFile> gistFiles = new ArrayList<GistFile>();
		Object temp = null;
		
		for (Object file : files) {
			JSONObject f = (JSONObject) file;
			String content = (String) f.get("content");
			String filename = (String) f.get("filename");
			String rawUrl = (String) f.get("raw_url");
			long size = 0L;
			temp = f.get("size");
			if (temp != null) size = (Long) temp;
			gistFiles.add(new GistFile(filename, content, rawUrl, size));
		}
		
		return gistFiles;
	}
	
	/**
	 * Parses and deserializes a list of GistHistory objects from the provided 
	 * JSON text.
	 * 
	 * @param historyJson JSON text to parse
	 * @return list of GistHistory objects corresponding to some Gist
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
	 * Parses and deserializes a GistChangeStatus object corresponding to a 
	 * GistHistory for some Gist from the provided JSON text.
	 * 
	 * @param csJson JSON text to parse
	 * @return GistChangeStatus corresponding to some Gist's GistHistory
	 * @throws ParseException (org.json.simple.parser.ParseException)
	 */
	private GistChangeStatus deserializeGistChangeStatusFromJson(String csJson) 
	throws ParseException {
		JSONObject csJO = (JSONObject) parser.parse(csJson);
		int additions, deletions, total;
		additions = deletions = total = 0;
		
		Object temp = csJO.get("additions");
		if (temp != null) additions = (Integer) temp;
		temp = csJO.get("deletions");
		if (temp != null) deletions = (Integer) temp;
		temp = csJO.get("total");
		if (temp != null) total = (Integer) temp;
			
		return new GistChangeStatus(additions, deletions, total);
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
		Object temp = null;
		
		for (Object fork : forkArray) {
			JSONObject f = (JSONObject) fork;
			String url = (String) f.get("url");
			String createdAt = (String) f.get("created_at");
			GistUser user = deserializeGistUserFromJson((String) f.get("user"));
			long id = 0L;
			temp = f.get("id");
			if (temp != null) id = (Long) temp;
			gistForks.add(new Gist(id, url, createdAt, user));
		}
		
		return gistForks;
	}
	
	/** {@inheritDoc} */
	@Override
	public List<Gist> deserializeGistsFromJson(String json) {
		JSONArray gistArray = null;
		try {
			gistArray = (JSONArray) parser.parse(json);
		} catch (ParseException e) {
			return null;
		}
		
		List<Gist> gists = new ArrayList<Gist>();
		for (Object gist : gistArray) {
			JSONObject gistJO = (JSONObject) gist;
			gists.add(parseGistFromJSONObject(gistJO));
		}
		
		return gists;
	}
	
	/** {@inheritDoc} */
	@Override
	public GistComment deserializeCommentFromJson(String json) {
		JSONObject commentJO = null;
		try {
			commentJO = (JSONObject) parser.parse(json);
		} catch (ParseException e) {
			return null;
		}
		
		return parseGistCommentFromJSONObject(commentJO);
	}
		
	/**
	 * Parses a GistComment object from the given JSONObject.
	 * 
	 * @param JSONObject to parse
	 * @return GistComment object
	 */
	private GistComment parseGistCommentFromJSONObject(JSONObject commentJO) {
		String url = (String) commentJO.get("url");
		String body = (String) commentJO.get("body");
		String createdAt = (String) commentJO.get("created_at");
		long id = 0L;
		Object temp = commentJO.get("id");
		if (temp != null) id = (Long) temp;
		
		GistUser user = null;
		try {
			user = deserializeGistUserFromJson((String) 
					commentJO.get("user"));
		} catch (ParseException e) { }
		
		return new GistComment(id, url, body, createdAt, user);
	}
	
	/** {@inheritDoc} */
	@Override
	public List<GistComment> deserializeCommentsFromJson(String json) {
		JSONArray commentArray = null;
		try {
			commentArray = (JSONArray) parser.parse(json);
		} catch (ParseException e) {
			return null;
		}
		List<GistComment> comments = new ArrayList<GistComment>();
		for (Object comment : commentArray) {
			JSONObject commentJO = (JSONObject) comment;
			comments.add(parseGistCommentFromJSONObject(commentJO));
		}
		return comments;
	}

	/** {@inheritDoc} */
	@Override
	public GistUser deserializeUserFromJson(String json) {
		JSONObject userJO = null;
		try {
			userJO = (JSONObject) parser.parse(json);
		} catch (ParseException e) {
			return null;
		}
		
		GistUser user = new GistUser();
		Object temp = null;
		
		user.setLogin((String) userJO.get("login"));
		user.setUrl((String) userJO.get("url"));
		user.setCreatedAt((String) userJO.get("created_at"));
		user.setAvatarUrl((String) userJO.get("avatar_url"));
		user.setGravatarUrl((String) userJO.get("gravatar_url"));
		user.setHtmlUrl((String) userJO.get("html_url"));
		user.setName((String) userJO.get("name"));
		user.setType((String) userJO.get("type"));
		user.setCompany((String) userJO.get("company"));
		user.setLocation((String) userJO.get("location"));
		user.setBlog((String) userJO.get("blog"));
		user.setEmail((String) userJO.get("email"));
		user.setBio((String) userJO.get("bio"));
		
		temp = userJO.get("id");
		if (temp != null) user.setId((Long) temp);
		else user.setId(0L);
		temp = userJO.get("hireable");
		if (temp != null) user.setHireable((Boolean) temp);
		else user.setHireable(false);
		temp = userJO.get("followers");
		if (temp != null) user.setFollowerCount((Integer) temp);
		else user.setFollowerCount(0);
		temp = userJO.get("following");
		if (temp != null) user.setFollowingCount((Integer) temp);
		else user.setFollowingCount(0);
		temp = userJO.get("public_repos");
		if (temp != null) user.setPublicRepoCount((Integer) temp);
		else user.setPublicRepoCount(0);
		temp = userJO.get("public_gists");
		if (temp != null) user.setPublicGistCount((Integer) temp);
		else user.setPublicGistCount(0);
		temp = userJO.get("private_gists");
		if (temp != null) user.setPrivateGistCount((Integer) temp);
		else user.setPrivateGistCount(0);
		temp = userJO.get("total_private_repos");
		
		if (temp != null) {
			user.setPrivateRepoCount((Integer) temp);
			//Got private info, must be authenticated user
			user.setIsMe(true);
		}
		else {
			user.setPrivateRepoCount(0);
			//No private info, must not be authenticated
			user.setIsMe(false); 
		}
		
		return user;
	}
}
