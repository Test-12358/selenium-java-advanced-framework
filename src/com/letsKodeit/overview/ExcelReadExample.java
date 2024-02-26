package com.letsKodeit.overview;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadExample {
	public static void main(String args[]){
		XSSFWorkbook ExcelWBook;
		XSSFSheet ExcelWSheet;
		XSSFCell ExcelCell;
		String path = System.getProperty("user.dir")+"/TestData/ExampleData.xlsx";
		String sheetname = "Scenario1";
		try{
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetname);
			ExcelCell = ExcelWSheet.getRow(0).getCell(0);
			String cellData = ExcelCell.getStringCellValue();
			System.out.println("Cell Data Value is : "+cellData);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
