// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PresentationRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to extract built-in metadata properties from a presentation.
 */
public class PresentationReadBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPpt)) {
            PresentationRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDocumentProperties().getAuthor());
            System.out.println(root.getDocumentProperties().getCreatedTime());
            System.out.println(root.getDocumentProperties().getCompany());
            System.out.println(root.getDocumentProperties().getCategory());
            System.out.println(root.getDocumentProperties().getKeywords());
            System.out.println(root.getDocumentProperties().getLastPrintedDate());
            System.out.println(root.getDocumentProperties().getNameOfApplication());

            // ...
        }
    }
}
