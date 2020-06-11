---
id: working-with-metadata-in-matroska-(mkv)-files
url: metadata/java/working-with-metadata-in-matroska-(mkv)-files
title: Working with metadata in Matroska (MKV) files
weight: 4
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
## Reading matroska format-specific properties

The GroupDocs.Metadata API supports extracting format-specific information from MKV files.

The following are the steps to read native MKV metadata.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an MKV video
2.  Get the root metadata package
3.  Extract  the native metadata package using the [MatroskaRootPackage.getMatroskaPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MatroskaRootPackage#getMatroskaPackage()) method
4.  Read the Matroska metadata properties on different levels of the format structure

**advanced\_usage.managing\_metadata\_for\_specific\_formats.video.matroska.MatroskaReadNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputMkv)) {
	MatroskaRootPackage root = metadata.getRootPackageGeneric();
	// Read the EBML header
	System.out.println(String.format("DocType: %s", root.getMatroskaPackage().getEbmlHeader().getDocType()));
	System.out.println(String.format("DocTypeReadVersion: %s", root.getMatroskaPackage().getEbmlHeader().getDocTypeReadVersion()));
	System.out.println(String.format("DocTypeVersion: %s", root.getMatroskaPackage().getEbmlHeader().getDocTypeVersion()));
	System.out.println(String.format("ReadVersion: %s", root.getMatroskaPackage().getEbmlHeader().getReadVersion()));
	System.out.println(String.format("Version: %s", root.getMatroskaPackage().getEbmlHeader().getVersion()));

	// Read Matroska segment information
	for (MatroskaSegment segment : root.getMatroskaPackage().getSegments()) {
		System.out.println(String.format("DateUtc: %s", segment.getDateUtc()));
		System.out.println(String.format("Duration: %s", segment.getDuration()));
		System.out.println(String.format("MuxingApp: %s", segment.getMuxingApp()));
		System.out.println(String.format("SegmentFilename: %s", segment.getSegmentFilename()));
		System.out.println(String.format("SegmentUid: %s", segment.getSegmentUid()));
		System.out.println(String.format("TimecodeScale: %s", segment.getTimecodeScale()));
		System.out.println(String.format("Title: %s", segment.getTitle()));
		System.out.println(String.format("WritingApp: %s", segment.getWritingApp()));
	}

	// Read Matroska tag metadata
	for (MatroskaTag tag : root.getMatroskaPackage().getTags()) {
		System.out.println(String.format("TargetType: %s", tag.getTargetType()));
		System.out.println(String.format("TargetTypeValue: %s", tag.getTargetTypeValue()));
		System.out.println(String.format("TagTrackUid: %s", tag.getTagTrackUid()));
		for (MetadataProperty simpleTag : tag.getSimpleTags()) {
			System.out.println(String.format("Name: %s", simpleTag.getName()));
			System.out.println(String.format("Value: %s", simpleTag.getValue()));
		}
	}

	// Read Matroska track metadata
	for (MatroskaTrack track : root.getMatroskaPackage().getTracks()) {
		System.out.println(String.format("CodecId: %s", track.getCodecID()));
		System.out.println(String.format("CodecName: %s", track.getCodecName()));
		System.out.println(String.format("DefaultDuration: %s", track.getDefaultDuration()));
		System.out.println(String.format("FlagEnabled: %s", track.getFlagEnabled()));
		System.out.println(String.format("Language: %s", track.getLanguage()));
		System.out.println(String.format("LanguageIetf: %s", track.getLanguageIetf()));
		System.out.println(String.format("Name: %s", track.getName()));
		System.out.println(String.format("TrackNumber: %s", track.getTrackNumber()));
		System.out.println(String.format("TrackType: %s", track.getTrackType()));
		System.out.println(String.format("TrackUid: %s", track.getTrackUid()));
		if (track instanceof MatroskaAudioTrack) {
			MatroskaAudioTrack audioTrack = (MatroskaAudioTrack) track;
			System.out.println(String.format("SamplingFrequency: %s", audioTrack.getSamplingFrequency()));
			System.out.println(String.format("OutputSamplingFrequency: %s", audioTrack.getOutputSamplingFrequency()));
			System.out.println(String.format("Channels: %s", audioTrack.getChannels()));
			System.out.println(String.format("BitDepth: %s", audioTrack.getBitDepth()));
		}
		if (track instanceof MatroskaVideoTrack) {
			MatroskaVideoTrack videoTrack = (MatroskaVideoTrack) track;
			System.out.println(String.format("FlagInterlaced: %s", videoTrack.getFlagInterlaced()));
			System.out.println(String.format("FieldOrder: %s", videoTrack.getFieldOrder()));
			System.out.println(String.format("StereoMode: %s", videoTrack.getStereoMode()));
			System.out.println(String.format("AlphaMode: %s", videoTrack.getAlphaMode()));
			System.out.println(String.format("PixelWidth: %s", videoTrack.getPixelWidth()));
			System.out.println(String.format("PixelHeight: %s", videoTrack.getPixelHeight()));
			System.out.println(String.format("PixelCropBottom: %s", videoTrack.getPixelCropBottom()));
			System.out.println(String.format("PixelCropTop: %s", videoTrack.getPixelCropTop()));
			System.out.println(String.format("PixelCropLeft: %s", videoTrack.getPixelCropLeft()));
			System.out.println(String.format("PixelCropRight: %s", videoTrack.getPixelCropRight()));
			System.out.println(String.format("DisplayWidth: %s", videoTrack.getDisplayWidth()));
			System.out.println(String.format("DisplayHeight: %s", videoTrack.getDisplayHeight()));
			System.out.println(String.format("DisplayUnit: %s", videoTrack.getDisplayUnit()));
		}
	}
}
```

## Extracting subtitles from a Matroska video

The GroupDocs.Metadata API also provides a convenient way of extracting subtitles attached to a Matroska video. The code sample below demonstrates how to extract multilingual subtitles from an MKV file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an MKV video
2.  Get the root metadata package
3.  Use the [MatroskaPackage.getSubtitleTracks](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/MatroskaPackage#getSubtitleTracks()) method to extract sets of subtitles in different languages

**advanced\_usage.managing\_metadata\_for\_specific\_formats.video.matroska.MatroskaReadSubtitles**

```csharp
try (Metadata metadata = new Metadata(Constants.MkvWithSubtitles)) {
	MatroskaRootPackage root = metadata.getRootPackageGeneric();

	for (MatroskaSubtitleTrack subtitleTrack : root.getMatroskaPackage().getSubtitleTracks()) {
		System.out.println(subtitleTrack.getLanguageIetf() != null ? subtitleTrack.getLanguageIetf() : subtitleTrack.getLanguage());
		for (MatroskaSubtitle subtitle : subtitleTrack.getSubtitles()) {
			System.out.println(String.format("Timecode=%s, Duration=%s", subtitle.getTimecode(), subtitle.getDuration()));
			System.out.println(subtitle.getText());
		}
	}
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
