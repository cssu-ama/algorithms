import java.util.Arrays;

public class Main {
  public static void main(String[] args) { 
    int array[] = { 12, 11, 13, 5, 6 }; 

    InsertionSort.sort(array);
    
    System.out.println(Arrays.toString(array)); 
  }
} 