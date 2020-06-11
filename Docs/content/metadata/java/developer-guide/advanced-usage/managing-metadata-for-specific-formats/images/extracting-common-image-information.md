---
id: extracting-common-image-information
url: metadata/java/extracting-common-image-information
title: Extracting common image information
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
For all supported image formats the GroupDocs.Metadata API allows extracting common image properties such as width and height, MIME type, byte order, etc. Please see the code snippet below for more information on the feature.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an image
2.  Extract the root metadata package
3.  Use the [getImageType](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/ImageRootPackage#getImageType()) method to obtain file format information

**advanced\_usage.managing\_metadata\_for\_specific\_formats.image.ImageReadFileFormatProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputPng)) {
	ImageRootPackage root = metadata.getRootPackageGeneric();

	System.out.println(root.getImageType().getFileFormat());
	System.out.println(root.getImageType().getByteOrder());
	System.out.println(root.getImageType().getMimeType());
	System.out.println(root.getImageType().getExtension());
	System.out.println(root.getImageType().getWidth());
	System.out.println(root.getImageType().getHeight());
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
