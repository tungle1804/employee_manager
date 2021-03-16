package poly.dao;

import java.io.Serializable;
import java.util.List;

import poly.entity.Contract;
import poly.entity.Staff;
import poly.entity.User;

public interface ContractDAO extends Serializable {
	public List<Contract> searchContract(String search);
	public List<Contract> listContract(Integer offset, Integer maxResult);
	public Long count1();
	public boolean creatContract(Contract contract);
	public boolean deleteContract(String id);
	public Contract infoContract(String id);
	public boolean editContract(Contract contract);
	int checkcodeID(String id);

}
