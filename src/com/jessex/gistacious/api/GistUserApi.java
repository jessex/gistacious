package com.jessex.gistacious.api;

import com.jessex.gistacious.gist.GistUser;

public interface GistUserApi extends AuthenticationApi {

	GistUser getUser(String user);
	
	GistUser getMyUser();
	
}
