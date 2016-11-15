package Algorithm;

import java.util.Arrays;

/**
 * 计数排序
 * 稳定的排序
 * 
 * 时间复杂度是O(n)(不是基于比较的算法，因此时间复杂度下线不再是O(nlogn))
 * 
 * 计数排序的算法思想 计数排序对输入的数据有附加的限制条件：
 * 	1、输入的线性表的元素属于有限偏序集S；(数据元素有范围限制)
 * 	2、设输入的线性表的长度为n，|S|=k（表示集合S中元素的总数目为k），则k=O(n)。 在这两个条件下，计数排序的复杂性为O(n)。
 * 	      计数排序的基本思想是对于给定的输入序列中的每一个元素x，确定该序列中值小于x的元素的个数（此处并非比较各元素的大小，而是通过对元素值的计数和计数值的累加来确定）。
 * 	      一旦有了这个信息，就可以将x直接存放到最终的输出序列的正确位置上。
 * 例如，如果输入序列中只有17个元素的值小于x的值，则x可以直接存放在输出序列的第18个位置上。
 * 
 * @author MG
 * 
 */
public class CountSort {
	// 计数排序
	public int[] countSort(int[] a) {
		int[] res = new int[a.length];
		int max = a[0], min = a[0];
		// 找到数组中的最大值和最小值
		for (int i : a) {
			if (i > max) {
				max = i;
			}
			if (i < min) {
				min = i;
			}
		}
		// 这里k的大小是要排序的数组中，元素大小的极值差+1
		int k = max - min + 1;
		// 存储最大值与最小值之间数据的个数
		int count[] = new int[k];
		for (int i = 0; i < a.length; i++) {
			count[a[i] - min] += 1;// 优化过的地方，减小了数组count的大小
		}
		// count[i]变为比i小的元素的数目
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {
			//解决掉了重复元素的问题
			int index = -- count[a[i] - min];
			res[index] = a[i];// 按存取的方式取出count的元素
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
        }//这里k的大小是要排序的数组中，元素大小的极值差+1
        int k=max-min+1;
        int c[]=new int[k];
        for(int i=0;i<a.length;++i){
            c[a[i]-min]+=1;//优化过的地方，减小了数组c的大小
        }
        for(int i=1;i<c.length;++i){
            c[i]=c[i]+c[i-1];
        }
        for(int i=a.length-1;i>=0;--i){
            b[--c[a[i]-min]]=a[i];//按存取的方式取出c的元素
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
