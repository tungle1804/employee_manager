package UnitTest;



import static org.testng.Assert.assertEquals;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import poly.dao.StaffDAO;
import poly.entity.Depart;
import poly.entity.Salary;
import poly.entity.Staff;

@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class StaffDAOTest extends AbstractTestNGSpringContextTests {
	
	private Staff staff;
	@Autowired
	@Qualifier("StaffDAO")
	private StaffDAO staffDAO;
	
	@BeforeTest
	static public void setUpBeforeClass() throws Exception {

	}

	@AfterTest
	static public void tearDownAfterClass() throws Exception {
	}
	@BeforeMethod 
	public void setUp() throws Exception{	
		staff = new Staff();
		staff.setGender(true);
		Salary salary = new Salary();
		salary.setId("Bac1");
		Depart depart = new Depart();
		depart.setId("P001");
		staff.setSalary(salary);
		staff.setDepart(depart);

	}
	@AfterMethod 
	public void tearDown() throws Exception {
		
		staffDAO.deleteStaff(staff.getId());
	}
	public Date ConversionStringtoSqlDate(String date) throws ParseException {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); // New Pattern
			java.util.Date dateutil = sdf1.parse(date); // Returns a Date format object with the pattern
			java.sql.Date sqlStartDate = new java.sql.Date(dateutil.getTime());
			return sqlStartDate;
		} catch (Exception e) {
			return null;
		}
		
	}
//	//botrong
//	@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
//	@Test
//	public void insertStaff0(@Optional() String codeID, @Optional() String name, @Optional() String birthday,
//			@Optional() String email, @Optional() String phone,@Optional() String photo, @Optional("false") boolean expected) throws ParseException {
//		boolean kq;
//		staff.setId(codeID);
//		staff.setName(name);
//		staff.setBirthday(ConversionStringtoSqlDate(birthday));
//		System.out.println(staff.getBirthday());
//		staff.setEmail(email);
//		staff.setPhone(phone);
//		staff.setPhoto(photo);
//		kq = staffDAO.creatStaff(staff);
//		assertEquals(expected, kq);
//	}
	// Th??m Nh??n vi??n
		@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
		@Test
		public void insertStaff(@Optional("M001") String codeID, @Optional("sss") String name, @Optional("12-12-2000") String birthday,
				@Optional("tungbeng@gmail.com") String email, @Optional("0856554123") String phone,@Optional("3.jpg") String photo, @Optional("true") boolean expected) throws ParseException {
			boolean kq;
			staff.setId(codeID);
			staff.setName(name);
			staff.setBirthday(ConversionStringtoSqlDate(birthday));
			System.out.println(staff.getBirthday());
			staff.setEmail(email);
			staff.setPhone(phone);
			staff.setPhoto(photo);
			kq = staffDAO.creatStaff(staff);
			assertEquals(expected, kq);
		}
		
//		 B??? tr???ng M?? nh??n vi??n, T??n nh??n vi??n, Ng??y sinh, Email, S??T,???nh,Ghi ch??
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff1(@Optional("") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
		
		// Ch??? nh???p tr?????ng M?? nh??n vi??n
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff2(@Optional("M001") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				
				// Ch??? nh???p tr?????ng T??n nh??n vi??n
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff3(@Optional("") String codeID, @Optional("Le Anh Tung") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng Ng??y sinh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff4(@Optional("") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng Email
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff5(@Optional("") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng S??T
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff6(@Optional("") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("0987654345") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng ???nh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff7(@Optional("") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff8(@Optional("M001") String codeID, @Optional("Le Anh Tung") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, Ng??y sinh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff9(@Optional("M001") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, Email
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff10(@Optional("M001") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, S??T
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff11(@Optional("M001") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("0896354785") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, ???nh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff12(@Optional("M001") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng T??n nh??n vi??n, Ng??y sinh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff13(@Optional("") String codeID, @Optional("Le Anh Tung") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					System.out.println("kq"+kq);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng T??n nh??n vi??n, Email
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff14(@Optional("") String codeID, @Optional("Le Anh Tung") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng T??n nh??n vi??n, S??T
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff15(@Optional("") String codeID, @Optional("Le Anh Tung") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("0987654345") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng T??n nh??n vi??n, ???nh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff16(@Optional("") String codeID, @Optional("Le Anh Tung") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng Ng??y sinh, Email
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff17(@Optional("") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng2000@gmail.com") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					System.out.println("kq"+kq);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng Ng??y sinh, S??T
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff18(@Optional("") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("0985463124") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					System.out.println("kq"+kq);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng Ng??y sinh, ???nh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff19(@Optional("") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					System.out.println("kq"+kq);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng Email, S??T
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff20(@Optional("") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("0987654323") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng Email, ???nh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff21(@Optional("") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng S??T, ???nh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff22(@Optional("") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("0987654324") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n, Ng??y sinh.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff23(@Optional("K001") String codeID, @Optional("Le Anh T??ng") String name, @Optional("12-12-2000") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("") String photo, @Optional("true") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n, Email.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff24(@Optional("K001") String codeID, @Optional("Le Anh T??ng") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n,S??T.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff25(@Optional("K001") String codeID, @Optional("Le Anh T??ng") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("0987423874") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n,???nh
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff26(@Optional("K001") String codeID, @Optional("Le Anh T??ng") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng T??n nh??n vi??n, Ng??y sinh, Email.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff27(@Optional("") String codeID, @Optional("Le Anh T??ng") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng2000@gmail.com") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng T??n nh??n vi??n, Ng??y sinh, S??T.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff28(@Optional("") String codeID, @Optional("Le Anh T??ng") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("0985236547") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng T??n nh??n vi??n, Ng??y sinh, ???nh.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff29(@Optional("") String codeID, @Optional("Le Anh T??ng") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng Ng??y sinh, Email, S??T
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff30(@Optional("") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("0987542345") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng Ng??y sinh, Email,photo
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff31(@Optional("") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng  Email,phone,photo
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff32(@Optional("") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("0985365124") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n, Ng??y sinh, Email.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff33(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n, Ng??y sinh, S??T.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff34(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("0985635142") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n, Ng??y sinh, photo
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff35(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n, Email, S??T.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff36(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("08745214144") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n, Email, photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff37(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, T??n nh??n vi??n, phone, photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff38(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("") String birthday,
						@Optional("") String email, @Optional("0987654567") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, Ng??y sinh, email, phone.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff39(@Optional("L001") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("0987654567") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, Ng??y sinh, email, photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff40(@Optional("L001") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n, Ng??y sinh, email, photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff41(@Optional("L001") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("0865235412") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n,  email,phone, photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff42(@Optional("L001") String codeID, @Optional("") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("0865235412") String phone,@Optional("3.jpg") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n,name,ng??y sinh,  email,phone.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff43(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("0865235412") String phone,@Optional("") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n,name,ng??y sinh,  email,photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff44(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("photo") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n,ng??y sinh,  email,phone,photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff45(@Optional("L001") String codeID, @Optional("") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("0985123654") String phone,@Optional("photo") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n,name,email,phone,photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff46(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("0985123654") String phone,@Optional("photo") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n,name,ng??y sinh,phone,photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff47(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("2000-12-12") String birthday,
						@Optional("") String email, @Optional("0985123654") String phone,@Optional("photo") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				// Ch??? nh???p tr?????ng M?? nh??n vi??n,name,ng??y sinh,email,photo.
				@Parameters({ "codeID", "name", "birthday", "email", "phone","photo", "expected" })
				@Test
				public void insertStaff48(@Optional("L001") String codeID, @Optional("Le Anh Tung") String name, @Optional("2000-12-12") String birthday,
						@Optional("tungbeng@gmail.com") String email, @Optional("") String phone,@Optional("photo") String photo, @Optional("false") boolean expected) throws ParseException {
					boolean kq;
					staff.setId(codeID);
					staff.setName(name);
					staff.setBirthday(ConversionStringtoSqlDate(birthday));
					System.out.println(staff.getBirthday());
					staff.setEmail(email);
					staff.setPhoto(photo);
					staff.setPhone(phone);
					kq = staffDAO.creatStaff(staff);
					assertEquals(expected, kq);
				}
				
}
