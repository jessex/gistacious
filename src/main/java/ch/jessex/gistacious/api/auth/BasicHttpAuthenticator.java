package ch.jessex.gistacious.api.auth;

import ch.jessex.gistacious.api.Validator;
import org.apache.http.Header;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.auth.BasicScheme;

/**
 * Default implementation of the {@link HttpAuthenticator} interface.
 * 
 * @author jessex
 */
public class BasicHttpAuthenticator implements HttpAuthenticator {

    // TODO: Consider adding OAuth implementation, will likely need to refactor how authentication is done

    private static final String REQUEST_ENCODING = "UTF-8";

	/**
     * {@inheritDoc}
     * This implementation of the authenticator uses "basic" authentication, using the combination of a user's name and
     * password.
     */
	@Override
	public void addAuthenticationCredentials(HttpRequestBase request, AuthenticationCredentialsDTO credentials) {
        Validator.paramNotNull(request, "request");

	    Header header = BasicScheme.authenticate(
                new UsernamePasswordCredentials(credentials.getUserName(), credentials.getPassword()),
                REQUEST_ENCODING, false);

        request.addHeader(header);
	}
}
