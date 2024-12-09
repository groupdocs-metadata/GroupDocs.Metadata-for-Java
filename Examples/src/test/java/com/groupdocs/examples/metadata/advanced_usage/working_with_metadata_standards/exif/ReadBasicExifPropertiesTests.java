package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.IExif;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class ReadBasicExifPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        IExif result = ReadBasicExifProperties.run(SampleFiles.EXIF_TIFF);
        Assertions.assertThat(result).isNotNull();
    }
}