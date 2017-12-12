package com.groupdocs.metadata.examples.Utilities;
import com.groupdocs.metadata.FormatBase;
import com.groupdocs.metadata.FormatFactory;
import com.groupdocs.metadata.MetadataUtility;

public class MIMETypeDetector {
    public static void getFileFormats(String path) {
        // recognize file by it's signature
        FormatBase format = FormatFactory.recognizeFormat(path);
        if (format != null)
        {
            System.out.printf("File: %s, type: %s", path, format.getType());
        }
    }
    public static void getMimeType(String path) {
        // get MIME type string
        String mimeType = MetadataUtility.getMimeType(Common.mapSourceFilePath(path));

        System.out.printf("File: %, MIME type: %", path, mimeType);
    }
}
