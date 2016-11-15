package Interview;
/**
 * 给定任意一个整数，小C可以交换该数中任意的不同位，能够得到的最小数值是多少？前提是不能有前导0。
 * 解决方法：
 * 	计数排序O(n)
 * @author MG
 *
 */
public class MinNum {

	public static int getMinNum(int num){
		if(num == 0){
			return num;
		}
		
		boolean flag = num > 0 ? true : false;  
		int[] map = new int[10];
		num = num > 0 ? num : 0 - num;
		StringBuilder sb = new StringBuilder(num + "");
		int len = sb.length();
		
		for(int i = 0;i < len;i ++){
			map[sb.charAt(i) - '0'] ++;
		}
		
		sb.delete(0, len);
		for(int i = 1;i < 10;i ++){
			while(map[i] > 0){
				sb.append(i);
				map[i] --;
			}
		}
		
		if(map[0] > 0){
			if(flag){
				while(map[0] > 0){
					sb.insert(1, 0);
					map[0] --;
				}
			} else {
				while(map[0] > 0){
					sb.insert(0, 0);
					map[0] --;
				}
			}
		}
		
		return flag ? Integer.parseInt(sb.toString()) : -Integer.parseInt(sb.reverse().toString());
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMinNum(-1330));
	}

}
