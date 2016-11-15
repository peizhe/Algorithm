package LeetCodeSecondEasy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
	public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0){
        	return new ArrayList<Integer>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp;
        
        for(int i = 0;i <= rowIndex;i ++){
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
        
        return res.get(rowIndex);
    }
}
