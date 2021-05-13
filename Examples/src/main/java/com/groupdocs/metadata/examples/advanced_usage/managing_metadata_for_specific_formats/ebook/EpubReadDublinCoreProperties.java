// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EpubRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to extract Dublin Core metadata from an EPUB file.
 */
public class EpubReadDublinCoreProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputEpub)) {
            EpubRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDublinCorePackage().getRights());
            System.out.println(root.getDublinCorePackage().getPublisher());
            System.out.println(root.getDublinCorePackage().getTitle());
            System.out.println(root.getDublinCorePackage().getCreator());
            System.out.println(root.getDublinCorePackage().getLanguage());
            System.out.println(root.getDublinCorePackage().getDate());

            // ...
        }
    }
}
