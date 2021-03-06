package com.example.demo.controllers;

import com.example.demo.model.Goods;
import com.example.demo.services.GoodsService;
import com.example.demo.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewGoods(@Valid @RequestBody Goods goods, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        goodsService.saveGoods(goods);
        return new ResponseEntity<Goods>(goods, HttpStatus.CREATED);
    }

    @GetMapping("/{goodsCode}")
    public ResponseEntity<?> getGoodsByCode(@PathVariable String goodsCode){
        Goods goods = goodsService.findGoodsByCode(goodsCode);

        return new ResponseEntity<Goods>(goods, HttpStatus.OK);
    }

    @GetMapping("")
    public Iterable<Goods> getAllGoods(){
        return goodsService.findAllGoods();
    }

    @DeleteMapping("/{goodsCode}")
    public void deleteGoods(@PathVariable String goodsCode){
        goodsService.deleteGoodsFromCode(goodsCode);
    }

    
}
