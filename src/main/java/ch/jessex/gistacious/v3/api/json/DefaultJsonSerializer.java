package ch.jessex.gistacious.v3.api.json;

import java.util.ArrayList;
import java.util.List;

import ch.jessex.gistacious.v3.gist.Gist;
import ch.jessex.gistacious.v3.gist.GistComment;
import ch.jessex.gistacious.v3.gist.GistFile;

/**
 * Default implementation of the {@link JsonSerializer} interface.
 * 
 * @author jessex
 */
public class DefaultJsonSerializer implements JsonSerializer {

    // TODO: Convert implementation to use Jackson Json

    /** {@inheritDoc} */
    @Override
    public String serializeJsonFromGistCreate(Gist gist) {
        StringBuilder sb = new StringBuilder("{\n\t\"description\": \"");
        sb.append(gist.getDescription());
        sb.append("\",\n\t\"public\": ");
        sb.append(gist.isPublic());
        sb.append(",\n\t\"files\": {\n");

        int length = gist.getFiles().size();
        int i = 0;
        for (GistFile file : gist.getFiles()) {
            sb.append("\t\t\"");
            sb.append(file.getFilename());
            sb.append("\": {\n\t\t\t\"content\": \"");
            sb.append(file.getContent());
            sb.append("\"\n\t\t}");
            i++;
            if (i == length) sb.append("\n");
            else sb.append(",\n");
        }

        sb.append("\t}\n}");

        return sb.toString();
    }

    /** {@inheritDoc} */
    @Override
    public String serializeJsonFromGistEdit(Gist gist,
            List<GistFile> oldFiles) {
        StringBuilder sb = new StringBuilder("{\n\t\"description\": \"");
        sb.append(gist.getDescription());
        sb.append("\",\n\t\"files\": {\n");

        List<String> renamedNames = new ArrayList<String>();

        for (GistFile file : gist.getFiles()) {
            sb.append(serializeGistFileFromComparison(file, oldFiles));
            if (file.isRenamed()) renamedNames.add(file.getOldName());
        }

        for (GistFile file : oldFiles) {
            String filename = file.getFilename();
            if (!gist.getFiles().contains(filename) &&
                    !renamedNames.contains(filename)) {
                sb.append("\"");
                sb.append(filename);
                sb.append("\": null,\n");
            }
        }

        //Remove trailing comma
        sb.replace(sb.length()-2, sb.length()-1, "");

        return sb.toString();
    }

    /**
     * Serializes and returns correct form of JSON-formatted text from GistFile,
     * based upon what sort of edit occurred. This includes changes in filename
     * and content.
     *
     * @param file new GistFile object to serialize
     * @param oldFiles List of old GistFiles from previous version of Gist
     * @return serialized JSON text
     */
    private String serializeGistFileFromComparison(GistFile file,
            List<GistFile> oldFiles) {
        StringBuilder sb = new StringBuilder();

        if (file.isRenamed()) {
            sb.append("\t\t\"");
            sb.append(file.getOldName());
            sb.append("\": {\n\t\t\t\"filename\": \"");
            sb.append(file.getFilename());
            sb.append("\",\n\t\t\t\"content\": \"");
            sb.append(file.getContent());
            sb.append("\"\n\t\t},\n");
            file.setRenamed(false);

            //Change in file name
            return sb.toString();
        }

        for (GistFile oldFile : oldFiles) {
            if (oldFile.getFilename().equals(file.getFilename())) {
              //No change in file content, carried by default
                if (oldFile.getContent().equals(file.getContent()))
                    return "";
                else
                    break;
            }
        }

        sb.append("\t\t\"");
        sb.append(file.getFilename());
        sb.append("\t: {\n\t\t\t\"content\": \"");
        sb.append(file.getContent());
        sb.append("\"\n\t\t},\n");

        //Change in file content or new file entirely
        return sb.toString();
    }

    /** {@inheritDoc} */
    @Override
    public String serializeJsonFromGistComment(GistComment comment) {
        StringBuilder sb = new StringBuilder("{\n\t\"body\": \"");
        sb.append(comment.getBody());
        sb.append("\"\n}");
        return sb.toString();
    }
}
