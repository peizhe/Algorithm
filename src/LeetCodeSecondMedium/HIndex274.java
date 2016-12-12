package LeetCodeSecondMedium;

import java.util.Arrays;

public class HIndex274 {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;

		Arrays.sort(citations);
		
		int end = citations.length - 1, count = 0;
		while(end >= 0 && count < citations[end]) {
			count++;
			end --;
		}
		
		return count;
	}
}
