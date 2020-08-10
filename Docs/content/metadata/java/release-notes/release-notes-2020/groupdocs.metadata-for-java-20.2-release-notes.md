---
id: groupdocs-metadata-for-java-20-2-release-notes
url: metadata/java/groupdocs-metadata-for-java-20-2-release-notes
title: GroupDocs.Metadata for Java 20.2 Release Notes
weight: 12
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 20.2{{< /alert >}}

## Major Features

{{< alert style="danger" >}}In this version we're introducing a new public API which was designed to be simple and easy to use. For more details about the new API please check Public Docs section. The legacy API have been moved to the legacy package so after update to this version it is required to make project-wide replacement of package usages from com.groupdocs.metadata to com.groupdocs.metadata.legacy to resolve build issues.{{< /alert >}}

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATAJAVA-171 | New public API | Feature |
| METADATAJAVA-172 | Modality field is blank for DICOM images | Bug |

## Public API and Backward Incompatible Changes

### All public types from com.groupdocs.metadata package are moved and marked as deprecated

#### All public types from com.groupdocs.metadata package

1.  Have been moved to the **com.groupdocs.metadata.legacy** namespace
2.  Marked as **Deprecated***.*

#### Full list of types that have been moved and marked as deprecated:

###### div.rbtoc1591866174830 { padding-top: 0px; padding-right: 0px; padding-bottom: 0px; padding-left: 0px; }div.rbtoc1591866174830 ul { list-style-type: disc; list-style-image: none; margin-left: 0px; }div.rbtoc1591866174830 li { margin-left: 0px; padding-left: 0px; }

###### com.groupdocs.metadata

New package: **com.groupdocs.metadata.legacy**

Types:

*   Apev2Metadata
*   ApplicationRecordKeywords
*   AsfAudioStreamProperty
*   AsfBaseDescriptor
*   AsfBaseStreamProperty
*   AsfCodecInfo
*   AsfCodecType
*   AsfContentDescriptor
*   AsfDescriptorType
*   AsfExtendedStreamPropertiesFlags
*   AsfFilePropertiesFlag
*   AsfFormat
*   AsfMetadata
*   AsfMetadataDescriptor
*   AsfMetadataDescriptorCollection
*   AsfStreamType
*   AsfVideoStreamProperty
*   AttachedPictureFrame
*   AudioChannelType
*   AudioSampleType
*   AviFormat
*   AviHeader
*   AviHeaderFlags
*   BasicJobTicketPackage
*   BmpFormat
*   BmpHeader
*   ByteOrder
*   CadMetadata
*   CameraRawPackage
*   CanonCameraSettings
*   CanonMakerNotes
*   CellsPreviewHandler
*   ClosedChoice
*   Cms
*   CmsAttribute
*   CmsCertificate
*   CmsEncapsulatedContentInfo
*   CmsSignerInfo
*   ColorantBase
*   ColorantCMYK
*   ColorantColorMode
*   ColorantFields
*   ColorantLAB
*   ColorantRGB
*   ColorType
*   CommentsFrame
*   ComparerSearchType
*   ComparisonFacade
*   CropUnits
*   DiagramPreviewHandler
*   DICOMFormat
*   DicomMetadata
*   DigitalSignature
*   DimensionInfo
*   Dimensions
*   DjvuFormat
*   DjvuImagePreviewHandler
*   DocComment
*   DocField
*   DocFormat
*   DocInspectionOptions
*   DocInspectionResult
*   DocInspectorOptionsEnum
*   DocMetadata
*   DocMetadataProperty
*   DocumentFormat
*   DocumentInfo
*   DocumentMetadata
*   DocumentMetadataKey
*   DocumentProtectedException
*   DocumentType
*   DublinCoreMetadata
*   DublinCorePackage
*   DwgFormat
*   DxfFormat
*   EbmlReader
*   EmfFormat
*   EmlFormat
*   EmlMetadata
*   EnvelopeRecordKeywords
*   EpubFormat
*   EpubKeywords
*   EpubMetadata
*   ExifDictionaryBase
*   ExifGPSAltitudeRef
*   ExifIfdInfo
*   ExifInfo
*   ExifMetadata
*   ExifMetadataKey
*   ExportBuilder
*   ExportFacade
*   ExportFormat
*   ExportFormatter
*   FileFormatChecker
*   FileHelper
*   FileType
*   FlvFormat
*   FlvHeader
*   Font
*   FormatBase
*   FormatFactory
*   GifFormat
*   GifImagePreviewHandler
*   GpsInfo
*   GpsLocation
*   GroupDocsMetadataException
*   IBarCodeDetector
*   Id3Tag
*   Id3v1Tag
*   Id3v2Tag
*   IDocumentFormat
*   IDublinCore
*   IExif
*   IExportBuilder
*   IImageResourceBlocks
*   IInspectable
*   IInspectionOptions
*   IInspectorResult
*   IIptc
*   ImageFormat
*   ImagePreviewHandler
*   ImageResourceBlock
*   ImageResourceIds
*   ImageResourceMetadata
*   IMetadataProperty
*   InvalidFormatException
*   IProtectableFormat
*   IptcApplicationRecord
*   IptcCollection
*   IptcCorePackage
*   IptcDataSet
*   IptcDataSetCollection
*   IptcDataSetType
*   IptcEnvelopeRecord
*   IptcExtensionPackage
*   IptcIIMPackage
*   IptcMetadata
*   IptcMetadataKey
*   IptcProperty
*   IptcPropertyType
*   IReplaceHandler
*   ISignedFormat
*   IXmlValue
*   IXmp
*   IXmpType
*   Job
*   Jp2Format
*   JpegFormat
*   LangAlt
*   License
*   LoadOptions
*   Lyrics3Field
*   Lyrics3Tag
*   MakerNotesBase
*   MatroskaAudioTrackMetadata
*   MatroskaBaseMetadata
*   MatroskaContentType
*   MatroskaEbmlHeaderMetadata
*   MatroskaFormat
*   MatroskaSegmentInfoMetadata
*   MatroskaSimpleTagMetadata
*   MatroskaSubtitle
*   MatroskaSubtitleTrackMetadata
*   MatroskaTagMetadata
*   MatroskaTargetTypeValue
*   MatroskaTrackMetadata
*   MatroskaTrackType
*   MatroskaVideoDisplayUnit
*   MatroskaVideoFieldOrder
*   MatroskaVideoFlagInterlaced
*   MatroskaVideoStereoMode
*   MatroskaVideoTrackMetadata
*   Metadata
*   MetadataContainer
*   MetadataKey
*   MetadataProperty
*   MetadataPropertyCollection
*   MetadataPropertyType
*   MetadataType
*   MetadataUtility
*   MetadataValidationException
*   Metered
*   MIMEType
*   MLLTFrame
*   MovFormat
*   Mp3Format
*   MpegAudio
*   MpegChannelMode
*   MppFormat
*   MppMetadata
*   Namespaces
*   NikonMakerNotes
*   NotesPreviewHandler
*   Oid
*   OneNoteFormat
*   OneNoteMetadata
*   OneNotePageInfo
*   OpenTypeBaseNameRecord
*   OpenTypeDigitalSignatureFlags
*   OpenTypeDirectionHint
*   OpenTypeFlags
*   OpenTypeFormat
*   OpenTypeIsoEncoding
*   OpenTypeLicensingRights
*   OpenTypeMacintoshEncoding
*   OpenTypeMacintoshLanguage
*   OpenTypeMacintoshNameRecord
*   OpenTypeMetadata
*   OpenTypeName
*   OpenTypePlatform
*   OpenTypeReader
*   OpenTypeStyle
*   OpenTypeUnicodeEncoding
*   OpenTypeUnicodeNameRecord
*   OpenTypeVersion
*   OpenTypeWeight
*   OpenTypeWidth
*   OpenTypeWindowsEncoding
*   OpenTypeWindowsLanguage
*   OpenTypeWindowsNameRecord
*   OutlookMessage
*   OutlookMessageMetadata
*   PagedTextPackage
*   PageInfo
*   PanasonicMakerNotes
*   PdfAnnotation
*   PdfAttachment
*   PdfBookmark
*   PdfFormat
*   PdfFormField
*   PdfInspectionOptions
*   PdfInspectionResult
*   PdfInspectorOptionsEnum
*   PdfMetadata
*   PdfMetadataProperty
*   PdfPackage
*   PdfPreviewHandler
*   PhotoshopColorMode
*   PhotoshopPackage
*   PleaseReportException
*   PngFormat
*   PptComment
*   PptFormat
*   PptInspectionOptions
*   PptInspectionResult
*   PptInspectorOptionsEnum
*   PptMetadata
*   PptMetadataProperty
*   PptSlide
*   PreviewFactory
*   PreviewHandler
*   PreviewImageData
*   PreviewInvalidPasswordException
*   PreviewNotSupportedException
*   PreviewPage
*   PreviewUnitOfMeasurement
*   PrivateFrame
*   ProjectType
*   PropertyValue
*   ProtectableDocumentPreviewHandler
*   PsdFormat
*   PsdLayer
*   PsdMetadata
*   QuickTimeAtom
*   QuickTimeMetadata
*   Rational
*   Rectangle
*   RenditionClass
*   ResourceEvent
*   ResourceRef
*   Revision
*   RevisionCollection
*   RevisionType
*   RiffFormat
*   SearchCondition
*   SearchFacade
*   SlidesPreviewHandler
*   SonyMakerNotes
*   SRational
*   StringChoice
*   TagFrame
*   TagFrameFlags
*   TextFrame
*   Thumbnail
*   ThumbnailMetadata
*   TiffArrayTag
*   TiffAsciiTag
*   TiffByteTag
*   TiffDoubleTag
*   TiffFloatTag
*   TiffFormat
*   TiffIfd
*   TiffImagePreviewHandler
*   TiffLongTag
*   TiffRationalTag
*   TiffSByteTag
*   TiffShortTag
*   TiffSLongTag
*   TiffSRationalTag
*   TiffSShortTag
*   TiffTag
*   TiffTagIdEnum
*   TiffTagType
*   TiffUndefinedTag
*   Time
*   Timecode
*   TimeFormat
*   TorrentFileInfo
*   TorrentFormat
*   TorrentMetadata
*   UrlLinkFrame
*   UserDefinedFrame
*   UserDefinedUrlLinkFrame
*   VCardAgentRecordMetadata
*   VCardBaseMetadata
*   VCardBinaryRecordMetadata
*   VCardCalendarRecordsetMetadata
*   VCardCommunicationRecordsetMetadata
*   VCardContentType
*   VCardCustomRecordMetadata
*   VCardDateTimeRecordMetadata
*   VCardDeliveryAddressingRecordsetMetadata
*   VCardExplanatoryRecordsetMetadata
*   VCardFormat
*   VCardGeneralRecordsetMetadata
*   VCardGeographicalRecordsetMetadata
*   VCardIdentificationRecordsetMetadata
*   VCardMetadata
*   VCardOrganizationalRecordsetMetadata
*   VCardReaderCoolector
*   VCardReaderVisitor
*   VCardRecordMetadata
*   VCardRecordsetMetadata
*   VCardSecurityRecordsetMetadata
*   VCardTextRecordMetadata
*   Version
*   VisioFormat
*   VisioMetadata
*   VisioMetadataProperty
*   WavAudioInfo
*   WavFormat
*   WebPFormat
*   WhiteBalance
*   WmfFormat
*   WordsPreviewHandler
*   XlsComment
*   XlsContentProperty
*   XlsFormat
*   XlsInspectionOptions
*   XlsInspectionResult
*   XlsInspectorOptionsEnum
*   XlsMetadata
*   XlsMetadataProperty
*   XlsSheet
*   XmpAgentName
*   XmpArray
*   XmpArrayBase
*   XmpArrayType
*   XmpBasicPackage
*   XmpBoolean
*   XmpComplexType
*   XmpContainerException
*   XmpDate
*   XmpDynamicMediaPackage
*   XmpEditableCollection
*   XmpElementBase
*   XmpException
*   XmpGuid
*   XmpHeaderPI
*   XmpInteger
*   XmpLocale
*   XmpMediaManagementPackage
*   XmpMeta
*   XmpMetadata
*   XmpMetadataKey
*   XmpMetadataProperty
*   XmpMIMEType
*   XmpNodeView
*   XmpNodeViewType
*   XmpPackage
*   XmpPackageBaseCollection
*   XmpPacketWrapper
*   XmpProperties
*   XmpRational
*   XmpRdfRoot
*   XmpReal
*   XmpRightsManagementPackage
*   XmpSchemes
*   XmpText
*   XmpTrailerPI
*   XmpTypeBase
*   XmpValueBase
*   ZipCompressionMethod
*   ZipFileInfo
*   ZipFormat
*   ZipMetadata

### Modality field is blank for DICOM images

Fixed the issue when DICOM Modality attribute was always return Blank for DICOM Images using Java

##### Public API changes

None

##### Use cases

Read the DICOM header fields (including the Modality field)

**Java**

```csharp
try(com.groupdocs.metadata.Metadata metadata = new com.groupdocs.metadata.Metadata(path)) {

	DicomRootPackage root = metadata.<DicomRootPackage>getRootPackageGeneric();

	for (String field : root.getDicomPackage().getDicomInfo()) {
		System.out.println(field);
	}
}
```
