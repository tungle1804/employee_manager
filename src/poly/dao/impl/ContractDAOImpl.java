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

import poly.dao.ContractDAO;
import poly.entity.Contract;
import poly.entity.Dependent;
import poly.entity.Staff;
import poly.entity.User;

@Transactional
@Service("ContractDAO")
@Repository
public class ContractDAOImpl implements ContractDAO {
	@Autowired
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

//	@Override
//	public List<Contract> listContract() {
//		Session session = factory.getCurrentSession();
//		String hql = "FROM Contract";
//		Query query = session.createQuery(hql);
//		List<Contract> list = query.list();
//		return list;
//	}
	@SuppressWarnings("unchecked")
    public List<Contract> listContract(Integer offset, Integer maxResults) {
        return factory.openSession()
                .createCriteria(Contract.class)
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:5)
                .list();
    }
	 @SuppressWarnings("unchecked")
	    public Long count1() {
	        return (Long)factory.openSession()
	                .createCriteria(Contract.class)
	                .setProjection(Projections.rowCount())
	                .uniqueResult();
	    }
	 
		@Override
		public boolean creatContract(Contract contract) {
			

			Session session = this.factory.openSession();
			org.hibernate.Transaction t = session.beginTransaction();
			try {
				session.save(contract);
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
		public boolean deleteContract(String id) {
			// TODO Auto-generated method stub
			Contract contract = infoContract(id);

			if (contract == null) {
				
				return false;
			}
			try {
				Session session = this.factory.getCurrentSession();
				
				session.delete(contract);
				
			
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		@Override
		public boolean editContract(Contract contract) {
			// TODO Auto-generated method stub
			try {
				Session session = this.factory.getCurrentSession();
				session.update(contract);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		

		public Contract infoContract(String id) {
			Session session = factory.openSession();
			try {
				Contract contract = (Contract) session.get(Contract.class, id);
				return contract;
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				session.flush();
				session.close();
			}
			return null;
		}

		@Override
		public List<Contract> searchContract(String search) {
			Session session = factory.getCurrentSession();
			String hql = "from Contract where staff.name like '%"+search+"%'";

			Query query = session.createQuery(hql);
			List<Contract> list = query.list();


			return list;
		}
		@SuppressWarnings("unchecked")
		@Override
		public int checkcodeID(String id) {
			Session session = factory.getCurrentSession();
			String hql = "FROM Contract WHERE id = '" + id + "'";
			Query query = session.createQuery(hql);
			List<Contract> list = query.list();
			return list.size();

		}
//	
	
}
