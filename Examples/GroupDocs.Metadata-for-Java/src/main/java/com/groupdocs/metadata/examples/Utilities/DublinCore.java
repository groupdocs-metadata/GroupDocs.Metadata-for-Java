package com.groupdocs.metadata.examples.Utilities;

import com.groupdocs.metadata.*;

import java.io.File;
import java.nio.file.Path;

import static com.groupdocs.metadata.examples.Utilities.Common.getProjectBaseDir;

public class DublinCore {
    // initialize XMPFilesDirectory
    private static Path XMPFilesDirectory = getProjectBaseDir().resolve("Data/Source/XMPFiles/");

    public static void getDublinCoreMetadata() {
        File folder = new File(String.valueOf(XMPFilesDirectory));
        for (File file : folder.listFiles())
        {
            if (file.isFile())
            {
                try
                {
                    DublinCoreMetadata dublinCoreMetadata = (DublinCoreMetadata) MetadataUtility.extractSpecificMetadata(file.getAbsolutePath(), MetadataType.DublinCore);
                    if (dublinCoreMetadata != null)
                    {
                        System.out.println(dublinCoreMetadata.getCreator());
                        System.out.println(dublinCoreMetadata.getFormat());
                        System.out.println(dublinCoreMetadata.getSubject());
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Could not load " + file.getName());
                }
            }
        }
    }
    public static void getDublinCoreMetadataUsingIDublinCore() {
        File folder = new File(String.valueOf(XMPFilesDirectory));
        for (File file : folder.listFiles())
        {
            if (file.isFile())
            {
                try
                {
                    try (FormatBase format = FormatFactory.recognizeFormat(file.getAbsolutePath()))
                    {
                        if (format instanceof IDublinCore)
                        {
                            IDublinCore dublinCoreContainer = (IDublinCore)format;
                            DublinCoreMetadata dublinCoreMetadata = dublinCoreContainer.getDublinCore();
                            if (dublinCoreMetadata != null)
                            {
                                System.out.println(dublinCoreMetadata.getCreator());
                                System.out.println(dublinCoreMetadata.getFormat());
                                System.out.println(dublinCoreMetadata.getSubject());
                            }
                        }
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Could not load " + file.getName());
                }
            }
        }
    }
}
