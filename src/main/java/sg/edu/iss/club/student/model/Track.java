package sg.edu.iss.club.student.model;

public enum Track {
	SA("System Analysis"),
	SE("System Engineering"),
	IS("Intelligent Systems");
	
	private final String displayValue;
	
	private Track(String displayValue) {
		this.displayValue =  displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}

}
