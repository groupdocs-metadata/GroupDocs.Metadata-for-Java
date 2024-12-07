// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IExif;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample shows how to remove EXIF metadata from a file.
 */
public class RemoveExifMetadata {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("outputJpeg");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IExif root = (IExif) metadata.getRootPackage();
            root.setExifPackage(null);

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
