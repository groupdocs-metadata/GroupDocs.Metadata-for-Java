---
id: groupdocs-metadata-for-java-21-5-release-notes
url: metadata/java/groupdocs-metadata-for-java-21-5-release-notes
title: GroupDocs.Metadata for Java 21.5 Release Notes
weight: 9
description: ""
keywords: 
productName: GroupDocs.Metadata for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Metadata for Java 21.5{{< /alert >}}

## Major Features

  
There are the following features, enhancements and fixes in this release:

*   Implement the ability to edit EPUB properties
*   Implement the ability to edit DublinCore metadata properties in EPUB
*	Implement the ability to edit DXF metadata properties
*	Reduce the amount of resources consumed by EPUB rendering process

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| METADATANET-3780 | Implement the ability to edit EPUB properties                                                | Improvement         |
| METADATANET-3800 | Implement the ability to edit DublinCore metadata properties in EPUB                         | Improvement         |
| METADATANET-3801 | Implement the ability to edit DXF metadata properties                              	      | Improvement         |
| METADATANET-3803 | Reduce the amount of resources consumed by EPUB rendering process                            | Bug                 |



## Public API and Backward Incompatible Changes

### Implement the ability to edit EPUB properties

This improvement allows the user to update and remove EPUB metadata properties.

##### Public API changes

The [getAbstract](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getAbstract()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getAccessRights](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getAccessRights()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getAccrualMethod](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getAccrualMethod()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getAccrualPeriodicity](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getAccrualPeriodicity()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getAccrualPolicy](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getAccrualPolicy()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getAlternative](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getAlternative()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getAudience](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getAudience()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getAvailable](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getAvailable()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getBibliographicCitation](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getBibliographicCitation()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getConformsTo](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getConformsTo()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getContributor](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getContributor()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getCoverage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getCoverage()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getCreated](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getCreated()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getCreator](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getCreator()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getDate](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getDate()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getDateAccepted](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getDateAccepted()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getDateCopyrighted](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getDateCopyrighted()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getDateSubmitted](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getDateSubmitted()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getDescription](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getDescription()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getEducationLevel](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getEducationLevel()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getExtent](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getExtent()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getFormat](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getFormat()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [hasFormat](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#hasFormat()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [hasPart](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#hasPart()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [hasVersion](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#hasVersion()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getIdentifier](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getIdentifier()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getInstructionalMethod](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getInstructionalMethod()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getIsFormatOf](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getIsFormatOf()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getIsPartOf](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getIsPartOf()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getIsReferencedBy](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getIsReferencedBy()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getIsReplacedBy](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getIsReplacedBy()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getIsRequiredBy](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getIsRequiredBy()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getIssued](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getIssued()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getIsVersionOf](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getIsVersionOf()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getLanguage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getLanguage()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getLicense](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getLicense()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getMediator](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getMediator()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getMedium](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getMedium()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getModified](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getModified()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getProvenance](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getProvenance()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getPublisher](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getPublisher()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getReferences](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getReferences()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getRelation](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getRelation()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getReplaces](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getReplaces()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getRequires](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getRequires()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getRights](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getRights()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getRightsHolder](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getRightsHolder()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getSource](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getSource()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getSpatial](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getSpatial()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getSubject](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getSubject()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getTableOfContents](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getTableOfContents()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getTemporal](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getTemporal()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getTitle](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getTitle()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getType](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getType()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [getValid](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#getValid()) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setAbstract](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setAbstract(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setAccessRights](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setAccessRights(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setAccrualMethod](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setAccrualMethod(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setAccrualPeriodicity](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setAccrualPeriodicity(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setAccrualPolicy](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setAccrualPolicy(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setAlternative](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setAlternative(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setAudience](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setAudience(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setAvailable](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setAvailable(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setBibliographicCitation](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setBibliographicCitation(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setConformsTo](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setConformsTo(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setContributor](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setContributor(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setCoverage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setCoverage(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setCreated](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setCreated(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setCreator](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setCreator(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setDate](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setDate(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setDateAccepted](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setDateAccepted(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setDateCopyrighted](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setDateCopyrighted(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setDateSubmitted](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setDateSubmitted(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setDescription](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setDescription(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setEducationLevel](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setEducationLevel(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setExtent](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setExtent(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setFormat](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setFormat(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setHasFormat](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setHasFormat(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setPart](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setPart(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setHasVersion](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setHasVersion(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setIdentifier](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setIdentifier(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setInstructionalMethod](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setInstructionalMethod(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setIsFormatOf](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setIsFormatOf(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setIsPartOf](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setIsPartOf(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setIsReferencedBy](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setIsReferencedBy(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setIsReplacedBy](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setIsReplacedBy(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setIsRequiredBy](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setIsRequiredBy(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setIssued](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setIssued(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setIsVersionOf](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setIsVersionOf(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setLanguage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setLanguage(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setLicense](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setLicense(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setMediator](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setMediator(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setMedium](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setMedium(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setModified](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setModified(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setProvenance](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setProvenance(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setPublisher](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setPublisher(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setReferences](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setReferences(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setRelation](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setRelation(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setReplaces](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setReplaces(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setRequires](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setRequires(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setRights](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setRights(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setRightsHolder](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setRightsHolder(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setSource](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setSource(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setSpatial](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setSpatial(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setSubject](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setSubject(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setTableOfContents](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setTableOfContents(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setTemporal](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setTemporal(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setTitle](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setTitle(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setType](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setType(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

The [setValid](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage#setValid(java.lang.String)) method has been added to the [EpubPackage](https://apireference.groupdocs.com/metadata/java/com.groupdocs.metadata.core/EpubPackage) class

##### Use cases 

Update EPUB metadata properties

```java
try (Metadata metadata = new Metadata(Constants.InputEpub)) {
    EpubRootPackage root = metadata.getRootPackageGeneric();
 
    root.getEpubPackage().setCreator("GroupDocs");
    root.getEpubPackage().setDescription("test e-book");
    root.getEpubPackage().setFormat("EPUB");
    root.getEpubPackage().setDate(new Date().toString());
 
    // ...
 
    metadata.save(Constants.OutputEpub);
}
```

### Implement the ability to edit DublinCore metadata properties in EPUB

This improvement allows the user to edit DublinCore metadata properties stored in an EPUB file.

##### Public API changes

None

##### Use cases 

Update DublinCore metadata properties stored in an EPUB file

```java
try (Metadata metadata = new Metadata(Constants.InputEpub)) {
    EpubRootPackage root = metadata.getRootPackageGeneric();
 
    root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:creator"), new PropertyValue("GroupDocs"));
    root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:description"), new PropertyValue("test e-book"));
    root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:title"), new PropertyValue("test EPUB"));
    root.getDublinCorePackage().setProperties(new WithNameSpecification("dc:date"), new PropertyValue(new Date().toString()));
 
    // ...
 
    metadata.save(Constants.OutputEpub);
}
```

### Implement the ability to edit DXF metadata properties

This improvement allows the user to edit metadata properties stored in a DXF file.

##### Public API changes

None

##### Use cases 

Update DXF metadata properties

```java
try (Metadata metadata = new Metadata(Constants.InputDxf)) {
 
    CadRootPackage root = metadata.getRootPackageGeneric();
 
    root.getCadPackage().setProperties(new WithNameSpecification("Author"), new PropertyValue("GroupDocs"));
    root.getCadPackage().setProperties(new WithNameSpecification("Comments"), new PropertyValue("test comment"));
    root.getCadPackage().setProperties(new WithNameSpecification("HyperlinkBase"), new PropertyValue("test hyperlink base"));
    root.getCadPackage().setProperties(new WithNameSpecification("Keywords"), new PropertyValue("test keywords"));
    root.getCadPackage().setProperties(new WithNameSpecification("LastSavedBy"), new PropertyValue("test editor"));
    root.getCadPackage().setProperties(new WithNameSpecification("RevisionNumber"), new PropertyValue("test revision number"));
    root.getCadPackage().setProperties(new WithNameSpecification("Subject"), new PropertyValue("test subject"));
    root.getCadPackage().setProperties(new WithNameSpecification("Title"), new PropertyValue("test title"));
    root.getCadPackage().setProperties(new WithNameSpecification("CreatedDateTime"), new PropertyValue(new Date()));
    root.getCadPackage().setProperties(new WithNameSpecification("ModifiedDateTime"), new PropertyValue(new Date()));
 
    metadata.save(Constants.OutputDxf);
}
```

