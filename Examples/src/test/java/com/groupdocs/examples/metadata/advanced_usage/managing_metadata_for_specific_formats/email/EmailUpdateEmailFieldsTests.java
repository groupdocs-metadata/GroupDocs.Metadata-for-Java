package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.email;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class EmailUpdateEmailFieldsTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = EmailUpdateEmailFields.run(SampleFiles.INPUT_EML);
        Assertions.assertThat(result).isNotNull().exists();
    }
}