// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2026 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MsgAttachmentPackage;
import com.groupdocs.metadata.core.MsgKnownProperties;
import com.groupdocs.metadata.core.MsgPackage;
import com.groupdocs.metadata.core.MsgRootPackage;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.examples.Constants;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

/**
 * This code sample shows how to update fields of an Outlook (MSG) message.
 */
public class MsgUpdateEmailFields {
    public static void run() throws IOException {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # MsgUpdateEmailFields : How to update fields of an email message.\n");
        try (Metadata metadata = new Metadata(Constants.InputMsg)) {
            MsgRootPackage root = metadata.getRootPackageGeneric();
            MsgPackage msg = root.getMsgPackage();

            System.out.println(String.format("PR_DISPLAY_NAME before: %s", root.getString(MsgKnownProperties.PR_DISPLAY_NAME)));
            System.out.println(String.format("PR_DISPLAY_CC before: %s", root.getString(MsgKnownProperties.PR_DISPLAY_CC)));
            System.out.println(String.format("SenderEmailAddress before: %s", msg.getSenderEmailAddress()));
            System.out.println(String.format("SenderName before: %s", msg.getSenderName()));
            System.out.println(String.format("Delivery Time before: %s", msg.getDeliveryTime()));
            System.out.println(String.format("Body before: %s", msg.getBody()));
            System.out.println(String.format("SenderSmtpAddress before: %s", msg.getSenderSmtpAddress()));
            for (MetadataProperty header : msg.getHeaders()) {
                System.out.println(String.format("Header before: name - %s, value = %s", header.getName(), header.getValue()));
            }
            if (msg.getCategories() != null) {
                for (String category : msg.getCategories()) {
                    System.out.println(String.format("Category before: %s", category));
                }
            }
            for (MsgAttachmentPackage attachment : msg.getAttachments()) {
                System.out.println(String.format("Attachment before: name - %s, length = %d", attachment.getName(), attachment.getContent().length));
            }

            msg.setSenderName("sender");
            msg.setSenderSmtpAddress("sender1@sender.com");
            msg.setDeliveryTime(new Date());
            msg.setBody("text");
            msg.setCategories(new String[]{"test1", "test2"});

            // Add new headers or update the existing ones
            msg.getHeaders().set("X-Custom-Header", new PropertyValue("Custom Value"));
            msg.getHeaders().set("X-MS-Exchange-Transport-EndToEndLatency", new PropertyValue("Custom Value"));
            msg.getHeaders().set("X-SID-Result", new PropertyValue("PASS"));

            // Replace the attachments
            byte[] content = Files.readAllBytes(Paths.get(Constants.AttachmentJpg));
            msg.setAttachments(new MsgAttachmentPackage[]{new MsgAttachmentPackage("tree.jpg", content)});

            metadata.save(Constants.OutputMsg);
        }

        try (Metadata metadata = new Metadata(Constants.OutputMsg)) {
            MsgRootPackage root = metadata.getRootPackageGeneric();
            MsgPackage msg = root.getMsgPackage();

            System.out.println(String.format("PR_DISPLAY_NAME after: %s", root.getString(MsgKnownProperties.PR_DISPLAY_NAME)));
            System.out.println(String.format("PR_DISPLAY_CC after: %s", root.getString(MsgKnownProperties.PR_DISPLAY_CC)));
            System.out.println(String.format("SenderEmailAddress after: %s", msg.getSenderEmailAddress()));
            System.out.println(String.format("SenderName after: %s", msg.getSenderName()));
            System.out.println(String.format("Delivery Time after: %s", msg.getDeliveryTime()));
            System.out.println(String.format("Body after: %s", msg.getBody()));
            System.out.println(String.format("SenderSmtpAddress after: %s", msg.getSenderSmtpAddress()));
            for (MetadataProperty header : msg.getHeaders()) {
                System.out.println(String.format("Header after: name - %s, value = %s", header.getName(), header.getValue().getRawValue()));
            }
            if (msg.getCategories() != null) {
                for (String category : msg.getCategories()) {
                    System.out.println(String.format("Category after: %s", category));
                }
            }
            for (MsgAttachmentPackage attachment : msg.getAttachments()) {
                System.out.println(String.format("Attachment after: name - %s, length = %d", attachment.getName(), attachment.getContent().length));
            }
        }
    }
}
