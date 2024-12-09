package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.document.project_management;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.ProjectManagementRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class ProjectManagementReadBuiltInPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        ProjectManagementRootPackage result = ProjectManagementReadBuiltInProperties.run(SampleFiles.INPUT_MPP);
        Assertions.assertThat(result).isNotNull();
    }
}