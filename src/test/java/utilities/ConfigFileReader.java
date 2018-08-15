package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "configs//config.properties";
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public String getDriverPath() {
		String driverpath = properties.getProperty("driver_path");
		if(driverpath!= null) 
			return driverpath;
		else throw new RuntimeException("Driver path not configured");
	}
	public String getDriverName() {
		String drivername = properties.getProperty("driver_name");
		if(drivername!= null) 
			return drivername;
		else throw new RuntimeException("Driver name not configured");
	}
	public String getExcelPath() {
		String excelpath = properties.getProperty("excel_path");
		if(excelpath!= null) 
			return excelpath;
		else throw new RuntimeException("Excel path not configured");
	}
	public String getExcelname() {
		String excelname = properties.getProperty("excel_name");
		if(excelname!= null) 
			return excelname;
		else throw new RuntimeException("Excel Name not configured");
	}
	public String getSheetname() {
		String sheetname = properties.getProperty("sheet_name");
		if(sheetname!= null) 
			return sheetname;
		else throw new RuntimeException("Sheet name not configured");
	}
	public String getLogName() {
		String logfile = properties.getProperty("logfile");
		if(logfile!= null) 
			return logfile;
		else throw new RuntimeException("Log4j.xml file not configured");
	}
}
