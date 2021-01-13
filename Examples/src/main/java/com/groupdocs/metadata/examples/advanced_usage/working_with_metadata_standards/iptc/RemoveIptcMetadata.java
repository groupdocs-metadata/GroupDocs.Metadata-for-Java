// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IIptc;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to remove IPTC metadata from a file.
 */
public class RemoveIptcMetadata {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.JpegWithIptc)) {
            IIptc root = (IIptc) metadata.getRootPackage();
            root.setIptcPackage(null);

            metadata.save(Constants.OutputJpeg);
        }
    }
}
