package LeetCodeSecondEasy;

public class CompareVersionNumbers165 {
	public static int compareVersion(String version1, String version2) {
		if(version1 == null || version2 == null){
			return 0;
		}
		
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        int len = v1.length > v2.length ? v1.length : v2.length;
        int v1Len = v1.length,v2Len = v2.length;
        int index = 0;
        
        int temp1,temp2;
        while(index < len){
        	temp1 = index < v1Len ? Integer.parseInt(v1[index]) : 0;
        	temp2 = index < v2Len ? Integer.parseInt(v2[index]) : 0;
        	
        	if(temp1 > temp2){
        		return 1;
        	} else if(temp1 < temp2){
        		return -1;
        	}
        	
        	index ++;
        }
        
        return 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String v1 = "1";
		String v2 = "0";
		System.out.println(compareVersion(v1,v2));
	}

}
