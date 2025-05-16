package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile); // Opens the Excel file
		wb = new XSSFWorkbook(fi); // This reads the entire Excel file and loads it into a wb (workbook) object.
		ws = wb.getSheet(xlsheet); // Accesses the specified sheet
		int rowCount = ws.getLastRowNum(); // Gets the last row number (0-based index)
		wb.close(); // Closes the workbook
		fi.close(); // Closes the file input stream
		return rowCount; // Returns the row count
	}
	public static int getCellCount(String xlfile, String xlsheet,int rowNum) throws IOException {
		fi = new FileInputStream(xlfile); // Opens the Excel file
		wb = new XSSFWorkbook(fi); // This reads the entire Excel file and loads it into a wb (workbook) object.
		ws = wb.getSheet(xlsheet); // Accesses the specified sheet
		row = ws.getRow(rowNum); // Gets the row at the given index
		int cellCount = row.getLastCellNum(); //Returns the total number of cells in that row (1-based index)
		wb.close(); // Closes the workbook
		fi.close(); // Closes the file input stream
		return cellCount; // Returns the row count
	}

	public static String getCellData(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlfile); // Opens the Excel file
		wb = new XSSFWorkbook(fi); // Loads the workbook
		ws = wb.getSheet(xlsheet); // Retrieves the specified sheet
		row = ws.getRow(rowNum); // Gets the specified row
		cell = row.getCell(colNum); // Gets the specified cell
		String data;
		try {
			// data=cell.toString();
			// or
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);// Using DataFormatter to fetch cell value as a String

		} catch (Exception e) {
			data = ""; // If any exception occurs, return an empty string
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setCellData(String xlfile, String xlsheet, int rowNum, int colNum, String data)
			throws IOException {

		fi = new FileInputStream(xlfile); // Opens the Excel file
		wb = new XSSFWorkbook(fi); // Loads the workbook
		ws = wb.getSheet(xlsheet); // Retrieves the specified sheet
		row = ws.getRow(rowNum); // Gets the specified row
		cell = row.createCell(colNum); // Creates a new cell (if it doesn’t exist)
		cell.setCellValue(data); // Sets the cell value
		fo = new FileOutputStream(xlfile); // Opens the file in write mode
		wb.write(fo); // ensures that the new data is saved.
		wb.close();
		fi.close();
		fo.close();
	}

	public static void fillGreenColor(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {

		fi = new FileInputStream(xlfile); // Opens the Excel file
		wb = new XSSFWorkbook(fi); // Loads the workbook
		ws = wb.getSheet(xlsheet); // Retrieves the specified sheet
		row = ws.getRow(rowNum); // Gets the specified row
		cell = row.getCell(colNum); // Retrieves the cell (does NOT create a new one if it doesn’t exist)

		style = wb.createCellStyle(); // Creates a new CellStyle object
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); // Sets the fill color to GREEN
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // Applies solid fill
		cell.setCellStyle(style); // Applies the style to the cell

		fo = new FileOutputStream(xlfile); // Opens the file in write mode
		wb.write(fo); // ensures that the new data is saved.
		wb.close();
		fi.close();
		fo.close();
	}
	public static void fillRedColor(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {

		fi = new FileInputStream(xlfile); // Opens the Excel file
		wb = new XSSFWorkbook(fi); // Loads the workbook
		ws = wb.getSheet(xlsheet); // Retrieves the specified sheet
		row = ws.getRow(rowNum); // Gets the specified row
		cell = row.getCell(colNum); // Retrieves the cell (does NOT create a new one if it doesn’t exist)

		style = wb.createCellStyle(); // Creates a new CellStyle object
		style.setFillForegroundColor(IndexedColors.RED.getIndex()); // Sets the fill color to GREEN
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // Applies solid fill
		cell.setCellStyle(style); // Applies the style to the cell

		fo = new FileOutputStream(xlfile); // Opens the file in write mode
		wb.write(fo); // ensures that the new data is saved.
		wb.close();
		fi.close();
		fo.close();
	}
}
