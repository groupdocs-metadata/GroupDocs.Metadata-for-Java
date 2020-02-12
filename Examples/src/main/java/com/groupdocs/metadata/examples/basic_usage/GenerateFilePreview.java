// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.basic_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.options.ICreatePageStream;
import com.groupdocs.metadata.options.PreviewOptions;

import java.io.*;

/**
 * This code snippet demonstrates how to create image previews for document pages.
 */
public class GenerateFilePreview {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            PreviewOptions previewOptions = new PreviewOptions(new GenerateFilePreview().new CreatePageStream());
            previewOptions.setPreviewFormat(PreviewOptions.PreviewFormats.PNG);
            previewOptions.setPageNumbers(new int[]{1});
            metadata.generatePreview(previewOptions);
        }
    }

    private class CreatePageStream implements ICreatePageStream {
        @Override
        public OutputStream createPageStream(int pageNumber) {
            File file = new File(String.format("%s\\result_%s.png", Constants.OutputPath, pageNumber));
            OutputStream stream = null;
            try {
                stream = new FileOutputStream(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return stream;
        }
    }
}
