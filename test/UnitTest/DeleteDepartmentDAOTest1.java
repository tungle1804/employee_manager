package UnitTest;
import static org.testng.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import poly.dao.DepartmentDAO;
import poly.entity.Depart;
@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class DeleteDepartmentDAOTest1 extends AbstractTestNGSpringContextTests {
	private Depart depart;
	@Autowired
	@Qualifier("DepartmentDAO")
	private DepartmentDAO departDAO;
	  @Test
	  public void delete_01() {
			depart = new Depart();
			depart=departDAO.infoDepartment("P001");
		  boolean kq;
		  kq=departDAO.deleteDepartment(depart.getId());
		
		  assertEquals(false, kq);
	  }
}
