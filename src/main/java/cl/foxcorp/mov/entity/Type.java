package cl.foxcorp.mov.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="type")
public class Type 
{
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable = false)
	private String name;	
	
	@Column(name="createDate", nullable = false)
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
		
}
