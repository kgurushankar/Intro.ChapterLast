package chapter11.dancestudio;

public interface Dance
{
  DanceStep getStep(int i);
  int getTempo();
  int getBeat(int i);
}
