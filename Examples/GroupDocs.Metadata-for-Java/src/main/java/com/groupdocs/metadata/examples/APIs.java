package com.groupdocs.metadata.examples;

import java.util.regex.Pattern;

import com.groupdocs.metadata.*;
import com.groupdocs.metadata.examples.Utilities.Common;

public class APIs {
	public static class Document {
		public static void compareDocument(String first, String second) {
			String firstFile = Common.mapSourceFilePath(first);
			String secondFile = Common.mapSourceFilePath(second);
			// get differences
			MetadataPropertyCollection differences = ComparisonFacade.compareDocuments(firstFile, secondFile,
					ComparerSearchType.Difference);
		}

		public static void searchMetadata(String path) {
			// looking the author of the document
			MetadataPropertyCollection properties = SearchFacade.scanDocument(Common.mapSourceFilePath(path), "Author",
					SearchCondition.Matches);

			// search all properties where property name/value contains 'a'
			// character
			MetadataPropertyCollection properties2 = SearchFacade.scanDocument(Common.mapSourceFilePath(path), "co",
					SearchCondition.Contains);
		}

		public static void replaceMetadataProperties(String path) {
			// replace 'author' value
			SearchFacade.replaceInDocument(Common.mapSourceFilePath(path), "Author", "Jack London",
					SearchCondition.Matches, Common.mapDestinationFilePath(path));
			// replace all properties contained 'co' to 'some value'
			SearchFacade.replaceInDocument(Common.mapSourceFilePath(path), "co", "some value", SearchCondition.Contains,
					Common.mapDestinationFilePath(path));
		}
		 public static void DemonstrateMetadataTree()
	        {
	            //Source file path
	            String filePath = "Video/ASF/sample.asf";

	            try (FormatBase format = FormatFactory.recognizeFormat(Common.mapSourceFilePath(filePath)))
	            {

	                displayMetadataTree(format.getMetadata(), 0);
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
	}

	public static class Image {

		public static void compareExifMetadata(String first, String second) {
			String firstFile = Common.mapSourceFilePath(first);
			String secondFile = Common.mapSourceFilePath(second);
			// get differences
			TiffTag[] intersection = ComparisonFacade.compareExifTags(Common.mapSourceFilePath(firstFile), Common.mapDestinationFilePath(secondFile), ComparerSearchType.Intersection);
			for (TiffTag tag : intersection)
			{
				System.out.println(tag.getName());
				System.out.println(tag.getTagType());
				System.out.println(tag.getFormattedValue());
			}
		}

		public static void searchMetadata(String path) {
			TiffTag[] resolutionTags = SearchFacade.scanExifTags(Common.mapSourceFilePath(path), Pattern.compile("^(XResolution|YResolution)$"));
  
			for (TiffTag resolutionTag : resolutionTags)
			{
				System.out.println(resolutionTag.getName() + " = " +  ((TiffRationalTag)resolutionTag).getTagValue()[0].getValue());
			}
		}
	}
}
