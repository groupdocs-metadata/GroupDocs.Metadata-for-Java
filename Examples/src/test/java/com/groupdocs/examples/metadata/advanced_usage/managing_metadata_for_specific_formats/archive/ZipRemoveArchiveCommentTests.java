package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.archive;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class ZipRemoveArchiveCommentTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = ZipRemoveArchiveComment.run(SampleFiles.INPUT_ZIP);
        Assertions.assertThat(result).isNotNull().exists();
    }
}