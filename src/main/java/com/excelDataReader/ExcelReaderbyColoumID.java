package com.excelDataReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderbyColoumID {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\user\\Downloads\\test.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("login");
		XSSFRow row=sheet.getRow(2);
		 XSSFCell cell =row.getCell(1);
	      String val =cell.getStringCellValue(); 
	      System.out.println(val);

	      wb.close();
			 fis.close();
	}

}
