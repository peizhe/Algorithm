package Leetcode;

public class FirstBadVersion {
	
	public static boolean isBadVersion(int a){
		if(a < 2){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static int firstBadVersion1(int n){
        int start = 1,end = n;
        while(start <= end){
        	boolean startBad = isBadVersion(start);
	    	if(startBad == isBadVersion(end)){
	    		if(startBad){
	         		return start;
	    		}
	        }
	    	
        	int mid = start + (end - start) / 2;
        	if(!isBadVersion(mid)){
        		start = mid + 1;
        	}
        	else{
        		end = mid - 1;
        	}
        }
        return start;
    }
	
	public static int firstBadVersion(int n){
        int start = 1,end = n;
        while(start <= end){
	    	//�˴����ص㣬����д��(start + end) / 2;��Ϊstart + end���ܳ��������ķ�Χ
        	int mid = start + (end - start) / 2;
        	if(isBadVersion(mid)){
        		end = mid - 1;
        	}
        	else{
        		start = mid + 1;
        	}
        }
        return start;
    }
	
	
	public static void main(String[] args) {
		System.out.println(firstBadVersion(3));
	}
}
