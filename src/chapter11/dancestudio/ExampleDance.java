package chapter11.dancestudio;

public class ExampleDance extends AbstractDance {

	private static DanceStep[] steps = 
        {
           new DanceStep(0,  50,   0, 0,    0,   0,   0, 0),
           new DanceStep(0,   0,   0, 0,    0,   50,   0, 0),
           new DanceStep(0,   0,   -50, 0,    0,  0,  0, 0),
           new DanceStep(0,   0,  0, 0,    0,   0,   -50, 0),
           new DanceStep(0,   -50,   0, 0,    0, 0,   0, 0),
           new DanceStep(0,   0,   0, 0,    0,   -50,   0, 0),
           new DanceStep(0, 0, 0, 0,   0, 0, 50, 0),
           new DanceStep(0, 0, 50, 0,    0, 0, 0, 0),
           //new DanceStep(0, 50, 0, 0,    0,   0,   0, 0),
           //new DanceStep(0,   0,   0, 0,    0,   50, 0, 0),
        };
      private static int[] rhythm = {2, 2, 2, 2};
      public ExampleDance()
      {
        super(steps, rhythm);
      }
      public String getName()
      {
        return "Disco";
      }
      public int getTempo()
      {
        return 800;
      }

}
