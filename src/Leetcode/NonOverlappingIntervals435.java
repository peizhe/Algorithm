package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

import Structure.Interval;

/**
 * 贪心的技巧
 * 
 * @author MG
 *
 */
public class NonOverlappingIntervals435 {
	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals == null || intervals.length == 0){
			return 0;
		}
		
		//按照start升序  end升序
		Arrays.sort(intervals, new Comparator<Interval>() {

			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start == o2.start ? (o1.end - o2.end) : (o1.start - o2.start);
			}
		});
		
		int len = intervals.length;
		int count = 0;
		
		Interval firstUnique = intervals[0];
		for(int i = 1;i < len; i++){
			//start相同
			if(intervals[i].start == intervals[i - 1].start){
				count ++;
				continue;
			}
			
			if(intervals[i].start >= firstUnique.end){//不相交
				firstUnique = intervals[i];
			} else {//相交了
				firstUnique = intervals[i].end < firstUnique.end ? intervals[i] : firstUnique;
				count ++;
			}
		}
		
		
		return count;
    }
	
	public static void main(String[] mh){
		
	} 
}
