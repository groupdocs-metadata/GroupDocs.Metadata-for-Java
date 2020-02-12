// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.EmlRootPackage;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code sample shows how to extract metadata from an EML message.
 */
public class EmlReadNativeMetadataProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputEml)) {
            EmlRootPackage root = metadata.getRootPackageGeneric();

            System.out.println(root.getEmailPackage().getSender());
            System.out.println(root.getEmailPackage().getSubject());
            for (String recipient : root.getEmailPackage().getRecipients()) {
                System.out.println(recipient);
            }

            for (String attachedFileName : root.getEmailPackage().getAttachedFileNames()) {
                System.out.println(attachedFileName);
            }

            for (MetadataProperty header : root.getEmailPackage().getHeaders()) {
                System.out.println(String.format("%s = %s", header.getName(), header.getValue()));
            }

            // ...
        }
    }
}
