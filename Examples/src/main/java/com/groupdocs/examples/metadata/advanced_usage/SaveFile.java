package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class provides methods to save files with metadata modifications to different destinations.
 */
public class SaveFile {

    /**
     * Saves the input file to its original source location after modifying its metadata.
     *
     * @param inputFile The path to the input file. Can be an absolute or relative path.
     * @return The path to the output file where the modified metadata is saved.
     */
    public static Path toOriginalSource(Path inputFile) {
        System.out.println("Running sample: SaveFile toOriginalSource..");
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\test.jpg"
        final Path outputPath = makeOutputPath("SaveFile-toOriginalSource.pptx");
        try {
            Files.copy(inputFile, outputPath);
            try (Metadata metadata = new Metadata(outputPath.toString())) {
                // Edit or remove metadata here
                metadata.save();

                System.out.println("..sample finished successfully.\n");
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    /**
     * Saves the input file to a specified location after modifying its metadata.
     *
     * @param inputFile The path to the input file. Can be an absolute or relative path.
     * @return The path to the output file where the modified metadata is saved.
     */
    public static Path toSpecifiedLocation(Path inputFile) {
        System.out.println("Running sample: SaveFile toSpecifiedLocation..");
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\test.jpg"
        final Path outputPath = makeOutputPath("SaveFile-toSpecifiedLocation.jpg");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            // Edit or remove metadata here

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }

    /**
     * Saves the input file to a specified stream after modifying its metadata.
     *
     * @param inputFile The path to the input file. Can be an absolute or relative path.
     * @return The path to the output file where the modified metadata is saved.
     */
    public static Path toSpecifiedStream(Path inputFile) {
        System.out.println("Running sample: SaveFile toSpecifiedStream..");
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\test.jpg"
        final Path outputPath = makeOutputPath("SaveFile-toSpecifiedStream.png");
        try (Metadata metadata = new Metadata(inputFile.toString())) {

            try (OutputStream stream = Files.newOutputStream(outputPath)) {
                // Edit or remove metadata here
                metadata.save(stream);
            }
            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
