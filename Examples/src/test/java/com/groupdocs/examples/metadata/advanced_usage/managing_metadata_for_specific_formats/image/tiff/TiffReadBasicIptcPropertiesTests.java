package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.tiff;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.TiffRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class TiffReadBasicIptcPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        TiffRootPackage result = TiffReadBasicIptcProperties.run(SampleFiles.IPTC_TIFF);
        Assertions.assertThat(result).isNotNull();
    }
}