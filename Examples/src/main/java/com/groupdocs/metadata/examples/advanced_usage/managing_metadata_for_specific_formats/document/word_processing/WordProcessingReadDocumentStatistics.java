// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to obtain simple text statistics for a WordProcessing document.
 */
public class WordProcessingReadDocumentStatistics {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDocumentStatistics().getCharacterCount());
            System.out.println(root.getDocumentStatistics().getPageCount());
            System.out.println(root.getDocumentStatistics().getWordCount());
        }
    }
}
