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
import poly.entity.Depart;
import poly.entity.Staff;
import poly.entity.User;

@Transactional
@Service("DepartmentDAO")
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	@Autowired
	public SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	@SuppressWarnings("unchecked")
    public List<Depart> listDepartment(Integer offset, Integer maxResults) {
        return factory.openSession()
                .createCriteria(Depart.class)
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:5)
                .list();
    }

    @SuppressWarnings("unchecked")
    public Long count2() {
        return (Long)factory.openSession()
                .createCriteria(Depart.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

	@Override
	public boolean creatDepartment(Depart depart) {
		Session session = this.factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		try {
			session.save(depart);
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
	public int departstaff(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		String hql = "select s.depart.id FROM Staff s WHERE s.depart.id = '" + id + "'";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list.size();
		
	}

	@Override
	public boolean deleteDepartment(String id) {
		Depart depart = infoDepartment(id);
		if (depart == null) {
			
			return false;
		}
		if(departstaff(id)>0) {
		
			return false;
		}
		try {
			Session session = this.factory.getCurrentSession();
			session.delete(depart);
			System.out.println("lỗiiiiiiiiiiiiiiiiiiiii");
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}

	@Override
	public Depart infoDepartment(String id) {
		Session session = factory.openSession();
		try {
			Depart depart = (Depart) session.get(Depart.class, id);
		
			return depart;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}
	@Override
	public boolean editDepartment(Depart depart) {
		try {
			Session session = this.factory.getCurrentSession();
			session.update(depart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Depart> searchDepart(String search) {
		Session session = factory.getCurrentSession();
		String hql = "from Depart where name like '%"+search+"%'";
		
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
	


		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int checkCodeId(String codeId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart WHERE id = '" + codeId + "'";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		return list.size();
	}

	@Override
	public List<Depart> listfromDepartment() {
		org.hibernate.Session session = factory.getCurrentSession();
		String hql = "from Depart";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		return list;
	}
}
