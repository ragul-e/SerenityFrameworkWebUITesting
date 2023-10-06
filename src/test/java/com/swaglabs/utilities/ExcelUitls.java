package com.swaglabs.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUitls {
	
	
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	
	
	public static void putValueIntoExcel(String filepath ,List<String> productone) {
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Products");
		
		
		
//		for (int i = 0; i < producttwo.size(); i++) {
//			sheet.getRow(0).createCell(i).setCellValue(productone.get(i));
//		}
		sheet.createRow(0);
		
		sheet.getRow(0).createCell(0).setCellValue(Constant.productname);
		sheet.getRow(0).createCell(1).setCellValue(Constant.productdescription);
		sheet.getRow(0).createCell(2).setCellValue(Constant.productprice);
		sheet.getRow(0).createCell(3).setCellValue(Constant.price);
		
//		sheet.createRow(1);
		
		
		int rowcount = 1;
		int colcount = 0;
		
		for (String data : productone) {
			Row row = sheet.getRow(rowcount);
			if(row == null) {
				row = sheet.createRow(rowcount);
			}
			
			Cell cell = row.createCell(colcount);
			cell.setCellValue(data);			
			colcount++;
			
			if(colcount == 4) {
				rowcount++;
				colcount=0;
			}
		}
		
		
////		old logic
//		for (int i = 0; i < productone.size(); i++) {
//			sheet.getRow(1).createCell(i).setCellValue(productone.get(i));
//		}
		
//		sheet.createRow(2);
//		for (int i = 0; i < producttwo.size(); i++) {
//			sheet.getRow(2).createCell(i).setCellValue(producttwo.get(i));
//		}
		
		//new logic
		

//		"C:\\Users\\RA20312005\\Workspace-assignments\\SeleniumBddframeworlk\\src\\test\\java\\com\\demoautomation\\testdata\\ProductDetails.xls"
		
		File file = new File(filepath); 
		try {
			workbook.write(file);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
