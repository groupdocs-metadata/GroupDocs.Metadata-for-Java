// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EpubRootPackage;
import com.groupdocs.metadata.examples.Constants;
import java.util.Date;

/**
 * This code sample shows how to update EPUB format-specific metadata properties.
 */
public class EpubUpdateNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputEpub)) {
            EpubRootPackage root = metadata.getRootPackageGeneric();

            root.getEpubPackage().setCreator("GroupDocs");
            root.getEpubPackage().setDescription("test e-book");
            root.getEpubPackage().setFormat("EPUB");
            root.getEpubPackage().setDate(new Date().toString());
 
            // ...
 
            metadata.save(Constants.OutputEpub);
        }
    }
}
