public class Main {

  // Matrix Ai has dimension dimensions[i - 1] * dimensions[i]
  private static int MatrixChainOrder(int dimensions[], int i, int j) {
    if (i == j) return 0;

    int min = Integer.MAX_VALUE;

    for (int k = i; k < j; k++) {
      int count =
        MatrixChainOrder(dimensions, i, k) +
        MatrixChainOrder(dimensions, k + 1, j) +
        dimensions[i - 1] *
        dimensions[k] *
        dimensions[j];

      if (count < min) min = count;
    }

    return min;
  }

  public static void main(String args[]) {
    int dimensions[] = new int[] { 1, 2, 3, 4, 3 };
    int DIMENSIONS_QUANTITY = dimensions.length;
    int FIRST_MATRIX_NUMBER = 1;

    System.out.println(
      "Minimum number of multiplications is " + MatrixChainOrder(dimensions, FIRST_MATRIX_NUMBER, DIMENSIONS_QUANTITY)
    );
  }
}
