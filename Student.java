package application;

public class Student {
	private String Name,Major,Rank;
	private int ID;
	public Student(int ID,String Name, String Major, String Rank) {
		super();
		this.Name = Name;
		this.Major = Major;
		this.Rank = Rank;
		this.ID = ID;
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
