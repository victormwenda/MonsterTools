package com.codemonster.libs.maps.google;

import com.codemonster.exceptions.GoogleMapDirectionNotFoundException;
import com.codemonster.libs.net.GoogleMapsHttpExecutor;
import com.codemonster.libs.net.URLBuilder;
import com.codemonster.maps.GoogleMapDirectionDetails;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class GoogleMapsUtils {

    public GoogleMapDirectionDetails getDirectionDetails(String origin, String destination, String googleMapKey) throws GoogleMapDirectionNotFoundException {
        String url = "https://maps.googleapis.com/maps/api/directions/json";
        URLBuilder urlBuilder = new URLBuilder(url);
        String builtGetUrl   = urlBuilder.append("origin", origin).append("destination", destination).append("key", googleMapKey).buildUpon();
        System.out.println(builtGetUrl);
        try {
            String rawJSON = new GoogleMapsHttpExecutor(builtGetUrl, "").doGetHttpRequest();
            System.err.println(rawJSON);
            JSONParser jsonParser = new JSONParser();
            Object objJSON = jsonParser.parse(rawJSON);
            JSONObject serverJSON = (JSONObject) objJSON;
            System.out.println(serverJSON.get("geocoded_waypoints")); //Getting an element - geocoded_waypoints
            return new GoogleMapDirectionDetails();
        } catch (IOException e) {
            throw new GoogleMapDirectionNotFoundException(String.format("IOException- %s", e.getMessage()));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new GoogleMapDirectionNotFoundException(String.format("ParseException- %s", e.getMessage()));
        }
    }
}
