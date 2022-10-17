package com.example.accessfintech;

import com.example.accessfintech.bl.StockBL;
import com.example.accessfintech.controller.StockController;
import com.example.accessfintech.dao.StockRepository;
import com.example.accessfintech.dto.Stock;
import com.example.accessfintech.dto.StockCsvRecord;
import com.example.accessfintech.entity.StockEntity;
import com.example.accessfintech.service.StockService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;



@SpringBootApplication
@ComponentScan(basePackageClasses = {StockController.class, StockService.class, StockBL.class, Stock.class, org.modelmapper.ModelMapper.class})
@EntityScan(basePackageClasses = {StockEntity.class})
@EnableJpaRepositories(basePackageClasses = {StockRepository.class})
@EnableScheduling
public class Stock3Application implements CommandLineRunner  {


    public static void main(String[] args) {
        SpringApplication.run(Stock3Application.class, args);
    }

    @Override
    public void run(String[] args) throws IOException, ParseException {

        readSources();


    }

    @Scheduled(fixedDelay=20000)
    private void readSources() throws IOException {
        File file = new File("C:\\JAVA_PROJECTS\\AccessFintech3\\src\\main\\resources\\stocks.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Object read = JsonPath.read(file,"[*]" );

        Collection<Stock> records = objectMapper.readValue(String.valueOf(read), new TypeReference<Collection<Stock>>() {});

        //System.out.println(records);


        //////////////////////////////////////

        JsonNode jsonNode = readRemoteJsonFile("http://s3.amazonaws.com/test-data-samples/stocks.json");
        ObjectMapper mapper = new ObjectMapper();
        Collection<Stock> result = mapper.convertValue(jsonNode, new TypeReference<Collection<Stock>>(){});
        //System.out.println(result);


        ///////////////////////////


        String fileName = "C:\\JAVA_PROJECTS\\AccessFintech3\\src\\main\\resources\\stocks.csv";

        List<StockCsvRecord> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(StockCsvRecord.class)
                .build()
                .parse();

        //beans.forEach(System.out::println);
    }

    private static JsonNode readRemoteJsonFile(String source) throws IOException {

//        JsonObject json = new JsonObject();
//        JsonObject asJsonObject = json.getAsJsonObject(IOUtils.toString(new URL(source), Charset.forName("UTF-8")));

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new URL(source));
        // System.out.println(jsonNode.toString());
        return jsonNode;

    }



}


