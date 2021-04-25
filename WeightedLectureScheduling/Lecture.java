/**
 * Lecture class
 * Using this class for schedule lectures with the maximum value
 */

public class Lecture {

  public int startTime;
  public int endTime;
  public int value;

  // Constructor
  public Lecture(int startTime, int endTime, int value) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.value = value;
  }

  // Driver method
  public static void main(String[] args) {
    Lecture[] lectures = new Lecture[4];

    lectures[0] = new Lecture(3, 10, 20);
    lectures[1] = new Lecture(1, 2, 50);
    lectures[2] = new Lecture(6, 19, 100);
    lectures[3] = new Lecture(2, 100, 200);

    System.out.println("The maximum value is: " + findMaxValue(lectures));
  }

  // Find the latest lecture (in sorted array) that doesn't
  // conflict with the lectures[index]
  public static int latestNonConflict(Lecture lectures[], int index) {
    for (int i = index - 1; i >= 0; i--) {
      if (lectures[i].endTime <= lectures[index].startTime) {
        return i;
      }
    }

    return -1;
  }

  // The main function that returns the maximum possible
  // values from given array of lectures
  public static int findMaxValue(Lecture lectures[]) {
    // Sorting the lectures by end time
    for (int i = 0; i < lectures.length - 1; i++) {
      for (int j = 0; j < lectures.length - 1 - i; j++) {
        if (lectures[j].endTime > lectures[j + 1].endTime) {
          Lecture temp = lectures[j];
          lectures[j] = lectures[j + 1];
          lectures[j + 1] = temp;
        }
      }
    }

    // Create an array to store solutions of subproblems.  table[i]
    // stores the value for lectures till lectures[i] (including lectures[i])
    int[] table = new int[lectures.length];
    table[0] = lectures[0].value;

    // Fill entries in M[] using recursive property
    for (int i = 1; i < lectures.length; i++) {
      // Find value including the current lecture
      int includingValue = lectures[i].value;
      int latest = latestNonConflict(lectures, i);

      if (latest != -1) {
        includingValue += table[latest];
      }

      // Store maximum of including and excluding
      table[i] = Integer.max(includingValue, table[i - 1]);
    }

    int result = table[lectures.length - 1];
    return result;
  }
}
