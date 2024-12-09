package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.JpegRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class JpegDetectBarcodesTests extends TestsSetUp {


    @Test
    void testRun() {
        JpegRootPackage result = JpegDetectBarcodes.run(SampleFiles.INPUT_WITH_BARCODES_JPEG);
        Assertions.assertThat(result).isNotNull();
    }
}