package poly.dao;

import java.io.Serializable;
import java.util.List;

import poly.entity.Contract;
import poly.entity.Depart;
import poly.entity.Record;
import poly.entity.Staff;

public interface AchievementDAO extends Serializable{
	public List<Record> searchAchievement(String search);
	public List<Record> listAchievement(Integer offset, Integer maxResult);
	public Long count3();
	public boolean createAchievement(Record record);
	public boolean deleteAchievement(String id);
	public boolean sentMail(String to, Boolean tieude, String noidung);
	public boolean sentMailPass(String to, String tieude, String noidung);
	public Record infoAchievement(String id);
	public boolean editAchievement(Record record);
	int checkCodeId(String codeId);

}
