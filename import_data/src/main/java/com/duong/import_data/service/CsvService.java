package com.duong.import_data.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class CsvService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvService.class);

    public String importCsv(MultipartFile file){
        try {
            CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
            List<String[]> listLine = csvReader.readAll();
            if (!listLine.isEmpty()) {
                for (String[] line : listLine) {
                    for (String s : line){
                        System.out.println(s);
                    }
                }
            }

        } catch (IOException | CsvException e){
            LOGGER.error("Error read file CSV: ", e);
        }
        return "OK";
    }
}
