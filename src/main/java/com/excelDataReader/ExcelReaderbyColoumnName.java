package com.excelDataReader;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderbyColoumnName {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\user\\Downloads\\test.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("login");
		XSSFRow row=sheet.getRow(0);
		XSSFCell cell;
		int lastrow=row.getLastCellNum();
		System.out.println("last data row="+lastrow);
		int rowindex=-1;
		
		  for(int i=0;i<row.getLastCellNum();i++)
		    {
		      if(row.getCell(i).getStringCellValue().trim().equals("UserName"))
		      
		       rowindex=i;
		 }
		   row=sheet.getRow(3);
		   cell=row.getCell(rowindex);
		   String val = cell.getStringCellValue();
		   System.out.println(val);
		   wb.close(); 
		   fis.close();

	}

}
