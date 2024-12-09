package com.groupdocs.examples.metadata.advanced_usage;

import com.groupdocs.examples.metadata.SampleFiles;
import com.groupdocs.examples.metadata.TestsSetUp;
import com.groupdocs.metadata.core.FileFormat;
import com.groupdocs.metadata.core.SpreadsheetRootPackage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

class LoadFileTests extends TestsSetUp {


    @Test
    void testFromLocalDisk() {
        LoadFile.fromLocalDisk(SampleFiles.INPUT_ONE);
    }

    @Test
    void testFromStream() {
        LoadFile.fromStream(SampleFiles.INPUT_DOC);
    }

    @Test
    void testFileOfSpecificFormat() {
        SpreadsheetRootPackage result = LoadFile.fileOfSpecificFormat(SampleFiles.INPUT_XLSX, FileFormat.Spreadsheet);
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    void testProtectedByPassword() {
        LoadFile.protectedByPassword(SampleFiles.PROTECTED_DOCX, "123");
    }
}