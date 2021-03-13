public class Sort {
  private static final int K = 2;

  public static void sort(int array[]) {
    sort(array, 0, array.length - 1);
  }

  private static void sort(int array[], int left, int right) {
    if (right - left <= K) {
      InsertionSort.sort(array, left, right);
    } else {
      int middle = (left + right) / 2;

      sort(array, left, middle);
      sort(array, middle + 1, right);

      MergeSort.merge(array, left, middle, right);
    }
  }

  public static void printArray(int array[]) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + ((i < (array.length - 1)) ? ", " : ""));
    }

    System.out.println();
  }
}
