package com.codemonster.guides.travellers;

import com.codemonster.exceptions.GoogleMapDirectionNotFoundException;
import com.codemonster.libs.maps.google.GoogleMapsUtils;
import com.codemonster.maps.GoogleMapDirectionDetails;

public class Main {

    public static void main(String[] args) {
        GoogleMapsUtils googleMapsUtils = new GoogleMapsUtils();
        try {
            GoogleMapDirectionDetails googleMapDirectionDetails = googleMapsUtils.getDirectionDetails("Nairobi",
                    "Mombasa","AIzaSyA20SJMIV1ck_-i_Eu8nXm0kPXcG9pK69I");

        } catch (GoogleMapDirectionNotFoundException e) {
            e.printStackTrace();
            System.err.println(String.format("GoogleMapDirectionNotFoundException - %s", e.getMessage()));
        }
    }
}
