package com.example.routesmanagement.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectID;

import javax.persistence.Embeddable;

@Embeddable
public class RouteId extends DomainObjectID {
    protected RouteId(String uuid) {
        super(uuid);
    }

    public RouteId() {
        super(RouteId.randomId(RouteId.class).getId());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
