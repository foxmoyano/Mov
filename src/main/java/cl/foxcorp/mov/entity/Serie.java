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
@Table(name="series")
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
	
	@Column(name="seasons", nullable = false)
	private int seasons;
	
	@JoinColumn(name="state", nullable = false, referencedColumnName="code")
	@ManyToOne
	private State state;
	
	@Column(name="yearFrom", nullable = false)
	private int from;	
	
	@Column(name="yearTo", nullable = false)
	private int to;	

	@Column(name="episodes", nullable = false)
	private int episodes;	

	@Column(name="created", nullable = false)
	private String created;	

	@Column(name="origin", nullable = false)
	private String origin;	

	public int getEpisodes() {
		return episodes;
	}

	public void setEpisodes(int episodes) {
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

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getSeasons() {
		return seasons;
	}

	public void setSeasons(int seasons) {
		this.seasons = seasons;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

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
