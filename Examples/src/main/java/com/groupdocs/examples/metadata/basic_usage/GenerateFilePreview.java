// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.options.PreviewFormats;
import com.groupdocs.metadata.options.PreviewOptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code snippet demonstrates how to create image previews for document pages.
 */
public class GenerateFilePreview {
    public static List<Path> run(Path inputFile) {
        final List<Path> outputPaths = new ArrayList<>();
        try {
            try (Metadata metadata = new Metadata(inputFile.toString())) {
                PreviewOptions previewOptions = new PreviewOptions(pageNumber -> {
                    final Path outputPath = makeOutputPath(String.format("GenerateFilePreview-p%d.png", pageNumber));
                    try {
                        return Files.newOutputStream(outputPath);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

                previewOptions.setPreviewFormat(PreviewFormats.PNG);
                previewOptions.setPageNumbers(new int[]{1});

                metadata.generatePreview(previewOptions);
            }
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPaths;
    }
}
