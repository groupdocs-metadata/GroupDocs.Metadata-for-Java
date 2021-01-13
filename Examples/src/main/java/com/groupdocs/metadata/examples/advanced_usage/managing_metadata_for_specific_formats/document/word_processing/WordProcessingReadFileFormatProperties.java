// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to detect the exact type of a loaded document and extract some additional file format information.
 */
public class WordProcessingReadFileFormatProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDoc)) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getWordProcessingType().getFileFormat());
            System.out.println(root.getWordProcessingType().getWordProcessingFormat());
            System.out.println(root.getWordProcessingType().getMimeType());
            System.out.println(root.getWordProcessingType().getExtension());
        }
    }
}
