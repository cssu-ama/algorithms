public class Main {

  public static void main(String args[]) {
    Graph graph = new Graph(5);

    graph.add(0, 1); // lecture 1
    graph.add(0, 2); // lecture 2
    graph.add(1, 2); // lecture 3
    graph.add(1, 3); // lecture 4
    graph.add(2, 3); // lecture 5
    graph.greedyAssigningHall();
  }
}
