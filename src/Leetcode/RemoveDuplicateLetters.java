package Leetcode;
/**
 * 不太懂
 * @author MG
 *
 */
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) 
        	cnt[s.charAt(i) - 'a'] ++;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)){ 
            	pos = i;
            }
            if (--cnt[s.charAt(i) - 'a'] == 0){ 
            	break;
            }
        }
        
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
	
	//更高效的解决办法(看不懂)
	public String removeDuplicateLetters1(String s) {
        /**
         * First loop: use an array cnt[] to count the number of times
         * appeared for each letter in s.
         * 
         * Second loop (Greedy): use a stack, pop() while (!stack.isEmpty()
         * && (sc = stack.peek()) >= c && cnt[sc] > 0)
         */

        int i, n = s.length();
        int[] cnt = new int[128];
        boolean[] inRes = new boolean[128]; // whether a char is in res[]
        char[] res = s.toCharArray(); // simulate a stack

        for (i = 0; i < n; i++)
            cnt[res[i]]++;

        char c, sc;
        int end = -1;
        // now cnt[c] means the remaining count of the char c
        for (i = 0; i < n; i++) {
            c = res[i];
            if (inRes[c]) {
                cnt[c]--;
                continue;
            }

            while (end >= 0 && (sc = res[end]) >= c && cnt[sc] > 0) {
                end--;
                inRes[sc] = false;
            }

            res[++ end] = c;
            cnt[c]--;
            inRes[c] = true;
        }
        
        return String.valueOf(res).substring(0, end + 1);
    }
}
