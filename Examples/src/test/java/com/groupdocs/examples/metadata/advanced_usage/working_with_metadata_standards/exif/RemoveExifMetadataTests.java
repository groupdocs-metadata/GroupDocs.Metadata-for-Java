package com.groupdocs.examples.metadata.advanced_usage.working_with_metadata_standards.exif;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class RemoveExifMetadataTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = RemoveExifMetadata.run(SampleFiles.EXIF_JPEG);
        Assertions.assertThat(result).isNotNull().exists();
    }
}