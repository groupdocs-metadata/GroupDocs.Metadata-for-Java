// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.loading_files;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to load a file from a local disk.
 */
public class LoadFromLocalDisk {
    public static void run() {
        // Constants.InputOne is an absolute or relative path to your document. Ex: @"C:\Docs\source.one"
        try (Metadata metadata = new Metadata(Constants.InputOne)) {
            // Extract, edit or remove metadata here
        }
    }
}
