// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to copy metadata properties to another file.
 */
public class CopyToMetadata {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # CopyToMetadata : How to copy metadata properties to another file.\n");
        try (Metadata sourceMetadata = new Metadata(Constants.InputPdf);
             Metadata destinationMetadata = new Metadata(Constants.CopyPdf)) {
            PdfRootPackage sourceRoot = sourceMetadata.getRootPackageGeneric();
            System.out.println("\nBefore copy:");
            System.out.println("\nSource package:");
            System.out.println(sourceRoot.getDocumentProperties().getAuthor());
            System.out.println(sourceRoot.getDocumentProperties().getCreatedDate());
            System.out.println(sourceRoot.getDocumentProperties().getProducer());

            PdfRootPackage destinationRoot = destinationMetadata.getRootPackageGeneric();
            System.out.println("\nDestination package:");
            System.out.println(destinationRoot.getDocumentProperties().getAuthor());
            System.out.println(destinationRoot.getDocumentProperties().getCreatedDate());
            System.out.println(destinationRoot.getDocumentProperties().getProducer());

            sourceMetadata.copyTo(destinationRoot);

            System.out.println("\n\nAfter copy:");
            System.out.println("\nDestination package:");
            System.out.println(destinationRoot.getDocumentProperties().getAuthor());
            System.out.println(destinationRoot.getDocumentProperties().getCreatedDate());
            System.out.println(destinationRoot.getDocumentProperties().getProducer());

            // Call destinationMetadata.save(...) to persist the copied properties
        }
    }
}
