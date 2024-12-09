package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.word_processing;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.WordProcessingRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class WordProcessingUpdateBuiltInPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        WordProcessingRootPackage result = WordProcessingUpdateBuiltInProperties.run(SampleFiles.INPUT_DOC);
        Assertions.assertThat(result).isNotNull();
    }
}