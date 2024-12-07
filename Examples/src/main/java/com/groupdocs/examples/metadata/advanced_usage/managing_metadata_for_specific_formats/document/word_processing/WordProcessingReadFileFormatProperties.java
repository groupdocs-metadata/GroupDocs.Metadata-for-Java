// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;

import java.nio.file.Path;

/**
 * This example shows how to detect the exact type of a loaded document and extract some additional file format information.
 */
public class WordProcessingReadFileFormatProperties {
    public static WordProcessingRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tFile Format: %s%n", root.getWordProcessingType().getFileFormat());
            System.out.printf("\tWord Processing Format: %s%n", root.getWordProcessingType().getWordProcessingFormat());
            System.out.printf("\tMime Type: %s%n", root.getWordProcessingType().getMimeType());
            System.out.printf("\tExtension: %s%n", root.getWordProcessingType().getExtension());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
