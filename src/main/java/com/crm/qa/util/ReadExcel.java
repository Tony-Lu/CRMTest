package com.crm.qa.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFTextBox;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ReadExcel {
	
	public static Object[][] getTestData(String filePath, String fileName, String sheetName) throws IOException {
        //从Excel文件获取测试数据的静态方法
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        //将SimpleDateFormat类型转换成Date类型
        File file = new File(filePath+""+fileName);   //声明一个和File文件对象
        FileInputStream inputStream = new FileInputStream(file);    //创建FileInputStream对象用于读取Excel文件
        Workbook workbook = null;   //声明workbook对象
        String fileExtensionName = fileName.substring(fileName.indexOf("."));   //获取文件名的后缀
        if (fileExtensionName.equals(".xlsx"))
            workbook = new XSSFWorkbook(inputStream);   //判断如果是.xlsx，则使用XSSFWorkbook对象进行实例化
        else if (fileExtensionName.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);   //判断如果是.xls，则使用HSSFWorkbook对象进行实例化
        }

        Sheet sheet = null;
        if (workbook != null) {
            sheet = workbook.getSheet(sheetName);//通过sheetName参数，生成Sheet对象
        }

        int rowCount = 0;
        if (sheet != null) {
            rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();//Eecel文件的行号和列号都是从0开始的，相减得出列数
        }

        List<Object[]> records = new ArrayList<Object[]>(); //创建名为records的List对象来存储从Excel文件读取的数据
        for (int i = 1; i < rowCount + 1; i++) {     //遍历Excel文件的数据，从第1行开始，第0行是数据列名称
            Row row = null;
            if (sheet != null) {
                row = sheet.getRow(i);//使用getRow方法获取行对象
            }
            if (row == null) {
                continue;   //略过空行
            }
            String fields[] = new String[row.getLastCellNum()]; //声明一个数组，存储Excel文件每行的N个数据
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    try {
                        Cell cell = row.getCell(j); //cell是单元格
                        //int cellType = cell.getCellType();  //判断单元格类型
                        String cellValue;
                        switch (cell.getCellType()) {
                            case STRING://文本 Cell.CELL_TYPE_STRING
                                cellValue = cell.getStringCellValue();
                                break;
                            case NUMERIC: //日期、数字
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    cellValue = fmt.format(cell.getDateCellValue()); //日期
                                } else {
                                    cellValue = String.valueOf(cell.getNumericCellValue()); //数字
                                }
                                break;
                            case BOOLEAN: //布尔型
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case BLANK: //空白
                                cellValue = cell.getStringCellValue();
                                break;
                            case FORMULA: //公式
                                cellValue = "错误";
                                break;
                            case ERROR: //错误
                                cellValue = "错误";
                                break;
                            default:
                                cellValue = "";
                        }
                        fields[j] = cellValue;    //获取Excel文件中单元格数据
                    }catch (NullPointerException e){ //如果单元格为空的时候，则用这个来处理
                        fields[j] = "";
                    }
                }
            records.add(fields);    //将fields的数据对象存储到records的List中
        }

        if (workbook != null) {
            workbook.close();   //关闭workbook对象
        }
        inputStream.close();    //关闭inputStream对象

        Object[][] results = new Object[records.size()][]; //定义函数返回值，即Object[][]
        for (int i=0; i<records.size();i++) {                //将存储测试数据的List转换为一个人Object的二维数组
            results[i] = records.get(i);                    //设置二维数组每行的值，每行是一个Object对象
        }
        return results;
    }

	

	
	

}
