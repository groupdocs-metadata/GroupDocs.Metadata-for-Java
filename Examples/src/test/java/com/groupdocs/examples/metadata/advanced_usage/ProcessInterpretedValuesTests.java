package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class ProcessInterpretedValuesTests extends TestsSetUp {

    @Test
    void testRun() {
        ProcessInterpretedValues.run(SampleFiles.INPUT_FILES_DIRECTORY);
    }
}