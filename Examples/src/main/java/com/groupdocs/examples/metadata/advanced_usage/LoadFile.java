package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import com.groupdocs.metadata.options.LoadOptions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class provides methods for loading metadata from files located on the local disk, from input streams,
 * and from files with specific formats. It also includes a method to handle password-protected files.
 */
public class LoadFile {
    /**
     * Loads metadata from a file located on the local disk.
     *
     * @param inputFile The path to the document from which metadata will be loaded.
     */
    public static void fromLocalDisk(Path inputFile) {
        System.out.println("Running sample: LoadFile fromLocalDisk..");
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\source.one"
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            System.out.printf("\tMetadata loaded successfully: %s%n", metadata);
            // Extract, edit or remove metadata here
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        System.out.println("..sample finished successfully.\n");
    }

    /**
     * Loads metadata from a file using an input stream.
     *
     * @param inputFile The path to the document from which metadata will be loaded.
     */
    public static void fromStream(Path inputFile) {
        System.out.println("Running sample: LoadFile fromStream..");
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\source.doc"
        try (InputStream stream = Files.newInputStream(inputFile)) {
            try (Metadata metadata = new Metadata(stream)) {
                System.out.printf("\tMetadata loaded successfully: %s%n", metadata);
                // Extract, edit or remove metadata here
            }
            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
    }

    /**
     * Loads metadata from a file of a specific format.
     *
     * @param inputFile The path to the document from which metadata will be loaded.
     * @param fileFormat The format of the document.
     * @return A SpreadsheetRootPackage object representing the root package of the spreadsheet metadata.
     */
    public static SpreadsheetRootPackage fileOfSpecificFormat(Path inputFile, FileFormat fileFormat) {
        System.out.println("Running sample: LoadFile fileOfSpecificFormat..");
        // Explicitly specifying the format of a file to load you can spare some time on detecting the format
        LoadOptions loadOptions = new LoadOptions(fileFormat);

        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\source.xls"
        try (Metadata metadata = new Metadata(inputFile.toString(), loadOptions)) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

            // Use format-specific properties to extract or edit metadata

            System.out.printf("\tAuthor: %s%n", root.getDocumentProperties().getAuthor());

            // ...
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }

    /**
     * Loads metadata from a password-protected file.
     *
     * @param inputFile The path to the document from which metadata will be loaded.
     * @param password The password required to access the document.
     */
    public static void protectedByPassword(Path inputFile, String password) {
        System.out.println("Running sample: LoadFile protectedByPassword..");
        // Specify the password
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);

        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\source.docx"
        try (Metadata metadata = new Metadata(inputFile.toString(), loadOptions)) {
            System.out.printf("\tMetadata loaded successfully: %s%n", metadata);

            // Extract, edit or remove metadata here

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
    }
}
