package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.*;
import com.groupdocs.metadata.examples.Utilities.Common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class VideoFormats {
	public static class Avi {
		private static String path = "\\Videos\\Avi\\sample.avi";

		public static void readAviMainHeader() {
			// initialize AviFormat

			try (AviFormat aviFormat = new AviFormat(Common.mapSourceFilePath(path))) {

				// get AVI header
				AviHeader header = aviFormat.getHeader();
				// display video width
				System.out.printf("Video width: %s", header.getWidth());

				// display video height
				System.out.printf("Video height: %s", header.getHeight());

				// display total frames
				System.out.printf("Total frames: %s", header.getTotalFrames());

				// display number of streams in file
				System.out.printf("Number of streams: %s", header.getStreams());

				// display suggested buffer size for reading the file
				System.out.printf("Suggested buffer size: %s", header.getSuggestedBufferSize());
			}
		}

		public static void cleanMetadata() {
			// initialize AviFormat
			try (AviFormat aviFormat = new AviFormat(Common.mapSourceFilePath(path))) {

				// clean all metadata supported by GroupDocs.Metadata
				aviFormat.cleanMetadata();

				// and commit changes
				aviFormat.save();
			}
		}

		public static void readAviMainHeaderUsingStream() throws IOException {
			try (OutputStream stream = new FileOutputStream(Common.mapDestinationFilePath(path)))
			{
				try (AviFormat format = new AviFormat(Common.mapSourceFilePath(path)))
				{
					// get AVI header
					AviHeader header = format.getHeader();
					// display video width
					System.out.printf("Video width: %s", header.getWidth());

					// display video height
					System.out.printf("Video height: %s", header.getHeight());

					// display total frames
					System.out.printf("Total frames: %s", header.getTotalFrames());

					// display number of streams in file
					System.out.printf("Number of streams: %s", header.getStreams());

					// display suggested buffer size for reading the file
					System.out.printf("Suggested buffer size: %s", header.getSuggestedBufferSize());

					format.save(stream);
				}
				// The stream is still open here
			}
		}
	}

	public static class Mov {
		private static String path = "\\Videos\\Mov\\sample.mov";

		public static void detectMovFormat() {
			// recognize format
			try (FormatBase format = FormatFactory.recognizeFormat(Common.mapSourceFilePath(path))) {

				// check format type
				if (format.getType() == DocumentType.Mov) {
					// cast it to MovFormat
					MovFormat movFormat = (MovFormat) format;

					// and get it MIME type
					String mimeType = movFormat.getMIMEType();

					System.out.printf("Mime: %s", mimeType);
				}
			}
		}
	}

	public static class Flv {
		private static String path = "\\Videos\\Flv\\sample.flv";

		/**
		 * Checks FLV file format
		 * This method is supported by version 18.11 or higher
		 */
		public static void detectFlvFormat() {
			try (FileFormatChecker checker = new FileFormatChecker(Common.mapSourceFilePath(path)))
			{
				if (checker.getDocumentType() == DocumentType.Flv)
				{
					System.out.println("This is a valid FLV format");
				}
			}
		}

		/**
		 * Gets XMP Metadata for FLV format
		 * This method is supported by version 18.11 or higher
		 */
		public static void getXMPMetadata() {
			try (FlvFormat format = new FlvFormat(Common.mapSourceFilePath(path)))
			{
				System.out.println(format.getXmpValues().getSchemes().getXmpBasic().getCreateDate());
				System.out.println(format.getXmpValues().getSchemes().getXmpBasic().getLabel());
				System.out.println(format.getXmpValues().getSchemes().getDublinCore().getSource());
				System.out.println(format.getXmpValues().getSchemes().getDublinCore().getFormat());
			}
		}

		/**
		 * Updates XMP Metadata of FLV format
		 * This method is supported by version 18.11 or higher
		 */
		public static void updateXMPMetadata() {

			try (FlvFormat format = new FlvFormat(Common.mapSourceFilePath(path)))
			{
				format.getXmpValues().getSchemes().getXmpBasic().setCreateDate(new Date());
				format.getXmpValues().getSchemes().getXmpBasic().setLabel("Test");
				format.getXmpValues().getSchemes().getDublinCore().setSource("http://groupdocs.com");
				format.getXmpValues().getSchemes().getDublinCore().setFormat("FLV Video");

				format.save(Common.mapDestinationFilePath(path));

				System.out.println("File saved to destination folder...");
			}
		}

		/**
		 * Removes XMP Metadata of FLV format
		 * This method is supported by version 18.11 or higher
		 */
		public static void removeXMPMetadata() {
			try (FlvFormat format = new FlvFormat(Common.mapSourceFilePath(path)))
			{
				format.removeXmpData();
				format.save(Common.mapDestinationFilePath(path));

				System.out.println("File saved to destination folder...");
			}
		}

		/**
		 * Reads FLV header metadata
		 * This method is supported by version 18.11 or higher
		 */
		public static void readFlvHeaderMetadata() {
			try (FlvFormat format = new FlvFormat(Common.mapSourceFilePath(path)))
			{
				System.out.println(format.getHeader().getVersion());
				System.out.println(format.getHeader().hasVideoTags());
				System.out.println(format.getHeader().hasAudioTags());
				System.out.println(Integer.toBinaryString(format.getHeader().getTypeFlags()));
			}

		}
	}

	public static class Mkv {
		private static String path = "\\Videos\\Mkv\\sample.mkv";
		/**
		 * This method gets MKV file format metadata
		 * This method is supported by version 19.1 or greater
		 */
		public static void getMetadata() {
			try (MatroskaFormat format = new MatroskaFormat(Common.mapSourceFilePath((path)))) {
				System.out.printf("\nDocType: %s",format.getEbmlHeader().getDocType());
				System.out.printf("\nDocTypeReadVersion: %s",format.getEbmlHeader().getDocTypeReadVersion());
				System.out.printf("\nDocTypeVersion: %s",format.getEbmlHeader().getDocTypeVersion());
				System.out.printf("\nReadVersion: %s",format.getEbmlHeader().getReadVersion());
				System.out.printf("\nVersion: %s",format.getEbmlHeader().getVersion());
			}

		}

		/**
		 * This method gets Matroska Segment Info Metadata
		 * This method is supported by version 19.1 or greater
		 */
		public static void matroskaSegmentInfoMetadata() {
			try (MatroskaFormat format = new MatroskaFormat(Common.mapSourceFilePath((path)))) {
				for (MatroskaSegmentInfoMetadata segment : format.getSegments())
				{
					System.out.printf("\nDateUtc: %s",segment.getDateUtc());
					System.out.printf("\nDuration: %s",segment.getDuration());
					System.out.printf("\nMuxingApp: %s",segment.getMuxingApp());
					System.out.printf("\nSegmentFilename: %s",segment.getSegmentFilename());
					System.out.printf("\nSegmentUid: %s",segment.getSegmentUid());
					System.out.printf("\nTimecodeScale: %s",segment.getTimecodeScale());
					System.out.printf("\nTitle: %s",segment.getTitle());
					System.out.printf("\nWritingApp: %s",segment.getWritingApp());
				}
			}
		}
		/**
		 * This method gets Matroska Tag Metadata
		 * This method is supported by version 19.1 or greater
		 */
		public static void matroskaTagMetadata() {
			try (MatroskaFormat format = new MatroskaFormat(Common.mapSourceFilePath((path)))) {
				for (MatroskaTagMetadata tag : format.getTags())
				{
					System.out.printf("\nTargetType: %s",tag.getTargetType());
					System.out.printf("\nTargetTypeValue: %s",tag.getTargetTypeValue());
					System.out.printf("\nTagTrackUid: %s",tag.getTagTrackUid());
					for (String key : tag.getSimpleTags().getKeys())
					{
						System.out.println(tag.getSimpleTags().readByStringKey(key).getFormattedValue());
					}
				}
			}
		}
		/**
		 * This method gets Matroska Track Metadata
		 * This method is supported by version 19.1 or greater
		 */
		public static void matroskaTrackMetadata() {
			try (MatroskaFormat format = new MatroskaFormat(Common.mapSourceFilePath((path)))) {
				for (MatroskaTrackMetadata track : format.getTracks())
				{
					System.out.printf("\nCodecId: %s",track.getCodecId());
					System.out.printf("\nCodecName: %s",track.getCodecName());
					System.out.printf("\nDefaultDuration: %s",track.getDefaultDuration());
					System.out.printf("\nFlagEnabled: %s",track.getFlagEnabled());
					System.out.printf("\nLanguage: %s",track.getLanguage());
					System.out.printf("\nLanguageIetf: %s",track.getLanguageIetf());
					System.out.printf("\nName: %s",track.getName());
					System.out.printf("\nTrackNumber: %s",track.getTrackNumber());
					System.out.printf("\nTrackType: %s",track.getTrackType());
					System.out.printf("\nTrackUid: %s",track.getTrackUid());

					if (track instanceof MatroskaAudioTrackMetadata)
					{
						MatroskaAudioTrackMetadata audioTrack = (MatroskaAudioTrackMetadata)track;
						System.out.printf("\nSamplingFrequency: %s",audioTrack.getSamplingFrequency());
						System.out.printf("\nOutputSamplingFrequency: %s",audioTrack.getOutputSamplingFrequency());
						System.out.printf("\nChannels: %s",audioTrack.getChannels());
						System.out.printf("\nBitDepth: %s",audioTrack.getBitDepth());
					}

					if (track instanceof MatroskaVideoTrackMetadata)
					{
						MatroskaVideoTrackMetadata videoTrack = (MatroskaVideoTrackMetadata)track;
						System.out.printf("\nFlagInterlaced: %s",videoTrack.getFlagInterlaced());
						System.out.printf("\nFieldOrder: %s",videoTrack.getFieldOrder());
						System.out.printf("\nStereoMode: %s",videoTrack.getStereoMode());
						System.out.printf("\nAlphaMode: %s",videoTrack.getAlphaMode());
						System.out.printf("\nPixelWidth: %s",videoTrack.getPixelWidth());
						System.out.printf("\nPixelHeight: %s",videoTrack.getPixelHeight());
						System.out.printf("\nPixelCropBottom: %s",videoTrack.getPixelCropBottom());
						System.out.printf("\nPixelCropTop: %s",videoTrack.getPixelCropTop());
						System.out.printf("\nPixelCropLeft: %s",videoTrack.getPixelCropLeft());
						System.out.printf("\nPixelCropRight: %s",videoTrack.getPixelCropRight());
						System.out.printf("\nDisplayWidth: %s",videoTrack.getDisplayWidth());
						System.out.printf("\nDisplayHeight: %s",videoTrack.getDisplayHeight());
						System.out.printf("\nDisplayUnit: %s",videoTrack.getDisplayUnit());
					}
				}
			}
		}
	}

	 public static class Asf
     {
         //Source file path
         private static String filePath = "Video/ASF/sample.asf";
         /**
         * This method gets ASF video native metadata
         * This method is supported by version 19.2 or greater 
         */
         public static void GetMetadata()
         {
             //ExStart:GetASFNativeMetadata
             try (AsfFormat format = new AsfFormat(Common.mapSourceFilePath(filePath)))
             {
                 // get AsfMetadata
                 AsfMetadata metadata = format.getAsfInfo();

                 //Display properties
                 System.out.println("Creation date: "+metadata.getCreationDate());
                 System.out.println("File id: "+ metadata.getFileId());
                 System.out.println("Flags: "+ metadata.getFlags());

                 // Display Asf Codec Information
                 for (AsfCodecInfo codecInfo : metadata.getCodecInformation())
                 {
                     System.out.println("Codec type: "+ codecInfo.getCodecType());
                     System.out.println("Description: "+ codecInfo.getDescription());
                     System.out.println("Codec information: "+ codecInfo.getInformation());
                     System.out.println(codecInfo.getName());
                 }
                 // Display metadata descriptors
                 for (AsfBaseDescriptor descriptor : metadata.getMetadataDescriptors())
                 {

                     System.out.println("Name: "+ descriptor.getName());
                     System.out.println("Formatted value: "+ descriptor.getFormattedValue());
                     AsfMetadataDescriptor metadataDescriptor = (AsfMetadataDescriptor)descriptor ;
                     if (metadataDescriptor != null)
                     {
                         System.out.println("Language: "+ metadataDescriptor.getLanguage());
                         System.out.println("Stream number: "+ metadataDescriptor.getStreamNumber());
                         System.out.println("Original name: "+ metadataDescriptor.getOriginalName());
                     }
                 }
                 //Dispay the base stream related metadata 
                 for (AsfBaseStreamProperty property : metadata.getStreamProperties())
                 {
                     System.out.println("Alternate bitrate: "+ property.getAlternateBitrate());
                     System.out.println("Average bitrate: "+ property.getAverageBitrate());
                     System.out.println("Average time per frame: "+ property.getAverageTimePerFrame());
                     System.out.println("Bitrate: "+ property.getBitrate());
                     System.out.println("Stream end time: "+ property.getEndTime());
                     System.out.println("Stream flags: "+ property.getFlags());
                     System.out.println("Stream language: "+ property.getLanguage());
                     System.out.println("Stream start time: "+ property.getStartTime());
                     System.out.println("Stream number: "+ property.getStreamNumber());
                     System.out.println("Stream type: "+ property.getStreamType());
                     
                     //Display the audio stream related metadata
                     AsfAudioStreamProperty audioStreamProperty = (AsfAudioStreamProperty)property ;
                     if (audioStreamProperty != null)
                     {
                         System.out.println("Audio bits per sample: "+ audioStreamProperty.getBitsPerSample());
                         System.out.println("Audio channels: "+ audioStreamProperty.getChannels());
                         System.out.println("Audio format tag: "+ audioStreamProperty.getFormatTag());
                         System.out.println("Audio samples per second: "+ audioStreamProperty.getSamplesPerSecond());
                     }
                     //Display the vedio stream related metadata
                     AsfVideoStreamProperty videoStreamProperty = (AsfVideoStreamProperty)property ;
                     if (videoStreamProperty != null)
                     {
                         System.out.println("Video bits per pixels: "+ videoStreamProperty.getBitsPerPixels());
                         System.out.println("Compression: "+ videoStreamProperty.getCompression());
                         System.out.println("Image height: "+ videoStreamProperty.getImageHeight());
                         System.out.println("Image width: "+ videoStreamProperty.getImageWidth());
                     }
                 }
             }
             //ExEnd:GetASFNativeMetadata
         }
        
         /**
          * This method gets ASF video XMP metadata
          * This method is supported by version 19.2 or greater 
          */
         public static void GetXMPMetadata()
         {
             //ExStart: GetASFXMPMetadata
             try (AsfFormat asfFormat = new AsfFormat(Common.mapSourceFilePath(filePath)))
             {
                 //Get XMP Basic metadata
                 XmpBasicPackage xmpMetadata = asfFormat.getXmpValues().getSchemes().getXmpBasic();

                 // Display some properties from the XMP Basic metadata
                 System.out.println("Creation date: "+ xmpMetadata.getCreateDate());
                 System.out.println("Label: "+ xmpMetadata.getLabel());
                 System.out.println("Rating: "+ xmpMetadata.getRating());
             }

             //ExEnd:GetASFXMPMetadata
         }
         
         /**
          * This method write ASF video XMP metadata
          * This method is supported by version 19.2 or greater 
          */ public static void SetXMPMetadata()
         {
             //ExStart: WriteASFXMPMetadata
             try (AsfFormat asfFormat = new AsfFormat(Common.mapSourceFilePath(filePath)))
             {
                 //Get XMP Basic metadata
            	 XmpBasicPackage xmpMetadata = asfFormat.getXmpValues().getSchemes().getXmpBasic();

                 // set some properties to write xmp data
                 xmpMetadata.setCreateDate( new Date());
                 xmpMetadata.setRating(4);
                 xmpMetadata.setNickname("ASF Video");

                 // Update the ASF file
                 asfFormat.save(Common.mapDestinationFilePath(filePath));
             }

             //ExEnd:WriteASFXMPMetadata
         }
          
         /**
          * This method remove ASF video XMP metadata
          * This method is supported by version 19.2 or greater 
          */
          public static void RemoveXMPMetadata()
         {
             //ExStart: RemoveASFXMPMetadata
             try (AsfFormat format = new AsfFormat(Common.mapSourceFilePath(filePath)))
             {
                 // Remove all XMP data from ASF file
                 format.removeXmpData();
                 
                 // Update the ASF file
                 format.save(Common.mapDestinationFilePath(filePath));
             }

             //ExEnd:RemoveASFXMPMetadata
         }
     }


}
