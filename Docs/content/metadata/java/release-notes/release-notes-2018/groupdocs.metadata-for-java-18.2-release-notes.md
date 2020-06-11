---
id: groupdocs-metadata-for-java-18-2-release-notes
url: metadata/java/groupdocs-metadata-for-java-18-2-release-notes
title: GroupDocs.Metadata for Java 18.2 Release Notes
weight: 9
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 18.2.{{< /alert >}}

## Major Features

There are 3 enhancements and 6 new features in this regular monthly release. The most notable are:

*   Performance improvements - better speed of loading and saving EXIF metadata for JPEG and TIFF formats
*   Validate ID3 input metadata before saving in Mp3Format
*   Read additional properties from ID3v2 tag in Mp3Format
*   Ability to update ID3v2 tag using properties in Mp3Format
*   Ability to update ID3v1 tag using properties in Mp3Format
*   Ability to read image cover from EPUB e-book format
*   Ability to read version of EPUB format
*   Ability to read image cover from ID3 audio tag
*   Ability to update or remove image cover from ID3 audio tag in MP3 audio

## All Changes

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2155 | Performance improvements - better speed of loading and saving EXIF metadata for JPEG and TIFF formats | Enhancement  |
| METADATANET-2157   | Validate ID3 input metadata before saving in Mp3Format  | Enhancement  |
| METADATANET-2162 | Read additional properties from ID3v2 tag in Mp3Format  | Enhancement  |
| METADATANET-1230 | Ability to update ID3v2 tag using properties in Mp3Format  | New Feature  |
| METADATANET-1231 | Ability to update ID3v1 tag using properties in Mp3Format  | New Feature  |
| METADATANET-2119 | Ability to read image cover from EPUB e-book format  | New Feature  |
| METADATANET-2147  | Ability to read version of EPUB package  | New Feature  |
| METADATANET-2166 | Ability to read image cover from ID3 audio tag  | New Feature  |
| METADATANET-2170 | Ability to update or remove image cover from ID3 audio tag in MP3 audio  | New Feature  |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 18.2. It includes not only new and obsoleted public methods, but also a description of any changes in the behaviour behind the scenes in GroupDocs.Metadata which may affect existing code. Any behaviour introduced that could be seen as a regression and modifies existing behaviour is especially important and is documented here.{{< /alert >}}

#### Performance Improvements - Better speed of loading and saving EXIF metadata for JPEG and TIFF formats

##### Description

This enhancement loads and writes EXIF metadata more quickly than in previous versions.

##### Public API changes

None

##### Usecases

This example just demonstrates how to use EXIF API, all necessary improvements are hidden under the hood.

**Java**

```csharp
// path to the jpg file
String path = "C:\\\\example.jpg";

// initialize JpegFormat
JpegFormat jpegFormat = new JpegFormat(path);

// get EXIF data
JpegExifInfo exif = (JpegExifInfo)jpegFormat.getExifInfo();

if (exif == null)
{                                
 // initialize EXIF data if null
 exif = new JpegExifInfo();
}

// set artist
exif.setArtist("test artist");

// set the name of the camera's owner
exif.setCameraOwnerName("camera owner's name");

// set description
exif.setImageDescription("test description");
        
// update EXIF data
jpegFormat.setExifInfo(exif);

// commit changes
jpegFormat.save("C:\\\\result.jpg");
        
// and close the file
jpegFormat.dispose();
```

#### Validate ID3 input metadata before saving in Mp3Format 

##### Description

This enhancement allows validating ID3(both v1 and v2) input metadata before saving. Validation prevents to pass invalid data and ensures that metadata will not be broken after saving. Validation API is executed before saving (see FormatBase.Save method) and causes GroupDocsException with appropriate details about the invalid field(s).

##### Public API changes

None

##### Usecases

This example demonstrates an unsuccessful attempt to save ID3 metadata with invalid 'album' and throws GroupDocsException with the message: 'Length could not be greater than 30'.

**Java**

```csharp
String filePath = "C:\\\\download files\\\\podcast_001.mp3";
                
// init Mp3Format class
Mp3Format mp3Format = new Mp3Format(filePath);

// set album but with invalid length
mp3Format.getId3v1Properties().setAlbum("this is very looooooooong album name but must be less 30 characters");

try
{
 // and commit changes
 mp3Format.save();
}
catch (GroupDocsException e)
{
 //e.Message is "Property 'album': Length could not be grater then 30"
 System.out.println(e.getMessage());
}
            
// and close file
mp3Format.dispose();

```

### Read additional properties from ID3v2 tag in Mp3Format 

##### Description

This enhancement allows to read next properties from ID3v2 metadata:

*   Subtitle (TIT3 frame)
*   MusicalKey (TKEY frame)
*   LengthInMilliseconds (TLEN frame)
*   OriginalAlbum (TOAL frame)
*   SizeInBytes (TSIZ frame)
*   ISRC (TSRC frame)
*   SoftwareHardware (TSSE frame)
*   PlayCounter (PCNT frame)

##### Public API changes

Added new method **getSubtitle** into class **com.groupdocs.metadata.Id3v2Tag**  
Added new method **getMusicalKey** into class **com.groupdocs.metadata.Id3v2Tag**  
Added new method **getLengthInMilliseconds** into class **com.groupdocs.metadata.Id3v2Tag**  
Added new method **getOriginalAlbum** into class **com.groupdocs.metadata.Id3v2Tag**  
Added new method **getSizeInBytes** into class **com.groupdocs.metadata.Id3v2Tag**  
Added new method **getISRC** into class **com.groupdocs.metadata.Id3v2Tag**  
Added new method **getSoftwareHardware** into class **com.groupdocs.metadata.Id3v2Tag**  
Added new method **getPlayCounter** into class **com.groupdocs.metadata.Id3v2Tag**

##### Usecases

This example is shown how to read additional ID3v2 properties

**Java**

```csharp
final String filePath = "C:\\download files\\a-ha - Take On Me.mp3";
// init Mp3Format class
Mp3Format mp3Format = new Mp3Format(filePath);
// get ID3 v2 tag
Id3v2Tag id3v2 = mp3Format.getId3v2();
// close file
mp3Format.dispose();
if (id3v2 != null)
{
    // write subtitle version
    System.out.printf("Subtitle: %s\n", id3v2.getSubtitle());
    // read musical key
    System.out.printf("Musical key: %s\n", id3v2.getMusicalKey());
    // read length in milliseconds
    System.out.printf("Length in milliseconds: %s\n", id3v2.getLengthInMilliseconds());
    // read original album
    System.out.printf("Original album: %s\n", id3v2.getOriginalAlbum());
    // read size in bytes. Please note that is present TSIZ tag and may be overrided by invalid value
    System.out.printf("Size in bytes: %s\n", id3v2.getSizeInBytes());
    // read TSRC value
    System.out.printf("ISRC: %s\n", id3v2.getISRC());
    // read TSSE value
    System.out.printf("Software/Hardware: %s\n", id3v2.getSoftwareHardware());
    // read PCNT value
    System.out.printf("Play counter: %d\n", id3v2.getPlayCounter());
    // in trial mode only first 5 frames are available
    TagFrame[] idFrames = id3v2.getFrames();
    for (TagFrame tagFrame : idFrames)
    {
        System.out.printf("Frame: %s, value: %s\n", tagFrame.getName(), tagFrame.getFormattedValue());
    }
}

```

### Ability to update ID3v2 tag using properties in Mp3Format  

##### Description

This feature provides an easy way to update ID3v2 metadata in Mp3Format. Library updates ID3v2 if specific properties were changed in user code. Otherwise - the update will not happen.

##### Public API changes

Added **getId3v2Properties** method into class **com.groupdocs.metadata.Mp3Format**

##### Usecases

This example demonstrates how to update ID3v2 metadata using properties

```csharp
final String filePath = "C:\\download files\\a-ha - Take On Me.mp3";

// init Mp3Format class
Mp3Format mp3Format = new Mp3Format(filePath);

// get id3v2 tag
Id3v2Tag id3Tag = mp3Format.getId3v2Properties();
                
// set artist
id3Tag.setArtist("A-ha");

// set title
id3Tag.setTitle("Take on me");                

// commit changes
mp3Format.save();
        
// and close file
mp3Format.dispose();
```

### Ability to update ID3v1 tag using properties in Mp3Format 

##### Description

This feature provides an easy way to update ID3v1 metadata in Mp3Format. Library updates ID3v1 if specific properties were changed in user code. Otherwise - the update will not happen.

##### Public API changes

Added **getId3v1Properties** method into class **com.groupdocs.metadata.Mp3Format**

##### Usecases

This example demonstrates how to update ID3v1 metadata using properties

```csharp
final String filePath = "C:\\download files\\a-ha - Take On Me.mp3";
// init Mp3Format class
Mp3Format mp3Format = new Mp3Format(filePath);
// get id3v1 tag
Id3v1Tag id3Tag = mp3Format.getId3v1Properties();
// set artist
id3Tag.setArtist("A-ha");
// set title
id3Tag.setTitle("Take on me");
// commit changes
mp3Format.save();
// and close file
mp3Format.dispose();
```

### Ability to read image cover from EPUB e-book format 

##### Description

This feature allows reading image cover from EPUB format

##### Public API changes

Added **getImageCoverBytes** method into class **com.groupdocs.metadata.EpubFormat**

##### Usecases

This example demonstrates how to read image cover data from EpubFormat

```csharp
// path to the EPUB file
String file = "C:\\\\download files\\\\wells-anticipations.epub";
// open EPUB file
EpubFormat epub = new EpubFormat(file);
// read image cover as array of bytes
byte[] imageCoverData = epub.getImageCoverBytes();
// store image data to file
// ...
```

### Ability to read version of EPUB package 

##### Description

This feature allows reading version of EPUB (2.1, 3.0, 3.1). Version is placed in 'version' attribute of the root of 'package' element

##### Public API changes

Added **getVersion** method into class **com.groupdocs.metadata.EpubMetadata**

##### Usecases

This example demonstrates how to read version of EPUB format

```csharp
// path to the EPUB file
String file = "C:\\\\download files\\\\wells-anticipations.epub";
// open EPUB file
EpubFormat epub = new EpubFormat(file);
// read EPUB metadata
EpubMetadata metadata = epub.getEpubMetadata();
// close file after getting metadata
epub.dispose();
// and print version
System.out.printf("EPUB version = %s", metadata.getVersion()); 
```

### Ability to read image cover from ID3 audio tag  

##### Description

This feature allows reading image cover data from ID3(v2) tag in Mp3Format

##### Public API changes

Added new method **getImageCover** into class **com.groupdocs.metadata.Id3v2Tag**

##### Usecases

This example demonstrates how to read image cover bytes from ID3(v2) tag in Mp3Format

```csharp
// path to the file
final String filePath = "C:\\download files\\a-ha - Take On Me.mp3";
// init Mp3Format class
Mp3Format mp3Format = new Mp3Format(filePath);
// get ID3 v2 tag
Id3v2Tag id3v2 = mp3Format.getId3v2();
// close file after getting metadata
mp3Format.dispose();
if (id3v2 == null){
    return;
}
// read all APIC frames
TagFrame[] frames = id3v2.readFrames("APIC");
// get first exist APIC frame
if (frames != null && frames.length == 1)
{
    // get AttachedPictureFrame
    AttachedPictureFrame picture = (AttachedPictureFrame)frames[0];
    // get image bytes
    byte[] imageData = picture.getPictureData();
    // get MIME type
    String mime = picture.getMIMEType();
    System.out.printf("Mime type = %s, size = %d\n", mime, imageData.length);
    // write bytes to file
    // ..
}
```

### Ability to update or remove image cover from ID3 audio tag in MP3 audio 

##### Description

This feature allows to update/remove image data from ID3(v2) tag in Mp3Format

##### Public API changes

Added **removeImageCover** method into **com.groupdocs.metadata.Id3v2Tag** class

##### Usecases

This example demonstrates how to remove image data from ID3(v2) tag in Mp3Format

```csharp
// path to the file
final String filePath = "C:\\download files\\a-ha - Take On Me.mp3";
final String outPath = "C:\\download files\\a-ha - Take On Me(no cover).mp3";
// init Mp3Format class
Mp3Format mp3Format = new Mp3Format(filePath);
// get ID3 v2 tag
Id3v2Tag id3v2 = mp3Format.getId3v2();
if (id3v2 != null){
    // remove image cover
    id3v2.removeImageCover();
    // update tag
    mp3Format.updateId3v2(id3v2);
    // save changes
    mp3Format.save(outPath);
}
// and close file
mp3Format.dispose();
```
