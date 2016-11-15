package HihoCoder;

/**
 * ŷ������f(n):����<=n����n���ʵ����ĸ���
 * f(x) = x(1-1/p1)(1-1/p2)(1-1/p3)(1-1/p4)��(1-1/pn),����p1,p2����pnΪx������������
 * 
 * ��m,n����,f(m * n) = f(m) * f(n)
 * �������ʣ���nΪ����ʱ f(2 * n) = f(n), ֤�����������ơ�
 * ��nΪ������f(n) = n - 1 
 * 
 * @author MG
 *
 */
public class ElurFunction1298 {
	
	public static int getElur(int L,int R){
        int res = Integer.MAX_VALUE;
        int resIndex = R;
        
		int[] values = new int[R + 1];
		values[1] = 1;
		//��ʽ��x*(1 - 1/p1)...�е�x
		for(int i = 2;i <= R; i++) {
			values[i] = i;
		}
		
		for(int i = 2; i <= R; i++){
			//values[i] == i : ֤��iΪ����
			if(values[i] == i){
				//����ÿ������i���������
				for(int j = i; j <= R; j += i){
					//���������Ƿ�ֹԽ��
					values[j] = values[j] / i * (i - 1);
				}
			}
			
			if(i >= L && values[i] < res){
			    res = values[i];
			    resIndex = i;
			}
		}
		
		return resIndex;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
