package com.example.accessfintech.dao;

import com.example.accessfintech.entity.StockEntity;
import org.springframework.data.repository.CrudRepository;


public interface StockRepository extends CrudRepository<StockEntity, Long> {


}
