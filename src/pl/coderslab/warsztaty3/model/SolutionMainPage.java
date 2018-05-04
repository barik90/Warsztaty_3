package pl.coderslab.warsztaty3.model;

import java.sql.Date;

public class SolutionMainPage {

	private String username;
	private String exerciseTitle;
	private Date created;
	private int id;

	public SolutionMainPage() {
	}

	public SolutionMainPage(String username, String exerciseTitle, Date created, int id) {
		super();
		this.username = username;
		this.exerciseTitle = exerciseTitle;
		this.created = created;
		this.id = id;
	}
	public SolutionMainPage(String username, String exerciseTitle, Date created) {
		super();
		this.username = username;
		this.exerciseTitle = exerciseTitle;
		this.created = created;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getExerciseTitle() {
		return exerciseTitle;
	}

	public void setExerciseTitle(String exerciseTitle) {
		this.exerciseTitle = exerciseTitle;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SolutionMainPage [username=" + username + ", exerciseTitle=" + exerciseTitle + ", created=" + created
				+ ", id=" + id + "]";
	}
	
}
