package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

public class SaveFile {
    public static Path toOriginalSource(Path inputFile) {
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\test.jpg"
        final Path outputPath = makeOutputPath("Original_Source.pptx");
        try {
            Files.copy(inputFile, outputPath);
            try (Metadata metadata = new Metadata(outputPath.toString())) {
                // Edit or remove metadata here
                metadata.save();

                System.out.println("..sample finished successfully.");
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path toSpecifiedLocation(Path inputFile) {
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\test.jpg"
        final Path outputPath = makeOutputPath("specified_location.jpg");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            // Edit or remove metadata here

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    public static Path toSpecifiedStream(Path inputFile) {
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\test.jpg"
        final Path outputPath = makeOutputPath("specified_stream.png");
        try (Metadata metadata = new Metadata(inputFile.toString())) {

            try (OutputStream stream = Files.newOutputStream(outputPath)) {
                // Edit or remove metadata here
                metadata.save(stream);
            }
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
