package com.example.demo.services;

import com.example.demo.model.Goods;
import com.example.demo.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public Goods saveGoods(Goods goods){
        return goodsRepository.save(goods);
    }
}
