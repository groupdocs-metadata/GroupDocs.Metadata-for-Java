// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>
package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.RootMetadataPackage;
import com.groupdocs.metadata.export.ExportFormat;
import com.groupdocs.metadata.export.ExportManager;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This class demonstrates how to export metadata properties from a file to an Excel workbook,
 * XML document, and CSV file.
 */
public class ExportMetadataProperties {
    /**
     * Exports metadata properties from the specified input file to various formats (Excel, XML, CSV).
     *
     * @param inputFile The path to the input file from which to extract metadata.
     * @return A list of paths to the output files containing the exported metadata.
     */
    public static List<Path> run(Path inputFile) {
        System.out.println("Running sample: ExportMetadataProperties..");
        final List<Path> outputPaths = new ArrayList<>();
        final Path outputXlsPath = makeOutputPath("ExportMetadataProperties.xls");
        final Path outputXmlPath = makeOutputPath("ExportMetadataProperties.xml");
        final Path outputCsvPath = makeOutputPath("ExportMetadataProperties.csv");

        try (Metadata metadata = new Metadata(inputFile.toString())) {
            RootMetadataPackage rootMetadataPackage = metadata.getRootPackage();
            if (rootMetadataPackage != null) {
                ExportManager manager = new ExportManager(rootMetadataPackage);
                manager.export(outputXlsPath.toString(), ExportFormat.Xls);

                manager.export(outputXmlPath.toString(), ExportFormat.Xml);

                manager.export(outputCsvPath.toString(), ExportFormat.Csv);

                outputPaths.add(outputXlsPath);
                outputPaths.add(outputXmlPath);
                outputPaths.add(outputCsvPath);
                System.out.println("..sample finished successfully.\n");
            }

        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPaths;
    }
}
