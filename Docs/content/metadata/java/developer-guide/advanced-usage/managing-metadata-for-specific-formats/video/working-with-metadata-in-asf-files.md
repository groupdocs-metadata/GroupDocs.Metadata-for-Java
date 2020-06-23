---
id: working-with-metadata-in-asf-files
url: metadata/java/working-with-metadata-in-asf-files
title: Working with metadata in ASF files
weight: 1
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading ASF format-specific properties

The GroupDocs.Metadata API supports extracting format-specific information from ASF files.

The following are the steps to read native ASF metadata.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an ASF video
2.  Get the root metadata package
3.  Extract  the native metadata package using the [AsfRootPackage.getAsfPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/AsfRootPackage#getAsfPackage()) method
4.  Read the ASF metadata properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.video.asf.AsfReadNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputAsf)) {
	AsfRootPackage root = metadata.getRootPackageGeneric();
	AsfPackage asfPackage = root.getAsfPackage();

	// Display basic properties
	System.out.println(String.format("Creation date: %s", asfPackage.getCreationDate()));
	System.out.println(String.format("File id: %s", asfPackage.getFileID()));
	System.out.println(String.format("Flags: %s", asfPackage.getFlags()));

	// Display Asf Codec Information
	for (AsfCodec codecInfo : asfPackage.getCodecInformation()) {
		System.out.println(String.format("Codec type: %s", codecInfo.getCodecType()));
		System.out.println(String.format("Description: %s", codecInfo.getDescription()));
		System.out.println(String.format("Codec information: %s", codecInfo.getInformation()));
		System.out.println(codecInfo.getName());
	}

	// Display metadata descriptors
	for (AsfBaseDescriptor descriptor : asfPackage.getMetadataDescriptors()) {
		System.out.println(String.format("Name: %s", descriptor.getName()));
		System.out.println(String.format("Value: %s", descriptor.getValue()));
		System.out.println(String.format("Content type: %s", descriptor.getAsfContentType()));
		if (descriptor instanceof AsfMetadataDescriptor) {
			AsfMetadataDescriptor metadataDescriptor = (AsfMetadataDescriptor) descriptor;
			System.out.println(String.format("Language: %s", metadataDescriptor.getLanguage()));
			System.out.println(String.format("Stream number: %s", metadataDescriptor.getStreamNumber()));
			System.out.println(String.format("Original name: %s", metadataDescriptor.getOriginalName()));
		}
	}

	//Display the base stream properties
	for (AsfBaseStreamProperty property : asfPackage.getStreamProperties()) {
		System.out.println(String.format("Alternate bitrate: %s", property.getAlternateBitrate()));
		System.out.println(String.format("Average bitrate: %s", property.getAverageBitrate()));
		System.out.println(String.format("Average time per frame: %s", property.getAverageTimePerFrame()));
		System.out.println(String.format("Bitrate: %s", property.getBitrate()));
		System.out.println(String.format("Stream end time: %s", property.getEndTime()));
		System.out.println(String.format("Stream flags: %s", property.getFlags()));
		System.out.println(String.format("Stream language: %s", property.getLanguage()));
		System.out.println(String.format("Stream start time: %s", property.getStartTime()));
		System.out.println(String.format("Stream number: %s", property.getStreamNumber()));
		System.out.println(String.format("Stream type: %s", property.getStreamType()));

		//Display the audio stream properties
		if (property instanceof AsfAudioStreamProperty) {
			AsfAudioStreamProperty audioStreamProperty = (AsfAudioStreamProperty) property;
			System.out.println(String.format("Audio bits per sample: %s", audioStreamProperty.getBitsPerSample()));
			System.out.println(String.format("Audio channels: %s", audioStreamProperty.getChannels()));
			System.out.println(String.format("Audio format tag: %s", audioStreamProperty.getFormatTag()));
			System.out.println(String.format("Audio samples per second: %s", audioStreamProperty.getSamplesPerSecond()));
		}

		//Display the video stream properties
		if (property instanceof AsfVideoStreamProperty) {
			AsfVideoStreamProperty videoStreamProperty = (AsfVideoStreamProperty) property;
			System.out.println(String.format("Video bits per pixels: %s", videoStreamProperty.getBitsPerPixels()));
			System.out.println(String.format("Compression: %s", videoStreamProperty.getCompression()));
			System.out.println(String.format("Image height: %s", videoStreamProperty.getImageHeight()));
			System.out.println(String.format("Image width: %s", videoStreamProperty.getImageWidth()));
		}
	}
}
```

## Working with XMP metadata

GroupDocs.Metadata for Java allows managing XMP metadata in ASF files. For more details please refer to the following guide: [Working with XMP Metadata]({{< ref "metadata/java/developer-guide/advanced-usage/working-with-metadata-standards/working-with-xmp-metadata.md" >}}).

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
