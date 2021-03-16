package poly.entity;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="Staffs")
public class Staff {
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	@Column(name="gender")
	private boolean gender;
	@DateTimeFormat( pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name="birthday")
	private Date birthday;
	@Column(name="photo")
	private String photo;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="notes")
	private String notes;
	@ManyToOne
	@JoinColumn(name="departid")
	private Depart depart;
	@ManyToOne
	@JoinColumn(name="salaryid")
	private Salary salary;
	@OneToMany(mappedBy = "staff",fetch = FetchType.LAZY)
	private Collection<Contract> contract;
	@OneToMany(mappedBy = "staff",fetch = FetchType.LAZY)
	private Collection<Dependent> dependent;
	@OneToMany(mappedBy = "staff", fetch = FetchType.LAZY)
	private Collection<Record> record;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Depart getDepart() {
		return depart;
	}
	public void setDepart(Depart depart) {
		this.depart = depart;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public Salary getSalary() {
		return salary;
	}	
	
	
	
	

}
