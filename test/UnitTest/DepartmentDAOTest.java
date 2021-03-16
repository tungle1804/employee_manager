	package UnitTest;

import static org.testng.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import poly.dao.DepartmentDAO;
import poly.entity.Depart;


@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class DepartmentDAOTest extends AbstractTestNGSpringContextTests {
	private Depart depart;

	@Autowired
	@Qualifier("DepartmentDAO")
	private DepartmentDAO departDAO;
	@BeforeTest
	static public void setUpBeforeClass() throws Exception {

	}

	@AfterTest
	static public void tearDownAfterClass() throws Exception {
	}
	@BeforeMethod 
	public void setUp() throws Exception{
		System.out.println("hiiiiiii");
	
		depart = new Depart();
	}
	@AfterMethod 
	public void tearDown() throws Exception {
		System.out.println("id laf"+depart.getId());
		departDAO.deleteDepartment(depart.getId());
	}
	
	
	// Bỏ trống Mã phòng ban, Tên phòng ban
  @Test
  public void Add_01() {
	  boolean kq;
	  depart.setId(null);
	  depart.setName(null);
	  kq=departDAO.creatDepartment(depart);
	  assertEquals(false, kq);
  }
  
//Chỉ nhập trường Mã phòng ban
	@Test
  public void Add_02() {
		boolean kq;
		depart.setId("DE010");
		depart.setName(null);
		kq = departDAO.creatDepartment(depart);
		assertEquals(false ,kq);
	}


//Chỉ nhập trường Tên phòng ban
	@Test
	public void Add_03() {
		boolean kq;
		depart.setId(null);
		depart.setName("Phòng kế hoạch");
		kq = departDAO.creatDepartment(depart);
		assertEquals(false, kq);
	}
	
	// Điền đầy đủ các trường
	@Test
	public void Add_04() {
		boolean kq;
		depart.setId("DE010");
		depart.setName("Phòng kế hoạch");
		kq = departDAO.creatDepartment(depart);
		assertEquals(true, kq);
	}
	// Thêm phòng ban với Mã phòng ban có độ dài 0 kí tự
	@Test
	public void Add_05() {
		boolean kq;
		depart.setId("");
		depart.setName("Phòng kế hoạch");
		kq = departDAO.creatDepartment(depart);
		assertEquals(true, kq);
	}
	
	// Thêm phòng ban với Mã phòng ban có độ dài 1 kí tự
	@Test
	public void Add_06() {
		boolean kq;
		depart.setId("D");
		depart.setName("Phòng kế hoạch");
		kq = departDAO.creatDepartment(depart);
		assertEquals(true, kq);
	}
	// Thêm phòng ban với Mã phòng ban có độ dài 2 kí tự
		@Test
		public void Add_07() {
			boolean kq;
			depart.setId("DA");
			depart.setName("Phòng kế hoạch");
			kq = departDAO.creatDepartment(depart);
			assertEquals(true, kq);
		}
		
		// Thêm phòng ban với Mã phòng ban có độ dài 9 kí tự
				@Test
				public void Add_08() {
					boolean kq;
					depart.setId("DAS123456");
					depart.setName("Phòng kế hoạch");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				
				// Thêm phòng ban với Mã phòng ban có độ dài 10 kí tự
				@Test
				public void Add_09() {
					boolean kq;
					depart.setId("DAS1234567");
					depart.setName("Phòng kế hoạch");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				
				// Thêm phòng ban với Mã phòng ban có độ dài 11 kí tự
				@Test
				public void Add_10() {
					boolean kq;
					depart.setId("DAS12345678");
					depart.setName("Phòng kế hoạch");
					kq = departDAO.creatDepartment(depart);
					assertEquals(false, kq);
				}
				
				// Thêm phòng ban với Mã phòng ban có chứa ký tự đặc biệt
				@Test
				public void Add_11() {
					boolean kq;
					depart.setId("%#$&");
					depart.setName("Phòng kế hoạch");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				
				// Thêm phòng ban với Mã phòng ban chỉ chứa ký tự có khoảng trắng
				@Test
				public void Add_12() {
					boolean kq;
					depart.setId(" ");
					depart.setName("Phòng kế hoạch");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				
				// Thêm phòng ban với Tên phòng ban có độ dài 0 kí tự
				@Test
				public void Add_13() {
					boolean kq;
					depart.setId("DE010");
					depart.setName("");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				// Thêm phòng ban với Tên phòng ban có độ dài 1 kí tự
				@Test
				public void Add_14() {
					boolean kq;
					depart.setId("DE010");
					depart.setName("A");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				// Thêm phòng ban với Tên phòng ban có độ dài 2 kí tự
				@Test
				public void Add_15() {
					boolean kq;
					depart.setId("DE010");
					depart.setName("AA");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				// Thêm phòng ban với Tên phòng ban có độ dài 19 kí tự
				@Test
				public void Add_16() {
					boolean kq;
					depart.setId("DE010");
					depart.setName("AAAAAAAAAAAAAAAAAAA");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				// Thêm phòng ban với Tên phòng ban có độ dài 20 kí tự
				@Test
				public void Add_17() {
					boolean kq;
					depart.setId("DE010");
					depart.setName("AAAAAAAAAAAAAAAAAAAA");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				// Thêm phòng ban với Tên phòng ban có độ dài 21 kí tự
				@Test
				public void Add_18() {
					boolean kq;
					depart.setId("DE010");
					depart.setName("AAAAAAAAAAAAAAAAAAAAA");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				// Thêm phòng ban với Tên phòng ban có chứa ký tự đặc biệt
				@Test
				public void Add_19() {
					boolean kq;
					depart.setId("DE010");
					depart.setName("%#$&");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				// Thêm phòng ban với Tên phòng ban chỉ chứa khoảng trắng
				@Test
				public void Add_20() {
					boolean kq;
					depart.setId("DE010");
					depart.setName(" ");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				// Thêm phòng ban với Mã phòng ban đã tồn tại
				@Test
				public void Add_21() {
					boolean kq;
					depart.setId("DE001");
					depart.setName(" ");
					kq = departDAO.creatDepartment(depart);
					assertEquals(true, kq);
				}
				
	
}
