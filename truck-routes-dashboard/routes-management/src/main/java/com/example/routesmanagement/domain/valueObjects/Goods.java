package com.example.routesmanagement.domain.valueObjects;

import com.example.sharedkernel.domain.base.ValueObject;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Goods implements ValueObject {

    private final GoodsId id;
    private final String name;
    private final Money price;
    private final int sales;

    public Goods() {
        this.sales = 0;
        this.id=GoodsId.randomId(GoodsId.class);
        this.name = "";
        this.price = Money.valueOf(Currency.MKD, 0);

    }

    @JsonCreator
    public Goods(@JsonProperty("id") GoodsId id,
                 @JsonProperty("goodsName") String name,
                 @JsonProperty("price") Money price,
                 @JsonProperty("sales") int sales) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
    }
}
