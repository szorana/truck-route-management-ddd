package com.example.goodscatalog.domain.valueObjects;

import com.example.sharedkernel.domain.base.ValueObject;
import javax.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Quantity implements ValueObject {

    private final int quantity;

    protected Quantity(){
        this.quantity = 0;
    }
}
