package org.codedivoire.dembesi.dictionary.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Christian Amani on 02/02/2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class FacadeDictionaryServiceTest {

    @Test
    public void submittedName() {
    }

    @Test
    public void submitNameDefinition() {
    }

    @Test
    public void submitNameDiction() {
    }

    @Test
    public void submitNameEtymology() {
    }

    @Test
    public void submitNameGeoLocation() {
    }

    @Test
    public void submitMediaLink() {
    }

    @Test
    public void submitNameWithAllInformation() {
    }

    @Test
    public void putAudioStream() {
    }
}