package application;

public class Team {
	private String TeamName;
	private String Name, Major, Rank;
	private int ID,Team;

	public Team(int ID, String Name, String Major,int Team, String TeamName,  String Rank) {
		super();
		this.Team = Team;
		this.TeamName = TeamName;
		this.Name = Name;
		this.Major = Major;
		this.Rank = Rank;
		this.ID = ID;
	}

	public int getTeam() {
		return Team;
	}

	public void setTeam(int Team) {
		this.Team = Team;
	}

	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String TeamName) {
		this.TeamName = TeamName;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String Major) {
		this.Major = Major;
	}

	public String getRank() {
		return Rank;
	}

	public void setRank(String Rank) {
		this.Rank = Rank;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

}