package com.example.routesmanagement.service;

import com.example.routesmanagement.xport.client.GoodsClient;
import com.example.routesmanagement.domain.exceptions.RouteDoesNotExistException;
import com.example.routesmanagement.domain.models.Route;
import com.example.routesmanagement.domain.models.RouteId;
import com.example.routesmanagement.domain.valueObjects.Goods;
import com.example.routesmanagement.domain.valueObjects.GoodsId;
import com.example.routesmanagement.service.forms.RouteForm;
import com.example.routesmanagement.service.forms.TruckForm;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RouteServiceImplTests {

    @Autowired
    private RouteService routeService;
    @Autowired
    private GoodsClient goodsClient;

    private static Goods newGoods(String name, Money price, int sales){
        Goods ng = new Goods(GoodsId.randomId(GoodsId.class), name, price, sales);
        return ng;
    }

    @Test
    public void testMarkRouteAsFinished(){
        TruckForm truck1 = new TruckForm();
        truck1.setGoods(newGoods("Drinks", Money.valueOf(Currency.MKD, 1500), 0));
        truck1.setQuantity(1);

        TruckForm truck2 = new TruckForm();
        truck2.setGoods(newGoods("Food", Money.valueOf(Currency.MKD, 200), 0));
        truck2.setQuantity(2);

        RouteForm route = new RouteForm();
        route.setCurrency(Currency.MKD);
        route.setTrucks(Arrays.asList(truck1,truck2));

        RouteId newRouteId = routeService.markRouteAsFinished(route);
        Route newRoute = routeService.findById(newRouteId)
                .orElseThrow(RouteDoesNotExistException::new);
        Assertions.assertEquals(newRoute.total(), Money.valueOf(Currency.MKD,1900));

    }

    @Test
    public void testPlaceOrderWithRealData() {
        List<Goods> goodsList = goodsClient.getAll();
        System.out.println(goodsList);
    }




}
