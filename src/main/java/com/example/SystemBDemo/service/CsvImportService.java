package com.example.SystemBDemo.service;


import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public interface CsvImportService {

    public List<String[]> importCsvData(Path filePath, char separator);

    public List<String[]> importCsvDataLineByLine(Path filePath);
}
