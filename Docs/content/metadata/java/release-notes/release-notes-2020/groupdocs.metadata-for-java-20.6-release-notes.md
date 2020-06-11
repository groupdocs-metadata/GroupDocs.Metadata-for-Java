---
id: groupdocs-metadata-for-java-20-6-release-notes
url: metadata/java/groupdocs-metadata-for-java-20-6-release-notes
title: GroupDocs.Metadata for Java 20.6 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 20.6{{< /alert >}}

# Major Features

  
There are the following features, enhancements and fixes in this release:

*   Implement the ability to add, update and remove IPTC metadata in TIFF images
*   Implement the ability to export metadata properties to an xls/xlsx worksheet
*   Exception: Could not read MPP format

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2495 | Implement the ability to add, update and remove IPTC metadata in TIFF images | New Feature |
| METADATANET-3332 | Implement the ability to export metadata properties to an xls/xlsx worksheet | Improvement |
| METADATANET-3338 | Exception: Could not read MPP format | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 20.6. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Implement the ability to add, update and remove IPTC metadata in TIFF images

This new feature allows the user to add, update and remove IPTC metadata packages in TIFF images.

##### Public API changes

The [TiffRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffRootPackage) class now implements the [IIptc](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IIptc) interface

The [setIptcPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffRootPackage#setIptcPackage(com.groupdocs.metadata.core.IptcRecordSet)) method has been added to the [TiffRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffRootPackage) class

##### Use cases

Add or update IPTC metadata in a TIFF image

**Java**

```csharp
 try (Metadata metadata = new Metadata("D:\\input.tif")) {
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
	metadata.save("D:\\output.tif");
}
```

### Implement the ability to export metadata properties to an xls/xlsx worksheet

This improvement allows the user to export an arbitrary set of metadata properties to an Excel workbook.

##### Public API changes

The [com.groupdocs.metadata.export](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.export/package-frame) package has been introduced

The [ExportFormat](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.export/ExportFormat) class has been added to the [com.groupdocs.metadata.export](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.export/package-frame) package

The [ExportManager](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.export/ExportManager) class has been added to the [com.groupdocs.metadata.export](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.export/package-frame) package

##### Use cases

Export the whole metadata tree to an Excel workbook

**Java**

```csharp
try (Metadata metadata = new Metadata(Constants.InputDoc)) {
	RootMetadataPackage root = metadata.getRootPackage();
	if (root != null) {
		// Initialize the export manager with the root metadata package to export the whole metadata tree
		ExportManager manager = new ExportManager(root);
		manager.export(Constants.OutputXls, ExportFormat.Xls);
	}
}
```

###
