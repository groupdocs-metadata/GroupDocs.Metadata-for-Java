package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

public class CleanMetadata {
    public static Path run(Path sampleFile) {
        final Path outputPath = makeOutputPath("CleanMetadata.docx");

        try {
            try (Metadata metadata = new Metadata(sampleFile.toString())) {

                // Remove detected metadata packages
                int affected = metadata.sanitize();
                System.out.printf("\tProperties removed: %s%n", affected);

                metadata.save(outputPath.toString());
            }
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }

        return outputPath;
    }
}
