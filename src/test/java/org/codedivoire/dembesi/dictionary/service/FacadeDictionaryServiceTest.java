package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.common.model.api.ApiResponse;
import org.codedivoire.dembesi.common.model.api.GreatResponse;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.dictionary.entity.*;
import org.codedivoire.dembesi.dictionary.model.NameBodyRequest;
import org.codedivoire.dembesi.dictionary.model.State;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Christian Amani on 02/02/2019.
 */
@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {DictionService.class
        , NameService.class, FacadeDictionaryService.class}))
@ActiveProfiles("embedded")
public class FacadeDictionaryServiceTest {


    @MockBean
    MultipartFile multipartFile;

    @MockBean
    NameBodyRequest bodyRequest;

    @Autowired
    private FacadeDictionaryService facadeDictionary;

    private final String API_VERSION = "1.0.0";

    @Before
    public void setup() throws IOException {
        Mockito.when(multipartFile.getBytes())
                .thenReturn(new byte[10]);
        Name name = new Name();
        name.setName("Koffi");
        name.setState(State.NEW);
        name.setTemporalEventData(new TemporalEventData());
        Mockito.when(bodyRequest.getName()).thenReturn(name);
        Definition definition = new Definition();
        definition.setContent("Lorem Ipsum");
        definition.setEnglishContent("Lorem Ipsum");
        definition.setTemporalEventData(new TemporalEventData());
        Mockito.when(bodyRequest.getDefinition()).thenReturn(definition);
        Diction diction = new Diction();
        diction.setPronunciation("Koffi");
        diction.setTemporalEventData(new TemporalEventData());
        Mockito.when(bodyRequest.getDiction()).thenReturn(diction);
        Etymology etymology = new Etymology();
        etymology.setOrigin("Côte D'ivoire");
        etymology.setTemporalEventData(new TemporalEventData());
        Mockito.when(bodyRequest.getEtymologie()).thenReturn(etymology);
        GeoLocation geoLocation = new GeoLocation();
        geoLocation.setRegion("Centre de la Côte D'ivoire");
        geoLocation.setTemporalEventData(new TemporalEventData());
        Mockito.when(bodyRequest.getGeoLocation()).thenReturn(geoLocation);
        MediaLink mediaLink = new MediaLink();
        mediaLink.setUri("http://www.dembesi.org");
        mediaLink.setTemporalEventData(new TemporalEventData());
        Mockito.when(bodyRequest.getMediaLink()).thenReturn(mediaLink);
    }

    @Test
    public void submittedName() {
        ApiResponse apiResponse = facadeDictionary.submittedName(bodyRequest, API_VERSION);
        assertTrue(apiResponse instanceof GreatResponse);
    }

    @Test
    public void submitNameDefinition() {
        ApiResponse apiResponse = facadeDictionary.submitNameDefinition(bodyRequest, API_VERSION);
        assertTrue(apiResponse instanceof GreatResponse);
    }

    @Test
    public void submitNameDiction() {
        ApiResponse apiResponse = facadeDictionary.submitNameDiction(bodyRequest, API_VERSION);
        assertTrue(apiResponse instanceof GreatResponse);
    }

    @Test
    public void submitNameEtymology() {
        ApiResponse apiResponse = facadeDictionary.submitNameEtymology(bodyRequest, API_VERSION);
        assertTrue(apiResponse instanceof GreatResponse);
    }

    @Test
    public void submitNameGeoLocation() {
        ApiResponse apiResponse = facadeDictionary.submitNameGeoLocation(bodyRequest, API_VERSION);
        assertTrue(apiResponse instanceof GreatResponse);
    }

    @Test
    public void submitMediaLink() {
        ApiResponse apiResponse = facadeDictionary.submitMediaLink(bodyRequest, API_VERSION);
        assertTrue(apiResponse instanceof GreatResponse);
    }

    @Test
    public void submitNameWithAllInformation() {
        ApiResponse apiResponse = facadeDictionary.submitNameWithAllInformation(bodyRequest, API_VERSION);
        assertTrue(apiResponse instanceof GreatResponse);
    }

    @Test
    public void putAudioStream() {
        Diction diction = bodyRequest.getDiction();
        diction = facadeDictionary.putAudioStream(multipartFile, diction);
        assertNotNull(diction);
    }
}