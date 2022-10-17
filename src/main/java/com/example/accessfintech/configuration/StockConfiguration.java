package com.example.accessfintech.configuration;

import com.example.accessfintech.service.StockService;
import com.example.accessfintech.service.StockServiceImpl;
import com.example.accessfintech.bl.StockBL;
import com.example.accessfintech.bl.StockBLImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class StockConfiguration {

    @Bean
    public StockService stockService() {
        return new StockServiceImpl();
    }

    @Bean
    public StockBL stockBL() {
        return new StockBLImpl();
    }

//    @Bean
//    public ModelMapper modelMapper() {return new ModelMapper();}








}



