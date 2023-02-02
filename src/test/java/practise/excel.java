package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		  FileInputStream fis = new FileInputStream("./src/main/resources/assign.xlsx");
		  Workbook wo =  WorkbookFactory.create(fis);
		 Sheet s = wo.getSheet("Sheet1");
		  DataFormatter df = new DataFormatter();
		  
		  for(int i =0; i<=s.getLastRowNum(); i++)
		  {
			    Row r = s.getRow(i);
			    
			    for(int j=0; j<=r.getLastCellNum(); j++)
			    {
			    	String data = df.formatCellValue( r.getCell(j));
			    	System.out.println(data);
			    }
		  }
	}

}
