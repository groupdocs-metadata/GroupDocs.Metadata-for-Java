package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class demonstrates how to clean metadata from a specified file.
 */
public class CleanMetadata {

    /**
     * Cleans metadata by removing detected metadata packages from the specified file.
     *
     * @param sampleFile The path to the file from which metadata will be removed.
     * @return The path to the output file where the cleaned content is saved.
     */
    public static Path run(Path sampleFile) {
        System.out.println("Running sample: CleanMetadata..");
        final Path outputPath = makeOutputPath("CleanMetadata.docx");

        try {
            try (Metadata metadata = new Metadata(sampleFile.toString())) {

                // Remove detected metadata packages
                int affected = metadata.sanitize();
                System.out.printf("\tProperties removed: %s%n", affected);

                metadata.save(outputPath.toString());
            }
            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }

        return outputPath;
    }
}
