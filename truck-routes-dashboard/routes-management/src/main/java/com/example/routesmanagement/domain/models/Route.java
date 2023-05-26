package com.example.routesmanagement.domain.models;

import com.example.routesmanagement.domain.valueObjects.Goods;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;
import com.example.sharedkernel.domain.financial.Currency;
import lombok.Getter;
import lombok.NonNull;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "routes")
@Getter
public class Route extends AbstractEntity<RouteId> {

    /*
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    Preminuva vo method
    private Money price;
    */

    private String location;
    private Instant date_from;

    @Enumerated(value = EnumType.STRING)
    private RouteState state;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "route_currency")
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,
    fetch = FetchType.EAGER)
    private Set<Truck> trucksList = new HashSet<>();

    public Route(){
        super(RouteId.randomId(RouteId.class));
    }

    public Route(Instant date_from, Currency currency) {
        this.location = "location";
        this.date_from = date_from;
        this.currency = currency;
    }

    public Money total(){
        return trucksList.stream().map(Truck::subTotal).reduce(new Money(currency,0),Money::add);
    }

    public void removeTruck(@NonNull TruckId truckId){
        Objects.requireNonNull(truckId, "truckId must not be null");
        trucksList.removeIf(m -> m.getId().equals(truckId));
    }

    public Truck addTruck(@NonNull Goods goods, int qty){
        Objects.requireNonNull(goods, "goods must not be null");
        var truck = new Truck(goods.getId(), goods.getPrice(), qty);
        trucksList.add(truck);
        return truck;
    }

}
