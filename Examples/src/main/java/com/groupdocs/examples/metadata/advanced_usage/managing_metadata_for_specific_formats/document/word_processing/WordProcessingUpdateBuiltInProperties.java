// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.WordProcessingRootPackage;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample shows how to update built-in metadata properties in a WordProcessing document.
 */
public class WordProcessingUpdateBuiltInProperties {
    public static WordProcessingRootPackage run(Path inputFile) {
        final Path outputPath = makeOutputPath("WordProcessingUpdateBuiltInProperties.doc");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();
            root.getDocumentProperties().setAuthor("test author");
            root.getDocumentProperties().setCreatedTime(new Date());
            root.getDocumentProperties().setCompany("GroupDocs");
            root.getDocumentProperties().setCategory("test category");
            root.getDocumentProperties().setKeywords("metadata, built-in, update");
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
