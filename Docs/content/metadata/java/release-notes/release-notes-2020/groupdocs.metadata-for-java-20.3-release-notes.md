---
id: groupdocs-metadata-for-java-20-3-release-notes
url: metadata/java/groupdocs-metadata-for-java-20-3-release-notes
title: GroupDocs.Metadata for Java 20.3 Release Notes
weight: 11
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 20.3{{< /alert >}}

## Major Features

There are the following features, enhancements and fixes in this release:

*   Implement the ability to work with EXIF metadata in PSD images
*   Implement the ability to work with XMP metadata in WEBP images

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2849 | Implement the ability to work with EXIF metadata in PSD images | New Feature |
| METADATANET-2850 | Implement the ability to work with XMP metadata in WEBP images | New Feature |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 20.3. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Implement the ability to work with EXIF metadata in PSD images

This new feature allows the user to update (or remove) EXIF metadata in a PSD file.

##### Public API changes

The [setExifPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/PsdRootPackage#setExifPackage(com.groupdocs.metadata.core.ExifPackage)) method has been added to the [PsdRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/PsdRootPackage) class

The [PsdRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/PsdRootPackage) class now implements the [IExif](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/IExif) interface

##### Use cases

Update EXIF metadata properties in a PSD file

**Java**

```csharp
 try (Metadata metadata = new Metadata("D:\\input.psd")) {
	IExif root = (IExif) metadata.getRootPackage();

	// Set the EXIF package if it's missing
	if (root.getExifPackage() == null) {
		root.setExifPackage(new ExifPackage());
	}

	root.getExifPackage().setCopyright("Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.");
	root.getExifPackage().setImageDescription("test image");
	root.getExifPackage().setSoftware("GroupDocs.Metadata");

	// ...

	root.getExifPackage().getExifIfdPackage().setBodySerialNumber("test");
	root.getExifPackage().getExifIfdPackage().setCameraOwnerName("GroupDocs");
	root.getExifPackage().getExifIfdPackage().setUserComment("test comment");

	// ...

	metadata.save("D:\\output.psd");
}
```

### Implement the ability to work with XMP metadata in WEBP images

This new feature allows the user to work with XMP metadata in WEBP images.

##### Public API changes

The [getXmpPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/WebPRootPackage#getXmpPackage()) method has been added to the [WebPRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/WebPRootPackage) class

The [setXmpPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/WebPRootPackage#setXmpPackage(com.groupdocs.metadata.core.XmpPacketWrapper)) method has been added to the [WebPRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/WebPRootPackage) class

The [WebPRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/WebPRootPackage) class now implements the [IXmp](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/IXmp) interface

##### Use cases

Extract XMP metadata properties from a WEBP image

**Java**

```csharp
 try (Metadata metadata = new Metadata("D:\\input.webp")) {
	IXmp root = (IXmp) metadata.getRootPackage();
	if (root.getXmpPackage() != null) {
		if (root.getXmpPackage().getSchemes().getXmpBasic() != null) {
			System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getCreatorTool());
			System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getCreateDate());
			System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getModifyDate());
			System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getLabel());
			System.out.println(root.getXmpPackage().getSchemes().getXmpBasic().getNickname());

			// ...
		}

		if (root.getXmpPackage().getSchemes().getDublinCore() != null) {
			System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getFormat());
			System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getCoverage());
			System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getIdentifier());
			System.out.println(root.getXmpPackage().getSchemes().getDublinCore().getSource());

			// ...
		}

		if (root.getXmpPackage().getSchemes().getPhotoshop() != null) {
			System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getColorMode());
			System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getIccProfile());
			System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getCountry());
			System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getCity());
			System.out.println(root.getXmpPackage().getSchemes().getPhotoshop().getDateCreated());

			// ...
		}

		// ...
	}
}
```
