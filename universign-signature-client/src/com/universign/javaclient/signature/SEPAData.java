
package com.universign.javaclient.signature;

/**
 * Contains information needed to create a SEPA mandate PDF.
 *
 */
public class SEPAData
{
	private String rum;
	private String ics;
	private String iban;
	private String bic;
	private Boolean recurring;
	private SEPAThirdParty debtor;
	private SEPAThirdParty creditor;

	/**
	 * Return the mandate identifier.
	 *
	 * @return The mandate identifier.
	 */
	public String getRum()
	{
		return rum;
	}

	/**
	 * Sets the mandate identifier.
	 *
	 * @param rum The mandate identifier.
	 * @return The current object instance
	 */
	public SEPAData setRum(String rum)
	{
		this.rum = rum.trim();
		return this;
	}

	/**
	 * Return the creditor identifier.
	 *
	 * @return The creditor identifier.
	 */
	public String getIcs()
	{
		return ics;
	}

	/**
	 * Sets the creditor identifier.
	 *
	 * @param ics The creditor identifier.
	 * @return The current object instance
	 */
	public SEPAData setIcs(String ics)
	{
		this.ics = ics.trim();
		return this;
	}

	/**
	 * Return the debtor international bank account number.
	 *
	 * @return The debtor international bank account number.
	 */
	public String getIban()
	{
		return iban;
	}

	/**
	 * Sets the debtor international bank account number.
	 *
	 * @param iban The debtor international bank account number.
	 * @return The current object instance
	 */
	public SEPAData setIban(String iban)
	{
		this.iban = iban.trim();
		return this;
	}

	/**
	 * Return the debtor bank identifier code.
	 *
	 * @return The debtor bank identifier code.
	 */
	public String getBic()
	{
		return bic;
	}

	/**
	 * Sets the debtor bank identifier code.
	 *
	 * @param bic The debtor bank identifier code.
	 * @return The current object instance
	 */
	public SEPAData setBic(String bic)
	{
		this.bic = bic.trim();
		return this;
	}

	/**
	 * Return <code>true</code> if the SEPA mandate
	 * describe a recurring payment,
	 * or <code>false</code> if it's a single-shot payment.
	 *
	 * @return The payment mode.
	 */
	public Boolean getRecurring()
	{
		return recurring;
	}

	/**
	 * Sets <code>true</code> if the SEPA mandate
	 * describe a recurring payment,
	 * or <code>false</code> if it's a single-shot payment.
	 *
	 * @param recurring A payment mode.
	 * @return The current object instance
	 */
	public SEPAData setRecurring(Boolean recurring)
	{
		this.recurring = recurring;
		return this;
	}

	/**
	 * Returns information of the debtor.
	 *
	 * @return The debtor information.
	 */
	public SEPAThirdParty getDebtor()
	{
		return debtor;
	}

	/**
	 * Sets information of the debtor.
	 *
	 * @param debtor Information of the debtor.
	 * @return The current object instance
	 */
	public SEPAData setDebtor(SEPAThirdParty debtor)
	{
		this.debtor = debtor;
		return this;
	}

	/**
	 * Returns information of the creditor.
	 *
	 * @return The creditor information.
	 */
	public SEPAThirdParty getCreditor()
	{
		return creditor;
	}

	/**
	 * Sets information of the creditor.
	 *
	 * @param creditor Information of the creditor.
	 * @return The current object instance
	 */
	public SEPAData setCreditor(SEPAThirdParty creditor)
	{
		this.creditor = creditor;
		return this;
	}
}
