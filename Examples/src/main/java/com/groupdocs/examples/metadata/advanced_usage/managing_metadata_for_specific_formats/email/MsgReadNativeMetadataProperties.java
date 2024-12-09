// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MsgRootPackage;

import java.nio.file.Path;

/**
 * This code sample shows how to extract metadata from an MSG message.
 */
public class MsgReadNativeMetadataProperties {
    public static MsgRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MsgRootPackage root = metadata.getRootPackageGeneric();
            System.out.printf("\tSender: %s%n", root.getMsgPackage().getSender());
            System.out.printf("\tSubject: %s%n", root.getMsgPackage().getSubject());
            for (String recipient : root.getMsgPackage().getRecipients()) {
                System.out.printf("\tRecipient: %s%n", recipient);
            }
            for (String attachedFileName : root.getMsgPackage().getAttachedFileNames()) {
                System.out.printf("\tAttached File: %s%n", attachedFileName);
            }
            for (MetadataProperty header : root.getMsgPackage().getHeaders()) {
                System.out.printf("\tHeader: %s = %s%n", header.getName(), header.getValue());
            }
            System.out.printf("\tBody: %s%n", root.getMsgPackage().getBody());
            System.out.printf("\tDelivery Time: %s%n", root.getMsgPackage().getDeliveryTime());

            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
