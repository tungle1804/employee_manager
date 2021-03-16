package AutomationTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;





public class EmailTest {
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
		BirthdayFiel.sendKeys("02091993");
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
	  @Test(description = "Không nhập email", groups = "email", priority = 53)
		public void Add_53() {
			try {
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
	  @Test(description = "Nhập email với chữ thường không dấu", groups = "email", priority = 54)
		public void Add_54() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("abcd");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please include an '@' in the email address. 'abcd' is missing an '@'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		@Test(description = "Nhập email với chữ hoa không dấu", groups = "email", priority = 55)
		public void Add_55() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("ABCD");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please include an '@' in the email address. 'ABCD' is missing an '@'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		@Test(description = "Nhập email với chữ thường có dấu", groups = "email", priority = 56)
		public void Add_56() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("aăê");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please include an '@' in the email address. 'aăê' is missing an '@'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		@Test(description = "Nhập email với chữ hoa có dấu", groups = "email", priority = 57)
		public void Add_57() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("AĂÊ");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please include an '@' in the email address. 'AĂÊ' is missing an '@'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		@Test(description = "Nhập email với số", groups = "email", priority = 58)
		public void Add_58() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("123456");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please include an '@' in the email address. '123456' is missing an '@'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		@Test(description = "Nhập email với chữ thường không dấu và số", groups = "email", priority = 59)
		public void Add_59() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("abcd1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please include an '@' in the email address. 'abcd1234' is missing an '@'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		@Test(description = "Nhập email với chữ hoa không dấu và số", groups = "email", priority = 60)
		public void Add_60() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("ABCD12345");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please include an '@' in the email address. 'ABCD12345' is missing an '@'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		@Test(description = "Nhập email với chữ thường có dấu và số", groups = "email", priority = 61)
		public void Add_61() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("aăê1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please include an '@' in the email address. 'aăê1234' is missing an '@'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		@Test(description = "Nhập email với chữ hoa có dấu và số", groups = "email", priority = 62)
		public void Add_62() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("AĂÊ1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please include an '@' in the email address. 'AĂÊ1234' is missing an '@'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		
		
		@Test(description = "Nhập email có ký tự đặc biệt", groups = "email", priority = 63)
		public void Add_63() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("!@#!#");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "A part following '@' should not contain the symbol '#'.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}
		
		@Test(description = "Nhập email chỉ chứa ký tự khoảng trắng", groups = "email", priority =64)
		public void Add_64() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys(" ");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập email có 6 ký tự", groups = "email", priority = 65)
		public void Add_65() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("@tk.vn");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
			
				assertEquals(actual, "Please enter a part followed by '@'. '@tk.vn' is incomplete.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập email có 7 ký tự", groups = "email", priority = 66)
		public void Add_66() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputEmail"));
				codeIDFiel.sendKeys("t@tb.vn");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập email có 49 ký tự", groups = "email", priority = 67)
		public void Add_67() {
			try {
				WebElement emailFiel =driver.findElement(By.id("exampleInputEmail"));
				emailFiel.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@tk.vn");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
			
				assertEquals(emailFiel.getAttribute("value").length(), 49);
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập email có 50 ký tự", groups = "email", priority = 68)
		public void Add_68() {
			try {
				WebElement emailFiel =driver.findElement(By.id("exampleInputEmail"));
				emailFiel.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@tk.vn");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
			
				assertEquals(emailFiel.getAttribute("value").length(), 50);
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập email có 51 ký tự", groups = "email", priority = 69)
		public void Add_69() {
			try {
				WebElement emailFiel =driver.findElement(By.id("exampleInputEmail"));
				emailFiel.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@tk.vn");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv =driver.findElement(By.id("exampleInputEmail"));
				String actual = getHtml5ValidationMessage(invalidDiv);
			
				assertEquals(emailFiel.getAttribute("value").length(), 50);
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		

		@Test(description = "Nhập email sai định dạng", groups = "email", priority = 70)
		public void Add_70() {
			try {
				WebElement emailFiel = driver.findElement(By.id("exampleInputEmail"));
				emailFiel.sendKeys("aaaaaa@t.b");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				String actual = getHtml5ValidationMessage(emailFiel);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}
	  public String getHtml5ValidationMessage(WebElement element) {
			org.openqa.selenium.JavascriptExecutor jsExecutor = (org.openqa.selenium.JavascriptExecutor) driver;
			return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
		}
		
}
