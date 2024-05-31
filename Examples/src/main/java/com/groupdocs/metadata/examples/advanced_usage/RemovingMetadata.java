// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.FallsIntoCategorySpecification;
import com.groupdocs.metadata.search.WithNameSpecification;
import com.groupdocs.metadata.tagging.Tags;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * This example demonstrates how to remove metadata properties by various criteria regardless of the file format.
 */
public class RemovingMetadata {
    public static void run() {
        File folder = new File(Constants.InputPath);
        for (File file : folder.listFiles((dir, name) -> !name.toLowerCase().endsWith(".json"))) {
            try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
                    System.out.println();
                    System.out.println(file.getName());

                    // Remove all mentions of any people contributed in file creation
                    // Remove a custom property with the specified name
                    int affected = metadata.removeProperties(new FallsIntoCategorySpecification(Tags.getPerson()).or(new WithNameSpecification("CustomProperty")));

                    System.out.println(String.format("Affected properties: %s", affected));

                    metadata.save(Constants.OutputPath + "output." + FilenameUtils.getExtension(file.getName()));
                }
            }
        }
    }
}
