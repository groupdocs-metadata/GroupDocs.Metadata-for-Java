// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.iptc;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IIptc;
import com.groupdocs.metadata.core.IptcApplicationRecord;
import com.groupdocs.metadata.core.IptcEnvelopeRecord;
import com.groupdocs.metadata.core.IptcRecordSet;

import java.nio.file.Path;
import java.util.Date;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample shows hot to update basic IPTC metadata properties.
 */
public class UpdateIptcProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("UpdateIptcProperties.jpg");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            IIptc root = (IIptc) metadata.getRootPackage();
            // Set the IPTC package if it's missing
            if (root.getIptcPackage() == null) {
                root.setIptcPackage(new IptcRecordSet());
            }
            if (root.getIptcPackage().getEnvelopeRecord() == null) {
                root.getIptcPackage().setEnvelopeRecord(new IptcEnvelopeRecord());
            }
            root.getIptcPackage().getEnvelopeRecord().setDateSent(new Date());
            root.getIptcPackage().getEnvelopeRecord().setProductID("test project id");
            // ...
            if (root.getIptcPackage().getApplicationRecord() == null) {
                root.getIptcPackage().setApplicationRecord(new IptcApplicationRecord());
            }
            root.getIptcPackage().getApplicationRecord().setByLine("GroupDocs");
            root.getIptcPackage().getApplicationRecord().setHeadline("test");
            root.getIptcPackage().getApplicationRecord().setByLineTitle("code sample");
            root.getIptcPackage().getApplicationRecord().setReleaseDate(new Date());

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}
