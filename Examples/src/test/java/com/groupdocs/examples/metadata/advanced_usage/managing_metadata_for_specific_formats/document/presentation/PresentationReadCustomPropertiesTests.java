package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class PresentationReadCustomPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        IReadOnlyList<MetadataProperty> result = PresentationReadCustomProperties.run(SampleFiles.INPUT_PPTX);
        Assertions.assertThat(result).isNotNull();
    }
}