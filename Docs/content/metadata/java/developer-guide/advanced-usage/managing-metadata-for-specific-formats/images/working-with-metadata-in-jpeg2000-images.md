---
id: working-with-metadata-in-jpeg2000-images
url: metadata/java/working-with-metadata-in-jpeg2000-images
title: Working with metadata in JPEG2000 images
weight: 5
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading JPEG2000 comments

The GroupDocs.Metadata API supports extracting format-specific information from JPEG2000 images.

The following are the steps to read the JPEG2000 comments (pieces of metadata represented as strings with the length up to 64 kbytes).

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a JPEG2000 image
2.  Get the root metadata package
3.  Extract  the native metadata package using the [Jpeg2000RootPackage.getJpeg2000Package](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/Jpeg2000RootPackage#getJpeg2000Package()) method
4.  Read the JPEG2000 comments

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>image.jpeg2000.Jpeg2000ReadComments**

```csharp
try (Metadata metadata = new Metadata(Constants.InputJpeg2000)) {
	Jpeg2000RootPackage root = metadata.getRootPackageGeneric();

	if (root.getJpeg2000Package().getComments() != null) {
		for (String comment : root.getJpeg2000Package().getComments()) {
			System.out.println(comment);
		}
	}
}
```

## Working with XMP metadata

GroupDocs.Metadata for Java also allows managing XMP metadata in JPEG2000 images. For more details please refer to the following guide: [Working with XMP Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-xmp-metadata.md" >}}).

## Working with EXIF metadata

The GroupDocs.Metadata API supports handling EXIF metadata in JPEG2000 images. Please find appropriate code samples in the [Working with EXIF Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-exif-metadata.md" >}}) section.

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
