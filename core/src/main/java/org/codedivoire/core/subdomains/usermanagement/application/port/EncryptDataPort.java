package org.codedivoire.core.subdomains.usermanagement.application.port;

/**
 * @author Christian Amani 2019-11-24
 */
public interface EncryptDataPort {

  String encrypt(String data);

  boolean correspond(String rawData, String encryptedData);
}
