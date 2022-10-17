package com.example.accessfintech.bl;

import com.example.accessfintech.dao.StockRepository;
import com.example.accessfintech.dto.Stock;
import com.example.accessfintech.entity.StockEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class StockBLImpl extends StockBL {

    @Autowired
    StockRepository repository;

    ModelMapper modelMapper;

    public Collection<Stock> getAllLowestPrices() {
        Iterable<StockEntity> all = repository.findAll();
        Collection<Stock> result = new ArrayList<>();
        for (StockEntity stockEntity:all) {
            result.add(modelMapper.map(stockEntity,Stock.class));
        }
        return result;
    }
}
