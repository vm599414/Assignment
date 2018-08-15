package pageFactories;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class AmazonResult {
	//Implementing POM as PageFactory
	WebDriver driver;
	@FindBy(xpath = "//*[@id='s-results-list-atf']//li[1]//h2")
		WebElement bookTitle;
	@FindBy(xpath = "//*[@id='s-results-list-atf']//li[1]//h2//parent::a//following-sibling::span[3]")
		WebElement bookPublishDate;
	@FindBy(xpath = "//*[@id='s-results-list-atf']//li[1]//span[contains(text(),'by')]/following-sibling::span")
		WebElement bookPublish;
	@FindBy(xpath = "//*[@id='s-results-list-atf']//li[1]//h3[@data-attribute = 'Paperback']")
		WebElement bookPaperback;
	@FindBy(xpath = "//*[@id='s-results-list-atf']//li[1]//h3[@data-attribute = 'Paperback']/parent::a/parent::div/following-sibling::div//span[2]")
		WebElement bookPaperbackPrice;
	@FindBy(xpath = "//*[@id='s-results-list-atf']//li[1]//h3[@data-attribute = 'Hardcover']")
		WebElement bookHardcover;
	@FindBy(xpath = "//*[@id='s-results-list-atf']//li[1]//h3[@data-attribute = 'Hardcover']/parent::a/parent::div/following-sibling::div//span[2]")
		WebElement bookHardcoverPrice;
	@FindBy(xpath = "//*[@id='s-results-list-atf']//li[1]//h3[@data-attribute = 'Kindle Edition']")
		WebElement bookKindle;
	@FindBy(xpath = "//*[@id='s-results-list-atf']//li[1]//h3[@data-attribute = 'Kindle Edition']/parent::a/parent::div/following-sibling::div//span[2]")
		WebElement bookKindlePrice;
	//Constructing the Class for Accessing the Driver class
	public AmazonResult(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	//Get the Title of the book
	public String getTitle() {
		try {
			Assert.assertEquals(true, bookTitle.isDisplayed());
			return bookTitle.getText();
		}
		catch(NoSuchElementException nsee) {
			return "No Element Present";
		}
	}
	//Get the Published date of the book
	public String getPublishDate() {
		try {
			Assert.assertEquals(true, bookPublishDate.isDisplayed());
			return bookPublishDate.getText();
		}
		catch(NoSuchElementException nsee) {
			return "No Element Present";
		}
	}
	//Get the Publisher of the book
	public String getPublisher() {
		try {
			Assert.assertEquals(true, bookPublish.isDisplayed());
			return bookPublish.getText();
		}
		catch(NoSuchElementException nsee) {
			return "No Element Present";
		}
	}
	//Get the Paperback result of the book
	public String getPaperback() {
		try {
			Assert.assertEquals(true, bookPaperback.isDisplayed());
			return "Available";
		}
		catch(NoSuchElementException nsee) {
			return "No Element Present";
		}
	}
	//Get the paperback price of the book
	public String getPaperbackPrice() {
		try {
			Assert.assertEquals(true, bookPaperbackPrice.isDisplayed());
			return bookPaperbackPrice.getText();
		}
		catch(NoSuchElementException nsee) {
			return "No Element Present";
		}
	}
	//Get the Hardcover result of the book
	public String getHardcover() {
		try {
			Assert.assertEquals(true, bookHardcover.isDisplayed());
			return "Available";
		}
		catch(NoSuchElementException nsee) {
			return "No Element Present";
		}
	}
	//Get the Hardcover price of the book
	public String getHardcoverPrice() {
		try {
			Assert.assertEquals(true, bookHardcoverPrice.isDisplayed());
			return bookHardcoverPrice.getText();
		}
		catch(NoSuchElementException nsee) {
			return "No Element Present";
		}
	}
	//Get the Kindle result of the book
	public String getKindle() {
		try {
			Assert.assertEquals(true, bookKindle.isDisplayed());
			return "Available";
		}
		catch(NoSuchElementException nsee) {
			return "No Element Present";
		}
	}
	////Get the Kindle price of the book
	public String getKindlePrice() {
		try {
			Assert.assertEquals(true, bookKindlePrice.isDisplayed());
			return bookKindlePrice.getText();
		}
		catch(NoSuchElementException nsee) {
			return "No Element Present";
		}
	}
	//Get the Test Result based on Book Title
	public String getResult() {
		try {
			Assert.assertEquals(true, bookTitle.isDisplayed());
			return "Passed";
		}
		catch(NoSuchElementException nsee) {
			return "Failed";
		}
	}
}