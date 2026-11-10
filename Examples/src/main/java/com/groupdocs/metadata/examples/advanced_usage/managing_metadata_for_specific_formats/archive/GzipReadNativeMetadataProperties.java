// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.GzipPackage;
import com.groupdocs.metadata.core.GzipRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The following code snippet shows how to get metadata from a GZIP archive.
 */
public class GzipReadNativeMetadataProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # GzipReadNativeMetadataProperties : How to get metadata from a GZIP archive.\n");
        try (Metadata metadata = new Metadata(Constants.InputGzip)) {
            GzipRootPackage root = metadata.getRootPackageGeneric();
            GzipPackage archive = root.getGzipPackage();

            System.out.println(archive.getTotalEntries());
            System.out.println(archive.getName());
            System.out.println(archive.getUncompressedSize());
            System.out.println(archive.getSize());
        }
    }
}
