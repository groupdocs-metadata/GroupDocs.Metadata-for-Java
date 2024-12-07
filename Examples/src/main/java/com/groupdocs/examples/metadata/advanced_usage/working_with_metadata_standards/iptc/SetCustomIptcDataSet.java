// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This example shows how to add or update custom IPTC datasets in a file.
 */
public class SetCustomIptcDataSet {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("OutputPsdWithIptc");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IIptc root = (IIptc) metadata.getRootPackage();
            // Set the IPTC package if it's missing
            if (root.getIptcPackage() == null) {
                root.setIptcPackage(new IptcRecordSet());
            }
            // Add a know property using the DataSet API
            root.getIptcPackage().set(new IptcDataSet((byte) IptcRecordType.ApplicationRecord.getRawValue(),
                    (byte) IptcApplicationRecordDataSet.BylineTitle.getRawValue(), "test code sample"));
            // Add a custom IPTC DataSet
            root.getIptcPackage().set(new IptcDataSet((byte) 100, (byte) 100, new byte[]{1, 2, 3}));

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
