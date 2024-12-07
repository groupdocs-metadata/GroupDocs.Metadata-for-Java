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

public class LoadFile {
    public static void fromLocalDisk(Path inputFile) {
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\source.one"
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            System.out.printf("\tMetadata loaded successfully: %s%n", metadata);
            // Extract, edit or remove metadata here
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        System.out.println("..sample finished successfully.");
    }

    public static void fromStream(Path inputFile) {
        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\source.doc"
        try (InputStream stream = Files.newInputStream(inputFile)) {
            try (Metadata metadata = new Metadata(stream)) {
                System.out.printf("\tMetadata loaded successfully: %s%n", metadata);
                // Extract, edit or remove metadata here
            }
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
    }

    public static SpreadsheetRootPackage fileOfSpecificFormat(Path inputFile, FileFormat fileFormat) {
        // Explicitly specifying the format of a file to load you can spare some time on detecting the format
        LoadOptions loadOptions = new LoadOptions(fileFormat);

        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\source.xls"
        try (Metadata metadata = new Metadata(inputFile.toString(), loadOptions)) {
            SpreadsheetRootPackage root = metadata.getRootPackageGeneric();

            // Use format-specific properties to extract or edit metadata

            System.out.printf("\tAuthor: %s%n", root.getDocumentProperties().getAuthor());

            // ...
            System.out.println("..sample finished successfully.");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }

    public static void protectedByPassword(Path inputFile, String password) {
        // Specify the password
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword(password);

        // inputFile is an absolute or relative path to your document. Ex: @"C:\Docs\source.docx"
        try (Metadata metadata = new Metadata(inputFile.toString(), loadOptions)) {
            System.out.printf("\tMetadata loaded successfully: %s%n", metadata);

            // Extract, edit or remove metadata here

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
    }
}
