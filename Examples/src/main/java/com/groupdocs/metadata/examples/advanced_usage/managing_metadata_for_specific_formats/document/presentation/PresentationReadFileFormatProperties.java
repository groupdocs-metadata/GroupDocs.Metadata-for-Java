// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PresentationRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to detect the exact type of a presentation and extract some additional file format information.
 */
public class PresentationReadFileFormatProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPptx)) {
            PresentationRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getPresentationType().getFileFormat());
            System.out.println(root.getPresentationType().getPresentationFormat());
            System.out.println(root.getPresentationType().getMimeType());
            System.out.println(root.getPresentationType().getExtension());
        }
    }
}
