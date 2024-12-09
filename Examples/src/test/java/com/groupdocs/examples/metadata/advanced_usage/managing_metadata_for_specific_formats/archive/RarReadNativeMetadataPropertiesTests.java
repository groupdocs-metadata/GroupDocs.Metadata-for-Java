package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.RarRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class RarReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        RarRootPackage result = RarReadNativeMetadataProperties.run(SampleFiles.INPUT_RAR);
        Assertions.assertThat(result).isNotNull();
    }
}