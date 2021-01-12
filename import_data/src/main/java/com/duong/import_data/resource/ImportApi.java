package com.duong.import_data.resource;

import com.duong.import_data.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1")
public class ImportApi {
    @Autowired
    private CsvService csvService;

    @PostMapping("/import-csv")
    public ResponseEntity importCsv(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(csvService.importCsv(file));
    }
}
