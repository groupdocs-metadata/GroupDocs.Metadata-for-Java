// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.xmp;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IXmp;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample shows how to remove XMP metadata from a file.
 */
public class RemoveXmpMetadata {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("JpegWithoutXmp.jpg");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IXmp root = (IXmp) metadata.getRootPackage();
            root.setXmpPackage(null);

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
