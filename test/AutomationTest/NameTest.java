package AutomationTest;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class NameTest {
	static public org.openqa.selenium.WebDriver driver;;
  
  @BeforeTest
  public static void beforeTest() {
	
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  String url = "http://localhost:8080/QuanLiNhanVien/admin/add-staff.htm";
	driver.get(url);
	WebElement UsernameFied = driver.findElement(By.id("exampleInputCode"));
	UsernameFied.sendKeys("ID1");
	WebElement UsernameFied1 = driver.findElement(By.id("birthday"));
	UsernameFied1.sendKeys("12/12/2000");
	WebElement UsernameFied2 = driver.findElement(By.id("exampleInputEmail"));
	UsernameFied2.sendKeys("tung4@gmail.com");
	WebElement UsernameFied3 = driver.findElement(By.id("exampleInputPhone"));
	UsernameFied3.sendKeys("0965324125");
	WebElement UsernameFied4 = driver.findElement(By.id("exampleTextarea1"));
	UsernameFied4.sendKeys("tung");
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

  @AfterClass
  public void afterClass() {
//	  driver.close();
  }
  
  //Nhap ten nhan vien
  @Test(description = "Kh??ng nh???p ten nhan vien", groups = "name", priority = 18)
	public void Add_18() {
		try {
//			WebElement LoginButun = driver.findElement(By.id("submit")); 
//			LoginButun.click();
	
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
//			WebElement invalidate = driver.findElement(By.id("name.errors"));
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
		
			assertEquals(actual, "Please fill out this field.");
		
	} catch (Exception e) {
			fail("L???i: Kh??ng nh???p m?? v???n h???p l???");
	}
	}
//@Test(description = "de trong", groups = "name", priority = 19)
//	public void Add_19() {
//		try {
//			WebElement codename = driver.findElement(By.id("exampleInputName"));
//			codename.sendKeys("");
//			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
//			Thread.sleep(1000);
//			WebElement invalidDiv = driver.findElement(By.xpath("//*[@id=\"name.errors\"]"));
//			System.out.println("text "+invalidDiv.getText());
////			String actual = getHtml5ValidationMessage(invalidDiv);
//			assertEquals(invalidDiv.getText(), "Vui l??ng nh???p t??n nh??n vi??n !");
//		} catch (Exception e) {
//			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
//		}
//	}
  @Test(description = "Nh???p t??n nh??n vi??n v???i ch??? th?????ng kh??ng d???u", groups = "name", priority = 19)
	public void Add_19() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("abcd");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n v???i ch??? hoa kh??ng d???u", groups = "name", priority = 20)
	public void Add_20() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("ABCD");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n v???i ch??? th?????ng c?? d???u", groups = "name", priority = 21)
	public void Add_21() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("a????");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n v???i ch??? hoa c?? d???u", groups = "name", priority = 22)
	public void Add_22() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("A????");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n v???i s???", groups = "name", priority = 23)
	public void Add_23() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("123456");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n v???i ch??? th?????ng kh??ng d???u v?? s???", groups = "name", priority = 24)
	public void Add_24() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("abcd1234");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n v???i ch??? hoa kh??ng d???u v?? s???", groups = "name", priority = 25)
	public void Add_25() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("ABCD12345");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n v???i ch??? th?????ng c?? d???u v?? s???", groups = "name", priority = 26)
	public void Add_26() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("a????1234");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n v???i ch??? hoa c?? d???u v?? s???", groups = "name", priority = 27)
	public void Add_27() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("A????1234");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}
	
	@Test(description = "Nh???p t??n nh??n vi??n c?? k?? t??? ?????c bi???t", groups = "name", priority = 28)
	public void Add_28() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("#@#@#");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n ch??? ch???a k?? t??? kho???ng tr???ng", groups = "name", priority = 29)
	public void Add_29() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys(" ");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}


	@Test(description = "Nh???p t??n nh??n vi??n c?? 1 k?? t???", groups = "name", priority = 30)
	public void Add_30() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("a");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			WebElement invalidDiv = driver.findElement(By.id("exampleInputName"));
			String actual = getHtml5ValidationMessage(invalidDiv);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n c?? 2 k?? t???", groups = "name", priority = 31)
	public void Add_31() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("aa");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			assertEquals(codename.getAttribute("value").length(), 2);
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n c?? 49 k?? t???", groups = "name", priority = 32)
	public void Add_32() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			assertEquals(codename.getAttribute("value").length(), 49);
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n c?? 50 k?? t???", groups = "name", priority = 33)
	public void Add_33() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			assertEquals(codename.getAttribute("value").length(), 50);
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}

	@Test(description = "Nh???p t??n nh??n vi??n c?? 51 k?? t???", groups = "name", priority = 34)
	public void Add_34() {
		try {
			WebElement codename = driver.findElement(By.id("exampleInputName"));
			codename.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			driver.findElement(By.xpath("//*[@id=\"staff\"]/div[11]/button[1]")).click();
			Thread.sleep(1000);
			assertEquals(codename.getAttribute("value").length(), 50);
		} catch (Exception e) {
			fail("L???i: Kh??ng nh???p t??n v???n h???p l???");
		}
	}
  public String getHtml5ValidationMessage(WebElement element) {
		org.openqa.selenium.JavascriptExecutor jsExecutor = (org.openqa.selenium.JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
		
		
	}
}
