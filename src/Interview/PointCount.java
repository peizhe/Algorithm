package Interview;

public class PointCount {
	public int count(int radis,int target){
		if(radis == 0){
			return 1;
		}
		
		if(radis < 1){
			return 0;
		}
		boolean flag = false;
		int len = (int)Math.sqrt(radis);
		int[] temp = new int[len];
		for(int i = 1;i * i <= radis;i ++){
			temp[i] = i * i;
		}
		
		flag = temp[len - 1] == radis;
		
		int begin = 0,end = len - 1,res = 0;;
		while(begin <= end){
			int p = temp[begin] + temp[end];
			if(p == target){
				if(begin == end){
					res += 4;
				} else {
					res += 8;
				}
				
				begin ++;
				end --;
			} else if(p < target){
				begin ++;
			} else {
				end --;
			}
		}
		
		return flag ? res + 4: res;
	}
	
	public static void main(String[] mh){
	
	}
}
