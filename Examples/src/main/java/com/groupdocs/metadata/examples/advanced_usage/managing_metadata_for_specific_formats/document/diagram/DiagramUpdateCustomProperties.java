// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DiagramRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The following code sample demonstrates how to update custom metadata properties in a diagram document.
 */
public class DiagramUpdateCustomProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputVsdx)) {
            DiagramRootPackage root = metadata.getRootPackageGeneric();

            root.getDocumentProperties().set("customProperty1", "some value");
            root.getDocumentProperties().set("customProperty2", true);

            metadata.save(Constants.OutputVsdx);
        }
    }
}
