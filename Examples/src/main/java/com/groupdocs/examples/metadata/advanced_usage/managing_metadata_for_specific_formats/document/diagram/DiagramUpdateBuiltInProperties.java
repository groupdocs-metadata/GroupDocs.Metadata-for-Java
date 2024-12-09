// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DiagramRootPackage;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * The following code sample demonstrates how to update built-in metadata properties in a diagram document.
 */
public class DiagramUpdateBuiltInProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("DiagramUpdateBuiltInProperties.vdx");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            DiagramRootPackage root = metadata.getRootPackageGeneric();
            root.getDocumentProperties().setCreator("test author");
            root.getDocumentProperties().setTimeCreated(new Date());
            root.getDocumentProperties().setCompany("GroupDocs");
            root.getDocumentProperties().setCategory("test category");
            root.getDocumentProperties().setKeywords("metadata, built-in, update");

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
