package Note;
/**
 * 
 * �����Ĳ�����ԭ����ͬ
 * �����Ĳ���Ϊ�Ը�����ԭ�������λ���λȡ����Ȼ�������һλ��1
 * 	���磺
 * 		a: -3��Դ��(10000011)������λȡ��Ϊ: 1111 1100
 * 		b: ��1��1111 1101
 * 		c: ����-3�Ĳ����ǣ�1111 1101
 * 
 * �Ӳ�����������ԭ�룺
 * 	�����Ĳ����������ԭ��
 * 	������ԭ����㣺-3Ϊ��,-3�Ĳ�����1111 1101
 * 		ԭ��Ϊ```���������λ��λȡ�� + 1```
 * 
 * ����:
 * 	byte b = 127;
 * 	b = (byte) (b + 1);
 * 	���b��ֵ�Ƕ��٣�
 * 	127�Ķ�����Ϊ: 0111 1111
 * 	127 + 1��Ϊ��0111 1111 + 1 = 1000 0000
 * ���Ե�����1000 0000��ֵʱ��
 * 	a: ���λΪ1�������Ǹ���
 * 	b: ȡ����1��0111 1111 + 1 = 1000 0000
 * 	c: ����1000 0000��ֵ��128
 * 	d: �����128�ĸ�ֵ������Ϊ-128����byte���͵�127��1��ֵΪ-128
 * 
 * @author MG
 *
 * ��Ŀ��һ������ʮ�����Ƶ��������Ǹ��Ĳ������ʽ(�μ�)!!!
 */
public class NumberBinaryEncoding {
	//java ����4���ֽ�
	static int max = Integer.MAX_VALUE;//ʮ���Ʊ�ʾ(2147483647)ʮ�����Ʊ�ʾ(Ox7FFFFFFF)
	static int min = Integer.MIN_VALUE;//ʮ���Ʊ�ʾ(-2147483648)ʮ�����Ʊ�ʾ(Ox80000000)
	
	//��a = 1,b = 0����ʱ���������ѭ��
	public static int plus(int a, int b){
		while(a + b > 0){
			a += 1;
			b -= 1;
		}
		
		return a + b;
	}
	
	public static void main(String[] mh){
		//�������ֵ + 1���(Ox7FFFFFF + 1 �ص��������Ĳ����ʾ����)��
		//����ǣ�-2147483648(Ox80000000)
		int x = max + 1;
		System.out.println(x);
		
		//��Сֵ - 1���
		//����ǣ�2147483647(Ox7FFFFFFF)
		int y = min - 1;
		System.out.println(y);
		
		//���ֵ  + ��Сֵ(Ox7FFFFFF + Ox80000000)
		//����ǣ�-1
		int xy = max + min;
		System.out.println(xy);
		
		//a = -2147483648(min) b = -2147483647(min + 1)  a + b = ?
		//����ǣ�1
		int m = min + (min + 1);
		System.out.println(m);
		
		//a = -2147483648 a + a = ?
		//�����0
		int n = min + min;
		System.out.println(n);
		
		//a = 2147483647 a + a = ?
		//����ǣ�-2
		int p = max + max;
		System.out.println(p);
	}
}
