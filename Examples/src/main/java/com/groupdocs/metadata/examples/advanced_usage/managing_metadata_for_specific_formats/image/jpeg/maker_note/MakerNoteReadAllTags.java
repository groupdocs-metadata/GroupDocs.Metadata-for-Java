// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.core.TiffTag;
import com.groupdocs.metadata.examples.Constants;


/**
 * This code sample shows how to extract all detected MakerNote properties in the form of TIFF/EXIF tags.
 */
public class MakerNoteReadAllTags {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.CanonJpeg)) {
            JpegRootPackage root = metadata.getRootPackageGeneric();
            if (root.getMakerNotePackage() != null) {
                for (TiffTag tag : root.getMakerNotePackage().toList()) {

                    // Please note that tag ids used by camera manufacturers may intersect with the ids defined in the TIFF/EXIF specification
                    System.out.println(String.format("%s = %s", (int) tag.getTagID(), tag.getValue()));
                }
            }
        }
    }
}