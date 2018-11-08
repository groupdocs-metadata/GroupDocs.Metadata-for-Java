package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.examples.Utilities.Common;

public class MainClass {
	public static void main(String[] args) {

		//region Working with licensing
		// Uncomment following code if you have license file
         Common.applyLicenseFromFile();

		// Using metered license
		// Common.useDynabicMeteredAccount();
		//endregion

		//region Working with Documents

		//region Working Doc files
		// Get document properties of Doc file
		// Documents.Doc.getDocumentProperties();

		// Update document properties of Doc file
		// Documents.Doc.updateDocumentProperties();

		// Remove document properties of Doc file
		// Documents.Doc.removeDocumentProperties();

		// Add custom property in Doc file
		// Documents.Doc.addCustomProperty();

		// Get custom properties in Doc file
		// Documents.Doc.getCustomProperties();

		// Remove custom property of Doc file
		// Documents.Doc.removeCustomProperties();

		// Clear custom property of Doc file
		// Documents.Doc.clearCustomProperties();

		// Get hidden fields, merge fields and comments in Doc file
		// Documents.Doc.getHiddenData();

		// Remove Hidden Data in Doc file
		// Documents.Doc.removeHiddenData();

		// Remove merge fields in Doc file
		// Documents.Doc.removeMergeFields();

		// Read document comments
		// Documents.Doc.readComments();

		// Remove document comments
		// Documents.Doc.removeComments();

		// Update document comments
		// Documents.Doc.updateComments();

		// update metadata and save the original file
		// Documents.Doc.saveFileAfterMetadataUpdate();

		// Read all metadata Keys of word document
		// Documents.Doc.readMetadataUsingKeys("Different Formats");**

		// Read Document info of a word document
		// Documents.Doc.readDocumentInfo();

		// Lazy Load Document info of a word document
		// Documents.Doc.lazyLoadDocumentInfoProperty();

		// Detect Document Type of word document
		// Documents.Doc.detectDocumentType();

		// Detect protected Document
		// Documents.Doc.detectProtectedDocument();

		// Document Protected Exception in Doc Format
		// Documents.Doc.documentProtectedException();

		// Read Digital Signature from word document
		// Documents.Doc.readDigitalSignature();

		// Remove Digital Signature from word document
		// Documents.Doc.removeDigitalSignature();

		//Read DublinCore Metadata
		//Documents.Doc.readDublinCoreMetadata();

		//Read ImageCover using Metadata Utility
		//Documents.Doc.readImageCoverMetadataUtility();

		//Find Metadata Using Regex
		//Documents.Doc.findMetadataUsingRegex();

		//Replace Metadata Using Regex
		//Documents.Doc.replaceMetadataUsingRegex();
		//endregion

		//region Working with Ppt files

		// Get document properties of Ppt file
		// Documents.Ppt.getDocumentProperties();

		// Update document properties of Ppt file
		// Documents.Ppt.updateDocumentProperties();

		// Remove document properties of Ppt file
		// Documents.Ppt.removeDocumentProperties();

		// Add custom property in Ppt file
		// Documents.Ppt.addCustomProperty();

		// Get custom properties in Ppt file
		// Documents.Ppt.getCustomProperties();

		// Remove custom property of Ppt file
		// Documents.Ppt.removeCustomProperties();

		// Gets Comments, and Hidden Slides of Ppt file
		// Documents.Ppt.getHiddenData();

		// Removes Comments, and Hidden Slides of Ppt File
		// Documents.Ppt.removeHiddenData();
		//endregion

		//region Working with Xls files

		// Get document properties of Xls file
		 Documents.Xls.getDocumentProperties();

		// Update document properties of Xls file
		 Documents.Xls.updateDocumentProperties();

		// Remove document properties of Xls file
		// Documents.Xls.removeDocumentProperties();

		// Add custom property in Xls file
		// Documents.Xls.addCustomProperty();

		// Get custom properties in Xls file
		// Documents.Xls.getCustomProperties();

		// Remove custom property of Xls file
		// Documents.Xls.removeCustomProperties();

		// Gets Content type document properties in Xls file
		// Documents.Xls.getContentTypeDocumentProperties();

		// Add content type properties
		// Documents.Xls.addContentTypeProperty();

		// Reads thumbnail in excel file
		// Documents.Xls.readThumbnailXls();

		// Export content type properties of Xls file to Csv/Xls
		// Documents.Xls.exportContentTypeProperties();

		/// Get hidden data in Xls file
		// Documents.Xls.getHiddenData();

		// Remove Hidden Data in Xls file
		// Documents.Xls.removeHiddenData();

		// Read ImageCover using Metadata Utility
		// Documents.Xls.readImageCoverMetadataUtility();

		//endregion

		//region Working with Pdf files

		// Get document properties of Pdf file
		// Documents.Pdf.getDocumentProperties();

		// Update document properties of Pdf file
		// Documents.Pdf.updateDocumentProperties();

		// Remove document properties of Pdf file
		// Documents.Pdf.removeDocumentProperties();

		// Add custom property in Pdf file
		// Documents.Pdf.addCustomProperty();

		// Get custom properties in Pdf file
		// Documents.Pdf.getCustomProperties();

		// Remove custom property of Pdf file
		// Documents.Pdf.removeCustomProperties();

		// Get XMP data in Pdf file
		// Documents.Pdf.getXMPProperties();

		// Update XMP data in Pdf file
		// Documents.Pdf.updateXMPProperties();

		// Remove hidden data in Pdf file
		// Documents.Pdf.removeHiddenData();

		//Read DublinCore Metadata
		//Documents.Pdf.readDublinCoreMetadata();

		//endregion

		//region Working with MSVisio files

		// Get metadata of MSVisio file
		// Documents.MSVisio.getMetadata();

		// Set metadata of MSVisio File
		// Documents.MSVisio.updateMetadata();

		//endregion

		//region Working with OneNote files

		// Get Pages Info of OneNote file
		// Documents.OneNote.getPagesInfo();

		//endregion

		//region Working with MSProject files

		// Get Metadata
		// Documents.MSProject.getMetadata();

		//Update MS Project Metadata
		//Documents.MSProject.updateMetadata();

		//Clean MS Project Metadata
		//Documents.MSProject.cleanMetadata();

		//Update MS Project Metadata using Stream
		//Documents.MSProject.updateMetadataUsingStream();

		//endregion

		//region Working with Odt files

		// Read metadata of odt File
		// Documents.ODT.getOdtMetadata();

		// Update metadata of odt file
		// Documents.ODT.updateOdtMetadata();

		//endregion

		//region Working with ODS files
		// Documents.ODS.readOdsMetadata();
		//endregion

		//region Working EPUB file

		//Detects EPUB file format
		//Documents.EPUB.detectEPUBFormat();

		//Read EPUB file format metadata
		//Documents.EPUB.readEPUBFormatMetadata();

		//Read Dublin Core Metadata
		//Documents.EPUB.readDublinCoreMetadata();

		//Read Image covr from EPUB Format
		//Documents.EPUB.readImageCover();

		//Read version of EPUB Package
		//Documents.EPUB.readEPUBPackageVersion();

		//Read DublinCore Metadata using unified approach
		//Documents.EPUB.readDublinCoreMetadataUtility();

		//Get Torrent Metadata Using Stream
		//Documents.EPUB.getMetadataUsingStream();

		//endregion

		//endregion

		//region Working with Images

		//region working with JP2 images
		// Read Metadata of JP2 Format
		// Images.JP2.readMetadataJP2();

		// Read XMP properties of Jpeg2000 image
		// Images.JP2.readXMPProperties();

		// Update XMP properties of Jpeg2000 image
		// Images.JP2.updateXMPProperties();

		// Remove XMP properties of Jpeg2000 image
		// Images.JP2.removeXMPProperties();

		//endregion

		//region Working with Gif

		// Get XMP properties of Gif image
		// Images.Gif.getXMPProperties();

		// Get XMP properties of Gif image using Stream
		// Images.Gif.getXMPPropertiesUsingStream();

		// Update XMP properties of Gif image
		// Images.Gif.updateXMPProperties();

		// Update XMP properties of Gif image
		// Images.Gif.updateXMPPropertiesUsingStream();

		// Remove XMP properties of Gif image
		// Images.Gif.removeXMPProperties();

		// Update Paged Text XMP values of Gif image
		// Images.Gif.updatePagedTextXMPProperties();

		// Update Camera Raw XMP properties values of Gif image
		// Images.Gif.updateCameraRawXMPProperties();

		// Update Basic Jon XMP properties values of Gif image
		// Images.Gif.updateBasicJobXMPProperties();

		// Remove Medatadata of Gif image
		// Images.Gif.removeMetadata();

		// Find XMP Metadata Using Regex
		// Images.Gif.findXmpMetadataUsingRegex();

		// Update XMP Metadata Using Regex
		// Images.Gif.replaceXmpMetadataUsingRegex();

		//endregion

		//region Working with Jpeg
		// Get XMP properties of Jpeg image
		// Images.Jpeg.getXMPProperties();

		// Get XMP properties of Jpeg image using Stream
		// Images.Jpeg.getXMPPropertiesUsingStream();

		// Update XMP properties of Jpeg image
		// Images.Jpeg.updateXMPProperties();

		// Update XMP properties of Jpeg image
		// Images.Jpeg.updateXMPPropertiesUsingStream();

		// Remove XMP properties of Jpeg image
		// Images.Jpeg.removeXMPProperties();

		// Get Exif Info of Jpeg image using tag
		// Images.Jpeg.getExifInfoUsingTag();

		// Get Exif Info of Jpeg image using tag
		// Images.Jpeg.getAllExifTags();

		// Get Exif Info of Jpeg image
		// Images.Jpeg.getExifInfo();

		// Update Exif Info of Jpeg image
		// Images.Jpeg.updateExifInfo();

		// Update Exif Info of Jpeg image using properties
		// Images.Jpeg.updateExifInfoUsingProperties();

		// Delete Exif data faster
		// Images.Jpeg.fastRemoveExifData();

		// Update Exif data faster
		// Images.Jpeg.fasterUpdateExifData();

		// Add IPTC metadat in Jpeg image
		// Images.Jpeg.addIPTCMetadataJpeg();

		// Update IPTC metadata in Jpeg image
		// Images.Jpeg.updateIPTCMetadataOfJPEG();

		// Remove IPTC metadata in Jpeg image
		// Images.Jpeg.removeIPTCMetadataOfJPEG();

		// Update Paged Text XMP values of Jpeg image
		// Images.Jpeg.updatePagedTextXMPProperties();

		// Update Camera Raw XMP properties values of Jpeg image
		// Images.Jpeg.updateCameraRawXMPProperties();

		// Update Basic Job XMP properties values of Jpeg image
		// Images.Jpeg.updateBasicJobXMPProperties();

		// Remove Photoshop Metadata in JPEG Format
		// Images.Jpeg.removePhotoshopMetadata();

		// Read IPTC XMP metadata in Jpeg image
		// Images.Jpeg.getIPTCPhotoMetadataFromXMP();

		// Update IPTC XMP metadata in Jpeg image
		// Images.Jpeg.updateIPTCPhotoMetadataFromXMP();

		// Detect Barcode in Jpeg image
		// Images.Jpeg.detectBarcode();

		// Read Image Resource Blocks
		// Images.Jpeg.readImageResourceBlocks();

		// Read Sony maker notes
		// Images.Jpeg.readSonyMakerNotes();

        //The method loads and save EXIF metadata with better speed
        //Images.Jpeg.getEXIFMetadataWithBetterSpeed();

        //Find EXIF Metadata using regex
        //Images.Jpeg.findEXIFMetadataUsingRegex();

        //Replace EXIF Metadata using regex
		//Images.Jpeg.replaceEXIFMetadataUsingRegex();
		
		//Get TIFF Tags using EXIF Properties 
		//Images.Jpeg.getTiffTagsUsingExifProperties();

		//endregion

		//region Working with Png

		// Get XMP properties of Png image
		// Images.Png.getXMPProperties();

		// Update XMP properties of Png image
		// Images.Png.updateXMPProperties();

		// Remove XMP properties of Png image
		// Images.Png.removeXMPProperties();

		// Update Paged Text XMP values of Png image
		// Images.Png.updatePagedTextXMPProperties();

		// Update Camera Raw XMP properties values of Png image
		// Images.Png.updateCameraRawXMPProperties();

		// Update Basic Jon XMP properties values of Png image
		// Images.Png.updateBasicJobXMPProperties();

		//endregion

		//region Working with Tiff

		// Get XMP properties of Tiff image
		// Images.Tiff.getXMPProperties();

		// Get XMP properties of Tiff image using Stream
		// Images.Tiff.getXMPPropertiesusingStream();

		// Read File Directory Tags of Tiff Image
		// Images.Tiff.readTiffFileDirectoryTags();

		// Read Exif Info of Tiff image
		// Images.Tiff.getExifInfo();

		// Update Exif Info of Tiff image
		// Images.Tiff.updateExifInfo();

		// Update Exif Info Using Properties of Tiff image
		// Images.Tiff.updateExifInfoUsingProperties();

		// Delete Exif data
		// Images.Tiff.removeExifData();

		// Read IPTC metadata from Tiff File
		// Images.Tiff.readIPTCmetadataTiff();

		// Remove XMP Metadata
		// Images.Tiff.removeXMPMetadata();

		// Remove XMP Metadata Using Stream
		// Images.Tiff.removeXMPMetadataUsingStream();

		// Extract Specifc TIFF Tags 
		// Images.Tiff.extractSpecificTiffTags();

		// Update Exif Info of Tiff image using shortcut properties
		// Images.Tiff.updateExifMetadataUsingShortcutProperties();

		// Update Exif Info of Tiff image by replacing tag collection 
		// Images.Tiff.updateExifMetadatByReplacingTagCollection();

		// Update Exif IFD Tags of Tiff image using shortcut properties
		// Images.Tiff.updateExifIFDTagsUsingShortcutProperties();

		// Update Exif IFD Tags of Tiff image by replacing tag collection 
		// Images.Tiff.updateExifIFDTagsByReplacingTagCollection();

		//endregion

		//region Working with WebP

		// Get metadata properties of WebP image
		// Images.WebP.getMetadataProperties();

		//endregion

		//region Working with Djvu

		// Get metadata properties of emf image
		// Images.DJVU.getMetadataProperties();

		//endregion

		//region Working with BMP

		// Get metadata properties of bmp image
		// Images.BMP.getMetadataProperties();

		// Get header properties bmp image
		// Images.BMP.getHeaderProperties();

		//endregion

		//region Working with Dicom

		// Read metadata of a DICOM file
		// Images.DICOM.getheaderProperties();

		//endregion

		//region Working with PSD

		// Read metadata of PSD file
		// Images.Psd.getPsdInfo();

		// Read XMP metadata of PSD file
		// Images.Psd.getXMPProperties();

		// Read Layers
		// Images.Psd.readLayers();

		// Read IPTC metadata from PSF file
		// Images.Psd.readIPTCmetadataPsd();

		// Update IPTC Metadata
		//Images.Psd.updateIPTCMetadata();

		// Remove IPTC Metadata
		//Images.Psd.removeIPTCMetadata();

		// Read IPTC Metadata PSD file using stream
		//Images.Psd.readIPTCMetadatasUsingStream();

		// Update IPTC Metadata using steam
		//Images.Psd.updateIPTCMetadataUsingStream();

		// Read EXIF Metadata
		// Images.Psd.readEXIFMetadata();

		//endregion

		//region Working with Emf

		// Get metadata properties of emf image
		// Images.EMF.getMetadataProperties();

		//endregion

		//region Working with Wmf

		// Get metadata properties of Wmf image
		// Images.WMF.getMetadataProperties();

		//endregion

		//region Retrieve Image Size

		// Retrive the height and width of images of supported formats
		// Images.retrieveImageSize("\\Images\\SampleImages\\");

		//endregion

		//region Read Byte order of images

		// Reads byte order of images of supported formats
		// Images.readByteOrder("\\Images\\SampleImages\\");

		//endregion

		//endregion

		//region Working with APIs

		// Compare document metadata
		// APIs.Document.compareDocument("\\Documents\\Pdf\\sample.pdf",
		// "\\Documents\\Pdf\\sample.pdf");

		// Search document metadata in document
		// APIs.Document.searchMetadata("\\Documents\\Doc\\sample.doc");

		// Replace metadata properties in documents
		// APIs.Document.replaceMetadataProperties("\\Documents\\Doc\\sample.doc");

		// Compare Exif metadata in images
		// APIs.Image.compareExifMetadata("\\Images\\Jpeg\\sample.jpg",
		// "\\Images\\Jpeg\\sample.jpg");

		// Search document metadata in image
		// APIs.Image.searchMetadata("\\Images\\Tiff\\sample.tif");


		// FormatRecognizer: Recognizes the format of file
		// MIMETypeDetector.getFileFormats("/Documents/Doc/sample.doc");

		// Get MimeType
		// MIMETypeDetector.getMimeType("/Documents/Doc/sample.doc");

		// Working with Utilities
		// Get Document Type
		// DocumentTypeDetector.getDocumentType("/Documents/Doc/sample.doc");
		// Get all Jpeg Files
		// String[] file = DocumentTypeDetector.getFiles("/Images/Jpeg/",
		// DocumentType.Jpeg);

		// JpegPhotoParser: Finds photos taken on a specific camera in a
		// directory
		// PhotoParser jpegPhotoParser = new PhotoParser("/Images/Jpeg/");
		// jpegPhotoParser.filterByCameraManufacturer("Sony");

		// PhotoCleaner: Cleans GPS data from photos in a directory
		// PhotoCleaner photoCleaner = new PhotoCleaner("/Images/Jpeg/");
		// photoCleaner.removeExifLocation();

		// DocCleaner: Cleans metadata from all Doc files, created by an author,
		// in a directory
		// DocCleaner docCleaner = new DocCleaner("/Documents/Doc/");
		// docCleaner.removeMetadataByAuthor("Usman Aziz");

		// FormatRecognizer: Recognizes the format of all files in a directory
		// Common.getFileFormats("/Documents/Doc/");

		//endregion

		//region Working with emails

		//region Working with Outlook

		// Get Outlook email metadata
		// Emails.OutLook.getOutlookEmailMetadata();

		// Remove Outlook email attachment
		// Emails.OutLook.removeOutlookEmailAttachments();

		// Remove Outlook email metadata
		// Emails.OutLook.removeOutlookEmailMetadata();

		//endregion

		//region Working with Eml

		// Get email metadata
		// Emails.Eml.getEmailMetadata();

		// Remove email attachment
		// Emails.Eml.removeEmailAttachments();

		// Remove email metadata
		// Emails.Eml.removeEmailMetadata();

		//endregion

		//endregion

		//region Working with Audio Formats

		//region Working with MP3 Files

		// Export metadata of Mp3 format to Excel
		// AudioFormats.Mp3.exportMetadataToExcel();

		// Detect MP3 audio format
		// AudioFormats.Mp3.detectMp3Format();

		// Read ID3v2 tag in MP3 format
		// AudioFormats.Mp3.readID3v2Tags();

		// Update ID3v2Tag
		// AudioFormats.Mp3.updateID3v2Tags();

		// Remove ID3v2Tag
		// AudioFormats.Mp3.removeID3v2Tags();

		// Read ID3v1 tag in MP3 format
		// AudioFormats.Mp3.readID3v1Tags();

		// Read MPEG audio information
		// AudioFormats.Mp3.readMPEGAudioInfo();

		// Read Lyrics3 Tag
		// AudioFormats.Mp3.readLyrics3Tags();

		// Update Lyrics3 Tag
		// AudioFormats.Mp3.updateLyrics3Tag();

		// Update Lyrics3 Tag by replacing whole field collection
		// AudioFormats.Mp3.updateLyrics3TagByReplacingWholeFieldCollection();

		// Update Lyrics3 Tag by replacing whole tag
		// AudioFormats.Mp3.updateLyrics3TagByReplacingWholeTag();

		// Update ID3v1Tag
		// AudioFormats.Mp3.updateID3v1Tags();

		// Read ID3 metadata directtly from MP3
		// AudioFormats.Mp3.readId3MetadataDirectly();

		// Read APEV2 tag in MP3 files
		// AudioFormats.Mp3.readApev2Tags();

        //Validate ID3 input metadata before saviing
        // AudioFormats.Mp3.validateID3Metadata();

        //Read additional properties from ID3v2 tag
        //AudioFormats.Mp3.readAdditionalID3v2Properties();

        //Update ID3v2 tag using properties
        //AudioFormats.Mp3.updateID3v2TagUsingProperties();

        //Update ID3v1 tag using properties
        //AudioFormats.Mp3.updateID3v1TagUsingProperties();

        //Ability to read Image cover from ID3 audio tag
        //AudioFormats.Mp3.readImageCoverID3();

        //Update or Remove image cover from ID3 audio tag
        //AudioFormats.Mp3.updateOrRemoveImageCoverID3();

		// Read ImageCover using Metadata Utility
		//AudioFormats.Mp3.readImageCoverMetadataUtility();

		//Read ID3v2 tag in MP3 format using stream
		//AudioFormats.Mp3.readID3v2TagUsingStream();

		// Update ID3v2Tag
		//AudioFormats.Mp3.updateID3v2TagUsingStream();

		//endregion

		//region Working with WAV Files

		// Detect WAV format
		// AudioFormats.Wav.detectWavFormat();

		// Read Audio Details
		// AudioFormats.Wav.readAudioDetails();

		// Update XMP Metadata
		//AudioFormats.Wav.updateXmpMetadata();

		//Remove XMP Metadata
		//AudioFormats.Wav.removeXmpMetadata();

		//Update XMP Metadata using stream
		//AudioFormats.Wav.UpdateXmpMetadataUsingStream();

		//endregion

		//endregion

		//region Working with Video Formats

		//region Working with AVI
		// Read Header information in AVI format
		// VideoFormats.Avi.readAviMainHeader();

		// Read Avi Main header using stream
		// VideoFormats.Avi.readAviMainHeaderUsingStream();

		//endregion

		//region Working with Mov

		//Detect Mov file format
		//VideoFormats.Mov.detectMovFormat();

		//endregion

		//region Working with Flv

        //Detect FLV file format
        //VideoFormats.Flv.detectFlvFormat();

        //Get XMP Metadata
        //VideoFormats.Flv.getXMPMetadata();

        //Update XMP Metadata
        //VideoFormats.Flv.updateXMPMetadata();

        //Remove XMP Metadata
        //VideoFormats.Flv.removeXMPMetadata();

        //Read FLV header metadata
        //VideoFormats.Flv.readFlvHeaderMetadata();

		//endregion

		//endregion

		//region Working with ZIP Archives

		//Detect Zip file format using format factory
        //Archives.Zip.detectZipFormat();

        //Get Zip format metadata
        //Archives.Zip.getZipMetadata();

        // Get ZIP format metadata using stream
        //Archives.Zip.getZipMatadataUsingStream();

        //Remove ZIP format
        //Archives.Zip.removeComment();

        //Update ZIP format Comment
        //Archives.Zip.updateComment();

		//endregion

		//region Working with Torrents

		//region Working with Bit Torrent

		//Read Bit Torrent File Metadata
		//Torrent.BitTorrent.getTorrentMetadata();

		//Update Bit Torrent File Metadata
		//Torrent.BitTorrent.updateTorrentMedata();

		//Read Bit Torrent File Metadata Using Stream
		//Torrent.BitTorrent.getTorrentMetadataUsingStream();

		//endregion

		//endregion

		//region Working with DublinCore Metadata
		//Get DublinCore of supported file formats using MetadataUtility class
        //DublinCore.getDublinCoreMetadata();

        //Get DublinCore Metadata of supported file formats using IDublinCore Interface
        //DublinCore.getDublinCoreMetadataUsingIDublinCore();

		//endregion

	}
}
