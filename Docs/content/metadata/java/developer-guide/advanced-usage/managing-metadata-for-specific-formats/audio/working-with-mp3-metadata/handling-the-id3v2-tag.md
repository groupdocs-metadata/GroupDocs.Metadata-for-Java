---
id: handling-the-id3v2-tag
url: metadata/java/handling-the-id3v2-tag
title: Handling the ID3v2 tag
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
# Handling the ID3v1 tag

## What is ID3v1?

ID3v1 is a metadata tag that is usually used with MP3 audio files. The whole tag occupies 128 bytes and allows adding metadata properties such as title, artist, album, track number, etc.The ID3v1 standard was introduced in 1996 but it's still widely supported by various audio players and decoders. To get more information about ID3v1 tags please visit [http://id3.org/ID3v1](http://id3.org/ID3v1).

## Reading an ID3v1 tag

The following steps show how to read the ID3v1 tag in an MP3 file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an MP3 file
2.  Extract the root metadata package
3.  Get the ID3v1 tag by using the [Mp3RootPackage.getID3V1](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MP3RootPackage#getID3V1()) method
4.  If the ID3v1 tag is not null then check for all of its metadata properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.audio.mp3.MP3ReadID3V1Tag**

```csharp
try (Metadata metadata = new Metadata(Constants.MP3WithID3V1)) {
	MP3RootPackage root = metadata.getRootPackageGeneric();
	if (root.getID3V1() != null) {

		System.out.println(root.getID3V1().getAlbum());
		System.out.println(root.getID3V1().getArtist());
		System.out.println(root.getID3V1().getTitle());
		System.out.println(root.getID3V1().getVersion());
		System.out.println(root.getID3V1().getComment());

		// ...
	}
}
```

## Updating an ID3v1 tag

The following are the steps to update the ID3v1 tag in an MP3 file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an MP3 file
2.  Extract the root metadata package
3.  Create the ID3v1 tag if it's missing
4.  Update ID3v1 fields using the [Mp3RootPackage.getID3V1](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MP3RootPackage#getID3V1()) method
5.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/saving-files/_index.md" >}}) the changes

The following code snippet shows how to update the ID3v1 tag in an MP3 file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.audio.mp3.MP3UpdateID3V1Tag**

```csharp
try (Metadata metadata = new Metadata(Constants.MP3WithID3V1)) {
	MP3RootPackage root = metadata.getRootPackageGeneric();
	if (root.getID3V1() == null) {
		root.setID3V1(new ID3V1Tag());
	}

	root.getID3V1().setAlbum("test album");
	root.getID3V1().setArtist("test artist");
	root.getID3V1().setTitle("test title");
	root.getID3V1().setComment("test comment");
	root.getID3V1().setYear("2019");

	// ...

	metadata.save(Constants.OutputMp3);
}
```

## Removing an ID3v1 tag

To remove the ID3v1 tag from an MP3 audio just pass null to the [Mp3RootPackage.setID3V1](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MP3RootPackage#setID3V1(com.groupdocs.metadata.core.ID3V1Tag)) method as a parameter. The code sample below shows how to remove the ID3v1 tag from an MP3 file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.audio.mp3.MP3RemoveID3V1Tag**

```csharp
try (Metadata metadata = new Metadata(Constants.MP3WithID3V1)) {
	MP3RootPackage root = metadata.getRootPackageGeneric();
	root.setID3V1(null);
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
