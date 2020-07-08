---
id: working-with-metadata-in-psd-images
url: metadata/java/working-with-metadata-in-psd-images
title: Working with metadata in PSD images
weight: 8
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading Photoshop Metadata properties

The GroupDocs Metadata API allows the user to read Adobe Photoshop metadata associated with a PSD image. For more information on the Photoshop file format and metadata blocks please refer to the specification: [https://www.adobe.com/devnet-apps/photoshop/fileformatashtml/](https://www.adobe.com/devnet-apps/photoshop/fileformatashtml/).

The code sample below demonstrates how to extract image resource blocks (building blocks of the Photoshop file format) from a PSD image.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a PSD file
2.  Get the root metadata package
3.  Extract the [ImageResourcePackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ImageResourcePackage) instance and obtain a list of [ImageResourceBlock](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ImageResourceBlock) objects
4.  Iterate trough the collection of resource blocks

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>image.psd.PsdReadImageResourceBlocks**

```csharp
try (Metadata metadata = new Metadata(Constants.PsdWithIrb)) {
	PsdRootPackage root = metadata.getRootPackageGeneric();
	if (root.getImageResourcePackage() != null) {
		for (ImageResourceBlock block : root.getImageResourcePackage().toList()) {
			System.out.println(block.getSignature());
			System.out.println(block.getID());
			System.out.println(block.getName());
			System.out.println(block.getData());
		}
	}
}
```

## Reading the image header and information about PSD layers

The GroupDocs.Metadata API also supports extracting some other format-specific information from PSD images.

The following are the steps to read the header of a PSD file and extract information about the PSD layers.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a PSD image
2.  Get the root metadata package
3.  Extract  the native metadata package using the [PsdRootPackage.getPsdPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PsdRootPackage#getPsdPackage()) method
4.  Read the PSD header and layer information

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>image.psd.PsdReadNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.PsdWithIptc)) {
	PsdRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getPsdPackage().getChannelCount());
	System.out.println(root.getPsdPackage().getColorMode());
	System.out.println(root.getPsdPackage().getCompression());
	System.out.println(root.getPsdPackage().getPhotoshopVersion());

	for (PsdLayer layer : root.getPsdPackage().getLayers()) {
		System.out.println(layer.getName());
		System.out.println(layer.getBitsPerPixel());
		System.out.println(layer.getChannelCount());
		System.out.println(layer.getFlags());
		System.out.println(layer.getHeight());
		System.out.println(layer.getWidth());

		// ...
	}

	// ...
}
```

## Working with XMP metadata

GroupDocs.Metadata for Java allows managing XMP metadata in JPEG images. For more details please refer to the following guide: [Working with XMP Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-xmp-metadata.md" >}}).

## Working with EXIF metadata

The GroupDocs.Metadata API supports handling EXIF metadata in JPEG images. Please find appropriate code samples in the [Working with EXIF Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-exif-metadata.md" >}}) section.

## Working with IPTC metadata

GroupDocs.Metadata for Java is also able to work with IPTC metadata in PSD images. Please find more information in the [Working with IPTC IIM Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-iptc-iim-metadata.md" >}}) section.

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
