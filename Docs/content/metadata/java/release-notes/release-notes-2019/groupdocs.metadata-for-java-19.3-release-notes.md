---
id: groupdocs-metadata-for-java-19-3-release-notes
url: metadata/java/groupdocs-metadata-for-java-19-3-release-notes
title: GroupDocs.Metadata for Java 19.3 Release Notes
weight: 4
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 19.3.{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Implement the ability to parse font files.
*   Implement the ability to render image previews for supported document types.
*   Refactor the AVI, FLV, MOV, Matroska, BitTorrent, ZIP and EPUB formats according to the new concept of metadata arrangement.

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-518 | Implement the ability to parse font files | New Feature |
| METADATANET-2441 | Implement the ability to render image previews for supported document types | New Feature |
| METADATANET-2696 | Refactor the AVI, FLV, MOV, Matroska, BitTorrent, ZIP and EPUB formats according to the new concept of metadata arrangement | Enhancement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for Java 19.3. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Implement the ability to parse font files

This new feature allows a user to read metadata of **OpenType** fonts.

**Public API changes**

The *Cms* class has been added to the *com.groupdocs.metadata* package

The *CmsAttribute* class has been added to the *com.groupdocs.metadata* package

The *CmsCertificate* class has been added to the *com.groupdocs.metadata* package

The *CmsEncapsulatedContentInfo* class has been added to the *com.groupdocs.metadata* package

The *CmsSignerInfo* class has been added to the *com.groupdocs.metadata* package

The *Oid* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeBaseNameRecord* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeDigitalSignatureFlags* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeDirectionHint* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeFlags* class  has been added to the *com.groupdocs.metadata* package

The *OpenTypeFormat* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeIsoEncoding* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeLicensingRights* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeMacintoshEncoding* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeMacintoshLanguage* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeMacintoshNameRecord* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeMetadata* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeName* class has been added to the *com.groupdocs.metadata* package

The *OpenTypePlatform* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeStyle* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeUnicodeEncoding* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeUnicodeNameRecord* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeVersion* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeWeight* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeWidth* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeWindowsEncoding* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeWindowsLanguage* class has been added to the *com.groupdocs.metadata* package

The *OpenTypeWindowsNameRecord* class has been added to the *com.groupdocs.metadata* package

The *Rectangle* class has been added to the *com.groupdocs.metadata* package

The *OpenType* public static field has been added to the *MetadataType *class

The *OpenType* public static field has been added to the *DocumentType *class

##### Use cases

Read OpenType font metadata

**Java**

```csharp
public static void main(String[] args)
{    
    License license = new License();
    license.setLicense("D:\\GroupDocs.Metadata.lic");
    
    try (OpenTypeFormat format = new OpenTypeFormat("D:\\input.ttf"))
    {
        // Read the OpenType font metadata
        for (OpenTypeMetadata metadataEntry : format.getFontInfo())
        {
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
            for (OpenTypeBaseNameRecord nameRecord : metadataEntry.getNames())
            {
                System.out.println(nameRecord.getNameId());
                System.out.println(nameRecord.getPlatform());
                System.out.println(nameRecord.getValue());
                if (nameRecord instanceof OpenTypeMacintoshNameRecord)
                {
                    OpenTypeMacintoshNameRecord macintoshNameRecord = (OpenTypeMacintoshNameRecord)nameRecord;
                    System.out.println(macintoshNameRecord.getEncoding());
                    System.out.println(macintoshNameRecord.getLanguage());
                }
                else
                {
                    if (nameRecord instanceof OpenTypeUnicodeNameRecord)
                    {
                        OpenTypeUnicodeNameRecord unicodeNameRecord = (OpenTypeUnicodeNameRecord)nameRecord;
                        System.out.println(unicodeNameRecord.getEncoding());
                    }
                    else
                    {
                        if (nameRecord instanceof OpenTypeWindowsNameRecord)
                        {
                            OpenTypeWindowsNameRecord windowsNameRecord = (OpenTypeWindowsNameRecord)nameRecord;
                            System.out.println(windowsNameRecord.getEncoding());
                            System.out.println(windowsNameRecord.getLanguage());
                        }
                    }
                }
            }
        }

        // Read the digital signature metadata
        if (format.hasDigitalSignatures())
        {
            System.out.println(format.getDigitalSignatureFlags());
            for (Cms signature : format.getDigitalSignatures())
            {
                System.out.println(signature.getSignTime());
                if (signature.getDigestAlgorithms() != null)
                {
                    for (Oid signatureDigestAlgorithm : signature.getDigestAlgorithms())
                    {
                        printOid(signatureDigestAlgorithm);
                    }
                }
                if (signature.getEncapsulatedContentInfo() != null)
                {
                    printOid(signature.getEncapsulatedContentInfo().getContentType());
                    System.out.println(signature.getEncapsulatedContentInfo().getContentRawData().length);
                }
                if (signature.getCertificates() != null)
                {
                    for (CmsCertificate certificate : signature.getCertificates())
                    {
                        System.out.println(certificate.getNotAfter());
                        System.out.println(certificate.getNotBefore());
                        System.out.println(certificate.getRawData().length);
                    }
                }
                if (signature.getSignerInfoEntries() != null)
                {
                    for (CmsSignerInfo signerInfoEntry : signature.getSignerInfoEntries())
                    {
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

private static void printOid(Oid oid)
{
    if (oid != null)
    {
        System.out.println(oid.getFriendlyName());
        System.out.println(oid.getValue());
    }
}

private static void printAttributes(CmsAttribute[] attributes)
{
    if (attributes != null)
    {
        for (CmsAttribute attribute : attributes)
        {
            printOid(attribute.getOid());
            System.out.println(attribute.getValue());
        }
    }
}
```

{{< alert style="info" >}}This format supports hierarchical metadata arrangement{{< /alert >}}

Read the whole metadata tree in the unified way

**Java**

```csharp
public static void main(String[] args)
{    
    License license = new License();
    license.setLicense("D:\\GroupDocs.Metadata.lic");
            
    try (FormatBase format = FormatFactory.recognizeFormat("D:\\input.ttf"))
    {
        displayMetadataTree(format.getMetadata(), 1);
    }
}

private static void displayMetadataTree(Metadata metadata, int indent)
{
    if (metadata != null)
    {
        String stringMetadataType = String.valueOf(metadata.getMetadataType());
        System.out.printf("%" + (stringMetadataType.length() + indent) + "s%n", stringMetadataType);
        for (MetadataProperty property : metadata)
        {
            String stringPropertyRepresentation = "Name: " + property.getName() + ", Value: " + property.getFormattedValue();
            System.out.printf("%" + (stringPropertyRepresentation.length() + indent + 1) + "s%n", stringPropertyRepresentation);
            if (property.getValue() != null)
            {
                switch (property.getValue().getType())
                {
                    case MetadataPropertyType.Metadata:
                        displayMetadataTree(property.getValue().toMetadata(), indent + 2);
                        break;
                    case MetadataPropertyType.MetadataArray:
                        displayMetadataTree(property.getValue().toMetadataArray(), indent + 2);
                        break;
                }
            }
        }
    }
}

private static void displayMetadataTree(Metadata[] metadataArray, int indent)
{
    if (metadataArray != null)
    {
        for (Metadata metadata : metadataArray)
        {
            displayMetadataTree(metadata, indent);
        }
    }
}
```

###   
Implement the ability to render image previews for supported document types

This new feature allows a user to render image previews for documents of some popular formats supported by GroupDocs.Metadata. It can be used for creating demo applications.

**Public API Changes**

The *PreviewFactory *class has been added to the *com.groupdocs.metadata *package

The *PreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *PreviewImageData *class has been added to the *com.groupdocs.metadata *package

The *PreviewInvalidPasswordException *class has been added to the *com.groupdocs.metadata *package

The *PreviewNotSupportedException *class has been added to the *com.groupdocs.metadata *package

The *PreviewPage *class has been added to the *com.groupdocs.metadata *package

The *PreviewUnitOfMeasurement *class has been added to the *com.groupdocs.metadata *package

The *ProtectableDocumentPreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *CellsPreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *DiagramPreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *DjvuImagePreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *GifImagePreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *ImagePreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *NotesPreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *PdfPreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *SlidesPreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *TiffImagePreviewHandler *class has been added to the *com.groupdocs.metadata *package

The *WordsPreviewHandler *class has been added to the *com.groupdocs.metadata *package

##### Use cases

Create preview images for all document pages.

**Java**

```csharp
try (PreviewHandler handler = PreviewFactory.load("D:\\input.docx"))
{
    for (int i = 0; i < handler.getPages().length; i++)
    {
        PreviewImageData[] pagePreviews = handler.getPageImage(i);
        for (int j = 0; j < pagePreviews.length; j++)
        {
            try (FileOutputStream stream = new FileOutputStream("D:\\preview\\" + i + "-" + j + ".png")) 
            {
                pagePreviews[j].writeTo(stream);
            }
        }
    }
}
```

### Refactor the AVI, FLV, MOV, Matroska, BitTorrent, ZIP and EPUB formats according to the new concept of metadata arrangement

The following formats now support hierarchical metadata arrangement: AVI, FLV, MOV, Matroska, BitTorrent, ZIP, EPUB.

##### Use case:

Read the whole metadata tree in the unified way (regardless of the format).

**Java**

```csharp
public static void main(String[] args)
{
    License license = new License();
    license.setLicense("D:\\GroupDocs.Metadata.lic");
     
    try (FormatBase format = FormatFactory.recognizeFormat("D:\\input.torrent"))
    {
        displayMetadataTree(format.getMetadata(), 1);
    }
}

private static void displayMetadataTree(Metadata metadata, int indent)
{
    if (metadata != null)
    {
        String stringMetadataType = String.valueOf(metadata.getMetadataType());
        System.out.printf("%" + (stringMetadataType.length() + indent) + "s%n", stringMetadataType);
        for (MetadataProperty property : metadata)
        {
            String stringPropertyRepresentation = "Name: " + property.getName() + ", Value: " + property.getFormattedValue();
            System.out.printf("%" + (stringPropertyRepresentation.length() + indent + 1) + "s%n", stringPropertyRepresentation);
            if (property.getValue() != null)
            {
                switch (property.getValue().getType())
                {
                    case MetadataPropertyType.Metadata:
                        displayMetadataTree(property.getValue().toMetadata(), indent + 2);
                        break;
                    case MetadataPropertyType.MetadataArray:
                        displayMetadataTree(property.getValue().toMetadataArray(), indent + 2);
                        break;
                }
            }
        }
    }
}

private static void displayMetadataTree(Metadata[] metadataArray, int indent)
{
    if (metadataArray != null)
    {
        for (Metadata metadata : metadataArray)
        {
            displayMetadataTree(metadata, indent);
        }
    }
}
```
