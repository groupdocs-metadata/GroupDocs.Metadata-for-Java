---
id: working-with-bmp-metadata
url: metadata/java/working-with-bmp-metadata
title: Working with BMP metadata
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading BMP header properties

The GroupDocs.Metadata API supports extracting format-specific information from BMP file headers.

The following are the steps to read the header of a BMP file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a BMP image
2.  Get the root metadata package
3.  Extract  the native metadata package using the [BmpRootPackage.getBmpHeader](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/BmpRootPackage#getBmpHeader()) method
4.  Read the BMP header properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>image.bmp.BmpReadHeaderProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputBmp)) {
	BmpRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getBmpHeader().getBitsPerPixel());
	System.out.println(root.getBmpHeader().getColorsImportant());
	System.out.println(root.getBmpHeader().getHeaderSize());
	System.out.println(root.getBmpHeader().getImageSize());
	System.out.println(root.getBmpHeader().getPlanes());
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
