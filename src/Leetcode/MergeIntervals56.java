package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Structure.Interval;

public class MergeIntervals56 {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return new ArrayList<Interval>();
		}

		// 按照start升序，end降序
		Collections.sort(intervals, new Comparator<Interval>() {

			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start == o2.start ? o2.end - o1.end : o1.start - o2.start;
			}
		});

		int len = intervals.size();
		List<Interval> res = new ArrayList<Interval>();
		res.add(intervals.get(0));
		for (int i = 1; i < len; i++) {
			//start相等，直接拿第一个
			if(intervals.get(i).start == intervals.get(i - 1).start){
				continue;
			}
			
			Interval last = res.get(res.size() - 1);
			if(intervals.get(i).start <= last.end){
				last.end = intervals.get(i).end > last.end ? intervals.get(i).end : last.end;
			} else {
				res.add(intervals.get(i));
			}
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> list = new ArrayList<Interval>();
		for(int i = 0; i < 3; i++){
			list.add(new Interval(i, i + 3));
		}
		
		System.out.println(list.get(list.size() - 1).end);
	}

}
