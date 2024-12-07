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
    public static IReadOnlyList<MetadataProperty> byTag(Path inputFile) {
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

    public static IReadOnlyList<MetadataProperty> byTagGroup(Path inputFile) {
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
