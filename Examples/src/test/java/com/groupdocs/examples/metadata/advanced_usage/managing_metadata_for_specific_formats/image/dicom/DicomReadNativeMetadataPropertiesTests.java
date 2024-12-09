package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.image.dicom;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.DicomRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class DicomReadNativeMetadataPropertiesTests extends TestsSetUp {


    @Test
    void testRun() {
        DicomRootPackage result = DicomReadNativeMetadataProperties.run(SampleFiles.INPUT_DICOM);
        Assertions.assertThat(result).isNotNull();
    }
}