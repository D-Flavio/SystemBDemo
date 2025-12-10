package com.example.SystemBDemo;

import com.example.SystemBDemo.entity.CustomerCompanyPolicyEntity;
import com.example.SystemBDemo.entity.OutpayHeaderEntity;
import com.example.SystemBDemo.entity.ZTPSPFEntity;
import com.example.SystemBDemo.repository.CustomerCompanyPolicyRepository;
import com.example.SystemBDemo.repository.OutpayHeaderRepository;
import com.example.SystemBDemo.repository.ZTPSPFRepository;
import com.example.SystemBDemo.service.CsvImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private CsvImportService csvImportService;

    @Autowired
    private CustomerCompanyPolicyRepository customerCompanyPolicyRepository;

    @Autowired
    private OutpayHeaderRepository outpayHeaderRepository;

    @Autowired
    private ZTPSPFRepository ztpspfRepository;

    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 10000)
    public void importAndPersist() {
        //cron = "0 12 * * ?", zone = "Europe/Paris" run every day at noon europe/paris time

        System.out.println("importAndPersist started");

        String desktopPath = System.getProperty("user.home") + "/Desktop";
        File directory = new File(desktopPath + "/SystemAExports");

        if (directory.exists()){
            Path customerfilePath = Paths.get(desktopPath + "/SystemAExports/CUSTCOMP01.txt");
            Path outpayFilePath = Paths.get(desktopPath + "/SystemAExports/OUTPH_CUP_20200204_1829.TXT");
            Path survaluesFilePath = Paths.get(desktopPath + "/SystemAExports/ZTPSPF.TXT");

            List<String[]> list1 = csvImportService.importCsvData(customerfilePath, '|');
            List<CustomerCompanyPolicyEntity> policyEntities = new ArrayList<>();
            for (int i = 1; i < list1.size(); i++) {
                System.out.println(Arrays.toString(list1.get(i)));
            }
            for (String[] csvData : list1) {
                CustomerCompanyPolicyEntity customerCompanyPolicyEntity = toCustomerCompanyPolicyEntity(csvData);
                policyEntities.add(customerCompanyPolicyEntity);
                System.out.println(customerCompanyPolicyEntity.toString());
            }

            customerCompanyPolicyRepository.saveAll(policyEntities);

            System.out.println();
            System.out.println();
            List<String[]> list2 = csvImportService.importCsvData(outpayFilePath, ';');
            List<OutpayHeaderEntity> outpayHeaderEntities = new ArrayList<>();
            for (int i = 1; i < list2.size(); i++) {
                System.out.println(Arrays.toString(list2.get(i)));
            }
            for (String[] csvData : list2) {
                OutpayHeaderEntity outpayHeaderEntity = toOutpayHeaderEntity(csvData);
                outpayHeaderEntities.add(outpayHeaderEntity);
                System.out.println(outpayHeaderEntity.toString());
            }

            outpayHeaderRepository.saveAll(outpayHeaderEntities);

            System.out.println();
            System.out.println();
            List<String[]> list3 = csvImportService.importCsvDataLineByLine(survaluesFilePath);
            List<ZTPSPFEntity> ztpspfEntities = new ArrayList<>();
            for (int i = 1; i < list3.size(); i++) {
                System.out.println(Arrays.toString(list3.get(i)));
            }
            for (String[] csvData : list3) {
                ZTPSPFEntity zTPSPFEntity = toZTPSPFEntity(csvData);
                ztpspfEntities.add(zTPSPFEntity);
                System.out.println(zTPSPFEntity.toString());
            }

            ztpspfRepository.saveAll(ztpspfEntities);
        }
        System.out.println("importAndPersist ended");
    }

    private CustomerCompanyPolicyEntity toCustomerCompanyPolicyEntity(String[] line) {
        return new CustomerCompanyPolicyEntity(
                line[0].trim(),
                line[1].trim(),
                line[2].trim(),
                line[3].trim(),
                line[4].trim(),
                line[5].trim(),
                line[6].trim(),
                line[7].trim()
        );
    }

    private OutpayHeaderEntity toOutpayHeaderEntity(String[] line) {
        return new OutpayHeaderEntity(
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
    }

    private ZTPSPFEntity toZTPSPFEntity(String[] line) {
        return new ZTPSPFEntity(
                line[1].trim(),
                BigDecimal.valueOf(Double.parseDouble(line[2].trim())),
                line[0].trim(),
                "",
                LocalDateTime.now());
    }
}
