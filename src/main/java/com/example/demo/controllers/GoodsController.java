package com.example.demo.controllers;

import com.example.demo.model.Goods;
import com.example.demo.services.GoodsService;
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

    @PostMapping("")
    public ResponseEntity<?> createNewGoods(@Valid @RequestBody Goods goods, BindingResult result){

        if (result.hasErrors()){

            Map<String, String> errorMap = new HashMap<>();

            for (FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        goodsService.saveGoods(goods);
        return new ResponseEntity<Goods>(goods, HttpStatus.CREATED);
    }
}
