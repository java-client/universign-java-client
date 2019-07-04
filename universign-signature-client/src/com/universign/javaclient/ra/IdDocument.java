
package com.universign.javaclient.ra;

/**
 * Defines the ID document and their type.
 *
 */
public class IdDocument
{
	private byte[][] photos;
	private RaConstants.IdDocumentTypes type;

	/**
	 * Returns the list of ID document to be validated.
	 *
	 * @return The list of ID document.
	 */
	public byte[][] getPhotos()
	{
		return photos;
	}

	/**
	 * Sets the ID document list.
	 *
	 * @param photos The ID document list to set.
	 * @return The current object instance
	 */
	public IdDocument setPhotos(byte[][] photos)
	{
		this.photos = photos;
		return this;
	}

	/**
	 * Returns the type of the ID document.
	 *
	 * @return The ID document type.
	 */
	public RaConstants.IdDocumentTypes getType()
	{
		return type;
	}

	/**
	 * Sets the type of the ID document.
	 *
	 * @param type The type to set.
	 * @return The current object instance
	 */
	public IdDocument setType(RaConstants.IdDocumentTypes type)
	{
		this.type = type;
		return this;
	}
}
