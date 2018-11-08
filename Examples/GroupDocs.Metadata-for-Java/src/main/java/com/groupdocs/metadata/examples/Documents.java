package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.*;
import com.groupdocs.metadata.examples.Utilities.Common;
import org.apache.commons.io.FileUtils;


import java.io.*;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.regex.Pattern;

public class Documents {
	public static class Doc {
		private static String path = "\\Documents\\Doc\\sample.doc";
		private static String outputPath = "\\Documents\\Doc\\result.doc";

		public static void getDocumentProperties() {

			try (DocFormat docFormat = new DocFormat("D:\\Documents\\sample.doc")) {
				// get document properties
                DocMetadata properties = docFormat.getDocumentProperties();
                // get author
				System.out.printf("Author: %s ", properties.getAuthor());
				// get company
				System.out.printf("Company: %s ", properties.getAuthor());
				// get name of the last author

			}
		}

		public static void updateDocumentProperties() {
			// initialize DocFormat
			try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

				// get document properties
				DocMetadata properties = docFormat.getDocumentProperties();

				// update built-in properties
				properties.setAuthor("test author");
				properties.setCompany("test company");
				properties.setManager("test manager");

				// commit changes
				docFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void removeDocumentProperties() {
			// initialize DocFormat
			try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
				// reset built-in document properties; remove all comments and
				// custom properties
				docFormat.cleanMetadata();
				// commit changes
				docFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void addCustomProperty() {
			// initialize DocFormat
			try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
				// initialize DocMetadata
				DocMetadata metadata = docFormat.getDocumentProperties();
				// add string key
				if (!metadata.containsKey("NET version")) {
					metadata.add("NET version", "4.0");
				}
				// add boolean key
				if (!metadata.containsKey("IsSigned")) {
					metadata.add("IsSigned", false);
				}
				// save changes
				docFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void getCustomProperties() {
			// initialize PdfFormat
			try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
				// get DocMetadata
				DocMetadata metadata = docFormat.getDocumentProperties();
				// get metadata all metadata keys
				String[] metadataKeys = metadata.getKeys();
				for (String key : metadataKeys) {
					// check if metadata value is custom
					if (!metadata.isBuiltIn(key)) {
						// get metadata value by key
						PropertyValue propertyValue = metadata.readPropertyValue(key);

						// write value to output
						System.out.printf("key: %s, type: %s, value: %s", key, propertyValue.getType(), propertyValue);
					}
				}
			}
		}

		public static void getHiddenData() {
			// initialize DocFormat

            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

                // inspect document
                DocInspectionResult inspectionResult = docFormat.inspectDocument();
                // if merge fields are presented
                if (inspectionResult.getComments().length > 0) {
                    System.out.printf("Comments in document:");
                    for (DocComment comment : inspectionResult.getComments()) {
                        System.out.printf("Comment: %s", comment.getText());
                        System.out.printf("Author: %s", comment.getAuthor());
                        System.out.printf("Date: %s", comment.getCreatedDate());
                    }
                }
                // display merge fields
                if (inspectionResult.getFields().length > 0) {
                    System.out.printf("\nMerge Fields in document:");
                    for (DocField field : inspectionResult.getFields()) {
                        System.out.printf(field.getName());
                    }
                }
                // display hidden fields
                if (inspectionResult.getHiddenText().length > 0) {
                    System.out.printf("\nHiddent text in document:");
                    for (String word : inspectionResult.getHiddenText()) {
                        System.out.printf(word);
                    }
                }
            }
		}

		public static void removeMergeFields() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
                // inspect document
                DocInspectionResult inspectionResult = docFormat.inspectDocument();

                // if merge fields are presented
                if (inspectionResult.getFields().length > 0) {
                // remove it
                    docFormat.removeHiddenData(new DocInspectionOptions(DocInspectorOptionsEnum.Fields));

                // and commit changes
                    docFormat.save(Common.mapDestinationFilePath(outputPath));
                }
            }

		}

		public static void removeCustomProperties() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
                // get DocMetadata
                DocMetadata metadata = docFormat.getDocumentProperties();
                // check if metadata value is custom
                if (metadata.containsKey("Affiliate") && !metadata.isBuiltIn("Affiliate")) {
                    // and remove it
                    metadata.remove("Affiliate");
                }
                // and save changes
                docFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void clearCustomProperties() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
                // Use one of the following methods
                // Method 1 - clear custom properties
                // docFormat.clearCustomProperties();
                // Method 2 - clear custom properties
                docFormat.getDocumentProperties().clearCustomData();
                // commit changes
                docFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void readComments() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
                // get comments
                DocComment[] comments = docFormat.extractComments();
                for (DocComment comment : comments) {
                    System.out.printf("Author: %s", comment.getAuthor());
                    System.out.printf("Created on Date: %s", comment.getCreatedDate());
                    System.out.printf("Initials: %s", comment.getInitials());
                    System.out.printf("\n");
                }
            }

		}

		public static void removeComments() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
                // remove all comments
                docFormat.clearComments();
                // commit changes
                docFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void updateComments() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

                // extract comments
                DocComment[] comments = docFormat.extractComments();

                if (comments.length > 0) {
                    // get first comment if exist
                    DocComment comment = comments[0];

                    // change comment's author
                    comment.setAuthor("Jack London");

                    // change comment's text
                    comment.setText("This comment is created using GroupDocs.Metadata");

                    // update comment
                    docFormat.updateComment(comment.getId(), comment);

                    // and commit changes
                    docFormat.save(Common.mapDestinationFilePath(outputPath));
                }
            }
		}

		public static void saveFileAfterMetadataUpdate() {
			// initialize format
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
                // update document properties
                docFormat.getDocumentProperties().setAuthor("Joe Doe");
                docFormat.getDocumentProperties().setCompany("Aspose");
                // commit changes
                docFormat.save();
            }
		}

		public static void readDocumentInfo() {
			// initialize DocFormat

            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
                // get document info
                DocumentInfo documentInfo = docFormat.getDocumentInfo();
                // get number of words in document
                System.out.printf("words : %s", documentInfo.getWordsCount());

                // get number of pages in document
                System.out.printf("Pages: %s", documentInfo.getPagesCount());
            }

		}

		public static void detectProtectedDocument() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {
                // determines whether document is protected by password
                boolean isProtected = docFormat.isProtected();
                System.out.printf("IsProtected : %s", isProtected);
            }

		}

		public static void documentProtectedException() {
			try {
				// initialize DocFormat
                try (DocFormat pdfFormat = new DocFormat(path)) {

                    // and try to get document properties
                    DocMetadata documentProperties = pdfFormat.getDocumentProperties();
                }
			} catch (DocumentProtectedException ex) {
				System.out.printf("File is protected by password PDF: %s", ex.getMessage());
			}
		}

		public static void removeHiddenData() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

                // inspect document
                DocInspectionResult inspectionResult = docFormat.inspectDocument();

                // if merge fields are presented
                if (inspectionResult.getFields().length > 0) {
                    // remove it
                    docFormat.removeHiddenData(new DocInspectionOptions(DocInspectorOptionsEnum.Fields));

                    // save file in destination folder
                    docFormat.save(Common.mapDestinationFilePath(outputPath));
                }
            }
		}

		public static void lazyLoadDocumentInfoProperty() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

                // get document info
                DocumentInfo documentInfo = docFormat.getDocumentInfo();

                // next call returns previous documentInfo object
                DocumentInfo next = docFormat.getDocumentInfo();
            }

		}

		public static void detectDocumentType() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

                // display file type
                switch (docFormat.getFileType()) {
                    case FileType.Doc:
                        System.out.printf("Old binary document");
                        break;

                    case FileType.Docx:
                        System.out.printf("XML-based document");
                        break;
                }
            }
		}

		public static void readDigitalSignature() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

                // if document contains digital signatures
                if (docFormat.hasDigitalSignatures()) {
                    // then inspect it
                    DocInspectionResult inspectionResult = docFormat.inspectDocument();

                    // and get digital signatures
                    DigitalSignature[] signatures = inspectionResult.getDigitalSignatures();

                    for (DigitalSignature signature : signatures) {
                        // get certificate subject
                        System.out.printf("Certificate subject: {0}", signature.getCertificateSubject());

                        // get certificate sign time
                        System.out.printf("Signed time: {0}", signature.getSignTime());
                    }
                }
            }
		}

		public static void removeDigitalSignature() {
			// initialize DocFormat
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

                // if document contains digital signatures
                if (docFormat.hasDigitalSignatures()) {
                    // then remove them
                    docFormat.removeHiddenData(new DocInspectionOptions(DocInspectorOptionsEnum.DigitalSignatures));

                    // and commit changes
                    docFormat.save();
                }
            }
		}

		public static void readDublinCoreMetadata() {
			try {
				// open EPUB file
				DublinCoreMetadata dublinCoreMetadata = (DublinCoreMetadata) MetadataUtility.extractSpecificMetadata(Common.mapSourceFilePath(path), MetadataType.DublinCore);

				// get dc title
				System.out.printf("Title = %s\n", dublinCoreMetadata.getTitle());

				// get creator
				System.out.printf("Creator = %s\n", dublinCoreMetadata.getCreator());

				// get dc publisher
				System.out.printf("Publisher = %s\n", dublinCoreMetadata.getPublisher());

				// get dc description
				System.out.printf("Description = %s\n", dublinCoreMetadata.getDescription());

				// get language
				System.out.printf("Language = %s\n", dublinCoreMetadata.getLanguage());

				// get format
				System.out.printf("Format = %s\n", dublinCoreMetadata.getFormat());

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		public static void readImageCoverMetadataUtility() {
			try {
				// Get Thumbnail Metadata
				ThumbnailMetadata thumbnailMetadata = (ThumbnailMetadata)MetadataUtility.extractSpecificMetadata(Common.mapSourceFilePath(path), MetadataType.Thumbnail);
				//Get Mime Type
				System.out.println(thumbnailMetadata.getMimeType());
				//Get Image Data Length
				System.out.println(thumbnailMetadata.getImageData().length);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

        public static void findMetadataUsingRegex() {
            try {
                Pattern pattern = Pattern.compile("author|company", Pattern.CASE_INSENSITIVE);
                MetadataPropertyCollection properties = SearchFacade.scanDocument(Common.mapSourceFilePath(path), pattern);
                for (int i = 0; i < properties.getCount(); i++)
                {
                    System.out.println(properties.readByIndex(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public static void replaceMetadataUsingRegex() {
            try {
                Pattern pattern = Pattern.compile("^author|company$", Pattern.CASE_INSENSITIVE);
                String replaceValue = "Aspose";
                SearchFacade.replaceInDocument(Common.mapSourceFilePath(path), pattern, replaceValue, Common.mapDestinationFilePath(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	public static class Ppt {
		private static String path = "\\Documents\\ppt\\sample.pptx";
		private static String outputPath = "\\Documents\\ppt\\result.pptx";

		public static void getDocumentProperties() {
			// initialize PptFormat

            try (PptFormat pptFormat = new PptFormat(Common.mapSourceFilePath(path))) {
                // get document properties
                PptMetadata properties = pptFormat.getDocumentProperties();
                // get author
                System.out.printf("Author: %s", properties.getAuthor());
                // get company
                System.out.printf("Company: %s", properties.getCompany());
                // get created date of the document
                System.out.printf("Created Date: %s", properties.getCreatedTime());
            }
		}

		public static void updateDocumentProperties() {
			// initialize PptFormat
            try (PptFormat pptFormat = new PptFormat(Common.mapSourceFilePath(path))) {
                // get document properties
                PptMetadata properties = pptFormat.getDocumentProperties();
                // update built-in properties
                properties.setAuthor("test author");
                properties.setSubject("test subject");
                properties.setManager("test manager");
                // commit changes
                pptFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void removeDocumentProperties() {
			// initialize PptFormat
            try (PptFormat pptFormat = new PptFormat(Common.mapSourceFilePath(path))) {
                // reset built-in document properties; remove all custom properties
                pptFormat.cleanMetadata();
                // commit changes
                pptFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void addCustomProperty() {
			// initialize PptFormat
            try (PptFormat pptFormat = new PptFormat(Common.mapSourceFilePath(path))) {

                // get document properties
                PptMetadata metadata = pptFormat.getDocumentProperties();

                // add string key
                if (!metadata.containsKey("NET version")) {
                    metadata.add("NET version", "4.0");
                }

                // add boolean key
                if (!metadata.containsKey("IsSigned")) {
                    metadata.add("IsSigned", false);
                }
                // save changes
                pptFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void getCustomProperties() {
			// initialize PptFormat
            try (PptFormat pptFormat = new PptFormat(Common.mapSourceFilePath(path))) {

                // get document properties
                PptMetadata metadata = pptFormat.getDocumentProperties();
                // get metadata keys
                String[] keys = metadata.getKeys();

                for (String key : keys) {
                    // check if metadata value is custom
                    if (!metadata.isBuiltIn(key)) {
                        // get metadata value by key
                        PropertyValue propertyValue = metadata.readPropertyValue(key);

                        // write value to output
                        System.out.printf("key: %s, type: %s, value: %s", key, propertyValue.getType(), propertyValue);
                    }
                }
            }


		}

		public static void removeCustomProperties() {
			// initialize PptFormat
            try (PptFormat pptFormat = new PptFormat(Common.mapSourceFilePath(path))) {

                // get document properties
                PptMetadata metadata = pptFormat.getDocumentProperties();

                // check if metadata value is custom
                if (!metadata.isBuiltIn("Affiliate")) {
                    // and remove it
                    metadata.remove("Affiliate");
                }
                // and save changes
                pptFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void getHiddenData() {
			// initialize PptFormat
            try (PptFormat pptFormat = new PptFormat(Common.mapSourceFilePath(path))) {

                // get hidden data
                PptInspectionResult hiddenData = pptFormat.inspectDocument();
                // get comments
                PptComment[] comments = hiddenData.getComments();

                for (PptComment comment : comments) {
                    System.out.printf("Author: %s, slide: %s", comment.getAuthor(), comment.getSlideId());
                }
            }
		}

		public static void removeHiddenData() {
			// initialize PptFormat
            try (PptFormat pptFormat = new PptFormat(Common.mapSourceFilePath(path))) {

                // get hidden data
                PptInspectionResult hiddenData = pptFormat.inspectDocument();

                // get comments
                PptComment[] comments = hiddenData.getComments();

                if (comments.length > 0) {
                    // remove all comments
                    pptFormat.removeHiddenData(new PptInspectionOptions(PptInspectorOptionsEnum.Comments));

                    // and commit changes
                    pptFormat.save();
                }
            }
		}
	}

	public static class Xls {
		private static String path = "\\Documents\\Xls\\sample.xls";
		private static String outputPath = "\\Documents\\Xls\\result.xls";

		public static void getDocumentProperties() {
			// initialize XlsFormat
            try (XlsFormat format = new XlsFormat(Common.mapSourceFilePath(path))) {

                System.out.println(format.getDocumentProperties().getAuthor());
                System.out.println(format.getDocumentProperties().getCompany());
                System.out.println(format.getDocumentProperties().getCreatedTime());

                // Following metadata properties are supported by version 18.11 or higher
                System.out.println(format.getDocumentProperties().getLanguage());
                System.out.println(format.getDocumentProperties().getContentStatus());
                System.out.println(format.getDocumentProperties().getContentType());
                System.out.println(format.getDocumentProperties().getCreatedTime());
                System.out.println(format.getDocumentProperties().getTotalEditingTime());
                System.out.println(format.getDocumentProperties().getLastSavedTime());
                System.out.println(format.getDocumentProperties().getLastPrintedDate());
                System.out.println(format.getDocumentProperties().getLastSavedBy());
                System.out.println(format.getDocumentProperties().getRevision());
                System.out.println(format.getDocumentProperties().getVersion());
            }
		}

		public static void updateDocumentProperties() {
			// initialize XlsFormat
            try (XlsFormat xlsFormat = new XlsFormat(Common.mapSourceFilePath(path))) {

                // update built-in properties
                xlsFormat.getDocumentProperties().setAuthor("test author");
                xlsFormat.getDocumentProperties().setSubject("test subject");
                xlsFormat.getDocumentProperties().setManager("test manager");

                // Following metadata properties are supported by version 18.11 or higher
                xlsFormat.getDocumentProperties().setLanguage("test language");
                xlsFormat.getDocumentProperties().setContentStatus("test content status");
                xlsFormat.getDocumentProperties().setContentType("test content type");
                xlsFormat.getDocumentProperties().setCreatedTime(new Date());
                xlsFormat.getDocumentProperties().setTotalEditingTime(100);
                xlsFormat.getDocumentProperties().setLastSavedTime(new Date());
                xlsFormat.getDocumentProperties().setLastPrintedDate(new Date());
                xlsFormat.getDocumentProperties().setLastSavedBy("test last saved by");
                xlsFormat.getDocumentProperties().setRevision("test revision");
                xlsFormat.getDocumentProperties().setVersion("12.1111");

                // commit changes
                xlsFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void removeDocumentProperties() {
			// initialize XlsFormat
            try (XlsFormat xlsFormat = new XlsFormat(Common.mapSourceFilePath(path))) {
                // reset built-in document properties; remove all custom properties
                xlsFormat.cleanMetadata();
                // commit changes
                xlsFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void addCustomProperty() {
			// initialize XlsFormat
            try (XlsFormat xlsFormat = new XlsFormat(Common.mapSourceFilePath(path))) {
                // get document properties
                XlsMetadata metadata = xlsFormat.getDocumentProperties();
                // add string key
                if (!metadata.containsKey("NET version")) {
                    metadata.add("NET version", "4.0");
                }
                // add boolean key
                if (!metadata.containsKey("IsSigned")) {
                    metadata.add("IsSigned", false);
                }
                // save changes
                xlsFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void getCustomProperties() {
			// initialize XlsFormat
            try (XlsFormat xlsFormat = new XlsFormat(Common.mapSourceFilePath(path))) {
                // get document properties
                XlsMetadata metadata = xlsFormat.getDocumentProperties();
                // get collection
                MetadataPropertyCollection collection = metadata.getCollection();

                for (int i = 0; i < collection.getCount(); i++) {
                    // get next metadata property
                    MetadataProperty property = collection.readByIndex(i);

                    // check if property is not built-in
                    if (!property.isBuiltInProperty()) {
                        // get property value
                        PropertyValue propertyValue = property.getValue();

                        // write value to output
                        System.out.printf("key: %s, type: %s, value: %s", property.getName(), propertyValue.getType(),
                                propertyValue);
                    }
                }
            }
		}

		public static void removeCustomProperties() {
			// initialize XlsFormat
            try (XlsFormat xlsFormat = new XlsFormat(Common.mapSourceFilePath(path))) {

                // get document properties
                XlsMetadata metadata = xlsFormat.getDocumentProperties();

                // check if metadata value is custom
                if (!metadata.isBuiltIn("Affiliate")) {
                    // and remove it
                    metadata.remove("Affiliate");
                }
                // and save changes
                xlsFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void getContentTypeDocumentProperties() {
			// initialize XlsFormat
            try (XlsFormat xlsFormat = new XlsFormat(Common.mapSourceFilePath(path))) {
                // get content properties
                for (XlsContentProperty property : xlsFormat.getDocumentProperties().getContentTypeProperties())
                {
                    System.out.println(property.getFormattedValue());
                }
            }
		}

		public static void addContentTypeProperty() {

			// initialize XlsFormat
            try (XlsFormat xlsFormat = new XlsFormat(Common.mapSourceFilePath(path))) {

                // get all xls properties
                XlsMetadata xlsProperties = xlsFormat.getDocumentProperties();

                // if Excel contains content type properties
                if (xlsProperties.getContentTypeProperties().length > 0) {
                    // than remove all content type properties
                    xlsProperties.clearContentTypeProperties();
                }

                // set hidden field
                xlsProperties.addContentTypeProperty("user hidden id", "asdk12dkvjdjh3");

                // and commit changes
                xlsFormat.save(Common.mapDestinationFilePath(outputPath));
            }

		}

		public static void readThumbnailXls() {
			// initialize XlsFormat

            try (XlsFormat docFormat = new XlsFormat(Common.mapSourceFilePath(path))) {

                // get thumbnail
                /* Byte */
                byte[] thumbnailData = docFormat.getThumbnail();
                // check if first sheet is empty
                if (thumbnailData.length == 0) {
                    System.out.println("Excel sheet is empty and does not contain data");
                } else {
                    // write thumbnail to PNG image since it has png format
                    // ..
                }
            }


		}

		public static void exportContentTypeProperties() throws IOException {
			// export to excel
			byte[] content = ExportFacade.exportToExcel(Common.mapSourceFilePath(path));
			// write data to the file
			FileUtils.writeByteArrayToFile(new File(Common.mapDestinationFilePath(outputPath)), content);

			System.out.printf("File has been exported");
		}

		public static void getHiddenData() {
			// initialize XlsFormat

            try (XlsFormat xlsFormat = new XlsFormat(Common.mapSourceFilePath(path))) {

                // get hidden data
                XlsInspectionResult hiddenData = xlsFormat.inspectDocument();
                // get hidden sheets
                XlsSheet[] hiddenSheets = hiddenData.getHiddenSheets();

                // get comments
                XlsComment[] comments = hiddenData.getComments();

                if (comments.length > 0) {
                    for (XlsComment comment : comments) {
                        System.out.printf("Comment: {0}, Column: {1}", comment, comment.getColumn());
                    }
                } else {
                    System.out.printf("No comment found!");
                }
            }


		}

		public static void removeHiddenData() {
			// initialize XlsFormat
            try (XlsFormat xlsFormat = new XlsFormat(Common.mapSourceFilePath(path))) {

                // get hidden data
                XlsInspectionResult hiddenData = xlsFormat.inspectDocument();

                // get hidden sheets
                XlsSheet[] hiddenSheets = hiddenData.getHiddenSheets();

                // display hidden fields
                if (hiddenSheets.length > 0) {
                    // clear hidden sheets
                    xlsFormat.removeHiddenData(new XlsInspectionOptions(XlsInspectorOptionsEnum.HiddenSheets));
                    System.out.printf("Hidden sheets removed.");

                    // and commit changes
                    xlsFormat.save();
                    System.out.printf("Changes save successfully!");
                } else
                    System.out.printf("No sheets found.");
            }
		}

		public static void readImageCoverMetadataUtility() {
			try {
				// Get Thumbnail Metadata
				ThumbnailMetadata thumbnailMetadata = (ThumbnailMetadata)MetadataUtility.extractSpecificMetadata(Common.mapSourceFilePath(path), MetadataType.Thumbnail);
				//Get Mime Type
				System.out.println(thumbnailMetadata.getMimeType());
				//Get Image Data Length
				System.out.println(thumbnailMetadata.getImageData().length);

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		}
	}

	public static class Pdf {
		private static String path = "\\Documents\\Pdf\\sample.pdf";
		private static String outputPath = "\\Documents\\Pdf\\result.pdf";

		public static void getDocumentProperties() {
			// initialize PdfFormat
            try (PdfFormat pdfFormat = new PdfFormat(Common.mapSourceFilePath(path))) {
                // get document properties
                PdfMetadata properties = pdfFormat.getDocumentProperties();
                // get author
                System.out.printf("Author: %s", properties.getAuthor());
                // get producer
                System.out.printf("Producer: %s", properties.getProducer());
                // get created date of the document
                System.out.printf("Created Date: %s", properties.getCreatedDate());
            }
		}

		public static void updateDocumentProperties() {
			// initialize PdfFormat
            try (PdfFormat pdfFormat = new PdfFormat(Common.mapSourceFilePath(path))) {
                // get document properties
                PdfMetadata properties = pdfFormat.getDocumentProperties();
                // update built-in properties
                properties.setAuthor("test author");
                properties.setSubject("test subject");
                properties.setTrappedFlag(true);
                // commit changes
                pdfFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void removeDocumentProperties() {
			// initialize PdfFormat
            try (PdfFormat pdfFormat = new PdfFormat(Common.mapSourceFilePath(path))) {

                // reset built-in document properties; remove all custom properties
                pdfFormat.cleanMetadata();

                // commit changes
                pdfFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void addCustomProperty() {
			// initialize PdfFormat
            try (PdfFormat pdfFormat = new PdfFormat(Common.mapSourceFilePath(path))) {

                // initialize PdfMetadata
                PdfMetadata metadata = pdfFormat.getDocumentProperties();

                // add string key
                if (!metadata.containsKey("NET version")) {
                    metadata.add("NET version", "4.0");
                }
                // save changes
                pdfFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void getCustomProperties() {
			// initialize PdfFormat
            try (PdfFormat pdfFormat = new PdfFormat(Common.mapSourceFilePath(path))) {
                // initialize PdfMetadata
                PdfMetadata metadata = pdfFormat.getDocumentProperties();
                // get metadata all metadata keys
                String[] metadataKeys = metadata.getKeys();

                for (String key : metadataKeys) {
                    // check if metadata value is custom
                    if (!metadata.isBuiltIn(key)) {
                        // get metadata value by key
                        PropertyValue propertyValue = metadata.readPropertyValue(key);

                        // write value to output
                        System.out.printf("key: %s, type: %s, value: %s", key, propertyValue.getType(), propertyValue);
                    }
                }
            }

		}

		public static void removeCustomProperties() {
			// initialize PdfFormat
            try (PdfFormat pdfFormat = new PdfFormat(Common.mapSourceFilePath(path))) {

                // initialize PdfMetadata
                PdfMetadata metadata = pdfFormat.getDocumentProperties();

                // check if metadata value is custom
                if (!metadata.isBuiltIn("Affiliate")) {
                    // and remove it
                    metadata.remove("Affiliate");
                }

                // and save changes
                pdfFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

		public static void updateXMPProperties() {
			// initialize PdfFormat
            try (PdfFormat pdfFormat = new PdfFormat(Common.mapSourceFilePath(path))) {

                // get pdf schema
                PdfPackage pdfPackage = pdfFormat.getXmpValues().getSchemes().getPdf();

                // update keywords
                pdfPackage.setKeywords("literature, programming");

                // update pdf version
                pdfPackage.setPdfVersion("1.0");

                // commit changes
                pdfFormat.save(Common.mapDestinationFilePath(outputPath));
            }

		}

		public static void getXMPProperties() {
			// initialize Pdf Format
            try (PdfFormat pdfFormat = new PdfFormat(Common.mapSourceFilePath(path))) {
                // get pdf schema
                PdfPackage pdfPackage = pdfFormat.getXmpValues().getSchemes().getPdf();
                System.out.printf("Keywords: %s", pdfPackage.getKeywords());
                System.out.printf("PdfVersion: %s", pdfPackage.getPdfVersion());
                System.out.printf("Producer: %s", pdfPackage.getProducer());
            }
		}

		public static void removeHiddenData() {
			// initialize PdfFormat
            try (PdfFormat pdfFormat = new PdfFormat(Common.mapSourceFilePath(path))) {

                // inspect document
                PdfInspectionResult inspectionResult = pdfFormat.inspectDocument();

                // get annotations
                PdfAnnotation[] annotation = inspectionResult.getAnnotations();

                // if annotations are presented
                if (annotation.length > 0) {
                    // remove all annotation
                    pdfFormat.removeHiddenData(new PdfInspectionOptions(PdfInspectorOptionsEnum.Annotations));

                    // and commit changes
                    pdfFormat.save(Common.mapDestinationFilePath(outputPath));
                }
            }
		}

		public static void readDublinCoreMetadata() {
			try {
				//Read DublinCore Metadata
				DublinCoreMetadata dublinCoreMetadata = (DublinCoreMetadata) MetadataUtility.extractSpecificMetadata(Common.mapSourceFilePath(path), MetadataType.DublinCore);

				// get dc title
				System.out.printf("Title = %s\n", dublinCoreMetadata.getTitle());

				// get creator
				System.out.printf("Creator = %s\n", dublinCoreMetadata.getCreator());

				// get dc publisher
				System.out.printf("Publisher = %s\n", dublinCoreMetadata.getPublisher());

				// get dc description
				System.out.printf("Description = %s\n", dublinCoreMetadata.getDescription());

				// get language
				System.out.printf("Language = %s\n", dublinCoreMetadata.getLanguage());

				// get format
				System.out.printf("Format = %s\n", dublinCoreMetadata.getFormat());

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public static class MSVisio {
		private static String path = "\\Documents\\MSVisio\\sample.vdx";
		private static String outputPath = "\\Documents\\MSVisio\\result.vdx";

		public static void getMetadata() {
			// initialize VisioFormat
            try (VisioFormat visioFormat = new VisioFormat(Common.mapSourceFilePath(path))) {

                VisioMetadata properties = visioFormat.getDocumentProperties();
                // get company
                System.out.printf("Company : %s", properties.getCompany());

                // get creator
                System.out.printf("Creator: %s", properties.getCreator());
            }
		}

		public static void updateMetadata() {
			// initialize VisioFormat
            try (VisioFormat visioFormat = new VisioFormat(Common.mapSourceFilePath(path))) {

                // get properties
                VisioMetadata properties = visioFormat.getDocumentProperties();

                // update creator
                properties.setCreator("Joe Doe");

                // update title
                properties.setTitle("example");

                // commit changes
                visioFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}

	}

	public static class OneNote {
		private static String path = "\\Documents\\OneNote\\sample.one";
		private static String outputPath = "\\Documents\\OneNote\\result.one";

		public static void getPagesInfo() {
			// initialize OneNoteFormat
            try (OneNoteFormat oneNoteFormat = new OneNoteFormat(Common.mapSourceFilePath(path))) {
                // and read pages
                OneNotePageInfo[] pages = oneNoteFormat.getPages();
                for (OneNotePageInfo page : pages) {
                    System.out.println("Author: " + page.getAuthor());
                    System.out.println("Title: " + page.getTitle());
                }
            }
		}
	}

	public static class MSProject {
		private static String path = "\\Documents\\MSProject\\sample.mpp";

		public static void getMetadata() {
			// initialize MppFormat
            try (MppFormat mppFormat = new MppFormat(Common.mapSourceFilePath(path))) {

                // get document properties
                MppMetadata properties = mppFormat.getProjectProperties();

                if (mppFormat != null) {
                    // get Author
                    System.out.printf("Author: %s", properties.getAuthor());
                    // get Company
                    System.out.printf("Company: %s", properties.getCompany());
                    // get Keywords
                    System.out.printf("Keywords: %s", properties.getKeywords());
                }
            }

		}
        // This Feature is supported in version 18.6 or greater of the API
        public static void updateMetadata() {
            try (MppFormat format = new MppFormat(Common.mapSourceFilePath(path)))
            {
                format.getProjectInfo().setAuthor("John Smith");
                format.getProjectInfo().setSubject("Test project");
                format.getProjectInfo().setCategory("Software Development");

                format.save(Common.mapDestinationFilePath(path));
            }
        }
        // This Feature is supported in version 18.6 or greater of the API
        public static void cleanMetadata() {
            try (MppFormat format = new MppFormat(Common.mapSourceFilePath(path)))
            {
                format.cleanMetadata();
                format.save(Common.mapDestinationFilePath(path));
            }
        }
        // This Feature is supported in version 18.6 or greater of the API
        public static void updateMetadataUsingStream() throws IOException {
            try (OutputStream stream = new FileOutputStream(Common.mapDestinationFilePath(path)))
            {
                try (MppFormat format = new MppFormat(Common.mapSourceFilePath(path)))
                {
                    // Working with metadata

                    format.save(stream);
                }
                // The stream is still open here
            }
        }
    }

	public static class ODT {
		private static String path = "\\Documents\\odt\\sample.odt";
		private static String outputPath = "\\Documents\\Odt\\result.odt";

		public static void getOdtMetadata() {
			// initialize DocFormat with ODT file's path
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

                // read all metadata properties
                Metadata metadata = docFormat.getDocumentProperties();
                // get metadata keys
                String[] keys = metadata.getKeys();

                for (String key : keys) {
                    // get metadata value by key
                    MetadataProperty propertyValue = metadata.readByStringKey(key);
                    // write value to output
                    System.out.printf("key: %s, type: %s, value: %s", key, propertyValue.getName(), propertyValue);

                }
            }
		}

		public static void updateOdtMetadata() {
			// initialize DocFormat with ODT file's path
            try (DocFormat docFormat = new DocFormat(Common.mapSourceFilePath(path))) {

                // initialize DocMetadata
                DocMetadata docMetadata = docFormat.getDocumentProperties();

                // update document property...
                docMetadata.setAuthor("Ali");
                docMetadata.setCompany("Aspose");
                docMetadata.setManager("Ali Ahmed");

                // save output file...
                docFormat.save(Common.mapDestinationFilePath(outputPath));
            }
		}
	}


	public static class EPUB {
		private static String path = "\\Documents\\Epub\\sample.epub";

		public static void detectEPUBFormat() {
			// init FileFormatChecker
            try (FileFormatChecker formatChecker = new FileFormatChecker(Common.mapSourceFilePath(path))) {

                // validate format
                boolean isEpub = formatChecker.verifyFormat(DocumentType.Epub);
                // and print appropriate message if success
                if (isEpub) {
                    System.out.println("Is EPUB");
                }
            }
		}

		public static void readEPUBFormatMetadata() {

			// open EPUB file
            try (EpubFormat epub = new EpubFormat(Common.mapSourceFilePath(path))) {

                // read EPUB metadata
                EpubMetadata metadata = epub.getEpubMetadata();
                // get keys
                String[] keys = metadata.getKeys();

                for (String key : keys) {
                    // get next metadata property
                    MetadataProperty property = metadata.readByStringKey(key);

                    // and print it
                    System.out.println(property);
                }
            }
		}

		public static void readDublinCoreMetadata() {
			// open EPUB file
            try (EpubFormat epub = new EpubFormat(Common.mapSourceFilePath(path))) {

                // read DublinCore metadata
                DublinCoreMetadata dublinCore = epub.getDublinCore();
                // get dc title
                System.out.printf("Title = %s\n", dublinCore.getTitle());

                // get creator
                System.out.printf("Creator = %s\n", dublinCore.getCreator());

                // get dc publisher
                System.out.printf("Publisher = %s\n", dublinCore.getPublisher());

                // get dc description
                System.out.printf("Description = %s\n", dublinCore.getDescription());

                // get language
                System.out.printf("Language = %s\n", dublinCore.getLanguage());

                // get format
                System.out.printf("Format = %s\n", dublinCore.getFormat());
            }
		}

		public static void readImageCover() {
            try (EpubFormat epubFormat = new EpubFormat(Common.mapSourceFilePath(path)))
            {
                ThumbnailMetadata thumbnail = epubFormat.readThumbnail();
                if (thumbnail != null)
                {
                    System.out.println(thumbnail.getImageData().length);
                    System.out.println(thumbnail.getMimeType());
                }
            }
		}

		public static void readEPUBPackageVersion() {
			try {
				// open EPUB file
                try (EpubFormat epub = new EpubFormat(Common.mapSourceFilePath(path))) {
                    // read EPUB metadata
                    EpubMetadata metadata = epub.getEpubMetadata();
                    // close file after getting metadata
                    epub.dispose();
                    // and print version
                    System.out.printf("EPUB version = %s", metadata.getVersion());
                }

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		public static void readDublinCoreMetadataUtility() {
			try {
				// open EPUB file
				DublinCoreMetadata dublinCoreMetadata = (DublinCoreMetadata) MetadataUtility.extractSpecificMetadata(Common.mapSourceFilePath(path), MetadataType.DublinCore);

				// get dc title
				System.out.printf("Title = %s\n", dublinCoreMetadata.getTitle());

				// get creator
				System.out.printf("Creator = %s\n", dublinCoreMetadata.getCreator());

				// get dc publisher
				System.out.printf("Publisher = %s\n", dublinCoreMetadata.getPublisher());

				// get dc description
				System.out.printf("Description = %s\n", dublinCoreMetadata.getDescription());

				// get language
				System.out.printf("Language = %s\n", dublinCoreMetadata.getLanguage());

				// get format
				System.out.printf("Format = %s\n", dublinCoreMetadata.getFormat());

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

        public static void getMetadataUsingStream() {
            try (InputStream stream = new FileInputStream(Common.mapSourceFilePath(path)))
            {
                try (EpubFormat format = new EpubFormat(stream))
                {
                    // read EPUB metadata
                    EpubMetadata metadata = format.getEpubMetadata();
                    // get keys
                    String[] keys = metadata.getKeys();

                    for (String key : keys) {
                        // get next metadata property
                        MetadataProperty property = metadata.readByStringKey(key);

                        // and print it
                        System.out.println(property);
                    }
                }
                // The stream is still open here
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
