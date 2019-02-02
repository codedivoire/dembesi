package org.codedivoire.dembesi.dictionary.utils;

/**
 * @author Christian Amani on 24/01/2019.
 */
public class RequiredException extends Exception {

    private String objectRequired;

    public RequiredException(String objectRequired) {
        this.objectRequired = objectRequired;
    }

    @Override
    public String getMessage() {
        return objectRequired + " value is required";
    }
}
