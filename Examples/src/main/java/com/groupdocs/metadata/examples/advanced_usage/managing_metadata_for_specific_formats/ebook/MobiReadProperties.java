// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MobiRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to extract metadata from a MOBI file.
 */
public class MobiReadProperties {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # MobiReadProperties : How to extract metadata from a MOBI file.\n");
        try (Metadata metadata = new Metadata(Constants.InputMobi)) {
            MobiRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getMobiPackage().getPDBHeader().getName());
            System.out.println(root.getMobiPackage().getPDBHeader().getCreator());
            System.out.println(root.getMobiPackage().getMobiHeader().getFullName());
            System.out.println(root.getMobiPackage().getMobiHeader().getMobiType());

            // ...
        }
    }
}
