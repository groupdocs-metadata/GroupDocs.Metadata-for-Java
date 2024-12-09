// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IExif;
import com.groupdocs.metadata.core.TiffTag;

import java.nio.file.Path;

/**
 * This example demonstrates how to read all EXIF tags extracted from a file.
 */
public class ReadExifTags {
    public static IExif run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IExif root = (IExif) metadata.getRootPackage();
            if (root.getExifPackage() != null) {
                for (TiffTag tag : root.getExifPackage().toList()) {
                    System.out.printf("\tTag: %s = %s%n%n", tag.getTagID(), tag.getValue());
                }
                for (TiffTag tag : root.getExifPackage().getExifIfdPackage().toList()) {
                    System.out.printf("\tTag: %s = %s%n", tag.getTagID(), tag.getValue());
                }
                for (TiffTag tag : root.getExifPackage().getGpsPackage().toList()) {
                    System.out.printf("\tTag: %s = %s%n", tag.getTagID(), tag.getValue());
                }
            } else {
                System.out.println("\tExif data not found.");
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
