package cl.foxcorp.mov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class State {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "code", length = 3)
	private String code;

	@Column(name = "description", nullable = false, length = 50)
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public State(int id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}

	public State() {

	}
}
