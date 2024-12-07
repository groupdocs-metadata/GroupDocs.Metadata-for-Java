// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.diagram;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.DiagramRootPackage;

import java.nio.file.Path;

/**
 * The following code sample demonstrates how to obtain the text statistics for a diagram.
 */
public class DiagramReadDocumentStatistics {
    public static DiagramRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            DiagramRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tPage count: %d%n", root.getDocumentStatistics().getPageCount());

            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
