---
id: working-with-iptc-iim-metadata
url: metadata/java/working-with-iptc-iim-metadata
title: Working with IPTC IIM metadata
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## What is IPTC IIM?

The IPTC Information Interchange Model (IIM) is a set of metadata properties that can be applied to text, images, and other media types. The standard also defines a complex data structure that is utilized to store the properties. The IPTC IIM was developed by the International Press Telecommunications Council (IPTC) to expedite the international exchange of news among newspapers and news agencies. But nowadays it's commonly used by amateur and commercial photographers. The standard is supported by many image creation and manipulation programs. IPTC IIM metadata can be embedded into a variety of image formats such as JPEG, TIFF, etc.

{{< alert style="info" >}}For more information on the IPTC IIM standard please refer to https://www.iptc.org/std/IIM/4.2/specification/IIMV4.2.pdf.{{< /alert >}}

## Reading basic IPTC IIM properties

To access IPTC metadata in a file of any supported format, GroupDocs.Metadata provides the [IIptc.getIptcPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IIptc#getIptcPackage()) method. The following are the steps to read IPTC metadata:

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains IPTC metadata
2.  Extract the IPTC metadata package using the [IIptc.getIptcPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IIptc#getIptcPackage()) method
3.  Read properties of the [IptcApplicationRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcApplicationRecord) and [IptcEnvelopeRecord](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcEnvelopeRecord) class instances

The following code snippet gets IPTC properties of a JPEG image and displays them on the screen. 

**advanced\_usage.working\_with\_metadata\_standards.iptc.ReadBasicIptcProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.JpegWithIptc)) {
	IIptc root = (IIptc) metadata.getRootPackage();
	if (root.getIptcPackage() != null) {
		if (root.getIptcPackage().getEnvelopeRecord() != null) {
			System.out.println(root.getIptcPackage().getEnvelopeRecord().getDateSent());
			System.out.println(root.getIptcPackage().getEnvelopeRecord().getDestination());
			System.out.println(root.getIptcPackage().getEnvelopeRecord().getFileFormat());
			System.out.println(root.getIptcPackage().getEnvelopeRecord().getFileFormatVersion());

			// ...
		}
		if (root.getIptcPackage().getApplicationRecord() != null) {
			System.out.println(root.getIptcPackage().getApplicationRecord().getHeadline());
			System.out.println(root.getIptcPackage().getApplicationRecord().getByLine());
			System.out.println(root.getIptcPackage().getApplicationRecord().getByLineTitle());
			System.out.println(root.getIptcPackage().getApplicationRecord().getCaptionAbstract());
			System.out.println(root.getIptcPackage().getApplicationRecord().getCity());
			System.out.println(root.getIptcPackage().getApplicationRecord().getDateCreated());
			System.out.println(root.getIptcPackage().getApplicationRecord().getReleaseDate());

			// ...
		}
	}
}
```

## Reading all IPTC IIM datasets

In some cases, it's necessary to read all IPTC datasets (metadata properties) from a file, including custom ones. To achieve this the GroupDocs.Metadata API provides direct access to the IPTC datasets extracted from a file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains IPTC metadata
2.  Extract the IPTC metadata package using the [IIptc.getIptcPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IIptc#getIptcPackage()) method
3.  Iterate through all IPTC datasets

**advanced\_usage.working\_with\_metadata\_standards.iptc.ReadIptcDataSets**

```csharp
try (Metadata metadata = new Metadata(Constants.PsdWithIptc)) {
	IIptc root = (IIptc) metadata.getRootPackage();
	if (root.getIptcPackage() != null) {
		for (IptcDataSet dataSet : root.getIptcPackage().toDataSetList()) {
			System.out.println(dataSet.getRecordNumber());
			System.out.println(dataSet.getDataSetNumber());
			System.out.println(dataSet.getAlternativeName());
			System.out.println(dataSet.getValue().getRawValue());
		}
	}
}
```

## Updating IPTC IIM properties

The GroupDocs.Metadata API facilitates the user to update IPTC metadata in a convenient way - using the [IptcRecordSet](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcRecordSet) class methods. Follow the below steps to update IPTC metadata in a file of any supported format.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains IPTC metadata
2.  Extract the IPTC metadata package using the [IIptc.getIptcPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IIptc#getIptcPackage()) method
3.  Assign values to desired IPTC properties
4.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/saving-files/_index.md" >}}) the changes

**advanced\_usage.working\_with\_metadata\_standards.iptc.UpdateIptcProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputJpeg)) {
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

	// ...

	metadata.save(Constants.OutputJpeg);
}
```

## Adding or updating custom IPTC IIM datasets

The GroupDocs.Metadata API allows adding or updating custom datasets in an IPTC package.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains IPTC metadata
2.  Extract the IPTC metadata package using the [IIptc.getIptcPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IIptc#getIptcPackage()) method
3.  Set the IPTC package if it's missing
4.  Add any number of custom datasets to the package (Please see the [IptcDataSet](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IptcDataSet) class for more information)
5.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/saving-files/_index.md" >}}) the changes

**advanced\_usage.working\_with\_metadata\_standards.iptc.SetCustomIptcDataSet**

```csharp
try (Metadata metadata = new Metadata(Constants.PsdWithIptc)) {
	IIptc root = (IIptc) metadata.getRootPackage();

	// Set the IPTC package if it's missing
	if (root.getIptcPackage() == null) {
		root.setIptcPackage(new IptcRecordSet());
	}

	// Add a know property using the DataSet API
	root.getIptcPackage().set(new IptcDataSet((byte) IptcRecordType.ApplicationRecord, (byte) IptcApplicationRecordDataSet.BylineTitle, "test code sample"));

	// Add a custom IPTC DataSet
	root.getIptcPackage().set(new IptcDataSet((byte) 100, (byte) 100, new byte[]{1, 2, 3}));

	metadata.save(Constants.OutputPsd);
}
```

## Removing IPTC IIM metadata

To remove the IPTC package from a file just pass null to the [IIptc.setIptcPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IIptc#setIptcPackage(com.groupdocs.metadata.core.IptcRecordSet)) method as a parameter. The code sample below shows how to remove IPTC metadata from a file.

**advanced\_usage.working\_with\_metadata\_standards.iptc.RemoveIptcMetadata**

```csharp
try (Metadata metadata = new Metadata(Constants.JpegWithIptc)) {
	IIptc root = (IIptc) metadata.getRootPackage();
	root.setIptcPackage(null);
	metadata.save(Constants.OutputJpeg);
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
