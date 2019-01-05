package com.example.demo.repositories;

import com.example.demo.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    Goods findByCode(String goodsCode);

    @Override
    List<Goods> findAll();
}
