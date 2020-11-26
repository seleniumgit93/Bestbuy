package excelLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel {
	
	static String EXCELFILELOCATION="C:\\Users\\user\\Downloads\\test.xlsx";

	public static void main(String[] args) throws Exception  {
		
		File  file=new File(EXCELFILELOCATION);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet  =workbook.getSheet("people");
	    int rowCount = sheet.getLastRowNum();
	  //  int colCount = sheet.getRow(0).getLastCellNum();
	   
	    
		
		  for(int i=1;i<=rowCount;i++) 
	{ 
		  XSSFCell cell = sheet.getRow(i).getCell(1);
		  String celltext="";
		 // System.out.println(cell);
		  
 //get the CellType value
		  
		  if(cell.getCellTypeEnum()==CellType.STRING)
		  {
		  celltext=cell.getStringCellValue();
		  System.out.println(celltext);
		  }
		  else if(cell.getCellTypeEnum()==CellType.NUMERIC) 
		  {
		  celltext=String.valueOf(cell.getNumericCellValue());
		  System.out.println(celltext);
		  } 
		  else if(cell.getCellTypeEnum()==CellType.BLANK) 
		  { 
			  celltext=""; 
			  System.out.println(celltext);
		  } 
		  
		  //check the age &set the cell value into excel
		  
		  if(Double.parseDouble(celltext)>=18) {
			  
			  cell= sheet.getRow(i).getCell(2);
			  if(cell == null)
				  cell=sheet.getRow(i).createCell(2);
			     cell.setCellValue("Major");
	 
	           
		   
		  } 
		  else 
		  {   cell= sheet.getRow(i).getCell(2);
		  if(cell == null)
			  cell=sheet.getRow(i).createCell(2);
		     cell.setCellValue("Minor");
		  } 
	 }
		  
		  fis.close();
		  
		  FileOutputStream fos=new FileOutputStream(EXCELFILELOCATION);
		  workbook.write(fos); 
		  workbook.close();
		  fos.close();
		 
	   
	    

	}

	}

