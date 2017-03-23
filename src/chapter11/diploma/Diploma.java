package chapter11.diploma;

public class Diploma {
	private String name;
	private String field;

	public Diploma(String fullName, String subjectName) {
		this.name = fullName;
		this.field = subjectName;
	}

	public String toString() {
		return "This certifies that \n" + this.name + "\nhas completed a course in " + this.field;
	}
}
