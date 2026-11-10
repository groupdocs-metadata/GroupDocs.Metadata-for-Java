// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.AarFile;
import com.groupdocs.metadata.core.AarPackage;
import com.groupdocs.metadata.core.AarRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * The following code snippet shows how to get metadata from an Apple Archive (.aar) file.
 */
public class AarReadNativeMetadataProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # AarReadNativeMetadataProperties : How to get metadata from an Apple Archive.\n");
        try (Metadata metadata = new Metadata(Constants.InputAar)) {
            AarRootPackage root = metadata.getRootPackageGeneric();
            AarPackage archive = root.getAarPackage();

            System.out.println(archive.getTotalEntries());
            System.out.println(archive.isSolid());

            for (AarFile file : archive.getFiles()) {
                System.out.println(file.getName());
                System.out.println(file.getLength());
                System.out.println(file.isDirectory());
            }
        }
    }
}
