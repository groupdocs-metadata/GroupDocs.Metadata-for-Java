// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ExifPackage;
import com.groupdocs.metadata.core.IExif;
import com.groupdocs.metadata.core.TiffAsciiTag;
import com.groupdocs.metadata.core.TiffTagID;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to add a custom tag to an EXIF package.
 */
public class SetCustomExifTag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.TiffWithExif)) {
            IExif root = (IExif) metadata.getRootPackage();

            // Set the EXIF package if it's missing
            if (root.getExifPackage() == null) {
                root.setExifPackage(new ExifPackage());
            }

            // Add a known property
            root.getExifPackage().set(new TiffAsciiTag(TiffTagID.Artist, "test artist"));

            // Add a fully custom property (which is not described in the EXIF specification).
            // Please note that the chosen ID may intersect with the IDs used by some third party tools.
            root.getExifPackage().set(new TiffAsciiTag(TiffTagID.getByRawValue(65523), "custom"));

            metadata.save(Constants.OutputTiff);
        }
    }
}
