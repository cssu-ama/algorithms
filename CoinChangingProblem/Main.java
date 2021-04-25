public class Main {

  public static int minCoins(int coins[], int cents) {
    int table[] = new int[cents + 1];

    // Base case (If given value of cents is 0)
    table[0] = 0;

    // Initialize all table values as Infinite
    for (int i = 1; i <= cents; i++) {
      table[i] = Integer.MAX_VALUE;
    }

    // Compute minimum coins required for all
    // values from 1 to cents
    for (int i = 1; i <= cents; i++) {
      // Go through all coins smaller than i
      for (int j = 0; j < coins.length; j++) if (coins[j] <= i) {
        int subResult = table[i - coins[j]];
        if (subResult != Integer.MAX_VALUE && subResult + 1 < table[i]) {
          table[i] = subResult + 1;
        }
      }
    }

    if (table[cents] == Integer.MAX_VALUE) {
      return -1;
    }

    return table[cents];
  }

  // Driver program
  public static void main(String[] args) {
    int c = 5;
    int k = 10;
    int coins[] = generateAvailableCoins(c, k);

    int cents = 31;
    System.out.println("Minimum coins required is " + minCoins(coins, cents));
  }

  // Function to generate coins wich value is a power of c
  public static int[] generateAvailableCoins(int c, int k) {
    int[] coins = new int[k + 1];

    for (int i = 0; i < coins.length; i++) {
      coins[i] = (int) Math.pow(c, i);
    }

    return coins;
  }
}
