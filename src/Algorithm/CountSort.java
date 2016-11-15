package Algorithm;

import java.util.Arrays;

/**
 * ��������
 * �ȶ�������
 * 
 * ʱ�临�Ӷ���O(n)(���ǻ��ڱȽϵ��㷨�����ʱ�临�Ӷ����߲�����O(nlogn))
 * 
 * ����������㷨˼�� �������������������и��ӵ�����������
 * 	1����������Ա��Ԫ����������ƫ��S��(����Ԫ���з�Χ����)
 * 	2������������Ա�ĳ���Ϊn��|S|=k����ʾ����S��Ԫ�ص�����ĿΪk������k=O(n)�� �������������£���������ĸ�����ΪO(n)��
 * 	      ��������Ļ���˼���Ƕ��ڸ��������������е�ÿһ��Ԫ��x��ȷ����������ֵС��x��Ԫ�صĸ������˴����ǱȽϸ�Ԫ�صĴ�С������ͨ����Ԫ��ֵ�ļ����ͼ���ֵ���ۼ���ȷ������
 * 	      һ�����������Ϣ���Ϳ��Խ�xֱ�Ӵ�ŵ����յ�������е���ȷλ���ϡ�
 * ���磬�������������ֻ��17��Ԫ�ص�ֵС��x��ֵ����x����ֱ�Ӵ����������еĵ�18��λ���ϡ�
 * 
 * @author MG
 * 
 */
public class CountSort {
	// ��������
	public int[] countSort(int[] a) {
		int[] res = new int[a.length];
		int max = a[0], min = a[0];
		// �ҵ������е����ֵ����Сֵ
		for (int i : a) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		// ����k�Ĵ�С��Ҫ����������У�Ԫ�ش�С�ļ�ֵ��+1
		int k = max - min + 1;
		// �洢���ֵ����Сֵ֮�����ݵĸ���
		int count[] = new int[k];
		for (int i = 0; i < a.length; i++) {
			count[a[i] - min] += 1;// �Ż����ĵط�����С������count�Ĵ�С
		}
		// count[i]��Ϊ��iС��Ԫ�ص���Ŀ
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {
			//��������ظ�Ԫ�ص�����
			int index = -- count[a[i] - min];
			res[index] = a[i];// ����ȡ�ķ�ʽȡ��count��Ԫ��
		}

		return res;
	}

	public static int[] countSort1(int[] a){
        int b[] = new int[a.length];
        int max = a[0],min = a[0];
        for(int i:a){
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }//����k�Ĵ�С��Ҫ����������У�Ԫ�ش�С�ļ�ֵ��+1
        int k=max-min+1;
        int c[]=new int[k];
        for(int i=0;i<a.length;++i){
            c[a[i]-min]+=1;//�Ż����ĵط�����С������c�Ĵ�С
        }
        for(int i=1;i<c.length;++i){
            c[i]=c[i]+c[i-1];
        }
        for(int i=a.length-1;i>=0;--i){
            b[--c[a[i]-min]]=a[i];//����ȡ�ķ�ʽȡ��c��Ԫ��
        }
        return b;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,4,5,8,2,2,1,0,3,4,6};
		System.out.println(Arrays.toString(new CountSort().countSort(a)));
	}
}
