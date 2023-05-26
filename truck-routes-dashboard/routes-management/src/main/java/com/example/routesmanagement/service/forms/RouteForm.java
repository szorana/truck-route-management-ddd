package com.example.routesmanagement.service.forms;

import com.example.sharedkernel.domain.financial.Currency;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class RouteForm {

    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<TruckForm> trucks = new ArrayList<>();

}
