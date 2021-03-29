// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.Specification;
import java.io.File;

/**
 * This example demonstrates how to use interpreted property values.
 */
public class WorkingWithInterpretedValues {
     public static void run() {
        File folder = new File(Constants.InputPath);
        for (File file : folder.listFiles()) {
            try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
                    System.out.println();
                    System.out.println(file.getName());
                    
                    IReadOnlyList<MetadataProperty> properties = metadata.findProperties(
                            new WorkingWithInterpretedValues().new InterpretedValueIsNotNullSpecification());
                    for (MetadataProperty property : properties) {
                            System.out.println(property.getName());
                            System.out.println(property.getValue().getRawValue());
                            System.out.println(property.getInterpretedValue().getRawValue());
                    }
                }
            }
        }
    }
     
    private class InterpretedValueIsNotNullSpecification extends Specification {
        public /*override*/ boolean isSatisfiedBy(MetadataProperty candidate) {
            return candidate.getInterpretedValue() != null;
        }
    }
}
