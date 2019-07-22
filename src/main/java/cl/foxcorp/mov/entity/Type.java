package cl.foxcorp.mov.entity;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "types")
public class Type {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Basic	
	@Column(name = "createDate", nullable = false, insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public Type(int id, String name, Calendar createDate) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}

	public Type() {

	}

}
