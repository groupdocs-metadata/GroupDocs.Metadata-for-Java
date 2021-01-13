// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to extract built-in metadata properties from a PDF document.
 */
public class PdfReadBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPdf)) {
            PdfRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDocumentProperties().getAuthor());
            System.out.println(root.getDocumentProperties().getCreatedDate());
            System.out.println(root.getDocumentProperties().getSubject());
            System.out.println(root.getDocumentProperties().getProducer());
            System.out.println(root.getDocumentProperties().getKeywords());

            // ...
        }
    }
}
