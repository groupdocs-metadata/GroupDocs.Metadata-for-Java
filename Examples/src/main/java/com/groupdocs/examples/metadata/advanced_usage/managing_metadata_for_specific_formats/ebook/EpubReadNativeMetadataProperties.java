// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EpubRootPackage;

import java.nio.file.Path;

/**
 * This code sample shows how to read EPUB format-specific metadata properties.
 */
public class EpubReadNativeMetadataProperties {
    public static EpubRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            EpubRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tVersion: %s%n", root.getEpubPackage().getVersion());
            System.out.printf("\tUnique Identifier: %s%n", root.getEpubPackage().getUniqueIdentifier());
            System.out.printf("\tImage Cover Length: %d%n", root.getEpubPackage().getImageCover() != null ? root.getEpubPackage().getImageCover().length : 0);

            // ...

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
