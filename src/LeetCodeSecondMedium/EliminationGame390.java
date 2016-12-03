package LeetCodeSecondMedium;

public class EliminationGame390 {
	public int lastRemaining(int n) {
		int step = 2,start = 1; 
		boolean direction = true;
		while(n > 1) {
			if(direction || (n & 1) == 1) start += step >> 1;
			
			direction = !direction;
			n /= 2;
			step <<= 1;
		}
		
        return start;
    }
}
