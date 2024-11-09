package com.example.PincodeDistanceAPI.controller;

import com.example.PincodeDistanceAPI.model.Route;
import com.example.PincodeDistanceAPI.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/distance")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public Route getDistance(
            @RequestParam String fromPincode,
            @RequestParam String toPincode) {
        return routeService.getRoute(fromPincode, toPincode);
    }
}
