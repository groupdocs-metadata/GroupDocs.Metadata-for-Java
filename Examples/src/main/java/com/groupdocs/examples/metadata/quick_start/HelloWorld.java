package com.groupdocs.examples.metadata.quick_start;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.search.FallsIntoCategorySpecification;
import com.groupdocs.metadata.tagging.Tags;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class demonstrates a basic usage of the GroupDocs.Editor API
 * to edit a word processing document by modifying its HTML content.
 */
public class HelloWorld {

    /**
     * Runs the editing process for a given input file path and returns the output file path.
     *
     * @param inputFile The path to the input document file.
     * @return The path to the edited document file.
     */
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("HelloWorld.docx");

        try {
            // Initialize a Metadata instance with the provided input file.
            try (final Metadata metadata = new Metadata(inputFile.toString())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {

                    // Fetch all metadata properties that fall into a particular category
                    IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new FallsIntoCategorySpecification(Tags.getContent()));
                    System.out.println("\tThe metadata properties describing some characteristics of the file content: title, keywords, language, etc.");
                    for (MetadataProperty property : properties) {
                        System.out.printf("\tProperty name: %s, Property value: %s%n", property.getName(), property.getValue());
                    }
                }
            }
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }

        return outputPath;
    }
}