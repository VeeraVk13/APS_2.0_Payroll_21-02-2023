package utillity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.APS_contsant;

public class Read_data {

	private List<String> usernamelist = new ArrayList<String>();
	private List<String> passwordlist = new ArrayList<String>();

	public FileInputStream loadExcel() {
		String Excelpath = System.getProperty("user.dir") + APS_contsant.EXCELPATH;
		try {
			FileInputStream file = new FileInputStream(Excelpath);
			XSSFWorkbook Workbook = new XSSFWorkbook();
			XSSFSheet sheet = Workbook.getSheet("wrong employee");

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row rowValue = rowIterator.next();
				Iterator<Cell> columnIteatore = rowValue.iterator();
				int i = 2;

				while (columnIteatore.hasNext()) {
					if (i % 2 == 0) {
						usernamelist.add(columnIteatore.next().getStringCellValue());
					} else {
						passwordlist.add(columnIteatore.next().getStringCellValue());
					}
				}
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return null;

	}

	public static void main(String[] args) {
		Read_data a = new Read_data();
		a.loadExcel();
	}
}
