// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * This example demonstrates how to set metadata properties by various criteria regardless of the file format.
 */
public class SettingMetadata {
    public static void run() {
        File folder = new File(Constants.InputPath);
        for (File file : folder.listFiles()) {
            try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
                    System.out.println();
                    System.out.println(file.getName());

                    // This operation is a combination of the AddProperties and UpdateProperties methods.
                    // If an existing property satisfies the predicate its value is updated.
                    // If there is a known property missing in the package that satisfies the predicate it is added to the package.

                    // Set the copyright notice
                    int affected = metadata.setProperties(new ContainsTagSpecification(Tags.getLegal().getCopyright()),
                            new PropertyValue("Copyright (C) 2011-2020 GroupDocs. All Rights Reserved."));

                    System.out.println(String.format("Affected properties: %s", affected));

                    metadata.save(Constants.OutputPath + "output." + FilenameUtils.getExtension(file.getName()));
                }
            }
        }
    }
}
