package com.example.accessfintech.service;


import com.example.accessfintech.bl.StockBL;
import com.example.accessfintech.dto.Stock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class StockServiceImpl extends StockService {
    @Autowired
    StockBL stockBL;


    public Stock getLowestPrice(String stockPrice) {

        return new Stock();

    }

    public Collection<Stock> getAllLowestPrices() {
        return stockBL.getAllLowestPrices();
    }
}
