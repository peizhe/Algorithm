package NiuKe;

/**
 * 
 * 
 * @author Administrator
 *
 */
public class JumpFloor {
	
	/**
	 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
	 * @param target
	 * @return
	 */
	public static int JumpFloorI(int target) {
        if(target <= 0) return 0;
        else if(target == 1) return 1;
        else if(target == 2) return 2;
        else {
            int res = 0, first = 1, second = 2;
            for(int i = 3; i <= target; i++) {
                res = first + second;
                first = second;
                second = res;
            }
            
            return res;
        }
    }
	
	/**
	 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
	 * @param target
	 * @return
	 */
	public static int JumpFloorII(int target) {
        if(target <= 0) return 0;
        else if(target == 1) return 1;
        else if(target == 2) return 2;
        else {
            int res = 0, sum = 3;
            for(int i = 3; i <= target; i++) {
                res = sum + 1;
                sum += res;
            }
            
            return res;
        }
    }
	
	public static void main(String[] mh){
		
	}
}
