package com.example.demo.services;

import com.example.demo.exeptions.GoodsIdException;
import com.example.demo.model.Goods;
import com.example.demo.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public Goods saveGoods(Goods goods){
        try {
            goods.setCode(goods.getCode().toUpperCase());
            return goodsRepository.save(goods);
        } catch (Exception e){
            throw new GoodsIdException("Goods Id '" + goods.getCode().toUpperCase() + "' already exists");
        }
    }

    public Goods findGoodsByCode(String goodsCode){
        Goods goods = goodsRepository.findByCode(goodsCode.toUpperCase());

        if (goods == null){
            throw new GoodsIdException("Goods Id does not exists");
        }

        return goods;
    }
}
