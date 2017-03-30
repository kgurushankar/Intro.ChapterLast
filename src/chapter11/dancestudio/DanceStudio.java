package chapter11.dancestudio;

public class DanceStudio {
	public static void main(String[] args) {
		DanceFloor danceFloor = new DanceFloor();
		StudentGroup students = new HoppingGroup(danceFloor);
		new DanceLesson(students, danceFloor);
	}
}
