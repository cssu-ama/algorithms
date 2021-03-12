public class MergeSort {
  public static void merge(int array[], int left, int middle, int right) {
		int leftArraySize = middle - left + 1;
		int rightArraySize = right - middle;

		int leftArray[] = new int[leftArraySize];
		int rightArray[] = new int[rightArraySize];

		for (int i = 0; i < leftArraySize; ++i) {
			leftArray[i] = array[left + i];
    }

		for (int j = 0; j < rightArraySize; ++j) {
			rightArray[j] = array[middle + 1 + j];
    }

		int i = 0, j = 0;

		int k = left;
		while (i < leftArraySize && j < rightArraySize) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < leftArraySize) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightArraySize) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}
}
