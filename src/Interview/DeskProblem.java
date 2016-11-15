package Interview;

import java.util.Arrays;

public class DeskProblem {
	public static int deskProblem(int[] deskCapacity,int[] people,int[] prices){
		Arrays.sort(deskCapacity);
		
		int len = deskCapacity.length,peopleLen = people.length;
		int max = 0,index,res = 0;
		for(int i = 0;i < len;i ++){
			max = 0;
			index = 0;
			for(int j = 0;j < peopleLen;j ++){
				if(people[j] == -1){
					continue;
				} else if(people[j] <= deskCapacity[i]){
					if(prices[j] > max){
						max = prices[j];
						index = j;
					}
				}
			}
			
			people[index] = -1;
			res += max;
		}
		
		return res;
	}
	
	public static void main(String[] mh){
		int[] desk = new int[]{2,3,4,3};
		int[] people = new int[]{2,2,3,3,5};
		int[] prices = new int[]{3,10,7,5,10};
		System.out.println(deskProblem(desk,people,prices));
	}
}
