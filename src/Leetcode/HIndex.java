package Leetcode;

public class HIndex {
	
	public static int hIndex(int[] citations) {
		int result = 0;
		int len = citations.length;
		
		for(int i = len - 1;i >= 0;i --){
			for(int j = 0;j < i;j ++){
				if(citations[j] < citations[j + 1]){
					int temp = citations[j];
					citations[j] = citations[j + 1];
					citations[j + 1] = temp;
				}
			}
		}
		
		for(int i = 0;i < len;i ++){
			if(citations[i] >= i + 1){
				result = i + 1;
				continue;
			}
			else if(citations[i] < i + 1){
				result = i;
				break;
			}
		}
		
		return result;
    }

	public static void main(String[] args) {
		int[] a = {0,1,4,5,6};
		System.out.println(hIndex(a));
	}

}
