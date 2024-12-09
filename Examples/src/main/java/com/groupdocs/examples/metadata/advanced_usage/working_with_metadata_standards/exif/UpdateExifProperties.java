// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ExifPackage;
import com.groupdocs.metadata.core.IExif;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample demonstrates how to update common EXIF properties.
 */
public class UpdateExifProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("UpdateExifProperties.jpg");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IExif root = (IExif) metadata.getRootPackage();
            // Set the EXIF package if it's missing
            if (root.getExifPackage() == null) {
                root.setExifPackage(new ExifPackage());
            }
            root.getExifPackage().setCopyright("Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.");
            root.getExifPackage().setImageDescription("test image");
            root.getExifPackage().setSoftware("GroupDocs.Metadata");
            // ...
            root.getExifPackage().getExifIfdPackage().setBodySerialNumber("test");
            root.getExifPackage().getExifIfdPackage().setCameraOwnerName("GroupDocs");
            root.getExifPackage().getExifIfdPackage().setUserComment("test comment");
            // ...

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
