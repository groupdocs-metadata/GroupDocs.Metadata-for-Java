// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PresentationRootPackage;
import com.groupdocs.metadata.examples.Constants;

import java.util.Date;

/**
 * This example demonstrates how to update built-in metadata properties in a presentation.
 */
public class PresentationUpdateBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPptx)) {
            PresentationRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().setAuthor("test author");
            root.getDocumentProperties().setCreatedTime(new Date());
            root.getDocumentProperties().setCompany("GroupDocs");
            root.getDocumentProperties().setCategory("test category");
            root.getDocumentProperties().setKeywords("metadata, built-in, update");

            // ...

            metadata.save(Constants.OutputPptx);
        }
    }
}
