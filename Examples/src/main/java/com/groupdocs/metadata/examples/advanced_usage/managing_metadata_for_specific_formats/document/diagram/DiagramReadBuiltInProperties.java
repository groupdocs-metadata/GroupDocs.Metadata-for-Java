// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DiagramRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to extract built-in metadata properties from a diagram.
 */
public class DiagramReadBuiltInProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputVsdx)) {
            DiagramRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDocumentProperties().getCreator());
            System.out.println(root.getDocumentProperties().getCompany());
            System.out.println(root.getDocumentProperties().getKeywords());
            System.out.println(root.getDocumentProperties().getLanguage());
            System.out.println(root.getDocumentProperties().getTimeCreated());
            System.out.println(root.getDocumentProperties().getCategory());

            // ...
        }
    }
}
