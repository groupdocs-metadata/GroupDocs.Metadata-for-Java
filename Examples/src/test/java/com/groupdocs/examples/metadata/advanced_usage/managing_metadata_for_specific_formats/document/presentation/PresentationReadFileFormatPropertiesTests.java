package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.PresentationRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class PresentationReadFileFormatPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        PresentationRootPackage result = PresentationReadFileFormatProperties.run(SampleFiles.INPUT_PPTX);
        Assertions.assertThat(result).isNotNull();
    }
}