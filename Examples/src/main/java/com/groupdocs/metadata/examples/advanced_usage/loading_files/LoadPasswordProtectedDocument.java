// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.loading_files;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.options.LoadOptions;


/**
 * This example demonstrates how to load a password-protected document.
 */
public class LoadPasswordProtectedDocument {
    public static void run() {
        // Specify the password
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("123");

        // Constants.ProtectedDocx is an absolute or relative path to your document. Ex: @"C:\Docs\source.docx"
        try (Metadata metadata = new Metadata(Constants.ProtectedDocx, loadOptions)) {
            // Extract, edit or remove metadata here
        }
    }
}
