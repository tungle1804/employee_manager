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

import poly.dao.SalaryDAO;
import poly.dao.StaffDAO;
import poly.entity.Depart;
import poly.entity.Salary;
import poly.entity.Staff;

@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class SalaryDAOTest extends AbstractTestNGSpringContextTests {
	private Salary salary;
	@Autowired
	@Qualifier("SalaryDAO")
	private SalaryDAO salaryDAO;
	
	@BeforeTest
	static public void setUpBeforeClass() throws Exception {

	}

	@AfterTest
	static public void tearDownAfterClass() throws Exception {
	}
	@BeforeMethod 
	public void setUp() throws Exception{	
		salary = new Salary();
		

	}
	@AfterMethod 
	public void tearDown() throws Exception {
		
		salaryDAO.deleteSalary(salary.getId());
	}
	
	@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
	@Test
	public void insertSalary(@Optional() String id, @Optional() float basic_salary, @Optional() float allowance,
			@Optional() float salary_factor, @Optional() boolean expected) throws ParseException {
		boolean kq;
		salary.setId(id);
		salary.setAllowance(allowance);
		salary.setBasicsalary(basic_salary);
		salary.setSalary_factor(salary_factor);
		
		kq = salaryDAO.creatSalary(salary);
		assertEquals(expected, kq);
	}
	//Chỉ thêm trường id
//		@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//		@Test
//		public void insertSalary1(@Optional("M001") String id, @Optional("0") float basic_salary, @Optional("0") float allowance,
//				@Optional("0") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//			boolean kq;
//			salary.setId(id);
//			salary.setAllowance(allowance);
//			salary.setBasicsalary(basic_salary);
//			salary.setSalary_factor(salary_factor);
//			
//			kq = salaryDAO.creatSalary(salary);
//			System.out.println("sssss"+kq);
//			assertEquals(expected, kq);
//		}
//		//Chỉ thêm trường basic_salary
//				@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//				@Test
//				public void insertSalary2(@Optional("") String id, @Optional("10") float basic_salary, @Optional("0") float allowance,
//						@Optional("0") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					salary.setId(id);
//					salary.setAllowance(allowance);
//					salary.setBasicsalary(basic_salary);
//					salary.setSalary_factor(salary_factor);
//					
//					kq = salaryDAO.creatSalary(salary);
//					System.out.println("sssss"+kq);
//					assertEquals(expected, kq);
//				}
//				//Chỉ thêm trường allowance
//				@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//				@Test
//				public void insertSalary3(@Optional("") String id, @Optional("0") float basic_salary, @Optional("10") float allowance,
//						@Optional("0") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					salary.setId(id);
//					salary.setAllowance(allowance);
//					salary.setBasicsalary(basic_salary);
//					salary.setSalary_factor(salary_factor);
//					
//					kq = salaryDAO.creatSalary(salary);
//					System.out.println("sssss"+kq);
//					assertEquals(expected, kq);
//				}
//				//Chỉ thêm trường salary_factor
//				@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//				@Test
//				public void insertSalary4(@Optional("") String id, @Optional("0") float basic_salary, @Optional("0") float allowance,
//						@Optional("10") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					salary.setId(id);
//					salary.setAllowance(allowance);
//					salary.setBasicsalary(basic_salary);
//					salary.setSalary_factor(salary_factor);
//					
//					kq = salaryDAO.creatSalary(salary);
//					System.out.println("sssss"+kq);
//					assertEquals(expected, kq);
//				}
//				//Chỉ thêm trường id,basic_salary
//				@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//				@Test
//				public void insertSalary5(@Optional("M001") String id, @Optional("10") float basic_salary, @Optional("0") float allowance,
//						@Optional("0") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					salary.setId(id);
//					salary.setAllowance(allowance);
//					salary.setBasicsalary(basic_salary);
//					salary.setSalary_factor(salary_factor);
//					
//					kq = salaryDAO.creatSalary(salary);
//					System.out.println("sssss"+kq);
//					assertEquals(expected, kq);
//				}
//				//Chỉ thêm trường id,allowance
//				@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//				@Test
//				public void insertSalary6(@Optional("M001") String id, @Optional("0") float basic_salary, @Optional("10") float allowance,
//						@Optional("0") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					salary.setId(id);
//					salary.setAllowance(allowance);
//					salary.setBasicsalary(basic_salary);
//					salary.setSalary_factor(salary_factor);
//					
//					kq = salaryDAO.creatSalary(salary);
//					System.out.println("sssss"+kq);
//					assertEquals(expected, kq);
//				}
//				//Chỉ thêm trường id,salary_factor
//				@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//				@Test
//				public void insertSalary7(@Optional("M001") String id, @Optional("0") float basic_salary, @Optional("0") float allowance,
//						@Optional("10") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					salary.setId(id);
//					salary.setAllowance(allowance);
//					salary.setBasicsalary(basic_salary);
//					salary.setSalary_factor(salary_factor);
//					
//					kq = salaryDAO.creatSalary(salary);
//					System.out.println("sssss"+kq);
//					assertEquals(expected, kq);
//				}
//				//Chỉ thêm trường basic_salary,allowance
//				@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//				@Test
//				public void insertSalary8(@Optional("") String id, @Optional("10") float basic_salary, @Optional("10") float allowance,
//						@Optional("0") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					salary.setId(id);
//					salary.setAllowance(allowance);
//					salary.setBasicsalary(basic_salary);
//					salary.setSalary_factor(salary_factor);
//					
//					kq = salaryDAO.creatSalary(salary);
//					System.out.println("sssss"+kq);
//					assertEquals(expected, kq);
//				}
//				//Chỉ thêm trường basic_salary,salary_factor
//				@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//				@Test
//				public void insertSalary9(@Optional("") String id, @Optional("10") float basic_salary, @Optional("0") float allowance,
//						@Optional("10") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					salary.setId(id);
//					salary.setAllowance(allowance);
//					salary.setBasicsalary(basic_salary);
//					salary.setSalary_factor(salary_factor);
//					
//					kq = salaryDAO.creatSalary(salary);
//					System.out.println("sssss"+kq);
//					assertEquals(expected, kq);
//				}
//				//Chỉ thêm trường allowance,salary_factor
//				@Parameters({ "id", "basic_salary", "allowance", "salary_factor","expected" })
//				@Test
//				public void insertSalary10(@Optional("") String id, @Optional("0") float basic_salary, @Optional("10") float allowance,
//						@Optional("10") float salary_factor, @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					salary.setId(id);
//					salary.setAllowance(allowance);
//					salary.setBasicsalary(basic_salary);
//					salary.setSalary_factor(salary_factor);
//					
//					kq = salaryDAO.creatSalary(salary);
//					System.out.println("sssss"+kq);
//					assertEquals(expected, kq);
//				}
}
