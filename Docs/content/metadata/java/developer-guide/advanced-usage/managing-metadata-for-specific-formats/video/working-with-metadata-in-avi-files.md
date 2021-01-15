---
id: working-with-metadata-in-avi-files
url: metadata/java/working-with-metadata-in-avi-files
title: Working with metadata in AVI files
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading AVI header properties

The GroupDocs.Metadata API supports extracting format-specific information from AVI file headers.

The following are the steps to read the header of an AVI file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an AVI video
2.  Get the root metadata package
3.  Extract  the native metadata package using the [AviRootPackage.getHeader](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/AviRootPackage#getHeader()) method
4.  Read the AVI header properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>video.avi.AviReadHeaderProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputAvi)) {
    AviRootPackage root = metadata.getRootPackageGeneric();

    System.out.println(root.getHeader().getAviHeaderFlags());
    System.out.println(root.getHeader().getHeight());
    System.out.println(root.getHeader().getWidth());
    System.out.println(root.getHeader().getTotalFrames());
    System.out.println(root.getHeader().getInitialFrames());
    System.out.println(root.getHeader().getMaxBytesPerSec());
    System.out.println(root.getHeader().getPaddingGranularity());
    System.out.println(root.getHeader().getStreams());

    // ...
}
```

## Extract RIFF INFO chunk metadata

The AVI format is derived from the RIFF container which acts as a wrapper for various audio and video coding formats. As a derivative of RIFF, AVI files can be tagged with metadata in the INFO chunk. The chunk may include information such as the title of the work, the author, the creation date, and copyright information. Here is an example of how the RIFF INFO metadata can be extracted:

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>video.avi.AviReadInfoMetadata**

```csharp
try (Metadata metadata = new Metadata(Constants.InputAvi)) {
    AviRootPackage root = metadata.getRootPackageGeneric();
    if (root.getRiffInfoPackage() != null) {
        System.out.println(root.getRiffInfoPackage().getArtist());
        System.out.println(root.getRiffInfoPackage().getComment());
        System.out.println(root.getRiffInfoPackage().getCopyright());
        System.out.println(root.getRiffInfoPackage().getCreationDate());
        System.out.println(root.getRiffInfoPackage().getSoftware());
        System.out.println(root.getRiffInfoPackage().getEngineer());
        System.out.println(root.getRiffInfoPackage().getGenre());
 
        // ...
    }
}
```

## Working with XMP metadata

GroupDocs.Metadata for Java allows managing XMP metadata in AVI files. For more details please refer to the following guide: [Working with XMP Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-xmp-metadata.md" >}}).

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
