// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.ZstdPackage;
import com.groupdocs.metadata.core.ZstdRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The following code snippet shows how to get metadata from a ZSTD archive.
 */
public class ZstdReadNativeMetadataProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # ZstdReadNativeMetadataProperties : How to get metadata from a ZSTD archive.\n");
        try (Metadata metadata = new Metadata(Constants.InputZstd)) {
            ZstdRootPackage root = metadata.getRootPackageGeneric();
            ZstdPackage archive = root.getZstdPackage();

            System.out.println(archive.getTotalEntries());
            System.out.println(archive.getName());
            System.out.println(archive.getSize());
        }
    }
}
