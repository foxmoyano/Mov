package cl.foxcorp.mov.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "series")
public class Serie {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "createDate", nullable = false, insertable = false, updatable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createDate;

	@JoinColumn(name = "genre", nullable = false)
	@ManyToOne
	private Genre genre;

	@JoinColumn(name = "emitter", nullable = false)
	@ManyToOne
	private Emitter emitter;

	@Column(name = "seasons", nullable = false)
	private Long seasons;
	
	@JoinColumn(name = "state", nullable = false, referencedColumnName="id")
	@ManyToOne	
	private Parameter state;

	@Column(name = "yearFrom", nullable = false)
	private Long from;

	@Column(name = "yearTo", nullable = false)
	private Long to;

	@Column(name = "episodes", nullable = false)
	private Long episodes;

	@Column(name = "created", nullable = false)
	private String created;

	@Column(name = "origin", nullable = false)
	private String origin;

	public Long getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Long episodes) {
		this.episodes = episodes;
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

	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	public Long getSeasons() {
		return seasons;
	}

	public void setSeasons(Long seasons) {
		this.seasons = seasons;
	}

	public Parameter getState() {
		return state;
	}

	public void setState(Parameter state) {
		this.state = state;
	}

	public Emitter getEmitter() {
		return emitter;
	}

	public void setEmitter(Emitter emitter) {
		this.emitter = emitter;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
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

	public Serie(int id, String name, Calendar createDate, Genre genre, Emitter emitter, Long seasons, Parameter state,
			Long from, Long to, Long episodes, String created, String origin) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.genre = genre;
		this.emitter = emitter;
		this.seasons = seasons;
		this.state = state;
		this.from = from;
		this.to = to;
		this.episodes = episodes;
		this.created = created;
		this.origin = origin;
	}

	public Serie() {

	}
}
