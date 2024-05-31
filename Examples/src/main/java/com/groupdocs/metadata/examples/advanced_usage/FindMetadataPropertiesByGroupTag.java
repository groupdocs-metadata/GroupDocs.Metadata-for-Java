package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.search.FallsIntoCategorySpecification;
import com.groupdocs.metadata.tagging.Tags;

/**
* This example demonstrates how to search for specific metadata properties using tags.
*/
public class FindMetadataPropertiesByGroupTag
{
    public static void run()
    {
        System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.println("[Example Advanced Usage] # FindMetadataPropertiesByGroupTag : How to search for specific metadata properties using tags.\n");
        Metadata metadata = new Metadata(Constants.InputVsdx);
        {
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new FallsIntoCategorySpecification(Tags.getPerson()));
            for (MetadataProperty property : properties)
            {
                System.out.println("Property name: "+property.getName()+", Property value: "+ property.getValue());
            }
        }
    }
}
