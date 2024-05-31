package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.SevenZipFile;
import com.groupdocs.metadata.core.SevenZipRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
* The following code snippet shows how to get metadata from a SevenZip archive.
*/
public class SevenZipReadNativeMetadataProperties
{
    public static void run()
    {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # SevenZipReadNativeMetadataProperties : How to get metadata from a SevenZip archive.\n");
        Metadata metadata = new Metadata(Constants.InputSevenZip);
        {
            SevenZipRootPackage root = metadata.getRootPackageGeneric();
            System.out.println(root.getSevenZipPackage().getTotalEntries());

            for (SevenZipFile file : root.getSevenZipPackage().getFiles())
            {
                System.out.println(file.getName());
                System.out.println(file.getCompressedSize());
                System.out.println(file.getModificationDateTime());
                System.out.println(file.getUncompressedSize());
            }
        }
    }
}
