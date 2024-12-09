package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.TarRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class TarReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        TarRootPackage result = TarReadNativeMetadataProperties.run(SampleFiles.INPUT_TAR);
        Assertions.assertThat(result).isNotNull();
    }
}