package Assessment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomateWorkflow {
	
	private WebDriver driver = new FirefoxDriver();
	
	@BeforeClass
	public void init() {
		
		//driver.get("http://www.build.com");
		driver.get(Constants.URL);
		driver.manage().window().maximize();
		((JavascriptExecutor) driver).executeScript("window.focus();");
		
		addWaitTime(10);

		(new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.searchTextId)));
	}
	
	@Test
	public void AddFirstItem(){
	
		driver.findElement(By.id(Constants.searchTextId)).sendKeys(Constants.product1);
		// Click Search Button
		driver.findElement(By.className(Constants.searchBtn)).click();

		// Click on the displayed product
		driver.findElement(By.xpath("//a[@href='/kohler-k-6626-6u-kitchen-sink/s563763?uid=173148']")).click();

		addWaitTime(5);

		driver.findElement(By.xpath("//img[contains(@alt,'Suede')]"));
        
		driver.findElement(By.cssSelector(".button-primary.add-to-cart.js-add-to-cart.btn-lg")).click();
        
		System.out.println("Done with adding Suede to Cart");
		
	}
	
	@Test
	public void AddSecondItem(){
		
		driver.get(Constants.URL);
		
		(new WebDriverWait(driver, 120))
		.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.searchTextId)));

		driver.findElement(By.id(Constants.searchTextId)).sendKeys(Constants.product1);
		
		// Click Search Button
		driver.findElement(By.className(Constants.searchBtn)).click();

		// Click on the displayed product
		driver.findElement(By.xpath("//a[@href='/kohler-k-6626-6u-kitchen-sink/s563763?uid=173148']")).click();

		addWaitTime(5);

		// Click on the Cashmere color product and Click Add to cart
		driver.findElement(By.xpath(".//img[@alt='Cashmere']")).click();
		driver.findElement(By.cssSelector(".button-primary.add-to-cart.js-add-to-cart.btn-lg")).click();
		
		System.out.println("Done with adding 2nd Product to Cart");
		
		addWaitTime(5);
	}
	
	@Test
	public void AddThirdItem(){
		
		driver.get(Constants.URL);
		
		(new WebDriverWait(driver, 120))
		.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.searchTextId)));
		
		driver.findElement(By.id(Constants.searchTextId)).sendKeys(Constants.product2);

		driver.findElement(By.className(Constants.searchBtn)).click();

		addWaitTime(5);

		
		driver.findElement(By.cssSelector("#main-product-quantity > div > input")).sendKeys(Keys.ARROW_UP);
		driver.findElement(By.cssSelector(".button-primary.add-to-cart.js-add-to-cart.btn-lg")).click();
		System.out.println("Done with adding 3rd Product to Cart");
		
		addWaitTime(10);
	}	
	
	@Test
	public void Checkout(){
		
		//Click on the Checkout button
		driver.findElement(By.xpath(".//*[@id='cartNav']/a/span")).click();
		
		addWaitTime(5);
		
		//Choose the Checkout as Guest button
//		driver.findElement(By.name("guestLoginSubmit")).click();
		driver.findElement(By.name(Constants.guestLoginBtnName)).click();

		//Enter Shipping and Payment Information
		driver.findElement(By.id(Constants.shippingfirstnameId)).clear();
		driver.findElement(By.id(Constants.shippingfirstnameId)).sendKeys(Constants.FirstNameValue);
		System.out.println("Entered user's first name");
		
		driver.findElement(By.id(Constants.shippinglastnameId)).clear();
		driver.findElement(By.id(Constants.shippinglastnameId)).sendKeys(Constants.LastNameValue);
		System.out.println("Entered user's last name");
		
		driver.findElement(By.id(Constants.shippingaddress1Id)).clear();
		driver.findElement(By.id(Constants.shippingaddress1Id)).sendKeys(Constants.ShippingAddress);
		System.out.println("Entered user's street address");
		
		driver.findElement(By.id(Constants.shippingpostalcodeId)).clear();
		driver.findElement(By.id(Constants.shippingpostalcodeId)).sendKeys(Constants.ZipCode);
		System.out.println("Entered user's zipcode");
		
		driver.findElement(By.id(Constants.shippingcityId)).sendKeys(Constants.City);
		System.out.println("Entered user's city");
		
		Select city = new Select(driver.findElement(By.id(Constants.shippingstate_1)));
		city.selectByVisibleText(Constants.State);
		System.out.println("State selected");
		
		Select country = new Select(driver.findElement(By.id(Constants.shippingcountryId)));
		country.selectByVisibleText(Constants.Country);
		System.out.println("Country selected");
		
		driver.findElement(By.id(Constants.shippingphonenumberId)).clear();
		driver.findElement(By.id(Constants.shippingphonenumberId)).sendKeys(Constants.PhoneNumber);
		System.out.println("Mobile Number entered");
		
		driver.findElement(By.id(Constants.emailAddressId)).clear();
		driver.findElement(By.id(Constants.emailAddressId)).sendKeys(Constants.EmailAddress);
		System.out.println("Email Address entered");
		
		driver.findElement(By.id(Constants.creditCardNumberId)).clear();
		driver.findElement(By.id(Constants.creditCardNumberId)).sendKeys(Constants.CcNumber);
		System.out.println("Credit Card Number entered");
		
		Select cardMonth = new Select(driver.findElement(By.id(Constants.creditCardMonthId)));
		cardMonth.selectByIndex(2);
		System.out.println("Card Expiry Month selected");
		
		Select cardYear = new Select(driver.findElement(By.id(Constants.creditCardYearId)));
		cardYear.selectByValue(Constants.CcYear);
		System.out.println("Card Expiry Year selected");
		
		driver.findElement(By.id(Constants.creditcardnameId)).clear();
		driver.findElement(By.id(Constants.creditcardnameId)).sendKeys(Constants.CcUserName);
		System.out.println("CC Holder Name entered");
		
		driver.findElement(By.id(Constants.creditCardCVV2Id)).clear();
		driver.findElement(By.id(Constants.creditCardCVV2Id)).sendKeys(Constants.CvvValue);
		System.out.println("CVV enetered");
	}
	
	@Test
	public void ReviewOrder(){
		
		//Click on the "Review Order" button
		driver.findElement(By.xpath(".//*[@value='Review Order']")).click();
		
		//Get the Sub-total of the order
		String subTotal = driver.findElement(By.cssSelector("#subtotalamount")).getText();
		subTotal = subTotal.replace("$", "");
		subTotal = subTotal.replaceAll(",", "");
		float subTotalAmt = Float.parseFloat(subTotal);
		System.out.println("Final str: "+subTotalAmt);
		
		//Get the Tax amount of the order
		String tax = driver.findElement(By.cssSelector("#taxAmount")).getText();
		tax = tax.replace("$", "");
		tax = tax.replaceAll(",", "");
		float taxAmt = Float.parseFloat(tax);
		taxAmt = Math.round(taxAmt*100)/100.0f;
		System.out.println("Tax: "+taxAmt);
		
		float californiaTax = Math.round(0.0725* subTotalAmt *100)/100.0f;
		System.out.println("Diff: "+californiaTax);

		//Assert if CA tax is 7.25% of the subTotal
		Assert.assertEquals(taxAmt, californiaTax, 0.01);
		
		//Assert.assertTrue(0 == Math.floor(taxAmt-californiaTax));
		System.out.println("CA Tax assert successful");
		
		//Get the Grand Total
		String grandTotal = driver.findElement(By.id("grandtotalamount")).getText();
		grandTotal = grandTotal.replace("$", "");
		grandTotal = grandTotal.replaceAll(",", "");
		float grandTotalAmt = Float.parseFloat(grandTotal);
		System.out.println("Grand Total: "+grandTotalAmt);
		
		float payableAmt = subTotalAmt + taxAmt;
		
		Assert.assertEquals(payableAmt, grandTotalAmt, 0);
		//Assert.assertTrue(0f == (payableAmt-grandTotalAmt));
		System.out.println("Grand Total assert successful");
	}	
	
	@AfterClass
	public void finish(){
		driver.quit();
	}
	
	public void addWaitTime(int n){
		try {
			Thread.sleep(n * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}