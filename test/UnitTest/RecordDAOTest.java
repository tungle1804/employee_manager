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

import poly.dao.AchievementDAO;
import poly.dao.StaffDAO;
import poly.entity.Depart;
import poly.entity.Record;
import poly.entity.Salary;
import poly.entity.Staff;

@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class RecordDAOTest extends AbstractTestNGSpringContextTests {
	private Record record;
	@Autowired
	@Qualifier("AchievementDAO")
	private AchievementDAO recordDAO;
	
	@BeforeTest
	static public void setUpBeforeClass() throws Exception {

	}

	@AfterTest
	static public void tearDownAfterClass() throws Exception {
	}
	@BeforeMethod 
	public void setUp() throws Exception{	
		record = new Record();
		Staff staff= new Staff();
		staff.setId("PH001");
		record.setStaff(staff);
		record.setId("11111");
		record.setType(true);
		

	}
	@AfterMethod 
	public void tearDown() throws Exception {
		
		recordDAO.deleteAchievement(record.getId());
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
	// Thêm Record thành công
				@Parameters({ "date", "reason", "expected" })
				@Test
				public void inserRecord(@Optional() String date,@Optional() String reason,
						 @Optional() boolean expected) throws ParseException {
					boolean kq;
					record.setDate(ConversionStringtoSqlDate(date));
					record.setReason(reason);
				  
					kq = recordDAO.createAchievement(record);
					assertEquals(expected, kq);
				}
//				// Chi nhap truong date
//				@Parameters({ "date", "reason", "expected" })
//				@Test
//				public void inserRecord1(@Optional("12-12-2020") String date,@Optional("") String reason,
//						 @Optional("true") boolean expected) throws ParseException {
//					boolean kq;
//					record.setDate(ConversionStringtoSqlDate(date));
//					record.setReason(reason);
//				  
//					kq = recordDAO.createAchievement(record);
//					assertEquals(expected, kq);
//				}
//				// Chi nhap truong reason
//				@Parameters({ "date", "reason", "expected" })
//				@Test
//				public void inserRecord2(@Optional() String date,@Optional("sad") String reason,
//						 @Optional("false") boolean expected) throws ParseException {
//					boolean kq;
//					record.setDate(ConversionStringtoSqlDate(date));
//					record.setReason(reason);
//				  
//					kq = recordDAO.createAchievement(record);
//					assertEquals(expected, kq);
//				}
//				// Bo trong ca 2 truong
//				@Parameters({ "date", "reason", "expected" })
//				@Test
//				public void inserRecord3(@Optional() String date,@Optional("") String reason,
//						 @Optional("false") boolean expected) throws ParseException {
//					boolean kq;
//					record.setDate(ConversionStringtoSqlDate(date));
//					record.setReason(reason);
//				  
//					kq = recordDAO.createAchievement(record);
//					assertEquals(expected, kq);
//				}
//				
}
