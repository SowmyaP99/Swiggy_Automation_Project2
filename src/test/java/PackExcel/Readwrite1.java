package PackExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.Home.HomePage;

public class Readwrite1 {
	
	HomePage pom = new HomePage();
	WebDriver driver = new EdgeDriver();
	
	public void excel() {
		pom.home(driver);
		pom.location1(driver);
		pom.locationclick(driver);
		pom.search(driver);
		pom.searchitem(driver);
		pom.ItemName(driver);
		pom.ItemPrice(driver);
		String[] name = pom.ItemName(driver);
		String[] price = pom.ItemPrice(driver);
		
		
		
//		
		String Inpath = "C:\\Users\\sowparth\\excels\\LoginDataOriginal.xlsx";
		String OpPath = "C:\\Users\\sowparth\\excels\\Resultdata.xlsx";
		
		
		
		FileInputStream inputStream;
		FileOutputStream outputstream;
		try {
			inputStream = new FileInputStream(new File(Inpath));
			outputstream = new FileOutputStream(new File(OpPath));
			 Workbook workbook = WorkbookFactory.create(inputStream);
			  Sheet sheet = workbook.getSheet("Login");
			  int lastRowNum = sheet.getLastRowNum();
			  System.out.println(lastRowNum);
			  int cnt=0;
			  for(int i=1;i<=lastRowNum ; i++) {
				  Row row = sheet.getRow(i);
//				  Cell cellID = row.getCell(0);
				  Cell cellName = row.createCell(1);
				  Cell cellPrice = row.createCell(2);
				  String string1 = name[cnt];
				  cellName.setCellValue(string1);
				  cellPrice.setCellValue(price[cnt]);
				  
				  String val = string1+(i-1);
				  String val1 = price[cnt]+(i-1);
				  System.out.println(val);
				  System.out.println(val1);
				  cnt++;

				  
			  }
			  
			  workbook.write(outputstream);
			  outputstream.close();
			  workbook.close();
			  

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
		
		
		
	
		
	 
		
	}


