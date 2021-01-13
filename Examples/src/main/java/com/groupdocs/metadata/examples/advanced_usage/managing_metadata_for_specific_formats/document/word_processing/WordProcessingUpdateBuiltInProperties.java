// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import com.groupdocs.metadata.examples.Constants;

import java.util.Date;

/**
 * This code sample shows how to update built-in metadata properties in a WordProcessing document.
 */
public class WordProcessingUpdateBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDoc)) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().setAuthor("test author");
            root.getDocumentProperties().setCreatedTime(new Date());
            root.getDocumentProperties().setCompany("GroupDocs");
            root.getDocumentProperties().setCategory("test category");
            root.getDocumentProperties().setKeywords("metadata, built-in, update");

            // ...

            metadata.save(Constants.OutputDoc);
        }
    }
}
