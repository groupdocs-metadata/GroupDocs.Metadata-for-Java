package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.avi;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.AviRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class AviReadHeaderPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        AviRootPackage result = AviReadHeaderProperties.run(SampleFiles.INPUT_AVI);
        Assertions.assertThat(result).isNotNull();
    }
}