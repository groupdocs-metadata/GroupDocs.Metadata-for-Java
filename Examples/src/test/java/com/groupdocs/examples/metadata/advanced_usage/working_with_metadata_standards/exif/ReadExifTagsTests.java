package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.IExif;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class ReadExifTagsTests extends TestsSetUp {


    @Test
    void testRun() {
        IExif result = ReadExifTags.run(SampleFiles.EXIF_JPEG);
        Assertions.assertThat(result).isNotNull();
    }
}