package ch.jessex.gistacious.v3.api.json;

import java.util.List;

import ch.jessex.gistacious.v3.gist.Gist;
import ch.jessex.gistacious.v3.gist.GistComment;
import ch.jessex.gistacious.v3.gist.GistFile;

/**
 * Object for serializing Gist* objects as JSON text.
 * 
 * @author jessex
 */
public interface JsonSerializer {

    /**
     * Serializes and returns JSON-formatted text for a Gist.
     *
     * @param gist Gist object to serialize
     * @return serialized JSON text
     */
    String serializeJsonFromGistCreate(Gist gist);

    /**
     * Serializes and returns JSON-formatted text for an edited Gist.
     *
     * @param gist Gist object to serialize
     * @return serialized JSON text
     */
    String serializeJsonFromGistEdit(Gist gist, List<GistFile> oldFiles);

    /**
     * Serializes and returns JSON-formatted text for a GistComment.
     *
     * @param comment GistComment object to serialize
     * @return serialized JSON text
     */
    String serializeJsonFromGistComment(GistComment comment);

}
