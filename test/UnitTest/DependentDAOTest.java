	package UnitTest;
import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import poly.dao.DependentDAO;
import poly.entity.Dependent;
import poly.entity.Staff;

@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class DependentDAOTest extends AbstractTestNGSpringContextTests{
	private Dependent depentent;
	@Autowired
	@Qualifier("DependentDAO")
	private DependentDAO dependentDAO;
	@BeforeMethod 
	public void setUp() throws Exception{
		depentent = new Dependent();
		depentent.setGender(true);
		Staff staff= new Staff();
		staff.setId("PH001");
		depentent.setStaff(staff);
	}
	@AfterMethod 
	public void tearDown() throws Exception {
		dependentDAO.deleteDependent(depentent.getId());
	}
	@Parameters({ "codeID", "name", "birthday", "relationship", "expected" })
	@Test
	public void insertStaff(@Optional() String codeID, @Optional() String name, @Optional() String birthday,
			@Optional() String relationship,@Optional() boolean expected) throws ParseException {
		boolean kq;
		depentent.setId(codeID);
		depentent.setName(name);
		depentent.setBirthday(ConversionStringtoSqlDate(birthday));
		depentent.setRelationship(relationship);
		kq = dependentDAO.creatDependent(depentent);
		assertEquals(expected, kq);
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
}
