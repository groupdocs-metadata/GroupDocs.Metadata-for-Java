// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ZipRootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class provides a method to update the user comment in a ZIP archive.
 */
public class ZipUpdateArchiveComment {
    /**
     * Executes the process of updating the comment in the specified ZIP archive.
     *
     * @param inputFile The path to the input file from which metadata will be read and updated.
     * @return The path to the output file where the updated metadata is saved.
     */
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("ZipUpdateArchiveComment.docx");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            ZipRootPackage root = metadata.getRootPackageGeneric();
            // Update the comment of the ZIP package to "updated comment"
            root.getZipPackage().setComment("updated comment");
            // Save the modified metadata back to the output path
            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
