// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.basic_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to remove all detected metadata packages/properties from a file.
 */
public class CleanMetadata {
    public static void run() {
        // Constants.InputPdf is an absolute or relative path to your document. Ex: @"C:\Docs\source.pdf"
        try (Metadata metadata = new Metadata(Constants.InputPdf)) {

            // Remove detected metadata packages
            int affected = metadata.sanitize();
            System.out.println(String.format("Properties removed: %s", affected));

            metadata.save(Constants.OutputPdf);
        }
    }
}
