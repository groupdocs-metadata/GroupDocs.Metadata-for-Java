// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ExifPackage;
import com.groupdocs.metadata.core.IExif;
import com.groupdocs.metadata.core.TiffAsciiTag;
import com.groupdocs.metadata.core.TiffTagID;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample demonstrates how to add a custom tag to an EXIF package.
 */
public class SetCustomExifTag {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("outputTiff");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IExif root = (IExif) metadata.getRootPackage();
            // Set the EXIF package if it's missing
            if (root.getExifPackage() == null) {
                root.setExifPackage(new ExifPackage());
            }
            // Add a known property
            root.getExifPackage().set(new TiffAsciiTag(TiffTagID.Artist, "test artist"));
            // Add a fully custom property (which is not described in the EXIF specification).
            // Please note that the chosen ID may intersect with the IDs used by some third party tools.
            root.getExifPackage().set(new TiffAsciiTag(TiffTagID.getByRawValue(65523), "custom"));

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
