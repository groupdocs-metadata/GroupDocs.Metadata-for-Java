package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.SevenZipRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class SevenZipReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        SevenZipRootPackage result = SevenZipReadNativeMetadataProperties.run(SampleFiles.INPUT_7Z);
        Assertions.assertThat(result).isNotNull();
    }
}