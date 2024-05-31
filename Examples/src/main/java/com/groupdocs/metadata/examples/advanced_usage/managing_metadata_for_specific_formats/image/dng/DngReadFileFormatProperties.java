package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.dng;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DngRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
* This code snippet shows how to detect the version of a loaded DNG image and extract some additional file format information.
*/
public class DngReadFileFormatProperties
{
    public static void run()
    {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # DngReadFileFormatProperties : How to detect the version of a loaded DNG image and extract some additional file format information.\n");
        Metadata metadata = new Metadata(Constants.InputDng);
        {
            DngRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getImageType().getFileFormat());
            System.out.println(root.getImageType().getByteOrder());
            System.out.println(root.getImageType().getMimeType());
            System.out.println(root.getImageType().getExtension());
            System.out.println(root.getImageType().getWidth());
            System.out.println(root.getImageType().getHeight());
            System.out.println(root.getDngPackage().getArtist());
            System.out.println(root.getDngPackage().getDescription());
        }
    }
}
