# Document Metadata Library for Java

GroupDocs.Metadata for Java provides easy ways to [Manage Document Metadata via Java](https://products.groupdocs.com/metadata/java). It enables you to read, write, update and remove metadata of a [wide range of file formats](https://docs.groupdocs.com/metadata/java/supported-document-formats/) including documents, images, emails, archives and many more. It also provides the feature to search and update metadata in document files.

<p align="center">

  <a title="Download complete GroupDocs.Metadata for Java source code" href="https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java/archive/master.zip">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

Directory | Description
--------- | -----------
[Docs](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java/tree/master/Docs)  | Product documentation containing the Developer's Guide, Release Notes and more.
[Examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java/tree/master/Examples)  | Java examples and sample documents for you to get started quickly. 

## Read, Write, Update & Remove Document Metadata

- Read, update and remove metadata from 60+ popular file formats.
- Search, update and remove particular metadata properties that satisfy a specification.
- Use tags to easily manipulate most common metadata properties in a unified manner.
- [Load & work with password-protected documents](https://docs.groupdocs.com/metadata/java/load-a-password-protected-document/).
- Extract information about hidden document pages, digital signatures, user comments, revisions and more.
- Supports most popular metadata standards: IPTC, XMP, EXIF, Image Resources.
- Manipulate native metadata properties in various formats, extracting technical information from images, audio and video files.
- [Calculate common document statistics](https://docs.groupdocs.com/metadata/java/get-document-info/).
- Auto-detect the format and MIME type of a file by its internal structure.
- Supports various audio tags including ID3, Lyrics & APE.

## Get Started with GroupDocs.Metadata for Java

GroupDocs.Metadata for Java requires J2SE 7.0 (1.7), J2SE 8.0 (1.8) or above. Please install Java first if you do not have it already. 

GroupDocs hosts all Java APIs on [GroupDocs Artifact Repository](https://artifact.groupdocs.com/webapp/#/artifacts/browse/tree/General/repo/com/groupdocs/groupdocs-metadata), so simply [configure](https://docs.groupdocs.com/metadata/java/installation/) your Maven project to fetch the dependencies automatically.

## Find Metadata Property via Tag

```java
// Constants.InputPptx is an absolute or relative path to your document. Ex: @"C:\Docs\source.pptx"
try (Metadata metadata = new Metadata(Constants.InputPptx)) {
	// Fetch all the properties satisfying the predicate:
	// property contains the name of the last document editor OR the date/time the document was last modified
	IReadOnlyList<MetadataProperty> properties = metadata.findProperties(
			new ContainsTagSpecification(Tags.getPerson().getEditor()).or(new ContainsTagSpecification(Tags.getTime().getModified())));
	for (MetadataProperty property : properties) {
		System.out.println(String.format("Property name: %s, Property value: %s", property.getName(), property.getValue()));
	}
}
```

## Add or Update Metadata Properties Satisfying a Predicate

```java
// Constants.InputVsdx is an absolute or relative path to your document. Ex: @"C:\Docs\source.vsdx"
try (Metadata metadata = new Metadata(Constants.InputVsdx)) {
	// Set the value of each property that satisfies the predicate:
	// property contains the date/time the document was created OR modified
	int affected = metadata.setProperties(
			new ContainsTagSpecification(Tags.getTime().getCreated()).or(new ContainsTagSpecification(Tags.getTime().getModified())),
			new PropertyValue(new Date()));
	System.out.println(String.format("Properties set: %s", affected));
	metadata.save(Constants.OutputVsdx);
}
```

[Home](https://www.groupdocs.com/) | [Product Page](https://products.groupdocs.com/metadata/java) | [Documentation](https://docs.groupdocs.com/metadata/java/) | [Demos](https://products.groupdocs.app/metadata/family) | [API Reference](https://apireference.groupdocs.com/java/metadata) | [Examples](https://github.com/groupdocs-metadata/GroupDocs.metadata-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/metadata/) | [Free Support](https://forum.groupdocs.com/c/metadata) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
