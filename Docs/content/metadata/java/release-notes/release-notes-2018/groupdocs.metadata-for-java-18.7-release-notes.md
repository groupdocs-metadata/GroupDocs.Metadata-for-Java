---
id: groupdocs-metadata-for-java-18-7-release-notes
url: metadata/java/groupdocs-metadata-for-java-18-7-release-notes
title: GroupDocs.Metadata for Java 18.7 Release Notes
weight: 5
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 18.7.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Implement the ability to update IPTC metadata in a PSD file
*   Reduce memory consumption of the PSD format
*   Reduce memory consumption of the Mp3 format

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-1175 | Implement the ability to update IPTC metadata in a PSD file | New Feature   |
| METADATANET-2375  | Reduce memory consumption of the PSD format  | Enhancement |
| METADATANET-2305 | Reduce memory consumption of the Mp3 format  | Enhancement   |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 18.7. It includes not only new and obsoleted public methods, but also a description of any changes in the behaviour behind the scenes in GroupDocs.Metadata which may affect existing code. Any behaviour introduced that could be seen as a regression and modifies existing behaviour is especially important and is documented here.{{< /alert >}}

### Implement the ability to update IPTC metadata in a PSD file 

##### Description

This enhancement allows a user to remove and update IPTC metadata in PSD files

##### Public API changes

The *IIptc* interface has been implemented in the *PsdFormat* class  
The *updateIptc(IptcCollection)* method has been added to the *PsdFormat* class  
The *updateIptc(IptcDataSet)* method has been added to the *PsdFormat* class  
The *removeIptc* method has been added to the *PsdFormat* class

##### Usecases

Update IPTC metadata.

**C#**

```csharp
try (PsdFormat format = new PsdFormat("D:\\input.psd"))
{
    IptcCollection iptc = format.getIptc();
    if (iptc == null)
    {
        iptc = new IptcCollection();
    }
    iptc.add(new IptcProperty(2, "urgency", 10, 5));
    format.updateIptc(iptc);
    format.save("D:\\output.psd");
}
```

Remove IPTC metadata.

**C#**

```csharp
try (PsdFormat format = new PsdFormat("D:\\input.psd"))
{
    format.removeIptc();
    format.save("D:\\output.psd");
}
```

### Reduce memory consumption of the PSD format

##### Description

This enhancement allows working with PSD files with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *PsdFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (PsdFormat format = new PsdFormat("d:\\input.psd"))
{
    // Working with metadata
}
```

If you are loading a PSD file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.psd"))
{
    try (PsdFormat format = new PsdFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.psd"))
{
    try (PsdFormat format = new PsdFormat("d:\\input.psd"))
    {
        // Working with metadata

        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduce memory consumption of the Mp3 format

##### Description

This enhancement allows working with mp3 files with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *Mp3Format* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (Mp3Format format = new Mp3Format("d:\\input.mp3"))
{
    // Working with metadata
}
```

If you are loading an mp3 file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.mp3"))
{
    try (Mp3Format format = new Mp3Format(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.mp3"))
{
    try (Mp3Format format = new Mp3Format("d:\\input.mp3"))
    {
        // Working with metadata

        format.save(stream);
    }
    // The stream is still open here
}
```
