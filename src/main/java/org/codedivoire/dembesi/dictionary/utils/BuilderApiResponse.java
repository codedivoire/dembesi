package org.codedivoire.dembesi.dictionary.utils;

import org.codedivoire.dembesi.common.model.api.DataResponse;
import org.codedivoire.dembesi.common.model.api.ErrorResponse;
import org.codedivoire.dembesi.common.model.api.GreatResponse;
import org.codedivoire.dembesi.common.model.api.StateResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Christian Amani on 23/01/2019.
 */
@Component
public class BuilderApiResponse {

    private GreatResponse greatResponse;

    private ErrorResponse errorResponse;

    private BuilderApiResponse() {
        greatResponse = new GreatResponse();
        greatResponse.setData(new DataResponse());
        errorResponse = new ErrorResponse();
    }

    public static BuilderApiResponse builder() {
        return new BuilderApiResponse();
    }

    public BuilderApiResponse greatResponseApiVersion(String apiVersion) {
        greatResponse.setApiVersion(apiVersion);
        return this;
    }

    public BuilderApiResponse errorResponseState(String apiVersion) {
        errorResponse.setApiVersion(apiVersion);
        return this;
    }

    public BuilderApiResponse greatResponseState(StateResponse stateResponse) {
        greatResponse.setState(stateResponse);
        return this;
    }

    public BuilderApiResponse errorResponseState(StateResponse stateResponse) {
        errorResponse.setState(stateResponse);
        return this;
    }

    public BuilderApiResponse greatResponseDomain(String domain) {
        DataResponse data = greatResponse.getData();
        data.setDomain(domain);
        return this;
    }

    public BuilderApiResponse errorResponseAddErrorData(String domain, String reason, String message) {
        ErrorResponse.ErrorData errorData = new ErrorResponse.ErrorData(domain, reason, message);
        errorResponse.addError(errorData);
        return this;
    }

    public BuilderApiResponse greatResponseItem(Object item) {
        DataResponse data = greatResponse.getData();
        data.setItem(item);
        return this;
    }

    public BuilderApiResponse greatResponseItems(List<Object> items) {
        DataResponse data = greatResponse.getData();
        data.setItems(items);
        return this;
    }

    public BuilderApiResponse greatResponseAddItem(Object item) {
        DataResponse data = greatResponse.getData();
        data.getItems().add(item);
        return this;
    }

    public BuilderApiResponse greatResponseAddGroupedItem(String key, Object item) {
        DataResponse data = greatResponse.getData();
        Map groupedItems = data.getGroupedItems();
        groupedItems.put(key, item);
        return this;
    }

    public GreatResponse buildGreatResponse() {
        DataResponse data = greatResponse.getData();
        int sizeItems = data.getItems()
                .size();
        int sizeGroupedItems = data.getGroupedItems()
                .size();
        data.setTotalItems(sizeItems);
        data.setTotalGroupedItems(sizeGroupedItems);
        return greatResponse;
    }

    public ErrorResponse buildErrorResponse() {
        return errorResponse;
    }
}
