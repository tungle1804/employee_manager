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
@Table(name="labor_contract")
public class Contract {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="type_contract")
	private String type;
	@Column(name="from_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat( pattern = "dd/MM/yyyy")
	private Date fromdate;
	@Column(name="to_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat( pattern = "dd/MM/yyyy")
	private Date todate;
	@ManyToOne
	@JoinColumn(name="staffid")
	private Staff staff;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
