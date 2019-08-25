package cl.foxcorp.mov.model;

public class SerieModel {
	private int id;
	private String name;
	private TuplaModel genre;
	private Long episodes;
	private Long yearFrom;
	private Long yearTo;
	private Long seasons;
	private TuplaModel emitter;
	private String created;
	private String origin;
	private TuplaModel state;

	public SerieModel(int id, String name, TuplaModel genre, Long episodes, Long yearFrom, Long yearTo, Long seasons,
			TuplaModel emitter, String created, String origin, TuplaModel state) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.episodes = episodes;
		this.yearFrom = yearFrom;
		this.yearTo = yearTo;
		this.seasons = seasons;
		this.emitter = emitter;
		this.created = created;
		this.origin = origin;
		this.state = state;
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

	public TuplaModel getGenre() {
		return genre;
	}

	public void setGenre(TuplaModel genre) {
		this.genre = genre;
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

	public TuplaModel getEmitter() {
		return emitter;
	}

	public void setEmitter(TuplaModel emitter) {
		this.emitter = emitter;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public TuplaModel getState() {
		return state;
	}

	public void setState(TuplaModel state) {
		this.state = state;
	}

}
