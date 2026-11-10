// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.tiff;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ExifPackage;
import com.groupdocs.metadata.core.IExif;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to update EXIF metadata properties in a TIFF image.
 */
public class TiffUpdateExifProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # TiffUpdateExifProperties : How to update EXIF metadata properties in a TIFF image.\n");
        try (Metadata metadata = new Metadata(Constants.TiffWithExif)) {
            IExif root = (IExif) metadata.getRootPackage();

            // Set the EXIF package if it's missing
            if (root.getExifPackage() == null) {
                root.setExifPackage(new ExifPackage());
            }

            root.getExifPackage().setCopyright("Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.");
            root.getExifPackage().setImageDescription("test TIFF image");
            root.getExifPackage().setSoftware("GroupDocs.Metadata");
            root.getExifPackage().setArtist("GroupDocs");

            // ...

            root.getExifPackage().getExifIfdPackage().setBodySerialNumber("test");
            root.getExifPackage().getExifIfdPackage().setCameraOwnerName("GroupDocs");
            root.getExifPackage().getExifIfdPackage().setUserComment("test comment");

            // ...

            metadata.save(Constants.OutputTiff);
        }
    }
}
