package com.example.PincodeDistanceAPI.service;

import com.example.PincodeDistanceAPI.model.Route;
import com.example.PincodeDistanceAPI.repository.RouteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RouteServiceTest {

    @Autowired
    private RouteService routeService;

    @Autowired
    private RouteRepository routeRepository;

    @Test
    public void testRouteCaching() {
        Route route1 = routeService.getRoute("141106", "110060");
        Route route2 = routeService.getRoute("141106", "110060");

        Mockito.verify(routeRepository, Mockito.times(1)).findByFromPincodeAndToPincode("141106", "110060");
    }
}
