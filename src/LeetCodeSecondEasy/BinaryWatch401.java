package LeetCodeSecondEasy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch401 {
	
	public List<String> readBinaryWatch(int num) {
        if(num < 0) {
        	return new ArrayList<String>();
        }
        
        List<String> res = new ArrayList<String>();
        
        for(int i = 0; i < 24; i++) {
        	for(int j = 0; j < 60; j++) {
        		if(Integer.bitCount(i) + Integer.bitCount(j) == num) {
        			res.add(String.format("%d:%02d", i, j));
        		}
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(String.format("%d:%02d", 12, 22));
	}

}
