package poly.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.StatisticalDAO;

@Transactional
@Service("StatisticalDAO")
@Repository
public class StatisticalDAOImpl implements StatisticalDAO {
	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	@Override
	public List<Object> top10Staff() {
		Session session = this.factory.getCurrentSession();
		String sql ="SELECT r.staff.name,r.staff.photo,r.staff.depart.name"
				
				+ " FROM Record r  GROUP BY r.staff.name,r.staff.depart.name,r.staff.photo"
				+ " order by (SUM (CASE when type = 1 then 1 else 0 end) - SUM (CASE when type = 0 then 1 else 0 end)) desc";
		List<Object> list = session.createQuery(sql).setFirstResult(0).setMaxResults(10).list();
		return list;
		
	
		
	}

	@Override
	public List<Object> Staffsalary() {
		Session session = this.factory.getCurrentSession();
		String sql = "select r.id,r.name,r.email,r.gender,sum(r.salary.basicsalary*r.salary.salary_factor+r.salary.allowance) from Staff r group by r.id,r.name,r.email,r.gender" ;
		List<Object> list = session.createQuery(sql).list();
		return list;
	}

	@Override
	public List<Object> Departmentsalary() {
		Session session = this.factory.getCurrentSession();
		String sql = "select d.depart.name,count(d.id),sum(d.salary.basicsalary*d.salary.salary_factor+d.salary.allowance) from Staff d group by d.depart.name" ;
		List<Object> list = session.createQuery(sql).list();
		return list;
	}

	@Override
	public List<Object> DateDiff() {
		Session session = this.factory.getCurrentSession();
		String sql = "select c.staff.name,c.todate,getdate() from Contract c  " ;
		List<Object> list = session.createQuery(sql).list();

		return list;
	}

	@Override
	public List<Object> listnameStaff() {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT r.staff.id, r.staff.name, SUM(case when r.type = 1 then 1 else 0 end),"
				+ " SUM(case when r.type = 0 then 1 else 0 end),"
				+ " (SUM(case when r.type = 1 then 1 else 0 end) - SUM(case when r.type = 0 then 1 else 0 end))"
				+ " FROM Record r  GROUP BY r.staff.id,r.staff.name"
				+ " order by (SUM (CASE when type = 1 then 1 else 0 end) - SUM (CASE when type = 0 then 1 else 0 end)) desc";
		List<Object> list = session.createQuery(sql).list();
		return list;
	}

	@Override
	public List<Object> listDepartment() {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT r.staff.depart.name, SUM(case when r.type = 1 then 1 else 0 end),"
				+ " SUM(case when r.type = 0 then 1 else 0 end),"
				+ " (SUM(case when r.type = 1 then 1 else 0 end) - SUM(case when r.type = 0 then 1 else 0 end))"
				+ " FROM Record r  GROUP BY r.staff.depart.name"
				+ " order by (SUM (CASE when type = 1 then 1 else 0 end) - SUM (CASE when type = 0 then 1 else 0 end)) desc";
		List<Object> list = session.createQuery(sql).list();
		return list;
	}

	@Override
	public List<Object> totalStaff() {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT Count(r.id) from Staff r ";
			
		List<Object> list = session.createQuery(sql).list();		
		return list;
	}

	@Override
	public List<Object> totalDepartment() {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT Count(r.id) from Depart r ";
			
		List<Object> list = session.createQuery(sql).list();		
		return list;
	}

	@Override
	public List<Object> totalSalary() {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT sum(r.basicsalary*r.salary_factor+r.allowance) from Salary r ";
			
		List<Object> list = session.createQuery(sql).list();		
		return list;
	}
	@Override
	public List<Object> totalContract() {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT Count(c.id)  from Contract c ";
			
		List<Object> list = session.createQuery(sql).list();	
	
		return list;
	}

	@Override
	public List<Object> totalRecord() {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT Count(r.id)  from Record r where r.type = 1 ";
			
		List<Object> list = session.createQuery(sql).list();	

		return list;
	}
	@Override
	public List<Object> totalRecord1() {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT Count(r.id)  from Record r where r.type = 0 ";
			
		List<Object> list = session.createQuery(sql).list();	

		return list;
	}

	@Override
	public List<Object> totalDependent() {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT Count(d.id)  from Dependent d  ";
			
		List<Object> list = session.createQuery(sql).list();	

		return list;
	}
	@Override
	public List<Object> totalstaffachievement(String id) {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT Count(r.id)  from Record r where r.staff.id= '" + id + "' ";
			
		List<Object> list = session.createQuery(sql).list();	

		return list;
	}
	@Override
	public List<Object> totalstaffachievement1(String id) {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT Count(r.id) from Record r where r.staff.id = '" + id + "' and r.type = 0 ";
			
		List<Object> list = session.createQuery(sql).list();	

		return list;
	}
	@Override
	public List<Object> totalstaffachievement2(String id) {
		Session session = this.factory.getCurrentSession();
		String sql = "SELECT Count(r.id) from Record r where r.staff.id = '" + id + "' and r.type = 1 ";
			
		List<Object> list = session.createQuery(sql).list();	

		return list;
	}
	

}
