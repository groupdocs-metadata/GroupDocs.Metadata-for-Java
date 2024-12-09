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
 * This class provides a method to remove the user comment from a ZIP archive.
 */
public class ZipRemoveArchiveComment {
    /**
     * Executes the process of removing the comment from the specified ZIP archive.
     *
     * @param inputZip The path to the input ZIP archive whose comment needs to be removed.
     * @return The path to the output ZIP archive with the comment cleared.
     */
    public static Path run(Path inputZip) {
        final Path outputPath = makeOutputPath("ZipRemoveArchiveComment.zip");
        try (Metadata metadata = new Metadata(inputZip.toString())) {
            ZipRootPackage root = metadata.getRootPackageGeneric();
            // Set the comment of the ZIP package to null to remove it
            root.getZipPackage().setComment(null);
            // Save the modified metadata back to the output path
            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
