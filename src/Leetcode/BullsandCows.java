package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class BullsandCows {

	public static String getHint(String secret, String guess) {
		char[] secretChar  = secret.toCharArray();
		char[] guessChar = guess.toCharArray();
		int bulls = 0,cows = 0;
		for(int i = 0;i < secretChar.length;i ++){
			if(secretChar[i] == guessChar[i]){
				bulls ++;
			}
		}
		
		List<Character> temp = new ArrayList<Character>();
		for(int i = 0;i < secretChar.length;i ++){
			temp.add(secretChar[i]);
		}
		
		for(int i = 0;i < guessChar.length;i ++){
			Character c  = guessChar[i];
			if(temp.contains(c)){
				temp.remove(c);
			}
		}
		
		cows = secretChar.length - temp.size() - bulls;
		return bulls + "A" + cows + "B";
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "11123";
		String s2 = "01114";
		System.out.println(getHint(s1,s2));
	}

}
