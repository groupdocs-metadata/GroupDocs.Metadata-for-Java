// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.loading_files;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.examples.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * This example demonstrates how to load a file from a stream.
 */
public class LoadFromStream {
    public static void run() throws IOException {
        // Constants.InputDoc is an absolute or relative path to your document. Ex: @"C:\Docs\source.doc"
        try (InputStream stream = new FileInputStream(Constants.InputDoc)) {
            try (Metadata metadata = new Metadata(stream)) {
                // Extract, edit or remove metadata here
            }
        }
    }
}
