package com.example.goodscatalog.domain.repository;

import com.example.goodscatalog.domain.models.Goods;
import com.example.goodscatalog.domain.models.GoodsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository  extends JpaRepository<Goods, GoodsId> {
}
