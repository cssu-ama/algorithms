public class InsertionSort {
  public static void sort(int array[], int left, int right) {
    for (int i = left; i < right; i++) {
      int key = array[i + 1];
      int j = i + 1;

      while (j > left && array[j - 1] > key) {
        array[j] = array[j - 1];
        j--;
      }

      array[j] = key;
    }
  }
}
