package chapter11.dancestudio;

public class Foxtrot extends AbstractDance {

	private static int[] rhythm = {2, 2, 1, 1, 2, 2, 1, 1};
	private static DanceStep[] steps ={
	           new DanceStep(0,  50,   0, 0,    0,   0,   0, 0),
	           new DanceStep(0,   0,   0, 0,    0,   100,   0, 0),
	           new DanceStep(0,   50,   -50, 0,    0,  0,  0, 0),
	           new DanceStep(0,   0,   0, 0,    0,  0,  -50, 0),
	           //Return to start
	           new DanceStep(0,  -50,   0, 0,    0,   0,   0, 0),
	           new DanceStep(0,   0,   0, 0,    0,   -100,   0, 0),
	           new DanceStep(0,   0,   0, 0,    0,  0,  50, 0),
	           new DanceStep(0,   -50,   50, 0,    0,  0,  0, 0)
	           };

	public Foxtrot() {
		super(steps, rhythm);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Foxtrot";
	}

	@Override
	public int getTempo() {
		// TODO Auto-generated method stub
		return 700;
	}

}
