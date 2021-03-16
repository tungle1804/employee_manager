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

import poly.dao.UserDAO;
import poly.entity.User;

@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class UpdateUserDAOTest extends AbstractTestNGSpringContextTests {
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
		user=userDAO.infoUser("dang@gmail.com");
		
	}
	@AfterMethod 
	public void tearDown() throws Exception {
		
	user.setFullname("le anh tung");
	user.setPass("tung123");
	userDAO.editUser(user);
	}
	
//			@Parameters({ "username", "fullname", "password","role", "expected" })
//			@Test
//			public void insertUser(@Optional() String username,@Optional() String fullname, @Optional() String password,@Optional() boolean role,
//					 @Optional() boolean expected) throws ParseException {
//				boolean kq;
//				System.out.println(user.getFullname());
//				user.setFullname(fullname);
//				user.setPass(password);
//				user.setRole(role);
//				kq = userDAO.editUser(user);	
//				assertEquals(expected, kq);
//			}
	//upadateuser không nhập gì
	@Test
	public void update_01() throws ParseException {
		boolean kq;
		kq = userDAO.editUser(user);	
		assertEquals(true, kq);
	}
	
	//updateuser để trống fullname
	@Test
	public void update_02() throws ParseException {
		boolean kq;
		user.setFullname(null);
		kq = userDAO.editUser(user);	
		assertEquals(false, kq);
	}
	//updateuser để trống password
		@Test
		public void update_03() throws ParseException {
			boolean kq;
			user.setPass(null);
			kq = userDAO.editUser(user);	
			assertEquals(false, kq);
		}
		//updateuser role là true
		@Test
		public void update_04() throws ParseException {
			boolean kq;
			user.setRole(true);
			kq = userDAO.editUser(user);	
			assertEquals(true, kq);
		}
		//updateuser fullname 1 ký tự
				@Test
				public void update_05() throws ParseException {
					boolean kq;	
					user.setFullname("t");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser fullname 2 ký tự
				@Test
				public void update_06() throws ParseException {
					boolean kq;	
					user.setFullname("tt");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser fullname 49 ký tự
				@Test
				public void update_07() throws ParseException {
					boolean kq;	
					user.setFullname("ttttttttttttttttttttttttttttttttttttttttttttttttt");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser fullname 50 ký tự
				@Test
				public void update_08() throws ParseException {
					boolean kq;	
					user.setFullname("tttttttttttttttttttttttttttttttttttttttttttttttttt");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser fullname 51 ký tự
				@Test
				public void update_09() throws ParseException {
					boolean kq;	
					user.setFullname("ttttttttttttttttttttttttttttttttttttttttttttttttttt");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser pass 1 ký tự
				@Test
				public void update_10() throws ParseException {
					boolean kq;	
					user.setPass("t");
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser pass 2 ký tự
				@Test
				public void update_11() throws ParseException {
					boolean kq;	
					user.setPass("tt");
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser pass 49 ký tự
				@Test
				public void update_12() throws ParseException {
					boolean kq;	
					user.setPass("ttttttttttttttttttttttttttttttttttttttttttttttttt");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser pass 50 ký tự
				@Test
				public void update_13() throws ParseException {
					boolean kq;	
					user.setPass("tttttttttttttttttttttttttttttttttttttttttttttttttt");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser pass 51 ký tự
				@Test
				public void update_14() throws ParseException {
					boolean kq;	
					user.setPass("ttttttttttttttttttttttttttttttttttttttttttttttttttt");;
					kq = userDAO.editUser(user);	
					assertEquals(false, kq);
				}
				//updateuser pass chứa ký tự đặc biệt
				@Test
				public void update_15() throws ParseException {
					boolean kq;	
					user.setPass("@#@#@");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser fullname chứa ký tự đặc biệt
				@Test
				public void update_16() throws ParseException {
					boolean kq;	
					user.setFullname("@#@#@");
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser pass chứa khoảng trắng
				@Test
				public void update_17() throws ParseException {
					boolean kq;	
					user.setPass(" ");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				//updateuser fullname chứa khoảng trắng
				@Test
				public void update_18() throws ParseException {
					boolean kq;	
					user.setFullname(" ");;
					kq = userDAO.editUser(user);	
					assertEquals(true, kq);
				}
				
}
