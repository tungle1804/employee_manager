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

import poly.dao.DepartmentDAO;
import poly.dao.DependentDAO;
import poly.entity.Dependent;
import poly.entity.Salary;
import poly.entity.Staff;
import poly.entity.User;

@Transactional
@Service("DependentDAO")
@Repository
public class DependentDAOImpl implements DependentDAO {
	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	@SuppressWarnings("unchecked")
	public List<Dependent> listDependent(Integer offset, Integer maxResult) {
		  return factory.openSession()
	                .createCriteria(Dependent.class)
	                .setFirstResult(offset!=null?offset:0)
	                .setMaxResults(maxResult!=null?maxResult:5)
	                .list();
	}

	@SuppressWarnings("unchecked")
	public Long count5() {
		 return (Long)factory.openSession()
	                .createCriteria(Dependent.class)
	                .setProjection(Projections.rowCount())
	                .uniqueResult();
	}

	@Override
	public boolean creatDependent(Dependent dependent) {
		Session session = this.factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		try {
			session.save(dependent);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean deleteDependent(String id) {
		Dependent dependent = infoDependent(id);
		if (dependent == null) {
			return false;
		}
		try {
			Session session = this.factory.getCurrentSession();
			session.delete(dependent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Dependent infoDependent(String id) {
		Session session = factory.openSession();
		try {
			Dependent dependent = (Dependent) session.get(Dependent.class, id);
			return dependent;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	@Override
	public boolean editDependent(Dependent dependent) {
		try {
			Session session = this.factory.getCurrentSession();
			session.update(dependent);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public int checkcodeID(String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Dependent WHERE id = '" + id + "'";
		Query query = session.createQuery(hql);
		List<Dependent> list = query.list();
		return list.size();

	}

}
