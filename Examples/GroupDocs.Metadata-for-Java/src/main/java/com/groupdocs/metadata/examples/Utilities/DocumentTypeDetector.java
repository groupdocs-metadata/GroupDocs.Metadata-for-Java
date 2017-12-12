package com.groupdocs.metadata.examples.Utilities;
import com.groupdocs.metadata.FileFormatChecker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DocumentTypeDetector {
    /// <summary>
    /// Gets and prints document type of the file
    /// </summary>
    /// <param name="path">File Path</param>
    public static void getDocumentType(String path) {
        //Get File Format
        FileFormatChecker fileFormatChecker = new FileFormatChecker(Common.mapSourceFilePath(path));
        System.out.printf("Document Type : %s", fileFormatChecker.getDocumentType());
    }
    /// <summary>
    /// Gets and returns files of a specific document type
    /// </summary>
    /// <param name="directory">Directory Path</param>
    /// <param name="documentType">Document Type</param>
    /// <returns>String array containing file paths</returns>
    public static String[] getFiles(String directory, int documentType) {
        // get all files using Directory.GetFiles approach
        File folder = new File(Common.mapSourceFilePath(directory));
        File[] files = folder.listFiles();
        // return empty array if directory is empty
        if (files.length == 0)
        {
            return new String[0];
        }

        List<String> result = new ArrayList<>();

        for (File path : files)
        {
            FileFormatChecker fileFormatChecker = new FileFormatChecker(path.getPath());

            if (fileFormatChecker.verifyFormat(documentType))
            {
                result.add(path.getName());
            }
        }
        return (String[]) result.toArray();
    }
}

