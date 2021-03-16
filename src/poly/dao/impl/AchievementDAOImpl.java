package poly.dao.impl;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.AchievementDAO;
import poly.entity.Contract;
import poly.entity.Depart;
import poly.entity.Record;
import poly.entity.Staff;
import poly.entity.User;

@Transactional
@Service("AchievementDAO")
@Repository
public class AchievementDAOImpl implements AchievementDAO {
	@Autowired
	private SessionFactory factory;
	@Autowired
	private JavaMailSender mailer;
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	@SuppressWarnings("unchecked")
	public List<Record> listAchievement(Integer offset, Integer maxResult) {
		  return factory.openSession()
	                .createCriteria(Record.class)
	                .setFirstResult(offset!=null?offset:0)
	                .setMaxResults(maxResult!=null?maxResult:5)
	                .list();
	}

	@SuppressWarnings("unchecked")
	public Long count3() {
		 return (Long)factory.openSession()
	                .createCriteria(Record.class)
	                .setProjection(Projections.rowCount())
	                .uniqueResult();
	}

	@Override
	public boolean createAchievement(Record record) {

		Session session = this.factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		try {
			session.save(record);
			t.commit();
			
			return true;
		} catch (Exception e) {
		t.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean deleteAchievement(String id) {
	        Record record = infoAchievement(id);

		if (record == null) {
			
			return false;
		}	
		try {
			Session session = this.factory.getCurrentSession();
			
			session.delete(record);
			
		
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Record infoAchievement(String id) {
		Session session = factory.openSession();
		try {
			Record record = (Record) session.get(Record.class, id);
			return record;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	@Override
	public boolean editAchievement(Record record) {
		try {
			Session session = this.factory.getCurrentSession();
			session.update(record);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Record> searchAchievement(String search) {
		Session session = factory.getCurrentSession();
		String hql = "from Record where staff.name like '%"+search+"%'";
System.out.println(hql);
		Query query = session.createQuery(hql);
		List<Record> list = query.list();
System.out.println(list);

		return list;
	}
	public boolean sentMail(String to, Boolean tieude, String noidung) {
		try {
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
			helper.setFrom("tungbeng200000@gmail.com", "leanhtung184");
			helper.setTo(to);
			helper.setReplyTo("tungbeng200000@gmail.com", "Anh Tùng");
			helper.setSubject(tieude == true ? "Chúc Mừng & Thông báo khen thưởng" : "Xin Lỗi % Thông báo kỷ luật");
			helper.setText(noidung, true);
			mailer.send(mail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Gửi mail thất bại");
			return false;
		}

	}

	@Override
	public boolean sentMailPass(String to, String tieude, String noidung) {
		try {
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
			helper.setFrom("tungbeng200000@gmail.com", "leanhtung184");
			helper.setTo(to);
			helper.setReplyTo("tungbeng200000@gmail.com", "Anh Tùng");
			helper.setSubject(tieude);
			helper.setText(noidung, true);
//             mail.setContent("<h1>This is actual message</h1>",
//     
			mailer.send(mail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Gửi mail thất bại");
			return false;
		}
		
		

	
}
	@SuppressWarnings("unchecked")
	@Override
	public int checkCodeId(String codeId) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		String hql = "FROM Record WHERE id = '" + codeId + "'";
		Query query = session.createQuery(hql);
		List<Record> list = query.list();
		return list.size();
	}
	
}