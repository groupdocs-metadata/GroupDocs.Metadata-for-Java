package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.RarFile;
import com.groupdocs.metadata.core.RarRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
* The following code snippet shows how to get metadata from a Rar archive.
*/
public class RarReadNativeMetadataProperties
{
    public static void run()
    {

        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # RarReadNativeMetadataProperties : How to get metadata from a Rar archive.\n");
        Metadata metadata = new Metadata(Constants.InputRar);
        {
            RarRootPackage root = metadata.getRootPackageGeneric();
            System.out.println(root.getRarPackage().getTotalEntries());

            for (RarFile file : root.getRarPackage().getFiles())
            {
                System.out.println(file.getName());
                System.out.println(file.getCompressedSize());
                System.out.println(file.getModificationDateTime());
                System.out.println(file.getUncompressedSize());
            }
        }
    }
}
