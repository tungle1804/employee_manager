package AutomationTest;
import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class BirthdayTest {
	static public org.openqa.selenium.WebDriver driver;;
	@BeforeMethod
	  public void beforeMethod() {
		  String url = "http://localhost:8080/QuanLiNhanVien/admin/add-staff.htm";
		driver.get(url);
		WebElement UsernameFied = driver.findElement(By.id("exampleInputCode"));
		UsernameFied.sendKeys("ID1");
		WebElement NameFied = driver.findElement(By.id("exampleInputName"));
		NameFied.sendKeys("Le Anh Tung");
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }

	  @BeforeClass
	  public void beforeClass() {
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
	  }
	  @Test(description = "Không nhập ngày sinh", groups = "Birthday", priority = 35)
		public void Add_35() {
			try {
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập ngày sinh với chữ thường không dấu", groups = "Birthday", priority = 36)
		public void Add_36() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("abcd");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập ngày sinh với chữ hoa không dấu", groups = "Birthday", priority = 37)
		public void Add_37() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("ABCD");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
//
		@Test(description = "Nhập ngày sinh với chữ thường có dấu", groups = "Birthday", priority = 38)
		public void Add_38() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("aăê");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
//
		@Test(description = "Nhập ngày sinh với chữ hoa có dấu", groups = "Birthday", priority = 39)
		public void Add_39() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("AĂÊ");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
//
		@Test(description = "Nhập ngày sinh với số", groups = "Birthday", priority = 40)
		public void Add_40() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("02091993");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
//
		@Test(description = "Nhập ngày sinh với chữ thường không dấu và số", groups = "Birthday", priority = 41)
		public void Add_41() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("abcd1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
//				assertEquals(actual, "Value must be 01/01/1950 or later.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
//
		@Test(description = "Nhập ngày sinh với chữ hoa không dấu và số", groups = "Birthday", priority = 42)
		public void Add_42() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("ABCD12345");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
//				assertEquals(actual, "Value must be 01/01/1950 or later.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
//
		@Test(description = "Nhập ngày sinh với chữ thường có dấu và số", groups = "Birthday", priority = 43)
		public void Add_43() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("aăê1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
//				assertEquals(actual, "Value must be 01/01/1950 or later.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
//
		@Test(description = "Nhập ngày sinh với chữ hoa có dấu và số", groups = "Birthday", priority = 44)
		public void Add_44() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("AĂÊ12345");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
//				assertEquals(actual, "Value must be 01/01/1950 or later.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
//
		@Test(description = "Nhập ngày sinh chỉ chứa ký tự đặc biệt", groups = "Birthday", priority = 45)
		public void Add_45() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys("$#$##");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}
//
		@Test(description = "Nhập ngày sinh chỉ chứa ký tự khoảng trắng", groups = "Birthday", priority = 46)
		public void Add_46() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("birthday"));
				codeIDFiel.sendKeys(" ");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("birthday"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}
//
//		@Test(description = "Nhập ngày sinh 31/12/1949", groups = "Birthday", priority = 47)
//		public void Add_47() {
//			try {
//				WebElement BirthdayFiel = codeIDTest.driver.findElement(By.id("Birthday"));
//				BirthdayFiel.sendKeys("31121949");
//				WebElement LoginButun = codeIDTest.driver.findElement(By.id("submit"));
//				LoginButun.click();
//				Thread.sleep(1000);
//				String actual = getHtml5ValidationMessage(BirthdayFiel);
//				System.out.println(actual);
//				assertEquals(actual, "Value must be 01/01/1950 or later.");
//			} catch (Exception e) {
//				fail("Lỗi: Không nhập ngày sinh vẫn hợp lệ");
//			}
//		}
//
//		@Test(description = "Nhập ngày sinh 01/01/1950", groups = "Birthday", priority = 48)
//		public void Add_48() {
//			try {
//				WebElement BirthdayFiel = codeIDTest.driver.findElement(By.id("Birthday"));
//				BirthdayFiel.sendKeys("01011950");
//				WebElement LoginButun = codeIDTest.driver.findElement(By.id("submit"));
//				LoginButun.click();
//				Thread.sleep(1000);
//				String actual = getHtml5ValidationMessage(BirthdayFiel);
//				assertEquals(actual, "");
//			} catch (Exception e) {
//				fail("Lỗi: Không nhập tên vẫn hợp lệ");
//			}
//		}
//
//		@Test(description = "Nhập ngày sinh 02/01/1950", groups = "Birthday", priority = 49)
//		public void Add_49() {
//			try {
//				WebElement BirthdayFiel = codeIDTest.driver.findElement(By.id("Birthday"));
//				BirthdayFiel.sendKeys("02011950");
//				WebElement LoginButun = codeIDTest.driver.findElement(By.id("submit"));
//				LoginButun.click();
//				Thread.sleep(1000);
//				String actual = getHtml5ValidationMessage(BirthdayFiel);
//				assertEquals(actual, "");
//			} catch (Exception e) {
//				fail("Lỗi: Không nhập tên vẫn hợp lệ");
//			}
//		}
//
//		@Test(description = "Nhập ngày sinh 30/12/2002", groups = "Birthday", priority = 50)
//		public void Add_50() {
//			try {
//				WebElement BirthdayFiel = codeIDTest.driver.findElement(By.id("Birthday"));
//				BirthdayFiel.sendKeys("30122002");
//				WebElement LoginButun = codeIDTest.driver.findElement(By.id("submit"));
//				LoginButun.click();
//				Thread.sleep(1000);
//				String actual = getHtml5ValidationMessage(BirthdayFiel);
//				assertEquals(actual, "");
//			} catch (Exception e) {
//				fail("Lỗi: Không nhập tên vẫn hợp lệ");
//			}
//		}
//
//		@Test(description = "Nhập ngày sinh 31/12/2002", groups = "Birthday", priority = 51)
//		public void Add_51() {
//			try {
//				WebElement BirthdayFiel = codeIDTest.driver.findElement(By.id("Birthday"));
//				BirthdayFiel.sendKeys("31122002");
//				WebElement LoginButun = codeIDTest.driver.findElement(By.id("submit"));
//				LoginButun.click();
//				Thread.sleep(1000);
//				String actual = getHtml5ValidationMessage(BirthdayFiel);
//				assertEquals(actual, "");
//			} catch (Exception e) {
//				fail("Lỗi: Không nhập tên vẫn hợp lệ");
//			}
//		}
//
//		@Test(description = "Nhập ngày sinh 01/01/2003", groups = "Birthday", priority = 52)
//		public void Add_52() {
//			try {
//				WebElement BirthdayFiel = codeIDTest.driver.findElement(By.id("Birthday"));
//				BirthdayFiel.sendKeys("01012003");
//				WebElement LoginButun = codeIDTest.driver.findElement(By.id("submit"));
//				LoginButun.click();
//				Thread.sleep(1000);
//				String actual = getHtml5ValidationMessage(BirthdayFiel);
//				assertEquals(actual, "Value must be 31/12/2002 or earlier.");
//			} catch (Exception e) {
//				fail("Lỗi: Không nhập tên vẫn hợp lệ");
//			}
//		}

		public String getHtml5ValidationMessage(WebElement element) {
			org.openqa.selenium.JavascriptExecutor jsExecutor = (org.openqa.selenium.JavascriptExecutor) driver;
			return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
		}

}
