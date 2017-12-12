package com.groupdocs.metadata.examples.Utilities;

import com.groupdocs.metadata.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DocCleaner
{
    // Absolute path to the GroupDocs.Metadata license file
    private static final String LicensePath = "D:\\GroupDocs.Total.lic";

    // Absolute path to the documents directory
    public final String getDocumentsPath(){ return auto_DocumentsPath; }

    // Absolute path to the documents directory
    public final void setDocumentsPath(String value){ auto_DocumentsPath = value; }

    private String auto_DocumentsPath;

    public DocCleaner(String documentsPath) throws FileNotFoundException
    {
        Path path = Paths.get(Common.mapSourceFilePath(documentsPath));

        this.setDocumentsPath(Common.mapSourceFilePath(documentsPath));
    }

    private static void setInternalLicense()
    {
        com.groupdocs.metadata.License license = new com.groupdocs.metadata.License();
        license.setLicense(LicensePath);
    }

    public final void removeMetadataByAuthor(String authorName)
    {
        File dir = new File(getDocumentsPath());

        File [] files = dir.listFiles();

        for (File f : files)
        {
            String filePath = f.getAbsolutePath();

            // recognize format
            FormatBase format = FormatFactory.recognizeFormat(filePath);
            if(format != null && format.getType() == DocumentType.Doc)
            {

                DocFormat docFormat = (DocFormat)format;

                // get document properties
                DocMetadata properties = docFormat.getDocumentProperties();

                // check if author is the same
                if(authorName.equalsIgnoreCase(properties.getAuthor()))
                {
                    // remove comments
                    docFormat.clearComments();

                    // clear custom properties
                    properties.clearCustomData();

                    // and commit changes
                    docFormat.save();
                }
            }
        }
    }

    static
    {
        // apply license at once
        setInternalLicense();
    }
}
