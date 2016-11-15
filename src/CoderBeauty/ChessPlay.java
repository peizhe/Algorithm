package CoderBeauty;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������(Ҫ�󽫺�˧������һ��) : �����п��ܵ�λ���г���
 * 
 * ���ý���˧��λ�ã�Ҫ�󽫺�˧������һ��
 * 
 * @author MG
 *
 */
public class ChessPlay {
	
	/**
	 * ��������д��
	 * 
	 * @return
	 */
	public static List<String[]> getAllPosition1(){
		List<String[]> res = new ArrayList<String[]>();
		
		byte x = 81;
		while(x -- > 0){
			if(x / 9 % 3 == x % 9 % 3) continue;
			
			res.add(new String[]{"A" + (x / 9 + 1), "B" + (x % 9 + 1)});
		}
		
		return res;
	}
	
	public static List<String[]> getAllPosition2(){
		List<String[]> res = new ArrayList<String[]>();
		
		for(int i = 1;i < 10; i++){
			for(int j = 1; j < 10; j++){
				if(i % 3 == j % 3) continue;
				
				res.add(new String[]{"A" + i, "B" + j});
			}
		}
		
		return res;
	} 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String[]> res = getAllPosition2();
		for(String[] x : res){
			System.out.println(x[0] + "," + x[1]);
		}
	}

}
