// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.video.mov;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MovAtom;
import com.groupdocs.metadata.core.MovRootPackage;

import java.nio.file.Path;

/**
 * This example shows how to read QuickTime atoms in a MOV video.
 */
public class MovReadQuickTimeAtoms {
    public static MovRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            MovRootPackage root = metadata.getRootPackageGeneric();
            for (MovAtom atom : root.getMovPackage().getAtoms()) {
                System.out.printf("\tType: %s%n", atom.getType());
                System.out.printf("\tOffset: %d%n", atom.getOffset());
                System.out.printf("\tSize: %d%n", atom.getSize());
                // ...
            }
            System.out.println("..sample finished successfully.\n");
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        return null;
    }
}
