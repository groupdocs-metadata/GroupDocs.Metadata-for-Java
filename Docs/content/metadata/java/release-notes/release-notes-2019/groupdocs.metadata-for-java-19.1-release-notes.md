---
id: groupdocs-metadata-for-java-19-1-release-notes
url: metadata/java/groupdocs-metadata-for-java-19-1-release-notes
title: GroupDocs.Metadata for Java 19.1 Release Notes
weight: 6
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 19.1.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Add support for the Matroska multimedia container
*   Add support for password-protected OneNote documents
*   Reduce memory consumption of supported Visio formats
*   Reduce memory consumption of supported OneNote formats
*   Reduce memory consumption of supported CAD formats
*   Reduce memory consumption of supported Email formats
*   Reduce memory consumption of the MOV format
*   Remove the obsolete code related to the TIFF/EXIF functionality
*   Remove obsolete members of the DublinCorePackage class

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-519 | Add support for the Matroska multimedia container | New Feature |
| METADATANET-2556 | Add support for password-protected OneNote documents | New Feature |
| METADATANET-2513 | Reduce memory consumption of supported Visio formats | Enhancement |
| METADATANET-2517 | Reduce memory consumption of supported OneNote formats | Enhancement |
| METADATANET-2538 | Reduce memory consumption of supported CAD formats | Enhancement |
| METADATANET-2539 | Reduce memory consumption of supported Email formats | Enhancement |
| METADATANET-2544 | Reduce memory consumption of the MOV format | Enhancement |
| METADATANET-1565 | Remove the obsolete code related to the TIFF/EXIF functionality | Enhancement |
| METADATANET-1577 | Remove obsolete members of the DublinCorePackage class | Enhancement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 19.1. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Add support for the Matroska multimedia container

##### Description

This new feature allows a user to work with multimedia files encoded with the Matroska container.

##### Public API changes

The *MatroskaFormat* class has been added to the *com.groupdocs.metadata* package

The *MatroskaSegmentInfoMetadata* class has been added to the *com.groupdocs.metadata* package

The *MatroskaSimpleTagMetadata* class has been added to the *com.groupdocs.metadata* package

The *MatroskaTagMetadata* class has been added to the *com.groupdocs.metadata* package

The *MatroskaTargetTypeValue *class has been added to the *com.groupdocs.metadata* package

The *MatroskaTrackMetadata *class has been added to the *com.groupdocs.metadata* package

The *MatroskaTrackType* class has been added to the *com.groupdocs.metadata* package

The *MatroskaVideoDisplayUnit* class has been added to the *com.groupdocs.metadata* package

The *MatroskaVideoFieldOrder* class has been added to the *com.groupdocs.metadata* package

The *MatroskaVideoFlagInterlaced *class has been added to the *com.groupdocs.metadata* package

The *MatroskaVideoStereoMode* class has been added to the *com.groupdocs.metadata* package

The *MatroskaVideoTrackMetadata *class has been added to the *com.groupdocs.metadata* package

##### Usecases

Read MKV video metadata.

**Java**

```csharp
try (MatroskaFormat format = new MatroskaFormat("D:\\input.mkv"))
{
    System.out.println(format.getEbmlHeader().getDocType());
    System.out.println(format.getEbmlHeader().getDocTypeReadVersion());
    System.out.println(format.getEbmlHeader().getDocTypeVersion());
    System.out.println(format.getEbmlHeader().getReadVersion());
    System.out.println(format.getEbmlHeader().getVersion());
    for (MatroskaSegmentInfoMetadata segment : format.getSegments())
    {
        System.out.println(segment.getDateUtc());
        System.out.println(segment.getDuration());
        System.out.println(segment.getMuxingApp());
        System.out.println(segment.getSegmentFilename());
        System.out.println(segment.getSegmentUid());
        System.out.println(segment.getTimecodeScale());
        System.out.println(segment.getTitle());
        System.out.println(segment.getWritingApp());
    }
    for (MatroskaTagMetadata tag : format.getTags())
    {
        System.out.println(tag.getTargetType());
        System.out.println(tag.getTargetTypeValue());
        System.out.println(tag.getTagTrackUid());
        for (String key : tag.getSimpleTags().getKeys())
        {
            System.out.println(tag.getSimpleTags().readByStringKey(key).getFormattedValue());
        }
    }
    for (MatroskaTrackMetadata track : format.getTracks())
    {
        System.out.println(track.getCodecId());
        System.out.println(track.getCodecName());
        System.out.println(track.getDefaultDuration());
        System.out.println(track.getFlagEnabled());
        System.out.println(track.getLanguage());
        System.out.println(track.getLanguageIetf());
        System.out.println(track.getName());
        System.out.println(track.getTrackNumber());
        System.out.println(track.getTrackType());
        System.out.println(track.getTrackUid());
         
        if (track instanceof MatroskaAudioTrackMetadata)
        {
            MatroskaAudioTrackMetadata audioTrack = (MatroskaAudioTrackMetadata)track;
            System.out.println(audioTrack.getSamplingFrequency());
            System.out.println(audioTrack.getOutputSamplingFrequency());
            System.out.println(audioTrack.getChannels());
            System.out.println(audioTrack.getBitDepth());
        }
         
        if (track instanceof MatroskaVideoTrackMetadata)
        {
            MatroskaVideoTrackMetadata videoTrack = (MatroskaVideoTrackMetadata)track;
            System.out.println(videoTrack.getFlagInterlaced());
            System.out.println(videoTrack.getFieldOrder());
            System.out.println(videoTrack.getStereoMode());
            System.out.println(videoTrack.getAlphaMode());
            System.out.println(videoTrack.getPixelWidth());
            System.out.println(videoTrack.getPixelHeight());
            System.out.println(videoTrack.getPixelCropBottom());
            System.out.println(videoTrack.getPixelCropTop());
            System.out.println(videoTrack.getPixelCropLeft());
            System.out.println(videoTrack.getPixelCropRight());
            System.out.println(videoTrack.getDisplayWidth());
            System.out.println(videoTrack.getDisplayHeight());
            System.out.println(videoTrack.getDisplayUnit());
        }
    }
}  
```

### Add support for password-protected OneNote documents

##### Description

This new feature allows a user to work with password-protected OneNote documents.

##### Public API changes

The *OneNoteFormat**(String, LoadOptions)* constructor has been added to the *OneNoteFormat *class

The *OneNoteFormat**(InputStream, LoadOptions)* constructor has been added to the *OneNoteFormat *class

##### Usecases

Load a password-protected *OneNote* document.

**Java**

```csharp
LoadOptions loadOptions = new LoadOptions("password");
try (OneNoteFormat format = new OneNoteFormat("D:\\protected\\input.one", loadOptions))
{
    // Working with the password-protected document
}
```

Check if a document is password-protected.

**Java**

```csharp
if (MetadataUtility.isProtected("D:\\protected\\input.one"))
{
    // Working with the password-protected document
}
```

### Reduced memory consumption of supported Visio formats

##### Description

This enhancement allows working with Visio documents with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *VisioFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (VisioFormat format = new VisioFormat("d:\\input.vsdx"))
{
    // Working with metadata
}
```

If you are loading a Visio document from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.vsdx"))
{
    try (VisioFormat format = new VisioFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.vsdx"))
{
    try (VisioFormat format = new VisioFormat("d:\\input.vsdx"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduced memory consumption of supported OneNote formats

##### Description

This enhancement allows working with OneNote documents with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *OneNoteFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (OneNoteFormat format = new OneNoteFormat("d:\\input.one"))
{
    // Working with metadata
}
```

If you are loading a OneNote document from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.one"))
{
    try (OneNoteFormat format = new OneNoteFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.one"))
{
    try (OneNoteFormat format = new OneNoteFormat("d:\\input.one"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduced memory consumption of supported CAD formats

##### Description

This enhancement allows working with supported CAD formats with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *DwgFormat* and *DxfFormat* classes implement the *Closeable* interface and it's necessary to call the *close()* method when you're done working with the instance.

**Java**

```csharp
try (DwgFormat format = new DwgFormat("d:\\input.dwg"))
{
    // Working with metadata
}
```

If you are loading a CAD drawing from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.dxf"))
{
    try (DxfFormat format = new DxfFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.dwg"))
{
    try (DwgFormat format = new DwgFormat("d:\\input.dwg"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduced memory consumption of supported Email formats

##### Description

This enhancement allows working with saved email messages with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *EmlFormat* and *OutlookMessage* classes implement the *Closeable* interface and it's necessary to call the *close()* method when you're done working with the instance.

**Java**

```csharp
try (OutlookMessage format = new OutlookMessage("d:\\input.msg"))
{
    // Working with metadata
}
```

If you are loading an email message from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.eml"))
{
    try (EmlFormat format = new EmlFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.msg"))
{
    try (OutlookMessage format = new OutlookMessage("d:\\input.msg"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduced memory consumption of supported MOV formats

##### Description

This enhancement allows working with MOV videos with less memory consumption.

##### Public API changes

The *QuickTimeAtom.getData* method has been marked as deprecated

The *getDataOffset* method has been added to the *QuickTimeAtom* class

The *getDataSize* method has been added to the *QuickTimeAtom* class

##### Usecases

Please note that the *MovFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (MovFormat format = new MovFormat("d:\\input.mov"))
{
    // Working with metadata
}
```

If you are loading a MOV video from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.mov"))
{
    try (MovFormat format = new MovFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.mov"))
{
    try (MovFormat format = new MovFormat("d:\\input.mov"))
    {
        // Working with metadata
        format.save(stream);
    }
    // The stream is still open here
}
```

### Remove the obsolete code related to the TIFF/EXIF functionality

##### Description

This enhancement removes some obsolete classes, enumsandmembers connected with the TIFF/EXIF functionality.

##### Public API changes

The *ExifProperty* class has been removed from the *com.groupdocs.metadata* package

The *ExifPropertyType* class has been removed from the *com.groupdocs.metadata* package

The *getValue* method has been removed from the *TiffAsciiTag* class

The *get**Value* method  has been removed from the *TiffByteTag* class

The *get**Value* method has been removed from the *TiffLongTag* class

The *get**Value* method has been removed from the *TiffRationalTag* class

The *get**Value* method has been removed from the *TiffSByteTag* class

The *get**Value* method has been removed from the *TiffSLongTag* class

The *get**Value* method has been removed from the *TiffSRationalTag* class

The *get**Value* method has been removed from the *TiffSShortTag* class

The *get**Value* method has been removed from the *TiffShortTag* class

The *TiffLongTag(int,int)* constructor has been removed from the *TiffLongTag* class

The *TiffRationalTag(int,Rational)* constructor has been removed from the *TiffRationalTag *class

The *TiffSByteTag(int,int)* constructor has been removed from the *TiffSByteTag*class

The *TiffSLongTag(int,int)* constructor has been removed from the *TiffSLongTag*class

The *TiffSRationalTag(int,SRational)* constructor has been removed from the *TiffSRationalTag *class

The *TiffSShortTag(int,short)* constructor has been removed from the *TiffSShortTag*class

The *TiffShortTag(int,short)* constructor has been removed from the *TiffShortTag *class

The *CompareExif(String,String,int)* method has been removed from the *ComparisonFacade *class

The *CompareExif(InputStream,InputStream,int)* method has been removed from the *ComparisonFacade *class

The *ScanExif(String,String,int)* method has been removed from the *SearchFacade *class

The *ScanExif(String,String)* method has been removed from the *SearchFacade *class

The *ScanExif(*InputStream*,String,int)* method has been removed from the *SearchFacade *class

The *ScanExif(*InputStream*,String)* method has been removed from the *SearchFacade *class

The *ScanExif(String,Pattern)* method has been removed from the *SearchFacade *class

The *ScanExif(*InputStream*,*Pattern*)* method has been removed from the *SearchFacade *class

##### Usecases

Compare EXIF properties of two different documents.

**Java**

```csharp
TiffTag[] result = ComparisonFacade.compareExifTags("D:\\input1.jpg", "D:\\input2.jpg", ComparerSearchType.Intersection);
```

Search for EXIF tags using the *SearchFacade* class.

**Java**

```csharp
TiffTag[] result = SearchFacade.scanExifTags("D:\\input.jpg", "james"); 
```

Work with EXIF tags using alternative properties and constructors.

**Java**

```csharp
TiffLongTag width = new TiffLongTag(TiffTagIdEnum.ImageWidth, new Long[] { 123L });
TiffLongTag length = new TiffLongTag(TiffTagIdEnum.ImageLength, new Long[] { 123L });
try (JpegFormat format = new JpegFormat("D:\\input.jpg"))
{
    format.getExifValues().setTags(new TiffTag[] { width, length});
    format.save("D:\\output.jpg");
}
System.out.println(width.getTagValue()[0]);
System.out.println(length.getTagValue()[0]);
```

### Remove obsolete members of the DublinCorePackage class

##### Description

This enhancement removes some obsolete members of the *DublinCorePackage* class

##### Public API changes

The *getSubject* method has been removed from the *DublinCorePackage* class

The s*etSubject(String\[\])* method has been removed from the *DublinCorePackage* class

##### Usecases

Please use the *Subjects* property instead.

**Java**

```csharp
try (JpegFormat format = new JpegFormat("D:\\input.jpg"))
{
    DublinCorePackage dublinCore = format.getXmpValues().getSchemes().getDublinCore();
    for (String subject : dublinCore.getSubjects())
    {
        System.out.println(subject);
    }
}
```

**Java**

```csharp
try (JpegFormat format = new JpegFormat("D:\\input.jpg"))
{
    DublinCorePackage dublinCore = format.getXmpValues().getSchemes().getDublinCore();
    dublinCore.setSubjects(new String[] {"test subject"});
    format.save("D:\\output.jpg");
}
```
