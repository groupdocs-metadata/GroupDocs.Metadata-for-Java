---
id: groupdocs-metadata-for-java-18-12-release-notes
url: metadata/java/groupdocs-metadata-for-java-18-12-release-notes
title: GroupDocs.Metadata for Java 18.12 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 18.12.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Add support for password-protected documents
*   Reduce memory consumption of supported Word formats
*   Reduce memory consumption of supported PowerPoint formats
*   Ability to update metadata keys in Doc/Docx file format
*   Remove obsolete members of the Mp3Format class
*   Remove the MppFormat.GetProperties method (obsolete code)

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2462 | Add support for password-protected documents | New Feature |
| METADATANET-2489 | Reduce memory consumption of supported Word formats | Enhancement |
| METADATANET-2424 | Reduce memory consumption of supported PowerPoint formats | Enhancement |
| METADATANET-1436 | Ability to update metadata keys in Doc/Docx file format | Enhancement |
| METADATANET-1519 | Remove obsolete members of the Mp3Format class | Enhancement |
| METADATANET-2463 | Remove the MppFormat.GetProperties method (obsolete code) | Enhancement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 18.12. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Support for password-protected documents

##### Description

This new feature allows a user to work with password-protected documents of some popular formats.

##### Public API changes

The *LoadOptions* class has been added to the *com.groupdocs.metadata* package

The *DocFormat(String, LoadOptions)* constructor has been added to the *DocFormat* class

The *DocFormat(InputStream, LoadOptions)* constructor has been added to the *DocFormat* class

The *PptFormat(String, LoadOptions)* constructor has been added to the *PptFormat* class

The *PptFormat(*InputStream*, LoadOptions)* constructor has been added to the *PptFormat* class

The *XlsFormat(String, LoadOptions)* constructor has been added to the *XlsFormat *class

The *XlsFormat**(*InputStream*, LoadOptions)* constructor has been added to the *XlsFormat *class

The *PdfFormat(String, LoadOptions)* constructor has been added to the *PdfFormat *class

The *PdfFormat**(*InputStream*, LoadOptions)* constructor has been added to the *PdfFormat *class

##### Usecases

Load a password-protected PDF document.

**Java**

```csharp
LoadOptions loadOptions = new LoadOptions("password");
try (PdfFormat format = new PdfFormat("D:\\protected\\input.pdf", loadOptions))
{
    // Working with the password-protected document
    format.cleanMetadata();
    format.save("D:\\protected\\output.pdf");
}
```

Load a password-protected Excel document.

**Java**

```csharp
LoadOptions loadOptions = new LoadOptions("password");
try (XlsFormat format = new XlsFormat("D:\\protected\\input.xlsx", loadOptions))
{
    // Working with the password-protected document
    format.cleanMetadata();
    format.save("D:\\protected\\output.xlsx");
}
```

Load a password-protected PowerPoint document.

**Java**

```csharp
LoadOptions loadOptions = new LoadOptions("password");
try (PptFormat format = new PptFormat("D:\\protected\\input.pptx", loadOptions))
{
    // Working with the password-protected document
    format.cleanMetadata();
    format.save("D:\\protected\\output.pptx");
}
```

Load a password-protected Word document.

**Java**

```csharp
LoadOptions loadOptions = new LoadOptions("password");
try (DocFormat format = new DocFormat("D:\\protected\\input.doc", loadOptions))
{
    // Working with the password-protected document
    format.cleanMetadata();
    format.save("D:\\protected\\output.doc");
}
```

Check if a document is password-protected.

**Java**

```csharp
if (MetadataUtility.isProtected("D:\\protected\\input.doc"))
{
    // Working with the password-protected document
}
```

### Reduced memory consumption of supported Word formats

##### Description

This enhancement allows working with Word documents with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *DocFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (DocFormat format = new DocFormat("d:\\input.docx"))
{
    // Working with metadata
}
```

If you are loading a Word document from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.doc"))
{
    try (DocFormat format = new DocFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.docx"))
{
    try (DocFormat format = new DocFormat("d:\\input.docx"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduced memory consumption of supported PowerPoint formats

##### Description

This enhancement allows working with PowerPoint documents with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *PptFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (PptFormat format = new PptFormat("d:\\input.ppt"))
{
    // Working with metadata
}
```

If you are loading a Word document from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.pptx"))
{
    try (PptFormat format = new PptFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.ppt"))
{
    try (PptFormat format = new PptFormat("d:\\input.ppt"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Ability to update metadata keys in Doc/Docx file format

##### Description

This enhancement allows updating *Words* and *Version* properties of Doc/Docx file formats.

##### Public API changes

None.

##### Usecases

Update the Words and Version metadata keys in doc/docx documents.

**Java**

```csharp
try (DocFormat docFormat = new DocFormat("D:\\input.docx"))
{
    docFormat.getDocumentProperties().setValueByKey("Words", new PropertyValue(1));
    docFormat.getDocumentProperties().setValueByKey("Version", new PropertyValue(851968));
 
    docFormat.save("D:\\output.docx");
}
```

### Removed obsolete members of the Mp3Format class

##### Description

This enhancement removes some obsolete members of the *Mp3Format* class.

##### Public API changes

The *getId3v1* method has been removed from the *Mp3Format*class.

The *getId3v2* method has been removed from the *Mp3Format*class.

##### Usecases

Please use the g*etId3v1Tag* and *getId3v2Tag* methods instead.

**Java**

```csharp
try (Mp3Format format = new Mp3Format("D:\\input.mp3"))
{
    Id3v1Tag id3v1 = format.getId3v1Tag();
    System.out.println(id3v1.getAlbum());
    System.out.println(id3v1.getArtist());
 
    Id3v2Tag id3v2 = format.getId3v2Tag();
    System.out.println(id3v2.getAlbum());
    System.out.println(id3v2.getArtist());
} 
```

### Removed the MppFormat.GetProperties method (obsolete code)

##### Description

This enhancement removes some obsolete members of the *MppFormat* class.

##### Public API changes

The g*etProjectProperties *method has been removed from the *MppFormat* class.

##### Usecases

Please use the *MppFormat.getProjectInfo* method instead.

**Java**

```csharp
try (MppFormat format = new MppFormat("D:\\input.mpp"))
{
    System.out.println(format.getProjectInfo().getAuthor());
    System.out.println(format.getProjectInfo().getLastAuthor());
    System.out.println(format.getProjectInfo().getCompany());
} 
```
