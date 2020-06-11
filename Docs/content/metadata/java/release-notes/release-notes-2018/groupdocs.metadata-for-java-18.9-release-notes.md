---
id: groupdocs-metadata-for-java-18-9-release-notes
url: metadata/java/groupdocs-metadata-for-java-18-9-release-notes
title: GroupDocs.Metadata for Java 18.9 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 18.9.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Metered licensing security is improved and now supports Java version 8u101 or above
*   Remove EpubFormat.GetImageCoverBytes method (obsolete code)
*   Remove GroupDocs.Metadata.Formats.Document.InspectionResult class (obsolete code)
*   Remove XlsMetadata.ContentProperties property (obsolete code)
*   Refactor the classes representing tiff tags to bring them in accordance with the tiff specification
*   Reduce memory consumption of the JPEG format
*   Reduce memory consumption of the TIFF format
*   Implement the ability to read EXIF metadata in the PSD format
*   Implement the ability to read and update common TIFF/EXIF tags in TIFF images
*   Reduce memory consumption of the GIF format

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2319 | Refactor the classes representing tiff tags to bring them in accordance with the tiff specification | Enhancement |
| METADATANET-2382 | Reduce memory consumption of the JPEG format | Enhancement |
| METADATANET-2403 | Reduce memory consumption of the TIFF format | Enhancement |
| METADATANET-2320 | Remove EpubFormat.GetImageCoverBytes method (obsolete code) | Enhancement |
| METADATANET-2321 | Remove GroupDocs.Metadata.Formats.Document.InspectionResult class (obsolete code) | Enhancement |
| METADATANET-2322 | Remove XlsMetadata.ContentProperties property (obsolete code) | Enhancement |
| METADATANET-2446 | Implement the ability to read and update common TIFF/EXIF tags in TIFF images | Enhancement |
| METADATANET-2449 | Reduce memory consumption of the GIF format | Enhancement |
| METADATANET-1045 | Implement the ability to read EXIF metadata in the PSD format | New Feature |
| METADATAJAVA-81 | Metered licensing security is improved and now supports Java version 8u101 or above | Breaking Change |
| METADATANET-2417 | Unable to add TiffTag to EXIF tags | Bug |
| METADATANET-2418 | Unable to remove Title, Subject, Authors, and Copyright fields in Tiff file | Bug |
| METADATANET-2420 | TIF file SetSubject() method updates Tags field instead of Subject | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 18.9. It includes not only new and obsoleted public methods, but also a description of any changes in the behaviour behind the scenes in GroupDocs.Metadata which may affect existing code. Any behaviour introduced that could be seen as a regression and modifies existing behaviour is especially important and is documented here.{{< /alert >}}

### Refactor the classes representing TIFF tags to bring them in accordance with the TIFF specification

##### Description

This enhancement affects the classes representing different types of TIFF tags and brings them in accordance with [the tiff specification](https://www.itu.int/itudoc/itu-t/com16/tiff-fx/docs/tiff6.pdf).

##### Public API changes

*TiffArrayTag* class has been added to *com.groupdocs.metadata* package  
*TiffAsciiTag*.*getValue* method has been marked as deprecated  
*getTagValue* method has been added to *TiffAsciiTag* class  
*TiffByteTag*.*getValue* method has been marked as deprecated  
*TiffByteTag* class is now inherited from *TiffArrayTag* class  
*TiffLongTag.getValue* method has been marked as deprecated  
*TiffLongTag* class is now inherited from *TiffArrayTag* class  
*TiffLongTag.TiffLongTag(int, int)* constructor has been marked as deprecated  
*TiffRationalTag.getValue* method has been marked as deprecated  
*TiffRationalTag* class is now inherited from *TiffArrayTag* class  
*TiffRationalTag.TiffRationalTag(int, Rational)* constructor has been marked as deprecated  
*TiffSByteTag.getValue* method has been marked as deprecated  
*TiffSByteTag* class is now inherited from *TiffArrayTag* class  
*TiffSByteTag.TiffSByteTag(int, int)* constructor has been marked as deprecated  
*TiffShortTag.getValue* method has been marked as deprecated  
*TiffShortTag* class is now inherited from *TiffArrayTag* class  
*TiffShortTag.TiffShortTag(int, short)* constructor has been marked as deprecated  
*TiffSLongTag.getValue* method has been marked as deprecated  
*TiffSLongTag* class is now inherited from *TiffArrayTag* class  
*TiffSLongTag.TiffSLongTag(int, int)* constructor has been marked as deprecated  
*TiffSRationalTag.getValue* method has been marked as deprecated  
*TiffSRationalTag* class is now inherited from *TiffArrayTag* class  
*TiffSRationalTag.TiffSRationalTag(int, SRational)* constructor has been marked as deprecated  
*TiffSShortTag.getValue* method has been marked as deprecated  
*TiffSShortTag* class is now inherited from *TiffArrayTag* class  
*TiffSShortTag.TiffSShortTag(int, short)* constructor has been marked as deprecated  
*TiffDoubleTag* class has been added to *com.groupdocs.metadata* package  
*TiffFloatTag* class has been added to *com.groupdocs.metadata* package  
*TiffUndefinedTag* class has been added to *com.groupdocs.metadata* package  
*TiffRationalArrayTag* class has been marked as deprecated  
*ExifProperty* class has been marked as deprecated  
*compareExifTags(String, String, int)* method has been added to *ComparisonFacade* class  
*compareExifTags(InputStream, InputStream, int)* method has been added to *ComparisonFacade* class  
*scanExifTags(String, String, int)* method has been added to *SearchFacade* class  
*scanExifTags(String, String)* method has been added to *SearchFacade* class  
*scanExifTags(String, Pattern)* method has been added to *SearchFacade* class  
*scanExifTags(InputStream, String, int)* method has been added to *SearchFacade* class  
*scanExifTags(InputStream, String)* method has been added to *SearchFacade* class  
*scanExifTags(InputStream, Pattern)* method has been added to *SearchFacade* class  
*ComparisonFacade.compareExif(String, String, int)* method has been marked as deprecated  
*ComparisonFacade.compareExif(InputStream, InputStream, int)* method has been marked as deprecated  
*SearchFacade.scanExif(String, String, int)* method has been marked as deprecated  
*SearchFacade.scanExif(String, String)* method has been marked as deprecated  
*SearchFacade.scanExif(String, Pattern)* method has been marked as deprecated  
*SearchFacade.scanExif(InputStream, String, int)* method has been marked as deprecated  
*SearchFacade.scanExif(InputStream, String)* method has been marked as deprecated  
*SearchFacade.scanExif(InputStream, Pattern)* method has been marked as deprecated

##### Usecases

Extract values of certain TIFF tags.

**Java**

```csharp
try (TiffFormat format = new TiffFormat("D:\\input.tif"))
{
    TiffTag[] tags = format.getTags(format.getImageFileDirectories()[0]);
 
    for (TiffTag tag : tags)
    {
        if (tag.getTagId() == TiffTagIdEnum.XResolution || tag.getTagId() == TiffTagIdEnum.YResolution)
        {
            System.out.println(tag.getName() + " = " +  ((TiffRationalTag)tag).getTagValue()[0].getValue());
        }
    }
}
```

Since the EXIF metadata standard is based on the TIFF format specification, the classes representing TIFF tags can be used to obtain particular EXIF properties as well.

**Java**

```csharp
try (JpegFormat format = new JpegFormat("D:\\input.jpg"))
{
    ExifInfo exif = format.getExifInfo();
 
    if (exif != null)
    {
        for (TiffTag tag : exif.getTags())
        {
            if (tag.getTagId() == TiffTagIdEnum.XResolution || tag.getTagId() == TiffTagIdEnum.YResolution)
            {
                System.out.println(tag.getName() + " = " +  ((TiffRationalTag)tag).getTagValue()[0].getValue());
            }
        }
    }
}
```

The *ExifProperty* class had been duplicating the functionality of TIFF tags and having almost the same purpose, so it was marked as obsolete. Please use the new utility methods returning instances of the *TiffTag* descendants instead.

**Java**

```csharp
TiffTag[] resolutionTags = SearchFacade.scanExifTags("D:\\input.jpg", Pattern.compile("^(XResolution|YResolution)$"));
 
for (TiffTag resolutionTag : resolutionTags)
{
    System.out.println(resolutionTag.getName() + " = " +  ((TiffRationalTag)resolutionTag).getTagValue()[0].getValue());
}
```

**Java**

```csharp
TiffTag[] intersection = ComparisonFacade.compareExifTags("D:\\input1.jpg", "D:\\input2.jpg", ComparerSearchType.Intersection);
 
for (TiffTag tag : intersection)
{
    System.out.println(tag.getName());
    System.out.println(tag.getTagType());
    System.out.println(tag.getFormattedValue());
}
```

### Reduce memory consumption of the JPEG format

##### Description

This enhancement allows working with jpeg images with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *JpegFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (JpegFormat format = new JpegFormat("d:\\input.jpg"))
{
    // Working with metadata
}
```

If you are loading a jpeg file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.jpg"))
{
    try (JpegFormat format = new JpegFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.jpg"))
{
    try (JpegFormat format = new JpegFormat("d:\\input.jpg"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduce memory consumption of the TIFF format

##### Description

This enhancement allows working with tiff images with less memory consumption

##### Public API changes

None.

##### Usecases

Please note that the *TiffFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance

**Java**

```csharp
try (TiffFormat format = new TiffFormat("d:\\input.tiff"))
{
    // Working with metadata
}
```

If you are loading a tiff file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.tiff"))
{
    try (TiffFormat format = new TiffFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.tiff"))
{
    try (TiffFormat format = new TiffFormat("d:\\input.tiff"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Remove EpubFormat.GetImageCoverBytes method (obsolete code)

##### Description

This enhancement removes the *EpubFormat.getImageCoverBytes* method from the public API (obsolete code). Please use the *EpubFormat.readThumbnail* method instead.

##### Public API changes

The *getImageCoverBytes* method has been removed from the *EpubFormat *class

##### Usecases

Get the image cover data and MIME type

**Java**

```csharp
try (EpubFormat epubFormat = new EpubFormat("D:\\input.epub"))
{
    ThumbnailMetadata thumbnail = epubFormat.readThumbnail();
    if (thumbnail != null)
    {
        System.out.println(thumbnail.getImageData().length);
        System.out.println(thumbnail.getMimeType());
    }
}
```

### Remove GroupDocs.Metadata.Formats.Document.InspectionResult class (obsolete code)

##### Description

This enhancement removes the *InspectionResult* class from the public API (obsolete code). Please use an appropriate implementation of the *IInspectorResult* interface instead.

##### Public API changes

The *InspectionResult* class has been removed from the *com.groupdocs.metadata* package

##### Usecases

Inspect a document.

**Java**

```csharp
try (DocFormat format = new DocFormat("D:\\input.docx"))
{
    DocInspectionResult inspectionResult = format.inspectDocument();
    System.out.println(inspectionResult.getDigitalSignatures().length);
    System.out.println(inspectionResult.getComments().length);
}
```

### Remove XlsMetadata.ContentProperties property (obsolete code)

##### Description

This enhancement removes the *XlsMetadata.getContentProperties* method from the public API (obsolete code). Please use the *XlsMetadata.getContentTypeProperties* method instead.

##### Public API changes

The get*ContentProperties* method has been removed from the *XlsMetadata*class

##### Usecases

Get the content type properties.

**Java**

```csharp
try (XlsFormat format = new XlsFormat("D:\\input.xlsx"))
{
    for (XlsContentProperty property : format.getDocumentProperties().getContentTypeProperties())
    {
        System.out.println(property.getFormattedValue());
    }
}
```

### Implement the ability to read and update common TIFF/EXIF tags in TIFF images 

##### Description

This enhancement allows a user to read and update some common TIFF/EXIF metadata tags in TIFF images.

##### Public API changes

The *SubfileType* field has been added to the *TiffTagIdEnum* class  
The *T4Options* field has been added to the *TiffTagIdEnum* class  
The *T6Options* field has been added to the *TiffTagIdEnum* class  
The *TransferFunction* field has been added to the *TiffTagIdEnum* class  
The *WhitePoint* field has been added to the *TiffTagIdEnum* class  
The *PrimaryChromaticities* field has been added to the *TiffTagIdEnum* class  
The *HalftoneHints* field has been added to the *TiffTagIdEnum* class  
The *InkNames* field has been added to the *TiffTagIdEnum* class  
The *DotRange* field has been added to the *TiffTagIdEnum* class  
The *SampleFormat* field has been added to the *TiffTagIdEnum* class  
The *SMinSampleValue* field has been added to the *TiffTagIdEnum* class  
The *SMaxSampleValue* field has been added to the *TiffTagIdEnum* class  
The *TransferRange* field has been added to the *TiffTagIdEnum* class  
The *JPEGProc* field has been added to the *TiffTagIdEnum* class  
The *JPEGInterchangeFormat* field has been added to the *TiffTagIdEnum* class  
The *JPEGInterchangeFormatLength* field has been added to the *TiffTagIdEnum* class  
The *JPEGRestartInterval* field has been added to the *TiffTagIdEnum* class  
The *JPEGLosslessPredictors* field has been added to the *TiffTagIdEnum* class  
The *JPEGPointTransforms* field has been added to the *TiffTagIdEnum* class  
The *JPEGQTables* field has been added to the *TiffTagIdEnum* class  
The *JPEGDCTables* field has been added to the *TiffTagIdEnum* class  
The *JPEGACTables* field has been added to the *TiffTagIdEnum* class  
The *YCbCrCoefficients* field has been added to the *TiffTagIdEnum* class  
The *YCbCrSubSampling* field has been added to the *TiffTagIdEnum* class  
The *YCbCrPositioning* field has been added to the *TiffTagIdEnum* class  
The *ReferenceBlackWhite* field has been added to the *TiffTagIdEnum* class  
The *UserComment* field has been added to the *TiffTagIdEnum* class  
The *ExifIfdInfo* class has been added to the *com.groupdocs.metadata* package  
The *getExifIfdData* method has been added to the *ExifInfo* class  
The *getArtist* method has been added to the *ExifInfo* class  
The *setArtist* method has been added to the *ExifInfo* class  
The *getCopyright* method has been added to the *ExifInfo* class  
The *setCopyright* method has been added to the *ExifInfo* class  
The *getDateTime* method has been added to the *ExifInfo* class  
The *setDateTime* method has been added to the *ExifInfo* class  
The *getImageDescription* method has been added to the *ExifInfo* class  
The *setImageDescription* method has been added to the *ExifInfo* class  
The *getImageLength* method has been added to the *ExifInfo* class  
The *setImageLength* method has been added to the *ExifInfo* class  
The *getImageWidth* method has been added to the *ExifInfo* class  
The *setImageWidth* method has been added to the *ExifInfo* class  
The *getMake* method has been added to the *ExifInfo* class  
The *setMake* method has been added to the *ExifInfo* class  
The *getModel* method has been added to the *ExifInfo* class  
The *setModel* method has been added to the *ExifInfo* class  
The *getSoftware* method has been added to the *ExifInfo* class  
The *setSoftware* method has been added to the *ExifInfo* class  
The *JpegExifInfo* class has been marked as deprecated  
The *ExifInfo.getBodySerialNumber* method has been marked as deprecated  
The *ExifInfo.setBodySerialNumber* method has been marked as deprecated  
The *ExifInfo.getCFAPattern* method has been marked as deprecated  
The *ExifInfo.setCFAPattern* method has been marked as deprecated  
The *ExifInfo.getCameraOwnerName* method has been marked as deprecated  
The *ExifInfo.setCameraOwnerName* method has been marked as deprecated  
The *ExifInfo.getUserComment* method has been marked as deprecated  
The *ExifInfo.setUserComment* method has been marked as deprecated

##### Usecases

Update common EXIF/TIFF metadata tags by using the shortcut properties.

**Java**

```csharp
try (TiffFormat format = new TiffFormat("D:\\input.tif"))
{    
	format.getExifValues().setArtist("GroupDocs");    
	format.getExifValues().setSoftware("GroupDocs.Metadata");     
 
	format.save("D:\\output.tif");
}
```

Update common EXIF/TIFF metadata tags by replacing the whole tag collection.

**Java**

```csharp
try (TiffFormat format = new TiffFormat("D:\\input.tif"))
{
    TiffTag[] tags = new TiffTag[]
    {
        new TiffAsciiTag(TiffTagIdEnum.Artist, "GroupDocs"),
        new TiffAsciiTag(TiffTagIdEnum.Copyright, "GroupDocs.Metadata"),
    };
    format.getExifValues().setTags(tags);
 
    format.save("D:\\output.tif");
}
```

{{< alert style="warning" >}}Users are not able to replace/remove all the EXIF/TIFF tags contained in the collection. Some of the tags are crucial to display the image properly, so they will not be affected during metadata saving.{{< /alert >}}

Update EXIF IFD tags by using the shortcut properties.

**Java**

```csharp
try (TiffFormat format = new TiffFormat("D:\\input.tif"))
{
    format.getExifValues().getExifIfdData().setUserComment("test comment");
    format.getExifValues().getExifIfdData().setBodySerialNumber("1010101010");
    format.save("D:\\output.tif");
}
```

Update EXIF IFD tags by replacing the whole tag collection.

**Java**

```csharp
try (TiffFormat format = new TiffFormat("D:\\input.tif"))
{
    TiffTag[] tags = new TiffTag[]
    {
            new TiffAsciiTag(42032, "test camera owner"), // CameraOwnerName
            new TiffAsciiTag(42033, "test body serial number"), // BodySerialNumber
    };
    format.getExifValues().getExifIfdData().setTags(tags);
    format.save("D:\\output.tif");
}
```

### Reduce memory consumption of the GIF format

##### Description

This enhancement allows working with gif images with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that the *GifFormat* class implements the *Closeable* interface and it's necessary to call the *close()* method when you're done working with its instance.

**Java**

```csharp
try (GifFormat format = new GifFormat("d:\\input.gif"))
{
    // Working with metadata
}
```

  

If you are loading a gif file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.gif"))
{
    try (GifFormat format = new GifFormat(stream))
    {
        // Working with metadata
    }
    // The stream is still open here
}
```

  

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.gif"))
{
    try (GifFormat format = new GifFormat("d:\\input.gif"))
    {
        // Working with metadata
 
        format.save(stream);
    }
    // The stream is still open here
}
```

### Implement the ability to read EXIF metadata in the PSD format

##### Description

This new feature allows a user to obtain EXIF metadata contained in PSD files.

##### Public API changes

*getExifInfo* method has been added to *PsdFormat* class

##### Usecases

**Java**

```csharp
try (PsdFormat format = new PsdFormat("D:\\input.psd"))
{
    ExifInfo exif = format.getExifInfo();
    if (exif != null)
    {
        for (TiffTag tag : exif.getTags())
        {
            System.out.println(tag.getName());
            System.out.println(tag.getTagType());
            System.out.println(tag.getFormattedValue());
        }
    }
}
```

### Metered licensing security is improved and now supports Java version 8u101 or above

##### Description

This enhancement improves Metered licensing security. Starting from GroupDocs.Metadata v18.9 Metered API can be used only with Java version 8u101 or above. Metered licensing is incompatible with lower versions of Java runtime.

##### Public API changes

None.

##### Usecases

**Java**

```csharp
 Metered m = new Metered();
 
// Minimum supported version of Java is 8u101. This code throws an exception when running on lower versions of Java runtime
m.setMeteredKey("public key", "private key");
```

### Unable to add TiffTag to EXIF tags

##### Description

When adding TiffTag to EXIF tags in a .tif file. The API saves the file without any exception, however, it doesn't add the tags. If we get TIFF tags using ExifInfo.Tags property from the saved file, the API returns no tags.

##### Public API changes

None.

##### Usecases

**Java**

```csharp
try (TiffFormat tiffFormat = new TiffFormat("D:\\input.tif"))
{
    // get existing EXIF or create new one
    ExifInfo exif = tiffFormat.getExifInfo();
    if (exif == null)
    {
        exif = new ExifInfo();
    }
 
    // add specific tag
    TiffTag[] tags = new TiffTag[]
    {            
        new TiffAsciiTag(TiffTagIdEnum.Artist, "Rida"),
        new TiffAsciiTag(TiffTagIdEnum.Copyright, "copyright")
    };
 
    // and update tags
    exif.setTags(tags);
 
    // update exif
    tiffFormat.updateExifInfo(exif);
 
    tiffFormat.save("D:\\output.tif");
}
```

### Unable to remove Title, Subject, Authors, and Copyright fields in TIFF file

##### Description

Unable to remove Title, Subject, Authors, and Copyright fields in a TIFF file.

##### Public API changes

None.

##### Usecases

**Java**

```csharp
try (TiffFormat tiffFormat = new TiffFormat("D:\\input.tif"))
{
    tiffFormat.cleanMetadata();
    tiffFormat.save("D:\\output.tif");
}
```

### TIFF file SetSubject() method updates Tags field instead of Subject

##### Description

While updating the subject field of the TIFF file, Tags field gets updated.

##### Public API changes

The *getSubjects* method has been added to the *DublinCorePackage* class  
The *setSubjects* method has been added to the *DublinCorePackage* class  
The *DublinCorePackage.getSubject* method has been marked as deprecated  
The *DublinCorePackage.setSubject(String)* method has been marked as deprecated  
The *DublinCorePackage.setSubject(String\[\])* method has been marked as deprecated

##### Usecases

Set multiple subjects.

**Java**

```csharp
try (TiffFormat format = new TiffFormat("D:\\input.tif"))
{
    format.getXmpValues().getSchemes().getDublinCore().setSubjects(new String[] { "subject 1", "subject 2" });
    format.save("D:\\output.tif");
}
```
