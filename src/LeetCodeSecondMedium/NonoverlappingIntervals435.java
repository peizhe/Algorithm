package LeetCodeSecondMedium;

import java.util.Arrays;
import java.util.Comparator;

import Structure.Interval;

public class NonoverlappingIntervals435 {
	
	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) {
			return 0;
		}
		
        Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
			}
		});
        
        int count = 0, len = intervals.length;
        
        Interval temp = intervals[0];
        for(int i = 1; i < len; i++) {
        	if(intervals[i].start == intervals[i - 1].start) {
        		count ++;
        	} else {
        		if(intervals[i].start < temp.end) {
        			count ++;
        			temp = intervals[i].end < temp.end ? intervals[i] : temp;
        		} else {
        			temp = intervals[i];
        		}
        	}
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
