package application;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;

public class CompData {
	private String cName;
	private String cWebsite;
	private String cDate;

	public CompData(String cName, String cWebsite, String cDate) {
		super();
		this.cName = cName;
		this.cWebsite = cWebsite;
		this.cDate = cDate;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	public String getCWebsite() {
		return cWebsite;
	}

	public void setCWebsite(String cWebsite) {
		this.cWebsite = cWebsite;
	}

	public String getCDate() {
		return cDate;
	}

	public void setCDate(String cDate) {
		this.cDate = cDate;
	}
}