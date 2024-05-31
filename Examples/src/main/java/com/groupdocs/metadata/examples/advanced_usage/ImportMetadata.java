package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.PdfRootPackage;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.imports.ImportFormat;
import com.groupdocs.metadata.imports.ImportManager;
import com.groupdocs.metadata.imports.JsonImportOptions;

/**
* This example demonstrates how to import metadata properties from json.
*/
public class ImportMetadata
{
    public static void run()
    {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # ImportMetadata : How to import metadata from json.\n");
        System.out.println("Before import:\n");
        Metadata metadata = new Metadata(Constants.InputPdf);
        {
            PdfRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getDocumentProperties().getAuthor());
            System.out.println(root.getDocumentProperties().getCreatedDate());
            System.out.println(root.getDocumentProperties().getProducer());

            ImportManager manager = new ImportManager(root);
            manager.import_(Constants.ImportPdf, ImportFormat.Json, new JsonImportOptions());
            metadata.save(Constants.OutputPdf);
        }
        System.out.println("\nAfter import:\n");
        Metadata metadata1 = new Metadata(Constants.OutputPdf);
        {
            PdfRootPackage root = metadata1.getRootPackageGeneric();

            System.out.println(root.getDocumentProperties().getAuthor());
            System.out.println(root.getDocumentProperties().getCreatedDate());
            System.out.println(root.getDocumentProperties().getProducer());
        }
    }
}
