// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code snippet demonstrates how to update built-in metadata properties in a PDF document.
 */
public class PdfUpdateBuiltInProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("PdfUpdateBuiltInProperties.pdf");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PdfRootPackage root = metadata.getRootPackageGeneric();
            root.getDocumentProperties().setAuthor("test author");
            root.getDocumentProperties().setCreatedDate(new Date());
            root.getDocumentProperties().setTitle("test title");
            root.getDocumentProperties().setKeywords("metadata, built-in, update");

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
