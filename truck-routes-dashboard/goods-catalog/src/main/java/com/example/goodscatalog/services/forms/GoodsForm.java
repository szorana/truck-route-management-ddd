package com.example.goodscatalog.services.forms;

import com.example.sharedkernel.domain.financial.Money;
import lombok.Data;
import javax.validation.constraints.Min;

@Data
public class GoodsForm {

    //annotations
    private String goodName;
    private Money price;

    @Min(1)
    private int sales;
}
