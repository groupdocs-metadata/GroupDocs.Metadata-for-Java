// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EmlRootPackage;
import com.groupdocs.metadata.core.MetadataProperty;

import java.nio.file.Path;

import static com.groupdocs.examples.metadata.utils.FilesUtils.makeOutputPath;

/**
 * This code sample shows how to extract metadata from an EML message.
 */
public class EmlReadNativeMetadataProperties {
    public static Path run(Path inputFile) {
        final Path outputPath = makeOutputPath("EmailModifyRecipientsSubject.eml");
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            EmlRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tSender: %s%n", root.getEmailPackage().getSender());
            System.out.printf("\tSubject: %s%n", root.getEmailPackage().getSubject());
            for (String recipient : root.getEmailPackage().getRecipients()) {
                System.out.printf("\tRecipient: %s%n", recipient);
            }
            for (String attachedFileName : root.getEmailPackage().getAttachedFileNames()) {
                System.out.printf("\tAttached File: %s%n", attachedFileName);
            }
            for (MetadataProperty header : root.getEmailPackage().getHeaders()) {
                System.out.printf("\tHeader: %s = %s%n", header.getName(), header.getValue());
            }
            metadata.save(outputPath.toString());
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        System.out.println("..sample finished successfully.");
        return outputPath;
    }
}
