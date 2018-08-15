package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
		
		static ConfigFileReader reader;
		private static XSSFSheet wSheet;
		private static XSSFWorkbook wBook;
		private static XSSFCell Cell;
		private static XSSFRow Row;
		public static void setExcel(String Path,String SheetName) throws Exception {
			try {
			FileInputStream fis = new FileInputStream(Path);
			wBook = new XSSFWorkbook(fis);
			wSheet = wBook.getSheet(SheetName);
			} catch (Exception e){
				throw (e);
			}
		}
		public static String readData(int RowNum, int ColNum) throws Exception{
			try{
  			Cell = wSheet.getRow(RowNum).getCell(ColNum);
  			String CellData = Cell.getStringCellValue();
  			return CellData;
  			}catch (Exception e){
				return"";
  			}
		}
		public static void writeData(String input, int RowNum, int ColNum) throws Exception	{
			try{
				reader = new ConfigFileReader();
				Row = wSheet.getRow(RowNum);
				Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
				if(Cell == null) {
					Cell = Row.createCell(ColNum);
					Cell.setCellValue(input);
				}
				else {
					Cell.setCellValue(input);
				}
				FileOutputStream fos = new FileOutputStream(reader.getExcelPath()+reader.getExcelname());
  				wBook.write(fos);
  				fos.flush();
  				fos.close();
				}
			catch(Exception e){
					throw (e);
			}
		}
}
