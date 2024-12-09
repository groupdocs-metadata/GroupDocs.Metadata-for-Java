// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;

import java.nio.file.Path;

/**
 * This code sample shows how to obtain simple text statistics for a WordProcessing document.
 */
public class WordProcessingReadDocumentStatistics {
    public static WordProcessingRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tCharacter Count: %s%n", root.getDocumentStatistics().getCharacterCount());
            System.out.printf("\tPage Count: %s%n", root.getDocumentStatistics().getPageCount());
            System.out.printf("\tWord Count: %s%n", root.getDocumentStatistics().getWordCount());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
