---
id: working-with-metadata-in-gif-images
url: metadata/java/working-with-metadata-in-gif-images
title: Working with metadata in GIF images
weight: 4
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Detecting the GIF version

The following sample of code will help you to detect the version of a loaded GIF image and extract some additional file format information.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a GIF image
2.  Extract the root metadata package
3.  Use the [getGifImageType](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/GifRootPackage#getGifImageType()) method to obtain file format information

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>image.gif.GifReadFileFormatProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputGif)) {
	GifRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getGifImageType().getFileFormat());
	System.out.println(root.getGifImageType().getVersion());
	System.out.println(root.getGifImageType().getByteOrder());
	System.out.println(root.getGifImageType().getMimeType());
	System.out.println(root.getGifImageType().getExtension());
	System.out.println(root.getGifImageType().getWidth());
	System.out.println(root.getGifImageType().getHeight());
}
```

## Working with XMP Metadata

GroupDocs.Metadata for Java also allows managing XMP metadata in GIF files. For more details please refer to the following guide: [Working with XMP Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-xmp-metadata.md" >}}).

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
