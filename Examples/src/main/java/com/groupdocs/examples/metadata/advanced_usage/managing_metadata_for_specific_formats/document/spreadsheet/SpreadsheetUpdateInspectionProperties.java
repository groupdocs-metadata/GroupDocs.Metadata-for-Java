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
 * This code sample shows hot to remove inspection properties from a spreadsheet.
 */
public class SpreadsheetUpdateInspectionProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("UpdatedSpreadsheetMetadata.xlsx");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();
            root.getInspectionPackage().clearComments();
            root.getInspectionPackage().clearDigitalSignatures();
            root.getInspectionPackage().clearHiddenSheets();

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
