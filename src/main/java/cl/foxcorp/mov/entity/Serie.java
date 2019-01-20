package cl.foxcorp.mov.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="serie")
public class Serie 
{
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable = false)
	private String name;	
	
	@Column(name="createDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createDate;
	
	@JoinColumn(name="type", nullable = false)
	@ManyToOne
	private Type type;	

	@JoinColumn(name="emitter", nullable = false)
	@ManyToOne
	private Emitter emitter;	

	public Emitter getEmitter() {
		return emitter;
	}

	public void setEmitter(Emitter emitter) {
		this.emitter = emitter;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

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
