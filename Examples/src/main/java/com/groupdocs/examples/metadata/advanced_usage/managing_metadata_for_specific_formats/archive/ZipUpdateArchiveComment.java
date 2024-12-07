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
 * The following code snippet shows how to update the user comment in a ZIP archive.
 */
public class ZipUpdateArchiveComment {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("ZipUpdateArchiveComment.docx");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            ZipRootPackage root = metadata.getRootPackageGeneric();
            root.getZipPackage().setComment("updated comment");
            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
