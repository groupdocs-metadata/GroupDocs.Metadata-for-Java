package com.groupdocs.examples.metadata.basic_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.IDocumentInfo;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class GetDocumentInfoTests extends TestsSetUp {


    @Test
    void testRun() {
        IDocumentInfo result = GetDocumentInfo.run(SampleFiles.INPUT_XLSX);
        Assertions.assertThat(result).isNotNull();
    }
}