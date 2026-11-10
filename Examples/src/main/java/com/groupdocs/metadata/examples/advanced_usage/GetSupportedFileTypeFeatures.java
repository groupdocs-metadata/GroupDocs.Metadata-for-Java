// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.core.FeatureSupport;
import com.groupdocs.metadata.core.FileType;
import com.groupdocs.metadata.core.FileTypeFeatureSupport;
import java.util.Map;

/**
 * This example demonstrates how to find out which features (detection, reading, editing, removing) are supported for a file type.
 */
public class GetSupportedFileTypeFeatures {
    public static void run() {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # GetSupportedFileTypeFeatures : How to get the features supported for a file type.\n");
        // Get the support matrix for a specific file type
        FileTypeFeatureSupport pdf = FileTypeFeatureSupport.getSupportedFileTypeFeatures(FileType.PDF);
        printFeatures(pdf);

        // ... or look it up by file extension
        FileTypeFeatureSupport ogg = FileTypeFeatureSupport.getSupportedFileTypeFeatures(".ogg");
        printFeatures(ogg);

        // Get the whole matrix
        Map<FileType, FileTypeFeatureSupport> matrix = FileTypeFeatureSupport.getSupportedFileTypeFeatures();
        System.out.println(String.format("Total file types described: %d", matrix.size()));
    }

    private static void printFeatures(FileTypeFeatureSupport support) {
        System.out.println(String.format("%s (%s): %s", support.getExtension(), support.getFormatFamily(), support.getDescription()));
        for (FeatureSupport feature : support.getFeatures()) {
            System.out.println(String.format("    %s: %s", feature.getFeature(), feature.getLevel()));
        }
    }
}
