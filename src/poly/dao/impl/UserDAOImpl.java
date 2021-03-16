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

import poly.dao.UserDAO;
import poly.entity.Staff;
import poly.entity.User;

@Transactional
@Service("UserDAO")
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<User> searchUser(String search) {
		Session session = factory.getCurrentSession();
		String hql = "from User where username like '%"+search+"%'";

		Query query = session.createQuery(hql);
		List<User> list = query.list();


		return list;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser(Integer offset, Integer maxResult) {
		 return factory.openSession()
	                .createCriteria(User.class)
	                .setFirstResult(offset!=null?offset:0)
	                .setMaxResults(maxResult!=null?maxResult:5)
	                .list();
	}

	@SuppressWarnings("unchecked")
	public Long count6() {
		return (Long)factory.openSession()
                .createCriteria(User.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
	}

	@Override
	public User infoUser(String id) {
		Session session = factory.openSession();
		try {
			User user = (User) session.get(User.class, id);
			return user;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	@Override
	public boolean editUser(User user) {
		try {
			Session session = this.factory.getCurrentSession();
			session.update(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean creatUser(User user) {
		Session session = this.factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		try {
			session.save(user);
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
	public boolean deleteUser(String id) {
		User user = infoUser(id);
		
		if (user == null) {
		
			return false;
		}
		try {
			Session session = this.factory.getCurrentSession();
			
			session.delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkUser(String Username , String Password) {
		Session	session = factory.getCurrentSession();	
		User User = (User) session.get(User.class, Username);
		if (User == null) {
			return false;
		}
		if (User.getUsername().equals(Username) && User.getPass().equals(Password)) {
			
			return true;
		}
		return false;
	}
	@Override
	public boolean checkRole(String Username , String Password) {
		Session	session = factory.getCurrentSession();	
		User User = (User) session.get(User.class, Username);
		
		if (User.getRole()==true) {
			return true;
		}
		return false ;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int checkname(String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User WHERE username = '" + name + "'";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list.size();

	}

}
