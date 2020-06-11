---
id: groupdocs-metadata-for-java-19-2-release-notes
url: metadata/java/groupdocs-metadata-for-java-19-2-release-notes
title: GroupDocs.Metadata for Java 19.2 Release Notes
weight: 5
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 19.2.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Implement support for the ASF format
*   Refactor base metadata classes to add support for hierarchical metadata structures
*   Remove obsolete EXIF APIs
*   Remove Mp3Format obsolete members

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-1635 | Implement support for the ASF format | New Feature |
| METADATANET-1369 | Refactor base metadata classes to add support for hierarchical metadata structures | Enhancement |
| METADATANET-2636 | Remove obsolete EXIF APIs | Enhancement |
| METADATANET-1636 | Remove Mp3Format obsolete members | Enhancement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 19.2. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Implement support for the ASF format

This new feature allows a user to work with multimedia files encoded with the ASF container

**Public API changes**

The *AsfAudioStreamProperty* class has been added to the *com.groupdocs.metadata* package

The *AsfBaseDescriptor *class has been added to the *com.groupdocs.metadata* package

The *AsfBaseStreamProperty *class has been added to the *com.groupdocs.metadata* package

The *AsfCodecInfo *class has been added to the *com.groupdocs.metadata* package

The *AsfContentDescriptor *class has been added to the *com.groupdocs.metadata* package

The *AsfFormat *class has been added to the *com.groupdocs.metadata* package

The *AsfMetadata *class has been added to the *com.groupdocs.metadata* package

The *AsfMetadataDescriptor *class has been added to the *com.groupdocs.metadata* package

The *AsfVideoStreamProperty *class has been added to the *com.groupdocs.metadata* package

The *AsfCodecType *class has been added to the *com.groupdocs.metadata* package

The *AsfDescriptorType *class has been added to the *com.groupdocs.metadata* package

The *AsfExtendedStreamPropertiesFlags *class has been added to the *com.groupdocs.metadata* package

The *AsfFilePropertiesFlag *classhas been added to the *com.groupdocs.metadata* package

The *AsfStreamType *class has been added to the *com.groupdocs.metadata* package

The *Asf* public static field has been added to the *MetadataType* class

The *Asf* public static field has been added to the *DocumentType* class

##### Use cases

Read ASF video native metadata

**Java**

```csharp
try (AsfFormat format = new AsfFormat("D:\\input.asf"))
{
    AsfMetadata metadata = format.getAsfInfo();
    System.out.println(metadata.getCreationDate());
    System.out.println(metadata.getFileId());
    System.out.println(metadata.getFlags());

    for (AsfCodecInfo codecInfo : metadata.getCodecInformation())
    {
        System.out.println(codecInfo.getCodecType());
        System.out.println(codecInfo.getDescription());
        System.out.println(codecInfo.getInformation());
        System.out.println(codecInfo.getName());
    }

    for (AsfBaseDescriptor descriptor : metadata.getMetadataDescriptors())
    {
        System.out.println(descriptor.getName());
        System.out.println(descriptor.getFormattedValue());
        
        if (descriptor instanceof AsfMetadataDescriptor)
        {
            AsfMetadataDescriptor metadataDescriptor = (AsfMetadataDescriptor)descriptor;
            System.out.println(metadataDescriptor.getLanguage());
            System.out.println(metadataDescriptor.getStreamNumber());
            System.out.println(metadataDescriptor.getOriginalName());
        }
    }

    for (AsfBaseStreamProperty property : metadata.getStreamProperties())
    {
        System.out.println(property.getAlternateBitrate());
        System.out.println(property.getAverageBitrate());
        System.out.println(property.getAverageTimePerFrame());
        System.out.println(property.getBitrate());
        System.out.println(property.getEndTime());
        System.out.println(property.getFlags());
        System.out.println(property.getLanguage());
        System.out.println(property.getStartTime());
        System.out.println(property.getStreamNumber());
        System.out.println(property.getStreamType());

        if (property instanceof AsfAudioStreamProperty)
        {
            AsfAudioStreamProperty audioStreamProperty = (AsfAudioStreamProperty)property;
            System.out.println(audioStreamProperty.getBitsPerSample());
            System.out.println(audioStreamProperty.getChannels());
            System.out.println(audioStreamProperty.getFormatTag());
            System.out.println(audioStreamProperty.getSamplesPerSecond());
        }

        if (property instanceof AsfVideoStreamProperty)
        {
            AsfVideoStreamProperty videoStreamProperty = (AsfVideoStreamProperty)property;
            System.out.println(videoStreamProperty.getBitsPerPixels());
            System.out.println(videoStreamProperty.getCompression());
            System.out.println(videoStreamProperty.getImageHeight());
            System.out.println(videoStreamProperty.getImageWidth());
        }
    }
}
```

Read and write XMP metadata

**Java**

```csharp
try (AsfFormat format = new AsfFormat("D:\\input.asf"))
{
    System.out.println(format.getXmpValues().getSchemes().getXmpBasic().getCreateDate());
    System.out.println(format.getXmpValues().getSchemes().getXmpBasic().getLabel());
    System.out.println(format.getXmpValues().getSchemes().getDublinCore().getFormat());

    format.getXmpValues().getSchemes().getXmpBasic().setCreateDate(new Date());
    format.getXmpValues().getSchemes().getXmpBasic().setLabel("Test label");
    format.getXmpValues().getSchemes().getDublinCore().setFormat("ASF Video format");

    format.save("D:\\output.asf");
}
```

Remove XMP metadata

**Java**

```csharp
try (AsfFormat format = new AsfFormat("D:\\input.asf"))
{
    format.removeXmpData();
    format.save("D:\\output.asf");
}
```

### Refactor base metadata classes to add support for hierarchical metadata structures

This enhancement is necessary to introduce metadata types with hierarchical structure.

**Public API changes**

The t*oPropertyArray* method has been added to the *IptcDataSet* class

The *IptcDataSetCollection()* constructor has been added to the *IptcDataSetCollection* class

The *IptcDataSetCollection(IptcProperty\[\])* constructor has been added to the *IptcDataSetCollection* class

The *readByNumber(int)* method has been added to the *IptcDataSetCollection* class

The *readProperty(int,int)* method has been added to the *IptcDataSetCollection* class

The a*ddOrUpdate(IptcProperty)* method has been added to the *IptcDataSetCollection* class

The a*ddOrUpdate(IptcDataSet)* method has been added to the *IptcDataSetCollection* class

The r*emove(int)* method has been added to the *IptcDataSetCollection* class

The r*emove(int,int)* method has been added to the *IptcDataSetCollection* class

The c*lear* method has been added to the *IptcDataSetCollection* class

The t*oPropertyArray* method has been added to the *IptcDataSetCollection* class

The *IptcProperty(int,int,String)* constructor has been added to the *IptcProperty* class

The *IptcProperty(int,int,int)* constructor has been added to the *IptcProperty* class

The *IptcProperty(int,int,Date)* constructor has been added to the *IptcProperty* class

The *getAlternativeName* method has been added to the *IptcProperty* class

The *getIptcValues* method has been added to the *JpegFormat* class

The *setIptcValues* method has been added to the *JpegFormat* class

The *get**IptcValues* method has been added to the *PsdFormat* class

The *set**IptcValues* method has been added to the *PsdFormat* class

The *getIptcValues* method has been added to the *TiffFormat* class

The *TiffTag *class is now inherited from the *MetadataProperty *class

The *getIptcValues* method has been added to the *IIptc* interface

The *setIptcValues* method has been added to the *IIptc* interface

The *MetadataProperty(String,PropertyValue)* constructor has been added to the *MetadataProperty* class

The *DoubleArray* public static field has been added to the *MetadataPropertyType* class

The *IntegerArray* public static field has been added to the *MetadataPropertyType* class

The *LongArray* public static field has been added to the *MetadataPropertyType* class

The *Metadata* public static field has been added to the *MetadataPropertyType* class

The *MetadataArray* public static field has been added to the *MetadataPropertyType* class

The *toDoubleArray* method has been added to the *PropertyValue* class

The *toIntegerArray* method has been added to the *PropertyValue* class

The *toLongArray* method has been added to the *PropertyValue* class

The *t**oMetadataArray* method has been added to the *PropertyValue* class

The *t**oMetadata* method has been added to the *PropertyValue* class

The *IptcProperty *class is now inherited form the *MetadataProperty* class

The *IptcDataSetCollection.IptcDataSetCollection(IptcCollection)* constructor has been marked as deprecated

The *JpegFormat.hasIptc* method has been marked as deprecated

The *JpegFormat.getIptc* method has been marked as deprecated

The *JpegFormat.updateIptc* method has been marked as deprecated

The *JpegFormat.removeIptc* method has been marked as deprecated

The *PsdFormat.hasIptc* method has been marked as deprecated

The *PsdFormat.getIptc* method has been marked as deprecated

The *PsdFormat.updateIptc* method has been marked as deprecated

The *PsdFormat.removeIptc* method has been marked as deprecated

The *TiffFormat.hasIptc* method has been marked as deprecated

The *TiffFormat.getIptc* method has been marked as deprecated

The *IIptc.hasIptc* method has been marked as deprecated

The *IIptc**.getIptc* method has been marked as deprecated

The *IIptc**.updateIptc* method has been marked as deprecated

The *IIptc**.removeIptc* method has been marked as deprecated

The *MetadataProperty.MetadataProperty()* constructor has been marked as deprecated

The *MetadataProperty.getName* method has been marked as deprecated

The *MetadataProperty.getValue* method has been marked as deprecated

The *MetadataProperty.equals(*MetadataProperty,boolean*)* method has been marked as deprecated

The *PropertyValue.equals(*PropertyValue**,boolean*)* method has been marked as deprecated

The *ExifMetadata* class has been marked as deprecated

The *IptcCollection* class has been marked as deprecated

The *IptcMetadata* class has been marked as deprecated

The *IptcProperty**.IptcProperty(int,String,int,String)* constructor has been marked as deprecated

The *IptcProperty**.IptcProperty(int,String,int,Date)* constructor has been marked as deprecated

The *IptcProperty**.IptcProperty(int,String,int,int)* constructor has been marked as deprecated

The *IptcProperty**.getPropertyType* method has been marked as deprecated

The *IptcProperty**.toByteArray* method has been marked as deprecated

The *IptcProperty**.toInt* method has been marked as deprecated

The *IptcProperty**.toDate* method has been marked as deprecated

The *IptcProperty**Type* class has been marked as deprecated

##### Use cases

Display the whole metadata tree of a file

**Java**

```csharp
public static void main(String[] args) 
{    
    License l = new License();
    l.setLicense("D:\\GroupDocs.Metadata.lic");
    
    try (FormatBase format = FormatFactory.recognizeFormat("D:\\input.asf"))
    {
        displayMetadataTree(format.getMetadata(), 1);
    }
}

private static void displayMetadataTree(Metadata metadata, int indent)
{
    if (metadata != null)
    {
        String stringMetadataType = String.valueOf(metadata.getMetadataType());
        System.out.printf("%" + (stringMetadataType.length() + indent) + "s%n", stringMetadataType);
        for (MetadataProperty property : metadata)
        {
            String stringPropertyRepresentation = "Name: " + property.getName() + ", Value: " + property.getFormattedValue();
            System.out.printf("%" + (stringPropertyRepresentation.length() + indent + 1) + "s%n", stringPropertyRepresentation);
            if (property.getValue() != null)
            {
                switch (property.getValue().getType())
                {
                    case MetadataPropertyType.Metadata:
                        displayMetadataTree(property.getValue().toMetadata(), indent + 2);
                        break;
                    case MetadataPropertyType.MetadataArray:
                        displayMetadataTree(property.getValue().toMetadataArray(), indent + 2);
                        break;
                }
            }
        }
    }
}

private static void displayMetadataTree(Metadata[] metadataArray, int indent)
{
    if (metadataArray != null)
    {
        for (Metadata metadata : metadataArray)
        {
            displayMetadataTree(metadata, indent);
        }
    }
}
```

### Remove obsolete EXIF APIs

This enhancement removes some obsolete members and classes that were used to work with EXIF metadata.

**Public API changes**

The *getCameraOwnerName* method has been removed from the *ExifInfo* class

The *setCameraOwnerName* method has been removed from the *ExifInfo* class

The *getBodySerialNumber *method has been removed from the *ExifInfo* class

The *setBodySerialNumber *method has been removed from the *ExifInfo* class

The *getCFAPattern* method has been removed from the *ExifInfo* class

The *setCFAPattern* method has been removed from the *ExifInfo* class

The *getUserComment* method has been removed from the *ExifInfo* class

The *setUserComment* method has been removed from the *ExifInfo* class

The *JpegExifInfo* class has been removed form the *com.groupdocs.metadata* package

##### Use cases

Please use the appropriate methods of the *ExifIfdInfo *class instead

**Java**

```csharp
try (JpegFormat format = new JpegFormat("D:\\input.jpg"))
{
    format.getExifValues().getExifIfdData().setCameraOwnerName("test owner");
    format.getExifValues().getExifIfdData().setBodySerialNumber("body-123");
    format.getExifValues().getExifIfdData().setCFAPattern(new byte[] { 1, 2, 3 });
    format.getExifValues().getExifIfdData().setUserComment("test comment");

    format.save("D:\\output.jpg");
}
```

The *JpegExifInfo* class is no longer needed since you can use an instance of *ExifInfo* instead

**Java**

```csharp
ExifInfo exif = new ExifInfo();
exif.setArtist("test artist");
exif.setCopyright("(C)");
exif.getExifIfdData().setCameraOwnerName("test owner");
exif.getExifIfdData().setBodySerialNumber("body-123");
exif.getExifIfdData().setCFAPattern(new byte[] { 1, 2, 3 });
exif.getExifIfdData().setUserComment("test comment");

try (JpegFormat format = new JpegFormat("D:\\input.jpg"))
{
    format.updateExifInfo(exif);
    format.save("D:\\output.jpg");
}
```

### Remove Mp3Format obsolete members

This enhancement removes some obsolete members of the *Mp3Format* class.

**Public API changes**

The *getLyrics3v2()* method has been removed from the *Mp3Format* class

Please use the *getLyrics3Tag* method instead

**Java**

```csharp
try (Mp3Format format = new Mp3Format("D:\\input.mp3"))
{
    Lyrics3Tag lyricsTag = format.getLyrics3Tag();
    if (lyricsTag != null)
    {
        // ...
    }
}
```
