package com.example.systemBDemo.service;


import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public interface CsvImportService {

    List<String[]> importCsvData(Path filePath, char separator);

    List<String[]> importCsvDataLineByLine(Path filePath);
}
