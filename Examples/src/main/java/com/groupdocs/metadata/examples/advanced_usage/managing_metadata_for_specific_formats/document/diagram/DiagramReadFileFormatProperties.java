// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DiagramRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to detect the exact type of a loaded diagram and extract some additional file format information.
 */
public class DiagramReadFileFormatProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputVdx)) {
            DiagramRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDiagramType().getFileFormat());
            System.out.println(root.getDiagramType().getDiagramFormat());
            System.out.println(root.getDiagramType().getMimeType());
            System.out.println(root.getDiagramType().getExtension());
        }
    }
}
