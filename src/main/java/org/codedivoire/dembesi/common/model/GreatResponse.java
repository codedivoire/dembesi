package org.codedivoire.dembesi.common.model;

/**
 * @author Christian Amani on 22/01/2019.
 */
public class GreatResponse extends ApiResponse{

    private DataResponse data;

    public GreatResponse(String apiVersion,StateResponse stateResponse,DataResponse data) {
        this.apiVersion = apiVersion;
        this.state = stateResponse;
        this.data = data;
    }

    public GreatResponse() {
    }

    public DataResponse getData() {
        return data;
    }

    public void setData(DataResponse data) {
        this.data = data;
    }
}
