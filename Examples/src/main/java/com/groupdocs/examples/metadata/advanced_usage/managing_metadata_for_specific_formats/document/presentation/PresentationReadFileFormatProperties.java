// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PresentationRootPackage;

import java.nio.file.Path;

/**
 * This example demonstrates how to detect the exact type of presentation and extract some additional file format information.
 */
public class PresentationReadFileFormatProperties {
    public static PresentationRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            PresentationRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tFile Format: %s%n", root.getPresentationType().getFileFormat());
            System.out.printf("\tPresentation Format: %s%n", root.getPresentationType().getPresentationFormat());
            System.out.printf("\tMimeType: %s%n", root.getPresentationType().getMimeType());
            System.out.printf("\tExtension: %s%n", root.getPresentationType().getExtension());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
