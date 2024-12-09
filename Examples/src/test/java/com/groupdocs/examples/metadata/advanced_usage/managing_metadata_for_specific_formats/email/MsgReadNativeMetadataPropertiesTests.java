package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.MsgRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class MsgReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        MsgRootPackage result = MsgReadNativeMetadataProperties.run(SampleFiles.INPUT_MSG);
        Assertions.assertThat(result).isNotNull();
    }
}