package AutomationTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class IDTest {
	static public org.openqa.selenium.WebDriver driver;;

	@BeforeMethod
	public void beforeMethod()  {
		String url = "http://localhost:8080/QuanLiNhanVien/admin/add-staff.htm";
		driver.get(url);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeTest
	public static void beforeTest() {
		System.setProperty("webdriver.edge.driver", "C:\\chrome\\msedgedriver1.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		String url = "http://localhost:8080/QuanLiNhanVien/home/login.htm";
		driver.get(url);
		WebElement UsernameFied = driver.findElement(By.id("username"));
		UsernameFied.sendKeys("tung@gmail.com");
		WebElement PasswordFied = driver.findElement(By.id("exampleInputPassword"));
		PasswordFied.sendKeys("tung123");
		driver.findElement(By.xpath("//*[@id=\"user\"]/div[4]/a/button")).click();;
//		WebElement LoginButun = driver.findElement(By.id("Login"));
//		LoginButun.click();
	}

	@AfterTest
	public static void afterTest() {
//		driver.close();
	}
//
	@Test(description = "Không nhập mã nhân viên", groups = "codeID", priority = 1)
	public void Add_01() {
		try {
//			WebElement LoginButun = driver.findElement(By.id("submit")); 
//			LoginButun.click();
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
		
			assertEquals(actual, "Please fill out this field.");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	public String getHtml5ValidationMessage(WebElement element) {
		org.openqa.selenium.JavascriptExecutor jsExecutor = (org.openqa.selenium.JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
	}
	@Test(description = "Nhập mã nhân viên với chữ thường không dấu", groups = "codeID", priority = 2)
	public void Add_02() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("abcd");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên với chữ hoa không dấu", groups = "codeID", priority = 3)
	public void Add_03() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("ABCD");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên với chữ thường có dấu", groups = "codeID", priority = 4)
	public void Add_04() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("aăê");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			System.out.println("ss"+actual);
			assertEquals(actual, "Please match the requested format.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên với chữ hoa có dấu", groups = "codeID", priority = 5)
	public void Add_05() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("AĂÊ");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);		
			assertEquals(actual,"Please match the requested format.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên với số", groups = "codeID", priority = 6)
	public void Add_06() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("123456");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên với chữ thường không dấu và số", groups = "codeID", priority = 7)
	public void Add_07() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("abcd1234");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên với chữ hoa không dấu và số", groups = "codeID", priority = 8)
	public void Add_08() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("ABCD1235");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên với chữ thường có dấu và số", groups = "codeID", priority = 9)
	public void Add_09() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("aăê1235");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "Please match the requested format.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên với chữ hoa có dấu và số", groups = "codeID", priority = 10)
	public void Add_10() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("AĂÊ1236");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "Please match the requested format.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên có ký tự đặc biệt", groups = "codeID", priority = 11)
	public void Add_11() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("!@#$%^&*");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "Please match the requested format.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên chỉ chứa ký tự khoảng trắng", groups = "codeID", priority = 12)
	public void Add_12() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys(" ");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "Please match the requested format.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên có 1 ký tự", groups = "codeID", priority = 13)
	public void Add_13() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("a");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputCode"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên có 2 ký tự", groups = "codeID", priority = 14)
	public void Add_14() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("aa");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			assertEquals(codeIDFiel.getAttribute("value").length(), 2);
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên có 9 ký tự", groups = "codeID", priority = 15)
	public void Add_15() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("aaaaaaaaa");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			assertEquals(codeIDFiel.getAttribute("value").length(), 9);
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên có 10 ký tự", groups = "codeID", priority = 16)
	public void Add_16() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("aaaaaaaaaa");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			assertEquals(codeIDFiel.getAttribute("value").length(), 10);
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}
	@Test(description = "Nhập mã nhân viên có 11 ký tự", groups = "codeID", priority = 17)
	public void Add_17() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputCode"));
			codeIDFiel.sendKeys("aaaaaaaaaaa");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();	
			Thread.sleep(1000);
			assertEquals(codeIDFiel.getAttribute("value").length(), 10);
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}
}
