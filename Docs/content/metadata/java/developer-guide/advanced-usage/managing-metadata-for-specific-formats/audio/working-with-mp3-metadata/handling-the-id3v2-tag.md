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
## What is ID3v2?

ID3v2 is a metadata standard that is primarily used with mp3 files. Although it bears the name ID3, its structure is very different from [ID3v1]({{< ref "metadata/java/developer-guide/advanced-usage/managing-metadata-for-specific-formats/audio/working-with-mp3-metadata/handling-the-id3v1-tag.md" >}}). ID3v2 tags consist of a number of frames, each of which contains a piece of metadata.
{{< alert style="info" >}}For more information on the ID3v2 standard visit http://id3.org/id3v2.3.0. Please note there are three versions of ID3v2: ID3v2.2, ID3v2.3, ID3v2.4.{{< /alert >}}

## Reading an ID3v2 tag

The GroupDocs.Metadata API allows reading the ID3v2 tag in an MP3 audio. To get more information about ID3 tags, visit: https://en.wikipedia.org/wiki/ID3

The following steps show how to read the ID3v2 tag in an MP3 file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an MP3 file
2.  Extract the root metadata package
3.  Get the ID3v2 tag by using the [Mp3RootPackage.getID3V2](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MP3RootPackage#getID3V2()) method
4.  If the ID3v2 tag is not null then check for all of its metadata properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>audio.mp3.MP3ReadID3V2Tag**

```csharp
try (Metadata metadata = new Metadata(Constants.MP3WithID3V2)) {
    MP3RootPackage root = metadata.getRootPackageGeneric();
 
    if (root.getID3V2() != null) {
        System.out.println(root.getID3V2().getAlbum());
        System.out.println(root.getID3V2().getArtist());
        System.out.println(root.getID3V2().getBand());
        System.out.println(root.getID3V2().getTitle());
        System.out.println(root.getID3V2().getComposers());
        System.out.println(root.getID3V2().getCopyright());
        System.out.println(root.getID3V2().getPublisher());
        System.out.println(root.getID3V2().getOriginalAlbum());
        System.out.println(root.getID3V2().getMusicalKey());
 
        if (root.getID3V2().getAttachedPictures() != null) {
            for (ID3V2AttachedPictureFrame attachedPicture : root.getID3V2().getAttachedPictures()) {
                System.out.println(attachedPicture.getAttachedPictureType());
                System.out.println(attachedPicture.getMimeType());
                System.out.println(attachedPicture.getDescription());
 
                // ...
            }
        }
 
        // ...
    }
}
```

## Updating an ID3v2 tag

The GroupDocs.Metadata API supports updating the ID3v2 tag in an MP3 audio file.

The following are the steps to update the ID3v2 tag in an MP3 file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an MP3 file
2.  Extract the root metadata package
3.  Create the ID3v2 tag if it's missing
4.  Update ID3v2 fields using the [Mp3RootPackage.getID3V2](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MP3RootPackage#getID3V2()) method
5.  [Save]({{< ref "metadata/java/developer-guide/advanced-usage/saving-files/_index.md" >}}) the changes

The following code snippet shows how to update the ID3v2 tag in an MP3 file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>audio.mp3.MP3UpdateID3V2Tag**

```csharp
try (Metadata metadata = new Metadata(Constants.MP3WithID3V2)) {
    MP3RootPackage root = metadata.getRootPackageGeneric();
    if (root.getID3V2() == null) {
        root.setID3V2(new ID3V2Tag());
    }
 
    root.getID3V2().setAlbum("test album");
    root.getID3V2().setArtist("test artist");
    root.getID3V2().setBand("test band");
    root.getID3V2().setTrackNumber("1");
    root.getID3V2().setMusicalKey("C#");
    root.getID3V2().setTitle("code sample");
    root.getID3V2().setDate("2019");
 
    // ...
 
    metadata.save(Constants.OutputMp3);
}
```

## Removing an ID3v2 tag

To remove the ID3v2 tag from an MP3 audio just pass null to the [Mp3RootPackage.setID3V2](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MP3RootPackage#setID3V2(com.groupdocs.metadata.core.ID3V2Tag)) method as a parameter. The code sample below shows how to remove the ID3v2 tag from an MP3 file.

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>audio.mp3.MP3RemoveID3V2Tag**

```csharp
try (Metadata metadata = new Metadata(Constants.MP3WithID3V2)) {
    MP3RootPackage root = metadata.getRootPackageGeneric();
    root.setID3V2(null);
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
