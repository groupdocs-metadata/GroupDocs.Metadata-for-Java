// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DiagramRootPackage;
import com.groupdocs.metadata.examples.Constants;

import java.util.Date;

/**
 * The following code sample demonstrates how to update built-in metadata properties in a diagram document.
 */
public class DiagramUpdateBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputVdx)) {
            DiagramRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().setCreator("test author");
            root.getDocumentProperties().setTimeCreated(new Date());
            root.getDocumentProperties().setCompany("GroupDocs");
            root.getDocumentProperties().setCategory("test category");
            root.getDocumentProperties().setKeywords("metadata, built-in, update");

            // ...

            metadata.save(Constants.OutputVdx);
        }
    }
}
