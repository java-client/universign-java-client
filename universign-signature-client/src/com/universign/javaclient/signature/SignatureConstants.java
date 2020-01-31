
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

		/**
		 * Returns SignatureUrl from string value.
		 *
		 * @param url The Server Url as string.
		 * @return SignatureUrl enum.
		 */
		public static SignatureUrl fromString(String url)
		{
			for (SignatureUrl sUrl : values()) {
				if (sUrl.url.equals(url)) {
					return sUrl;
				}
			}
			throw new IllegalArgumentException(
					"No URL with such value: " + url);
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

		/**
		 * Returns Language from string value.
		 *
		 * @param language The language as string.
		 * @return Language enum.
		 */
		public static Language fromString(String language)
		{
			for (Language l : values()) {
				if (l.langue.equals(language)) {
					return l;
				}
			}
			throw new IllegalArgumentException(
					"No language with such value: " + language);
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

		/**
		 * Returns IdDocumentTypes from string value.
		 *
		 * @param type The id document type as string.
		 * @return IdDocumentTypes enum.
		 */
		public static IdDocumentTypes fromString(String type)
		{
			for (IdDocumentTypes t : values()) {
				if (t.type.equals(type)) {
					return t;
				}
			}
			throw new IllegalArgumentException(
					"No IdDocumentType with such value: " + type);
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

		/**
		 * Returns SignatureFormats from string value.
		 *
		 * @param format The signature format as string.
		 * @return SignatureFormats enum.
		 */
		public static SignatureFormats fromString(String format)
		{
			for (SignatureFormats f : values()) {
				if (f.format.equals(format)) {
					return f;
				}
			}
			throw new IllegalArgumentException(
					"No SignatureFormat with such value: " + format);
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

		/**
		 * Returns DocumentTypes from string value.
		 *
		 * @param type The document type as string.
		 * @return DocumentTypes enum.
		 */
		public static DocumentTypes fromString(String type)
		{
			for (DocumentTypes t : values()) {
				if (t.docType.equals(type)) {
					return t;
				}
			}
			throw new IllegalArgumentException(
					"No DocumentType with such value: " + type);
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

		/**
		 * Returns TransactionStatus from int value.
		 *
		 * @param status The transaction status as int.
		 * @return TransactionStatus enum.
		 */
		public static TransactionStatus fromInt(int status)
		{
			for (TransactionStatus s : values()) {
				if (s.status == status) {
					return s;
				}
			}
			throw new IllegalArgumentException(
					"No TransactionStatus with such value: " + status);
		}
	}

	/**
	 * Certificate type that can be used.
	 */
	public enum CertificateType
	{
		/*CERTIFICATE_TYPE_LOCAL("local"),*/
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

		/**
		 * Returns CertificateType from string value.
		 *
		 * @param type The certificate type as string.
		 * @return CertificateType enum.
		 */
		public static CertificateType formString(String type)
		{
			for (CertificateType t : values()) {
				if (t.certType.equals(type)) {
					return t;
				}
			}
			throw new IllegalArgumentException(
					"No CertificateType with such value: " + type);
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

		/**
		 * Returns HandwrittenMode from int value.
		 *
		 * @param mode The handwritten mode as int.
		 * @return HandwrittenMode enum.
		 */
		public static HandwrittenMode fromInt(int mode)
		{
			for (HandwrittenMode m : values()) {
				if (m.mode == mode) {
					return m;
				}
			}
			throw new IllegalArgumentException(
					"No HandwrittenMode with such value: " + mode);
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

		/**
		 * Returns ChaningMode from string value.
		 *
		 * @param mode the chaningMode as string.
		 * @return ChaningMode enum.
		 */
		public static ChaningMode fromString(String mode)
		{
			for (ChaningMode m : values()) {
				if (m.mode.equals(mode)) {
					return m;
				}
			}
			throw new IllegalArgumentException(
					"No ChainingMode with such value: " + mode);
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

		/**
		 * Returns Role form string value.
		 *
		 * @param role The role as string.
		 * @return Role enum.
		 */
		public static Role fromString(String role)
		{
			for (Role r : values()) {
				if (r.part.equals(role)) {
					return r;
				}
			}
			throw new IllegalArgumentException(
					"No Role with such value: " + role);
		}
	}

	/**
	 * RedirectPolicy that can be used.
	 */
	public enum RedirectPolicy
	{
		DASHBOARD("dashboard"),
		QUICK("quick");

		private String policy;

		private RedirectPolicy(String policy)
		{
			this.policy = policy;
		}

		@JsonValue
		public String getRedirectPolicy()
		{
			return policy;
		}

		/**
		 * Returns RedirectPolicy from string value.
		 *
		 * @param policy The redirect policy as string.
		 * @return RedirectPolicy enum.
		 */
		public static RedirectPolicy fromString(String policy)
		{
			for (RedirectPolicy redirectPolicy : values()) {
				if (redirectPolicy.policy.equals(policy)) {
					return redirectPolicy;
				}
			}
			throw new IllegalArgumentException(
					"No RedirectPolicy with such value: " + policy);
		}
	}
}
