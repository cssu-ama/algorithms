public class InsertionSort { 
  public static void sort(int array[]) {
    sort(array, array.length);
  }

  private static void sort(int array[], int n) { 
    if (n <= 1) { return; }

    sort(array, n - 1); 

    int last = array[n - 1]; 
    int j = n - 2; 

    while (j >= 0 && array[j] > last) { 
      array[j + 1] = array[j]; 
      j--; 
    }

    array[j + 1] = last; 
  }
} 
