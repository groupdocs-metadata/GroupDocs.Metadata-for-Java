// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EpubRootPackage;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.WithNameSpecification;
import com.groupdocs.metadata.core.PropertyValue;
import java.util.Date;

/**
 * This example shows how to update Dublin Core metadata in an EPUB file.
 */
public class EpubUpdateDublinCoreProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputEpub)) {
            EpubRootPackage root = metadata.getRootPackageGeneric();

            root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:creator"), new PropertyValue("GroupDocs"));
            root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:description"), new PropertyValue("test e-book"));
            root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:title"), new PropertyValue("test EPUB"));
            root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:date"), new PropertyValue(new Date().toString()));
 
            // ...
 
            metadata.save(Constants.OutputEpub);
        }
    }
}
