package utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	Workbook wb;

	public ExcelReader(String fileNameWithLocation) {
		try {
			if (fileNameWithLocation.endsWith(".xls")) {

				wb = new HSSFWorkbook(new FileInputStream(fileNameWithLocation));
			} else if (fileNameWithLocation.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(new FileInputStream(fileNameWithLocation));
			} else {

				System.out.println("Invalid File Type");
			}
		} catch (Exception E) {
			System.out.println("Error in File Reading " + E.getMessage());
		}
	}

	public String readCellData(String sheetName, int row, int col) {
		String data = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		return data;
	}
	
	public int rowNumbers(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum()+1;
	}
	public int colNumbers(String sheetName) {
		return wb.getSheet(sheetName).getRow(0).getLastCellNum();
	}
}
