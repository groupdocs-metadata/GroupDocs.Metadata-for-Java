// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IExif;
import com.groupdocs.metadata.core.TiffAsciiTag;
import com.groupdocs.metadata.core.TiffTagID;
import com.groupdocs.metadata.core.TiffUndefinedTag;

import java.nio.file.Path;

/**
 * This example demonstrates how to read a specific TIFF/EXIF tag by its identifier.
 */
public class ReadSpecificExifTag {
    public static IExif run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IExif root = (IExif) metadata.getRootPackage();
            if (root.getExifPackage() != null) {
                TiffAsciiTag software = (TiffAsciiTag) root.getExifPackage().getByTiffTagID(TiffTagID.Software);
                if (software != null) {
                    System.out.printf("\tSoftware: %s%n", software.getValue());
                }
                TiffUndefinedTag comment = (TiffUndefinedTag) root.getExifPackage().getExifIfdPackage().getByTiffTagID(TiffTagID.UserComment);
                if (comment != null) {
                    System.out.printf("\tComment: %s%n", comment.getInterpretedValue());
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
