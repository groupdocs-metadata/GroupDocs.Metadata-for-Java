package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.WordProcessingPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class GetKnownPropertyDescriptorsTests extends TestsSetUp {


    @Test
    void testRun() {
        WordProcessingPackage result = GetKnownPropertyDescriptors.run(SampleFiles.INPUT_DOC);
        Assertions.assertThat(result).isNotNull();
    }
}