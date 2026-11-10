// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.XzPackage;
import com.groupdocs.metadata.core.XzRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The following code snippet shows how to get metadata from an XZ archive.
 */
public class XzReadNativeMetadataProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # XzReadNativeMetadataProperties : How to get metadata from an XZ archive.\n");
        try (Metadata metadata = new Metadata(Constants.InputXz)) {
            XzRootPackage root = metadata.getRootPackageGeneric();
            XzPackage archive = root.getXzPackage();

            System.out.println(archive.getTotalEntries());
            System.out.println(archive.getName());
            System.out.println(archive.getSize());
        }
    }
}
