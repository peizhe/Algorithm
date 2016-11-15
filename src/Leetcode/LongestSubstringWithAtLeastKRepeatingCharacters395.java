package Leetcode;
/**
 * �ҵ��ַ����в�������ִ��� <k ���ַ����Ѹ��ַ���Ϊ�и�㣬���������������������󳤶�
 * 
 * @author MG
 *
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters395 {
	public int longestSubstring(String s, int k) {
		char[] a = s.toCharArray();
		return helper(a, 0, s.length(), k);
	}

	public int helper(char[] a, int start, int end, int k) {
		if (start > end || k > end - start)
			return 0;
		
		//��¼�ַ���start--end�Ӵ��и����ַ��ĸ���
		int[] count = new int[26];
		for (int i = start; i < end; i++)
			count[a[i] - 'a']++;
		
		for (int i = 0; i < 26; i++) {
			if (count[i] == 0)
				continue;
			
			//���count[i] < k,�� (i + 'a')�ַ����ַ�����һ������k�Σ�
			//��i + 'a' ��Ϊ�и�㣬���ַ��������и�����������ߵ����ֵ 
			if (count[i] < k) {
				for (int j = start; j < end; j++) {
					if (a[j] == i + 'a') {
						return Math.max(helper(a, start, j, k),
								helper(a, j + 1, end, k));
					}
				}
			}
		}
		
		return end - start;
	}
}
