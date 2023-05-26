package com.example.routesmanagement.service.impl;

import com.example.routesmanagement.domain.exceptions.RouteDoesNotExistException;
import com.example.routesmanagement.domain.exceptions.TruckIDDoesntExistException;
import com.example.routesmanagement.domain.models.Route;
import com.example.routesmanagement.domain.models.RouteId;
import com.example.routesmanagement.domain.models.TruckId;
import com.example.routesmanagement.domain.repository.RouteRepository;
import com.example.routesmanagement.service.RouteService;
import com.example.routesmanagement.service.forms.RouteForm;
import com.example.routesmanagement.service.forms.TruckForm;
import com.example.sharedkernel.domain.financial.Currency;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final Validator validator;

    @Override
    public RouteId markRouteAsFinished(RouteForm routeForm) {
        Objects.requireNonNull(routeForm, "route must not be null. ");
        var constraintVal = validator.validate(routeForm);
        if (constraintVal.size()>0){
            throw new ConstraintViolationException("The route form is not valid.", constraintVal);
        }
        var newRoute = routeRepository.saveAndFlush(toDomainObj(routeForm));
        return newRoute.getId();
    }

    private Route toDomainObj(RouteForm form){
        var route = new Route(Instant.now(), form.getCurrency());
        form.getTrucks().forEach(item -> route.addTruck(item.getGoods(), item.getQuantity()));
        return route;
    }

    @Override
    public List<Route> findAll() {
        return this.routeRepository.findAll();
    }

    @Override
    public Optional<Route> findById(RouteId routeId) {
        return this.routeRepository.findById(routeId);
    }

    @Override
    public void addRoute(RouteId routeId, TruckForm truckForm) throws RouteDoesNotExistException {
        Route route = routeRepository.findById(routeId).orElseThrow(RouteDoesNotExistException::new);
        route.addTruck(truckForm.getGoods(), truckForm.getQuantity());
        routeRepository.saveAndFlush(route);
    }

    @Override
    public void deleteRoute(RouteId routeId, TruckId truckId) throws RouteDoesNotExistException, TruckIDDoesntExistException {
        Route route = routeRepository.findById(routeId).orElseThrow(RouteDoesNotExistException::new);
        route.removeTruck(truckId);
        routeRepository.saveAndFlush(route);
    }
}
