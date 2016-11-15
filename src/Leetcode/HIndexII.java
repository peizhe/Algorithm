package Leetcode;

public class HIndexII {
	
	public static int hIndex(int[] citations) {
		int result = 0;
		int len = citations.length;
		int[] temp = new int[len];

		for(int i = 1;i <= len;i ++){
			temp[i - 1] = citations[len - i];
		}
		
		for(int i = 0;i < len;i ++){
			if(temp[i] >= i + 1){
				result = i + 1;
				continue;
			}
			else if(temp[i] < i + 1){
				result = i;
				break;
			}
		}
		
		return result;
    }

	public static void main(String[] args) {
		int[] a = {0,0};
		System.out.println(hIndex(a));
	}
}
