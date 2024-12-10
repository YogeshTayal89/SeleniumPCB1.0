package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import basepack.BaseClass;

public class ExcelUtility extends BaseClass {

	// Method to load the Excel file data
	public static String getReadData(int rownum, int colnum, int sheetnum) {
		String value = "";
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\IGT_player_testdata.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(sheetnum);
			value = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
		} catch (IOException e) {
			// Handle IOException if needed
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// Handle IOException if needed
					e.printStackTrace();
				} finally {
					// Additional cleanup code if needed
				}
			}
		}

		return value;
	}
}
