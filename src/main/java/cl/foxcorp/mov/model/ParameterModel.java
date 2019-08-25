package cl.foxcorp.mov.model;

public class ParameterModel {
	private int id;
	private String param;
	private String code;
	private String description;
	private Long orden;

	public ParameterModel(int id, String param, String code, String description, Long orden) {
		super();
		this.id = id;
		this.param = param;
		this.code = code;
		this.description = description;
		this.orden = orden;
	}

	public ParameterModel() {
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

	public Long getOrden() {
		return orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
