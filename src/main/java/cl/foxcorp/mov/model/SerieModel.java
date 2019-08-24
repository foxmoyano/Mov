package cl.foxcorp.mov.model;

public class SerieModel {
	private int id;
	private String name;
	private Long type;
	private Long episodes;
	private Long yearFrom;
	private Long yearTo;
	private Long seasons;
	private Long emitter;

	public SerieModel(int id, String name, Long type, Long episodes, Long yearFrom, Long yearTo, Long seasons,
			Long emitter) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.episodes = episodes;
		this.yearFrom = yearFrom;
		this.yearTo = yearTo;
		this.seasons = seasons;
		this.emitter = emitter;
	}

	public SerieModel() {
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

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Long episodes) {
		this.episodes = episodes;
	}

	public Long getYearFrom() {
		return yearFrom;
	}

	public void setYearFrom(Long yearFrom) {
		this.yearFrom = yearFrom;
	}

	public Long getYearTo() {
		return yearTo;
	}

	public void setYearTo(Long yearTo) {
		this.yearTo = yearTo;
	}

	public Long getSeasons() {
		return seasons;
	}

	public void setSeasons(Long seasons) {
		this.seasons = seasons;
	}

	public Long getEmitter() {
		return emitter;
	}

	public void setEmitter(Long emitter) {
		this.emitter = emitter;
	}

}
