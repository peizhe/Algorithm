package LeetCodeSecondMedium;

public class SuperPow372 {
	 public int superPow(int a, int[] b) {
		 if(b == null || b.length == 0 || a < 1) return 0;
		 
		 int len = b.length, yushu = a % 1337;
		 //´æ´¢a^1 a^10 a^100 .... %1337µÄÖµ
		 int[] standard = new int[len];
		 standard[len - 1] = yushu;
		 for(int i = len - 2; i >= 0; i--) {
			 int temp = 1;
			 for(int j = 0; j < 10; j++) {
				 temp *= standard[i + 1];
				 temp %= 1337;
			 }
			 standard[i] = temp;
		 }
		 
		 int res = 1;
		 
		 for(int i = len - 1; i >= 0; i--) {
			 for(int j = 0; j < b[i]; j++) {
				 res *= standard[i];
				 res %= 1337;
			 }
		 }
		 
		 return res;
	 }
}
