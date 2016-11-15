package Leetcode;

public class LengthOfLastWord {

	public static int lengthOfLastWord(String s) {
		int result = 0;
		if(s.trim().equals("")){
			return 0;
		}
		else{
			String[] str = s.split(" ");
			for(int i = 0;i < str.length;i ++){
				System.out.println(str[i]);
			}
			result = str[str.length - 1].length();
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " ";
		
		System.out.println(lengthOfLastWord(s));
	}

}
