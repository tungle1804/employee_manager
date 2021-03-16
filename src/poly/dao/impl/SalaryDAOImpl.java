package poly.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.SalaryDAO;
import poly.entity.Contract;
import poly.entity.Depart;
import poly.entity.Salary;
import poly.entity.Staff;

@Transactional
@Service("SalaryDAO")
@Repository
public class SalaryDAOImpl implements SalaryDAO {
	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	@SuppressWarnings("unchecked")
    public List<Salary> listSalary(Integer offset, Integer maxResults) {
        return factory.openSession()
                .createCriteria(Salary.class)
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:5)
                .list();
    }

    @SuppressWarnings("unchecked")
    public Long count4() {
        return (Long)factory.openSession()
                .createCriteria(Salary.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

	@Override
	public boolean creatSalary(Salary salary) {
		Session session = this.factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		try {
			session.save(salary);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public int Salarystaff(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		System.out.println(id);
		String hql = "select s.salary.id FROM Staff s WHERE s.salary.id like '%" + id + "%'";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
	System.out.println(list.size()+"a");
		return list.size();
		
	}
	@Override
	public boolean deleteSalary(String id) {
		Salary salary = infoSalary(id);
		if (salary == null) {
			return false;
		}if(Salarystaff(id)>0) {
			return false;
		}
		try {
			Session session = this.factory.getCurrentSession();
			session.delete(salary);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Salary infoSalary(String id) {
		Session session = factory.openSession();
		try {
			Salary salary = (Salary) session.get(Salary.class, id);
			return salary;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	@Override
	public boolean editSalary(Salary salary) {
		try {
			Session session = this.factory.getCurrentSession();
			session.update(salary);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Salary> listfromSalary() {
		org.hibernate.Session session = factory.getCurrentSession();
		String hql = "from Salary";
		Query query = session.createQuery(hql);
		List<Salary> list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int checkidsalary(String codeId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Salary WHERE id = '" + codeId + "'";
		Query query = session.createQuery(hql);
		List<Salary> list = query.list();
		return list.size();
	}
}
