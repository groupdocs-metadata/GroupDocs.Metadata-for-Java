// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.image.jpeg;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet demonstrates how to detect barcodes in a JPEG image.
 */
public class JpegDetectBarcodes {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.JpegWithBarcodes)) {
            JpegRootPackage root = metadata.getRootPackageGeneric();

            String[] barcodeTypes = root.detectBarcodeTypes();

            for (String barcodeType : barcodeTypes) {
                System.out.println(barcodeType);
            }
        }
    }
}
