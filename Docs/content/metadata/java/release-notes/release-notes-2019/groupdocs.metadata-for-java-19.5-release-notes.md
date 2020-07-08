---
id: groupdocs-metadata-for-java-19-5-release-notes
url: metadata/java/groupdocs-metadata-for-java-19-5-release-notes
title: GroupDocs.Metadata for Java 19.5 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 19.5{{< /alert >}}

## Major Features

There are the following features and enhancements in this release:

*   Add support for the vCard format
*   Add support for the pps, ppsx and ppsm PowerPoint formats
*   Implement the ability to get the metered credit consumption statistic

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-1177 | Add support for the vCard format | New Feature |
| METADATANET-2833 | Add support for the pps, ppsx and ppsm PowerPoint formats | Enhancement |
| METADATANET-2918 | Implement the ability to get the metered credit consumption statistic | Enhancement |

  

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Metadata for .NET 19.5. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Metadata which may affect existing code. Any behavior introduced that could be seen as regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

### Add support for the vCard format

This new feature allows a user to work with vCard files

**Public API Changes**

The *VCard* public static field has been added to the *DocumentType* class

The *VCardAgentRecordMetadata* class has been added to the *com.groupdocs.metadata* package

The *getContentType* method has been added to the *VCardAgentRecordMetadata* class

The *getValue* method has been added to the *VCardAgentRecordMetadata* class

The *VCardBaseMetadata* class has been added to the *com.groupdocs.metadata* package

The *VCardBinaryRecordMetadata* class has been added to the *com.groupdocs.metadata* package

The *getContentType* method has been added to the *VCardBinaryRecordMetadata* class

The *getValue* method has been added to the *VCardBinaryRecordMetadata* class

The *VCardCalendarRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *getBusyTimeRecords* method has been added to the *VCardCalendarRecordsetMetadata* class

The *getBusyTimeEntries* method has been added to the *VCardCalendarRecordsetMetadata* class

The *getCalendarAddressRecords* method has been added to the *VCardCalendarRecordsetMetadata* class

The *getCalendarAddresses* method has been added to the *VCardCalendarRecordsetMetadata* class

The *getCalendarUriRecords* method has been added to the *VCardCalendarRecordsetMetadata* class

The *getUriCalendarEntries* method has been added to the *VCardCalendarRecordsetMetadata* class

The *VCardCommunicationRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *getTelephoneRecords* method has been added to the *VCardCommunicationRecordsetMetadata* class

The *getTelephones* method has been added to the *VCardCommunicationRecordsetMetadata* class

The *getEmailRecords* method has been added to the *VCardCommunicationRecordsetMetadata* class

The *getEmails* method has been added to the *VCardCommunicationRecordsetMetadata* class

The *getMailer* method has been added to the *VCardCommunicationRecordsetMetadata* class

The *getImppRecords* method has been added to the *VCardCommunicationRecordsetMetadata* class

The *getImppEntries* method has been added to the *VCardCommunicationRecordsetMetadata* class

The *getLanguageRecords* method has been added to the *VCardCommunicationRecordsetMetadata* class

The *getLanguages* method has been added to the *VCardCommunicationRecordsetMetadata* class

The *VCardContentType* class has been added to the *com.groupdocs.metadata* package

The *Custom* public static field has been added to the *VCardContentType* class

The *Text* public static field has been added to the *VCardContentType* class

The *Binary* public static field has been added to the *VCardContentType* class

The *DateTime* public static field has been added to the *VCardContentType* class

The *Agent* public static field has been added to the *VCardContentType* class

The *VCardCustomRecordMetadata* class has been added to the *com.groupdocs.metadata* package

The *getContentType* method has been added to the *VCardCustomRecordMetadata* class

The *getValue* method has been added to the *VCardCustomRecordMetadata* class

The *VCardDateTimeRecordMetadata* class has been added to the *com.groupdocs.metadata* package

The *getContentType* method has been added to the *VCardDateTimeRecordMetadata* class

The *getValue* method has been added to the *VCardDateTimeRecordMetadata* class

The *VCardDeliveryAddressingRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *getAddressRecords* method has been added to the *VCardDeliveryAddressingRecordsetMetadata* class

The *getAddresses* method has been added to the *VCardDeliveryAddressingRecordsetMetadata* class

The *getLabelRecords* method has been added to the *VCardDeliveryAddressingRecordsetMetadata* class

The *getLabels* method has been added to the *VCardDeliveryAddressingRecordsetMetadata* class

The *VCardExplanatoryRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *getCategoryRecords* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getCategories* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getNoteRecords* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getNotes* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getProductIdentifierRecord* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getProductIdentifier* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getRevision* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getSortString* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getSoundRecords* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getSoundBinaryRecords* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getBinarySounds* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getSoundUriRecords* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getUriSounds* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getUidRecord* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getUid* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getPidIdentifierRecords* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getPidIdentifiers* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getUrlRecords* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getUrls* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *getVersion* method has been added to the *VCardExplanatoryRecordsetMetadata* class

The *VCardFormat* class has been added to the *com.groupdocs.metadata* package

The *VCardFormat(String)* constructor has been added to the *VCardFormat* class

The *VCardFormat(InputStream)* constructor has been added to the *VCardFormat* class

The *getVCardInfo* method has been added to the *VCardFormat* class

The *VCardGeneralRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *getSourceRecords* method has been added to the *VCardGeneralRecordsetMetadata* class

The *getSources* method has been added to the *VCardGeneralRecordsetMetadata* class

The *getNameOfSource* method has been added to the *VCardGeneralRecordsetMetadata* class

The *getKind* method has been added to the *VCardGeneralRecordsetMetadata* class

The *getXmlRecords* method has been added to the *VCardGeneralRecordsetMetadata* class

The *getXmlEntries* method has been added to the *VCardGeneralRecordsetMetadata* class

The *VCardGeographicalRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *getTimeZoneRecords* method has been added to the *VCardGeographicalRecordsetMetadata* class

The *getTimeZones* method has been added to the *VCardGeographicalRecordsetMetadata* class

The *getGeographicPositionRecords* method has been added to the *VCardGeographicalRecordsetMetadata* class

The *getGeographicPositions* method has been added to the *VCardGeographicalRecordsetMetadata* class

The *VCardIdentificationRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *getFormattedNameRecords* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getFormattedNames* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getNameRecord* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getName* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getNicknameRecords* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getNicknames* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getPhotoRecords* method has been added to the *VCardIdentificationRecordsetMetadata* class

The getPhotoBinaryRecords method has been added to the VCardIdentificationRecordsetMetadata class

The *getBinaryPhotos* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getPhotoUriRecords* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getUriPhotos* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getBirthdateRecords* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getBirthdateDateTimeRecord* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getDateTimeBirthdate* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getBirthdateTextRecords* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getTextBirthdates* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getAnniversaryRecord* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getAnniversaryDateTimeRecord* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getDateTimeAnniversary* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getAnniversaryTextRecord* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getTextAnniversary* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getGenderRecord* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *getGender* method has been added to the *VCardIdentificationRecordsetMetadata* class

The *VCardMetadata* class has been added to the *com.groupdocs.metadata* package

The *getGeneralRecordset* method has been added to the *VCardMetadata* class

The *getIdentificationRecordset* method has been added to the *VCardMetadata* class

The *getDeliveryAddressingRecordset* method has been added to the *VCardMetadata* class

The *getCommunicationRecordset* method has been added to the *VCardMetadata* class

The *getGeographicalRecordset* method has been added to the *VCardMetadata* class

The *getOrganizationalRecordset* method has been added to the *VCardMetadata* class

The *getExplanatoryRecordset* method has been added to the *VCardMetadata* class

The *getSecurityRecordset* method has been added to the *VCardMetadata* class

The *getCalendarRecordset* method has been added to the *VCardMetadata* class

The *getExtensionRecords* method has been added to the *VCardMetadata* class

The *getAvailableGroups* method has been added to the *VCardMetadata* class

The *filterByGroup(String)* method has been added to the *VCardMetadata* class

The *filterHomeTags* method has been added to the *VCardMetadata* class

The *filterWorkTags* method has been added to the *VCardMetadata* class

The *filterPreferred* method has been added to the *VCardMetadata* class

The *VCardOrganizationalRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *getTitleRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getTitles* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getRoleRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getRoles* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getLogoRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getLogoBinaryRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getBinaryLogos* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getLogoUriRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getUriLogos* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getAgentRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getAgentObjectRecord* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getObjectAgent* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getAgentUriRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getUriAgents* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getOrganizationNameRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getOrganizationNames* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getMemberRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getMembers* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getRelationshipRecords* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *getRelationships* method has been added to the *VCardOrganizationalRecordsetMetadata* class

The *VCardRecordMetadata* class has been added to the *com.groupdocs.metadata* package

The *getGroup* method has been added to the *VCardRecordMetadata* class

The *getValueParameters* method has been added to the *VCardRecordMetadata* class

The *getPrefParameter* method has been added to the *VCardRecordMetadata* class

The *getAltIdParameter* method has been added to the *VCardRecordMetadata* class

The *getTypeParameters* method has been added to the *VCardRecordMetadata* class

The *getEncodingParameter* method has been added to the *VCardRecordMetadata* class

The *getLanguageParameter* method has been added to the *VCardRecordMetadata* class

The *getAnonymParameters* method has been added to the *VCardRecordMetadata* class

The *getContentType* method has been added to the *VCardRecordMetadata* class

The *VCardRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *VCardSecurityRecordsetMetadata* class has been added to the *com.groupdocs.metadata* package

The *getAccessClassification* method has been added to the *VCardSecurityRecordsetMetadata* class

The *getPublicKeyRecords* method has been added to the *VCardSecurityRecordsetMetadata* class

The *getPublicKeyBinaryRecords* method has been added to the *VCardSecurityRecordsetMetadata* class

The *getBinaryPublicKeys* method has been added to the *VCardSecurityRecordsetMetadata* class

The *getPublicKeyUriRecords* method has been added to the *VCardSecurityRecordsetMetadata* class

The *getUriPublicKeys* method has been added to the *VCardSecurityRecordsetMetadata* class

The *VCardTextRecordMetadata* class has been added to the *com.groupdocs.metadata* package

The *getContentType* method has been added to the *VCardTextRecordMetadata* class

The *getMediaTypeParameter* method has been added to the *VCardTextRecordMetadata* class

The *getCharsetParameter* method has been added to the *VCardTextRecordMetadata* class

The *getValue* method has been added to the *VCardTextRecordMetadata* class

The *isQuotedPrintable* method has been added to the *VCardTextRecordMetadata* class

The *getReadabilityValue(String)* method has been added to the *VCardTextRecordMetadata* class

The *VCard* public static field has been added to the *MetadataType* class

##### Use cases

Read vCard properties using simplified APIs

**Java**

```csharp
public static void main(String[] args)
{    
	License license = new License();
	license.setLicense("D:\\GroupDocs.Metadata.lic");
	 
	try (VCardFormat format = new VCardFormat("D:\\input.vcf"))
	{
		for (VCardMetadata vCard : format.getVCardInfo())
		{
			System.out.println(vCard.getIdentificationRecordset().getName());
			printArray(vCard.getIdentificationRecordset().getFormattedNames());
			printArray(vCard.getCommunicationRecordset().getEmails());
			printArray(vCard.getCommunicationRecordset().getTelephones());
		}
	}
}

private static void printArray(String[] values)
{
	if (values != null)
	{
		for (String value : values)
		{
			System.out.println(value);
		}
	}
}
```

Read vCard properties along with descriptive parameters

**Java**

```csharp
try (VCardFormat format = new VCardFormat("D:\\input.vcf"))
{
	for (VCardMetadata vCard : format.getVCardInfo())
	{
		if (vCard.getIdentificationRecordset().getPhotoUriRecords() != null)
		{
			// Iterate all photos represented by URIs
			for (VCardTextRecordMetadata photoUriRecord : vCard.getIdentificationRecordset().getPhotoUriRecords())
			{
				// Print the property value
				System.out.println(photoUriRecord.getValue());

				// Print some additional parameters of the property
				System.out.println(photoUriRecord.getContentType());
				System.out.println(photoUriRecord.getMediaTypeParameter());
				if (photoUriRecord.getTypeParameters() != null)
				{
					for (String parameter : photoUriRecord.getTypeParameters())
					{
						System.out.println(parameter);
					}
				}
				System.out.println(photoUriRecord.getPrefParameter());
			}
		}
	}
} 
```

Filter vCard properties

**Java**

```csharp
public static void main(String[] args)
{    
	License license = new License();
	license.setLicense("D:\\GroupDocs.Metadata.lic");

	try (VCardFormat format = new VCardFormat("D:\\input.vcf"))
	{
		for (VCardMetadata vCard : format.getVCardInfo())
		{
			// Print most preferred work phone numbers and work emails
			VCardMetadata filtered = vCard.filterWorkTags().filterPreferred();
			printArray(filtered.getCommunicationRecordset().getTelephones());
			printArray(filtered.getCommunicationRecordset().getEmails());
		}
	}
}

private static void printArray(String[] values)
{
	if (values != null)
	{
		for (String value : values)
		{
			System.out.println(value);
		}
	}
} 
```

### Add support for the pps, ppsx and ppsm PowerPoint formats

This enhancement allows a user to work with pps, ppsx and ppsm files

**Public API changes**

The *Pps* public static field has been added to the *FileType* class

The *Ppsx* public static field has been added to the *FileType* class

The *Ppsm* public static field has been added to the *FileType* class

##### Use cases

Read or write pps, ppsx and ppsm files using the *PptFormat* class

**Java**

```csharp
try (PptFormat format = new PptFormat("D:\\input.pps"))
{
	// Read the file type
	System.out.println(format.getFileType());

	// Work with the loaded file as you normally do with all other presentations

	// Save all changes
	format.save("D:\\output.pps");
} 
```

### Implement the ability to get the metered credit consumption statistic

This enhancement allows a user to check metered credit consumption

##### Public API changes

The g*etConsumptionCredit* method has been added to the *Metered* class

##### Use cases

Check the amount of spent credits

**Java**

```csharp
// Apply your metered license
Metered metered = new Metered();
metered.setMeteredKey("PublicKey", "PrivateKey");

// Load a file
try (FormatBase format = FormatFactory.recognizeFormat("D:\\input.doc"))
{
	// Use library features
	Metadata[] metadata = format.getMetadata();

	// Check credit consumption
	double credits = Metered.getConsumptionCredit();

	// ...
}
```
