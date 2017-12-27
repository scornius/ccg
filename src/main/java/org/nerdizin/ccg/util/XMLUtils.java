package org.nerdizin.ccg.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class XMLUtils {

    public static URL convertToFileURL(final String fileName) throws MalformedURLException {
        String path = new File(fileName).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        return new URL("file:" + path);
    }
}
