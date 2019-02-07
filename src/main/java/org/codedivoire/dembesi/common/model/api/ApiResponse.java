package org.codedivoire.dembesi.common.model.api;

/**
 * @author Christian Amani on 23/01/2019.
 */
public abstract class ApiResponse {

    protected String apiVersion;

    protected StateResponse state;

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
}
