package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.common.model.ApiResponse;
import org.codedivoire.dembesi.common.model.StateResponse;
import org.codedivoire.dembesi.common.model.TemporalEventData;
import org.codedivoire.dembesi.dictionary.entity.*;
import org.codedivoire.dembesi.dictionary.model.NameBodyRequest;
import org.codedivoire.dembesi.dictionary.utils.BuilderApiResponse;
import org.codedivoire.dembesi.dictionary.utils.RequiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author Christian Amani on 23/01/2019.
 */
@Service
public class FacadeDictionaryService {

    private final Logger LOG = LoggerFactory.getLogger(FacadeDictionaryService.class);

    private final String DOMAIN = "dictionary";

    private final NameService nameService;

    private final DictionService dictionService;

    @Autowired
    public FacadeDictionaryService(NameService nameService, DictionService dictionService) {
        this.nameService = nameService;
        this.dictionService = dictionService;
    }


    public ApiResponse submittedName(NameBodyRequest bodyRequest, String apiVersion) {
        LOG.debug("Debut du Process 'submittedName'");
        Name name = bodyRequest.getName();
        TemporalEventData temporalEventData = name.getTemporalEventData();
        temporalEvent(temporalEventData);
        Optional<Name> optionalName = nameService.save(name);
        if (optionalName.isPresent()) {
            return optionalName.map(value -> BuilderApiResponse.builder()
                    .greatResponseApiVersion(apiVersion)
                    .greatResponseDomain(DOMAIN)
                    .greatResponseItem(value)
                    .greatResponseState(StateResponse.success)
                    .buildGreatResponse()).get();
        } else {
            return buildFailResponseName(apiVersion);
        }
    }

    public ApiResponse submitNameDefinition(NameBodyRequest bodyRequest, String apiVersion) {
        LOG.debug("Debut du Process 'submitNameDefinition'");
        Name name = bodyRequest.getName();
        TemporalEventData temporalEventData = name.getTemporalEventData();
        temporalEvent(temporalEventData);
        Definition definition = bodyRequest.getDefinition();
        TemporalEventData temporalEventDataDefinition = definition.getTemporalEventData();
        temporalEvent(temporalEventDataDefinition);
        name.addDefinition(definition);
        Optional<Name> optionalName = nameService.save(name);
        if (optionalName.isPresent()) {
            return optionalName.map(value -> BuilderApiResponse.builder()
                    .greatResponseApiVersion(apiVersion)
                    .greatResponseDomain(DOMAIN)
                    .greatResponseItem(value)
                    .greatResponseAddGroupedItem("definition", definition)
                    .greatResponseState(StateResponse.success)
                    .buildGreatResponse()).get();
        } else {
            return buildFailResponseName(apiVersion);
        }
    }

    public ApiResponse submitNameDiction(NameBodyRequest bodyRequest, String apiVersion) {
        LOG.debug("Debut du Process 'submittedDiction'");
        Name name = bodyRequest.getName();
        TemporalEventData temporalEventData = name.getTemporalEventData();
        temporalEvent(temporalEventData);
        Diction diction = bodyRequest.getDiction();
        TemporalEventData temporalEventDataDiction = diction.getTemporalEventData();
        temporalEvent(temporalEventDataDiction);
        name.addDiction(diction);
        Optional<Name> optionalName = nameService.save(name);
        if (optionalName.isPresent()) {
            return optionalName.map(value -> BuilderApiResponse.builder()
                    .greatResponseApiVersion(apiVersion)
                    .greatResponseDomain(DOMAIN)
                    .greatResponseItem(value)
                    .greatResponseAddGroupedItem("diction", diction)
                    .greatResponseState(StateResponse.success)
                    .buildGreatResponse()).get();
        } else {
            return buildFailResponseName(apiVersion);
        }
    }

    public ApiResponse submitNameEtymology(NameBodyRequest bodyRequest, String apiVersion) {
        LOG.debug("Debut du Process 'submitNameEtymology'");
        Name name = bodyRequest.getName();
        TemporalEventData temporalEventData = name.getTemporalEventData();
        temporalEvent(temporalEventData);
        Etymology etymology = bodyRequest.getEtymologie();
        TemporalEventData temporalEventDataEtymology = etymology.getTemporalEventData();
        temporalEvent(temporalEventDataEtymology);
        name.addEtymology(etymology);
        Optional<Name> optionalName = nameService.save(name);
        if (optionalName.isPresent()) {
            return optionalName.map(value -> BuilderApiResponse.builder()
                    .greatResponseApiVersion(apiVersion)
                    .greatResponseDomain(DOMAIN)
                    .greatResponseItem(value)
                    .greatResponseAddGroupedItem("etymology", etymology)
                    .greatResponseState(StateResponse.success)
                    .buildGreatResponse()).get();
        } else {
            return buildFailResponseName(apiVersion);
        }
    }

    public ApiResponse submitNameGeoLocation(NameBodyRequest bodyRequest, String apiVersion) {
        LOG.debug("Debut du Process 'submitNameGeoLocation'");
        Name name = bodyRequest.getName();
        TemporalEventData temporalEventData = name.getTemporalEventData();
        temporalEvent(temporalEventData);
        GeoLocation geoLocation = bodyRequest.getGeoLocation();
        TemporalEventData temporalEventDataGeoLocation = geoLocation.getTemporalEventData();
        temporalEvent(temporalEventDataGeoLocation);
        name.addGeoLocation(geoLocation);
        Optional<Name> optionalName = nameService.save(name);
        if (optionalName.isPresent()) {
            return optionalName.map(value -> BuilderApiResponse.builder()
                    .greatResponseApiVersion(apiVersion)
                    .greatResponseDomain(DOMAIN)
                    .greatResponseItem(value)
                    .greatResponseAddGroupedItem("geoLocation", geoLocation)
                    .greatResponseState(StateResponse.success)
                    .buildGreatResponse()).get();
        } else {
            return buildFailResponseName(apiVersion);
        }
    }

    public ApiResponse submitMediaLink(NameBodyRequest bodyRequest, String apiVersion) {
        LOG.debug("Debut du Process 'submitMediaLink'");
        Name name = bodyRequest.getName();
        TemporalEventData temporalEventData = name.getTemporalEventData();
        temporalEvent(temporalEventData);
        MediaLink mediaLink = bodyRequest.getMediaLink();
        TemporalEventData temporalEventDataMediaLink = mediaLink.getTemporalEventData();
        temporalEvent(temporalEventDataMediaLink);
        name.addMediaLink(mediaLink);
        Optional<Name> optionalName = nameService.save(name);
        if (optionalName.isPresent()) {
            return optionalName.map(value -> BuilderApiResponse.builder()
                    .greatResponseApiVersion(apiVersion)
                    .greatResponseDomain(DOMAIN)
                    .greatResponseItem(value)
                    .greatResponseAddGroupedItem("mediaLink", mediaLink)
                    .greatResponseState(StateResponse.success)
                    .buildGreatResponse()).get();
        } else {
            return buildFailResponseName(apiVersion);
        }
    }

    public ApiResponse submitNameWithAllInformation(NameBodyRequest bodyRequest, String apiVersion) {
        LOG.debug("Debut du Process 'submitNameWithAllInformation'");
        Name name = bodyRequest.getName();
        TemporalEventData temporalEventData = name.getTemporalEventData();
        temporalEvent(temporalEventData);
        Definition definition = bodyRequest.getDefinition();
        TemporalEventData temporalEventDataDefinition = definition.getTemporalEventData();
        temporalEvent(temporalEventDataDefinition);
        name.addDefinition(definition);
        Diction diction = bodyRequest.getDiction();
        TemporalEventData temporalEventDataDiction = diction.getTemporalEventData();
        temporalEvent(temporalEventDataDiction);
        name.addDiction(diction);
        Etymology etymology = bodyRequest.getEtymologie();
        TemporalEventData temporalEventDataEtymology = etymology.getTemporalEventData();
        temporalEvent(temporalEventDataEtymology);
        name.addEtymology(etymology);
        GeoLocation geoLocation = bodyRequest.getGeoLocation();
        TemporalEventData temporalEventDataGeoLocation = geoLocation.getTemporalEventData();
        temporalEvent(temporalEventDataGeoLocation);
        name.addGeoLocation(geoLocation);
        MediaLink mediaLink = bodyRequest.getMediaLink();
        TemporalEventData temporalEventDataMediaLink = mediaLink.getTemporalEventData();
        temporalEvent(temporalEventDataMediaLink);
        name.addMediaLink(mediaLink);
        Optional<Name> optionalName = nameService.save(name);
        if (optionalName.isPresent()) {
            return optionalName.map(value -> BuilderApiResponse.builder()
                    .greatResponseApiVersion(apiVersion)
                    .greatResponseDomain(DOMAIN)
                    .greatResponseItem(value)
                    .greatResponseAddGroupedItem("definition", mediaLink)
                    .greatResponseAddGroupedItem("diction", diction)
                    .greatResponseAddGroupedItem("etymology", etymology)
                    .greatResponseAddGroupedItem("geoLocation", geoLocation)
                    .greatResponseAddGroupedItem("mediaLink", mediaLink)
                    .greatResponseState(StateResponse.success)
                    .buildGreatResponse()).get();
        }
        return null;
    }

    public Diction putAudioStream(MultipartFile multipartFile, Diction diction) {
        LOG.debug("Debut du Process 'putAudioStream'");
        try {
            TemporalEventData temporalEventData = diction.getTemporalEventData();
            temporalEvent(temporalEventData);
            byte[] bytes = multipartFile.getBytes();
            diction.setAudioStream(bytes);
            Optional<Diction> optionalDiction = dictionService.save(diction);
            return optionalDiction.orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            return null;
        }
    }

    private ApiResponse buildFailResponseName(String apiVersion) {
        String message = new RequiredException("Name")
                .getMessage();
        return BuilderApiResponse.builder()
                .errorResponseState(apiVersion)
                .errorResponseState(StateResponse.fail)
                .errorResponseAddErrorData(DOMAIN, message, message)
                .buildErrorResponse();
    }

    private void temporalEvent(TemporalEventData temporalEventData) {
        if(temporalEventData.getCreated() == null) {
            temporalEventData.setCreated(LocalDateTime.now(Clock.systemUTC()));
        } else {
            temporalEventData.setUpdated(LocalDateTime.now(Clock.systemUTC()));
        }
    }
}
