package com.example.SystemBDemo;

import com.example.SystemBDemo.service.CsvImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Component
public class Scheduler {

    @Autowired
    private CsvImportService csvImportService;

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
            for (int i = 1; i < list1.size(); i++) {
                System.out.println(Arrays.toString(list1.get(i)));
            }
            System.out.println();
            System.out.println();
            List<String[]> list2 = csvImportService.importCsvData(outpayFilePath, ';');
            for (int i = 1; i < list2.size(); i++) {
                System.out.println(Arrays.toString(list2.get(i)));
            }
            System.out.println();
            System.out.println();
            List<String[]> list3 = csvImportService.importCsvDataLineByLine(survaluesFilePath);
            for (int i = 1; i < list3.size(); i++) {
                System.out.println(Arrays.toString(list3.get(i)));
            }
        }


        System.out.println("importAndPersist ended");
    }
}
