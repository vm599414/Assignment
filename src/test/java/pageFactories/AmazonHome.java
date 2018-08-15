package pageFactories;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonHome {
	WebDriver driver;
	
	@FindBy(id = "searchDropdownBox")	
		WebElement searchCatagory;
	@FindBy(id = "twotabsearchtextbox")	
		WebElement searchInput;
	
	public AmazonHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchCatalog(String input) {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Select oSelect = new Select(searchCatagory);
		oSelect.selectByVisibleText(input);
	}
	public void searchQuery(String input) {
		searchInput.sendKeys(input);
		searchInput.sendKeys(Keys.ENTER);
	}
}
