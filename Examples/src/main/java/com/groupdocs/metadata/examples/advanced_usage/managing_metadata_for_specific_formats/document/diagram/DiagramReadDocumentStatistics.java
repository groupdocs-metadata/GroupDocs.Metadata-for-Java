// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DiagramRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The following code sample demonstrates how to obtain the text statistics for a diagram.
 */
public class DiagramReadDocumentStatistics {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputVdx)) {
            DiagramRootPackage root = metadata.getRootPackageGeneric();
            System.out.println(root.getDocumentStatistics().getPageCount());
        }
    }
}
