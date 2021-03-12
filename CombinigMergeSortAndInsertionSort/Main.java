public class Main {
  public static void main(String args[]) {
    int array[] = { 12, 11, 13, 5, 6, 7 };
  
    System.out.println("Given Array");
    Sort.printArray(array);
  
    Sort.sort(array);

    System.out.println("Sorted array");
    Sort.printArray(array);
  }
}
