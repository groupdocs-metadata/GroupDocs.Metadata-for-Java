package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.Cms;
import com.groupdocs.metadata.CmsAttribute;
import com.groupdocs.metadata.CmsCertificate;
import com.groupdocs.metadata.CmsSignerInfo;
import com.groupdocs.metadata.FormatBase;
import com.groupdocs.metadata.FormatFactory;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.MetadataProperty;
import com.groupdocs.metadata.MetadataPropertyType;
import com.groupdocs.metadata.Oid;
import com.groupdocs.metadata.OpenTypeBaseNameRecord;
import com.groupdocs.metadata.OpenTypeFormat;
import com.groupdocs.metadata.OpenTypeMacintoshNameRecord;
import com.groupdocs.metadata.OpenTypeMetadata;
import com.groupdocs.metadata.OpenTypeUnicodeNameRecord;
import com.groupdocs.metadata.OpenTypeWindowsNameRecord;
import com.groupdocs.metadata.ZipFileInfo;
import com.groupdocs.metadata.ZipFormat;
import com.groupdocs.metadata.ZipMetadata;
import com.groupdocs.metadata.examples.Utilities.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Fonts {
	public static class OpenType {
		private static String filePath = "\\Fonts\\OpenType\\sample.otf";

		public static void readOpenTypeMetadata()
		{
			try (OpenTypeFormat format = new OpenTypeFormat(Common.mapSourceFilePath(filePath)))
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
			}
		}
		
		// Read the digital signature metadata
		public static void ReadDigitalSignatureMetadata()
		{
			try (OpenTypeFormat format = new OpenTypeFormat(Common.mapSourceFilePath(filePath)))
			{
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
		public static void DisplayMetadataTree()
        {
            try (FormatBase format = FormatFactory.recognizeFormat(Common.mapSourceFilePath(filePath)))
            {
            	metadataTree(format.getMetadata(), 0);
            }

        }
		
		private static void metadataTree(Metadata metadata, int indent)
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
		                    	metadataTree(property.getValue().toMetadata(), indent + 2);
		                        break;
		                    case MetadataPropertyType.MetadataArray:
		                    	metadataTree(property.getValue().toMetadataArray(), indent + 2);
		                        break;
		                }
		            }
		        }
		    }
		}
		 
		private static void metadataTree(Metadata[] metadataArray, int indent)
		{
		    if (metadataArray != null)
		    {
		        for (Metadata metadata : metadataArray)
		        {
		        	metadataTree(metadata, indent);
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

	}
}
