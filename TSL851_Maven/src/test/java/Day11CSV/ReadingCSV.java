package Day11CSV;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class ReadingCSV {
	@Test
	public void f() throws Exception {
		CSVReader cs = new CSVReader(new FileReader("C:\\Users\\atulj\\Documents\\SampleCSV.csv"));
//		List<String[]> allData = cs.readAll();
//		for (int i = 1; i < allData.size(); i++) {
//			String[] rows = allData.get(i);
//			for (int j = 0; j < rows.length; j++) {
//				System.out.println(rows[j]);
//
//			}
//		}
		String[] row;
		while ((row = cs.readNext()) != null) {
			for (int i = 0; i < row.length; i++) {
				System.out.println(row[i]);
			}
		}
		
		
		//TRY FrontAccouting Data Drivern Testing Using CSV
	}
}
