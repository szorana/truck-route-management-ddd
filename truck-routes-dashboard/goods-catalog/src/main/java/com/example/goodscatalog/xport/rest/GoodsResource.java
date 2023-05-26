package com.example.goodscatalog.xport.rest;

import com.example.goodscatalog.domain.models.Goods;
import com.example.goodscatalog.services.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
@AllArgsConstructor
public class GoodsResource {

    private final GoodsService goodsService;

    @GetMapping
    public List<Goods> getAll(){
        return this.goodsService.findAll();
    }
}
