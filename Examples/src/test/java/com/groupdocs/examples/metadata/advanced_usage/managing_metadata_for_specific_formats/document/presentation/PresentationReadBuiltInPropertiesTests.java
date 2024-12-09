package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.presentation;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.PresentationRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class PresentationReadBuiltInPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        PresentationRootPackage result = PresentationReadBuiltInProperties.run(SampleFiles.INPUT_PPT);
        Assertions.assertThat(result).isNotNull();
    }
}