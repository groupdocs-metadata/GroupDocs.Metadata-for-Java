---
id: working-with-exif-metadata
url: metadata/java/working-with-exif-metadata
title: Working with EXIF metadata
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## What is EXIF?

According to the [specification](https://www.exif.org/Exif2-2.PDF), EXIF (Exchangeable image file format) is a standard that specifies the formats to be used for images, sound and tags in digital still cameras and in other systems handling the image and sound files recorded by digital still cameras. Despite the confusing definition and name of the format, EXIF is just a metadata standard. In fact, it simply defines a way to store metadata properties in a variety of well-known image and audio formats. The EXIF tag structure is borrowed from TIFF files. The [specification](https://www.exif.org/Exif2-2.PDF) declares a set of tags intended to store technical details such as the geolocation of the place where a picture was taken, the name of the camera owner, camera settings, etc. 

{{< alert style="info" >}}
Please refer to the [following article](https://en.wikipedia.org/wiki/Exif) to get more information on the standard.
{{< /alert >}}

## Reading basic EXIF properties

To access EXIF metadata in a file of any supported format, GroupDocs.Metadata provides the [IExif.getExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IExif#getExifPackage()) method. The following are the steps to read EXIF metadata:

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains EXIF metadata
2.  Extract the EXIF metadata package using the [IExif.getExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IExif#getExifPackage()) method

The following code snippet gets EXIF properties of a TIFF image and displays them on the screen. 

**advanced\_usage.working\_with\_metadata\_standards.exif.ReadBasicExifProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.TiffWithExif)) {
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

## Reading all EXIF tags

In some cases, it's necessary to read all EXIF properties from a file, including custom ones. To achieve this the GroupDocs.Metadata API provides direct access to the EXIF tags extracted from a file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains EXIF metadata
2.  Extract the EXIF metadata package using the [IExif.getExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IExif#getExifPackage()) method
3.  Iterate through all EXIF tags on different levels

**advanced\_usage.working\_with\_metadata\_standards.exif.ReadExifTags**

```csharp
try (Metadata metadata = new Metadata(Constants.JpegWithExif)) {
	IExif root = (IExif) metadata.getRootPackage();
	if (root.getExifPackage() != null) {
		String pattern = "%s = %s";

		for (TiffTag tag : root.getExifPackage().toList()) {
			System.out.println(String.format(pattern, tag.getTagID(), tag.getValue()));
		}

		for (TiffTag tag : root.getExifPackage().getExifIfdPackage().toList()) {
			System.out.println(String.format(pattern, tag.getTagID(), tag.getValue()));
		}

		for (TiffTag tag : root.getExifPackage().getGpsPackage().toList()) {
			System.out.println(String.format(pattern, tag.getTagID(), tag.getValue()));
		}
	}
}
```

## Reading a specific EXIF tag

The GroupDocs.Metadata API also supports reading specific EXIF tags using a method that accepts the tag id as a parameter. Follow below-mentioned steps to read a specific EXIF tag.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains EXIF metadata
2.  Extract the EXIF metadata package using the [IExif.getExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IExif#getExifPackage()) method
3.  Get a specific tag using the [getByTiffTagID](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ExifDictionaryBasePackage#getByTiffTagID(int)) method

**advanced\_usage.working\_with\_metadata\_standards.exif.ReadSpecificExifTag**

```csharp
try (Metadata metadata = new Metadata(Constants.TiffWithExif)) {
	IExif root = (IExif) metadata.getRootPackage();
	if (root.getExifPackage() != null) {
		TiffAsciiTag software = (TiffAsciiTag) root.getExifPackage().getByTiffTagID(TiffTagID.Software);
		if (software != null) {
			System.out.println(String.format("Software: %s", software.getValue()));
		}
	}
}
```

## Updating EXIF properties

The GroupDocs.Metadata API facilitates the user to update EXIF metadata in a convenient way - using the [ExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ExifPackage) class methods. Follow the below steps to update EXIF metadata in a file of any supported format.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains EXIF metadata
2.  Extract the EXIF metadata package using the [IExif.getExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IExif#getExifPackage()) method
3.  Assign values to desired EXIF properties
4.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/saving-files/_index.md" >}}) the changes

**advanced\_usage.working\_with\_metadata\_standards.exif.UpdateExifProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputJpeg)) {
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

	metadata.save(Constants.OutputJpeg);
}
```

## Adding or updating custom EXIF tags

The GroupDocs.Metadata API allows adding or updating custom tags in an EXIF package.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a file that contains EXIF metadata
2.  Extract the EXIF metadata package using the [IExif.getExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IExif#getExifPackage()) method
3.  Set the EXIF package if it's missing
4.  Add any number of custom tags to the package
5.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/saving-files/_index.md" >}}) the changes

**advanced\_usage.working\_with\_metadata\_standards.exif.SetCustomExifTag**

```csharp
try (Metadata metadata = new Metadata(Constants.TiffWithExif)) {
	IExif root = (IExif) metadata.getRootPackage();
	// Set the EXIF package if it's missing
	if (root.getExifPackage() == null) {
		root.setExifPackage(new ExifPackage());
	}

	// Add a known property
	root.getExifPackage().set(new TiffAsciiTag(TiffTagID.Artist, "test artist"));

	// Add a fully custom property (which is not described in the EXIF specification).
	// Please note that the chosen ID may intersect with the IDs used by some third party tools.
	root.getExifPackage().set(new TiffAsciiTag(65523, "custom"));
	metadata.save(Constants.OutputTiff);
}
```

Here is a full list of tags that can be added to an EXIF package:

*   [TiffAsciiTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffAsciiTag)
*   [TiffByteTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffByteTag)
*   [TiffDoubleTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffDoubleTag)
*   [TiffFloatTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffFloatTag)
*   [TiffLongTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffLongTag)
*   [TiffRationalTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffRationalTag)
*   [TiffSByteTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffSByteTag)
*   [TiffShortTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffShortTag)
*   [TiffSLongTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffSLongTag)
*   [TiffSRationalTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffSRationalTag)
*   [TiffSShortTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffSShortTag)
*   [TiffUndefinedTag](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/TiffUndefinedTag)

## Removing EXIF metadata

To remove the EXIF package from a file just pass null to the [IExif.setExifPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/IExif#setExifPackage(com.groupdocs.metadata.core.ExifPackage)) method. The code sample below shows how to remove EXIF metadata from a file.

**advanced\_usage.working\_with\_metadata\_standards.exif.RemoveExifMetadata**

```csharp
try (Metadata metadata = new Metadata(Constants.JpegWithExif)) {
	IExif root = (IExif) metadata.getRootPackage();
	root.setExifPackage(null);
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
