package Leetcode;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import Structure.Interval;

/**
 * 
 * TreeMap ʵ��
 * 
 * @author MG
 * 
 */
public class FindRightInterval436 {
	public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        NavigableMap<Integer, Integer> intervalMap = new TreeMap<Integer, Integer>();
        
        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);    
        }
        
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        
        return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
