package com.example.accessfintech.controller;

import com.example.accessfintech.service.StockService;
import com.example.accessfintech.dto.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/")
    public String index() {
        return "Access Fintech Application is Up and Running :-) ";
    }



    @GetMapping("/GetLowestPrice")
    public Stock getLowestPrice(String stockName) {
        return stockService.getLowestPrice(stockName);
    }

    @GetMapping("/GetAllLowestPrices")
    public Collection<Stock> getAllLowestPrices() {
        return stockService.getAllLowestPrices();
    }



}
