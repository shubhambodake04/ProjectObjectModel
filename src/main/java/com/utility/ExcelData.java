package com.utility;

import com.browsers.BrowserFactory;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelData extends BrowserFactory {
    static Workbook book;
    static Sheet sheet;
    //public static long PAGE_LOAD_TIMEOUT = 20;
    //public static long IMPLICIT_WAIT = 10;
    public static String TESTDATA_SHEET_PATH = "C:\\Users\\shubh\\IdeaProjects\\PageObjectModel\\src\\main\\java\\com\\utility\\LoginData.xlsx";

    public static Object[][] getTestData(String path,String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (EncryptedDocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                try {
                    data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }
    public ExcelData() throws IOException {
    }

    public void switchToFrame()
    {
        //  webdriver.switchTo().frame("mainpanel");
    }
}
