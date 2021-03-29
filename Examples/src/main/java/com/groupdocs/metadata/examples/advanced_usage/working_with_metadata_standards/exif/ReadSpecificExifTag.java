// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IExif;
import com.groupdocs.metadata.core.TiffAsciiTag;
import com.groupdocs.metadata.core.TiffTagID;
import com.groupdocs.metadata.core.TiffUndefinedTag;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example demonstrates how to read a specific TIFF/EXIF tag by its identifier.
 */
public class ReadSpecificExifTag {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.TiffWithExif)) {
            IExif root = (IExif) metadata.getRootPackage();
            if (root.getExifPackage() != null) {
                TiffAsciiTag software = (TiffAsciiTag) root.getExifPackage().getByTiffTagID(TiffTagID.Software);
                if (software != null) {
                    System.out.println(String.format("Software: %s", software.getValue()));
                }
                
                TiffUndefinedTag comment = (TiffUndefinedTag)root.getExifPackage().getExifIfdPackage().getByTiffTagID(TiffTagID.UserComment);
                if (comment != null) {
                    System.out.println(String.format("Comment: %s", comment.getInterpretedValue()));
                }
            }
        }
    }
}
