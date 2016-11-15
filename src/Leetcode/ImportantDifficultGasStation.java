package Leetcode;
/**
 * ����һ��ѭ�����飬��������������� SUM >= 0��
 * 	��ô��Ȼ�������������ҵ���ôһ��Ԫ�أ����������Ԫ�س�����������һȦ���ܱ�֤�ۼӺ�һֱ�ǳ��ڷǸ�״̬��
 * 
 * ����Ŀ�е���˼��ʱ�临�Ӷ�O(N)��
 * ����˼·��
 * 	1�����������վΪ0����ʼ����������0
 * 	2��������������վ����������
 * 	3�����������������0����������һ��վ�����������վǰ��һ����վ
 * 	�ظ�2��3����ֱ�����г�վ�����ꡣ�����������ʣ����ڵ���0�����س�����վ�����򷵻أ�1.
 * 
 * @author MG
 *
 */
public class ImportantDifficultGasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null) {  
            return -1;
        }  
        
        int count = gas.length;  
          
        int n = 0;  
        //��������
        int gasInCar = 0;
        //������վ
        int begin = 0;  
        int end = 0; 
        
        int i = 0;  
        while (n < count - 1) {  
            gasInCar += gas[i] - cost[i];  
            if (gasInCar >= 0) {//forward  
                end ++;  
                i = end;  
            } 
            else {  
                begin--;  
                if (begin < 0) {  
                    begin = count - 1;  
                }  
                i = begin;  
            }  
              
            n++;  
        }  
         
        //����������n-1����վ�����������һ��
        gasInCar += gas[i] - cost[i];
          
        if (gasInCar >= 0) {  
            return begin;  
        } 
        else {  
            return -1;  
        }
    }
	
	public static void main(String[] mh){
		int[] gas = new int[]{2,5,6,7,5};
		int[] cost = new int[]{3,4,4,4,4};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
