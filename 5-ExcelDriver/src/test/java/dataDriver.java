import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriver {
	
	public ArrayList<String> getData(String testcaseName) throws IOException {
		/*
		Create object of XSSFWorkbook class 
		Get access to Sheet 
		Get access to all rows in sheet 
		Access to specific row from all rows
		Get access to all cells of a row
		Access the data from excel into array */
	//fileInputStream argument
	ArrayList<String> a=new ArrayList<String>();

	FileInputStream fis=new FileInputStream("//Users//shahad//Downloads//demoData.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	int sheets=workbook.getNumberOfSheets();
	
	//identify the (test cases) column y scanning the entire 1st row
	//once column is identified then scan entire (test cases) column  identify purchase test case row
	//after grabbing purchase test case grab it's data
	
	for(int i=0;i<sheets;i++){
	if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1")){
	XSSFSheet sheet=workbook.getSheetAt(i);
	
	//Identify Test cases column by scanning the entire 1st row

	Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
	Row firstrow= rows.next();
	Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
	int k=0;
	int coloumn = 0;
	while(ce.hasNext()){
	Cell value=ce.next();
	if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
	coloumn=k;

	k++;}
	System.out.println(coloumn);

	////once column is identified then scan entire test case column to identify purchase test case row
	while(rows.hasNext()){
	Row r=rows.next();

	if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)){

	// after you grab purchase test case row = pull all the data of that row and feed into test
	Iterator<Cell>  cv=r.cellIterator();
	while(cv.hasNext()){
	Cell c= cv.next();
	a.add(c.getStringCellValue());
		}}
	}

}}
	return a;

	}
	
}
