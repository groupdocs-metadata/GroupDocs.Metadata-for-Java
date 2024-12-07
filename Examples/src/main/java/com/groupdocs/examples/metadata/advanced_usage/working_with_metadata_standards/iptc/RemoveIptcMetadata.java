// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IIptc;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample shows how to remove IPTC metadata from a file.
 */
public class RemoveIptcMetadata {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("OutputJpegWithNoIptc");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IIptc root = (IIptc) metadata.getRootPackage();
            root.setIptcPackage(null);
            metadata.save(outputPath.toString());
            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
