package Leetcode;

public class SumofTwoIntegers371 {
	
	public static int getSum(int a, int b) {
		if(a == 0){
			return b;
		}
		if(b == 0){
			return a;
		}
		int res = 0;
		int carry = 0;
		int aBit = 0;
		int bBit = 0;
		int cycle = 0;
		while(cycle < 32){
			aBit = a & 1;
			bBit = b & 1;
			
			a >>>= 1;
			b >>>= 1;
			
			int bit = aBit ^ bBit ^ carry;
			
			res |= bit << cycle ++;
			
			if(aBit == 1 && bBit == 1){
				carry = 1;
			}
			else if(carry == 1 && aBit == 1){
				carry = 1;
			}
			else if(carry == 1 && bBit == 1){
				carry = 1;
			}
			else{
				carry = 0;
			}
		}
		
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSum(-8, -12));
	}
}
