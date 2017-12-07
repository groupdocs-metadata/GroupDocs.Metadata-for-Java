package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.AviFormat;
import com.groupdocs.metadata.AviHeader;
import com.groupdocs.metadata.DocumentType;
import com.groupdocs.metadata.FormatBase;
import com.groupdocs.metadata.FormatFactory;
import com.groupdocs.metadata.MovFormat;
import com.groupdocs.metadata.examples.Utilities.Common;

public class VideoFormats {
	public static class Avi {
		private static String path = "\\Videos\\Avi\\sample.avi";

		public static void readAviMainHeader() {
			// initialize AviFormat
			AviFormat aviFormat = new AviFormat(Common.mapSourceFilePath(path));

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

		public static void cleanMetadata() {
			// initialize AviFormat
			AviFormat aviFormat = new AviFormat(Common.mapSourceFilePath(path));

			// clean all metadata supported by GroupDocs.Metadata
			aviFormat.cleanMetadata();

			// and commit changes
			aviFormat.save();
		}
	}

	public static class Mov {
		private static String path = "\\Videos\\Mov\\sample.mov";

		public static void detectMovFormat() {
			// recognize format
			FormatBase format = FormatFactory.recognizeFormat(Common.mapSourceFilePath(path));

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
