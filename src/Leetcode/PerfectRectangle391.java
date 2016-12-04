package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 通过面积来做,同时需要记录边缘点
 * 	(掌握记录边缘点的方法)
 * @author MG
 *
 */
public class PerfectRectangle391 {
	public boolean isRectangleCover(int[][] rectangles) {
		if(rectangles == null || rectangles.length == 0) return true;
		
        int area = 0, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE, minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        
        Set<String> set = new HashSet<>();
        
        for(int[] num : rectangles) {
        	minX = Math.min(minX, num[0]);
        	minY = Math.min(minY, num[1]);
        	maxX = Math.max(maxX, num[2]);
        	maxY = Math.max(maxY, num[3]);
        	
        	area += (num[2] - num[0]) * (num[3] - num[1]);
        	
        	//字符串作为key，省去了需要重写hashCode()方法
        	String s1 = num[0] + " " + num[1];
            String s2 = num[0] + " " + num[3];
            String s3 = num[2] + " " + num[3];
            String s4 = num[2] + " " + num[1];
        	
        	if(!set.add(s1)) set.remove(s1);//边缘点重合，则直接去掉了
        	if(!set.add(s2)) set.remove(s2);
        	if(!set.add(s3)) set.remove(s3);
        	if(!set.add(s4)) set.remove(s4);
        }
        
        if (!set.contains(minX + " " + minY) || !set.contains(minX + " " + maxY) || !set.contains(maxX + " " + minY) || !set.contains(maxX + " " + maxY) || set.size() != 4) return false;
        
        return (maxY - minY) * (maxX - minX) == area;
    }
}
