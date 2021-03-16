package poly.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Salarys")
public class Salary {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name="basic_salary")
	private float basicsalary;
	@Column(name="allowance")
	private float allowance;
	@Column(name="salary_factor")
	private float salary_factor;
	
	@OneToMany(mappedBy = "salary", fetch = FetchType.LAZY)
	private Collection<Staff> staff;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getBasicsalary() {
		return basicsalary;
	}

	public void setBasicsalary(float basicsalary) {
		this.basicsalary = basicsalary;
	}

	public float getAllowance() {
		return allowance;
	}

	public void setAllowance(float allowance) {
		this.allowance = allowance;
	}

	public float getSalary_factor() {
		return salary_factor;
	}

	public void setSalary_factor(float salary_factor) {
		this.salary_factor = salary_factor;
	}

	public Collection<Staff> getStaff() {
		return staff;
	}

	public void setStaff(Collection<Staff> staff) {
		this.staff = staff;
	}

}
