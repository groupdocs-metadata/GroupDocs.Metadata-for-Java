// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PropertyDescriptor;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.tagging.PropertyTag;

/**
 * This code snippet demonstrates how to extract information about known properties that can be encountered in a particular package.
 */
public class GettingKnownPropertyDescriptors {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDoc)) {
            WordProcessingRootPackage root = metadata.getRootPackageGeneric();
            for (PropertyDescriptor descriptor : root.getDocumentProperties().getKnowPropertyDescriptors()) {
                System.out.println(descriptor.getName());
                System.out.println(descriptor.getType());
                System.out.println(descriptor.getAccessLevel());

                for (PropertyTag tag : descriptor.getTags()) {
                    System.out.println(tag);
                }

                System.out.println();
            }
        }
    }
}
