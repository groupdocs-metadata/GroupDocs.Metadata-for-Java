// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code snippet demonstrates how to update custom metadata properties in a spreadsheet.
 */
public class SpreadsheetUpdateCustomProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("SpreadsheetUpdateCustomProperties.xlsx");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();
            root.getDocumentProperties().set("customProperty1", "some value");
            root.getDocumentProperties().set("customProperty2", 7);
            // Set a content type property
            root.getDocumentProperties().getContentTypeProperties().set("customContentTypeProperty", "custom value");

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
