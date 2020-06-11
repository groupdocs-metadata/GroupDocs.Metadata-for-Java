---
id: groupdocs-metadata-for-java-20-4-release-notes
url: metadata/java/groupdocs-metadata-for-java-20-4-release-notes
title: GroupDocs.Metadata for Java 20.4 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 20.4{{< /alert >}}

# Major Features

There are the following features, enhancements and fixes in this release:

*   Implement the ability to work with EXIF metadata in PNG images
*   Implement the ability to work with XMP metadata in MP3 files
*   Implement the ability to parse most common EXIF Makernote metadata formats using the new API

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2847 | Implement the ability to work with EXIF metadata in PNG images | New Feature |
| METADATANET-2852 | Implement the ability to work with XMP metadata in MP3 files | New Feature |
| METADATANET-3185 | Implement the ability to parse most common EXIF Makernote metadata formats using the new API | Enhancement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 20.4. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Implement the ability to work with EXIF metadata in PNG images

This new feature allows the user to read, update and remove EXIF metadata in PNG images.

##### Public API changes

The following methods have been added to the [PngRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/PngRootPackage) class

*   [getExifPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/PngRootPackage#getExifPackage())
*   [setExifPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/PngRootPackage#setExifPackage(com.groupdocs.metadata.core.ExifPackage))

The [PngRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/PngRootPackage) class now implements the [IExif](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/IExif) interface

##### Use cases

Read EXIF metadata properties in a PNG  image

**Java**

```csharp
try (Metadata metadata = new Metadata("D:\\exif.png")) {
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

### Implement the ability to work with XMP metadata in MP3 files

This new feature allows the user to read, update and remove XMP metadata in MP3 audio files.

##### Public API changes

The following methods have been added to the [MP3RootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/MP3RootPackage) class

*   [getXmpPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/MP3RootPackage#getXmpPackage())
*   [setXmpPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/MP3RootPackage#setXmpPackage(com.groupdocs.metadata.core.XmpPacketWrapper))

The [MP3RootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/MP3RootPackage) class now implements the [IXmp](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/IXmp) interface

##### Use cases

Read XMP metadata properties in an MP3 audio

**Java**

```csharp
try (Metadata metadata = new Metadata("D:\\xmp.mp3")) {
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

### Implement the ability to parse most common EXIF Makernote metadata formats using the new API

This enhancement allows the user to read MakerNote metadata packages stored by various camera manufacturers. Currently, this feature is available for JPEG images only.

##### Public API changes

The [getMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/JpegRootPackage#getMakerNotePackage()) method has been added to the [JpegRootPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/JpegRootPackage) class

The following classes have been added to the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/package-frame) package

*   [CanonCameraSettingsPackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/CanonCameraSettingsPackage)
*   [CanonMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/CanonMakerNotePackage)
*   [MakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/MakerNotePackage)
*   [NikonMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/NikonMakerNotePackage)
*   [PanasonicMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/PanasonicMakerNotePackage)
*   [SonyMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/SonyMakerNotePackage)

##### Use cases

Read all MakerNote properties in the form of TIFF/EXIF tags

**Java**

```csharp
try (Metadata metadata = new Metadata(Constants.CanonJpeg)) {
	JpegRootPackage root = metadata.getRootPackageGeneric();
	if (root.getMakerNotePackage() != null) {
		for (TiffTag tag : root.getMakerNotePackage().toList()) {

			// Please note that tag ids used by camera manufacturers may intersect with the ids defined in the TIFF/EXIF specification
			System.out.println(String.format("%s = %s", tag.getTagID(), tag.getValue()));
		}
	}
}
```

Read Canon MakerNote properties

**Java**

```csharp
try (Metadata metadata = new Metadata(Constants.CanonJpeg)) {
	JpegRootPackage root = metadata.getRootPackageGeneric();
	CanonMakerNotePackage makerNote = (CanonMakerNotePackage) root.getMakerNotePackage();
	if (makerNote != null) {
		System.out.println(makerNote.getCanonFirmwareVersion());
		System.out.println(makerNote.getCanonImageType());
		System.out.println(makerNote.getOwnerName());
		System.out.println(makerNote.getCanonModelID());

		// ...

		if (makerNote.getCameraSettings() != null) {
			System.out.println(makerNote.getCameraSettings().getAFPoint());
			System.out.println(makerNote.getCameraSettings().getCameraIso());
			System.out.println(makerNote.getCameraSettings().getContrast());
			System.out.println(makerNote.getCameraSettings().getDigitalZoom());

			// ...
		}
	}
}
```

Read Nikon MakerNote properties

**Java**

```csharp
try (Metadata metadata = new Metadata(Constants.NikonJpeg)) {
	JpegRootPackage root = metadata.getRootPackageGeneric();
	NikonMakerNotePackage makerNote = (NikonMakerNotePackage) root.getMakerNotePackage();
	if (makerNote != null) {

		System.out.println(makerNote.getColorMode());
		System.out.println(makerNote.getFlashSetting());
		System.out.println(makerNote.getFlashType());
		System.out.println(makerNote.getFocusMode());
		System.out.println(makerNote.getQuality());
		System.out.println(makerNote.getSharpness());

		// ...
	}
}
```

Read Panasonic MakerNote properties

**Java**

```csharp
try (Metadata metadata = new Metadata(Constants.PanasonicJpeg)) {
	JpegRootPackage root = metadata.getRootPackageGeneric();
	PanasonicMakerNotePackage makerNote = (PanasonicMakerNotePackage) root.getMakerNotePackage();
	if (makerNote != null) {

		System.out.println(makerNote.getAccessorySerialNumber());
		System.out.println(makerNote.getAccessoryType());
		System.out.println(makerNote.getMacroMode());
		System.out.println(makerNote.getLensSerialNumber());
		System.out.println(makerNote.getLensType());

		// ...
	}
}
```

Read Sony MakerNote properties

**Java**

```csharp
try (Metadata metadata = new Metadata(Constants.SonyJpeg)) {
	JpegRootPackage root = metadata.getRootPackageGeneric();
	SonyMakerNotePackage makerNote = (SonyMakerNotePackage) root.getMakerNotePackage();
	if (makerNote != null) {

		System.out.println(makerNote.getCreativeStyle());
		System.out.println(makerNote.getColorMode());
		System.out.println(makerNote.getJpegQuality());
		System.out.println(makerNote.getBrightness());
		System.out.println(makerNote.getSharpness());

		// ...
	}
}
```
