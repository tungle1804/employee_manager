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
public class UsernameTest {
	static public org.openqa.selenium.WebDriver driver;;

	@BeforeMethod
	public void beforeMethod()  {
		String url = "http://localhost:8080/QuanLiNhanVien/admin/add-user.htm";
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
	@Test(description = "Không nhập username", groups = "username", priority = 1)
	public void Add_01() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Vui lòng nhập Tên tài khoản !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với chữ thường không dấu", groups = "username", priority = 2)
	public void Add_02() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("abcd");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với chữ hoa không dấu", groups = "username", priority = 3)
	public void Add_03() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("ABCD");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với chữ thường có dấu", groups = "username", priority = 4)
	public void Add_04() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("tùng");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với chữ hoa có dấu", groups = "username", priority = 5)
	public void Add_05() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("TÙNG");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với số", groups = "username", priority = 6)
	public void Add_06() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("123456");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với chữ thường không dấu và số", groups = "username", priority = 7)
	public void Add_07() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("tung123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với chữ hoa không dấu và số", groups = "username", priority = 8)
	public void Add_08() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("TUNG123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với chữ thường có dấu và số", groups = "username", priority = 9)
	public void Add_09() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("tùng123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với chữ hoa có dấu và số", groups = "username", priority = 10)
	public void Add_10() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("TÙNG123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với ký tự đặc biệt", groups = "username", priority = 11)
	public void Add_11() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("@#@#@");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với ký tự khoảng trắng", groups = "username", priority = 12)
	public void Add_12() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys(" ");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Vui lòng nhập Tên tài khoản !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với 1 ký tự", groups = "username", priority = 13)
	public void Add_13() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("t");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với 2 ký tự", groups = "username", priority = 14)
	public void Add_14() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("tt");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với 49 ký tự", groups = "username", priority = 14)
	public void Add_15() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("tttttttttttttttttttttttttttttttttttttttttttttttttttt");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với 50 ký tự", groups = "username", priority = 15)
	public void Add_16() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("ttttttttttttttttttttttttttttttttttttttttttttttttttttt");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username với 51 ký tự", groups = "username", priority = 17)
	public void Add_17() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("tttttttttttttttttttttttttttttttttttttttttttttttttttttt");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên đăng nhập phải trùng với email !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username bị trùng", groups = "username", priority = 18)
	public void Add_18() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("hoang@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			assertEquals(actual, "Tên tài khoản đã tồn tại !");
	} catch (Exception e) {
			fail("Lỗi: Không nhập mã vẫn hợp lệ");
	}
	}
	@Test(description = "Nhập username thành công", groups = "username", priority = 19)
	public void Add_19() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
			codeIDFiel.sendKeys("anh@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/form/span[1]")).getText();
			boolean actual = checkactual("username.errors");
			assertEquals(actual, false);
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
