package com.example.demo.controllers;

import com.example.demo.model.Goods;
import com.example.demo.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("")
    public ResponseEntity<Goods> createNewGoods(@RequestBody Goods goods){
        System.out.println("goods " + goods);
        return new ResponseEntity<Goods>(goods, HttpStatus.CREATED);
    }


}
