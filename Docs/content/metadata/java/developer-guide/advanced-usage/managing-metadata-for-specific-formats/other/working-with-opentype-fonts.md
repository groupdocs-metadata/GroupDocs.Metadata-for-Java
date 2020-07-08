---
id: working-with-opentype-fonts
url: metadata/java/working-with-opentype-fonts
title: Working with OpenType fonts
weight: 5
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
OpenType is a format for scalable computer fonts. It was built on its predecessor TrueType, retaining TrueType's basic structure and adding many intricate data structures for prescribing typographic behavior.

{{< alert style="info" >}}Please find more information on the OpenType format here: https://en.wikipedia.org/wiki/OpenType.{{< /alert >}}

## Reading OpenType metadata

The GroupDocs.Metadata API supports extracting format-specific information from OpenType font files.

The following are the steps to read the header of an OpenType file.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an OpenType font file
2.  Get the root metadata package
3.  Extract  the native metadata package using the [OpenTypeRootPackage.getOpenTypePackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/OpenTypeRootPackage#getOpenTypePackage()) method
4.  Read the OpenType font properties

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>font.OpenTypeReadNativeMetadataProperties**

```csharp
try (Metadata metadata = new Metadata(Constants.InputTtf)) {
	OpenTypeRootPackage root = metadata.getRootPackageGeneric();

	// Read the OpenType font metadata
	for (OpenTypeFont metadataEntry : root.getOpenTypePackage().getFonts()) {
		// Display the values of some metadata properties
		System.out.println(metadataEntry.getCreated());
		System.out.println(metadataEntry.getDirectionHint());
		System.out.println(metadataEntry.getEmbeddingLicensingRights());
		System.out.println(metadataEntry.getFlags());
		System.out.println(metadataEntry.getFontFamilyName());
		System.out.println(metadataEntry.getFontRevision());
		System.out.println(metadataEntry.getFontSubfamilyName());
		System.out.println(metadataEntry.getFullFontName());
		System.out.println(metadataEntry.getGlyphBounds());
		System.out.println(metadataEntry.getMajorVersion());
		System.out.println(metadataEntry.getMinorVersion());
		System.out.println(metadataEntry.getModified());
		System.out.println(metadataEntry.getSfntVersion());
		System.out.println(metadataEntry.getStyle());
		System.out.println(metadataEntry.getTypographicFamily());
		System.out.println(metadataEntry.getTypographicSubfamily());
		System.out.println(metadataEntry.getWeight());
		System.out.println(metadataEntry.getWidth());

		for (OpenTypeBaseNameRecord nameRecord : metadataEntry.getNames()) {
			System.out.println(nameRecord.getNameID());
			System.out.println(nameRecord.getPlatform());
			System.out.println(nameRecord.getValue());
			if (nameRecord instanceof OpenTypeMacintoshNameRecord) {
				OpenTypeMacintoshNameRecord macintoshNameRecord = (OpenTypeMacintoshNameRecord) nameRecord;
				System.out.println(macintoshNameRecord.getEncoding());
				System.out.println(macintoshNameRecord.getLanguage());
			} else {
				if (nameRecord instanceof OpenTypeUnicodeNameRecord) {
					OpenTypeUnicodeNameRecord unicodeNameRecord = (OpenTypeUnicodeNameRecord) nameRecord;
					System.out.println(unicodeNameRecord.getEncoding());
				} else {
					if (nameRecord instanceof OpenTypeWindowsNameRecord) {
						OpenTypeWindowsNameRecord windowsNameRecord = (OpenTypeWindowsNameRecord) nameRecord;
						System.out.println(windowsNameRecord.getEncoding());
						System.out.println(windowsNameRecord.getLanguage());
					}
				}
			}
		}
	}
}
```

## Reading digital signatures

The code snippet bellow demonstrates how to extract information about digital signatures associated with an OpenType font.

1.  [Load]({{< ref "metadata/java/developer-guide/advanced-usage/loading-files/_index.md" >}}) an OpenType font file
2.  Get the root metadata package
3.  Use the [getDigitalSignaturePackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/OpenTypeRootPackage#getDigitalSignaturePackage()) method to get access to all digital signatures associated with the file

**advanced\_usage.managing\_metadata\_for\_specific\_formats.<WBR>font.OpenTypeReadDigitalSignatureProperties**

```csharp
public static void run() {
    try (Metadata metadata = new Metadata(Constants.InputTtf)) {
        OpenTypeRootPackage root = metadata.getRootPackageGeneric();

        if (root.getDigitalSignaturePackage() != null) {
            System.out.println(root.getDigitalSignaturePackage().getFlags());
            for (Cms signature : root.getDigitalSignaturePackage().getSignatures()) {
                System.out.println(signature.getSignTime());

                if (signature.getDigestAlgorithms() != null) {
                    for (Oid signatureDigestAlgorithm : signature.getDigestAlgorithms()) {
                        printOid(signatureDigestAlgorithm);
                    }
                }

                if (signature.getEncapsulatedContent() != null) {
                    printOid(signature.getEncapsulatedContent().getContentType());
                    System.out.println(signature.getEncapsulatedContent().getContentRawData().length);
                }

                if (signature.getCertificates() != null) {
                    for (CmsCertificate certificate : signature.getCertificates()) {
                        System.out.println(certificate.getNotAfter());
                        System.out.println(certificate.getNotBefore());
                        System.out.println(certificate.getRawData().length);
                    }
                }

                if (signature.getSigners() != null) {
                    for (CmsSigner signerInfoEntry : signature.getSigners()) {
                        System.out.println(signerInfoEntry.getSignatureValue());
                        printOid(signerInfoEntry.getDigestAlgorithm());
                        printOid(signerInfoEntry.getSignatureAlgorithm());
                        System.out.println(signerInfoEntry.getSigningTime());
                        printAttributes(signerInfoEntry.getSignedAttributes());
                        printAttributes(signerInfoEntry.getUnsignedAttributes());
                    }
                }
            }
        }
    }
}

private static void printOid(Oid oid) {
    // Display the property name and value of OID
    if (oid != null) {
        System.out.println(oid.getFriendlyName());
        System.out.println(oid.getValue());
    }
}

private static void printAttributes(CmsAttribute[] attributes) {
    //Display the CmsAttributes of an OID
    if (attributes != null) {
        for (CmsAttribute attribute : attributes) {
            printOid(attribute.getOid());
            System.out.println(attribute.getValue());
        }
    }
}
```

## More resources

### GitHub examples

You may easily run the code above and see the feature in action in our GitHub examples:

*   [GroupDocs.Metadata for .NET examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-.NET)
    
*   [GroupDocs.Metadata for Java examples](https://github.com/groupdocs-metadata/GroupDocs.Metadata-for-Java)
    

### Free online document metadata management App

Along with full featured Java library we provide simple, but powerful free Apps.

You are welcome to view and edit metadata of PDF, DOC, DOCX, PPT, PPTX, XLS, XLSX, emails, images and more with our free online [Free Online Document Metadata Viewing and Editing App](https://products.groupdocs.app/metadata).
