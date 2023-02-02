package Generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This is for used to Excel values 
 * @author Rajesh
 * 
 *
 */
public class Excel_utility {
   public String ExcelValues(String Sheetname, int Row, int cell) throws Exception, IOException
   {    FileInputStream exfis = new FileInputStream("./src/test/resources/rajesh.xlsx");
	 Workbook book = WorkbookFactory.create(exfis);
	 Sheet sh = book.getSheet(Sheetname);
	  Row r = sh.getRow(Row);
	   Cell c = r.getCell(cell);
	   String edata =   c.getStringCellValue();
	   return edata;
   }
}
