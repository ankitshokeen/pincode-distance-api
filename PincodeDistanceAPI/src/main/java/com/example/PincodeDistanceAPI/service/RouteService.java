package com.example.PincodeDistanceAPI.service;

import com.example.PincodeDistanceAPI.service.GoogleMapsService;
import com.example.PincodeDistanceAPI.model.Route;
import com.example.PincodeDistanceAPI.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private GoogleMapsService googleMapsService;

    @Cacheable("routes")
    public Route getRoute(String fromPincode, String toPincode) {
        Optional<Route> cachedRoute = routeRepository.findByFromPincodeAndToPincode(fromPincode, toPincode);
        if (cachedRoute.isPresent()) {
            return cachedRoute.get();
        }

        String routeData = googleMapsService.getRouteData(fromPincode, toPincode);
        Route newRoute = new Route();
        newRoute.setFromPincode(fromPincode);
        newRoute.setToPincode(toPincode);
        newRoute.setRouteData(routeData);
        newRoute.setTimestamp(LocalDateTime.now());

        // Extract and set distance and duration from routeData (parsing required)

        return routeRepository.save(newRoute);
    }
}
