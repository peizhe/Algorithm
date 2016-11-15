package Leetcode;
/**
 * ����һ���㷨�����K����Сֵ
 */
import java.util.Arrays;

/**
 * �÷����ĺ����ǽ�ԭ����ת���һ��Ѱ�ҵ�kС�������⣨��������ԭ�����������У���������λ��ʵ�����ǵ�(m+n)/2С������
 * ����ֻҪ����˵�kС�������⣬ԭ����Ҳ���Խ����
 * @author MG
 *
 */
public class ImportantMedianofTwoSortedArrays {
	/**
	 * ���ȼ�������A��B��Ԫ�ظ���������k/2�����ǱȽ�A[k/2-1]��B[k/2-1]����Ԫ�أ�������Ԫ�طֱ��ʾA�ĵ�k/2С��Ԫ�غ�B�ĵ�k/2С��Ԫ�ء�������Ԫ�رȽϹ������������>��<��=��
	 * ���A[k/2-1]<B[k/2-1]�����ʾA[0]��A[k/2-1]��Ԫ�ض���A��B�ϲ�֮���ǰkС��Ԫ���С�
	 * ���仰˵��A[k/2-1]�����ܴ���������ϲ�֮��ĵ�kСֵ���������ǿ��Խ���������
	 
	 * ֤��Ҳ�ܼ򵥣����Բ��÷�֤��������A[k/2-1]���ںϲ�֮��ĵ�kСֵ�����ǲ����ٶ���Ϊ�ڣ�k+1��Сֵ��
	 * ����A[k/2-1]С��B[k/2-1]������B[k/2-1]�����ǵڣ�k+2��Сֵ��
	 * ��ʵ���ϣ���A���������k/2-1��Ԫ��С��A[k/2-1]��B��Ҳ�������k/2-1��Ԫ��С��A[k/2-1]������С��A[k/2-1]��Ԫ�ظ���������k/2+ k/2-2��С��k������A[k/2-1]�ǵڣ�k+1������ì�ܡ�
	 
	 * ��A[k/2-1]>B[k/2-1]ʱ�������ƵĽ��ۡ�
	 
	 * ��A[k/2-1]=B[k/2-1]ʱ�������Ѿ��ҵ��˵�kС������Ҳ�������ȵ�Ԫ�أ����ǽ����Ϊm��
	 * ������A��B�зֱ���k/2-1��Ԫ��С��m������m���ǵ�kС������
	 * @param A
	 * @param B
	 * @return
	 */
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1)
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        else
            return (findKth(nums1, 0, nums2, 0, total / 2) + findKth(nums1, 0, nums2, 0, total / 2 + 1)) / 2;
    }
 
	//k�����k����С����,�ؼ������������
    private double findKth(int[] a, int abegin, int[] b, int bbegin, int k) {
        if (a.length > b.length)
            return findKth(b, bbegin, a, abegin, k);
 
        if (a.length == 0)
            return b[k - 1];
 
        if (k == 1)
            return Math.min(a[0], b[0]);
 
        int pa = Math.min(k / 2, a.length), pb = k - pa;
        
        if (a[pa - 1] < b[pb - 1])
            return findKth(Arrays.copyOfRange(a, pa, a.length), abegin + pa, b, bbegin, k - pa);
        else if (a[pa - 1] > b[pb - 1])
            return findKth(a, abegin, Arrays.copyOfRange(b, pb, b.length), bbegin + pb, k - pb);
        else
            return a[pa - 1];
    }
}
