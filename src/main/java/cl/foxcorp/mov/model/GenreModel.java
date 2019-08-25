package cl.foxcorp.mov.model;

public class GenreModel {
	private int id;
	private String name;

	public GenreModel(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public GenreModel() {
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

}
