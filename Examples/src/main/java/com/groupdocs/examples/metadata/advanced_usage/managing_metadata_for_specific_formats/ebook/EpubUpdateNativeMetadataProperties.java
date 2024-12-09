// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.ebook;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EpubRootPackage;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample shows how to update EPUB format-specific metadata properties.
 */
public class EpubUpdateNativeMetadataProperties {
    public static EpubRootPackage run(Path inputFile) {
        final Path outputPath = makeOutputPath("EpubUpdateNativeMetadataProperties.epub");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            EpubRootPackage root = metadata.getRootPackageGeneric();
            root.getEpubPackage().setCreator("GroupDocs");
            root.getEpubPackage().setDescription("test e-book");
            root.getEpubPackage().setFormat("EPUB");
            root.getEpubPackage().setDate(new Date().toString());

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
