package org.codedivoire.dembesi.dictionary.restcontroller;

import org.codedivoire.dembesi.common.model.api.ApiResponse;
import org.codedivoire.dembesi.common.model.api.ErrorResponse;
import org.codedivoire.dembesi.common.model.api.StateResponse;
import org.codedivoire.dembesi.dictionary.model.NameBodyRequest;
import org.codedivoire.dembesi.dictionary.service.FacadeDictionaryService;
import org.codedivoire.dembesi.dictionary.utils.BuilderApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Christian Amani on 17/02/2019.
 */
@RestController
@RequestMapping("api/v0/dictionary")
public class DictionaryRestController {

    private final Logger LOG = LoggerFactory.getLogger(DictionaryRestController.class);
    private String API_VERSION = "v0";

    private final FacadeDictionaryService facadeDictionaryService;

    @Autowired
    public DictionaryRestController(FacadeDictionaryService facadeDictionaryService) {
        this.facadeDictionaryService = facadeDictionaryService;
    }

    @PostMapping("/submitted/name")
    public ResponseEntity<ApiResponse> submittedNamePost(@RequestBody NameBodyRequest nameBody) {
        LOG.debug("Debut du Process 'submittedNamePost'");
        ApiResponse apiResponse = facadeDictionaryService.submittedName(nameBody, API_VERSION);
        return returnApiResponse(apiResponse);
    }

    @PostMapping("/submitted/definition")
    public ResponseEntity<ApiResponse> submittedDefinitionPost(@RequestBody NameBodyRequest definitionBody) {
        LOG.debug("Debut du Process 'submittedDefinitionPost'");
        ApiResponse apiResponse = facadeDictionaryService.submitNameDefinition(definitionBody, API_VERSION);
        return returnApiResponse(apiResponse);
    }

    @PostMapping("/submitted/diction")
    public ResponseEntity<ApiResponse> submittedDictionPost(@RequestBody NameBodyRequest dictionBody) {
        LOG.debug("Debut du Process 'submittedDictionPost'");
        ApiResponse apiResponse = facadeDictionaryService.submitNameDiction(dictionBody, API_VERSION);
        return returnApiResponse(apiResponse);
    }

    @PostMapping("/submitted/etymology")
    public ResponseEntity<ApiResponse> submittedEtymologyPost(@RequestBody NameBodyRequest etymologyBody) {
        LOG.debug("Debut du Process 'submittedEtymologyPost'");
        ApiResponse apiResponse = facadeDictionaryService.submitNameEtymology(etymologyBody, API_VERSION);
        return returnApiResponse(apiResponse);
    }

    @PostMapping("/submitted/geolocation")
    public ResponseEntity<ApiResponse> submittedGeoLocationPost(@RequestBody NameBodyRequest geoLocationBody) {
        LOG.debug("Debut du Process 'submittedGeoLocationPost'");
        ApiResponse apiResponse = facadeDictionaryService.submitNameGeoLocation(geoLocationBody, API_VERSION);
        return returnApiResponse(apiResponse);
    }

    @PostMapping("/submitted/medialink")
    public ResponseEntity<ApiResponse> submittedMediaLinkPost(@RequestBody NameBodyRequest mediaLinkBody) {
        LOG.debug("Debut du Process 'submittedMediaLinkPost'");
        ApiResponse apiResponse = facadeDictionaryService.submitMediaLink(mediaLinkBody, API_VERSION);
        return returnApiResponse(apiResponse);
    }

    @PostMapping("/submitted/name/all/details")
    public ResponseEntity<ApiResponse> submittedNameWithAllDetails(@RequestBody NameBodyRequest nameBodyRequest) {
        LOG.debug("Debut du Process 'submittedNameWithAllDetails'");
        ApiResponse apiResponse = facadeDictionaryService.submitNameWithAllInformation(nameBodyRequest, API_VERSION);
        return returnApiResponse(apiResponse);
    }

    @PostMapping(value = "/submitted/name/diction/{id}/audio", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ApiResponse> submittedDictionAudio(@PathVariable long id, MultipartFile multipartFile) {
        LOG.debug("Debut du Process 'submittedDictionAudio'");
        ApiResponse apiResponse = facadeDictionaryService.putAudioStream(id, multipartFile, API_VERSION);
        return returnApiResponse(apiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleError(Exception exception) {
        LOG.debug("Debut du Process 'handleError'");
        ErrorResponse errorResponse = BuilderApiResponse.builder()
                .errorResponseState(API_VERSION)
                .errorResponseState(StateResponse.fail)
                .errorResponseAddErrorData("dictionary", exception.getMessage(), exception.getLocalizedMessage())
                .buildErrorResponse();
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ApiResponse> returnApiResponse(ApiResponse apiResponse) {
        if (apiResponse.getState() == StateResponse.success)
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        else
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
