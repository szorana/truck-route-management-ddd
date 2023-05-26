package com.example.routesmanagement.domain.models;

import com.example.routesmanagement.domain.valueObjects.GoodsId;
import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.base.DomainObjectID;
import com.example.sharedkernel.domain.financial.Money;
import lombok.Getter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "trucks")
@Getter
public class Truck extends AbstractEntity<TruckId> {

    private Money price;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id", column = @Column(name = "goods_id", nullable = false))
    private GoodsId goodsId;

    public Truck(@NonNull GoodsId goodsId,
                 @NonNull Money price,
                 int qty) {
        super(DomainObjectID.randomId(TruckId.class));
        this.goodsId = goodsId;
        this.price = price;
        this.quantity = qty;
    }

    public Truck() {
        super(DomainObjectID.randomId(TruckId.class));
    }

    public Money subTotal(){
        return price.multiply(quantity);
    }

}
