// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MetadataPropertyType;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.search.OfTypeSpecification;
import com.groupdocs.metadata.search.Specification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class demonstrates how to remove specific metadata properties from a file using various criteria.
 */
public class RemoveMetadataProperties {

    /**
     * Removes metadata properties from the specified input file that match certain conditions.
     *
     * @param inputFile The path to the file from which metadata properties will be removed.
     * @return The path to the output file where the modified metadata is saved.
     */
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("RemoveMetadataProperties.docx");

        try (Metadata metadata = new Metadata(inputFile.toString())) {
            // Remove all the properties satisfying the predicate:
            // property contains the name of the document author OR
            // it refers to the last editor OR
            // the property value is a string that is equal to the given string "John" (to remove any mentions of John from the detected metadata)
            int affected = metadata.removeProperties(
                    new ContainsTagSpecification(Tags.getPerson().getCreator())
                            .or(new ContainsTagSpecification(Tags.getPerson().getEditor()))
                            .or(new OfTypeSpecification(MetadataPropertyType.String).and(new WithValueSpecification("John"))));
            System.out.printf("\tProperties removed: %s%n", affected);
            metadata.save(outputPath.toString());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    // Define your own specifications to filter metadata properties
    static class WithValueSpecification extends Specification {
        private Object _value;

        public WithValueSpecification(Object value) {
            setValue(value);
        }

        public final Object getValue() {
            return _value;
        }

        private void setValue(Object value) {
            _value = value;
        }

        public boolean isSatisfiedBy(MetadataProperty candidate) {
            return candidate.getValue().getRawValue().equals(getValue());
        }
    }
}
