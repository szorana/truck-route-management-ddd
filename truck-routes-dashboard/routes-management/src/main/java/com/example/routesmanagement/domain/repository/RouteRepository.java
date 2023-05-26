package com.example.routesmanagement.domain.repository;

import com.example.routesmanagement.domain.models.Route;
import com.example.routesmanagement.domain.models.RouteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, RouteId> {
}
