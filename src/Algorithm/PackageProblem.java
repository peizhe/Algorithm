package Algorithm;
//ʹ�ö�̬�滮�ķ������0-1��������
/**
 * ÿ����Ʒ������ֻ��һ��(�μ���һ��)
 */
public class PackageProblem {
	public static int pack(int[] weight,int[] val,int capacity){
		int cap = capacity + 1;
		int len = weight.length + 1;
		//v[i][j]��ʾ����Ϊjʱװ��ǰi����Ʒ������ֵ
		int[][] v = new int[len][cap];
		
		for(int i = 0;i < len;i ++){
			v[i][0] = 0;
		}
		for(int j = 0;j < cap;j ++){
			v[0][j] = 0;
		}
		
		for(int i = 1;i < len;i ++){
			for(int j = 1;j < cap;j ++){
				if(weight[i - 1] > j){
					//�����i����Ʒ���������ڱ�����ǰ������������װ�����Ʒ��
					v[i][j] = v[i - 1][j];
				} else{
					//�����i����Ʒ������С�ڱ�����ǰ���������迼�����������
					//��1������i����Ʒװ�뱳�������ֵ�൱�ڽ�ǰi - 1����Ʒװ������Ϊj - weight[i]������ֵ + ��Ʒi�ļ�ֵ��v[i - 1][j - weight[i]] + val[i]
					//��2�����ѵ�i����Ʒװ�뱳�������ֵ�൱�ڽ�ǰi - 1����Ʒװ������Ϊj������ֵ��v[i - 1][j]
					v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - weight[i - 1]] + val[i - 1]);
				}
			}
		}
		
		//�������ڽ����ʾ
		cap = capacity;
		len = weight.length;
		//������װ�뱳������Ʒ��װ��Ϊ1����װ��Ϊ0
		int[] index = new int[len];
		for(int i = len;i > 0;i --){
			if(v[i][cap] > v[i - 1][cap]){
				index[i - 1] = 1;
				cap = cap - weight[i - 1];
			}
			else{
				index[i - 1] = 0;
			}
		} 
		
		for(int i = 0;i < index.length;i ++){
			System.out.print(index[i] + " ");
		}
		System.out.println();
		return v[len][capacity];
		
	}
	public static void main(String[] mh){
		int[] weight = {5,4,8,9,2};
		int[] val = {5,12,1,3,4};
		int capacity = 20;
		System.out.println(pack(weight,val,capacity));
	}
}
