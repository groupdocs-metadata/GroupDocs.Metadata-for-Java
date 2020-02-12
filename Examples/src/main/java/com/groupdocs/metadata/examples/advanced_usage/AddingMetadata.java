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
import java.util.Date;

/**
 * This example demonstrates how to add some missing metadata properties to a file regardless of its format.
 */
public class AddingMetadata {
    public static void run() {
        File folder = new File(Constants.InputPath);
        for (File file : folder.listFiles()) {
            try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
                    System.out.println();
                    System.out.println(file.getName());

                    // Add a property containing the file last printing date if it's missing
                    // Note that the property will be added to metadata packages that satisfy the following criteria:
                    // 1) Only existing metadata packages will be affected. No new packages are added during this operation
                    // 2) There should be a known metadata property in the package structure that fits the search condition but is actually missing in the package.
                    // All properties supported by a certain package are usually defined in the specification of a particular metadata standard
                    int affected = metadata.addProperties(new ContainsTagSpecification(Tags.getTime().getPrinted()), new PropertyValue(new Date()));

                    System.out.println(String.format("Affected properties: %s", affected));

                    metadata.save(Constants.OutputPath + "output." + FilenameUtils.getExtension(file.getName()));
                }
            }
        }
    }
}
