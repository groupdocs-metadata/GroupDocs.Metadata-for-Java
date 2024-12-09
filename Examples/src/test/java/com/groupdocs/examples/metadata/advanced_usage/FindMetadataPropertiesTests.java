package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class FindMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testByTag() {
        IReadOnlyList<MetadataProperty> result = FindMetadataProperties.byTag(SampleFiles.INPUT_PPTX);
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    void testByTagGroup() {
        IReadOnlyList<MetadataProperty> result = FindMetadataProperties.byTagGroup(SampleFiles.INPUT_VSDX);
        Assertions.assertThat(result).isNotNull();
    }
}