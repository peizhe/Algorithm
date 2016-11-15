package Leetcode;

public class ValidPerfectSquare367 {
	public static boolean isPerfectSquare(int num) {
		if (num == 0 || num == 1) {
			return true;
		}

		int maxInteger = Integer.MAX_VALUE;
		
		int begin = 2, end = num / 2;
		while (begin <= end) {
			int mid = begin + (end - begin) / 2;
			
			if(maxInteger / mid < mid){
				end = mid - 1;
				continue;
			}
			
			int temp = mid * mid;
			if (temp == num) {
				return true;
			} else if (temp < num) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPerfectSquare(2147395600));
	}

}
