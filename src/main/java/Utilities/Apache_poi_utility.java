package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

public class Apache_poi_utility {

	public static FileInputStream str=null;
	public static String url=System.getProperty("user.dir") +"/src/main/java/Testdata/Forms2.xls"; 
	public static HSSFWorkbook wb=null;
	public static HSSFSheet ws=null;
	public static int sheetcount;
	public  void File_Method() throws Exception
	{
		str=new FileInputStream(url);
		wb=new HSSFWorkbook(str);
		sheetcount=wb.getNumberOfSheets();
		System.out.println(sheetcount);
		test();
	}
	public static  Object test()
	{
		Object data = null;
		ws=wb.getSheetAt(0);
		for(int i=0;i<rowcount()+1;i++)	
		{
			HSSFRow row=ws.getRow(i);
			for (int j=0;j<colcount();j++)
			{
				HSSFCell cell=row.getCell(j);

				System.out.println(cell);
				data=CellToString(cell);
			}
		}
		return data;
	}


	private static Object CellToString(HSSFCell cell) {
		CellType Type=cell.getCellType();
		Object result = null;
		switch(Type)
		{
		case NUMERIC :
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				result = dateFormat.format(cell.getDateCellValue());
			} else {
				Double value = cell.getNumericCellValue();
				Long longValue = value.longValue();
				result = new String(longValue.toString());
			}
			break;
		case STRING:
			result=cell.getStringCellValue();
			break;
		default :
			//System.out.println(cell.getCellStyle());
			throw new RuntimeException("Unsupported cell.");			
		}

		return result.toString();
	}


	public static int rowcount()
	{
		int rowcount=ws.getLastRowNum();
		return rowcount;
	}


	public static int colcount()
	{
		int colcount=ws.getRow(0).getLastCellNum();
		return colcount;
	}
}
