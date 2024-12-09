// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.IDocumentInfo;

import java.nio.file.Path;

/**
 * This class demonstrates how to extract basic format information from a file.
 */
public class GetDocumentInfo {

    /**
     * Extracts basic document information such as file format, extension, MIME type,
     * number of pages, document size, and encryption status from the specified file.
     *
     * @param inputFile The path to the input file.
     * @return An IDocumentInfo object containing the extracted document information.
     */
    public static IDocumentInfo run(Path inputFile) {
        System.out.println("Running sample: GetDocumentInfo..");
        try {
            try (Metadata metadata = new Metadata(inputFile.toString())) {
                if (metadata.getFileFormat() != FileFormat.Unknown) {
                    IDocumentInfo info = metadata.getDocumentInfo();
                    System.out.printf("\tFile format: %s%n", info.getFileType().getFileFormat());
                    System.out.printf("\tFile extension: %s%n", info.getFileType().getExtension());
                    System.out.printf("\tMIME Type: %s%n", info.getFileType().getMimeType());
                    System.out.printf("\tNumber of pages: %s%n", info.getPageCount());
                    System.out.printf("\tDocument size: %s bytes%n", info.getSize());
                    System.out.printf("\tIs document encrypted: %s%n", info.isEncrypted());

                    System.out.println("..sample finished successfully.\n");
                    return info;
                }
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
