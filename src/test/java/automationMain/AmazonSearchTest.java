package automationMain;

import java.util.logging.Logger;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactories.AmazonHome;
import pageFactories.AmazonResult;
import utilities.ConfigFileReader;
import utilities.ExcelUtils;

public class AmazonSearchTest {
	  WebDriver driver;
	  AmazonHome home;
	  AmazonResult result;
	  ConfigFileReader reader = new ConfigFileReader();
	  static Logger Report = Logger.getLogger(AmazonSearchTest.class.getName());
	  
	  @Test(dataProvider = "Url")
	  public void launch(String url) throws Exception{
		  DOMConfigurator.configure(reader.getLogName());
		  System.setProperty(reader.getDriverName(), reader.getDriverPath());
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  Report.info("Launching the Application");
		  driver.navigate().to(url);
		  Report.info(url + " url launched");
	  }
	  @Test(dataProvider = "search", dependsOnMethods = {"launch"})
	  public void productList(String catalog, String searchq) {
		  home = new AmazonHome(driver);
		  result = new AmazonResult(driver);
		  Report.info("Filtering for categories");
		  home.searchCatalog(catalog);
		  Report.info("Categories filtered for: " + catalog);
		  Report.info("searching for " + searchq + " input");
		  home.searchQuery(searchq);
		  Report.info("Search result found for the input " + searchq);
	  }
	  @Test(dependsOnMethods = {"productList"})
	  public void getValues() throws Exception {
		  Report.info("Getting the required information from the list");
		  ExcelUtils.writeData(result.getTitle(),2,5);
		  ExcelUtils.writeData(result.getPublishDate(),2,6);
		  ExcelUtils.writeData(result.getPublisher(),2,7);
		  ExcelUtils.writeData(result.getPaperback(),2,8);
		  ExcelUtils.writeData(result.getPaperbackPrice(),2,9);
		  ExcelUtils.writeData(result.getHardcover(),2,10);
		  ExcelUtils.writeData(result.getHardcoverPrice(),2,11);
		  ExcelUtils.writeData(result.getKindle(),2,12);
		  ExcelUtils.writeData(result.getKindlePrice(),2,13);
		  Report.info("Product Information collected");
	  }
	  @Test(dependsOnMethods = {"getValues"})
	  public void close() throws Exception {
		  Report.info("Test Script Result: " + result.getResult());
		  ExcelUtils.writeData(result.getResult(),2,4);
		  driver.close();
	  }
	  @DataProvider
	  public Object[][] Url() throws Exception {
		  ExcelUtils.setExcel(reader.getExcelPath()+reader.getExcelname(), reader.getSheetname());
		  Object[][] input = new Object[1][1];
		  input[0][0] = ExcelUtils.readData(2,1);
		  return input;
	  }
	  @DataProvider
	  public Object[][] search() throws Exception {
		  ExcelUtils.setExcel(reader.getExcelPath()+reader.getExcelname(), reader.getSheetname());
		  Object[][] input = new Object[1][2];
		  input[0][0] = ExcelUtils.readData(2,2);
		  input[0][1] = ExcelUtils.readData(2,3);
		  return input;
	  }
}
