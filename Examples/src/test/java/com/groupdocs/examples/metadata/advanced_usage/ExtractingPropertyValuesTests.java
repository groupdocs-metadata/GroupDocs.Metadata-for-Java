package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class ExtractingPropertyValuesTests extends TestsSetUp {


    @Test
    void testUsingType() {
        IReadOnlyList<MetadataProperty> result = ExtractingPropertyValues.usingType(SampleFiles.INPUT_DOCX);
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    void testUsingAcceptor() {
        ExtractingPropertyValues.usingAcceptor(SampleFiles.INPUT_DOCX);
    }
}