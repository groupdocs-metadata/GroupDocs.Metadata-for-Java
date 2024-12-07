package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.imports.ImportFormat;
import com.groupdocs.metadata.imports.ImportManager;
import com.groupdocs.metadata.imports.JsonImportOptions;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to import metadata properties from json.
 */
public class ImportMetadata {
    public static Path run(Path inputFile, Path importFile) {
        // How to import metadata from json.
        final Path outputPath = makeOutputPath("ImportMetadata.pdf");

        try {
            try (Metadata metadata = new Metadata(inputFile.toString())) {
                PdfRootPackage beforeImportRoot = metadata.getRootPackageGeneric();
                System.out.println("\tBefore import:");
                System.out.printf("\t\tAuthor: %s, ", beforeImportRoot.getDocumentProperties().getAuthor());
                System.out.printf("created date: %s, ", beforeImportRoot.getDocumentProperties().getCreatedDate());
                System.out.printf("producer: %s%n", beforeImportRoot.getDocumentProperties().getProducer());

                ImportManager manager = new ImportManager(beforeImportRoot);
                manager.import_(importFile.toString(), ImportFormat.Json, new JsonImportOptions());
                metadata.save(outputPath.toString());
            }
            System.out.println("\tAfter import:");
            try (Metadata metadata1 = new Metadata(outputPath.toString())) {
                PdfRootPackage afterImportRoot = metadata1.getRootPackageGeneric();
                System.out.printf("\t\tAuthor: %s, ", afterImportRoot.getDocumentProperties().getAuthor());
                System.out.printf("created date: %s, ", afterImportRoot.getDocumentProperties().getCreatedDate());
                System.out.printf("producer: %s%n", afterImportRoot.getDocumentProperties().getProducer());
            }
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
