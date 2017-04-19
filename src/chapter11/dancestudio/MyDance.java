package chapter11.dancestudio;

public class MyDance extends AbstractDance {
	private static DanceStep[] steps = { 
			new DanceStep(0, 0, 0, 0, 0, 50, 0, 0), 
			new DanceStep(0, 50, 0, 0, 0, 0, 0, 0),
			new DanceStep(0, 0, 0, 0, 0, -100, 0, 0 ), 
			new DanceStep(0, -100, 0, 0, 0, 0, 0, 0),
			new DanceStep(0, 0, 0, 0, 0, 50, 0, 0), 
			new DanceStep(0, 50, 0, 0, 0, 0, 0, 0)
			};

	private static int[] rhythm = { 1, 1, 1, 1, 1, 1 };

	public MyDance() {
		super(steps, rhythm);
	}

	public String getName() {
		return "Walk";
	}

	public int getTempo() {
		return 700;
	}
}
