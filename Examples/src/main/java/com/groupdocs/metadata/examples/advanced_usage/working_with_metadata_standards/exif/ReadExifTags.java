// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IExif;
import com.groupdocs.metadata.core.TiffTag;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to read all EXIF tags extracted from a file.
 */
public class ReadExifTags {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.JpegWithExif)) {
            IExif root = (IExif) metadata.getRootPackage();
            if (root.getExifPackage() != null) {
                String pattern = "%s = %s";

                for (TiffTag tag : root.getExifPackage().toList()) {
                    System.out.println(String.format(pattern, tag.getTagID(), tag.getValue()));
                }

                for (TiffTag tag : root.getExifPackage().getExifIfdPackage().toList()) {
                    System.out.println(String.format(pattern, tag.getTagID(), tag.getValue()));
                }

                for (TiffTag tag : root.getExifPackage().getGpsPackage().toList()) {
                    System.out.println(String.format(pattern, tag.getTagID(), tag.getValue()));
                }
            }
        }
    }
}
