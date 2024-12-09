// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;

import java.nio.file.Path;

/**
 * This example demonstrates how to extract Dublin Core metadata from a WordProcessing document.
 */
public class WordProcessingReadDublinCoreProperties {
    public static WordProcessingRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();
            if (root.getDublinCorePackage() != null) {
                System.out.printf("\tFormat: %s%n", root.getDublinCorePackage().getFormat());
                System.out.printf("\tContributor: %s%n", root.getDublinCorePackage().getContributor());
                System.out.printf("\tCoverage: %s%n", root.getDublinCorePackage().getCoverage());
                System.out.printf("\tCreator: %s%n", root.getDublinCorePackage().getCreator());
                System.out.printf("\tSource: %s%n", root.getDublinCorePackage().getSource());
                System.out.printf("\tDescription: %s%n", root.getDublinCorePackage().getDescription());
            } else {
                System.out.println("\tDublin Core Package not found.");
            }
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
