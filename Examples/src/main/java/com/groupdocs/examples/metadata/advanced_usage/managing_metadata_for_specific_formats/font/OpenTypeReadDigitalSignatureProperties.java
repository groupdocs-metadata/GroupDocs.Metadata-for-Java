// <copyright company="Aspose Pty Ltd">
//   Copyright (C) 2011-2021 GroupDocs. All Rights Reserved.
// </copyright>

package com.groupdocs.examples.metadata.advanced_usage.managing_metadata_for_specific_formats.font;

import com.groupdocs.examples.metadata.utils.FailureRegister;
import com.groupdocs.metadata.Metadata;
import com.groupdocs.metadata.core.*;

import java.nio.file.Path;

/**
 * This code snippet demonstrates how to extract digital signatures associated with an OpenType font.
 */
public class OpenTypeReadDigitalSignatureProperties {
    public static OpenTypeRootPackage run(Path inputFile) {
        try (Metadata metadata = new Metadata(inputFile.toString())) {
            OpenTypeRootPackage root = metadata.getRootPackageGeneric();
            if (root.getDigitalSignaturePackage() != null) {
                System.out.printf("\tFlags: %s%n", root.getDigitalSignaturePackage().getFlags());
                for (Cms signature : root.getDigitalSignaturePackage().getSignatures()) {
                    System.out.printf("\t\tSignTime: %s%n", signature.getSignTime());
                    if (signature.getDigestAlgorithms() != null) {
                        for (Oid signatureDigestAlgorithm : signature.getDigestAlgorithms()) {
                            printOid(signatureDigestAlgorithm);
                        }
                    }
                    if (signature.getEncapsulatedContent() != null) {
                        System.out.printf("\t\tContentType: %s%n", signature.getEncapsulatedContent().getContentType());
                        System.out.printf("\t\tContentRawData Length: %d%n", signature.getEncapsulatedContent().getContentRawData().length);
                    }
                    if (signature.getCertificates() != null) {
                        for (CmsCertificate certificate : signature.getCertificates()) {
                            System.out.printf("\t\tNotAfter: %s%n", certificate.getNotAfter());
                            System.out.printf("\t\tNotBefore: %s%n", certificate.getNotBefore());
                            System.out.printf("\t\tRawData Length: %d%n", certificate.getRawData().length);
                        }
                    }
                    if (signature.getSigners() != null) {
                        for (CmsSigner signerInfoEntry : signature.getSigners()) {
                            System.out.printf("\t\tSignatureValue: %s%n", signerInfoEntry.getSignatureValue());
                            printOid(signerInfoEntry.getDigestAlgorithm());
                            printOid(signerInfoEntry.getSignatureAlgorithm());
                            System.out.printf("\t\tSigningTime: %s%n", signerInfoEntry.getSigningTime());
                            printAttributes(signerInfoEntry.getSignedAttributes());
                            printAttributes(signerInfoEntry.getUnsignedAttributes());
                        }
                    }
                }
            }
            return root;
        } catch (Exception e) {
            FailureRegister.getInstance().registerFailedSample(e);
        }
        System.out.println("..sample finished successfully.\n");
        return null;
    }


    private static void printOid(Oid oid) {
        // Display the property name and value of OID
        if (oid != null) {
            System.out.printf("\t\tOID: %s, Value: %s%n", oid.getFriendlyName(), oid.getValue());
        }
    }

    private static void printAttributes(CmsAttribute[] attributes) {
        //Display the CmsAttributes of an OID
        if (attributes != null) {
            for (CmsAttribute attribute : attributes) {
                printOid(attribute.getOid());
                System.out.printf("\t\tValue: %s%n", attribute.getValue());
            }
        }
    }
}
