// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.psd;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PsdRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to extract basic EXIF metadata properties from a PSD image.
 */
public class PsdReadBasicExifProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.PsdWithExif)) {
            PsdRootPackage root = metadata.getRootPackageGeneric();
            if (root.getExifPackage() != null) {
                System.out.println(root.getExifPackage().getArtist());
                System.out.println(root.getExifPackage().getCopyright());
                System.out.println(root.getExifPackage().getImageDescription());
                System.out.println(root.getExifPackage().getMake());
                System.out.println(root.getExifPackage().getModel());
                System.out.println(root.getExifPackage().getSoftware());
                System.out.println(root.getExifPackage().getImageWidth());
                System.out.println(root.getExifPackage().getImageLength());

                // ...

                System.out.println(root.getExifPackage().getExifIfdPackage().getBodySerialNumber());
                System.out.println(root.getExifPackage().getExifIfdPackage().getCameraOwnerName());
                System.out.println(root.getExifPackage().getExifIfdPackage().getUserComment());

                // ...

                System.out.println(root.getExifPackage().getGpsPackage().getAltitude());
                System.out.println(root.getExifPackage().getGpsPackage().getLatitudeRef());
                System.out.println(root.getExifPackage().getGpsPackage().getLongitudeRef());

                // ...
            }
        }
    }
}
