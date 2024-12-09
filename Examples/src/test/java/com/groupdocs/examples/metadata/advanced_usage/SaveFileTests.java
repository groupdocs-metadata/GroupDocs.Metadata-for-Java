package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class SaveFileTests extends TestsSetUp {


    @Test
    void testToOriginalSource() {
        Path result = SaveFile.toOriginalSource(SampleFiles.INPUT_PPT);
        Assertions.assertThat(result).isNotNull().exists();
    }

    @Test
    void testToSpecifiedLocation() {
        Path result = SaveFile.toSpecifiedLocation(SampleFiles.INPUT_PNG);
        Assertions.assertThat(result).isNotNull().exists();
    }

    @Test
    void testToSpecifiedStream() {
        Path result = SaveFile.toSpecifiedStream(SampleFiles.INPUT_JPG);
        Assertions.assertThat(result).isNotNull().exists();
    }
}