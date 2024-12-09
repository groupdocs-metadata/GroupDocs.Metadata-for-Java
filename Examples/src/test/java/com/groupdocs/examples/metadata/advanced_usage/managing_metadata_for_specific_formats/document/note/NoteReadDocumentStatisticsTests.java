package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.note;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.NoteRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class NoteReadDocumentStatisticsTests extends TestsSetUp {


    @Test
    void testRun() {
        NoteRootPackage result = NoteReadDocumentStatistics.run(SampleFiles.INPUT_ONE);
        Assertions.assertThat(result).isNotNull();
    }
}