package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.*;
import com.groupdocs.metadata.examples.Utilities.Common;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class Images {
	public static void retrieveImageSize(String directory) {
		// get all files
		File folder = new File(Common.mapSourceFilePath(directory));
		File[] files = folder.listFiles();
		for (File path : files) {
			// recognize format
			FormatBase format = FormatFactory.recognizeFormat(path.getAbsolutePath());

			// try to parse image
			ImageFormat imageFormat = (ImageFormat) format;

			// skip non-image file
			if (imageFormat == null) {
				continue;
			}

			// get width
			int width = imageFormat.getWidth();

			// get height
			int height = imageFormat.getHeight();

			System.out.printf("File: {0}, width {1}, height: {2}", path.getName(), width, height);
		}
	}

	public static void readByteOrder(String directory) {
		// get all files
		File folder = new File(Common.mapSourceFilePath(directory));
		File[] files = folder.listFiles();
		for (File path : files) {
			// recognize format
			FormatBase format = FormatFactory.recognizeFormat(path.getAbsolutePath());

			// try to parse image
			ImageFormat imageFormat = (ImageFormat) format;

			// skip non-image file
			if (imageFormat == null) {
				continue;
			}
			System.out.printf(String.valueOf(imageFormat.getByteOrder()));
		}
	}

	public static class JP2 {
		private static String path = "\\Images\\JP2\\sample.jp2";
		private static String outputPath = "\\Images\\JP2\\result.jp2";

		public static void readMetadataJP2() {
			// initialize Jpeg2000 format
			try (Jp2Format jp2Format = new Jp2Format(Common.mapSourceFilePath(path))) {

				// get height
				System.out.printf("Width: %s", jp2Format.getWidth());

				// get height
				System.out.printf("Height: %s", jp2Format.getHeight());

				// get comments
				String[] comments = jp2Format.getComments();

				for (String key : comments) {
					System.out.printf("Comments: %s", key);
				}
			}

		}

		public static void readXMPProperties() {
			// initialize Jp2Format
			try (Jp2Format jp2Format = new Jp2Format(Common.mapSourceFilePath(path))) {

				// get xmp properties
				XmpProperties xmpProperties = jp2Format.getXmpProperties();
				// show xmp properties
				for (String key : xmpProperties.getKeys()) {
					XmpNodeView xmpNodeView = xmpProperties.get_Item(key);
					System.out.printf("[%s] = %s", xmpNodeView.getName(), xmpNodeView.getValue());
				}
			}
		}

		public static void updateXMPProperties() {
			// initialize Jp2Format
			try (Jp2Format jp2Format = new Jp2Format(Common.mapSourceFilePath(path))) {
				// get xmp wrapper
				XmpPacketWrapper xmpPacket = jp2Format.getXmpData();

				// create xmp wrapper is not exist
				if (xmpPacket == null) {
					xmpPacket = new XmpPacketWrapper();
				}

				// check if DublinCore schema is exist
				if (!xmpPacket.containsPackage(Namespaces.DublinCore)) {
					// if no - add DublinCore schema
					xmpPacket.addPackage(new DublinCorePackage());
				}

				// get DublinCore package
				DublinCorePackage dublinCorePackage = (DublinCorePackage) xmpPacket.getPackage(Namespaces.DublinCore);

				// set author
				dublinCorePackage.setAuthor("Test author");
				// set description
				dublinCorePackage.setDescription("Some description");

				// update XMP package
				jp2Format.setXmpData(xmpPacket);

				// and commit changes
				jp2Format.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void removeXMPProperties() {
			// initialize Jp2Format
			try (Jp2Format jp2Format = new Jp2Format(Common.mapSourceFilePath(path))) {
				// remove XMP package
				jp2Format.removeXmpData();

				// and commit changes
				jp2Format.save(Common.mapDestinationFilePath(outputPath));
			}
		}
	}

	public static class Gif {
		private static String path = "\\Images\\Gif\\sample.gif";
		private static String outputPath = "\\Images\\JP2\\result.gif";

		public static void getXMPProperties() {
			// initialize GifFormat
			try (GifFormat gifFormat = new GifFormat(Common.mapSourceFilePath(path))) {
				// check if GIF supports XMP
				if (gifFormat.isSupportedXmp()) {
					// get xmp properties
					XmpProperties xmpProperties = gifFormat.getXmpProperties();

					// show xmp properties
					for (String key : xmpProperties.getKeys()) {
						XmpNodeView xmpNodeView = xmpProperties.get_Item(key);
						System.out.printf("[%s] = %s", xmpNodeView.getName(), xmpNodeView.getValue());
					}
				}
			}
		}
		public static void getXMPPropertiesUsingStream() throws IOException {
			try (InputStream stream = new FileInputStream(Common.mapSourceFilePath(path)))
			{
				try (GifFormat format = new GifFormat(stream))
				{
					// check if GIF supports XMP
					if (format.isSupportedXmp()) {
						// get xmp properties
						XmpProperties xmpProperties = format.getXmpProperties();

						// show xmp properties
						for (String key : xmpProperties.getKeys()) {
							XmpNodeView xmpNodeView = xmpProperties.get_Item(key);
							System.out.printf("[%s] = %s", xmpNodeView.getName(), xmpNodeView.getValue());
						}
					}
				}
				// The stream is still open here
			}
		}

		public static void updateXMPProperties() {
			// initialize GifFormat
			try (GifFormat gifFormat = new GifFormat(Common.mapSourceFilePath(path))) {

				// check if GIF supports XMP
				if (gifFormat.isSupportedXmp()) {
					// get xmp wrapper
					XmpPacketWrapper xmpPacket = gifFormat.getXmpData();

					// create xmp wrapper is not exist
					if (xmpPacket == null) {
						xmpPacket = new XmpPacketWrapper();
					}

					// check if DublinCore schema is exist
					if (!xmpPacket.containsPackage(Namespaces.DublinCore)) {
						// if no - add DublinCore schema
						xmpPacket.addPackage(new DublinCorePackage());
					}

					// get DublinCore package
					DublinCorePackage dublinCorePackage = (DublinCorePackage) xmpPacket.getPackage(Namespaces.DublinCore);

					// set author
					dublinCorePackage.setAuthor("Test author");
					// set description
					dublinCorePackage.setDescription("Some description");

					// update XMP package
					gifFormat.setXmpData(xmpPacket);

					// and commit changes
					gifFormat.save(Common.mapDestinationFilePath(outputPath));
				}
			}
		}
		public static void updateXMPPropertiesUsingStream() throws IOException {
			try (OutputStream stream = new FileOutputStream(Common.mapDestinationFilePath(path)))
			{
				try (GifFormat format = new GifFormat(Common.mapSourceFilePath(path)))
				{
					// check if GIF supports XMP
					if (format.isSupportedXmp()) {
						// get xmp wrapper
						XmpPacketWrapper xmpPacket = format.getXmpData();

						// create xmp wrapper is not exist
						if (xmpPacket == null) {
							xmpPacket = new XmpPacketWrapper();
						}

						// check if DublinCore schema is exist
						if (!xmpPacket.containsPackage(Namespaces.DublinCore)) {
							// if no - add DublinCore schema
							xmpPacket.addPackage(new DublinCorePackage());
						}

						// get DublinCore package
						DublinCorePackage dublinCorePackage = (DublinCorePackage) xmpPacket.getPackage(Namespaces.DublinCore);

						// set author
						dublinCorePackage.setAuthor("Test author");
						// set description
						dublinCorePackage.setDescription("Some description");

						// update XMP package
						format.setXmpData(xmpPacket);

						// and commit changes
						format.save(stream);
					}
				
				}
				// The stream is still open here
			}
		}

		public static void removeXMPProperties() {
			// initialize GifFormat
			try (GifFormat gifFormat = new GifFormat(Common.mapSourceFilePath(path))) {

				// check if GIF supports XMP
				if (gifFormat.isSupportedXmp()) {
					// remove XMP package
					gifFormat.removeXmpData();

					// and commit changes
					gifFormat.save(Common.mapDestinationFilePath(outputPath));
				}
			}
		}

		public static void updatePagedTextXMPProperties() {
			// initialize GifFormat
			try (GifFormat GifFormat = new GifFormat(Common.mapSourceFilePath(path))) {
				// get access to PagedText schema
				PagedTextPackage pagedTextPackage = GifFormat.getXmpValues().getSchemes().getPagedText();

				// update MaxPageSize
				pagedTextPackage.setMaxPageSize(new Dimensions(600, 800));

				// update number of pages
				pagedTextPackage.setNumberOfPages(10);

				// update plate names
				pagedTextPackage.setPlateNames(new String[]{"1", "2", "3"});

				// commit changes
				GifFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void updateCameraRawXMPProperties() {
			// initialize GifFormat
			try (GifFormat GifFormat = new GifFormat(Common.mapSourceFilePath(path))) {

				// get access to CameraRaw schema
				CameraRawPackage cameraRawPackage = GifFormat.getXmpValues().getSchemes().getCameraRaw();

				// update properties
				cameraRawPackage.setAutoBrightness(true);
				cameraRawPackage.setAutoContrast(true);
				cameraRawPackage.setCropUnits(CropUnits.Pixels);

				// update white balance
				cameraRawPackage.setWhiteBalance(WhiteBalance.getAuto());

				// commit changes
				GifFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void updateBasicJobXMPProperties() {
			// initialize GifFormat
			try (GifFormat gifFormat = new GifFormat(Common.mapSourceFilePath(path))) {
				// get xmp data
				XmpPacketWrapper xmp = gifFormat.getXmpData();

				BasicJobTicketPackage basicJobTicketPackage = null;

				// looking for the BasicJob schema if xmp data is presented
				if (xmp != null) {
					basicJobTicketPackage = (BasicJobTicketPackage) xmp.getPackage(Namespaces.BasicJob);
				} else {
					xmp = new XmpPacketWrapper();
				}
				if (basicJobTicketPackage == null) {
					// create package if not exist
					basicJobTicketPackage = new BasicJobTicketPackage();

					// and add it to xmp data
					xmp.addPackage(basicJobTicketPackage);
				}
				// create array of jobs
				Job[] jobs = new Job[1];
				Job job = new Job();
				job.setName("test job");
				job.setId("1");
				jobs[0] = job;
				// update schema
				basicJobTicketPackage.setJobs(jobs);
				// update xmp data
				gifFormat.setXmpData(xmp);
				// commit changes
				gifFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void removeMetadata() {
			try{

				try (GifFormat format = new GifFormat(Common.mapSourceFilePath(path))) {

					XmpEditableCollection xmpEditableCollection = format.getXmpValues();
					XmpSchemes schemes = xmpEditableCollection.getSchemes();

					schemes.getDublinCore().setSource(null);
					schemes.getDublinCore().setSubject((String) null);

					schemes.getPdf().setKeywords(null);
					schemes.getPdf().setProducer(null);

					schemes.getPhotoshop().setCity(null);
					schemes.getPhotoshop().setCountry(null);

					schemes.getXmpBasic().setBaseUrl(null);
					schemes.getXmpBasic().setNickname(null);

					format.save(Common.mapDestinationFilePath(path));
					format.dispose();
				}

			}catch (Exception ex){
				System.out.println(ex.getMessage());
			}
		}

		public static void findXmpMetadataUsingRegex() {
			try {
				Pattern pattern = Pattern.compile("^.*description$", Pattern.CASE_INSENSITIVE);
				XmpNodeView[] properties = SearchFacade.scanXmp(Common.mapSourceFilePath(path), pattern);
				for (int i = 0; i < properties.length; i++)
                {
                    System.out.println(properties[i]);
                }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void replaceXmpMetadataUsingRegex() {
			try {
				Pattern pattern = Pattern.compile("^.*description$", Pattern.CASE_INSENSITIVE);
				String replaceValue = "Test file";
				SearchFacade.replaceInXmp(Common.mapSourceFilePath(path), pattern, replaceValue, Common.mapDestinationFilePath(path));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class Jpeg {
		private static String path = "\\Images\\Jpeg\\sample.jpg";
		private static String outputPath = "\\Images\\Jpeg\\result.jpg";
		private static String sonyMakerFilePath = "\\Images\\Jpeg\\sony.jpg";
		private static String nikonMakerFilePath = "\\Images\\Jpeg\\nikon.jpg";
		private static String canonMakerFilePath = "\\Images\\Jpeg\\canon.jpg";
		private static String panasonicMakerFilePath = "\\Images\\Jpeg\\panasonic.jpg";
		private static String barcodeFilePath = "\\Images\\Jpeg\\barcode.jpeg";

		public static void getXMPProperties() {
			// initialize JpegFormat
			XmpProperties xmpProperties;
			try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

				// get xmp properties
				xmpProperties = jpegFormat.getXmpProperties();
				// show xmp properties
				for (String key : xmpProperties.getKeys()) {
					XmpNodeView xmpNodeView = xmpProperties.get_Item(key);
					System.out.printf("[%s] = %s", xmpNodeView.getName(), xmpNodeView.getValue());
				}
			}
		}
		public static void getXMPPropertiesUsingStream() throws IOException {
			try (InputStream stream = new FileInputStream(Common.mapSourceFilePath(path)))
				{
					try (JpegFormat format = new JpegFormat(stream))
					{
						// get xmp properties
						XmpProperties xmpProperties = format.getXmpProperties();
						// show xmp properties
						for (String key : xmpProperties.getKeys()) {
							XmpNodeView xmpNodeView = xmpProperties.get_Item(key);
							System.out.printf("[%s] = %s", xmpNodeView.getName(), xmpNodeView.getValue());
						}
					}
					// The stream is still open here
				}
		}

		public static void updateXMPProperties() {
			// initialize JpegFormat
			try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {
				// get xmp wrapper
				XmpPacketWrapper xmpPacket = jpegFormat.getXmpData();
				// create xmp wrapper is not exist
				if (xmpPacket == null)
					xmpPacket = new XmpPacketWrapper();
				// check if DublinCore schema is exist
				if (!xmpPacket.containsPackage(Namespaces.DublinCore)) {
					xmpPacket.addPackage(new DublinCorePackage());
				}
				// get DublinCore package
				DublinCorePackage dublinCorePackage = (DublinCorePackage) xmpPacket.getPackage(Namespaces.DublinCore);
				// set author
				dublinCorePackage.setAuthor("Test author");
				// set description
				dublinCorePackage.setDescription("Some description");
				// update XMP package
				jpegFormat.setXmpData(xmpPacket);
				// and commit changes
				jpegFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}
		public static void updateXMPPropertiesUsingStream() throws IOException {
			try (OutputStream stream = new FileOutputStream(Common.mapDestinationFilePath(path)))
				{
					try (JpegFormat format = new JpegFormat(Common.mapSourceFilePath(path)))
					{
						// get xmp wrapper
						XmpPacketWrapper xmpPacket = format.getXmpData();
						// create xmp wrapper is not exist
						if (xmpPacket == null)
							xmpPacket = new XmpPacketWrapper();
						// check if DublinCore schema is exist
						if (!xmpPacket.containsPackage(Namespaces.DublinCore)) {
							xmpPacket.addPackage(new DublinCorePackage());
						}
						// get DublinCore package
						DublinCorePackage dublinCorePackage = (DublinCorePackage) xmpPacket.getPackage(Namespaces.DublinCore);
						// set author
						dublinCorePackage.setAuthor("Test author");
						// set description
						dublinCorePackage.setDescription("Some description");
						// update XMP package
						format.setXmpData(xmpPacket);
						// and commit changes
						format.save(stream);
					}
					// The stream is still open here
				}
		}

		public static void removeXMPProperties() {
			// initialize JpegFormat
			try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {
				// remove XMP package
				jpegFormat.removeXmpData();
				// and commit changes
				jpegFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void getExifInfoUsingTag() {
			// init JpegFormat
			try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

				// get exif info
				ExifInfo exifInfo = jpegFormat.getExifInfo();
				if (exifInfo != null) {
					// get specific tag using indexer
					TiffAsciiTag artist = (TiffAsciiTag) exifInfo.readByTagId(TiffTagIdEnum.Artist);
					if (artist != null) {
						System.out.printf("Artist: %s", artist.getValue());
					}
				}
			}
		}

		public static void getAllExifTags() {
			// init JpegFormat
			try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {
				// get exif info
				ExifInfo exifInfo = jpegFormat.getExifInfo();
				if (exifInfo != null) {
					// all tags are available in licensed mode only
					TiffTag[] allTags = exifInfo.getTags();

					for (TiffTag tag : allTags) {
						switch (tag.getTagType()) {
							case TiffTagType.Ascii:
								TiffAsciiTag asciiTag = (TiffAsciiTag) tag;
								System.out.printf("Tag: %s, value: %s", asciiTag.getDefinedTag(), asciiTag.getValue());
								break;

							case TiffTagType.Rational:
								TiffRationalTag rationalTag = (TiffRationalTag) tag;
								System.out.printf("Tag: %s, value: %s", rationalTag.getDefinedTag(), rationalTag.getValue());
								break;
						}
					}
				}
			}
		}

		public static void getExifInfo() {
			// initialize JpegFormat
			try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {
				// get EXIF data
				JpegExifInfo exif = (JpegExifInfo) jpegFormat.getExifInfo();
				if (exif != null) {
					// get artist
					String artist = exif.getArtist();
					System.out.printf("Artist: %s", artist);

					// get description
					String description = exif.getImageDescription();
					System.out.printf("Description: %s", description);

					// get user's comment
					String comment = exif.getUserComment();
					System.out.printf("Comment: %s", comment);
				}
			}
		}

		public static void updateExifInfo() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                // get EXIF data
                JpegExifInfo exif = (JpegExifInfo) jpegFormat.getExifInfo();

                if (exif == null) {
                    // initialize EXIF data if null
                    exif = new JpegExifInfo();
                }
                // set artist
                exif.setArtist("test artist");

                // set the name of the camera's owner
                exif.setCameraOwnerName("camera owner's name");

                // set description
                exif.setImageDescription("test description");

                // update EXIF data
                jpegFormat.setExifInfo(exif);

                // and commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void fastRemoveExifData() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {
                // reset all exif properties
                jpegFormat.removeExifInfo();
                // and commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void fasterUpdateExifData() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                // get EXIF data
                JpegExifInfo exif = (JpegExifInfo) jpegFormat.getExifValues();

                // set artist
                exif.setArtist("test artist");

                // set the name of the camera's owner
                exif.setCameraOwnerName("camera owner's name");

                // set description
                exif.setImageDescription("test description");

                // set software
                exif.setSoftware("software...");

                // and commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void removeGpsLocation() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                // check if JPEG contains XMP metadata
                if (jpegFormat.hasXmp()) {
                    // get location
                    GpsLocation location = jpegFormat.getGpsLocation();
                    if (location != null) {
                        // remove GPS location
                        jpegFormat.removeGpsLocation();
                    }

                    // update Dublin Core format in XMP
                    jpegFormat.getXmpValues().getSchemes().getDublinCore().setFormat("image/jpeg");

                    // and commit changes
                    jpegFormat.save(Common.mapDestinationFilePath(path));
                }
            }
		}

		public static void addIPTCMetadataJpeg() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                // if file contains iptc metadata
                if (jpegFormat.hasIptc()) {
                    // get iptc collection
                    IptcCollection iptcCollection = jpegFormat.getIptc();

                    // initialize IptcDataSetCollection to read well-known
                    // properties
                    IptcDataSetCollection dsCollection = new IptcDataSetCollection(iptcCollection);

                    // try to read Application Record dataset
                    if (dsCollection.getApplicationRecord() != null) {
                        // get category
                        String category = dsCollection.getApplicationRecord().getCategory();

                        // get headline
                        String headline = dsCollection.getApplicationRecord().getHeadline();
                    }

                    if (dsCollection.getEnvelopeRecord() != null) {
                        // get model version
                        int modelVersion = dsCollection.getEnvelopeRecord().getModelVersion();

                        // get dataSent property
                        Date dataSent = dsCollection.getEnvelopeRecord().getDataSent();
                    }
                }
            }
		}

		public static void updateIPTCMetadataOfJPEG() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                // initialize IptcCollection
                IptcCollection collection = new IptcCollection();

                // add string property
                collection.add(new IptcProperty(2, "category", 15, "formats"));

                // add integer property
                collection.add(new IptcProperty(2, "urgency", 10, 5));

                // update iptc metadata
                jpegFormat.updateIptc(collection);

                // and commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void removeIPTCMetadataOfJPEG() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                // remove iptc
                jpegFormat.removeIptc();

                // and commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void updatePagedTextXMPProperties() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {
                // get access to PagedText schema
                PagedTextPackage pagedTextPackage = jpegFormat.getXmpValues().getSchemes().getPagedText();
                // update MaxPageSize
                pagedTextPackage.setMaxPageSize(new Dimensions(600, 800));
                // update number of pages
                pagedTextPackage.setNumberOfPages(10);
                // update plate names
                pagedTextPackage.setPlateNames(new String[]{"1", "2", "3"});
                // commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void updateCameraRawXMPProperties() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {
                // get access to CameraRaw schema
                CameraRawPackage cameraRawPackage = jpegFormat.getXmpValues().getSchemes().getCameraRaw();
                // update properties
                cameraRawPackage.setAutoBrightness(true);
                cameraRawPackage.setAutoContrast(true);
                cameraRawPackage.setCropUnits(CropUnits.Pixels);
                // update white balance
                cameraRawPackage.setWhiteBalance(WhiteBalance.getAuto());
                // commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void updateBasicJobXMPProperties() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {
                // get xmp data
                XmpPacketWrapper xmp = jpegFormat.getXmpData();

                BasicJobTicketPackage basicJobTicketPackage = null;

                // looking for the BasicJob schema if xmp data is presented
                if (xmp != null) {
                    basicJobTicketPackage = (BasicJobTicketPackage) xmp.getPackage(Namespaces.BasicJob);
                } else {
                    xmp = new XmpPacketWrapper();
                }
                if (basicJobTicketPackage == null) {
                    // create package if not exist
                    basicJobTicketPackage = new BasicJobTicketPackage();

                    // and add it to xmp data
                    xmp.addPackage(basicJobTicketPackage);
                }
                // create array of jobs
                Job[] jobs = new Job[1];
                Job job = new Job();
                job.setName("test job");
                job.setId("1");
                jobs[0] = job;
                // update schema
                basicJobTicketPackage.setJobs(jobs);
                // update xmp data
                jpegFormat.setXmpData(xmp);
                // commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void removePhotoshopMetadata() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                // remove photoshop metadata
                jpegFormat.removePhotoshopData();

                // and commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void getIPTCPhotoMetadataFromXMP() {
			// get xmp metadata
			XmpPacketWrapper xmpWrapper = MetadataUtility.extractXmpPackage(Common.mapSourceFilePath(path));

			if (xmpWrapper == null) {
				xmpWrapper = new XmpPacketWrapper();
			}

			// add iptc4xmpcore if not exist
			if (!xmpWrapper.containsPackage(Namespaces.Iptc4XmpCore)) {
				xmpWrapper.addPackage(new IptcCorePackage());
			}

			// get iptc4XmpCore package
			IptcCorePackage iptcCorePackage = (IptcCorePackage) xmpWrapper.getPackage(Namespaces.Iptc4XmpCore);

			System.out.printf("Country Code: %s", iptcCorePackage.getCountryCode());
			System.out.printf("Sub Location: %s", iptcCorePackage.getSublocation());
			System.out.printf("Intellectual Genre: %s", iptcCorePackage.getIntellectualGenre());
		}

		public static void updateIPTCPhotoMetadataFromXMP() {
			// get xmp metadata
			XmpPacketWrapper xmpWrapper = MetadataUtility.extractXmpPackage(Common.mapSourceFilePath(path));

			if (xmpWrapper == null) {
				xmpWrapper = new XmpPacketWrapper();
			}

			// add iptc4xmpcore if not exist
			if (!xmpWrapper.containsPackage(Namespaces.Iptc4XmpCore)) {
				xmpWrapper.addPackage(new IptcCorePackage());
			}

			// get iptc4XmpCore package
			IptcCorePackage iptcCorePackage = (IptcCorePackage) xmpWrapper.getPackage(Namespaces.Iptc4XmpCore);

			// set country code
			iptcCorePackage.setCountryCode("new country code");

			// set sublocation
			iptcCorePackage.setSublocation("new sublocation");

			// update intellectual genre
			iptcCorePackage.setIntellectualGenre("music");

			// save changes to another file
			MetadataUtility.updateMetadata(Common.mapSourceFilePath(path), new XmpMetadata(xmpWrapper),
					Common.mapDestinationFilePath(outputPath));
		}

		public static void detectBarcode() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(barcodeFilePath))) {

                // get barcodes: UPCA, UPCE, EAN13
                String[] barCodes = jpegFormat.getBarCodeTypes();
                for (int i = 0; i < barCodes.length; i++) {
                    // Prints Bar Code Type
                    System.out.printf("Code Type: %s", barCodes[i].toString());
                }
            }
		}

		public static void readImageResourceBlocks() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {
                // check if JPEG contain photoshop metadata
                if (jpegFormat.hasImageResourceBlocks()) {

                    // get native photoshop metadata
                    ImageResourceMetadata imageResource = jpegFormat.getImageResourceBlocks();

                    // display all blocks
                    for (ImageResourceBlock imageResourceBlock : imageResource.getBlocks()) {
                        System.out.printf("Id: %s, size: %s", imageResourceBlock.getDefinedId(),
                                imageResourceBlock.getDataSize());

                        // create your own logic to parse image resource block
                        byte[] data = imageResourceBlock.getData();
                    }
                }
            }
		}

		public static void readSonyMakerNotes() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(sonyMakerFilePath))) {

                // get maker notes
                MakerNotesBase makernotes = jpegFormat.getMakernotes();
                if (makernotes != null) {
                    // try cast to SonyMakerNotes
                    SonyMakerNotes sonyMakerNotes = (SonyMakerNotes) makernotes;
                    if (sonyMakerNotes != null) {
                        // get color mode
                        int colorMode = sonyMakerNotes.getColorMode();

                        // get JPEG quality
                        int jpegQuality = sonyMakerNotes.getJPEGQuality();
                        System.out.printf("color mode: {0},Jpeg quality: {1}", colorMode, jpegQuality);
                    }

                }
            }
		}

		public static void readNikonMakerNotes() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(nikonMakerFilePath))) {

                // get maker notes
                MakerNotesBase makernotes = jpegFormat.getMakernotes();
                if (makernotes != null) {
                    // try cast to NikonMakerNotes
                    NikonMakerNotes nikonMakerNotes = (NikonMakerNotes) makernotes;
                    if (nikonMakerNotes != null) {
                        // get quality string
                        String quality = nikonMakerNotes.getColorMode();

                        // get version
                        byte[] version = nikonMakerNotes.getMakerNoteVersion();

                        System.out.printf("Quality: %s,Version: %s", quality, version);
                    }
                }
            }
		}

		public static void readPanasonicMakerNotes() {
			// initialize JpegFormat

            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(panasonicMakerFilePath))) {
                // get maker notes
                MakerNotesBase makernotes = jpegFormat.getMakernotes();
                if (makernotes != null) {
                    if (makernotes instanceof PanasonicMakerNotes) {
                        // try cast to PanasonicMakerNotes
                        PanasonicMakerNotes panasonicMakerNotes = (PanasonicMakerNotes) makernotes;
                        // get firmware version
                        String firmwareVersion = panasonicMakerNotes.getFirmwareVersion();
                        // get image quality
                        Integer imageQuality = panasonicMakerNotes.getImageQuality();
                        // get lens type
                        String lensType = panasonicMakerNotes.getLensType();

                        System.out.printf("firmwareVersion: %s,imageQuality: %s,lensType: %s", firmwareVersion,
                                imageQuality, lensType);

                    }
                }
            }
		}

		public static void readCannonMakerNotes() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(canonMakerFilePath))) {

                // get maker notes
                MakerNotesBase makernotes = jpegFormat.getMakernotes();
                if (makernotes != null) {
                    // try cast to CanonMakerNotes
                    CanonMakerNotes canonMakerNotes = (CanonMakerNotes) makernotes;

                    if (canonMakerNotes != null) {
                        // get camera settings
                        CanonCameraSettings cameraSettings = canonMakerNotes.getCameraSettings();

                        if (cameraSettings != null) {
                            // get lens type
                            int lensType = cameraSettings.getLensType();

                            // get quality
                            int quality = cameraSettings.getQuality();

                            // get all values
                            int[] allValues = cameraSettings.getValues();

                            System.out.printf("lensType: %s,quality: %s", lensType, quality);
                            for (int value : allValues) {
                                System.out.printf("\nValue: %s,", value);
                            }
                        }

                        // get firmware version
                        String firmwareVersion = canonMakerNotes.getCanonFirmwareVersion();

                        System.out.printf("\nfirmwareVersion: %s,", firmwareVersion);
                    }
                }
            }
		}

		public static void readTiffSRationalTag() {
			// initialize JpegFormat

            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                // get existing EXIF or create new one
                ExifInfo exif = jpegFormat.getExifInfo();
                if (exif != null) {
                    // get all TIFF tags
                    TiffTag[] tags = exif.getTags();

                    for (TiffTag t : tags) {
                        // get tag type
                        switch (t.getTagType()) {
                            case TiffTagType.SRational:
                                TiffSRationalTag srationalTag = (TiffSRationalTag) t;
                                System.out.printf("Value: %s", srationalTag.getValue());
                                break;
                        }
                    }
                }
            }
		}

		public static void updateTiffTags() {
			// initialize JpegFormat
            try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                // get existing EXIF or create new one
                ExifInfo exif = jpegFormat.getExifInfo();

                // init EXIF metadata if not exist
                if (exif == null) {
                    exif = new JpegExifInfo();
                }

                // define array of tags
                TiffTag[] tags = new TiffTag[1];

                // add 'Artist' tag
                tags[0] = new TiffAsciiTag(TiffTagIdEnum.Artist, "Jack");

                // and update tags
                exif.setTags(tags);

                // update exif
                jpegFormat.updateExifInfo(exif);
                // and commit changes
                jpegFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

        public static void getEXIFMetadataWithBetterSpeed() {
			try{
				// initialize JpegFormat
                try (JpegFormat jpegFormat = new JpegFormat(Common.mapSourceFilePath(path))) {

                    // get EXIF data
                    JpegExifInfo exif = (JpegExifInfo) jpegFormat.getExifInfo();

                    if (exif == null) {
                        // initialize EXIF data if null
                        exif = new JpegExifInfo();
                    }

                    // set artist
                    exif.setArtist("test artist");

                    // set the name of the camera's owner
                    exif.setCameraOwnerName("camera owner's name");

                    // set description
                    exif.setImageDescription("test description");

                    // update EXIF data
                    jpegFormat.setExifInfo(exif);

                    // commit changes
                    jpegFormat.save(Common.mapDestinationFilePath(outputPath));

                    // and close the file
                    jpegFormat.dispose();
                }
			}catch (Exception ex){
				System.out.println(ex.getMessage());
			}
        }

		public static void findEXIFMetadataUsingRegex() {
			try {
				Pattern pattern = Pattern.compile(".*");
				ExifProperty[] properties = SearchFacade.scanExif(Common.mapSourceFilePath(path), pattern);
				for (int i = 0; i < properties.length; i++)
                {
                    System.out.println(properties[i]);
                }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void replaceEXIFMetadataUsingRegex() {
			try {
				Pattern pattern = Pattern.compile("James", Pattern.CASE_INSENSITIVE);
				String replaceValue = "John";
				SearchFacade.replaceInExif(Common.mapSourceFilePath(path), pattern, replaceValue, Common.mapDestinationFilePath(path));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void getTiffTagsUsingExifProperties() {
			// initialize TiffFormat
			try (JpegFormat format = new JpegFormat(Common.mapDestinationFilePath(path)))
			{
				ExifInfo exif = format.getExifInfo();
			
				if (exif != null)
				{
					for (TiffTag tag : exif.getTags())
					{
						if (tag.getTagId() == TiffTagIdEnum.XResolution || tag.getTagId() == TiffTagIdEnum.YResolution)
						{
							System.out.println(tag.getName() + " = " +  ((TiffRationalTag)tag).getTagValue()[0].getValue());
						}
					}
				}
			}
		}

		
	}

	public static class Png {
		private static String path = "\\Images\\Png\\sample.png";
		private static String outputPath = "\\Images\\Png\\result.png";

		public static void getXMPProperties() {
			// initialize PngFormat
            try (PngFormat pngFormat = new PngFormat(Common.mapSourceFilePath(path))) {

                // get xmp properties
                XmpProperties xmpProperties = pngFormat.getXmpProperties();
                // show xmp properties
                for (String key : xmpProperties.getKeys()) {
                    XmpNodeView xmpNodeView = xmpProperties.get_Item(key);
                    System.out.printf("[%s] = %s", xmpNodeView.getName(), xmpNodeView.getValue());
                }
            }
		}

		public static void updateXMPProperties() {
			// initialize PngFormat
            try (PngFormat pngFormat = new PngFormat(Common.mapSourceFilePath(path))) {

                // get xmp wrapper
                XmpPacketWrapper xmpPacket = pngFormat.getXmpData();

                // create xmp wrapper is not exist
                if (xmpPacket == null)
                    xmpPacket = new XmpPacketWrapper();
                // check if DublinCore schema is exist
                if (!xmpPacket.containsPackage(Namespaces.DublinCore)) {
                    xmpPacket.addPackage(new DublinCorePackage());
                }
                // get DublinCore package
                DublinCorePackage dublinCorePackage = (DublinCorePackage) xmpPacket.getPackage(Namespaces.DublinCore);

                // set author
                dublinCorePackage.setAuthor("Test author");
                // set description
                dublinCorePackage.setDescription("Some description");

                // update XMP package
                pngFormat.setXmpData(xmpPacket);

                // and commit changes
                pngFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void removeXMPProperties() {
			// initialize PngFormat
            try (PngFormat pngFormat = new PngFormat(Common.mapSourceFilePath(path))) {
                // remove XMP package
                pngFormat.removeXmpData();

                // and commit changes
                pngFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void updatePagedTextXMPProperties() {
			// initialize PngFormat
            try (PngFormat pngFormat = new PngFormat(Common.mapSourceFilePath(path))) {
                // get access to PagedText schema
                PagedTextPackage pagedTextPackage = pngFormat.getXmpValues().getSchemes().getPagedText();
                // update MaxPageSize
                pagedTextPackage.setMaxPageSize(new Dimensions(600, 800));
                // update number of pages
                pagedTextPackage.setNumberOfPages(10);
                // update plate names
                pagedTextPackage.setPlateNames(new String[]{"1", "2", "3"});
                // commit changes
                pngFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void updateCameraRawXMPProperties() {
			// initialize PngFormat
            try (PngFormat pngFormat = new PngFormat(Common.mapSourceFilePath(path))) {
                // get access to CameraRaw schema
                CameraRawPackage cameraRawPackage = pngFormat.getXmpValues().getSchemes().getCameraRaw();
                // update properties
                cameraRawPackage.setAutoBrightness(true);
                cameraRawPackage.setAutoContrast(true);
                cameraRawPackage.setCropUnits(CropUnits.Pixels);
                // update white balance
                cameraRawPackage.setWhiteBalance(WhiteBalance.getAuto());
                // commit changes
                pngFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void updateBasicJobXMPProperties() {
			// initialize PngFormat
            try (PngFormat pngFormat = new PngFormat(Common.mapSourceFilePath(path))) {
                // get xmp data
                XmpPacketWrapper xmp = pngFormat.getXmpData();

                BasicJobTicketPackage basicJobTicketPackage = null;

                // looking for the BasicJob schema if xmp data is presented
                if (xmp != null) {
                    basicJobTicketPackage = (BasicJobTicketPackage) xmp.getPackage(Namespaces.BasicJob);
                } else {
                    xmp = new XmpPacketWrapper();
                }
                if (basicJobTicketPackage == null) {
                    // create package if not exist
                    basicJobTicketPackage = new BasicJobTicketPackage();

                    // and add it to xmp data
                    xmp.addPackage(basicJobTicketPackage);
                }
                // create array of jobs
                Job[] jobs = new Job[1];
                Job job = new Job();
                job.setName("test job");
                job.setId("1");
                jobs[0] = job;
                // update schema
                basicJobTicketPackage.setJobs(jobs);
                // update xmp data
                pngFormat.setXmpData(xmp);
                // commit changes
                pngFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}
	}

	public static class Tiff {
		private static String path = "\\Images\\Tiff\\sample.tif";
		private static String outputPath = "\\Images\\Tiff\\result.tif";

		public static void readTiffFileDirectoryTags() {
			// initialize TiffFormat
            try (TiffFormat tiffFormat = new TiffFormat(Common.mapSourceFilePath(path))) {

                // get IFD
                TiffIfd[] directories = tiffFormat.getImageFileDirectories();

                if (directories.length > 0) {
                    // get tags of the first IFD
                    TiffTag[] tags = tiffFormat.getTags(directories[0]);

                    // write tags to the console
                    for (TiffTag tiffTag : tags) {
                        System.out.printf("tag: %s", tiffTag.getDefinedTag());
                        switch (tiffTag.getTagType()) {
                            case TiffTagType.Ascii:
                                TiffAsciiTag asciiTag = (TiffAsciiTag) tiffTag;
                                System.out.printf("Value: %s", asciiTag.getValue());
                                break;

                            case TiffTagType.Short:
                                TiffShortTag shortTag = (TiffShortTag) tiffTag;
                                System.out.printf("Value: %s", shortTag.getValue());
                                break;

                            default:
                                break;
                        }
                    }
                }
            }
		}

		public static void getExifInfo() {
			// initialize TiffFormat
            try (TiffFormat tiffFormat = new TiffFormat(Common.mapSourceFilePath(path))) {
                // get EXIF data
                ExifInfo exif = tiffFormat.getExifInfo();
                if (exif != null) {
                    // get Camera Owner Name
                    System.out.printf("Camera Owner Name: %s", exif.getCameraOwnerName());

                    // get Body Serial Number
                    System.out.printf("Body Serial Number: %s", exif.getBodySerialNumber());

                    // get user's comment
                    System.out.printf("Comment: %s", exif.getUserComment());
                }
            }
		}
		public static void updateExifInfoUsingProperties() {
			// initialize TiffFormat
            try (TiffFormat tiffFormat = new TiffFormat(Common.mapSourceFilePath(path))) {

                // set the name of the camera's owner
                tiffFormat.getExifValues().setCameraOwnerName("camera owner's name");

                // set user comment
                tiffFormat.getExifValues().setUserComment("user's comment");

                // and commit changes
                tiffFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void updateExifInfo() {
			// initialize TiffFormat
            try (TiffFormat tiffFormat = new TiffFormat(Common.mapSourceFilePath(path))) {
                ExifInfo exifInfo = tiffFormat.getExifInfo();
                // set the name of the camera's owner
                exifInfo.setCameraOwnerName("camera owner's name");
                // set user comment
                exifInfo.setUserComment("user's comment");
                // and commit changes
                tiffFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void removeExifData() {
			// initialize TiffFormat
            try (TiffFormat tiffFormat = new TiffFormat(Common.mapSourceFilePath(path))) {
                // reset all exif properties
                tiffFormat.removeExifInfo();
                // and commit changes
                tiffFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void getXMPProperties() {
			// initialize TiffFormat
            try (TiffFormat tiffFormat = new TiffFormat(Common.mapSourceFilePath(path))) {

                // get xmp properties
                XmpProperties xmpProperties = tiffFormat.getXmpProperties();
                // show xmp properties
                for (String key : xmpProperties.getKeys()) {
                    XmpNodeView xmpNodeView = xmpProperties.get_Item(key);
                    System.out.printf("[%s] = %s", xmpNodeView.getName(), xmpNodeView.getValue());
                }
            }
		}
		public static void getXMPPropertiesusingStream()throws IOException {
			try (InputStream stream = new FileInputStream(Common.mapSourceFilePath(path)))
				{
					try (TiffFormat format = new TiffFormat(stream))
					{						
						// get xmp properties
						XmpProperties xmpProperties = format.getXmpProperties();
						// show xmp properties
						for (String key : xmpProperties.getKeys()) {
							XmpNodeView xmpNodeView = xmpProperties.get_Item(key);
							System.out.printf("[%s] = %s", xmpNodeView.getName(), xmpNodeView.getValue());
						}					
					}
					// The stream is still open here
				}	
		}

		public static void readIPTCmetadataTiff() {
			// initialize TiffFormat
            try (TiffFormat tiffFormat = new TiffFormat(Common.mapSourceFilePath(path))) {
                // check if tiff contains IPTC metadata
                if (tiffFormat.hasIptc()) {
                    // get iptc collection
                    IptcCollection iptc = tiffFormat.getIptc();

                    // and display it
                    for (int i = 0; i < iptc.getCount(); i++) {
                        IptcProperty iptcProperty = iptc.readByIndex(i);
                        System.out.printf("%s: %s", iptcProperty.getName(), iptcProperty.getFormattedValue());
                    }
                }
            }
		}

		public static void removeXMPMetadata() {
			// initialize TiffFormat
			try (TiffFormat tiffFormat = new TiffFormat(Common.mapSourceFilePath(path)))
			{
				//remove Xmp Properties
				tiffFormat.removeXmpData();

				// commit changes and save output file
				tiffFormat.save(Common.mapDestinationFilePath(path));
			}
		}
		public static void removeXMPMetadataUsingStream() throws IOException {
			try (OutputStream stream = new FileOutputStream(Common.mapDestinationFilePath(path)))
				{
					try (TiffFormat format = new TiffFormat(Common.mapSourceFilePath(path)))
					{
						//remove Xmp Properties
						format.removeXmpData();
				
						format.save(stream);
					}
					// The stream is still open here
				}
		}

		public static void extractSpecificTiffTags() {
			// initialize TiffFormat
			try (TiffFormat format = new TiffFormat(Common.mapSourceFilePath(path)))
			{
				TiffTag[] tags = format.getTags(format.getImageFileDirectories()[0]);
			
				for (TiffTag tag : tags)
				{
					if (tag.getTagId() == TiffTagIdEnum.XResolution || tag.getTagId() == TiffTagIdEnum.YResolution)
					{
						System.out.println(tag.getName() + " = " +  ((TiffRationalTag)tag).getTagValue()[0].getValue());
					}
				}
			}
		}
		//This method is supported by version 18.9 or greater
		public static void updateExifMetadataUsingShortcutProperties() {	
			try (TiffFormat format = new TiffFormat(Common.mapSourceFilePath(path)))
			{    
				format.getExifValues().setArtist("GroupDocs");    
				format.getExifValues().setSoftware("GroupDocs.Metadata");     
			
				format.save(Common.mapDestinationFilePath(path));
			}
		}
		//This method is supported by version 18.9 or greater
		public static void updateExifMetadatByReplacingTagCollection() {	
			try (TiffFormat format = new TiffFormat(Common.mapSourceFilePath(path)))
			{
				TiffTag[] tags = new TiffTag[]
				{
					new TiffAsciiTag(TiffTagIdEnum.Artist, "GroupDocs"),
					new TiffAsciiTag(TiffTagIdEnum.Copyright, "GroupDocs.Metadata"),
				};
				format.getExifValues().setTags(tags);
			
				format.save(Common.mapDestinationFilePath(path));
			}
		}
		//This method is supported by version 18.9 or greater
		public static void updateExifIFDTagsUsingShortcutProperties() {
			try (TiffFormat format = new TiffFormat(Common.mapSourceFilePath(path)))
			{
				format.getExifValues().getExifIfdData().setUserComment("test comment");
				format.getExifValues().getExifIfdData().setBodySerialNumber("1010101010");
				format.save(Common.mapDestinationFilePath(path));
			}
		}
		//This method is supported by version 18.9 or greater
		public static void updateExifIFDTagsByReplacingTagCollection() {
			try (TiffFormat format = new TiffFormat(Common.mapSourceFilePath(path)))
			{
				TiffTag[] tags = new TiffTag[]
				{
						new TiffAsciiTag(42032, "test camera owner"), // CameraOwnerName
						new TiffAsciiTag(42033, "test body serial number"), // BodySerialNumber
				};
				format.getExifValues().getExifIfdData().setTags(tags);
				format.save(Common.mapDestinationFilePath(path));
			}
		}
	}

	public static class WebP {
		private static String path = "\\Images\\Webp\\sample.webp";

		public static void getMetadataProperties() {
			// initialize WebPFormat
            try (WebPFormat webpFormat = new WebPFormat(Common.mapSourceFilePath(path))) {
                System.out.printf("Width: %s, height: %s", webpFormat.getWidth(), webpFormat.getHeight());
            }
		}
	}

	public static class DJVU {
		private static String path = "\\Images\\Djuv\\sample.djuv";

		public static void getMetadataProperties() {
			// initialize DjvuFormat
            try (DjvuFormat wmfFormat = new DjvuFormat(Common.mapSourceFilePath(path))) {
                System.out.printf("Width: %s, height: %s", wmfFormat.getWidth(), wmfFormat.getHeight());
            }
		}
	}

	public static class BMP {
		private static String path = "\\Images\\Bmp\\sample.bmp";

		public static void getHeaderProperties() {
			// initialize BmpFormat

            try (BmpFormat bmpFormat = new BmpFormat(Common.mapSourceFilePath(path))) {

                // get BMP header
                BmpHeader header = bmpFormat.getHeaderInfo();
                // display bits per pixel
                System.out.printf("Bits per pixel: %s", header.getBitsPerPixel());

                // display header size
                System.out.printf("Header size: %s", header.getHeaderSize());

                // display image size
                System.out.printf("Image size: %s", header.getImageSize());
            }
		}

		public static void getMetadataProperties() {
			// initialize BmpFormat class
            try (BmpFormat bmpFormat = new BmpFormat(Common.mapSourceFilePath(path))) {
                // display height and width in console
                System.out.printf("Width: %s, Height: %s", bmpFormat.getWidth(), bmpFormat.getHeight());
            }
		}
	}

	public static class DICOM {
		private static String path = "\\Images\\Dicom\\sample";

		public static void getheaderProperties() {
			// initialize DICOMFormat

            try (DICOMFormat dicom = new DICOMFormat(Common.mapSourceFilePath(path))) {
                // get DICOM metadata
                DicomMetadata header = dicom.getInfo();
                // get array of DICOM info data
                String[] dicomInfo = header.getDicomInfo();

                // get number of frames
                int numberOfFrames = header.getNumberOfFrames();
                System.out.printf("Number of frames: %s", numberOfFrames);
            }
		}

	}

	public static class Psd {
		private static String path = "\\Images\\Psd\\sample.psd";

		public static void getPsdInfo() {
			// initialize PsdFormat
            try (PsdFormat psdFormat = new PsdFormat(Common.mapSourceFilePath(path))) {

                // check if JPEG contain photoshop metadata
                if (psdFormat.hasImageResourceBlocks()) {
                    // get native photoshop metadata
                    ImageResourceMetadata imageResource = psdFormat.getImageResourceBlocks();

                    // display all blocks
                    for (ImageResourceBlock imageResourceBlock : imageResource.getBlocks()) {
                        System.out.printf("Id: %s, size: %s", imageResourceBlock.getDefinedId(),
                                imageResourceBlock.getDataSize());

                    // create your own logic to parse image resource block
                        /* Byte */
                        byte[] data = imageResourceBlock.getData();
                    }
                }
            }
		}

		public static void getXMPProperties() {
			// initialize PsdFormat
            try (PsdFormat psdFormat = new PsdFormat(Common.mapSourceFilePath(path))) {

                // get photoshop namespace
                PhotoshopPackage photoshopMetadata = psdFormat.getXmpValues().getSchemes().getPhotoshop();
                // get color mode
                System.out.printf("color Mode: %s", photoshopMetadata.getColorMode());

                // get IIC profile
                System.out.printf("iicProfile: %s", photoshopMetadata.getICCProfile());
            }
		}

		public static void readLayers() {
			// initialize PsdFormat
            try (PsdFormat psdFormat = new PsdFormat(Common.mapSourceFilePath(path))) {

                // get all layers
                PsdLayer[] layers = psdFormat.getLayers();
                for (PsdLayer layer : layers) {
                    // display layer short info
                    System.out.printf("Name: %s, channels count: %s", layer.getName(), layer.getChannelsCount());
                }
            }
		}

		public static void readIPTCmetadataPsd() {
			// initialize PsdFormat
            try (PsdFormat psdFormat = new PsdFormat(Common.mapSourceFilePath(path))) {
                // check if PSD contains IPTC metadata
                if (psdFormat.hasIptc()) {
                    // get iptc collection
                    IptcCollection iptc = psdFormat.getIptc();

                    // and display it
                    for (int i = 0; i < iptc.getCount(); i++) {
                        IptcProperty iptcProperty = iptc.readByIndex(i);
                        System.out.printf("%s: %s", iptcProperty.getName(), iptcProperty.getFormattedValue());
                    }
                }
            }
		}
		//Update IPTC Metadata
		//This version is supported by version 18.7 or higher
        public static void updateIPTCMetadata() {
			// initialize PsdFormat
			try (PsdFormat format = new PsdFormat(Common.mapSourceFilePath(path)))
			{
				IptcCollection iptc = format.getIptc();
				if (iptc == null)
				{
					iptc = new IptcCollection();
				}
				iptc.add(new IptcProperty(2, "urgency", 10, 5));
				format.updateIptc(iptc);
				format.save(Common.mapDestinationFilePath(path));
			}

        }
		//Remove IPTC Metadata
		//This version is supported by version 18.7 or higher
		public static void removeIPTCMetadata() {
			try (PsdFormat format = new PsdFormat(Common.mapSourceFilePath(path)))
			{
				format.removeIptc();
				format.save(Common.mapDestinationFilePath(path));
			}
		}

		public static void readIPTCMetadatasUsingStream() throws IOException {
			try (InputStream stream = new FileInputStream(Common.mapSourceFilePath(path)))
			{
				try (PsdFormat format = new PsdFormat(stream))
				{
					// check if PSD contains IPTC metadata
					if (format.hasIptc()) {
						// get iptc collection
						IptcCollection iptc = format.getIptc();

						// and display it
						for (int i = 0; i < iptc.getCount(); i++) {
							IptcProperty iptcProperty = iptc.readByIndex(i);
							System.out.printf("%s: %s", iptcProperty.getName(), iptcProperty.getFormattedValue());
						}
					}
				}
				// The stream is still open here
			}
		}


		public static void updateIPTCMetadataUsingStream() throws IOException {
			try (OutputStream stream = new FileOutputStream(Common.mapDestinationFilePath(path)))
			{
				try (PsdFormat format = new PsdFormat(Common.mapSourceFilePath(path)))
				{
					// Working with metadata
					IptcCollection iptc = format.getIptc();
					if (iptc == null)
					{
						iptc = new IptcCollection();
					}
					iptc.add(new IptcProperty(2, "urgency", 10, 5));
					format.updateIptc(iptc);
					format.save(stream);
				}
				// The stream is still open here
			}
		}
		//This method is supported by version 18.9 or greater
		public static void readEXIFMetadata() {
			try (PsdFormat format = new PsdFormat(Common.mapSourceFilePath(path)))
			{
				ExifInfo exif = format.getExifInfo();
				if (exif != null)
				{
					for (TiffTag tag : exif.getTags())
					{
						System.out.println(tag.getName());
						System.out.println(tag.getTagType());
						System.out.println(tag.getFormattedValue());
					}
				}
			}
		}
	}

	public static class EMF {
		private static String path = "\\Images\\Emf\\sample.emf";
		public static void getMetadataProperties() {
			// initialize EmfFormat class
            try (EmfFormat emfFormat = new EmfFormat(Common.mapSourceFilePath(path))) {
                // display height and width in console
                System.out.printf("Width: %s, Height: %s", emfFormat.getWidth(), emfFormat.getHeight());
            }
		}
	}

	public static class WMF {
		private static String path = "\\Images\\Wmf\\sample.wmf";

		public static void getMetadataProperties() {
			// initialize WmfFormat class

            try (WmfFormat wmfFormat = new WmfFormat(Common.mapSourceFilePath(path))) {
                // display height and width in console
                System.out.printf("Width: %s, Height: %s", wmfFormat.getWidth(), wmfFormat.getHeight());
            }


		}
	}
}
