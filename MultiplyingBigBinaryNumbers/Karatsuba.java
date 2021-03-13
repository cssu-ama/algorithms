public class Karatsuba {
  private static int max(int x, int y) {
		return (x > y) ? x : y;
	}

	private static String[] strCopy(long index, String string) {
		String	first = "";
    String last = "";
		
    long midIndex = string.length() - index;
		
    for (int i = 0; i < midIndex; i++) {
			first += string.charAt(i);
		}

		for (int i = (int) (midIndex); i < string.length(); i++) {
			last += string.charAt(i);
		}

		return new String[] {first, last};
	}
	
	public static long multiply(long x, long y) {
		if (x < 10 || y < 10) {
			return x * y;
		} else {
			String X = Integer.toString((int) (x));
			String Y = Integer.toString((int) (y));

			long 	length = max(X.length(), Y.length());
			long middle = length / 2;
			
      long Xl = Integer.parseInt(strCopy(middle, X)[0]);
			long Xr = Integer.parseInt(strCopy(middle, X)[1]);

      long Yl = Integer.parseInt(strCopy(middle, Y)[0]);
      long Yr = Integer.parseInt(strCopy(middle, Y)[1]);

			long P1 = multiply(Xl, Yl);
			long P2 = multiply(Xr, Yr);
			long P3 = multiply((Xr + Xl), (Yr + Yl));

			return (long) (P1 * Math.pow(10, 2 * middle) + ((P3 - P1 - P2) * Math.pow(10, middle)) + P2);
		}
	}
}
