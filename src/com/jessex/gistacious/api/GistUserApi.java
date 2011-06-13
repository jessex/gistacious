package com.jessex.gistacious.api;

import java.io.IOException;

import com.jessex.gistacious.gist.GistUser;

public interface GistUserApi extends AuthenticationApi {

	GistUser getUser(String user) throws IOException;
	
	GistUser getMyUser() throws IOException;
	
}
