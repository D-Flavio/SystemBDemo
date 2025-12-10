package com.example.systemBDemo;

import com.example.systemBDemo.entity.CustomerCompanyPolicyEntity;
import com.example.systemBDemo.entity.OutpayHeaderEntity;
import com.example.systemBDemo.entity.ZTPSPFEntity;
import com.example.systemBDemo.repository.CustomerCompanyPolicyRepository;
import com.example.systemBDemo.repository.OutpayHeaderRepository;
import com.example.systemBDemo.repository.ZTPSPFRepository;
import com.example.systemBDemo.service.CsvImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TaskSchedulerSystemB {

    @Autowired
    private CsvImportService csvImportService;

    @Autowired
    private CustomerCompanyPolicyRepository customerCompanyPolicyRepository;

    @Autowired
    private OutpayHeaderRepository outpayHeaderRepository;

    @Autowired
    private ZTPSPFRepository ztpspfRepository;

    private static final Logger logger = LoggerFactory.getLogger(TaskSchedulerSystemB.class);

    @Scheduled(cron = "0 0 13 * * MON-FRI", zone = "Europe/Paris")
    public void importAndPersist() {
        logger.info("Start importing CSV file");

        String desktopPath = System.getProperty("user.home") + "/Desktop";
        File directory = new File(desktopPath + "/SystemAExports");

        if (directory.exists()) {
            List<String[]> customerCompanyPolicyData = csvImportService.importCsvData(Paths.get(desktopPath + "/SystemAExports/CUSTCOMP01.txt"), '|');
            customerCompanyPolicyData.stream().map(this::toCustomerCompanyPolicyEntity).forEach(customerCompanyPolicyRepository::save);
            logger.info("Customer Company Policy Data persisted successfully");

            List<String[]> outpayHeaderData = csvImportService.importCsvData(Paths.get(desktopPath + "/SystemAExports/OUTPH_CUP_20200204_1829.TXT"), ';');
            outpayHeaderData.stream().map(this::toOutpayHeaderEntity).forEach(outpayHeaderRepository::save);
            logger.info("Outpay Header Data persisted successfully");

            List<String[]> zTPSPFData = csvImportService.importCsvDataLineByLine(Paths.get(desktopPath + "/SystemAExports/ZTPSPF.TXT"));
            zTPSPFData.stream().map(this::toZTPSPFEntity).forEach(ztpspfRepository::save);
            logger.info("ZTPSPF Data persisted successfully");
        }
        logger.info("End importing CSV file");
    }

    private CustomerCompanyPolicyEntity toCustomerCompanyPolicyEntity(String[] line) {
        CustomerCompanyPolicyEntity customerCompanyPolicyEntity = new CustomerCompanyPolicyEntity(
                line[0].trim(),
                line[1].trim(),
                line[2].trim(),
                line[3].trim(),
                line[4].trim(),
                line[5].trim(),
                line[6].trim(),
                line[7].trim());

        logger.info("imported CustomerCompanyPolicyEntity: {}", customerCompanyPolicyEntity);
        return customerCompanyPolicyEntity;
    }

    private OutpayHeaderEntity toOutpayHeaderEntity(String[] line) {
        OutpayHeaderEntity outpayHeaderEntity = new OutpayHeaderEntity(
                line[0].trim(),
                line[1].trim(),
                line[2].trim(),
                LocalDate.parse(line[3].trim(), DateTimeFormatter.BASIC_ISO_DATE).atStartOfDay(),
                line[4].trim(),
                line[5].trim(),
                line[6].trim(),
                line[7].trim().isBlank() ? null : LocalDate.parse(line[7].trim(), DateTimeFormatter.BASIC_ISO_DATE).atStartOfDay(),
                BigDecimal.valueOf(Double.parseDouble(line[8].trim())),
                line[9].trim(),
                line[10].trim(),
                line[11].trim(),
                line[12].trim(),
                "",
                "",
                "",
                "",
                "",
                "",
                "", //missing from example files
                LocalDateTime.now());

        logger.info("imported OutpayHeaderEntity: {}", outpayHeaderEntity);
        return outpayHeaderEntity;
    }

    private ZTPSPFEntity toZTPSPFEntity(String[] line) {
        ZTPSPFEntity zTPSPFEntity = new ZTPSPFEntity(
                line[1].trim(),
                BigDecimal.valueOf(Double.parseDouble(line[2].trim())),
                line[0].trim(),
                "",
                LocalDateTime.now());

        logger.info("imported ZTPSPFEntity: {}", zTPSPFEntity);
        return zTPSPFEntity;
    }
}
