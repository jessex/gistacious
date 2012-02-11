package com.jessex.gistacious.api;

import org.junit.Test;

import com.jessex.gistacious.api.auth.AuthenticationCredentialsDTO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit tests for the validation utility.
 *
 * @author jessex
 */
public class TestValidator {

    @Test
    public void testParamNotNull() {
        String aString = "A string";
        Validator.paramNotNull(aString, "aString");

        AuthenticationCredentialsDTO authenticationCredentialsDTO = new AuthenticationCredentialsDTO("", "");
        Validator.paramNotNull(authenticationCredentialsDTO, "authenticationCredentialsDTO");
    }
    
    @Test
    public void testParamNull() {
        String aString = null;
        try {
            Validator.paramNotNull(aString, "aString");
            fail("Should have thrown an IllegalArgumentException because of null parameter");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Parameter 'aString' cannot be null", e.getMessage());
        }
    }
    
    @Test
    public void testParamNotEmpty() {
        String aString = "A string";
        Validator.paramNotEmpty(aString, "aString");
    }
    
    @Test
    public void testParamEmpty() {
        String aString = "";
        try {
            Validator.paramNotEmpty(aString, "aString");
            fail("Should have thrown an IllegalArgumentException because of empty String parameter");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Parameter 'aString' can be neither empty nor null", e.getMessage());
        }
        
        aString = null;
        try {
            Validator.paramNotEmpty(aString, "aString");
            fail("Should have thrown an IllegalArgumentException because of empty String parameter");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Parameter 'aString' can be neither empty nor null", e.getMessage());
        }
    }
}
