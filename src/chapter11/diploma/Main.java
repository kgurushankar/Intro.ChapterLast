package chapter11.diploma;

public class Main {

	public static void main(String[] args) {
		Diploma diploma1 = new Diploma("Murray Smith", "Gardening");
		System.out.println(diploma1);
		System.out.println();
		Diploma diploma2 = new DiplomaWithHonors("Lisa Smith", "Evolutionary Psychology");
		System.out.println(diploma2);
	}

}
