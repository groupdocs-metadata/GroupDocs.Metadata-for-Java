package com.groupdocs.metadata.examples;

import com.groupdocs.metadata.EmlFormat;
import com.groupdocs.metadata.EmlMetadata;
import com.groupdocs.metadata.OutlookMessage;
import com.groupdocs.metadata.OutlookMessageMetadata;
import com.groupdocs.metadata.examples.Utilities.Common;

public class Emails {
	public static class OutLook {
		private static String path = "\\Emails\\Outlook\\sample1.msg";
		private static String outputPath = "\\Emails\\Outlook\\result.msg";

		public static void getOutlookEmailMetadata() {
			// initialize outlookFormat
			try (OutlookMessage msgFormat = new OutlookMessage(Common.mapSourceFilePath(path))) {

				// get metadata
				OutlookMessageMetadata metadata = msgFormat.getMsgInfo();
				// display metadata
				System.out.printf("Body: " + metadata.getBody());
				System.out.printf("DeliveryTime: " + metadata.getDeliveryTime());
				System.out.printf("Recipients: " + metadata.getRecipients()[0]);
				System.out.printf("Subject: " + metadata.getSubject());
				System.out.printf("Attachments: " + metadata.getAttachments()[0]);
			}
		}

		public static void removeOutlookEmailAttachments() {
			// initialize outlookFormat
			try (OutlookMessage outlookFormat = new OutlookMessage(Common.mapSourceFilePath(path))) {
				// remove attachments
				outlookFormat.removeAttachments();

				// commit changes
				outlookFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void removeOutlookEmailMetadata() {
			// initialize outlookFormat
			try (OutlookMessage outlookFormat = new OutlookMessage(Common.mapSourceFilePath(path))) {
				// remove metadata
				outlookFormat.cleanMetadata();

				// commit changes
				outlookFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}
	}

	public static class Eml {
		private static String path = "\\Emails\\Eml\\sample.eml";
		private static String outputPath = "\\Emails\\Eml\\result.Eml";

		public static void getEmailMetadata() {
			// initialize EmlFormat
			try (EmlFormat emlFormat = new EmlFormat(Common.mapSourceFilePath(path))) {
				// get metadata
				EmlMetadata metadata = emlFormat.getEmlInfo();
				// display metadata
				System.out.printf("CC: " + metadata.getCC());
				System.out.printf("Mail Address From: " + metadata.getMailAddressFrom());
				System.out.printf("Subject: " + metadata.getSubject());
				System.out.printf("Attachments: " + metadata.getAttachments()[0]);
			}
		}

		public static void removeEmailAttachments() {
			// initialize EmlFormat
			try (EmlFormat emlFormat = new EmlFormat(Common.mapSourceFilePath(path))) {

				// remove attachments
				emlFormat.removeAttachments();

				// commit changes
				emlFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}

		public static void removeEmailMetadata() {
			// initialize EmlFormat
			try (EmlFormat emlFormat = new EmlFormat(Common.mapSourceFilePath(path))) {
				// remove metadata
				emlFormat.cleanMetadata();

				// commit changes
				emlFormat.save(Common.mapDestinationFilePath(outputPath));
			}
		}
	}
}
