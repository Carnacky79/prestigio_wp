import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

import static org.apache.poi.ss.usermodel.Cell.*;

public class ExcelClass {
    private File exelFile;
    public ExcelClass(String file) throws IOException {
        this.exelFile = new File(file);

/*
        // Get iterator to all the rows in current sheet
        Iterator<Row> rowIterator = mySheet.iterator();

        // Traversing over each row of XLSX file
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    default :

                }
            }
            System.out.println("");
        }*/
    }

    public HashMap<String, ArrayList<String[]>> leggiFogli() throws IOException {
        HashMap<String,  ArrayList<String[]>> fogli = new HashMap<>();

        FileInputStream fis = new FileInputStream(this.exelFile);

        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);

        for(int i=0;i<myWorkBook.getNumberOfSheets();i++){
            XSSFSheet myS = myWorkBook.getSheetAt(i);
            String sheetName = myS.getSheetName();
            ArrayList<String[]> righe = null;

            // Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = myS.iterator();

            righe = new ArrayList<>();
            // Traversing over each row of XLSX file
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String[] celleRiga = new String[6];


                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                int c = 0;
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case STRING:
                            celleRiga[c] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            celleRiga[c] = Double.toString(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            celleRiga[c] = Boolean.toString(cell.getBooleanCellValue());
                            break;
                        default :

                    }
                    c++;
                }

            righe.add(celleRiga);

            }

            fogli.put(sheetName,righe);

        }


        return fogli;
    }
}
