package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.mov;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.MovRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class MovReadQuickTimeAtomsTests extends TestsSetUp {


    @Test
    void testRun() {
        MovRootPackage result = MovReadQuickTimeAtoms.run(SampleFiles.INPUT_MOV);
        Assertions.assertThat(result).isNotNull();
    }
}