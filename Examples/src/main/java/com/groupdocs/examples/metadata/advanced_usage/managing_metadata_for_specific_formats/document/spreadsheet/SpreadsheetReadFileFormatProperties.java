// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.spreadsheet;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;

import java.nio.file.Path;

/**
 * This example shows how to detect the exact type of a loaded spreadsheet and extract some additional file format information.
 */
public class SpreadsheetReadFileFormatProperties {
    public static SpreadsheetRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tFile Format: %s%n", root.getSpreadsheetType().getFileFormat());
            System.out.printf("\tSpreadsheet Format: %s%n", root.getSpreadsheetType().getSpreadsheetFormat());
            System.out.printf("\tMIME Type: %s%n", root.getSpreadsheetType().getMimeType());
            System.out.printf("\tExtension: %s%n", root.getSpreadsheetType().getExtension());
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
