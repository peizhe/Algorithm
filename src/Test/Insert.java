package Test;

public class Insert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 5;
		int[] a = new int[]{1,2,3,4,6,7};
		int[] b = new int[a.length + 1];
		
		//����value
		int i;
		for(i = 0;i < a.length;i ++){
			if(a[i] >= value){
				break;
			}else{
				b[i] = a[i];
			}
		}
		System.out.println(i);
		//����Ԫ��
		b[i] = value;
		//�������к����Ԫ�����θ�ֵ������b��
		for(;i < a.length;i ++){
			b[i + 1] = a[i];
		}
		
		for(Integer num : b){
			System.out.print(num + " ");
		}
	}
}
