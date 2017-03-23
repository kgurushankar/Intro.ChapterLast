package chapter11.diploma;

public class DiplomaWithHonors extends Diploma {

	public DiplomaWithHonors(String fullName, String subjectName) {
		super(fullName, subjectName);
	}

	public String toString() {
		return super.toString() + "\n*** with honors*** ";
	}
}
