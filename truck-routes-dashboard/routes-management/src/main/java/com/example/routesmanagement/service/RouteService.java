package com.example.routesmanagement.service;

import com.example.routesmanagement.domain.exceptions.RouteDoesNotExistException;
import com.example.routesmanagement.domain.exceptions.TruckIDDoesntExistException;
import com.example.routesmanagement.domain.models.Route;
import com.example.routesmanagement.domain.models.RouteId;
import com.example.routesmanagement.domain.models.TruckId;
import com.example.routesmanagement.service.forms.RouteForm;
import com.example.routesmanagement.service.forms.TruckForm;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    //placeOrder
    RouteId markRouteAsFinished(RouteForm routeForm);
    List<Route> findAll();
    Optional<Route> findById(RouteId routeId);

    void addRoute(RouteId routeId, TruckForm truckForm) throws RouteDoesNotExistException;

    void deleteRoute(RouteId routeId, TruckId truckId) throws RouteDoesNotExistException, TruckIDDoesntExistException;

}
