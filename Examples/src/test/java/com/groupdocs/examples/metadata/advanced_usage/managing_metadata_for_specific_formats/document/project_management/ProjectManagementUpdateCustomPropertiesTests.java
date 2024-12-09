package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;

class ProjectManagementUpdateCustomPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        Path result = ProjectManagementUpdateCustomProperties.run(SampleFiles.INPUT_MPP);
        Assertions.assertThat(result).isNotNull().exists();
    }
}