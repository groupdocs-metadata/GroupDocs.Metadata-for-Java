// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.saving_files;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.examples.Constants;

import java.io.*;

/**
 * This example shows how to save a document to the specified stream.
 */
public class SaveFileToSpecifiedStream {
    public static void run() throws IOException {
        try (OutputStream stream = new FileOutputStream(Constants.OutputPng)) {
            // Constants.InputPng is an absolute or relative path to your document. Ex: @"C:\Docs\test.png"
            try (Metadata metadata = new Metadata(Constants.InputPng)) {
                // Edit or remove metadata here

                metadata.save(stream);
            }
        }
    }
}
