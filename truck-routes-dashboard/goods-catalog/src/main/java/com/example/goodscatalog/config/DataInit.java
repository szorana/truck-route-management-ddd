package com.example.goodscatalog.config;

import com.example.goodscatalog.domain.models.Goods;
import com.example.goodscatalog.domain.repository.GoodsRepository;
import com.example.sharedkernel.domain.financial.Currency;
import com.example.sharedkernel.domain.financial.Money;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInit {

    private final GoodsRepository goodsRepository;

    @PostConstruct
    public void initData() {
        Goods p1 = Goods.build("Hrana1", Money.valueOf(Currency.MKD,500), 10);
        Goods p2 = Goods.build("Mebel1", Money.valueOf(Currency.MKD,100), 5);
        if (goodsRepository.findAll().isEmpty()) {
            goodsRepository.saveAll(Arrays.asList(p1,p2));
        }
    }

}
