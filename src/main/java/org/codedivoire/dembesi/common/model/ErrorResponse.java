package org.codedivoire.dembesi.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christian Amani on 22/01/2019.
 */
public class ErrorResponse {

    private String message;

    private StateResponse state;

    private List<ErrorData> errors = new ArrayList<>();

    public class ErrorData {
        public String domain;
        public String reason;
        public String message;
    }
}
