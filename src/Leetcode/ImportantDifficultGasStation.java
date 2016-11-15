package Leetcode;
/**
 * 对于一个循环数组，如果这个数组整体和 SUM >= 0，
 * 	那么必然可以在数组中找到这么一个元素：从这个数组元素出发，绕数组一圈，能保证累加和一直是出于非负状态。
 * 
 * 这题目有点意思，时间复杂度O(N)。
 * 解题思路：
 * 	1：假设出发车站为0，初始化车内油量0
 * 	2：车内油量＝车站油量－消耗
 * 	3：如果车内油量大于0，车开到下一车站，否则出发车站前移一个车站
 * 	重复2，3步，直到所有车站遍历完。如果车内油量剩余大于等于0，返回出发车站，否则返回－1.
 * 
 * @author MG
 *
 */
public class ImportantDifficultGasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null) {  
            return -1;
        }  
        
        int count = gas.length;  
          
        int n = 0;  
        //车内油量
        int gasInCar = 0;
        //出发车站
        int begin = 0;  
        int end = 0; 
        
        int i = 0;  
        while (n < count - 1) {  
            gasInCar += gas[i] - cost[i];  
            if (gasInCar >= 0) {//forward  
                end ++;  
                i = end;  
            } 
            else {  
                begin--;  
                if (begin < 0) {  
                    begin = count - 1;  
                }  
                i = begin;  
            }  
              
            n++;  
        }  
         
        //上面走完了n-1个车站，现在走最后一个
        gasInCar += gas[i] - cost[i];
          
        if (gasInCar >= 0) {  
            return begin;  
        } 
        else {  
            return -1;  
        }
    }
	
	public static void main(String[] mh){
		int[] gas = new int[]{2,5,6,7,5};
		int[] cost = new int[]{3,4,4,4,4};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
