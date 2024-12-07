// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PropertyDescriptor;
import com.groupdocs.metadata.core.WordProcessingPackage;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import com.groupdocs.metadata.tagging.PropertyTag;

import java.nio.file.Path;

/**
 * This code snippet demonstrates how to extract information about known properties that can be encountered in a particular package.
 */
public class GetKnownPropertyDescriptors {
    public static WordProcessingPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();
            final WordProcessingPackage documentProperties = root.getDocumentProperties();

            for (PropertyDescriptor descriptor : documentProperties.getKnowPropertyDescriptors()) {
                System.out.printf("\tProperty Name: %s, Property Type: %s, Property Access Level: %s%n", descriptor.getName(), descriptor.getType(), descriptor.getAccessLevel().name());
                System.out.print("\t\tTags: ");
                for (PropertyTag tag : descriptor.getTags()) {
                    System.out.printf("%s, ", tag);
                }
                System.out.println();
            }
            return documentProperties;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
