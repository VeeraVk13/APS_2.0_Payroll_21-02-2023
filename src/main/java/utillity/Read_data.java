package utillity;

import constant.APS_contsant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Read_data{

    private List<String> usernamelist = new ArrayList<String>();
    private List<String> passwordlist = new ArrayList<String>();

    public FileInputStream loadExcel() {
        String Excelpath = APS_contsant.EXCELPATH;
        try {
            FileInputStream file = new FileInputStream(Excelpath);
            return file;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void readExcel(Workbook file) {

        XSSFWorkbook Workbook = new XSSFWorkbook();
        XSSFSheet sheet = Workbook.getSheetAt(0);

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
    }

    public List<String> getUsernamelist() {
        return usernamelist;
    }

    public void setUsernamelist(List<String> usernamelist) {
        this.usernamelist = usernamelist;
    }

    public List<String> getPasswordlist() {
        return passwordlist;
    }

    public void setPasswordlist(List<String> passwordlist) {
        this.passwordlist = passwordlist;
    }
}
