// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.MetadataProperty;
import com.groupdocs.metadata.core.MetadataPropertyType;
import com.groupdocs.metadata.core.PropertyValue;
import com.groupdocs.metadata.examples.Constants;
import com.groupdocs.metadata.search.ContainsTagSpecification;
import com.groupdocs.metadata.search.OfTypeSpecification;
import com.groupdocs.metadata.search.Specification;
import com.groupdocs.metadata.tagging.Tags;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * This example demonstrates how to update existing metadata properties by various criteria regardless of the file format.
 */
public class UpdatingMetadata {
    public static void run() {
        Date threeDaysAgo = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(3));

        File folder = new File(Constants.InputPath);
        for (File file : folder.listFiles((dir, name) -> !name.toLowerCase().endsWith(".json"))) {
            try (Metadata metadata = new Metadata(file.getAbsolutePath())) {
                if (metadata.getFileFormat() != FileFormat.Unknown && !metadata.getDocumentInfo().isEncrypted()) {
                    System.out.println();
                    System.out.println(file.getName());

                    // Update the file creation date/time if the existing value is older than 3 days
                    int affected = metadata.updateProperties(new ContainsTagSpecification(Tags.getTime().getCreated()).and(
                            new OfTypeSpecification(MetadataPropertyType.DateTime)).and(
                            new UpdatingMetadata().new DateBeforeSpecification(threeDaysAgo)), new PropertyValue(new Date()));

                    System.out.println(String.format("Affected properties: %s", affected));

                    metadata.save(Constants.OutputPath + "output." + FilenameUtils.getExtension(file.getName()));
                }
            }
        }
    }

    // Define your own specifications to filter metadata properties
    public class DateBeforeSpecification extends Specification {
        public DateBeforeSpecification(Date date) {
            setValue(date);
        }

        public final Date getValue() {
            return auto_Value;
        }

        private void setValue(Date value) {
            auto_Value = value;
        }

        private Date auto_Value;

        public boolean isSatisfiedBy(MetadataProperty candidate) {
            Date date = candidate.getValue().toClass(Date.class);
            if (date != null) {
                return date.before(getValue());
            }
            return false;
        }
    }
}
