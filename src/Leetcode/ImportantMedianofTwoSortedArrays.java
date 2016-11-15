package Leetcode;
/**
 * 这是一中算法，求第K个最小值
 */
import java.util.Arrays;

/**
 * 该方法的核心是将原问题转变成一个寻找第k小数的问题（假设两个原序列升序排列），这样中位数实际上是第(m+n)/2小的数。
 * 所以只要解决了第k小数的问题，原问题也得以解决。
 * @author MG
 *
 */
public class ImportantMedianofTwoSortedArrays {
	/**
	 * 首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。这两个元素比较共有三种情况：>、<和=。
	 * 如果A[k/2-1]<B[k/2-1]，这表示A[0]到A[k/2-1]的元素都在A和B合并之后的前k小的元素中。
	 * 换句话说，A[k/2-1]不可能大于两数组合并之后的第k小值，所以我们可以将其抛弃。
	 
	 * 证明也很简单，可以采用反证法。假设A[k/2-1]大于合并之后的第k小值，我们不妨假定其为第（k+1）小值。
	 * 由于A[k/2-1]小于B[k/2-1]，所以B[k/2-1]至少是第（k+2）小值。
	 * 但实际上，在A中至多存在k/2-1个元素小于A[k/2-1]，B中也至多存在k/2-1个元素小于A[k/2-1]，所以小于A[k/2-1]的元素个数至多有k/2+ k/2-2，小于k，这与A[k/2-1]是第（k+1）的数矛盾。
	 
	 * 当A[k/2-1]>B[k/2-1]时存在类似的结论。
	 
	 * 当A[k/2-1]=B[k/2-1]时，我们已经找到了第k小的数，也即这个相等的元素，我们将其记为m。
	 * 由于在A和B中分别有k/2-1个元素小于m，所以m即是第k小的数。
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
 
	//k代表第k个最小的数,关键就在这个函数
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
