package Algorithm;
//�����1��n�ĺͣ������ó˷���������ѭ�����жϣ�switch��? :
public class Calcuate1ToNSum {
	static int n = 0;
	static int sum = 0;
	
	//��������ʵ��һ���౻ʵ����max��(��������if���)
	public Calcuate1ToNSum(int max){
		sum += n;
		n ++;
		
		if(n <= max){
			new Calcuate1ToNSum(max);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Calcuate1ToNSum(10);
		
		System.out.println(Calcuate1ToNSum.sum);
	}
}
