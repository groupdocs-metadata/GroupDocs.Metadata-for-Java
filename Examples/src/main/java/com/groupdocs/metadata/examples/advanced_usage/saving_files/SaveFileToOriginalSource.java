// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.saving_files;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.examples.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * This example shows how to save the modified content to the underlying source.
 */
public class SaveFileToOriginalSource {
    public static void run() throws IOException {
        // Constants.InputPpt is an absolute or relative path to your document. Ex: @"C:\Docs\test.ppt"
        File outputFile = new File(Constants.OutputPpt);
        outputFile.delete();
        Files.copy(new File(Constants.InputPpt).toPath(), outputFile.toPath());

        try (Metadata metadata = new Metadata(Constants.OutputPpt)) {
            // Edit or remove metadata here

            // Saves the document to the underlying file
            metadata.save();
        }
    }
}
