
package com.universign.javaclient.signature;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines the different enum which
 * will be used in the Signature package.
 *
 */
public class SignatureConstants
{
	/**
	 * Server Url connection that can be used.
	 */
	public enum SignatureUrl
	{
		TEST_URL("https://sign.test.cryptolog.com/sign/rpc/"),
		PROD_URL("https://ws.universign.eu/sign/rpc/");

		private String url;

		private SignatureUrl(String url)
		{
			this.url = url;
		}

		@JsonValue
		public String getUrl()
		{
			return url;
		}
	}

	/**
	 * Language that can be used.
	 */
	public enum Language
	{
		LANGUAGE_BG("bg"),
		LANGUAGE_CA("ca"),
		LANGUAGE_DE("de"),
		LANGUAGE_EN("en"),
		LANGUAGE_ES("es"),
		LANGUAGE_FR("fr"),
		LANGUAGE_IT("it"),
		LANGUAGE_NL("nl"),
		LANGUAGE_PL("pl"),
		LANGUAGE_PT("pt"),
		LANGUAGE_RO("ro");

		private String langue;

		private Language(String langue)
		{
			this.langue = langue;
		}

		@JsonValue
		public String getLangue()
		{
			return langue;
		}
	}

	/**
	 * ID document type that can be used.
	 */
	public enum IdDocumentTypes
	{
		ID_TYPE_ID_CARD_FR("id_card_fr"),
		ID_TYPE_PASSPORT_EU("passport_eu"),
		ID_TYPE_TITRE_SEJOUR("titre_sejour");
		/*ID_TYPE_DRIVE_LICENCE("drive_licence");*/

		private String type;

		private IdDocumentTypes(String type)
		{
			this.type = type;
		}

		@JsonValue
		public String getType()
		{
			return type;
		}
	}

	/**
	 * Signature format that can be used.
	 */
	public enum SignatureFormats
	{
		SIGNATURE_FORMAT_PADES("PADES"),
		SIGNATURE_FORMAT_PADES_COMP("PADES-COMP"),
		SIGNATURE_FORMAT_ISO_32000_1("ISO-32000-1");

		private String format;

		private SignatureFormats(String format)
		{
			this.format = format;
		}

		@JsonValue
		public String getFormat()
		{
			return format;
		}
	}

	/**
	 * Document type that can be used.
	 */
	public enum DocumentTypes
	{
		DOCUMENT_TYPE_PDF("pdf"),
		DOCUMENT_TYPE_PDF_FOR_PRESENTATION("pdf-for-presentation"),
		DOCUMENT_TYPE_PDF_OPTIONAL("pdf-optional"),
		DOCUMENT_TYPE_SEPA("sepa");

		private String docType;

		private DocumentTypes(String docType)
		{
			this.docType = docType;
		}

		@JsonValue
		public String getDocType()
		{
			return docType;
		}
	}

	/**
	 * Status that can be used.
	 */
	public enum TransactionStatus
	{
		TRANSACTION_STATUS_READY(0),
		TRANSACTION_STATUS_EXPIRED(1),
		TRANSACTION_STATUS_COMPLETED(2),
		TRANSACTION_STATUS_CANCELED(3),
		TRANSACTION_STATUS_FAILED(4),
		TRANSACTION_STATUS_PENDING_RA_VALIDATION(5);

		private int status;

		private TransactionStatus(int status)
		{
			this.status = status;
		}

		@JsonValue
		public int getStatus()
		{
			return status;
		}
	}

	/**
	 * Certificate type that can be used.
	 */
	public enum CertificateType
	{
		CERTIFICATE_TYPE_LOCAL("local"),
		CERTIFICATE_TYPE_CERTIFIED("certified"),
		CERTIFICATE_TYPE_ADVANCED("advanced"),
		CERTIFICATE_TYPE_SIMPLE("simple");

		private String certType;

		private CertificateType(String certType)
		{
			this.certType = certType;
		}

		@JsonValue
		public String getCertType()
		{
			return certType;
		}
	}

	/**
	 * Handwritten mode that can be used.
	 */
	public enum HandwrittenMode
	{
		HANDWRITTEN_MODE_DISABLED(0),
		HANDWRITTEN_MODE_ENABLED(1),
		HANDWRITTEN_MODE_TOUCH_INTERFACE(2);

		private int mode;

		private HandwrittenMode(int mode)
		{
			this.mode = mode;
		}

		@JsonValue
		public int getMode()
		{
			return mode;
		}
	}

	/**
	 * Chaining mode that can be used.
	 */
	public enum ChaningMode
	{
		CHAINING_MODE_NONE("none"),
		CHAINING_MODE_EMAIL("email"),
		CHAINING_MODE_WEB("web");

		private String mode;

		private ChaningMode(String mode)
		{
			this.mode = mode;
		}

		@JsonValue
		public String getMode()
		{
			return mode;
		}
	}

	/**
	 * Role that can be used.
	 */
	public enum Role
	{
		SIGNER("signer"),
		OBSERVER("observer");

		private String part;

		private Role(String role)
		{
			this.part = role;
		}

		@JsonValue
		public String getRole()
		{
			return part;
		}
	}
}
