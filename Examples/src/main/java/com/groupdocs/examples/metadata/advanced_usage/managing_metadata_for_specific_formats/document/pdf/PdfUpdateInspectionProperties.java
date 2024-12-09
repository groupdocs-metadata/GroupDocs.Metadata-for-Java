// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.pdf;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample demonstrates how to remove the inspection properties in a PDF document.
 */
public class PdfUpdateInspectionProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("PdfUpdateInspectionProperties.pdf");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PdfRootPackage root = metadata.getRootPackageGeneric();
            root.getInspectionPackage().clearAnnotations();
            root.getInspectionPackage().clearAttachments();
            root.getInspectionPackage().clearFields();
            root.getInspectionPackage().clearBookmarks();
            root.getInspectionPackage().clearDigitalSignatures();

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
