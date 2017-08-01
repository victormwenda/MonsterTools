package com.codemonster.exceptions;

import java.io.IOException;

public class GoogleMapDirectionNotFoundException extends IOException {

    public GoogleMapDirectionNotFoundException(String exception) {
        super(exception);
    }
}
