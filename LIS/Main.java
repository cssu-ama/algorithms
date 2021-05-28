
public class Main {
	
	private static void LIS(int nums[]) {
		
		int LIS[] = new int[nums.length];
		int table[][] = new int[nums.length][nums.length];
		
		for (int i = 0; i < nums.length; i++) {
			LIS[i] = 1;
			table[i][nums.length - 1] = nums[i];
		}
		
		for (int i = 1; i < nums.length; i++) {
			
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
					
					table[i][j] = nums[j];
				}
			}
		}
		
		int max = 0;
		int maxIndex = -1;
		
		for (int i = 0; i < nums.length; i++) {
			if (max < LIS[i]) {
				max = LIS[i];
				maxIndex = i;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (table[maxIndex][i] != 0) {
				System.out.print(table[maxIndex][i] + ", ");
			}
		}
	}

	public static void main(String args[]) {
		int nums[] = { 8, 3, 9, 1, 14, 6 };
		
		LIS(nums);
	}
}
