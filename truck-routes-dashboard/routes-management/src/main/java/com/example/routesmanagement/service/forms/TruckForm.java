package com.example.routesmanagement.service.forms;

import com.example.routesmanagement.domain.valueObjects.Goods;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class TruckForm {

    @NotNull
    private Goods goods;

    @Min(1)
    private int quantity = 1;

}
