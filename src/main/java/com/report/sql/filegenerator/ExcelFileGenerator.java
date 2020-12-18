package com.report.sql.filegenerator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ExcelFileGenerator {
    private static final Logger log = LoggerFactory.getLogger(ExcelFileGenerator.class);

    public XSSFWorkbook generateExcelFile(List<Map<String, Object>> rows, String sReportType)  {

        log.debug("Row count -> {}", rows.size());
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sReportType);

        int rowCount = 0;
        int columnCount = 0;
        if (!rows.isEmpty()){
            Map<String,Object> mapHeaderColumn = rows.get(1);
            Row row = sheet.createRow(rowCount++);
            for (String columnName : mapHeaderColumn.keySet()) {
                Cell cell = row.createCell(columnCount++);
                cell.setCellValue(String.valueOf(columnName));
            }
        }

        // Freezing header column.
        sheet.createFreezePane(0, 1);
        for (Map<String,Object> data: rows) {
            Row row = sheet.createRow(rowCount++);
            columnCount = 0;
            for (Map.Entry<String, Object> entrySet : data.entrySet()) {
                Cell cell = row.createCell(columnCount++);
                Object rowValue = data.get(entrySet.getKey());
                if (rowValue instanceof String) {
                    cell.setCellValue((String) rowValue);
                } else if (rowValue instanceof Integer) {
                    cell.setCellValue((Integer) rowValue);
                }else {
                    cell.setCellValue(String.valueOf(rowValue));
                }
            }
        }
        return workbook;
    }
}
