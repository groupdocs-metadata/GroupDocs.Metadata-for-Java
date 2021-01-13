// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.basic_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.IDocumentInfo;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to extract basic format information from a file.
 */
public class GetDocumentInfo {
    public static void run() {
        // Constants.InputXlsx is an absolute or relative path to your document. Ex: @"C:\Docs\source.xlsx"
        try (Metadata metadata = new Metadata(Constants.InputXlsx)) {
            if (metadata.getFileFormat() != FileFormat.Unknown) {
                IDocumentInfo info = metadata.getDocumentInfo();
                System.out.println(String.format("File format: %s", info.getFileType().getFileFormat()));
                System.out.println(String.format("File extension: %s", info.getFileType().getExtension()));
                System.out.println(String.format("MIME Type: %s", info.getFileType().getMimeType()));
                System.out.println(String.format("Number of pages: %s", info.getPageCount()));
                System.out.println(String.format("Document size: %s bytes", info.getSize()));
                System.out.println(String.format("Is document encrypted: %s", info.isEncrypted()));
            }
        }
    }
}
