package com.example.accessfintech.bl;

import com.example.accessfintech.dto.Stock;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;


import java.util.Collection;

@Service("stockBL")
@Configurable
public class StockBL {

    public Collection<Stock> getAllLowestPrices() {
        return null;
    }
}
