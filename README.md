## GroupDocs.Metadata for Java



[Product Page](https://products.groupdocs.com/metadata/java) | [Docs](https://docs.groupdocs.com/metadata/java/) | [Demos](https://products.groupdocs.com/metadata/java/demos) | [API Reference](https://reference.groupdocs.com/metadata/java/) | [Examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java) | [Blog](https://blog.groupdocs.com/categories/groupdocs.metadata-product-family/) | [Releases](https://releases.groupdocs.com/metadata/java/) | [Free Support](https://forum.groupdocs.com/c/metadata/) | [Temporary License](https://purchase.groupdocs.com/temp-license)



GroupDocs.Metadata for Java is a full-featured class library enabling developers to read, edit, and remove metadata from over 110 document, image, audio, video, and other file formats—including popular formats like PDF, Office documents, images (JPEG, PNG, TIFF, HEIF), audio (MP3, WAV), video (AVI, MKV, MOV), archives (ZIP, 7z), CAD, fonts, emails, and more—while supporting leading metadata standards such as XMP, EXIF, IPTC, ID3, and format-specific properties.

### Features

- Reading, updating, and removing metadata from documents, images, audio, video, and other file formats  
- Searching for and modifying specific metadata properties using flexible filtering and specification-based queries  
- Working with password-protected files to access and edit metadata securely  
- Extracting and managing metadata from popular standards including XMP, EXIF, IPTC, and ID3  
- Handling hidden content such as digital signatures, comments, revisions, and embedded objects  
- Manipulating native metadata properties for Word, Excel, PowerPoint, PDF, CAD, and many other formats  
- Calculating document statistics like word count, character count, and page count  
- Exporting and cleaning metadata to ensure privacy compliance and data hygiene

See the [Features overview](https://docs.groupdocs.com/metadata/java/features-overview/) documentation topic for more details.

### Supported formats

## Supported Formats (high level)

This API supports a broad set of document and media formats, including:

- **Word Processing**: DOC, DOCX, DOCM, ODT, DOT, DOTM
- **Spreadsheets**: XLS, XLSX, XLSM, ODS, XLSB, XLT
- **Presentations**: PPT, PPTX, PPS, PPSX, POT, POTM
- **PDF**: PDF
- **Images**: JPG, PNG, TIFF, BMP, GIF, PSD
- **Audio/Video**: MP3, WAV, OGG, AVI, MOV, MKV, ASF, FLV, MK3D
- **Email**: EML, MSG
- **eBook**: EPUB, MOBI, FB2
- **Archives**: ZIP, RAR, 7Z, TAR, CB7, CBR
- **Fonts**: OTF, TTF, TTC, OTC
- **CAD**: DWG, DXF
- **3D**: FBX, STL, 3DS, DAE, GLTF
- **Visio**: VSD, VSDX, VDX, VSS, VSX, VTX
- **OneNote**: ONE
- **GIS**: KML, GPX, GEOJSON, GML, OSM, SHP
- **Other formats**: MPP, MPT, TORRENT, VCF, VCR

Supports **110+ formats**. See the [supported file formats](https://docs.groupdocs.com/metadata/java/supported-document-formats/) table for the complete list.

### Getting Started


Add the dependency via Maven or Gradle. See the [Java release hub](https://releases.groupdocs.com/metadata/java/) for current coordinates and repository URL.

```xml
<dependency>
  <groupId>com.groupdocs</groupId>
  <artifactId>groupdocs-metadata</artifactId>
  <version>LATEST</version>
</dependency>
```

See [documentation](https://docs.groupdocs.com/metadata/java/) and the examples in this repository for runnable samples.

#### Remove all recognized metadata properties from a file

Sometimes you may need to just remove all or clean metadata properties without applying any filters.

```java
// "input.pdf" is an absolute or relative path to your document. Ex: @"C:\Docs\input.pdf"
try (Metadata metadata = new Metadata("input.pdf")) {
            int affected = metadata.removeProperties(
                    new ContainsTagSpecification(Tags.getPerson().getCreator()).or(
                            new ContainsTagSpecification(Tags.getPerson().getEditor())).or(
                            new OfTypeSpecification(MetadataPropertyType.String).and(new RemoveMetadataProperties().new WithValueSpecification("John"))));

            System.out.println(String.format("Properties removed: %s", affected));

            metadata.save("output.pdf");
        }
```

#### Use tags to find most common metadata properties

To make manipulating metadata easier we attach specific tags to the most commonly used metadata properties extracted from a file.

```java
// "input.pptx" is an absolute or relative path to your document. Ex: @"C:\Docs\source.pptx"
        try (Metadata metadata = new Metadata("input.pptx")) {

            // Fetch all the properties satisfying the predicate:
            // property contains the name of the last document editor OR the date/time the document was last modified
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(
                    new ContainsTagSpecification(Tags.getPerson().getEditor()).or(new ContainsTagSpecification(Tags.getTime().getModified())));
            for (MetadataProperty property : properties) {
                System.out.println(String.format("Property name: %s, Property value: %s", property.getName(), property.getValue()));
            }
        }
```

#### Get Document Info

GroupDocs.Metadata allows users to get document information which includes.

```java
// "input.xlsx" is an absolute or relative path to your document. Ex: @"C:\Docs\source.xlsx"
try (Metadata metadata = new Metadata("input.xlsx")) {
            if (metadata.getFileFormat() != FileFormat.Unknown) {
                IDocumentInfo info = metadata.getDocumentInfo();
                System.out.println(String.format("File format: %s", info.getFileType().getFileFormat()));
                System.out.println(String.format("File extension: %s", info.getFileType().getExtension()));
                System.out.println(String.format("MIME Type: %s", info.getFileType().getMimeType()));
                System.out.println(String.format("Number of pages: %s", info.getPageCount()));
                System.out.println(String.format("Document size: %s bytes", info.getSize()));
                System.out.println(String.format("Is document encrypted: %s", info.isEncrypted()));
            }
        }}
}
```



Explore the sample projects in this repository or open [documentation](https://docs.groupdocs.com/metadata/java/) for more topics.

### Support

Our technical support is available to all users, including those evaluating our product. We offer assistance through our [Free Support Forum](https://forum.groupdocs.com/c/metadata/) and [Paid Support Helpdesk](https://helpdesk.groupdocs.com/). Let us know if you have any questions or issues, and we'll do our best to help you.

[Product Page](https://products.groupdocs.com/metadata/java) | [Docs](https://docs.groupdocs.com/metadata/java/) | [Demos](https://products.groupdocs.com/metadata/java/demos) | [API Reference](https://reference.groupdocs.com/metadata/java/) | [Examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java) | [Blog](https://blog.groupdocs.com/categories/groupdocs.metadata-product-family/) | [Releases](https://releases.groupdocs.com/metadata/java/) | [Free Support](https://forum.groupdocs.com/c/metadata/) | [Temporary License](https://purchase.groupdocs.com/temp-license)
