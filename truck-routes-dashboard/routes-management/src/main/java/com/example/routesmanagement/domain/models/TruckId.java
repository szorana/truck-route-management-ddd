package com.example.routesmanagement.domain.models;

import com.example.sharedkernel.domain.base.DomainObjectID;

import java.util.Objects;

public class TruckId extends DomainObjectID {
    protected TruckId(String uuid) {
        super(uuid);
    }

    private TruckId() {
        super(TruckId.randomId(TruckId.class).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TruckId)) return false;
        TruckId truckId = (TruckId) o;
        return Objects.equals(getId(), truckId.getId());
    }
}
