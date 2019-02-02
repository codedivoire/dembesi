package org.codedivoire.dembesi.dictionary.service;

import org.codedivoire.dembesi.common.model.ApiResponse;
import org.codedivoire.dembesi.common.model.StateResponse;
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
        name.getTemporalEventData().setCreated(LocalDateTime.now(Clock.systemUTC()));
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
        Definition definition = bodyRequest.getDefinition();
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
        Diction diction = bodyRequest.getDiction();
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
        Etymology etymology = bodyRequest.getEtymologie();
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
        GeoLocation geoLocation = bodyRequest.getGeoLocation();
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
        MediaLink mediaLink = bodyRequest.getMediaLink();
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
        Definition definition = bodyRequest.getDefinition();
        name.addDefinition(definition);
        Diction diction = bodyRequest.getDiction();
        name.addDiction(diction);
        Etymology etymology = bodyRequest.getEtymologie();
        name.addEtymology(etymology);
        GeoLocation geoLocation = bodyRequest.getGeoLocation();
        name.addGeoLocation(geoLocation);
        MediaLink mediaLink = bodyRequest.getMediaLink();
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
}
