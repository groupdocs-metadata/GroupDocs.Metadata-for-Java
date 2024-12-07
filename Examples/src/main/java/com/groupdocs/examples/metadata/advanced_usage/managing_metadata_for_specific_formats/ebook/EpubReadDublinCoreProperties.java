// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EpubRootPackage;

import java.nio.file.Path;

/**
 * This example shows how to extract Dublin Core metadata from an EPUB file.
 */
public class EpubReadDublinCoreProperties {
    public static EpubRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            EpubRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tRights: %s%n", root.getDublinCorePackage().getRights());
            System.out.printf("\tPublisher: %s%n", root.getDublinCorePackage().getPublisher());
            System.out.printf("\tTitle: %s%n", root.getDublinCorePackage().getTitle());
            System.out.printf("\tCreator: %s%n", root.getDublinCorePackage().getCreator());
            System.out.printf("\tLanguage: %s%n", root.getDublinCorePackage().getLanguage());
            System.out.printf("\tDate: %s%n", root.getDublinCorePackage().getDate());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
