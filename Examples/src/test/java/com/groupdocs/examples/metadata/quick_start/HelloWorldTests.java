package com.groupdocs.examples.metadata.quick_start;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.IReadOnlyList;
import com.groupdocs.metadata.core.MetadataProperty;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class HelloWorldTests extends TestsSetUp {


    @Test
    void testRun() {
        IReadOnlyList<MetadataProperty> result = HelloWorld.run(SampleFiles.INPUT_DOCX);
        Assertions.assertThat(result).isNotNull();
    }
}