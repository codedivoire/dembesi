package org.codedivoire.dembesi.common.configuration;

import org.codedivoire.dembesi.usermanagement.entity.Profile;

/**
 * @author  Christian Amani on 24/08/2018.
 */
public interface UtilsHandler {

    String getAuthorities(Profile account);
}
