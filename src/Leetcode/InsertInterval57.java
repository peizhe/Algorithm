package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import Structure.Interval;

public class InsertInterval57 {
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null){
        	return intervals;
        }
        
        if(intervals.size() == 0){
        	return Collections.singletonList(newInterval);
        }
        
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {

			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
        
        int len = intervals.size();
        List<Interval> res = new LinkedList<Interval>();
        res.add(intervals.get(0));
        for(int i = 1;i < len; i++){
        	Interval last = res.get(res.size() - 1);
        	
        	//如果当前start <= 前一个end(需要合并)
        	if(intervals.get(i).start <= last.end){
        		last.end = intervals.get(i).end > last.end ? intervals.get(i).end : last.end; 
        		continue;
        	} 
        	
        	//否则直接加入res
        	res.add(intervals.get(i));
        }
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1,5));
//		list.add(new Interval(6,8));
		
		insert(list, new Interval(6, 8));
 	}

}
