package UnitTest;
import static org.testng.Assert.assertEquals;

import java.text.ParseException;

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
import poly.dao.UserDAO;
import poly.entity.Depart;
import poly.entity.Salary;
import poly.entity.Staff;
import poly.entity.User;

@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class UserDAOTest extends AbstractTestNGSpringContextTests {
	
	private User user;
	@Autowired
	@Qualifier("UserDAO")
	private UserDAO userDAO;
	
	@BeforeTest
	static public void setUpBeforeClass() throws Exception {

	}

	@AfterTest
	static public void tearDownAfterClass() throws Exception {
	}
	@BeforeMethod 
	public void setUp() throws Exception{	
		user = new User();
		user.setRole(true);
		

	}
	@AfterMethod 
	public void tearDown() throws Exception {
		
		userDAO.deleteUser(user.getUsername());
	}
	
			@Parameters({ "username", "fullname", "password", "expected" })
			@Test
			public void insertUser(@Optional() String username,@Optional() String fullname, @Optional() String password,
					 @Optional() boolean expected) throws ParseException {
				boolean kq;
				user.setUsername(username);
				user.setFullname(fullname);
				user.setPass(password);
				kq = userDAO.creatUser(user);
				assertEquals(expected, kq);
			}
			//Không nhập gì
//			@Parameters({ "username", "fullname", "password", "expected" })
//			@Test
//			public void insertUser01(@Optional("") String username,@Optional("") String fullname, @Optional("") String password,
//					 @Optional("true") boolean expected) throws ParseException {
//				boolean kq;
//				user.setUsername(username);
//				user.setFullname(fullname);
//				user.setPass(password);
//				kq = userDAO.creatUser(user);
//				assertEquals(expected, kq);
//			}
			
	//Chỉ nhập trường username
//			@Parameters({ "username", "fullname", "password", "expected" })
//			@Test
//			public void insertUser02(@Optional("M001") String username,@Optional("") String fullname, @Optional("") String password,
//					 @Optional("true") boolean expected) throws ParseException {
//				boolean kq;
//				user.setUsername(username);
//				user.setFullname(fullname);
//				user.setPass(password);
//				kq = userDAO.creatUser(user);
//				assertEquals(expected, kq);
//			}
			//Chỉ nhập trường fullname
//			@Parameters({ "username", "fullname", "password", "expected" })
//			@Test
//			public void insertUser03(@Optional("") String username,@Optional("Le Anh Tung") String fullname, @Optional("") String password,
//					 @Optional("true") boolean expected) throws ParseException {
//				boolean kq;
//				user.setUsername(username);
//				user.setFullname(fullname);
//				user.setPass(password);
//				kq = userDAO.creatUser(user);
//				assertEquals(expected, kq);
//			}
			//Chỉ nhập trường password
//			@Parameters({ "username", "fullname", "password", "expected" })
//			@Test
//			public void insertUser04(@Optional("") String username,@Optional("") String fullname, @Optional("tung123") String password,
//					 @Optional("true") boolean expected) throws ParseException {
//				boolean kq;
//				user.setUsername(username);
//				user.setFullname(fullname);
//				user.setPass(password);
//				kq = userDAO.creatUser(user);
//				assertEquals(expected, kq);
//			}
			//Chỉ nhập trường username,fullname
//			@Parameters({ "username", "fullname", "password", "expected" })
//			@Test
//			public void insertUser05(@Optional("tung@gmail.com") String username,@Optional("Le Anh Tung") String fullname, @Optional("") String password,
//					 @Optional("true") boolean expected) throws ParseException {
//				boolean kq;
//				user.setUsername(username);
//				user.setFullname(fullname);
//				user.setPass(password);
//				kq = userDAO.creatUser(user);
//				assertEquals(expected, kq);
//			}
			//Chỉ nhập trường username,password
//			@Parameters({ "username", "fullname", "password", "expected" })
//			@Test
//			public void insertUser06(@Optional("tung@gmail.com") String username,@Optional("") String fullname, @Optional("tung123") String password,
//					 @Optional("true") boolean expected) throws ParseException {
//				boolean kq;
//				user.setUsername(username);
//				user.setFullname(fullname);
//				user.setPass(password);
//				kq = userDAO.creatUser(user);
//				assertEquals(expected, kq);
//			}
			//Chỉ nhập trường fullname,password
//			@Parameters({ "username", "fullname", "password", "expected" })
//			@Test
//			public void insertUser07(@Optional("") String username,@Optional("Le Anh Tung") String fullname, @Optional("tung123") String password,
//					 @Optional("true") boolean expected) throws ParseException {
//				boolean kq;
//				user.setUsername(username);
//				user.setFullname(fullname);
//				user.setPass(password);
//				kq = userDAO.creatUser(user);
//				assertEquals(expected, kq);
//			}
}
