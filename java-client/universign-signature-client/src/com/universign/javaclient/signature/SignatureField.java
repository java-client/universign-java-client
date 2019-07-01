
package com.universign.javaclient.signature;

/**
 * Describes the content of a PDF visible signature field.
 * If this option was omitted, the signature will be invisible.
 *
 */
public class SignatureField
{
	private String name;
	private int page;
	private int x;
	private int y;

	/**
	 * Returns the name of an existing field if the PDF contains
	 * a named signature field.
	 *
	 * @return The name of an existing field.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets the name of an existing field if the PDF contains
	 * a named signature field.
	 *
	 * @param name The name of an existing field.
	 * @return The current object instance
	 */
	public SignatureField setName(String name)
	{
		this.name = name;
		return this;
	}

	/**
	 * Returns the page number.
	 *
	 * @return The page number.
	 */
	public int getPage()
	{
		return page;
	}

	/**
	 * Sets the page number.
	 * Pages are enumerated starting at 1.
	 * The value -1 points at the last page.
	 *
	 * @param page The page number.
	 * @return The current object instance
	 */
	public SignatureField setPage(int page)
	{
		this.page = page;
		return this;
	}

	/**
	 * Returns the field horizontal coordinate on the page (abscissa).
	 *
	 * @return The abscissa for a signature field.
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Sets the field horizontal coordinate on the page (abscissa).
	 *
	 * @param x The abscissa for a signature field.
	 * @return The current object instance
	 */
	public SignatureField setX(int x)
	{
		this.x = x;
		return this;
	}

	/**
	 * Returns the field vertical coordinate on the page (ordinate).
	 *
	 * @return The ordinate for a signature field.
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * Sets the field vertical coordinate on the page (ordinate).
	 *
	 * @param y The ordinate for a signature field.
	 * @return The current object instance
	 */
	public SignatureField setY(int y)
	{
		this.y = y;
		return this;
	}
}
