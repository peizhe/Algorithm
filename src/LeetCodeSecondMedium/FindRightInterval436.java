package LeetCodeSecondMedium;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

import Structure.Interval;

public class FindRightInterval436 {
	
	public int[] findRightInterval(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
        	return new int[]{};
        }
        
        if(intervals.length == 1) {
        	return new int[]{-1};
        }
        
        //key «start,value «index
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
		});
        
        int len = intervals.length;
        for(int i = 0; i < len; i++) {
        	map.put(intervals[i].start, i);
        }
        
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
        	Entry<Integer, Integer> temp = map.ceilingEntry(intervals[i].end);
        	
        	res[i] = temp == null ? -1 : temp.getValue();
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
