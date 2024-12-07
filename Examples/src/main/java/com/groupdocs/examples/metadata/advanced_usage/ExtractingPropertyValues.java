package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.search.AnySpecification;

import java.nio.file.Path;
import java.util.*;

public class ExtractingPropertyValues {

    public static IReadOnlyList<MetadataProperty> usingType(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            // Fetch all metadata properties from the file
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new AnySpecification());
            for (MetadataProperty property : properties) {
                // Process String and DateTime properties only
                if (property.getValue().getType() == MetadataPropertyType.String) {
                    System.out.printf("\tFile: '%s', Property: '%s', Value: '%s'%n", inputFile.getFileName(), property.getName(), property.getValue().toClass(String.class));
                } else if (property.getValue().getType() == MetadataPropertyType.DateTime) {
                    System.out.printf("\tFile: '%s', Property: '%s', Value: '%s'%n", inputFile.getFileName(), property.getName(), property.getValue().toClass(Date.class));
                }
            }
            return properties;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        System.out.println("..sample finished successfully.");
        return null;
    }

    public static void usingAcceptor(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            // Fetch all metadata properties
            IReadOnlyList<MetadataProperty> properties = metadata.findProperties(new AnySpecification());
            ValueAcceptor valueAcceptor = new CustomValueAcceptor();
            for (MetadataProperty property : properties) {
                // Extract the property value using a custom acceptor
                property.getValue().acceptValue(valueAcceptor);
            }
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        System.out.println("..sample finished successfully.");
    }

    static class CustomValueAcceptor extends ValueAcceptor {
        protected void acceptNull() {
            System.out.println("\tNull value extracted");
        }

        protected void accept(String value) {
            System.out.printf("\tString value extracted: %s%n", value);
        }

        protected void accept(boolean value) {
            System.out.printf("\tBoolean value extracted: %s%n", value);
        }

        protected void accept(Date value) {
            System.out.printf("\tDateTime value extracted: %s%n", value);
        }

        protected void accept(int value) {
            System.out.printf("\tInteger value extracted: %s%n", value);
        }

        protected void accept(long value) {
            System.out.printf("\tLong value extracted: %s%n", value);
        }

        protected void accept(double value) {
            System.out.printf("\tDouble value extracted: %s%n", value);
        }

        protected void accept(String[] value) {
            System.out.printf("\tString array extracted: %s%n", (Object) value);
        }

        protected void accept(byte[] value) {
            System.out.printf("\tByte array extracted: %s%n", Arrays.toString(value));
        }

        protected void accept(double[] value) {
            System.out.printf("\tDouble array extracted: %s%n", Arrays.toString(value));
        }

        protected void accept(int[] value) {
            System.out.printf("\tInteger array extracted: %s%n", Arrays.toString(value));
        }

        protected void accept(long[] value) {
            System.out.printf("\tLong array extracted: %s%n", Arrays.toString(value));
        }

        protected void accept(MetadataPackage value) {
            System.out.printf("\tMetadata package value extracted: %s%n", value);
        }

        protected void accept(MetadataPackage[] value) {
            System.out.printf("\tMetadata package array extracted: %s%n", Arrays.toString(value));
        }

        protected void accept(UUID value) {
            System.out.printf("\tGuid value extracted: %s%n", value);
        }

        protected void accept(PropertyValue[] value) {
            System.out.printf("\tProperty value array extracted: %s%n", Arrays.toString(value));
        }
    }
}
