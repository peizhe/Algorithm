package LeetCodeSecondMedium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight406 {
	
	public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) {
        	return new int[][]{};
        }
        
        Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				//按照高度降序(高度相同,则按k升序)
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
		});
        
        List<int[]> res = new LinkedList<int[]>();
        for(int[] x : people) {
        	res.add(x[1], x);
        }
        
        return res.toArray(new int[][]{});
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
