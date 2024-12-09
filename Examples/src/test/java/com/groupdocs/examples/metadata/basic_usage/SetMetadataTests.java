package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class SetMetadataTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = SetMetadata.run(SampleFiles.INPUT_FILES_DIRECTORY);
        Assertions.assertThat(result).isNotNull().exists();
    }
}