// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EmailRootPackage;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This example demonstrates how to update fields of an email message.
 */
public class EmailUpdateEmailFields {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("EmailUpdateEmailFields.eml");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            EmailRootPackage root = metadata.getRootPackageGeneric();
            root.getEmailPackage().setRecipients(new String[]{"sample@aspose.com"});
            root.getEmailPackage().setCarbonCopyRecipients(new String[]{"sample@groupdocs.com"});
            root.getEmailPackage().setSubject("RE: test subject");

            metadata.save(outputPath.toString());

            System.out.println("..sample finished successfully.\n");
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return outputPath;
    }
}

