package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.TarFile;
import com.groupdocs.metadata.core.TarRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
* The following code snippet shows how to get metadata from a Tar archive.
*/
public class TarReadNativeMetadataProperties
{
    public static void run()
    {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # TarReadNativeMetadataProperties : How to get metadata from a Tar archive.\n");
        Metadata metadata = new Metadata(Constants.InputTar);
        {
            TarRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getTarPackage().getTotalEntries());

            for (TarFile file : root.getTarPackage().getFiles())
            {
                System.out.println(file.getName());
                System.out.println(file.getSize());

            }
        }
    }
}