package com.example.systemBDemo.service.impl;

import com.example.systemBDemo.service.CsvImportService;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CsvImportServiceImpl implements CsvImportService {

    private static final Logger logger = LoggerFactory.getLogger(CsvImportServiceImpl.class);

    //TODO problem: linebreak is being read as an entry.
    public List<String[]> importCsvData(Path filePath, char separator) {
        try (Reader reader = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-2"))) {
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(separator)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build()) {
                return csvReader.readAll();
            } catch (CsvException e) {
                logger.error(e.getMessage());
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new UncheckedIOException(e);
        }
    }

    public List<String[]> importCsvDataLineByLine(Path filePath) {
        try (var lines = Files.lines(Path.of(filePath.toString()))) {
            return lines.map(this::lineData).toList();
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new UncheckedIOException(e);
        }
    }

    private String[] lineData(String line) {
        return new String[] {line.substring(0, 1),
                             line.substring(1, 9),
                             line.substring(9, 24),
                             line.substring(24, 44),
                             line.substring(44, 54),
                             line.substring(54, 70)};
    }
}
