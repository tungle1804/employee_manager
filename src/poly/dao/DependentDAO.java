package poly.dao;

import java.io.Serializable;
import java.util.List;

import poly.entity.Dependent;
import poly.entity.Salary;

public interface DependentDAO extends Serializable {
	public List<Dependent> listDependent(Integer offset, Integer maxResult);

	public Long count5();
	public boolean creatDependent(Dependent dependent);
	public boolean deleteDependent(String id);
	public Dependent infoDependent(String id);
	public boolean editDependent(Dependent dependent);

	int checkcodeID(String id);
}
