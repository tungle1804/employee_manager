package AutomationTestUser;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import poly.dao.UserDAO;
import poly.entity.User;
@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class PasswordTest extends AbstractTestNGSpringContextTests {
	static public org.openqa.selenium.WebDriver driver;

	@Autowired
	@Qualifier("UserDAO")
	private UserDAO userDAO;

	@BeforeMethod
	public void beforeMethod()  {
		String url = "http://localhost:8080/QuanLiNhanVien/admin/add-user.htm";
		driver.get(url);
		WebElement codeIDFiel = driver.findElement(By.id("exampleInputUsername1"));
		codeIDFiel.sendKeys("anh@gmail.com");
		WebElement codeIDFie2 = driver.findElement(By.id("exampleInputFullname"));
		codeIDFie2.sendKeys("Le Anh Tung");
		
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("ss"+userDAO.infoUser("anh@gmail.com"));
		if(userDAO.infoUser("anh@gmail.com")!=null) {
			userDAO.deleteUser("anh@gmail.com");
		}
		
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
	@Test(description = "Kh??ng nh???p pass", groups = "pass", priority = 37)
	public void Add_20() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			assertEquals(actual, "Vui l??ng ??i???n m???t kh???u!");
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i ch??? th?????ng kh??ng d???u", groups = "pass", priority = 38)
	public void Add_38() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("tung");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i ch??? hoa kh??ng d???u", groups = "pass", priority = 39)
	public void Add_39() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("TUNG");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i ch??? th?????ng c?? d???u", groups = "pass", priority = 40)
	public void Add_40() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("t??ng");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i ch??? hoa c?? d???u", groups = "pass", priority = 41)
	public void Add_41() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("T??NG");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i s???", groups = "pass", priority = 42)
	public void Add_42() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i ch??? th?????ng kh??ng d???u v?? s???", groups = "pass", priority = 43)
	public void Add_43() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("tung123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i ch??? hoa kh??ng d???u v?? s???", groups = "pass", priority = 44)
	public void Add_44() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("TUNG1213");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i ch??? th?????ng c?? d???u v?? s???", groups = "pass", priority = 45)
	public void Add_45() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("t??ng123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i ch??? hoa c?? d???u v?? s???", groups = "pass", priority = 46)
	public void Add_46() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("T??NG123");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i k?? t??? ?????c bi???t", groups = "pass", priority = 47)
	public void Add_47() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("#@#@");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i k?? kho???ng tr???ng", groups = "pass",priority = 48)
	public void Add_48() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys(" ");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			assertEquals(actual, "Vui l??ng ??i???n m???t kh???u!");
		
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i 1 k?? t??? ", groups = "pass", priority = 49)
	public void Add_49() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("t");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i 2 k?? t???", groups = "pass", priority = 50)
	public void Add_50() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("tt");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i 49 k?? t???", groups = "pass", priority = 51)
	public void Add_51() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("0123456789012345678901234567890123456789012345678");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i 50 k?? t???", groups = "pass", priority = 52)
	public void Add_52() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("01234567890123456789012345678901234567890123456789");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
//			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			 boolean actual = checkactual("pass.errors");
				assertEquals(actual, false);
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
	@Test(description = "Nh???p pass v???i 51 k?? t???", groups = "pass", priority = 53)
	public void Add_53() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("exampleInputPassword1"));
			codeIDFiel.sendKeys("012345678901234567890123456789012345678901234567890");
			driver.findElement(By.xpath("//*[@id=\"user\"]/button[1]")).click();;
			Thread.sleep(1000);
			
			 String actual = driver.findElement(By.xpath("//*[@id=\"pass.errors\"]")).getText();
			
				assertEquals(actual, "Vu???t qu?? k?? t??? cho ph??p");
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
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
