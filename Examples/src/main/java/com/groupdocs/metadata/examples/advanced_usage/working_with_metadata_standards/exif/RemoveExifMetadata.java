// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IExif;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to remove EXIF metadata from a file.
 */
public class RemoveExifMetadata {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.JpegWithExif)) {
            IExif root = (IExif) metadata.getRootPackage();
            root.setExifPackage(null);

            metadata.save(Constants.OutputJpeg);
        }
    }
}
