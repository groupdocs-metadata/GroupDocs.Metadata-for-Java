// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.cad;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.CadRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to read metadata of a CAD drawing.
 */
public class CadReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDxf)) {
            CadRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getCadPackage().getAcadVersion());
            System.out.println(root.getCadPackage().getAuthor());
            System.out.println(root.getCadPackage().getComments());
            System.out.println(root.getCadPackage().getCreatedDateTime());
            System.out.println(root.getCadPackage().getHyperlinkBase());
            System.out.println(root.getCadPackage().getKeywords());
            System.out.println(root.getCadPackage().getLastSavedBy());
            System.out.println(root.getCadPackage().getTitle());

            // ...
        }
    }
}
