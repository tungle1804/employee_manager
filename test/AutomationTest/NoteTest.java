package AutomationTest;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class NoteTest extends AbstractTestNGSpringContextTests {
	@Autowired
	@Qualifier("StaffDAO")
	private poly.dao.StaffDAO staffDAO;
	static public org.openqa.selenium.WebDriver driver;;
	@BeforeMethod
	  public void beforeMethod() {
		  String url = "http://localhost:8080/QuanLiNhanVien/admin/add-staff.htm";
		driver.get(url);
		WebElement UsernameFied = driver.findElement(By.id("exampleInputCode"));
		UsernameFied.sendKeys("ID1");
		WebElement NameFied = driver.findElement(By.id("exampleInputName"));
		NameFied.sendKeys("Le Anh Tung");
		WebElement BirthdayFiel = driver.findElement(By.id("birthday"));
		BirthdayFiel.sendKeys("12/12/2000");
		WebElement Email =driver.findElement(By.id("exampleInputEmail"));
		Email.sendKeys("jojo@gmail.com");
		WebElement Phone =driver.findElement(By.id("exampleInputPhone"));
		Phone.sendKeys("0954823546");
		
	  }

	  @AfterMethod
	  public void afterMethod() {
		  staffDAO.deleteStaff("ID1");
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
	  @Test(description = "Không nhập Note", groups = "note", priority = 91)
		public void Add_91() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
				codeIDFiel.sendKeys("");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
	  @Test(description = "Nhập Note với chữ thường không dấu", groups = "note", priority = 92)
		public void Add_92() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
				codeIDFiel.sendKeys("abcd");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
	  @Test(description = "Nhập Note với chữ hoa không dấu", groups = "note", priority = 93)
		public void Add_93() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
				codeIDFiel.sendKeys("ABCD");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
	  @Test(description = "Nhập Note với chữ thường có dấu", groups = "note", priority = 94)
		public void Add_94() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
				codeIDFiel.sendKeys("aăê");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
	  @Test(description = "Nhập Note với chữ hoa có dấu", groups = "note", priority = 95)
			public void Add_95() {
				try {
					WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
					codeIDFiel.sendKeys("AĂÊ");
					driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
					Thread.sleep(1000);
					WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
					String actual = getHtml5ValidationMessage(invalidDiv);
					assertEquals(actual, "");
				} catch (Exception e) {
					fail("Lỗi: Không nhập mã vẫn hợp lệ");
				}
			}
	  @Test(description = "Nhập Note với số", groups = "note", priority = 96)
		public void Add_96() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
				codeIDFiel.sendKeys("123456");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
	  @Test(description = "Nhập Note với chữ thường không dấu và số", groups = "note", priority = 97)
			public void Add_97() {
				try {
					WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
					codeIDFiel.sendKeys("abcd1234");
					driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
					Thread.sleep(1000);
					WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
					String actual = getHtml5ValidationMessage(invalidDiv);
					assertEquals(actual, "");
				} catch (Exception e) {
					fail("Lỗi: Không nhập mã vẫn hợp lệ");
				}
			}
	  @Test(description = "Nhập Note với chữ hoa không dấu và số", groups = "note", priority = 98)
		public void Add_98() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
				codeIDFiel.sendKeys("ABCD1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
	  @Test(description = "Nhập Note với chữ thường có dấu và số", groups = "note", priority = 99)
		public void Add_99() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
				codeIDFiel.sendKeys("aăê1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
	  @Test(description = "Nhập Note với chữ hoa có dấu và số", groups = "note", priority = 100)
		public void Add_100() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleTextarea1"));
				codeIDFiel.sendKeys("AĂÊ1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleTextarea1"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		public String getHtml5ValidationMessage(WebElement element) {
			org.openqa.selenium.JavascriptExecutor jsExecutor = (org.openqa.selenium.JavascriptExecutor) driver;
			return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
		}
}
