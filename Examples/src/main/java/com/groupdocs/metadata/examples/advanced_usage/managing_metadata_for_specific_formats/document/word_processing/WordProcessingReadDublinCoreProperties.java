// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to extract Dublin Core metadata from a WordProcessing document.
 */
public class WordProcessingReadDublinCoreProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();

            if (root.getDublinCorePackage() != null) {
                System.out.println(root.getDublinCorePackage().getFormat());
                System.out.println(root.getDublinCorePackage().getContributor());
                System.out.println(root.getDublinCorePackage().getCoverage());
                System.out.println(root.getDublinCorePackage().getCreator());
                System.out.println(root.getDublinCorePackage().getSource());
                System.out.println(root.getDublinCorePackage().getDescription());

                // ...
            }
        }
    }
}
