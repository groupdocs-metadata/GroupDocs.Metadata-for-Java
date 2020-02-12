// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.saving_files;


import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to save a document to the specified location.
 */
public class SaveFileToSpecifiedLocation {
    public static void run() {
        // Constants.InputJpeg is an absolute or relative path to your document. Ex: @"C:\Docs\test.jpg"
        try (Metadata metadata = new Metadata(Constants.InputJpeg)) {
            // Edit or remove metadata here

            metadata.save(Constants.OutputJpeg);
        }
    }
}
