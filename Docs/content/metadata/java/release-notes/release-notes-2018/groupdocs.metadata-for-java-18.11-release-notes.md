---
id: groupdocs-metadata-for-java-18-11-release-notes
url: metadata/java/groupdocs-metadata-for-java-18-11-release-notes
title: GroupDocs.Metadata for Java 18.11 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 18.11.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Reduce memory consumption of the PDF format
*   Reduce memory consumption of supported Excel formats
*   XlsFormat: Add support for missing metadata properties
*   Implement the ability to work with metadata stored in FLV files

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-1640 | Reduce memory consumption of the PDF format | Enhancement |
| METADATANET-2422 | Reduce memory consumption of supported Excel formats | Enhancement |
| METADATANET-2436 | XlsFormat: Add support for missing metadata properties | Enhancement |
| METADATANET-470 | Implement the ability to work with metadata stored in FLV files | New Feature |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 18.11. It includes not only new and obsoleted public methods, but also a description of any changes in the behaviour behind the scenes in GroupDocs.Metadata which may affect existing code. Any behaviour introduced that could be seen as a regression and modifies existing behaviour is especially important and is documented here.{{< /alert >}}

### Reduce memory consumption of the PDF format

##### Description

This enhancement allows working with PDF documents with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *PdfFormat* class implements the *IDisposable* interface and it's necessary to call the *Dispose()* method when you're done working with its instance.

**Java**

```csharp
try (PdfFormat format = new PdfFormat("d:\\input.pdf"))
{
    // Working with metadata
}
```

If you are loading a PDF file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.pdf"))
{
    try (PdfFormat format = new PdfFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.pdf"))
{
    try (PdfFormat format = new PdfFormat("d:\\input.pdf"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduce memory consumption of the Excel formats

##### Description

This enhancement allows working with Excel documents with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *XlsFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (XlsFormat format = new XlsFormat("d:\\input.xlsx"))
{
    // Working with metadata
}
```

If you are loading an Excel document from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.xls"))
{
    try (XlsFormat format = new XlsFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.xlsx"))
{
    try (XlsFormat format = new XlsFormat("d:\\input.xlsx"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Add support for missing properties in XlsFormat format

##### Description

This enhancement adds some new metadata properties to the XlsMetadata class.

##### Public API changes

The *getLanguage* method has been added to the *XlsMetadata* class

The s*etLanguage* method has been added to the *XlsMetadata* class

The *setContentStatus* method has been added to the *XlsMetadata* class

The *setContentType* method has been added to the *XlsMetadata* class

The *setCreatedTime* method has been added to the *XlsMetadata* class

The *getTotalEditingTime* method has been added to the *XlsMetadata* class

The s*etTotalEditingTime* method has been added to the *XlsMetadata* class

The *getLastSavedTime* method has been added to the *XlsMetadata* class

The s*etLastSavedTime* method has been added to the *XlsMetadata* class

The *setLastPrintedDate* method has been added to the *XlsMetadata* class

The *setLastSavedBy* method has been added to the *XlsMetadata* class

The *XlsMetadata.getRevisionNumber*method has been marked as deprecated

The *getRevision* method has been added to the *XlsMetadata* class

The *setRevision* method has been added to the *XlsMetadata* class

The *setVersion* method has been added to the *XlsMetadata* class

##### Usecases

Get and set Excel metadata properties

**Java**

```csharp
try (XlsFormat format = new XlsFormat("D:\\input.xlsx"))
{
    // Get the current values
    System.out.println(format.getDocumentProperties().getLanguage());
    System.out.println(format.getDocumentProperties().getContentStatus());
    System.out.println(format.getDocumentProperties().getContentType());
    System.out.println(format.getDocumentProperties().getCreatedTime());
    System.out.println(format.getDocumentProperties().getTotalEditingTime());
    System.out.println(format.getDocumentProperties().getLastSavedTime());
    System.out.println(format.getDocumentProperties().getLastPrintedDate());
    System.out.println(format.getDocumentProperties().getLastSavedBy());
    System.out.println(format.getDocumentProperties().getRevision());
    System.out.println(format.getDocumentProperties().getVersion());
 
    // Update the metadata properties
    format.getDocumentProperties().setLanguage("test language");
    format.getDocumentProperties().setContentStatus("test content status");
    format.getDocumentProperties().setContentType("test content type");
    format.getDocumentProperties().setCreatedTime(new Date());
    format.getDocumentProperties().setTotalEditingTime(100);
    format.getDocumentProperties().setLastSavedTime(new Date());
    format.getDocumentProperties().setLastPrintedDate(new Date());
    format.getDocumentProperties().setLastSavedBy("test last saved by");
    format.getDocumentProperties().setRevision("test revision");
    format.getDocumentProperties().setVersion("12.1111");
 
    format.save("D:\\output.xlsx");
}
```

### Implement the ability to work with metadata stored in FLV files

##### Description

This new feature allows a user to work with metadata stored in FLV files.

##### Public API changes

The *FlvFormat* class has been added to the *com.groupdocs.metadata* package

The *FlvHeader* class has been added to the *com.groupdocs.metadata* package

The *Flv* constant has been added to the *DocumentType* class

The *Flv* constant has been added to the *MetadataType* class

##### Usecases

Check whether a file is an FLV video.

**Java**

```csharp
try (FileFormatChecker checker = new FileFormatChecker("D:\\input.unknown"))
{
    if (checker.getDocumentType() == DocumentType.Flv)
    {
        // The file is an FLV video
    }
}
```

Read and write XMP metadata.

**Java**

```csharp
try (FlvFormat format = new FlvFormat("D:\\input.flv"))
{
    System.out.println(format.getXmpValues().getSchemes().getXmpBasic().getCreateDate());
    System.out.println(format.getXmpValues().getSchemes().getXmpBasic().getLabel());
    System.out.println(format.getXmpValues().getSchemes().getDublinCore().getSource());
    System.out.println(format.getXmpValues().getSchemes().getDublinCore().getFormat());
 
    format.getXmpValues().getSchemes().getXmpBasic().setCreateDate(new Date());
    format.getXmpValues().getSchemes().getXmpBasic().setLabel("Test");
    format.getXmpValues().getSchemes().getDublinCore().setSource("http://groupdocs.com");
    format.getXmpValues().getSchemes().getDublinCore().setFormat("FLV Video");
 
    format.save("D:\\output.flv");
}
```

Remove XMP metadata.

**Java**

```csharp
try (FlvFormat format = new FlvFormat("D:\\input.flv"))
{
    format.removeXmpData();
    format.save("D:\\output.flv");
}
```

Read FLV header metadata.

**Java**

```csharp
try (FlvFormat format = new FlvFormat("D:\\input.flv"))
{
    System.out.println(format.getHeader().getVersion());
    System.out.println(format.getHeader().hasVideoTags());
    System.out.println(format.getHeader().hasAudioTags());
    System.out.println(Integer.toBinaryString(format.getHeader().getTypeFlags()));
}
```
