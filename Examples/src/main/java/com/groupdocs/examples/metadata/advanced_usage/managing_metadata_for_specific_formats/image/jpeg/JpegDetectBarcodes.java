// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;

import java.nio.file.Path;

/**
 * This code snippet demonstrates how to detect barcodes in a JPEG image.
 */
public class JpegDetectBarcodes {
    public static JpegRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            JpegRootPackage root = metadata.getRootPackageGeneric();
            String[] barcodeTypes = root.detectBarcodeTypes();
            System.out.println("\tDetected Barcode Types:\n");
            for (String barcodeType : barcodeTypes) {
                System.out.printf("\t\t%s%n", barcodeType);
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
