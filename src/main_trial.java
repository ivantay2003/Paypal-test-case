import static org.junit.Assert.*;




import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class main_trial {

	WebDriver driver =new FirefoxDriver ();
	String webURL;
	
	@Before
	public void setUp () throws Exception {
		
		webURL = "http://www.seleniumhq.org/projects/ide/";
		
	}
	
	@Test
	public void test() throws Exception {
		//fail("Not yet implemented");
		driver.get(webURL);
		TestCases ();
	}
	
	
	@After
	public void tearDown () throws Exception {
		
		
		//driver.quit();
	}
	

	
	public void ClickLinkText (){
		
		String linkURL = "operating systems";
		driver.findElement(By.linkText(linkURL)).click();
		
		
	}
	
	public void PayPalButton ()  {
		
		try  {
			Thread.sleep(2000);
			String linkURL = "https://www.paypal.com/cgi-bin/webscr";
			driver.findElement(By.name("submit")).click();
			
				
		} catch (Exception e){
			
			System.out.println(e.toString()); 
		}

		

		
	}
	
	public void PayPalForm () {
		
		//Check if correct page
		String textVal = "Please enter your donation amount.";
		
		try {
			
			Thread.sleep(2000);
			String mystring = driver.findElement(By.id("makeDonationMessage")).getText();
			
			//System.out.print(mystring);
			
			if (mystring == textVal){
				System.out.print(mystring + "\r");
				System.out.print(textVal+ "\r");
				fail("Not yet implemented");
			}
			
		} catch (Exception e){
			
			System.out.println(e.toString()); 
		}
		
		
	}
	
	
	
	public void fillPayPalForm () {
		
		
		String amt = "5";

		
		try {
			
			Thread.sleep(2000);
			driver.findElement(By.id("amount")).sendKeys(amt);;
			driver.findElement(By.id("enable_recurring_donations")).click();
			
			//Select form
			WebElement element = driver.findElement(By.id("country_code"));
			Select select = new Select (element);
			select.selectByVisibleText("Singapore");
			
			//Name
			driver.findElement(By.id("first_name")).sendKeys("testerfirstname");
			driver.findElement(By.id("last_name")).sendKeys("testerlastname");
			driver.findElement(By.id("cc_number")).sendKeys("4111111111111111");
			
			//Fill credit details
		    driver.findElement(By.id("expdate_month")).clear();
		    driver.findElement(By.id("expdate_year")).clear();
		    driver.findElement(By.id("cvv2_number")).clear();
		    //driver.findElement(By.id("address1")).clear();
		    //driver.findElement(By.id("city")).clear();
		    //driver.findElement(By.id("zip")).clear();

		    
		    
			driver.findElement(By.id("expdate_month")).sendKeys("02");
			driver.findElement(By.id("expdate_year")).sendKeys("16");
			driver.findElement(By.id("cvv2_number")).sendKeys("123");
		    driver.findElement(By.id("address1")).sendKeys("tester_address1");
		    driver.findElement(By.id("zip")).sendKeys("12345");
		    driver.findElement(By.id("email-address")).sendKeys("tester123456@testing.com.sg");
		    driver.findElement(By.id("H_PhoneNumber")).sendKeys("1234567890");
				
		    //Review
		    driver.findElement(By.id("review")).click();
		    
		    //Check if page is wrong
		    
		    //String mystring = driver.findElement(By.id("xptContentContainer")).getText();
		    String myElement = "//*[@id='xptContentContainer']/tbody/tr[3]/td[1]";
		    int Row_Count = driver.findElements(By.xpath("//*[@id='xptContentMain']")).size();
		    System.out.println(Row_Count);
		    
		    driver.findElement(By.xpath(myElement)).getSize();
		    String mystring = driver.findElement(By.xpath(myElement)).getText();
		    
		    System.out.println(mystring);
		}catch (Exception e) {
			
			
			System.out.println(e.toString());
		}
		
	}
	
	
	
	public void TestCases () {
		
		ClickLinkText();
		PayPalButton () ;
		PayPalForm ();
		fillPayPalForm ();
		
	}
}
