package Interview;

/**
 * ��Ȼ��һ����ȷ���ٽ�Σ���Ͷ�������Ӳ��ɱ��⣬���Ǿ��õڶ�����ȷ���ٽ�㣩��Ͷ�������ŵ�һ���Ĵ������Ӷ����١�
 * ��һ����Ͷ������һ��һ�����ӵģ��Ǿ��õڶ�����Ͷ����һ��һ�μ��١�
 * �����һ��Ͷ���Ĳ�����f��ת������ѧģ�ͣ�f + (f-1) +... + 2 + 1�ͱ�ʾ��f��ʼ�£�ÿ�ε���������ǰһ�ε�������1������£����µ��Ǹ���(�� f + (f - 1) +...+ 2 + 1)
 * ��������Ҫ��f + (f - 1) +...+ 2 + 1 >= 99����f(f + 1) / 2 >= 99
 * (��һ�β��Ե�ѡ��100����������ģ���Ȼ���飬�������κβ��Լ�ֵ�����Ե�һ�β��Ե�k��1 - 99�е�һ����)��
 * ����������14��
 */
public class EggFloorProblem {
	
	public static int eggFloor(int floorHeight){
		int sum = 1,index = 1;
		while(sum < floorHeight){
			index ++;
			sum += index;
		}
		
		return index;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(eggFloor(100));
	}

}
