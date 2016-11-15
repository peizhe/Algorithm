package Interview;
/**
 * ��������һ��������СC���Խ�������������Ĳ�ͬλ���ܹ��õ�����С��ֵ�Ƕ��٣�ǰ���ǲ�����ǰ��0��
 * ���������
 * 	��������O(n)
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
