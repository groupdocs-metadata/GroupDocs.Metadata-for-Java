package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.flv;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.FlvRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class FlvReadHeaderPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        FlvRootPackage result = FlvReadHeaderProperties.run(SampleFiles.INPUT_FLV);
        Assertions.assertThat(result).isNotNull();
    }
}