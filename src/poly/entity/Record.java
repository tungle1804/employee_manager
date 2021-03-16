package poly.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Records")
public class Record {
	@Id
	@GeneratedValue
	private String id;
	@Column(name="type")
	private boolean type;
	@Column(name="reason")
	private String reason;
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat( pattern = "dd/MM/yyyy")
	private Date date;
	@ManyToOne
	@JoinColumn(name="staffid")
	private Staff staff;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}	
	
}
