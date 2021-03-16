package AutomationTest;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class newvilbo {
	static public org.openqa.selenium.WebDriver driver;
	
	@Test
	 public void testCase1() {
		System.setProperty("webdriver.edge.driver", "C:\\chrome\\msedgedriver1.exe");
		driver = new EdgeDriver();
//		driver.manage().window().maximize();
	 String url = "https://accounts.viblo.asia/register";
//	 String expectTitle = "Learning Management System | Hệ thống quản trị học tập | FPT Polytechnic Việt Nam1";
	 driver.get(url);
	 String expectTitle = "Must be less than 50 characters"; 
	 		    
	 		       
	 String name ="1111111111111111111111111111111111111111111111111111111111111111";
	 String a ="123";
	 driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/form/div[5]/div/label/span[1]/span")).click();
	 driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/form/div[1]/div/div[1]/input")).sendKeys(name);
	 String actualTitel = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div/form/div[1]/div/div[2]")).getText();
	 assertEquals(actualTitel,  expectTitle);
	 }
}
