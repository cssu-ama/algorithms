import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

  private int lecturesQuantity;
  private LinkedList<Integer> lectures[]; // lectures list

  Graph(int lecturesQuantity) {
    this.lecturesQuantity = lecturesQuantity;
    lectures = new LinkedList[lecturesQuantity];

    for (int i = 0; i < lecturesQuantity; ++i) {
      lectures[i] = new LinkedList<Integer>();
    }
  }

  // function to add a lecture into the graph
  public void add(int startTime, int endTime) {
    lectures[startTime].add(endTime);
    lectures[endTime].add(startTime);
  }

  public void greedyAssigningHall() {
    int result[] = new int[lecturesQuantity];

    Arrays.fill(result, -1);

    result[0] = 0;

    /*
      a temporary array to store the available lecture halls. False
      value of available[hallIndex] would mean that the lecture hall hallIndex is
      assigned to one of its lectures
    */
    boolean available[] = new boolean[lecturesQuantity];

    // Initially, all halls are available
    Arrays.fill(available, true);

    // Assign halls to remaining (lecturesQuantity - 1) lectures
    for (int u = 1; u < lecturesQuantity; u++) {
      // Process all lectures and flag their halls
      // as unavailable
      Iterator<Integer> iterator = lectures[u].iterator();
      while (iterator.hasNext()) {
        int i = iterator.next();
        if (result[i] != -1) available[result[i]] = false;
      }

      // Find the first available hall
      int hallIndex;
      for (hallIndex = 0; hallIndex < lecturesQuantity; hallIndex++) {
        if (available[hallIndex]) break;
      }

      result[u] = hallIndex; // Assign the found hall

      // Reset the values back to true for the next iteration
      Arrays.fill(available, true);
    }

    // print the result
    for (int u = 0; u < lecturesQuantity; u++) System.out.println(
      "Lecture " + (u + 1) + " will be held in hall number " + (result[u] + 1)
    );

    Arrays.sort(result);

    int counter = 1;
    for (int i = 0; i < result.length - 1; i++) {
      if (result[i] != result[i + 1]) counter++;
    }

    System.out.println(
      "Minimum number of halls which are used to hold a lecture: " + counter
    );
  }
}
