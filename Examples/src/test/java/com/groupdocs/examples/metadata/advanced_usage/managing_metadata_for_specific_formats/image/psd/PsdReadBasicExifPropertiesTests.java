package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.psd;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.PsdRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class PsdReadBasicExifPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        PsdRootPackage result = PsdReadBasicExifProperties.run(SampleFiles.EXIF_PSD);
        Assertions.assertThat(result).isNotNull();
    }
}