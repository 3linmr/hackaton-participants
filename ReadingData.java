package application;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingData {
	
	public static void main(String[] args) throws Exception {
		ArrayList info = new ArrayList();
		XSSFWorkbook wb = new XSSFWorkbook(
				new FileInputStream("C:\\Users\\Aziz\\Downloads\\CompetitionsParticipations.xlsx"));
		Sheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) { // For each Row.
			Cell cell = row.getCell(1); 
			info.add(cell);
			
		}
		
		

	}
}