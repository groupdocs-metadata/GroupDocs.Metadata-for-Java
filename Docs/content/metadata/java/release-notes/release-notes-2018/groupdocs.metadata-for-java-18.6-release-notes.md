---
id: groupdocs-metadata-for-java-18-6-release-notes
url: metadata/java/groupdocs-metadata-for-java-18-6-release-notes
title: GroupDocs.Metadata for Java 18.6 Release Notes
weight: 6
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 18.6.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Implement the ability to edit XMP metadata in WAV files
*   Implement the ability to update properties of the Microsoft Project format
*   Reduce memory consumption of MPP format metadata loading and saving
*   Reduce memory consumption of WAV format metadata loading and saving
*   Reduce memory consumption of AVI format metadata loading and saving

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2333 | Implement the ability to edit XMP metadata in WAV files  | New Feature   |
| METADATANET-1168  | Implement the ability to update properties of the Microsoft Project format  | New Feature  |
| METADATANET-2334 | Reduce memory consumption of MPP format metadata loading and saving | Enhancement   |
| METADATANET-2332 | Reduce memory consumption of WAV format metadata loading and saving | Enhancement  |
| METADATANET-2297 | Reduce memory consumption of AVI format metadata loading and saving  | Enhancement  |
| METADATANET-2303 | TiffFormat.RemoveXmpData() turns Tiff Image into black  | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 18.6. It includes not only new and obsoleted public methods, but also a description of any changes in the behaviour behind the scenes in GroupDocs.Metadata which may affect existing code. Any behaviour introduced that could be seen as a regression and modifies existing behaviour is especially important and is documented here.{{< /alert >}}

### Implement the ability to edit XMP metadata in WAV files 

##### Description

This feature allows a user to read and update XMP metadata in WAV files

##### Public API changes

The *WavFormat* class now implements the *IXmp* interface.

##### Usecases

Read and write XMP metadata.

**Java**

```csharp
try (WavFormat format = new WavFormat("D:\\input.wav"))
{
    System.out.println(format.getXmpValues().getSchemes().getXmpBasic().getCreateDate());
    System.out.println(format.getXmpValues().getSchemes().getXmpBasic().getLabel());
    System.out.println(format.getXmpValues().getSchemes().getDublinCore().getSubject());
    System.out.println(format.getXmpValues().getSchemes().getDublinCore().getFormat());

    format.getXmpValues().getSchemes().getXmpBasic().setCreateDate(new Date());
    format.getXmpValues().getSchemes().getXmpBasic().setLabel("Test");
    format.getXmpValues().getSchemes().getDublinCore().setSubject("WAV XMP Test");
    format.getXmpValues().getSchemes().getDublinCore().setFormat("WAV Audio");

    format.save("D:\\output.wav");
}
```

Remove XMP metadata.

**Java**

```csharp
try (WavFormat format = new WavFormat("D:\\input.wav"))
{
    format.removeXmpData();
    format.save("D:\\output.wav");
}
```

### Implement the ability to update properties of the Microsoft Project format

##### Description

This feature allows a user to update metadata properties of an MPP file.

##### Public API changes

The *MppFormat.getProjectProperties* method has been marked as obsolete.  
A new *getProjectInfo* method has been added to the *MppFormat* class.

##### Usecases

Use public properties (methods in Java) of *MppMetadata* to update metadata values.

**Java**

```csharp
try (MppFormat format = new MppFormat("D:\\input.mpp"))
{
    format.getProjectInfo().setAuthor("John Smith");
    format.getProjectInfo().setSubject("Test project");
    format.getProjectInfo().setCategory("Software Development");

    format.save("D:\\output.mpp");
}
```

Clean metadata.

**Java**

```csharp
try (MppFormat format = new MppFormat("D:\\input.mpp"))
{
    format.cleanMetadata();
    format.save("D:\\output.mpp");
}
```

### Reduce memory consumption of MPP format metadata loading and saving

##### Description

This enhancement allows working with MPP files with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *MppFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (MppFormat format = new MppFormat("d:\\input.mpp"))
{
    // Working with metadata
}
```

If you are loading an MPP file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.mpp"))
{
    try (MppFormat format = new MppFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.mpp"))
{
    try (MppFormat format = new MppFormat("d:\\input.mpp"))
    {
        // Working with metadata

        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduce memory consumption of WAV format metadata loading and saving

##### Description

This enhancement allows working with WAV files with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *WavFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (WavFormat format = new WavFormat("d:\\input.wav"))
{
    // Working with metadata
}
```

If you are loading a WAV file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.wav"))
{
    try (WavFormat format = new WavFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.wav"))
{
    try (WavFormat format = new WavFormat("d:\\input.wav"))
    {
        // Working with metadata

        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduce memory consumption of AVI format metadata loading and saving

##### Description

This enhancement allows working with AVI files with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *AviFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (AviFormat format = new AviFormat("d:\\input.avi"))
{
    // Working with metadata
}
```

If you are loading an AVI file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.avi"))
{
    try (AviFormat format = new AviFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.avi"))
{
    try (AviFormat format = new AviFormat("d:\\input.avi"))
    {
        // Working with metadata

        format.save(stream);
    }
    // The stream is still open here
}
```

### TiffFormat.RemoveXmpData() turns Tiff Image into black 

##### Description

In earlier versions of API, after removing XMP data from Tiff image turns the image to black.

##### Public API changes

None.

##### Usecases

Remove XMP metadata.

**Java**

```csharp
// initialize TiffFormat
try (TiffFormat tiffFormat = new TiffFormat("D:\\input.tif"))
{
    //remove Xmp Properties
    tiffFormat.removeXmpData();

    // commit changes and save output file
    tiffFormat.save("D:\\output.tif");
}
```
