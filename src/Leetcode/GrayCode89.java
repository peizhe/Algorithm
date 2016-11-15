package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 	���������㣬����λ���㣬���λ���㡣
 * 
 * 	1���������λ����ߵ�һλ�����������λԪ��ȫ���¶Գƣ��������б��������һ�������������һ��������Գƣ����˵�һλ�����ڶ����������뵹���ڶ����Գƣ��Դ����ơ�
 * 	2����С���ظ���Ԫ�� 0 , 1��
 *			0 00
 *			0 01
 *			0 11
 *			0 10
 *			1 10
 *			1 11
 *			1 01
 *			1 00
 * 
 * 	��ʵ�ֵ�ʱ��������ȫ�������õݹ飬��ÿһ��ǰ�����0����1��Ȼ��Ϳ����г����еĸ����롣
 * 	��һ�������� 0, 1 �����ַ�����
 * 	�ڶ������ڵ�һ���Ļ����ϣ�ÿһ���ַ���������0��1������ÿ��ֻ�ܼ�һ�������Ե������Ρ������ͱ���� 00,01,11,10 ��ע��Գƣ���
 * 	���������ڵڶ����Ļ����ϣ��ٸ�ÿ���ַ���������0��1��ͬ����ÿ��ֻ�ܼ�һ���������ͱ���� 000,001,011,010,110,111,101,100��
 * 
 * 	
 * 	G:������  B:����λ��
 * 	G(N) = B(n+1) XOR B(n)
 * 
 *  ������ת����λ��:
 *  	����λ���nλ = ����λ��ڣ�n+1��λʱ���������nλ����Ϊ����λ��͸����������ͬλ�������Զ���λ��ɴ����λ�����λԪȡ0���Խ��м��㡣
 *  	���磺������0111��Ϊ4λ������������תΪ֮����λ��Ҳ��Ϊ4λ������˿�ȡת��֮����λ�����λΪ0���� 0 b3 b2 b1 b0��
 *  	0 xor 0 = 0������b3 = 0
 *  	0 xor 1 = 1������b2 = 1
 *  	1 xor 1 = 0������b1 = 0
 *  	0 xor 1 = 1������b0 = 1
 *  	�����ת��Ϊ֮����λ��Ϊ0101
 * 
 * @author MG
 *
 */
public class GrayCode89 {
	public static List<Integer> grayCode(int n) {
		if(n < 0){
			return new ArrayList<Integer>();
		}
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		
		for(int i = 0;i < n;i ++){
			int size = res.size();
			List<Integer> temp = new ArrayList<Integer>(); 
			for(int j = size - 1;j >= 0;j --){	
				temp.add((1 << i) + res.get(j));
			}
			
			res.addAll(temp);
		}
		
		return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = grayCode(0);
		for(int x : res){
			System.out.print(x + " ");
		}
	}

}
