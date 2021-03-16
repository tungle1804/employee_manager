package poly.dao.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.StaffDAO;
import poly.entity.Contract;
import poly.entity.Record;
import poly.entity.Staff;

@Transactional
@Service("StaffDAO")
@Repository
public class StaffDAOImpl implements StaffDAO {

	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
    public List<Staff> listStaff(Integer offset, Integer maxResults) {
        return factory.openSession()
                .createCriteria(Staff.class)
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:5)
                .list();
    }

    @SuppressWarnings("unchecked")
    public Long count() {
        return (Long)factory.openSession()
                .createCriteria(Staff.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> searchStaff(String search) {
		
		Session session = factory.getCurrentSession();
		String hql = "from Staff where name like '%" + search + "%'";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
          System.out.println(query);
		return list;
	}

	@Override
	public boolean creatStaff(Staff staff) {
			Session session = this.factory.openSession();
			org.hibernate.Transaction t = session.beginTransaction();
			try {
				session.save(staff);
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
	public Staff infoStaff(String id) {
		Session session = factory.openSession();
		try {
			Staff staff = (Staff) session.get(Staff.class, id);
			return staff;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	@Override
	public boolean editStaff(Staff staff) {
		try {
			Session session = this.factory.getCurrentSession();
			session.update(staff);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public int Staffrecord(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		String hql = "select r.staff.id FROM Record r WHERE r.staff.id = '" + id + "'";
		Query query = session.createQuery(hql);
		List<Record> list = query.list();

		return list.size();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public int Staffcontract(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		String hql = "select c.staff.id FROM Contract c WHERE c.staff.id = '" + id + "'";
		Query query = session.createQuery(hql);
		List<Contract> list = query.list();
	
		return list.size();
		
	}

	@Override
	public boolean deleteStaff(String id) {
		Staff staff = infoStaff(id);
		if (staff == null) {
			return false;
		}if(Staffrecord(id)>0||Staffcontract(id)>0) {
		
			return false;
		}
		try {
			Session session = this.factory.getCurrentSession();
			session.delete(staff);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Staff> listfromStaff() {
		org.hibernate.Session session = factory.getCurrentSession();
		String hql = "from Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}

	@Override
	public Staff infoStaffEmail(String Email) {
		Session session =factory.getCurrentSession();
		List<Staff> list = session.createQuery("from Staff S where S.email = '" + Email + "'").list();
		if (list.isEmpty()) {
			return null;
		}
		Staff staff = list.get(0);
		System.out.println("ssssss");
		return staff;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public int checkCodeId(String codeId) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff WHERE id = '" + codeId + "'";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list.size();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int checkEmail(String email) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff WHERE email = '" + email + "'";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
	
		return list.size();
	}

	@Override
	public List<Object> staffdepartment(String id) {
		org.hibernate.Session session = factory.getCurrentSession();
		String hql = "select s.photo,s.name,s.phone,s.notes from Staff s where s.depart.id='"+id+"'";
		Query query = session.createQuery(hql);
		List<Object> list = query.list();
		
		return list;
	}
	
	

	

	

	

}
