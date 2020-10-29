---
id: working-with-metadata-in-png-images
url: metadata/java/working-with-metadata-in-png-images
title: Working with metadata in PNG images
weight: 7
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading PNG metadata properties

The GroupDocs.Metadata API supports extracting format-specific information from PNG images.

The following are the steps to read the native PNG metadata.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a PNG image
2.  Get the root metadata package
3.  Extract  the native metadata package using [PngRootPackage.PngPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PngRootPackage#getPngPackage())
4.  Read the PNG metadata properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>image.png.PngReadTextChunks**

```java
try (Metadata metadata = new Metadata(Constants.InputPng)) {
    PngRootPackage root = metadata.getRootPackageGeneric();
    for (PngTextChunk chunk : root.getPngPackage().getTextChunks()) {
  
        System.out.println(chunk.getKeyword());
        System.out.println(chunk.getText());
  
        if (chunk instanceof PngCompressedTextChunk) {
            PngCompressedTextChunk compressedChunk = (PngCompressedTextChunk) chunk;
            System.out.println(compressedChunk.getCompressionMethod());
        }
  
        if (chunk instanceof PngInternationalTextChunk) {
            PngInternationalTextChunk internationalChunk = (PngInternationalTextChunk) chunk;
            System.out.println(internationalChunk.isCompressed());
            System.out.println(internationalChunk.getLanguage());
            System.out.println(internationalChunk.getTranslatedKeyword());
        }
    }
}
```

## Working with XMP metadata

GroupDocs.Metadata for Java allows managing XMP metadata in PNG images. For more details please refer to the following guide: [Working with XMP Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-xmp-metadata.md" >}}).

## Working with EXIF metadata

The GroupDocs.Metadata API supports handling EXIF metadata in PNG images. Please find appropriate code samples in the [Working with EXIF Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-exif-metadata.md" >}}) section.

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
