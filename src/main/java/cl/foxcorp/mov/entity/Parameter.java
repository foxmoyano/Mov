package cl.foxcorp.mov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "parameters", uniqueConstraints = {@UniqueConstraint(columnNames = {"param", "code"})})
public class Parameter {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "param")
	private String param;

	@Column(name = "code")
	private String code;

	@Column(name = "description")
	private String description;

	@Column(name = "orden", nullable = false)
	private Long order;

	@Column(name = "active")
	private String active;

	public Parameter(int id, String param, String code, String description, Long order, String active) {
		super();
		this.id = id;
		this.param = param;
		this.code = code;
		this.description = description;
		this.order = order;
		this.active = active;
	}

	public Parameter() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}