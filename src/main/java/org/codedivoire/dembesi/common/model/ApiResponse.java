package org.codedivoire.dembesi.common.model;

/**
 * @author Christian Amani on 22/01/2019.
 */
public class ApiResponse {

    private String apiVersion;

    private StateResponse state;

    private DataResponse data;

    public ApiResponse() {
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public StateResponse getState() {
        return state;
    }

    public void setState(StateResponse state) {
        this.state = state;
    }

    public DataResponse getData() {
        return data;
    }

    public void setData(DataResponse data) {
        this.data = data;
    }
}
