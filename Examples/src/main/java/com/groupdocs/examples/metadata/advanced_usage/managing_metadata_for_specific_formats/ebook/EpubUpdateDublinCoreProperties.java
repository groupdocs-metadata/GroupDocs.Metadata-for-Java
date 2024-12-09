// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EpubRootPackage;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.search.WithNameSpecification;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This example shows how to update Dublin Core metadata in an EPUB file.
 */
public class EpubUpdateDublinCoreProperties {
    public static EpubRootPackage run(Path inputFile) {
        final Path outputPath = makeOutputPath("EpubUpdateDublinCoreProperties.epub");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            EpubRootPackage root = metadata.getRootPackageGeneric();
            root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:creator"), new PropertyValue("GroupDocs"));
            root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:description"), new PropertyValue("test e-book"));
            root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:title"), new PropertyValue("test EPUB"));
            root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:date"), new PropertyValue(new Date().toString()));

            // ...

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
