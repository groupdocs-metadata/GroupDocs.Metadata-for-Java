package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.ZipFileInfo;
import com.groupdocs.metadata.ZipFormat;
import com.groupdocs.metadata.ZipMetadata;
import com.groupdocs.metadata.examples.Utilities.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Archives {
	public static class Zip {
		private static String filePath = "\\Archives\\Zip\\sample.zip";

		public static void detectZipFormat() {
			// open ZIP
			try(ZipFormat zip = new ZipFormat(Common.mapSourceFilePath(filePath))) {

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
		}

		public static void getZipMetadata() {
			// initialize ZipFormat
			try (ZipFormat zipFormat = new ZipFormat(Common.mapSourceFilePath(filePath))) {
				// get info
				ZipMetadata info = zipFormat.getZipInfo();
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

		public static void getZipMatadataUsingStream()  {
			try (InputStream stream = new FileInputStream(Common.mapSourceFilePath(filePath)))
			{
				try (ZipFormat format = new ZipFormat(stream))
				{
					// get info
					ZipMetadata info = format.getZipInfo();
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
				// The stream is still open here
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public static void removeComment() {
			// open ZIP
			try(ZipFormat zip = new ZipFormat(Common.mapSourceFilePath(filePath))) {

				// remove user comment
				zip.removeFileComment();

				// and commit changes
				zip.save(Common.mapDestinationFilePath(filePath));
			}
		}

		public static void updateComment() {
			try (ZipFormat format = new ZipFormat(Common.mapSourceFilePath(filePath)))
			{
				format.getZipInfo().setComment("test comment");
				//Or you can update comments using setZipFileComment() method
				//format.setZipFileComment("test comment");
				format.save(Common.mapDestinationFilePath(filePath));
			}
		}
	}
}
