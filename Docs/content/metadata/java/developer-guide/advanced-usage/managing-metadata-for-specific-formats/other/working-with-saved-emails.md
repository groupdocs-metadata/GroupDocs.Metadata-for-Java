---
id: working-with-saved-emails
url: metadata/java/working-with-saved-emails
title: Working with saved Emails
weight: 6
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
GroupDocs.Metadata for Java provides functionality that allows handling the most popular email message formats: EML and MSG. The following are some commonly used scenarios of working with the message content and metadata.

## Reading EML message metadata

The EML message format is used by many email clients including Novell GroupWise, Microsoft Outlook Express, Lotus notes, Windows Mail, Mozilla Thunderbird, and Postbox. The files contain the email contents as plain text in MIME format, containing the email header and body, including attachments in one or more of several formats. The code sample below demonstrates how to extract metadata from an EML message.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.email.EmlReadNativeMetadataProperties**

```csharp
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
```

## Reading MSG metadata

MSG files are usually created by the Microsoft Outlook email client. The MSG format is used to represent individual email messages, appointments, contacts, tasks, and so on in the file system. The following code snippet shows how to read most common properties of an email message stored as an MSG file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.email.MsgReadNativeMetadataProperties**

```csharp
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
```

## Removing email attachments

Both root package classes representing metadata in email messages ([EmlRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmlRootPackage) and [MsgRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MsgRootPackage)) have the common ancestor which is the [EmailRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailRootPackage) class. Since the MSG and EML formats have really similar functionality, in most cases, you don't need to know the exact type of a loaded message. It is possible to refer to the [EmailRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailRootPackage) class to access all basic features related to email messages. The following code sample shows how to remove all email message attachments using an instance of the [EmailRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EmailRootPackage) class.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.email.EmailRemoveAttachments**

```csharp
try (Metadata metadata = new Metadata(Constants.InputEml)) {
	EmailRootPackage root = metadata.getRootPackageGeneric();
	root.clearAttachments();
	metadata.save(Constants.OutputEml);
}
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
