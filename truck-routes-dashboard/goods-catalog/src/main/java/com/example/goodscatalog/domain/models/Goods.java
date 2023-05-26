package com.example.goodscatalog.domain.models;

import com.example.sharedkernel.domain.base.AbstractEntity;
import com.example.sharedkernel.domain.financial.Money;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "goods")
@Getter
public class Goods extends AbstractEntity<GoodsId> {

    private String goodsName;
    private int sales = 0;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name = "price_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    private Money price;

    public Goods() {
        super(GoodsId.randomId(GoodsId.class));
    }

    public static Goods build(String goodsName, Money price, int sales){
        Goods g = new Goods();
        g.goodsName = goodsName;
        g.price = price;
        g.sales = sales;
        return g;
    }
    public void addSales(int quantity){
        this.sales = this.sales - quantity;
    }

    public void removeSales(int quantity){
        this.sales -= quantity;
    }
}
