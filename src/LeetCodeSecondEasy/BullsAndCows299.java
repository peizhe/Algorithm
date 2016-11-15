package LeetCodeSecondEasy;

public class BullsAndCows299 {
	public String getHint(String secret, String guess) {
		if(secret == null || guess == null || secret.length() != guess.length()){
			return "0A0B";
		}
		int[] nums = new int[10];
		int bull = 0;
		int cows = 0;
		int s;
		int g;
		
		for(int i = 0;i < secret.length();i ++){
			s = secret.charAt(i) - '0';
			g = guess.charAt(i) - '0';
			nums[s] ++; 
			if(s == g){
				bull ++;
			}else{
				if (nums[s] < 0)
                    cows ++;
                nums[s] ++;
                if (nums[g] > 0)
                    cows ++;
                nums[g] --;
			}
		}
		
		return bull + "A" + cows + "B";
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
