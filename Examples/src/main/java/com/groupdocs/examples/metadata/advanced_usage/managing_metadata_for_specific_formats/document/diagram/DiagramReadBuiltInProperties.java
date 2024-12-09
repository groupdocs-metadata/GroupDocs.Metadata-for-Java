// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DiagramRootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample demonstrates how to extract built-in metadata properties from a diagram.
 */
public class DiagramReadBuiltInProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("DiagramReadBuiltInProperties.vsdx");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            DiagramRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tCreator: %s%n", root.getDocumentProperties().getCreator());
            System.out.printf("\tCompany: %s%n", root.getDocumentProperties().getCompany());
            System.out.printf("\tKeywords: %s%n", root.getDocumentProperties().getKeywords());
            System.out.printf("\tLanguage: %s%n", root.getDocumentProperties().getLanguage());
            System.out.printf("\tTime Created: %s%n", root.getDocumentProperties().getTimeCreated());
            System.out.printf("\tCategory: %s%n", root.getDocumentProperties().getCategory());

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
