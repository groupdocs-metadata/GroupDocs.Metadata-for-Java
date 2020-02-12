// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ExifPackage;
import com.groupdocs.metadata.core.IExif;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to update common EXIF properties.
 */
public class UpdateExifProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputJpeg)) {
            IExif root = (IExif) metadata.getRootPackage();

            // Set the EXIF package if it's missing
            if (root.getExifPackage() == null) {
                root.setExifPackage(new ExifPackage());
            }

            root.getExifPackage().setCopyright("Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.");
            root.getExifPackage().setImageDescription("test image");
            root.getExifPackage().setSoftware("GroupDocs.Metadata");

            // ...

            root.getExifPackage().getExifIfdPackage().setBodySerialNumber("test");
            root.getExifPackage().getExifIfdPackage().setCameraOwnerName("GroupDocs");
            root.getExifPackage().getExifIfdPackage().setUserComment("test comment");

            // ...

            metadata.save(Constants.OutputJpeg);
        }
    }
}
