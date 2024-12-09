package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.jpeg.maker_note;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.JpegRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class MakerNoteReadPanasonicPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        JpegRootPackage result = MakerNoteReadPanasonicProperties.run(SampleFiles.PANASONIC_JPEG);
        Assertions.assertThat(result).isNotNull();
    }
}