package org.codedivoire.dembesi.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Amani on 22/01/2019.
 */
public class ErrorResponse extends ApiResponse {

    private List<ErrorData> errors = new ArrayList<>();

    public ErrorResponse(String apiVersion, StateResponse stateResponse) {
        this.apiVersion = apiVersion;
        this.state = stateResponse;
    }

    public ErrorResponse() {
    }

    public void addError(ErrorData errorData) {
        errors.add(errorData);
    }

    public List<ErrorData> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorData> errors) {
        this.errors = errors;
    }

    public static class ErrorData {
        private String domain;
        private String reason;
        private String message;

        public ErrorData(String domain, String reason, String message) {
            this.domain = domain;
            this.reason = reason;
            this.message = message;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
