// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates hot to read built-in metadata properties of a WordProcessing document.
 */
public class WordProcessingReadBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDocumentProperties().getAuthor());
            System.out.println(root.getDocumentProperties().getCreatedTime());
            System.out.println(root.getDocumentProperties().getCompany());
            System.out.println(root.getDocumentProperties().getCategory());
            System.out.println(root.getDocumentProperties().getKeywords());

            // ...
        }
    }
}
