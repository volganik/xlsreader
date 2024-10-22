package org.independent.xlsreader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import lombok.extern.slf4j.Slf4j;
@Slf4j

public class XlsProcessor {

    public static void processExcelFile(String fileName) {

        Workbook workbook = null;
        log.debug("Begin process file [{}]", fileName);
        
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(fileName+".out", true));
            workbook = WorkbookFactory.create(new File(fileName));
            DataFormatter dataFormatter = new DataFormatter();

            log.info("Number of sheets: " + workbook.getNumberOfSheets());

            workbook.forEach(sheet -> {
                log.info("Sheet Name [{}]", sheet.getSheetName());

                for (Row row : sheet) {
                    log.info("Row num:{}", row.getRowNum());
                    row.forEach(
                            cell -> {
                                log.info(dataFormatter.formatCellValue(cell));
                                try {
                                    output.append(dataFormatter.formatCellValue(cell));
                                } catch (IOException e) {
                                    log.error(e.getMessage(), e);
                                }
                            });
                }
            });
            
            if (output != null) output.close();
        } catch (EncryptedDocumentException | IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (workbook != null)
                    workbook.close();
                
                    
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        log.debug("End process file [{}]", fileName);
    }
}
