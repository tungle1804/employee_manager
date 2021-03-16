package AutomationTestUser;
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

public class FullnameTest {
	static public org.openqa.selenium.WebDriver driver;;

	@BeforeMethod
	public void beforeMethod()  {
		String url = "http://localhost:8080/QuanLiNhanVien/admin/add-user.htm";
		driver.get(url);
		WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
		codeIDFiel.sendKeys("anh@gmail.com");
		
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
	@Test(description = "Không nhập fullanme", groups = "fullname", priority = 20)
	public void Add_20() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			assertEquals(actual, "Vui lòng điền họ tên!");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với chữ thường không dấu", groups = "fullname", priority = 21)
	public void Add_21() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("tung");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với chữ hoa không dấu", groups = "fullname", priority = 22)
	public void Add_22() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("LE ANH TUNG");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với chữ thường có dấu ", groups = "fullname", priority = 23)
	public void Add_23() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("tùng");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với chữ hoa có dấu ", groups = "fullname", priority = 24)
	public void Add_24() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("TÙNG");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với số ", groups = "fullname", priority = 25)
	public void Add_25() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("1234");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với chữ thường không dấu và số ", groups = "fullname", priority = 26)
	public void Add_26() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("tung123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với chữ hoa không dấu và số ", groups = "fullname", priority = 27)
	public void Add_27() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("TUNG123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với chữ thường có dấu và số ", groups = "fullname", priority = 28)
	public void Add_28() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("tùng123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với chữ hoa có dấu và số ", groups = "fullname", priority = 29)
	public void Add_29() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("TÙNG123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với ký tự đặc biệt ", groups = "fullname", priority = 30	)
	public void Add_30() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("#@#@");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
			boolean actual = checkactual("fullname.errors");
			assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với khoảng trắng ", groups = "fullname", priority = 31	)
	public void Add_31() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys(" ");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
//			boolean actual = checkactual("fullname.errors");
				assertEquals(actual, "Vui lòng điền họ tên!");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với 1 ký tự ", groups = "fullname", priority = 32	)
	public void Add_32() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("t");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
				boolean actual = checkactual("fullname.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với 2 ký tự ", groups = "fullname", priority = 33 		)
	public void Add_33() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("tt");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
				boolean actual = checkactual("fullname.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với 49 ký tự ", groups = "fullname", priority = 34 		)
	public void Add_34() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("0123456789012345678901234567890123456789012345678");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
				boolean actual = checkactual("fullname.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với 50 ký tự ", groups = "fullname", priority = 35 		)
	public void Add_35() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("01234567890123456789012345678901234567890123456789");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
				boolean actual = checkactual("fullname.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập fullname với 51 ký tự ", groups = "fullname", priority = 36 		)
	public void Add_36() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputFullname"));
			codeIDFiel.sendKeys("012345678901234567890123456789012345678901234567890");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("//*[@id=\"fullname.errors\"]")).getText();
//				boolean actual = checkactual("fullname.errors");
				assertEquals(actual, "Vuợt quá ký tự cho phép");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	public boolean checkactual(String id) {
		try {
			driver.findElement(By.id(id)).getText();
			return true;
		} catch (Exception e) {
		return false;
		}
		
		
	}
}
