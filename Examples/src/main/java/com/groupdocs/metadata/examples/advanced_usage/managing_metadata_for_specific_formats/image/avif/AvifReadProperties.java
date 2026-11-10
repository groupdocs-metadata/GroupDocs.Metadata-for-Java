// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.avif;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.AvifRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to read EXIF and XMP properties of an AVIF image.
 */
public class AvifReadProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # AvifReadProperties : How to read properties of an AVIF file.\n");
        try (Metadata metadata = new Metadata(Constants.InputAvif)) {
            AvifRootPackage root = metadata.getRootPackageGeneric();

            if (root.getXmpPackage() != null && root.getXmpPackage().getSchemes().getXmpDynamicMedia() != null) {
                System.out.println(String.format("XmpDynamicMedia Artist: %s", root.getXmpPackage().getSchemes().getXmpDynamicMedia().getArtist()));
            }
            if (root.getExifPackage() != null) {
                System.out.println(String.format("ExifPackage Artist: %s", root.getExifPackage().getArtist()));
            }
        }
    }
}
