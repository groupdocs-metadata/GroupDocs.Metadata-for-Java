// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.video.mov;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.MovAtom;
import com.groupdocs.metadata.core.MovRootPackage;
import com.groupdocs.metadata.examples.Constants;

/**
 * This example shows how to read QuickTime atoms in a MOV video.
 */
public class MovReadQuickTimeAtoms {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputMov)) {
            MovRootPackage root = metadata.getRootPackageGeneric();

            for (MovAtom atom : root.getMovPackage().getAtoms()) {
                System.out.println(atom.getType());
                System.out.println(atom.getOffset());
                System.out.println(atom.getSize());

                // ...
            }
        }
    }
}
