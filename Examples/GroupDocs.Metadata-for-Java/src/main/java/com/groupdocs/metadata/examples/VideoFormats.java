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
}
