---
id: groupdocs-metadata-for-java-19-4-release-notes
url: metadata/java/groupdocs-metadata-for-java-19-4-release-notes
title: GroupDocs.Metadata for Java 19.4 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 19.4.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Implement the ability to read Matroska subtitles
*   Implement the ability to read original encoded names of ZIP archive entries

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-2698 | Implement the ability to read Matroska subtitles | New Feature |
| METADATANET-2761 | Implement the ability to read original encoded names of ZIP archive entries | Enhancement |

##   
Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 19.3. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Implement the ability to read Matroska subtitles

This new feature allows a user to read subtitles built in a video file encoded with the Matroska media container.

**Public API changes**

The *getSubtitleTracks* method has been added to the *MatroskaFormat *class

The *get**ScaledDuration* method has been added to the *MatroskaSegmentInfoMetadata *class

The *MatroskaSubtitle* class has been added to the *com.groupdocs.metadata* package

The *get**Timecode* method has been added to the *MatroskaSubtitle *class

The *get**Duration* method has been added to the *MatroskaSubtitle *class

The *get**Text* method has been added to the *MatroskaSubtitle *class

The *MatroskaSubtitleTrackMetadata* class has been added to the *com.groupdocs.metadata*package

The *get**Subtitles* method has been added to the *MatroskaSubtitleTrackMetadata *class

The *Undefined* public static field has been added to the *MatroskaTrackType *class

The *MatroskaTrackType.Unefined* public static field has been marked as deprecated

##### Use cases

Read all subtitles stored in an MKV video

**Java**

```csharp
public static void main(String[] args)
{    
	License license = new License();
	license.setLicense("D:\\GroupDocs.Metadata.lic");
	 
	try (MatroskaFormat format = new MatroskaFormat("D:\\input.mkv"))
	{
		for (MatroskaSubtitleTrackMetadata subtitleTrack : format.getSubtitleTracks())
		{
			String language = subtitleTrack.getLanguageIetf() ;
			if (language == null)
			{
				language = subtitleTrack.getLanguage();
			}
			System.out.println(language);
			for (MatroskaSubtitle subtitle : subtitleTrack.getSubtitles())
			{
				System.out.println(
								"Timecode = " + millisecondsToTimeFormattedString(subtitle.getTimecode()) + 
								", Duration = " + millisecondsToTimeFormattedString(subtitle.getDuration()));
				System.out.println(subtitle.getText());
			}
		}
	}
}

private static String millisecondsToTimeFormattedString(double milliseconds)
{
	Date date = new Date((long)milliseconds);
	DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
	formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	return formatter.format(date);
}
```

### Implement the ability to read original encoded names of ZIP archive entries

All filenames are stored in a ZIP archive as sequences of bytes and it’s up to the file archiver which encoding is used for interpreting and persisting the names. If you use GroupDocs.Metadata to extract information about archived files having non-ASCII characters in their names you may find that sometimes they are interpreted incorrectly. If you are aware of the exact encoding used to store the filenames, you can read them properly using a new method introduced in this enhancement .

##### Public API changes

The get*RawName* method has been added to the *ZipFileInfo* class

##### Use cases

Read all entries of a ZIP archive using a specific charset

**Java**

```csharp
// Use a specific charset for filenames
Charset charset = Charset.forName("cp866");
try (ZipFormat format = new ZipFormat("D:\\input.zip"))
{
	for (ZipFileInfo file : format.getZipInfo().getFiles())
	{
		// Use the getRawName method to get the sequence of bytes representing the filename
		System.out.println(new String(file.getRawName(), charset));
	}
}
```
