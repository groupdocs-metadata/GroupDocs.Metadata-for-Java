// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to check whether a document conforms to a PDF/A standard.
 */
public class PdfDetectPdfA {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # PdfDetectPdfA : How to check whether a document conforms to a PDF/A standard.\n");
        try (Metadata metadata = new Metadata(Constants.InputPdfA)) {
            PdfRootPackage root = metadata.getRootPackageGeneric();

            if (root.getPdfType().isPdfA()) {
                System.out.println(String.format("PDF/A version: %s", root.getPdfType().getPdfFormat()));
            } else {
                System.out.println("The document is not PDF/A compliant.");
            }
        }
    }
}
