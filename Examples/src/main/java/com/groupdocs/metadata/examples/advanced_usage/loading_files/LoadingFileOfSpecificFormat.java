// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.loading_files;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.options.LoadOptions;

/**
 * This example demonstrates how to load a file of some particular format.
 */
public class LoadingFileOfSpecificFormat {
    public static void run() {
        // Explicitly specifying the format of a file to load you can spare some time on detecting the format
        LoadOptions loadOptions = new LoadOptions(FileFormat.Spreadsheet);

        // Constants.InputXls is an absolute or relative path to your document. Ex: @"C:\Docs\source.xls"
        try (Metadata metadata = new Metadata(Constants.InputXls, loadOptions)) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

            // Use format-specific properties to extract or edit metadata

            System.out.println(root.getDocumentProperties().getAuthor());

            // ...
        }
    }
}
