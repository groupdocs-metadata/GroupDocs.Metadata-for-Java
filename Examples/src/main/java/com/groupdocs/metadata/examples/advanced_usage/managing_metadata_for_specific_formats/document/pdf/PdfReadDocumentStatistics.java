// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to obtain the text statistics for a PDF document.
 */
public class PdfReadDocumentStatistics {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPdf)) {
            PdfRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDocumentStatistics().getCharacterCount());
            System.out.println(root.getDocumentStatistics().getPageCount());
            System.out.println(root.getDocumentStatistics().getWordCount());
        }
    }
}
