// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class demonstrates how to set specific metadata properties using different criteria.
 */
public class SetMetadataProperties {

    /**
     * Sets the value of metadata properties that match certain conditions.
     *
     * @param inputFile The path to the input file for which metadata will be modified.
     * @return The path to the output file where the modified metadata is saved.
     */
    public static Path run(Path inputFile) {
        System.out.println("Running sample: SetMetadataProperties..");
        final Path outputPath = makeOutputPath("SetMetadataProperties.docx");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            // Set the value of each property that satisfies the predicate:
            // property contains the date/time the document was created OR modified
            int affected = metadata.setProperties(
                    new ContainsTagSpecification(Tags.getTime().getCreated())
                            .or(new ContainsTagSpecification(Tags.getTime().getModified())),
                    new PropertyValue(new Date()));
            System.out.printf("\tProperties set: %s%n", affected);

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
