---
id: groupdocs-metadata-for-java-20-5-release-notes
url: metadata/java/groupdocs-metadata-for-java-20-5-release-notes
title: GroupDocs.Metadata for Java 20.5 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 20.5{{< /alert >}}

#   
Major Features

{{< alert style="danger" >}}In version 20.5 the legacy API has been removed (all types from the com.groupdocs.metadata.legacy package were removed).{{< /alert >}}

  
There are the following features, enhancements and fixes in this release:

*   Remove obsolete API (Legacy namespace)
*   Implement the ability to work with EXIF metadata in WEBP images
*   Implement the ability to work with XMP metadata in MOV files  
      
    

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-3293 | Remove obsolete API (Legacy namespace) | Improvement |
| METADATANET-2851 | Implement the ability to work with EXIF metadata in WEBP images | New Feature |
| METADATANET-2854 | Implement the ability to work with XMP metadata in MOV files | New Feature |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 20.5. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Remove obsolete API (Legacy namespace)

All types from the com.groupdocs.metadata.legacy package were removed.

##### Public API changes

All types from the com.groupdocs.metadata.legacy package were removed

##### Use cases

See the [migration notes]({{< ref "metadata/java/developer-guide/migration-notes.md" >}}) for brief comparison of the old and new API

### Implement the ability to work with EXIF metadata in WEBP images

This new feature allows the user to read, update and remove EXIF metadata in WEBP images.

##### Public API changes

The following methods have been added to the [WebPRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/WebPRootPackage) class

*   [getExifPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/WebPRootPackage#getExifPackage())
*   [setExifPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/WebPRootPackage#setExifPackage(com.groupdocs.metadata.core.ExifPackage))

The [WebPRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/WebPRootPackage) class now implements the [IExif](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/IExif) interface

##### Use cases

Read EXIF metadata properties in a WEBP image

**Java**

```csharp
try (Metadata metadata = new Metadata("D:\\exif.webp")) {
	IExif root = (IExif) metadata.getRootPackage();
	if (root.getExifPackage() != null) {

		System.out.println(root.getExifPackage().getArtist());
		System.out.println(root.getExifPackage().getCopyright());
		System.out.println(root.getExifPackage().getImageDescription());
		System.out.println(root.getExifPackage().getMake());
		System.out.println(root.getExifPackage().getModel());
		System.out.println(root.getExifPackage().getSoftware());
		System.out.println(root.getExifPackage().getImageWidth());
		System.out.println(root.getExifPackage().getImageLength());

		// ...
		System.out.println(root.getExifPackage().getExifIfdPackage().getBodySerialNumber());
		System.out.println(root.getExifPackage().getExifIfdPackage().getCameraOwnerName());
		System.out.println(root.getExifPackage().getExifIfdPackage().getUserComment());

		// ...
		System.out.println(root.getExifPackage().getGpsPackage().getAltitude());
		System.out.println(root.getExifPackage().getGpsPackage().getLatitudeRef());
		System.out.println(root.getExifPackage().getGpsPackage().getLongitudeRef());

		// ...
	}
}
```

### Implement the ability to work with XMP metadata in MOV files

This new feature allows the user to read, update and remove XMP metadata in MOV video files.

##### Public API changes

The following methods have been added to the [MovRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/MovRootPackage) class

*   [getXmpPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/MovRootPackage#getXmpPackage())
*   [setXmpPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/MovRootPackage#setXmpPackage(com.groupdocs.metadata.core.XmpPacketWrapper))

The [MovRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/MovRootPackage) class now implements the [IXmp](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/IXmp) interface

##### Use cases

Read XMP metadata properties in a MOV video

**Java**

```csharp
try (Metadata metadata = new Metadata("D:\\xmp.mov")) {
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
