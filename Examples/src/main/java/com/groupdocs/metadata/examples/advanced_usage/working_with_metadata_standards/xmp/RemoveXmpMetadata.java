// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.xmp;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IXmp;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to remove XMP metadata from a file.
 */
public class RemoveXmpMetadata {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.JpegWithXmp)) {
            IXmp root = (IXmp) metadata.getRootPackage();

            root.setXmpPackage(null);
            metadata.save(Constants.OutputJpeg);
        }
    }
}
