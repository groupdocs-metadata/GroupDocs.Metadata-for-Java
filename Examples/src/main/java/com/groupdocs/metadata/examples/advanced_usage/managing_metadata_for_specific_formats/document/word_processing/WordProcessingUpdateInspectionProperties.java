// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to update inspection properties in a WordProcessing document.
 */
public class WordProcessingUpdateInspectionProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDoc)) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();

            root.getInspectionPackage().clearComments();
            root.getInspectionPackage().acceptAllRevisions();
            root.getInspectionPackage().clearFields();
            root.getInspectionPackage().clearHiddenText();

            metadata.save(Constants.OutputDoc);
        }
    }
}
