package com.jessex.gistacious.api;

import org.apache.commons.lang.Validate;

/**
 * An extension of {@link org.apache.commons.lang.Validate Apache Validate} which adds a convenience method to easily
 * validate method parameters.
 *
 * @author jessex
 */
public class Validator extends Validate {

    /**
     * Validates that the given parameter is not null.
     *
     * @param param the parameter to validate
     * @param paramName the name of the parameter
     */
    public static void paramNotNull(Object param, String paramName) {
        notNull(param, String.format("Parameter '%s' cannot be null", paramName));
    }

    /**
     * Validates that the given String parameter is neither empty (zero characters) or null.
     *
     * @param param the parameter to validate
     * @param paramName the name of the parameter
     */
    public static void paramNotEmpty(String param, String paramName) {
        notEmpty(param, String.format("Parameter '%s' can be neither empty nor null", paramName));
    }
}
