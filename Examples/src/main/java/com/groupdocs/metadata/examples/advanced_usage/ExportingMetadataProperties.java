// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.RootMetadataPackage;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.export.ExportFormat;
import com.groupdocs.metadata.export.ExportManager;

/**
 *
 * This example demonstrates how to export metadata properties to an Excel workbook.
 */
public class ExportingMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDoc))
        {
            RootMetadataPackage root = metadata.getRootPackage();
            if (root != null)
            {
                // Initialize the export manager with the root metadata package to export the whole metadata tree
                ExportManager manager = new ExportManager(root);

                manager.export(Constants.OutputXls, ExportFormat.Xls);
            }
        }
    }
}
