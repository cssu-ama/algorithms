import java.util.Arrays;

public class MergeSort {
  private static int mergeAndCount(int[] array, int left, int middle, int right) {
    int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
    int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

    int i = 0, j = 0, k = left, swaps = 0;

    while (i < leftArray.length && j < rightArray.length) {
      if (leftArray[i] <= rightArray[j]) {
        array[k++] = leftArray[i++];
      } else {
        array[k++] = rightArray[j++];
	swaps += (middle + 1) - (left + i);
      }
    }

    while (i < leftArray.length) {
      array[k++] = leftArray[i++];
    }

    while (j < rightArray.length) {
      array[k++] = rightArray[j++];
    }

    return swaps;
  }

  public static int countInversion(int[] array) {
    return mergeSortAndCount(array, 0, array.length - 1);
  }

  private static int mergeSortAndCount(int[] array, int left, int right) {
    int count = 0;

    if (left < right) {
      int middle = (left + right) / 2;

      count += mergeSortAndCount(array, left, middle);
      count += mergeSortAndCount(array, middle + 1, right);

      count += mergeAndCount(array, left, middle, right);
    }

    return count;
  }
}
