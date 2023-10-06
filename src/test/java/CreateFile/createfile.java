

package CreateFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.swaglabs.utilities.Constant;

public class createfile {
	
	
	public static HSSFWorkbook workbook;
	public static HSSFSheet sheet;
	
	public static void main(String[] args) {
		

		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet("Products");
		
		
		
//		for (int i = 0; i < producttwo.size(); i++) {
//			sheet.getRow(0).createCell(i).setCellValue(productone.get(i));
//		}
		sheet.createRow(0);
		
		sheet.getRow(0).createCell(0).setCellValue("productname");
		sheet.getRow(0).createCell(1).setCellValue("productdescription");
		sheet.getRow(0).createCell(2).setCellValue("productprice");
		sheet.getRow(0).createCell(3).setCellValue("prodd");
		
		List<String> friends = new ArrayList<String>();
		
		friends.add("ragule");
		friends.add("suriee");
		friends.add("abi");
		friends.add("ansari");
		
		
		List<String>  games = new ArrayList<String>();
		
		games.add("footba");
		games.add("boxing");
		games.add("cricket");
		games.add("Kho kho");
		
		for (int i = 0; i < games.size(); i++) {
			
			for (int j = 0; j < friends.size()-1; j++) {
				Row row = sheet.createRow(i);
				row.createCell(i).setCellValue(friends.get(i));
				
			}
		}
		
		for (int i = 1; i < friends.size(); i++) {
			Row row = sheet.createRow(i);
			
			if (i < friends.size()) {
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(friends.get(i));
            }

            if (i < games.size()) {
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(friends.get(i));
            }
		}
		
		
		
		
//		sheet.createRow(1);
		
		
		
		
		
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
		
		File file = new File("C:\\Users\\RA20312005\\Documents\\22-23 Poc\\swaglabs\\src\\test\\java\\Useless\\myfile.xls"); 
		try {
			workbook.write(file);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
