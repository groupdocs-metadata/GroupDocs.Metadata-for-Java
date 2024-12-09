package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class ImportMetadataTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = ImportMetadata.run(SampleFiles.INPUT_PDF, SampleFiles.PDF_JSON);
        Assertions.assertThat(result).isNotNull().exists();
    }
}