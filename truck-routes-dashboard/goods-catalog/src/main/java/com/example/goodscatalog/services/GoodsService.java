package com.example.goodscatalog.services;

import com.example.goodscatalog.domain.models.Goods;
import com.example.goodscatalog.domain.models.GoodsId;
import com.example.goodscatalog.domain.valueObjects.Quantity;
import com.example.goodscatalog.services.forms.GoodsForm;

import java.util.List;
import java.util.Optional;

public interface GoodsService {

    List<Goods> findAll();
    Goods findById(GoodsId goodsId);
    Goods createGoods(GoodsForm form);
    Goods goodsCreated(GoodsId goodsId, int quantity);
    Goods goodsRemoved(GoodsId goodsId, int quantity);


}
