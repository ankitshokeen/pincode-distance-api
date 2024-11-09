package com.example.PincodeDistanceAPI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleMapsService {

    @Value("${google.maps.api.key}")
    private String apiKey;

    public String getRouteData(String fromPincode, String toPincode) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins="
                + fromPincode + "&destinations=" + toPincode + "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
