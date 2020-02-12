// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EpubRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to read EPUB format-specific metadata properties.
 */
public class EpubReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputEpub)) {
            EpubRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getEpubPackage().getVersion());
            System.out.println(root.getEpubPackage().getUniqueIdentifier());
            System.out.println(root.getEpubPackage().getImageCover() != null ? root.getEpubPackage().getImageCover().length : 0);
        }
    }
}
