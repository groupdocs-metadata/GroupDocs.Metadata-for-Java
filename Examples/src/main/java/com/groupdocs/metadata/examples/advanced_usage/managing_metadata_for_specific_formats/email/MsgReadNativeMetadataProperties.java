// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MsgRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to extract metadata from an MSG message.
 */
public class MsgReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputMsg)) {
            MsgRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getMsgPackage().getSender());
            System.out.println(root.getMsgPackage().getSubject());
            for (String recipient : root.getMsgPackage().getRecipients()) {
                System.out.println(recipient);
            }

            for (String attachedFileName : root.getMsgPackage().getAttachedFileNames()) {
                System.out.println(attachedFileName);
            }

            for (MetadataProperty header : root.getMsgPackage().getHeaders()) {
                System.out.println(String.format("%s = %s", header.getName(), header.getValue()));
            }

            System.out.println(root.getMsgPackage().getBody());
            System.out.println(root.getMsgPackage().getDeliveryTime());

            // ...
        }
    }
}
