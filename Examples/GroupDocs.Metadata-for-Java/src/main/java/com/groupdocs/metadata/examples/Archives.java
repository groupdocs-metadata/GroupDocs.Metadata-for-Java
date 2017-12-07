package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.ZipFileInfo;
import com.groupdocs.metadata.ZipFormat;
import com.groupdocs.metadata.ZipMetadata;
import com.groupdocs.metadata.examples.Utilities.Common;

public class Archives {
	public static class Zip {
		private static String filePath = "\\Archives\\Zip\\sample.zip";

		public static void detectZipFormat() {
			// open ZIP
			ZipFormat zip = new ZipFormat(Common.mapSourceFilePath(filePath));

			// and get metadata
			ZipMetadata metadata = zip.getZipInfo();

			// get array of files inside ZIP
			ZipFileInfo[] files = metadata.getFiles();

			System.out.println("Files:");

			// and print all files inside ZIP
			for (ZipFileInfo file : files) {
				System.out.println(file.getName());
			}
		}

		public static void getZipMetadata() {
			// initialize DocFormat
			ZipFormat movFormat = new ZipFormat(Common.mapSourceFilePath(filePath));
			// get info
			ZipMetadata info = movFormat.getZipInfo();

			// get total entries
			System.out.printf("Total Entries : %s, ", info.getTotalEntries());

			// get comments
			System.out.printf("Comments : %s, ", info.getComment());
			for (ZipFileInfo fileInfo : info.getFiles()) {
				// get file name
				System.out.printf("File Name : %s, ", fileInfo.getName());

				// get compressed size
				System.out.printf("CompressedSize : $s, ", fileInfo.getCompressedSize());

				// get uncompressed size
				System.out.printf("UncompressedSize : %s, ", fileInfo.getUncompressedSize());

				// get compression method
				System.out.printf("CompressionMethod : %s, ", fileInfo.getCompressionMethod());

			}
		}
	}

}
