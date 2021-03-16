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





public class PhoneTest {
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
		WebElement Email =driver.findElement(By.id("exampleInputEmail"));
		Email.sendKeys("jojo@gmail.com");
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
	  @Test(description = "Không nhập số điện thoại", groups = "phone", priority = 71)
		public void Add_71() {
			try {
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please fill out this field.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại với chữ thường không dấu", groups = "phone", priority = 72)
		public void Add_72() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("abcd");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}
		@Test(description = "Nhập số điện thoại với chữ hoa không dấu", groups = "phone", priority = 73)
		public void Add_73() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("ABCD");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại với chữ thường có dấu", groups = "phone", priority = 74)
		public void Add_74() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("aăê");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại với chữ hoa có dấu", groups = "phone", priority = 75)
		public void Add_75() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("AĂÊ");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại với số", groups = "phone", priority = 76)
		public void Add_76() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("123456");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại với chữ thường không dấu và số", groups = "phone", priority = 77)
		public void Add_77() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("abcd1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại với chữ hoa không dấu và số", groups = "phone", priority = 78)
		public void Add_78() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("ABCD1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại với chữ thường có dấu và số", groups = "phone", priority = 79)
		public void Add_79() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("aăê123");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại với chữ hoa có dấu và số", groups = "phone", priority = 80)
		public void Add_80() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("AĂÊ1234");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập mã vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại chỉ chứa ký tự đặc biệt", groups = "phone", priority = 81)
		public void Add_81() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("@#@#@");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại chỉ chứa ký tự khoảng trắng", groups = "phone", priority = 82)
		public void Add_82() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys(" ");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại có 5 ký tự", groups = "phone", priority = 83)
		public void Add_83() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("03686");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại có 6 ký tự", groups = "phone", priority = 84)
		public void Add_84() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("034562");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại có 7 ký tự", groups = "phone", priority = 85)
		public void Add_85() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("0345463");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại có 10 ký tự", groups = "phone", priority = 86)
		public void Add_86() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("0365845214");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "");
			} catch (Exception e) {
				fail("Lỗi: Không nhập sđt vẫn hợp lệ");
			}
		}

		@Test(description = "Nhập số điện thoại có 11 ký tự", groups = "phone", priority = 87)
		public void Add_87() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("09632587412");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không sai định dạng vẫn hợp lệ");
			}
		}
		@Test(description = "Nhập số điện thoại có 12 ký tự", groups = "phone", priority = 88)
		public void Add_88() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("023658425632");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}
		@Test(description = "Nhập số điện thoại có 13 ký tự", groups = "phone", priority = 89)
		public void Add_89() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("0325874125896");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}

		
		@Test(description = "Nhập số điện thoại sai định dạng", groups = "phone", priority = 90)
		public void Add_90() {
			try {
				WebElement codeIDFiel =driver.findElement(By.id("exampleInputPhone"));
				codeIDFiel.sendKeys("9856325412");
				driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();;
				Thread.sleep(1000);
				WebElement invalidDiv = driver.findElement(By.id("exampleInputPhone"));
				String actual = getHtml5ValidationMessage(invalidDiv);
				assertEquals(actual, "Please match the requested format.");
			} catch (Exception e) {
				fail("Lỗi: Nhập sai định dạng vẫn hợp lệ");
			}
		}
		
//		@Test(description = "Nhập mã nhân viên đã tồn tại", groups = "phone", priority = 91)
//		public void Add_91() {
//			try {
//				WebElement codeIDFiel = codeIDTest.driver.findElement(By.id("codeID"));
//				codeIDFiel.sendKeys("ST001");
//				WebElement phoneFiel = codeIDTest.driver.findElement(By.id("phone"));
//				phoneFiel.sendKeys("0363389894");
//				WebElement LoginButun = codeIDTest.driver.findElement(By.id("submit"));
//				LoginButun.click();
//				Thread.sleep(1000);
//				String actual = codeIDTest.driver.findElement(By.id("meseger")).getText();
//				assertEquals(actual,"Mã nhân viên đã tồn tại");
//			} catch (Exception e) {
//				fail("Lỗi: Nhập sai định dạng vẫn hợp lệ");
//			}
//		}
		public String getHtml5ValidationMessage(WebElement element) {
			org.openqa.selenium.JavascriptExecutor jsExecutor = (org.openqa.selenium.JavascriptExecutor) driver;
			return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
		}
}
