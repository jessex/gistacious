package ch.jessex.gistacious.api.json;

import java.util.List;

import ch.jessex.gistacious.gist.Gist;
import ch.jessex.gistacious.gist.GistComment;
import ch.jessex.gistacious.gist.GistUser;

/**
 * Object for deserializing JSON-formatted text into Gist* objects.
 * 
 * @author jessex
 */
public interface JsonDeserializer {

    /**
     * Parses and deserializes a Gist object from the provided JSON text. This
     * Gist object does not contain all comments on said Gist, as obtaining a
     * given Gist's comments requires a completely separate Github API call.
     *
     * @param json JSON text to parse
     * @return Gist object with related attributes and objects
     */
    Gist deserializeGistFromJson(String json);

    /**
     * Parses and deserializes a List of Gist objects from the provided JSON
     * text. If there is an error with parsing the JSON, null is returned.
     *
     * @param json JSON text to parse
     * @return List of Gist objects
     */
    List<Gist> deserializeGistsFromJson(String json);

    /**
     * Parses and deserializes a GistComment object from the provided JSON text.
     *
     * @param json JSON text to parse
     * @return GistComment corresponding to some Gist
     */
    GistComment deserializeCommentFromJson(String json);

    /**
     * Parses and deserializes a List of GistComment objects from the provided
     * JSON text. If there is an error with parsing the JSON, null is returned.
     *
     * @param json JSON text to parse
     * @return List of GistComment objects
     */
    List<GistComment> deserializeCommentsFromJson(String json);

    /**
     * Parses and deserializes an expanded GistUser object from the provided
     * JSON text. This user contains all fields contained in the "user" objects
     * found in standard Gist JSON responses, in addition to more fields found
     * in User JSON responses. If certain fields are present, namely
     * "private_gists" and "total_private_repos", then this must be the
     * currently authenticated user.
     *
     * @param json JSON text to parse
     * @return GistUser corresponding to some Github user
     */
    GistUser deserializeUserFromJson(String json);

}
