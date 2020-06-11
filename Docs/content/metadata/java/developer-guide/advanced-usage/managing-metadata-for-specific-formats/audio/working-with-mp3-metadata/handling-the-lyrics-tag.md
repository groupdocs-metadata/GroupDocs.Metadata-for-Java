---
id: handling-the-lyrics-tag
url: metadata/java/handling-the-lyrics-tag
title: Handling the Lyrics tag
weight: 3
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## What is Lyrics tag?

Lyrics3 Tag is a chunk of data which begins with "LYRICSBEGIN", ends with "LYRICSEND" and has the lyrics between these keywords. This data block is then saved in the audio file between the audio and the ID3 tag. If no ID3 tag is present one must be attached.

{{< alert style="info" >}}For more information, please visit: http://id3.org/Lyrics3{{< /alert >}}

## Reading a Lyrics tag

The GroupDocs.Metadata API allows reading the Lyrics3 tag in an MP3 file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/managing-metadata-for-specific-formats/audio/working-with-mp3-metadata/handling-the-lyrics-tag.md" >}}) an MP3 file
2.  Extract the root metadata package
3.  Get the Lyrics tag by using the [MP3RootPackage.getLyrics3V2](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MP3RootPackage#getLyrics3V2())method
4.  If the Lyrics tag is not null then check for all of its properties

The following code snippet reads the Lyrics tag from an MP3 file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.audio.mp3.MP3ReadLyricsTag**

```csharp
try (Metadata metadata = new Metadata(Constants.MP3WithLyrics)) {
	MP3RootPackage root = metadata.getRootPackageGeneric();
	if (root.getLyrics3V2() != null) {
		System.out.println(root.getLyrics3V2().getLyrics());
		System.out.println(root.getLyrics3V2().getAlbum());
		System.out.println(root.getLyrics3V2().getArtist());
		System.out.println(root.getLyrics3V2().getTrack());

		// ...
		// Alternatively, you can loop through a full list of tag fields
		for (LyricsField field : root.getLyrics3V2().toList()) {
			System.out.println(String.format("%s = %s", field.getID(), field.getData()));
		}
	}
}
```

## Updating a Lyrics tag

The GroupDocs.Metadata API supports updating the Lyrics tag in an MP3 audio file.

The following are the steps to update the Lyrics tag in an MP3 file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an MP3 file
2.  Extract the root metadata package
3.  Create the Lyrics tag if it's missing
4.  Update Lyrics fields using the [MP3RootPackage.getLyrics3V2](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MP3RootPackage#getLyrics3V2())method
5.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/saving-files/_index.md" >}}) the changes

The following code snippet shows how to update the Lyrics tag in an MP3 file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.audio.mp3.MP3UpdateLyricsTag**

```csharp
try (Metadata metadata = new Metadata(Constants.MP3WithLyrics)) {
	MP3RootPackage root = metadata.getRootPackageGeneric();
	if (root.getLyrics3V2() == null) {
		root.setLyrics3V2(new LyricsTag());
	}
	root.getLyrics3V2().setLyrics("[00:01]Test lyrics");
	root.getLyrics3V2().setArtist("test artist");
	root.getLyrics3V2().setAlbum("test album");
	root.getLyrics3V2().setTrack("test track");

	// You can add a fully custom field to the tag
	root.getLyrics3V2().set(new LyricsField("ABC", "custom value"));

	// ...

	metadata.save(Constants.OutputMp3);
}
```

## Removing a Lyrics tag

To remove the Lyrics tag from an MP3 audio just pass null to the [MP3RootPackage.setLyrics3V2](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MP3RootPackage#setLyrics3V2(com.groupdocs.metadata.core.LyricsTag)) method. The code sample below shows how to remove the Lyrics tag from an MP3 file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.audio.mp3.MP3RemoveLyricsTag**

```csharp
try (Metadata metadata = new Metadata(Constants.MP3WithLyrics)) {
	MP3RootPackage root = metadata.getRootPackageGeneric();
	root.setLyrics3V2(null);
	metadata.save(Constants.OutputMp3);
}
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
