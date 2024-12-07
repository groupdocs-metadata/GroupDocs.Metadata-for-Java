// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MetadataPackage;
import com.groupdocs.metadata.core.MetadataProperty;

import java.nio.file.Path;

/**
 * This example demonstrates how to traverse the whole metadata tree for a specific file regardless of the format.
 */
public class TraverseWholeMetadataTree {
    public static void run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            displayMetadataTree(metadata.getRootPackage(), 0);
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
    }

    private static void displayMetadataTree(MetadataPackage metadata, int indent) {
        if (metadata != null) {
            String stringMetadataType = String.valueOf(metadata.getMetadataType());
            System.out.printf("%" + (stringMetadataType.length() + indent) + "s%n", stringMetadataType);
            for (MetadataProperty property : metadata) {
                String stringPropertyRepresentation = String.format("Name: %s, Value: %s", property.getName(), property.getValue());
                System.out.printf("%" + (stringPropertyRepresentation.length() + indent + 1) + "s%n", stringPropertyRepresentation);
                if (property.getValue() != null) {
                    switch (property.getValue().getType()) {
                        case Metadata:
                            displayMetadataTree(property.getValue().toClass(MetadataPackage.class), indent + 2);
                            break;
                        case MetadataArray:
                            displayMetadataTree(property.getValue().toArray(MetadataPackage.class), indent + 2);
                            break;
                    }
                }
            }
        }
    }

    private static void displayMetadataTree(MetadataPackage[] metadataArray, int indent) {
        if (metadataArray != null) {
            for (MetadataPackage metadata : metadataArray) {
                displayMetadataTree(metadata, indent);
            }
        }
    }
}
