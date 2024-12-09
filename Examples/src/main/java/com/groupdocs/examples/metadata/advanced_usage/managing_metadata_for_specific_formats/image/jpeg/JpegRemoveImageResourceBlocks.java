// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.JpegRootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code snippet demonstrates how to remove Photoshop metadata from a JPEG image.
 */
public class JpegRemoveImageResourceBlocks {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("JpegRemoveImageResourceBlocks.jpg");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            JpegRootPackage root = metadata.getRootPackageGeneric();
            root.removeImageResourcePackage();

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
