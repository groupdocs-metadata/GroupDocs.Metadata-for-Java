// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PresentationRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to add or update custom metadata properties in a presentation.
 */
public class PresentationUpdateCustomProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPpt)) {
            PresentationRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().set("customProperty1", "some value");
            root.getDocumentProperties().set("customProperty2", 123.1);

            metadata.save(Constants.OutputPpt);
        }
    }
}
