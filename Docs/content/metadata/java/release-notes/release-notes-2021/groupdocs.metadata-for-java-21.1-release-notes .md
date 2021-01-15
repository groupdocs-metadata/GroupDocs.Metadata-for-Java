---
id: groupdocs-metadata-for-java-21-1-release-notes
url: metadata/java/groupdocs-metadata-for-java-21-1-release-notes
title: GroupDocs.Metadata for Java 21.1 Release Notes
weight: 12
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 21.1{{< /alert >}}

## Major Features

  
There are the following features, enhancements and fixes in this release:

*   Implement the ability to extract content statistics from OneNote documents
*   Implement the ability to extract INFO chunk metadata from all formats derived from the RIFF container (AVI, WAV)
*   Attempted to divide by zero.
*   Input string was not in a correct format.

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2841 | Implement the ability to extract content statistics from OneNote documents                                          | New Feature |
| METADATANET-2853 | Implement the ability to extract INFO chunk metadata from all formats derived from the RIFF container (AVI, WAV)    | New Feature |
| METADATANET-3660 | Attempted to divide by zero.                                                                                        | Bug         |
| METADATANET-3661 | Input string was not in a correct format.                                                                  		 | Bug         |



## Public API and Backward Incompatible Changes

### Implement the ability to extract content statistics from OneNote documents

This new feature allows the user to extract content statistics from OneNote documents

##### Public API changes 

The [getDocumentStatistics](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/NoteRootPackage#getDocumentStatistics()) method has been added to the [NoteRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/NoteRootPackage) class


##### Use cases 

Extract document statistics from a OneNote document

```java
try (Metadata metadata = new Metadata(Constants.InputOne)) {
    NoteRootPackage root = metadata.getRootPackageGeneric();
    System.out.println(root.getDocumentStatistics().getCharacterCount());
    System.out.println(root.getDocumentStatistics().getPageCount());
    System.out.println(root.getDocumentStatistics().getWordCount());
}
```

### Implement the ability to extract INFO chunk metadata from all formats derived from the RIFF container (AVI, WAV)

This new feature allows the user to extract INFO chunk metadata properties from all supported formats derived from the RIFF container (AVI, WAV)

##### Public API changes 

The [RiffInfoPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/RiffInfoPackage) class has been added to the [com.groupdocs.metadata.core](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/package-frame) package

The [getRiffInfoPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/WavRootPackage#getRiffInfoPackage()) method has been added to the [WavRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/WavRootPackage) class

The [getRiffInfoPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/AviRootPackage#getRiffInfoPackage()) property has been added to the [AviRootPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/AviRootPackage) class


##### Use cases 

Extract RIFF INFO properties from a WAV audio

```java
try (Metadata metadata = new Metadata(Constants.InputWav)) {
    // The same code snippet will work for AVI files as well. 
    // You just need to convert the metadata root package to the appropriate type (use AviRootPackage instead of WavRootPackage in the line below)
    WavRootPackage root = metadata.getRootPackageGeneric();
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
