public class Main {

	private static String max(String x, String y) {
		return (x.length() > y.length()) ? x : y;
	}

	private static String LPS(String seq, int i, int j) {
		if (i == j) {
			return seq.substring(i, i + 1);
		}

		if (seq.charAt(i) == seq.charAt(j) && i + 1 == j) {
			return seq.substring(i, i + 2);
		}

		if (seq.charAt(i) == seq.charAt(j)) {
			return seq.substring(i, i + 1) + LPS(seq, i + 1, j - 1) + seq.substring(j, j + 1);
		}

		return max(LPS(seq, i, j - 1), LPS(seq, i + 1, j));
	}

	public static void main(String[] args) {
		String seq = "character";
		System.out.println(LPS(seq, 0, seq.length() - 1));
	}
}
