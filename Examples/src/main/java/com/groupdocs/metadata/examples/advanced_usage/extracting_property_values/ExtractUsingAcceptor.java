// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2020 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.extracting_property_values;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.AnySpecification;

import java.util.Date;
import java.util.UUID;

/**
 * This code snippet demonstrates how to extract the property value using a custom acceptor.
 */
public class ExtractUsingAcceptor {

    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputDocx)) {
            // Fetch all metadata properties
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new AnySpecification());

            ValueAcceptor valueAcceptor = new ExtractUsingAcceptor().new CustomValueAcceptor();
            for (MetadataProperty property : properties) {
                // Extract the property value using a custom acceptor
                property.getValue().acceptValue(valueAcceptor);
            }
        }
    }

    private class CustomValueAcceptor extends ValueAcceptor {
        protected void acceptNull() {
            System.out.println("Null value extracted");
        }

        protected void accept(String value) {
            System.out.println(String.format("String value extracted: %s", value));
        }

        protected void accept(boolean value) {
            System.out.println(String.format("Boolean value extracted: %s", value));
        }

        protected void accept(Date value) {
            System.out.println(String.format("DateTime value extracted: %s", value));
        }

        protected void accept(int value) {
            System.out.println(String.format("Integer value extracted: %s", value));
        }

        protected void accept(long value) {
            System.out.println(String.format("Long value extracted: %s", value));
        }

        protected void accept(double value) {
            System.out.println(String.format("Double value extracted: %s", value));
        }

        protected void accept(String[] value) {
            System.out.println(String.format("String array extracted: %s", (Object) value));
        }

        protected void accept(byte[] value) {
            System.out.println(String.format("Byte array extracted: %s", value));
        }

        protected void accept(double[] value) {
            System.out.println(String.format("Double array extracted: %s", value));
        }

        protected void accept(int[] value) {
            System.out.println(String.format("Integer array extracted: %s", value));
        }

        protected void accept(long[] value) {
            System.out.println(String.format("Long array extracted: %s", value));
        }

        protected void accept(MetadataPackage value) {
            System.out.println(String.format("Metadata package value extracted: %s", value));
        }

        protected void accept(MetadataPackage[] value) {
            System.out.println(String.format("Metadata package array extracted: %s", (Object) value));
        }

        protected void accept(UUID value) {
            System.out.println(String.format("Guid value extracted: %s", value));
        }

        protected void accept(PropertyValue[] value) {
            System.out.println(String.format("Property value array extracted: %s", (Object) value));
        }
    }
}

