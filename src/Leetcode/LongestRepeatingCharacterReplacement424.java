package Leetcode;

/**
 * �����Ŀ: ���ǽ�ĳһ���ַ��滻�����������ַ������ǿ��԰������ַ��滻�������ַ�
 * 
 * @author MG
 * 
 */
public class LongestRepeatingCharacterReplacement424 {
	public static int characterReplacement(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int len = s.length();
		int[] map = new int[26];
		int maxOccur = 0, begin = 0, res = 1;

		for (int end = 0; end < len; end++) {
			map[s.charAt(end) - 'A']++;
			if (map[s.charAt(end) - 'A'] > maxOccur) {
				maxOccur = map[s.charAt(end) - 'A'];
			}
			
			//֤����ǰҪ�滻����ĸ��������k������Ҫ��ͷ��ʼɾ��ֱ��Ҫ�滻����ĸ����<=k
			while (end - begin + 1 - maxOccur > k) {
				map[s.charAt(begin) - 'A']--;
				begin ++;
				
				//�Ƴ�begin�����¼���maxOccur
				for(int i = 0;i < 26;i ++){
					maxOccur = Math.max(maxOccur, map[i]);
				}
			}
			
			res = Math.max(end - begin + 1, res);
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(characterReplacement("ABBBA", 2));
	}

}
