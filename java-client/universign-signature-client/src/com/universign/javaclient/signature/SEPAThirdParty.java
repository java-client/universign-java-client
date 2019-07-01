
package com.universign.javaclient.signature;

/**
 * Defines informations on both of debtor and creditor of a SEPA mandate.
 *
 */
public class SEPAThirdParty
{
	private String name;
	private String address;
	private String postalCode;
	private String city;
	private String country;

	/**
	 * Returns the debtor/creditor's full name.
	 *
	 * @return The debtor/creditor's full name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the debtor/creditor's full name.
	 *
	 * @param name The debtor/creditor's full name.
	 * @return The current object instance
	 */
	public SEPAThirdParty setName(String name)
	{
		this.name = name;
		return this;
	}

	/**
	 * Returns the debtor/creditor's address.
	 *
	 * @return The debtor/creditor's address.
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * Sets the debtor/creditor's address.
	 *
	 * @param address The debtor/creditor's address.
	 * @return The current object instance
	 */
	public SEPAThirdParty setAddress(String address)
	{
		this.address = address;
		return this;
	}

	/**
	 * Returns the debtor/creditor's postal code.
	 *
	 * @return The debtor/creditor's postal code.
	 */
	public String getPostalCode()
	{
		return postalCode;
	}

	/**
	 * Sets the debtor/creditor's postal code.
	 *
	 * @param postalCode The debtor/creditor's postal code.
	 * @return The current object instance
	 */
	public SEPAThirdParty setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
		return this;
	}

	/**
	 * Returns the debtor/creditor's city.
	 *
	 * @return The debtor/creditor's city.
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * Sets the debtor/creditor's city.
	 *
	 * @param city The debtor/creditor's city.
	 * @return The current object instance
	 */
	public SEPAThirdParty setCity(String city)
	{
		this.city = city;
		return this;
	}

	/**
	 * Returns the debtor/creditor's country.
	 *
	 * @return The debtor/creditor's country.
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * Sets the debtor/creditor's country.
	 *
	 * @param country The debtor/creditor's country.
	 * @return The current object instance
	 */
	public SEPAThirdParty setCountry(String country)
	{
		this.country = country;
		return this;
	}
}
