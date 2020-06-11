---
id: groupdocs-metadata-for-java-18-10-release-notes
url: metadata/java/groupdocs-metadata-for-java-18-10-release-notes
title: GroupDocs.Metadata for Java 18.10 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 18.10.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Implement the ability to update Lyrics3 tags
*   Remove MetadataUtility obsolete methods
*   Reduce memory consumption of the PNG format
*   Reduce memory consumption of the JPEG2000 format
*   Reduce memory consumption of the BMP, DICOM, DJVU, EMF, WEBP and WMF formats

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-383 | Implement the ability to update Lyrics3 tags | New Feature |
| METADATANET-1466 | Remove MetadataUtility obsolete methods | Enhancement |
| METADATANET-1608 | Reduce memory consumption of the PNG format | Enhancement |
| METADATANET-1632 | Reduce memory consumption of the JPEG2000 format | Enhancement |
| METADATANET-1633 | Reduce memory consumption of the BMP, DICOM, DJVU, EMF, WEBP and WMF formats | Enhancement |
| METADATANET-1045 | Exception when cleaning/updating metadata of Strict Open XML Presentation (.pptx) | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 18.10. It includes not only new and obsoleted public methods, but also a description of any changes in the behaviour behind the scenes in GroupDocs.Metadata which may affect existing code. Any behaviour introduced that could be seen as a regression and modifies existing behaviour is especially important and is documented here.{{< /alert >}}

### Implement the ability to update Lyrics3 tags

##### Description

This new feature allows a user to update Lyrics3v2 metadata in Mp3 files.

##### Public API changes

A public constructor has been added to the *Lyrics3Field* class

The *getLyrics3v2Properties* method has been added to the *Mp3Format* class

The *Mp3Format*.*getLyrics3v2* method has been marked as deprecated

The *updateLyrics3v2(Lyrics3Tag)* method has been added to the *Mp3Format* class

##### Usecases

Update Lyrics3v2 metadata using the shortcut properties.

**Java**

```csharp
try (Mp3Format format = new Mp3Format("D:\\input.mp3"))
{
    format.getLyrics3v2Properties().setAlbum("test album");
    format.getLyrics3v2Properties().setArtist("test artist");
    format.getLyrics3v2Properties().setAdditionalInfo("test info");
    format.getLyrics3v2Properties().setLyrics("[00:01] test lyrics");
    format.save("D:\\output.mp3");
}
```

Update Lyrics3v2 metadata by replacing the whole field collection.

**Java**

```csharp
try (Mp3Format format = new Mp3Format("D:\\input.mp3"))
{
    Lyrics3Field[] fields = new Lyrics3Field[]
    {
        new Lyrics3Field("EAL", "test album"),
        new Lyrics3Field("EAR", "test artist"),
        new Lyrics3Field("INF", "test info"),
        new Lyrics3Field("LYR", "[00:01] test lyrics"),
    };
 
    format.getLyrics3v2Properties().setFields(fields);
    format.save("D:\\output.mp3");
}
```

Update Lyrics3v2 metadata by replacing the whole tag.

**Java**

```csharp
try (Mp3Format format = new Mp3Format("D:\\input.mp3"))
{
    Lyrics3Tag tag = new Lyrics3Tag();
    tag.setFields(new Lyrics3Field[]
    {
        new Lyrics3Field("EAL", "test album"),
        new Lyrics3Field("EAR", "test artist"),
        new Lyrics3Field("INF", "test info"),
        new Lyrics3Field("LYR", "[00:01] test lyrics"),
    });
    format.updateLyrics3v2(tag);
    format.save("D:\\output.mp3");
}
```

### Remove MetadataUtility obsolete methods

##### Description

This enhancement removes some obsolete members of the *MetadataUtility* class.

##### Public API changes

The *compareDoc* method has been removed form the *MetadataUtility *class

The *comparePdf *method has been removed form the *MetadataUtility *class

The *comparePpt *method has been removed form the *MetadataUtility *class

The *compareXls *method has been removed form the *MetadataUtility *class

##### Usecases

Please use the *ComparisonFacade.CompareDocuments* (*ComparisonFacade.compareDocuments *in Java) method instead.

**Java**

```csharp
MetadataPropertyCollection diff = ComparisonFacade.compareDocuments("D:\\input1.pptx", "D:\\input2.pptx", ComparerSearchType.Difference);
for (int i = 0; i < diff.getCount(); i++)
{
    MetadataProperty property = diff.readByIndex(i);
    System.out.println("Property name: " + property.getName() + ", value: " + property.getValue());
}
```

### Reduce memory consumption of the PNG format

##### Description

This enhancement allows working with PNG images with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *PngFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance

**Java**

```csharp
try (PngFormat format = new PngFormat("d:\\input.png"))
{
    // Working with metadata
}
```

If you are loading a PNG file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.png"))
{
    try (PngFormat format = new PngFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.png"))
{
    try (PngFormat format = new PngFormat("d:\\input.png"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduce memory consumption of the JPEG2000 format

##### Description

This enhancement allows working with JPEG2000 images with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *Jp2Format* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance

**Java**

```csharp
try (Jp2Format format = new Jp2Format("d:\\input.jp2"))
{
    // Working with metadata
}
```

If you are loading a JPEG2000 file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.jp2"))
{
    try (Jp2Format format = new Jp2Format(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.jp2"))
{
    try (Jp2Format format = new Jp2Format("d:\\input.jp2"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduce memory consumption of the  BMP, DICOM, DJVU, EMF, WEBP and WMF formats

##### Description

This enhancement allows working with BMP, DICOM, DJVU, EMF, WEBP and WMF images with less memory consumption

##### Public API changes

None.

##### Usecases

Please note that all classes representing the mentioned formats implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance

**Java**

```csharp
try (DICOMFormat format = new DICOMFormat("d:\\input.dicom"))
{
    // Working with metadata
}
```

If you are loading an image file of the appropriate format from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.emf"))
{
    try (EmfFormat format = new EmfFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.wmf"))
{
    try (WmfFormat format = new WmfFormat("d:\\input.wmf"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Exception when cleaning/updating metadata of Strict Open XML Presentation (.pptx)

##### Description

This enhancement allows cleaning/updating metadata of Strict Open XML Presentation(.pptx) document.

##### Public API changes

None.

##### Usecases

Clean metadata of a strict open XML presentation.

**Java**

```csharp
try (PptFormat pptFormat = new PptFormat("D:\\SOXmlPresentation.pptx"))
{
    pptFormat.cleanMetadata();
    pptFormat.save("D:\\SOXmlPresentation_output.pptx");
}
```

Update metadata of a strict open XML presentation.

**Java**

```csharp
try (PptFormat pptFormat = new PptFormat("D:\\SOXmlPresentation.pptx"))
{
    PptMetadata pptMetadata = pptFormat.getDocumentProperties();
    pptMetadata.setTitle("usman");
    pptFormat.save("D:\\SOXmlPresentation_output.pptx");
}
```
