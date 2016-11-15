package LeetCodeSecondEasy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows < 1){
        	return res;
        }
        List<Integer> temp;
        
        for(int i = 0;i < numRows;i ++){
        	temp = new ArrayList<Integer>();
        	
        	temp.add(1);
        	for(int j = 1;j < i;j ++){
        		temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        	}
        	if(i != 0){
        		temp.add(1);
        	}
        	
        	res.add(new ArrayList<Integer>(temp));
        }
        
        return res;
    }
	
	public static void main(String[] mh){
		List<List<Integer>> res = generate(5);
		
		for(int i = 0;i < res.size();i ++){
			for(int j = 0;j < res.get(i).size();j ++){
				System.out.print(res.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
