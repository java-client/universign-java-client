
package com.universign.javaclient.utils;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

/**
 * Utility class.
 * Converts JavaBeans To Map and vice versa methods.
 *
 */
public class Utils
{
	private Utils()
	{
		// Private Constructor
	}

	/**
	 * Defines the transformation of Java object to Java map.
	 *
	 * @param object The Java Object to convert.
	 * @return The transformed object without null values.
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> objectToMap(Object object)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature
				.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.setDateFormat(new StdDateFormat());
		objectMapper.setSerializationInclusion(
				JsonInclude.Include.NON_NULL);
		return objectMapper.convertValue(
				object, Map.class);
	}

	/**
	 * Defines the transformation of Java map to Java object.
	 *
	 * @param map The Java Map to convert.
	 * @param objectClass The converted object class.
	 * @param <T> The generic class type.
	 * @return The transformed Map.
	 */
	public static <T> T mapToObject(Map<String, Object> map,
			Class<T> objectClass)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		//To ignore properties that are not declared
		objectMapper.configure(DeserializationFeature
				.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper.convertValue(map, objectClass);
	}
}
