// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PresentationRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to clean inspection properties in a presentation.
 */
public class PresentationUpdateInspectionProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputPpt)) {
            PresentationRootPackage root = metadata.getRootPackageGeneric();

            root.getInspectionPackage().clearComments();
            root.getInspectionPackage().clearHiddenSlides();

            metadata.save(Constants.OutputPpt);
        }
    }
}
