---
id: groupdocs-metadata-for-java-18-5-release-notes
url: metadata/java/groupdocs-metadata-for-java-18-5-release-notes
title: GroupDocs.Metadata for Java 18.5 Release Notes
weight: 7
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 18.5{{< /alert >}}

## Major Features

There are the following enhancements in this release:

*   Add implementation of Closeable interface to all classes referencing any resources that should be explicitly closed
*   Implement the ability to search and replace metadata using regular expressions
*   Implement unified DublinCore metadata reader for all formats that support XMP
*   Reduce memory consumption of zip format metadata loading and saving
*   Implement the ability to edit the zip archive comment
*   Reduce memory consumption of epub format metadata loading
*   Reduce memory consumption of torrent format metadata loading and saving

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATAJAVA-58 | Add implementation of Closeable interface to all classes referencing any resources that should be explicitly closed  | Enhancement  |
| METADATANET-566 | Implement the ability to search and replace metadata using regular expressions | Enhancement  |
| METADATANET-2238  | Implement unified DublinCore metadata reader for all formats that support XMP | Enhancement  |
| METADATANET-2246 | Reduce memory consumption of zip format metadata loading and saving   | Enhancement   |
| METADATANET-2288 | Implement the ability to edit the zip archive comment  | Enhancement  |
| METADATANET-2290 | Reduce memory consumption of epub format metadata loading  | Enhancement  |
| METADATANET-2291 | Reduce memory consumption of torrent format metadata loading and saving | Enhancement  |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 18.5. It includes not only new and obsoleted public methods, but also a description of any changes in the behaviour behind the scenes in GroupDocs.Metadata which may affect existing code. Any behaviour introduced that could be seen as a regression and modifies existing behaviour is especially important and is documented here.{{< /alert >}}

### Add implementation of Closeable interface to all classes referencing any resources that should be explicitly closed 

##### Description

This enhancement allows using try-with-resources statement when working with FormatBase and FileFormatChecker instances.

##### Public API changes

*Closeable* interface has been implemented in *FormatBase* class  
*Closeable* interface has been implemented in *FileFormatChecker* class

##### Usecases

Use try-with-resources statement when working with *FormatBase* class instance.

**Java**

```csharp
try (FormatBase format = FormatFactory.recognizeFormat("d:\\input.doc"))
{
    // Working with the format metadata
}
```

Please note that all classes representing formats are inherited from *FormatBase*. So it's necessary to invoke *close* method when the instance is not needed anymore.

**Java**

```csharp
try (ZipFormat format = new ZipFormat("d:\\input.zip"))
{
    // Working with the format metadata
}
```

Call *close* method for a *FileFormatChecker* instance.

**Java**

```csharp
try (FileFormatChecker checker = new FileFormatChecker("D:\\input.jpg"))
{
    checker.verifyFormat(DocumentType.Jpeg);
}
```

### Implement the ability to search and replace metadata using regular expressions

##### Description

This enhancement allows a user to search and replace metadata by using regular expressions

##### Public API changes

*scanDocument(String,Pattern)* method has been added to *SearchFacade* class  
*scanDocument(Stream,Pattern)* method has been added to *SearchFacade* class  
*scanXmp(String,Pattern)* method has been added to *SearchFacade* class  
*scanXmp(Stream,Pattern)* method has been added to *SearchFacade* class  
*scanExif(String,Pattern)* method has been added to *SearchFacade* class  
*scanExif(Stream,Pattern)* method has been added to *SearchFacade* class  
*replaceInDocument(String,Pattern,String,String)* method has been added to *SearchFacade* class  
*replaceInDocument(Stream,Pattern,String,String)* method has been added to *SearchFacade* class  
*replaceInXmp(String,Pattern,String,String)* method has been added to *SearchFacade* class  
*replaceInXmp(Stream,Pattern,String,String)* method has been added to *SearchFacade* class  
*replaceInExif(String,Pattern,String,String)* method has been added to *SearchFacade* class  
*replaceInExif(Stream,Pattern,String,String)* method has been added to *SearchFacade* class

##### Usecases

Find metadata in a document.

**Java**

```csharp
String testFile = "D:\\test.docx";
Pattern pattern = Pattern.compile("author|company", Pattern.CASE_INSENSITIVE);
MetadataPropertyCollection properties = SearchFacade.scanDocument(testFile, pattern);
for (int i = 0; i < properties.getCount(); i++)
{
    System.out.println(properties.readByIndex(i));
}
```

Replace metadata in a document.

**Java**

```csharp
String inputFile = "D:\\input.xlsx";
String outputFile = "D:\\output.xlsx";
Pattern pattern = Pattern.compile("^author|company$", Pattern.CASE_INSENSITIVE);
String replaceValue = "Aspose";
SearchFacade.replaceInDocument(inputFile, pattern, replaceValue, outputFile);
```

Find XMP metadata.

**Java**

```csharp
String testFile = "D:\\xmp.gif";
Pattern pattern = Pattern.compile("^.*description$", Pattern.CASE_INSENSITIVE);
XmpNodeView[] properties = SearchFacade.scanXmp(testFile, pattern);
for (int i = 0; i < properties.length; i++)
{
    System.out.println(properties[i]);
}
```

Replace XMP metadata.

**Java**

```csharp
String inputFile = "D:\\input.gif";
String outputFile = "D:\\output.gif";
Pattern pattern = Pattern.compile("^.*description$", Pattern.CASE_INSENSITIVE);
String replaceValue = "Test file";
SearchFacade.replaceInXmp(inputFile, pattern, replaceValue, outputFile);
```

Find EXIF metadata.

**Java**

```csharp
String testFile = "D:\\exif.jpg";
Pattern pattern = Pattern.compile(".*");
ExifProperty[] properties = SearchFacade.scanExif(testFile, pattern);
for (int i = 0; i < properties.length; i++)
{
    System.out.println(properties[i]);
}
```

Replace EXIF metadata.

**Java**

```csharp
String inputFile = "D:\\input.jpg";
String outputFile = "D:\\output.jpg";
Pattern pattern = Pattern.compile("James", Pattern.CASE_INSENSITIVE);
String replaceValue = "John";
SearchFacade.replaceInExif(inputFile, pattern, replaceValue, outputFile);
```

### Implement unified DublinCore metadata reader for all formats that support XMP

##### Description

This enhancement allows a user to obtain Dublin Core metadata using the unified approach.

##### Public API changes

*IDublinCore* interface has been added to *com.groupdocs.metadata* package  
*IXmp* interface is now inherited from *IDublinCore* interface  
*DocFormat* class now implements *IDublinCore* interface  
*PdfFormat* class now implements *IDublinCore* interface  
*EpubFormat* class now implements *IDublinCore* interface  
*GifFormat* class now implements *IDublinCore* interface  
*Jp2Format* class now implements *IDublinCore* interface  
*JpegFormat* class now implements *IDublinCore* interface  
*PngFormat* class now implements *IDublinCore* interface  
*PsdFormat* class now implements *IDublinCore* interface  
*TiffFormat* class now implements *IDublinCore* interface  
*AviFormat* class now implements *IDublinCore* interface  
*getRights()* method has been added to *DublinCoreMetadata* class  
*getIdentifier()* method has been added to *DublinCoreMetadata* class

##### Usecases

Get Dublin Core metadata using *MetadataUtility* class.

**Java**

```csharp
File folder = new File("D:\\test");
for (File file : folder.listFiles())
{
    if (file.isFile())
    {            
        try
        {
            DublinCoreMetadata dublinCoreMetadata = (DublinCoreMetadata)MetadataUtility.extractSpecificMetadata(file.getAbsolutePath(), MetadataType.DublinCore);
            if (dublinCoreMetadata != null)
            {
                System.out.println(dublinCoreMetadata.getCreator());
                System.out.println(dublinCoreMetadata.getFormat());
                System.out.println(dublinCoreMetadata.getSubject());
            }
        }
        catch(Exception e)
        {
            System.out.println("Could not load " + file.getName());
        }
    }
}
```

Get Dublin Core metadata using *IDublinCore* interface.

**Java**

```csharp
File folder = new File("D:\\test");
for (File file : folder.listFiles())
{
    if (file.isFile())
    {            
        try
        {
            try (FormatBase format = FormatFactory.recognizeFormat(file.getAbsolutePath()))
            {
                if (format instanceof IDublinCore)
                {
                    IDublinCore dublinCoreContainer = (IDublinCore)format;
                    DublinCoreMetadata dublinCoreMetadata = dublinCoreContainer.getDublinCore();
                    if (dublinCoreMetadata != null)
                    {
                        System.out.println(dublinCoreMetadata.getCreator());
                        System.out.println(dublinCoreMetadata.getFormat());
                        System.out.println(dublinCoreMetadata.getSubject());
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Could not load " + file.getName());
        }
    }
}
```

### Reduce memory consumption of zip format metadata loading and saving 

##### Description

This enhancement allows working with zip archives with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that *ZipFormat* class implements *IDisposable* interface and it's necessary to call *Dispose()* method when you're done working with its instance.

**Java**

```csharp
try (ZipFormat format = new ZipFormat("d:\\input.zip"))
{
    // Working with the zip archive metadata
}
```

If you are loading a zip file from a stream, it's up to you to close the stream when the archive is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.zip"))
{
    try (ZipFormat format = new ZipFormat(stream))
    {
        // Working with the zip archive metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.zip"))
{
    try (ZipFormat format = new ZipFormat("d:\\input.zip"))
    {
        // Working with the zip archive metadata

        format.save(stream);
    }
    // The stream is still open here
}
```

### Implement the ability to edit the zip archive comment   

##### Description

This enhancement allows a user to edit the zip archive comment.

##### Public API changes

*setComment* method has been added to *ZipMetadata* class  
*setZipFileComment* method has been added to *ZipFormat* class

##### Usecases

Change the comment of a zip archive.

**Java**

```csharp
try (ZipFormat format = new ZipFormat("d:\\input.zip"))
{
    format.getZipInfo().setComment("test comment");        
    format.save("d:\\output.zip");
}
```

Or alternatively, you can use *ZipFormat.ZipFileComment* property.

**Java**

```csharp
try (ZipFormat format = new ZipFormat("d:\\input.zip"))
{
    format.setZipFileComment("test comment");
    format.save("d:\\output.zip");
}
```

### Reduce memory consumption of epub format metadata loading

##### Description

This enhancement allows working with epub books with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that *EpubFormat* class implements *IDisposable* interface and it's necessary to call *Dispose()* method when you're done working with its instance.

**Java**

```csharp
try (EpubFormat format = new EpubFormat("d:\\input.epub"))
{
    // Working with the epub book metadata
}
```

If you are loading an epub file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.epub"))
{
    try (EpubFormat format = new EpubFormat(stream))
    {
        // Working with the epub book metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.epub"))
{
    try (EpubFormat format = new EpubFormat("d:\\input.epub"))
    {
        // Working with the epub book metadata

        format.save(stream);
    }
    // The stream is still open here
}
```

### Reduce memory consumption of torrent format metadata loading and saving

##### Description

This enhancement allows working with torrent files with less memory consumption.

##### Public API changes

None.

##### Usecases

Please note that *TorrentFormat* class implements *IDisposable* interface and it's necessary to call *Dispose()* method when you're done working with its instance.

**Java**

```csharp
try (TorrentFormat format = new TorrentFormat("d:\\input.torrent"))
{
    // Working with the torrent file metadata
}
```

If you are loading an epub file from a stream, it's up to you to close the stream when the file is not needed anymore.

**Java**

```csharp
try (InputStream stream = new FileInputStream("d:\\input.torrent"))
{
    try (TorrentFormat format = new TorrentFormat(stream))
    {
        // Working with the torrent file metadata
    }
    // The stream is still open here
}
```

The same rule works if you are saving the output file into a stream.

**Java**

```csharp
try (OutputStream stream = new FileOutputStream("d:\\output.torrent"))
{
    try (TorrentFormat format = new TorrentFormat("d:\\input.torrent"))
    {
        // Working with the torrent file metadata

        format.save(stream);
    }
    // The stream is still open here
}
```
