// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample demonstrates how to update document statistics for a WordProcessing document.
 */
public class WordProcessingUpdateDocumentStatistics {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDoc)) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();

            root.updateDocumentStatistics();

            metadata.save(Constants.OutputDoc);
        }
    }
}
