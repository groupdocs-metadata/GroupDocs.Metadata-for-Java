---
id: groupdocs-metadata-for-java-18-4-release-notes
url: metadata/java/groupdocs-metadata-for-java-18-4-release-notes
title: GroupDocs.Metadata for Java 18.4 Release Notes
weight: 8
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 18.4{{< /alert >}}

## Major Features

There are the following features and fixes in this release:

*   BitTorrent format support
*   Implement unified DublinCore metadata reader for EPUB, DOCX, PDF
*   Implement unified approach of getting image cover across all formats (EPUB, MP3, Word, Excel)

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-592 | Implement BitTorrent format support  | New Feature |
| METADATANET-2101   | Implement unified DublinCore metadata reader for EPUB, DOCX, PDF   | New Feature  |
| METADATANET-2221 | Implement unified approach of getting image cover across all formats (EPUB, MP3, Word, Excel)  | New Feature  |
| METADATANET-1976 | GIF and PNG file's size increases after removing metadata  | Bug |
| METADATANET-2169 | The JpegFormat() method in GroupDocs.Metadata.dll isn't safe on MTA  | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 18.4. It includes not only new and obsoleted public methods, but also a description of any changes in the behaviour behind the scenes in GroupDocs.Metadata which may affect existing code. Any behaviour introduced that could be seen as a regression and modifies existing behaviour is especially important and is documented here.{{< /alert >}}

#### Implement BitTorrent format support 

##### Description

Implement ability to read and write metadata of torrent files.

##### Public API changes

*TorrentFormat* class has been added to *com.groupdocs.metadata* package.  
*TorrentMetadata* class has been added to *com.groupdocs.metadata* package.  
*TorrentFileInfo* class has been added to *com.groupdocs.metadata* package.  
*Torrent* constant has been added to *DocumentType* class.  
*Torrent* constant has been added to *MetadataType* class.

##### Usecases

Read metadata of a torrent file.

**Java**

```csharp
TorrentFormat torrentFormat = new TorrentFormat("D:\\input.torrent");

TorrentMetadata info = torrentFormat.getTorrentInfo();
System.out.println(info.getAnnounce());
System.out.println(info.getCreatedBy());
System.out.println(info.getCreationDate());
System.out.println(info.getComment());
System.out.println(info.getPieceLength());
System.out.println(info.getPieces().length);

for (TorrentFileInfo file : info.getSharedFiles())
{
    System.out.println(file.getName());
    System.out.println(file.getLength());
}

torrentFormat.dispose();
```

Set some properties of torrent file metadata.

**Java**

```csharp
TorrentFormat torrentFormat = new TorrentFormat("D:\\input.torrent");

TorrentMetadata info = torrentFormat.getTorrentInfo();

info.setComment("test comment");
info.setCreatedBy("test application");
info.setCreationDate(new Date());

torrentFormat.save("D:\\output.torrent");

torrentFormat.dispose();
```

#### Implement unified DublinCore metadata reader for EPUB, DOCX, PDF  

##### Description

Implement ability to read DublinCore metadata from EPUB, DOCX and PDF files in a unified manner.

##### Public API changes

None.

##### Usecases

Read DublinCore metadata using MetadataUtility class.

**Java**

```csharp
DublinCoreMetadata dublinCoreMetadata = (DublinCoreMetadata)MetadataUtility.extractSpecificMetadata("D:\\input.docx", MetadataType.DublinCore);
```

### Implement unified approach of getting image cover across all formats (EPUB, MP3, Word, Excel) 

##### Description

Implement ability to read thumbnail (image cover) from EPUB, MP3, Word and Excel files in a unified manner.

##### Public API changes

*Thumbnail* constant has been added to *MetadataType* class.  
*ThumbnailMetadata* class has been added to *com.groupdocs.metadata* package.

##### Usecases

Read Thumbnail metadata using MetadataUtility class.

**Java**

```csharp
ThumbnailMetadata thumbnailMetadata = (ThumbnailMetadata)MetadataUtility.extractSpecificMetadata("D:\\input.docx", MetadataType.Thumbnail);

System.out.println(thumbnailMetadata.getMimeType());
System.out.println(thumbnailMetadata.getImageData().length);
```

### GIF and PNG file's size increases after removing metadata   

##### Description

After removing metadata from Gif and PNG file formats, file size increases.

##### Public API changes

None.

##### Usecases

In some cases, it is necessary to remove some specific values from XMP metadata package associated with GIF or PNG images. In previous versions of GroupDocs.Metadata this might cause unexpected increasing of the file size. Starting from version 18.4 please use the following code snippet to avoid the issue.

**Java**

```csharp
GifFormat format = new GifFormat("D:\\input.gif");

XmpEditableCollection xmpEditableCollection = format.getXmpValues();
XmpSchemes schemes = xmpEditableCollection.getSchemes();

schemes.getDublinCore().setSource(null);
schemes.getDublinCore().setSubject((String)null);

schemes.getPdf().setKeywords(null);
schemes.getPdf().setProducer(null);

schemes.getPhotoshop().setCity(null);
schemes.getPhotoshop().setCountry(null);

schemes.getXmpBasic().setBaseUrl(null);
schemes.getXmpBasic().setNickname(null);

format.save("D:\\output.gif");
format.dispose();
```

Please note that it's necessary to use null values (not empty strings) to completely remove appropriate XMP fields from the package.

### The JpegFormat() method in GroupDocs.Metadata.dll isn't safe on MTA 

##### Description

Creating instances of JpegFormat class is now safe when running in multiple threads. Please note that you still can't process single JPEG file using different instances of JpegFormat at the same time.

##### Public API changes

None.

##### Usecases

None.
