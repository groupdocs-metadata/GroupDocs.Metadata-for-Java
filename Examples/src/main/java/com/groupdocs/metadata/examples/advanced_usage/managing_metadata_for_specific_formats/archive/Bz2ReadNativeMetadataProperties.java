// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.Bz2Package;
import com.groupdocs.metadata.core.Bz2RootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The following code snippet shows how to get metadata from a BZ2 archive.
 */
public class Bz2ReadNativeMetadataProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # Bz2ReadNativeMetadataProperties : How to get metadata from a BZ2 archive.\n");
        try (Metadata metadata = new Metadata(Constants.InputBz2)) {
            Bz2RootPackage root = metadata.getRootPackageGeneric();
            Bz2Package archive = root.getBz2Package();

            System.out.println(archive.getTotalEntries());
            System.out.println(archive.getName());
            System.out.println(archive.getSize());
        }
    }
}
