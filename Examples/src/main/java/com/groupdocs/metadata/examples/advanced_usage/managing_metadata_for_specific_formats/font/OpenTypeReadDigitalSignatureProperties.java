// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.metadata.examples.advanced_usage.managing_metadata_for_specific_formats.font;

import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;
import com.groupdocs.metadata.examples.Constants;

/**
 * This code snippet demonstrates how to extract digital signatures associated with an OpenType font.
 */
public class OpenTypeReadDigitalSignatureProperties {
    public static void run() {
        try (Metadata metadata = new Metadata(Constants.InputTtf)) {
            OpenTypeRootPackage root = metadata.getRootPackageGeneric();

            if (root.getDigitalSignaturePackage() != null) {
                System.out.println(root.getDigitalSignaturePackage().getFlags());
                for (Cms signature : root.getDigitalSignaturePackage().getSignatures()) {
                    System.out.println(signature.getSignTime());
                    if (signature.getDigestAlgorithms() != null) {
                        for (Oid signatureDigestAlgorithm : signature.getDigestAlgorithms()) {
                            printOid(signatureDigestAlgorithm);
                        }
                    }
                    if (signature.getEncapsulatedContent() != null) {
                        printOid(signature.getEncapsulatedContent().getContentType());
                        System.out.println(signature.getEncapsulatedContent().getContentRawData().length);
                    }
                    if (signature.getCertificates() != null) {
                        for (CmsCertificate certificate : signature.getCertificates()) {
                            System.out.println(certificate.getNotAfter());
                            System.out.println(certificate.getNotBefore());
                            System.out.println(certificate.getRawData().length);
                        }
                    }
                    if (signature.getSigners() != null) {
                        for (CmsSigner signerInfoEntry : signature.getSigners()) {
                            System.out.println(signerInfoEntry.getSignatureValue());
                            printOid(signerInfoEntry.getDigestAlgorithm());
                            printOid(signerInfoEntry.getSignatureAlgorithm());
                            System.out.println(signerInfoEntry.getSigningTime());
                            printAttributes(signerInfoEntry.getSignedAttributes());
                            printAttributes(signerInfoEntry.getUnsignedAttributes());
                        }
                    }
                }
            }
        }
    }

    private static void printOid(Oid oid) {
        // Display the property name and value of OID
        if (oid != null) {
            System.out.println(oid.getFriendlyName());
            System.out.println(oid.getValue());
        }
    }

    private static void printAttributes(CmsAttribute[] attributes) {
        //Display the CmsAttributes of an OID
        if (attributes != null) {
            for (CmsAttribute attribute : attributes) {
                printOid(attribute.getOid());
                System.out.println(attribute.getValue());
            }
        }
    }
}
