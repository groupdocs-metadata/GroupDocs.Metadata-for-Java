---
id: handling-metadata-in-wav-files
url: metadata/java/handling-metadata-in-wav-files
title: Handling metadata in WAV files
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading audio details

The GroupDocs.Metadata API supports extracting technical audio information from WAV files.

The following are the steps to read audio details.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) a WAV audio
2.  Get the root metadata package
3.  Extract  the native metadata package using the [WavRootPackage.getWavPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/WavRootPackage#getWavPackage()) method
4.  Read the WAV audio properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>audio.wav.WavReadNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputWav)) {
	WavRootPackage root = metadata.getRootPackageGeneric();
	if (root.getWavPackage() != null) {
		System.out.println(root.getWavPackage().getAudioFormat());
		System.out.println(root.getWavPackage().getBitsPerSample());
		System.out.println(root.getWavPackage().getBlockAlign());
		System.out.println(root.getWavPackage().getByteRate());
		System.out.println(root.getWavPackage().getNumberOfChannels());
		System.out.println(root.getWavPackage().getSampleRate());
	}
}
```

## Extract RIFF INFO chunk metadata

The WAV format is derived from the RIFF container which acts as a wrapper for various audio and video coding formats. As a derivative of RIFF, WAV files can be tagged with metadata in the INFO chunk. The chunk may include information such as the title of the work, the author, the creation date, and copyright information. Here is an example of how the RIFF INFO metadata can be extracted:

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>audio.wav.WavReadInfoMetadata**

```csharp
try (Metadata metadata = new Metadata(Constants.InputWav)) {
    WavRootPackage root = metadata.getRootPackageGeneric();
    if (root.getRiffInfoPackage() != null) {
        System.out.println(root.getRiffInfoPackage().getArtist());
        System.out.println(root.getRiffInfoPackage().getComment());
        System.out.println(root.getRiffInfoPackage().getCopyright());
        System.out.println(root.getRiffInfoPackage().getCreationDate());
        System.out.println(root.getRiffInfoPackage().getSoftware());
        System.out.println(root.getRiffInfoPackage().getEngineer());
        System.out.println(root.getRiffInfoPackage().getGenre());
 
        // ...
    }
} 
```

## Working with XMP metadata

GroupDocs.Metadata for Java also allows managing XMP metadata in WAV files. For more details please refer to the following guide: [Working with XMP Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/managing-metadata-for-specific-formats/audio/handling-metadata-in-wav-files.md" >}})

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
