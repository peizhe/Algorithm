package Leetcode;
/**
 * 这种设计很牛叉
 * 
 * @author MG
 *
 */
public class UniqueSubstringsInWraparoundString467 {
	public static int findSubstringInWraproundString(String p) {
		// count[i] is the maximum unique substring end with ith letter.
		// 0 - 'a', 1 - 'b', ..., 25 - 'z'.
		int[] count = new int[26];

		// dp[i] is the longest contiguous substring ends at position i.
		int[] dp = new int[p.length()];

		for (int i = 0; i < p.length(); i++) {
			//找到最长子串长度并赋值给dp[i]
			int len = 1;
			if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
				len = dp[i - 1] + 1;
			}
			
			dp[i] = len;

			//这里为什么这样设计(好强)
			int index = p.charAt(i) - 'a';
			count[index] = Math.max(count[index], len);
		}

		// Sum to get result
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += count[i];
		}
		
		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findSubstringInWraproundString("abcefh"));
	}

}
