package HihoCoder;

import java.util.Scanner;

public class ArraysRemoveDuplicate1376 {
	
	private static Scanner sc;

	public static int removeDuplicate(int[] nums) {
        if(nums.length < 2) {
            return nums.length - 1;
        }
        
        int len = nums.length;
        int count = 0;
        for(int i = 2; i < len; i++) {
            if(nums[i] == nums[count]) continue;
            
            count ++;
            if(count != i) nums[count] = nums[i];
        }
        
        return count;
    }
    
    public static void main(String[] mh) {
        sc = new Scanner(System.in);
        int n = -1;
        while(sc.hasNext() && (n = sc.nextInt()) != -1) {
            int[] nums = new int[n];
            for(int i = 0; i < n; i ++) {
                nums[i] = sc.nextInt();
            }
            
            int index = removeDuplicate(nums);
            
            for(int i = 0; i <= index; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    }

}
