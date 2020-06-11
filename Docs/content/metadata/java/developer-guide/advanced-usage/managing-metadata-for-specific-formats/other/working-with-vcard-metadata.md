---
id: working-with-vcard-metadata
url: metadata/java/working-with-vcard-metadata
title: Working with vCard metadata
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## What is vCard?

vCard, also known as VCF (Virtual Contact File), is a file format standard for electronic business cards. vCards are often attached to e-mail messages, but can be exchanged in other ways. They can contain name and address information, telephone numbers, e-mail addresses, URLs, logos, photographs, and even audio clips.

{{< alert style="info" >}}For more information on the format please see https://en.wikipedia.org/wiki/VCard{{< /alert >}}

## Getting Simple vCard metadata

To access Metadata in a vCard, GroupDocs.Metadata API provides the [VCardRootPackage.getVCardPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/VCardRootPackage#getVCardPackage())method which contains the information extracted from a file. The following are the steps to access metadata in a vCard:

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a vCard file
2.  Get the root metadata package
3.  Extract  the native metadata package using the [VCardRootPackage.getVCardPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/VCardRootPackage#getVCardPackage())method
4.  Read the extracted vCard fields

The following code snippet gets metadata of a vCard file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.business\_card.VCardReadCardProperties**

```csharp
public static void run() {
	try (Metadata metadata = new Metadata(Constants.InputVcf)) {

		VCardRootPackage root = metadata.getRootPackageGeneric();
		for (VCardCard vCard : root.getVCardPackage().getCards()) {
			System.out.println(vCard.getIdentificationRecordset().getName());
			PrintArray(vCard.getIdentificationRecordset().getFormattedNames());
			PrintArray(vCard.getCommunicationRecordset().getEmails());
			PrintArray(vCard.getCommunicationRecordset().getTelephones());
			PrintArray(vCard.getDeliveryAddressingRecordset().getAddresses());

			// ...
		}
	}
}

private static void PrintArray(String[] values) {
	if (values != null) {
		for (String value : values) {
			System.out.println(value);
		}
	}
}
```

## Getting Metadata with descriptive parameters

The GroupDocs.Metadata API also provides a way to get Metadata from vCards with descriptive parameters.The steps are given below:

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a vCard file
2.  Get the root metadata package
3.  Extract  the native metadata package using [t](https://apireference.groupdocs.com/net/metadata/groupdocs.metadata.formats.businesscard/vcardrootpackage/properties/vcardpackage)he [VCardRootPackage.getVCardPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/VCardRootPackage#getVCardPackage())method
4.  Use methods with the Record(s) postfix to get vCard fields along with descriptive parameters

The following code snippet shows how to extract vCard fields along with descriptive parameters.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.business\_card.VCardReadCardPropertiesWithParameters**

```csharp
try (Metadata metadata = new Metadata(Constants.InputVcf)) {
	VCardRootPackage root = metadata.getRootPackageGeneric();
	for (VCardCard vCard : root.getVCardPackage().getCards()) {
		if (vCard.getIdentificationRecordset().getPhotoUriRecords() != null) {

			// Iterate all photos represented by URIs
			for (VCardTextRecord photoUriRecord : vCard.getIdentificationRecordset().getPhotoUriRecords()) {

				// Print the property value
				System.out.println(photoUriRecord.getValue());

				// Print some additional parameters of the property
				System.out.println(photoUriRecord.getContentType());
				System.out.println(photoUriRecord.getMediaTypeParameter());

				if (photoUriRecord.getTypeParameters() != null) {
					for (String parameter : photoUriRecord.getTypeParameters()) {
						System.out.println(parameter);
					}
				}
				System.out.println(photoUriRecord.getPrefParameter());
			}
		}
	}
}
```

## Filtering vCard properties

The GroupDocs.Metadata API provides the ability to filter vCard properties in order to make finding desired information easier. The code sample below demonstrates how to use the filtering feature.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.business\_card.VCardFilterCardProperties**

```csharp
public static void run() {
	try (Metadata metadata = new Metadata(Constants.InputVcf)) {
		VCardRootPackage root = metadata.getRootPackageGeneric();

		for (VCardCard vCard : root.getVCardPackage().getCards()) {
			// Print most preferred work phone numbers and work emails
			VCardCard filtered = vCard.filterWorkTags().filterPreferred();
			PrintArray(filtered.getCommunicationRecordset().getTelephones());
			PrintArray(filtered.getCommunicationRecordset().getEmails());
		}
	}
}

private static void PrintArray(String[] values) {
	if (values != null) {
		for (String value : values) {
			System.out.println(value);
		}
	}
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
