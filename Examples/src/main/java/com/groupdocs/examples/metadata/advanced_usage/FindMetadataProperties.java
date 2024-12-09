// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.search.FallsIntoCategorySpecification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.Path;

/**
 * This example demonstrates how to search for specific metadata properties using tags.
 */
public class FindMetadataProperties {
    /**
     * Retrieves metadata properties that contain the name of the last document editor or the date/time the document was last modified.
     *
     * @param inputFile The path to the input file from which to retrieve metadata properties.
     * @return A list of metadata properties that match the specified criteria.
     */
    public static IReadOnlyList<MetadataProperty> byTag(Path inputFile) {
        System.out.println("Running sample: FindMetadataProperties byTag..");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            // Fetch all the properties satisfying the predicate:
            // property contains the name of the last document editor OR the date/time the document was last modified
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(
                    new ContainsTagSpecification(Tags.getPerson().getEditor()).or(new ContainsTagSpecification(Tags.getTime().getModified())));
            for (MetadataProperty property : properties) {
                System.out.printf("\tProperty name: %s, Property value: %s%n", property.getName(), property.getValue());
            }
            return properties;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }

    /**
     * Retrieves metadata properties that fall into the person category.
     *
     * @param inputFile The path to the input file from which to retrieve metadata properties.
     * @return A list of metadata properties that match the specified criteria.
     */
    public static IReadOnlyList<MetadataProperty> byTagGroup(Path inputFile) {
        System.out.println("Running sample: FindMetadataProperties byTagGroup..");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new FallsIntoCategorySpecification(Tags.getPerson()));
            for (MetadataProperty property : properties) {
                System.out.printf("\tProperty name: %s, Property value: %s%n", property.getName(), property.getValue());
            }
            return properties;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
