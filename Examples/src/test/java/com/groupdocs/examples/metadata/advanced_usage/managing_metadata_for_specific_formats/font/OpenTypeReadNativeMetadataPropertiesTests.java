package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.font;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.OpenTypeRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class OpenTypeReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        OpenTypeRootPackage result = OpenTypeReadNativeMetadataProperties.run(SampleFiles.INPUT_TTF);
        Assertions.assertThat(result).isNotNull();
    }
}