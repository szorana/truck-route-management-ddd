package com.example.goodscatalog.services.impl;

import com.example.goodscatalog.domain.models.Goods;
import com.example.goodscatalog.domain.models.GoodsId;
import com.example.goodscatalog.domain.repository.GoodsRepository;
import com.example.goodscatalog.domain.valueObjects.Quantity;
import com.example.goodscatalog.services.GoodsService;
import com.example.goodscatalog.services.forms.GoodsForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import com.example.goodscatalog.domain.exceptions.GoodsNotFoundException;

@Service
@Transactional
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository repository;

    @Override
    public List<Goods> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Goods findById(GoodsId goodsId) {
        return this.repository.findById(goodsId).orElseThrow(GoodsNotFoundException::new);
    }

    @Override
    public Goods createGoods(GoodsForm form) {
        Goods g = Goods.build(form.getGoodName(), form.getPrice(),form.getSales());
        repository.save(g);
        return g;
    }

    @Override
    public Goods goodsCreated(GoodsId goodsId, int quantity) {
        Goods g = repository.findById(goodsId).orElseThrow(GoodsNotFoundException::new);
        g.addSales(quantity);
        repository.saveAndFlush(g);
        return g;
    }

    @Override
    public Goods goodsRemoved(GoodsId goodsId, int quantity) {
        Goods g = repository.findById(goodsId).orElseThrow(GoodsNotFoundException::new);
        g.removeSales(quantity);
        repository.saveAndFlush(g);
        return g;
    }
}
