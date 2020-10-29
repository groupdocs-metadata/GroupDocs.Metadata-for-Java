---
id: groupdocs-metadata-for-java-20-11-release-notes
url: metadata/java/groupdocs-metadata-for-java-20-11-release-notes
title: GroupDocs.Metadata for Java 20.11 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 20.11{{< /alert >}}

## Major Features

  
There are the following features, enhancements and fixes in this release:

*   Implement the ability to extract text data chunks from PNG images
*   "DXF version is not valid" exception when reading DXF file
*   Exception: Cannot process loading further due to incorrect file format structure
*   Exception: File is incompatible with exporter
*   Loading process freezes on a damaged file
*   Image loading failed

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-3473 | Implement the ability to extract text data chunks from PNG images                   | New Feature |
| METADATANET-3286 | "DXF version is not valid" exception when reading DXF file                 		 | Bug         |
| METADATANET-3313 | Exception: Cannot process loading further due to incorrect file format structure    | Bug         |
| METADATANET-3334 | Exception: File is incompatible with exporter                              		 | Bug         |
| METADATANET-3385 | Loading process freezes on a damaged file                                           | Bug         |
| METADATANET-3476 | Image loading failed                                          						 | Bug         |




## Public API and Backward Incompatible Changes

### Implement the ability to extract text data chunks from PNG images

This new feature allows the user to extract chunks of textual data from PNG images

##### Public API changes 

The [PngTextChunk](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PngTextChunk) class has been added to the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/package-frame) package

The [PngCompressedTextChunk](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PngCompressedTextChunk) class has been added to the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/package-frame) package

The [PngInternationalTextChunk](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PngInternationalTextChunk) class has been added to the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/package-frame) package

The [PngPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PngPackage) class has been added to the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/package-frame) package

The [PngCompressionMethod](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PngCompressionMethod) class has been added to the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/package-frame) package

The [getPngPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PngRootPackage#getPngPackage()) method has been added to the [PngRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/PngRootPackage) class



##### Use cases 

Extract chunks of textual metadata from a PNG image

```java
try (Metadata metadata = new Metadata("D:\\input.png")) {
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
