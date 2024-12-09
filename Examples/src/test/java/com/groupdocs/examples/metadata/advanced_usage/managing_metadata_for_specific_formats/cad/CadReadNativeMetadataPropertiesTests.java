package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.cad;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.CadRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class CadReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        CadRootPackage result = CadReadNativeMetadataProperties.run(SampleFiles.INPUT_DXF);
        Assertions.assertThat(result).isNotNull();
    }
}