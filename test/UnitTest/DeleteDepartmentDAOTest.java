package UnitTest;
import static org.testng.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import poly.dao.DepartmentDAO;
import poly.dao.UserDAO;
import poly.entity.Depart;
import poly.entity.User;

@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class DeleteDepartmentDAOTest extends AbstractTestNGSpringContextTests {
	private Depart depart;
	@Autowired
	@Qualifier("DepartmentDAO")
	private DepartmentDAO departDAO;
	@BeforeMethod 
	public void setUp() throws Exception{	
		depart = new Depart();
		  depart.setId("P008");
		  depart.setName("Nhà thi đấu");
		departDAO.creatDepartment(depart);
		depart=departDAO.infoDepartment("P008");
		
	}
	@AfterMethod 
	public void tearDown() throws Exception {
		  
	}
	//Depart bị ràng buộc
//  @Test
//  public void delete_01() {
//		depart = new Depart();
//		depart=departDAO.infoDepartment("P001");
//	  boolean kq;
//	  kq=departDAO.deleteDepartment(depart.getId());
//	
//	  assertEquals(false, kq);
//  }
  //Depart không bị ràng buộc
  @Test
  public void delete_02() {
		
	  boolean kq;
	  kq=departDAO.deleteDepartment(depart.getId());
	  
	  assertEquals(true, kq);
	
  }
}
