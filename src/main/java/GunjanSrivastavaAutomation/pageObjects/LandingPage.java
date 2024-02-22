package GunjanSrivastavaAutomation.pageObjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GunjanSrivastavaAutomation.AbstractComponents.AbstractComponent;
import GunjanSrivastavaAutomation.resoucres.LocatorConfig;


public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	public void submitSearchTerm(String keyword) throws IOException {
		driver.findElement(LocatorConfig.xpath_searchbox).click();
		driver.findElement(LocatorConfig.xpath_searchbox).sendKeys(keyword);
		driver.findElement(LocatorConfig.xpath_searchbox).sendKeys(Keys.RETURN);
	}

	public void landedOnSearchResultPage() {
		WebElement we = driver.findElement(LocatorConfig.xpath_results);
		elementIsDisplayed(we);
	}
	
    public String FirstItemReturned() {
		String actualResult = driver.findElements(LocatorConfig.xpath_items).get(0).getText();
		System.out.println("actual result: "+actualResult);
		return actualResult;
	}
	
}
