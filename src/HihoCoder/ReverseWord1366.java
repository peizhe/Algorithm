package HihoCoder;

import java.util.*;

public class ReverseWord1366 {
	
	private static Scanner sc;

	public static int getPairsCount(String[] words){
		if(words == null || words.length < 2){
			return 0;
		}
		Set<String> set = new HashSet<String>();
		int count = 0;
		for(String s : words){
			if(set.contains((new StringBuilder(s)).reverse().toString())) {
				set.remove(s);
				count ++;
			} else {
				set.add(s);
			}
		}
		
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			String[] words = new String[n];
			for(int i = 0; i < n; i++) {
				words[i] = sc.next();
			}
		}
	}

}
