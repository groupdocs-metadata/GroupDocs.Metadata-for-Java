---
id: extracting-makernote-metadata
url: metadata/java/extracting-makernote-metadata
title: Extracting MakerNote metadata
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## What is MakerNote?

MakerNote metadata refers to image information that is written by digital cameras of different manufacturers. Usually, MakerNote metadata properties contain camera settings and some other conditions under which the shot was taken. Most manufacturers store MakerNote properties in a proprietary binary format derived from EXIF. GroupDocs.Metadata allows extracting MakerNote metadata saved by the following manufacturers:

*   Canon
*   Nikon
*   Panasonic
*   Sony

## Read all MakerNote properties in the form of TIFF/EXIF tags

Utilizing the GroupDocs.Metadata API the user is able to read all metadata properties regardless of the exact MakerNote format.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a raw image file that contains MakerNote metadata
2.  Extract the MakerNote package using the [getMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/JpegRootPackage#getMakerNotePackage()) method
3.  Iterate through the EXIF tags 

**advanced\_usage.managing\_metadata\_for\_specific\_formats.image.jpeg.maker\_note.MakerNoteReadAllTags**

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

To help you with interpreting extracted tags we implemented classes representing specific MakerNote metadata packages. Please cast the return value of the [getMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/JpegRootPackage#getMakerNotePackage()) method to one of the classes listed below to get more format-specific capabilities:

*   [CanonMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/CanonMakerNotePackage)
*   [NikonMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/NikonMakerNotePackage)
*   [PanasonicMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/PanasonicMakerNotePackage)
*   [SonyMakerNotePackage](https://apireference.groupdocs.com/java/metadata/com.groupdocs.metadata.core/SonyMakerNotePackage)

## Read Canon MakerNote properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.image.jpeg.maker\_note.MakerNoteReadCanonProperties**

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

## Read Nikon MakerNote properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.image.jpeg.maker\_note.MakerNoteReadNikonProperties**

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

## Read Panasonic MakerNote properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.image.jpeg.maker\_note.MakerNoteReadPanasonicProperties**

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

## Read Sony MakerNote properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.image.jpeg.maker\_note.MakerNoteReadSonyProperties**

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

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
