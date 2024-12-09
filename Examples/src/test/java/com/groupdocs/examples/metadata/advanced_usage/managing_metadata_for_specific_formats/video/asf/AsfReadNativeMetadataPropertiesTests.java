package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.asf;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.AsfRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class AsfReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        AsfRootPackage result = AsfReadNativeMetadataProperties.run(SampleFiles.INPUT_ASF);
        Assertions.assertThat(result).isNotNull();
    }
}