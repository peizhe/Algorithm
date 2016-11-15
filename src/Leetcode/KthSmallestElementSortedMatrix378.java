package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 解决这个问题的方法：
 * 万流齐进法！so niubility!
 * 	1	2	3	4	5
 * 	|	|	|	|	|
 *	| 	|	|	|	|
 * 	|	|	|	|	|
 * 	|	|	|	|	|
 * 	|	|	|	|	|
 * 	|	|	|	|	|
 * 	^	^	^	^	^
 * 二分查找法：
 * 	最小数为matrix[0][0],最大数为matrix[n - 1][n - 1],其他数分布在两者之间(不太懂)
 * @author MG
 * 
 */
public class KthSmallestElementSortedMatrix378 {
	
	public int kthSmallestBinarySearch(int[][] matrix, int k){
		int n = matrix.length;
	    int left = matrix[0][0], right = matrix[n - 1][n - 1];

	    while (left < right) {
	        int mid = left + (right - left) >> 1;
	        int count = 0; // number of elements no bigger than mid
	        
	        //计算矩阵中不大于mid的数的个数
	        for (int i = 0;i < n;i ++) {
	            int[] row = matrix[i];

	            int t_left = 0, t_right = row.length;
	            while (t_left < t_right) {
	                int t_mid = t_left + (t_right - t_left) >> 1;
	                int value = row[t_mid];
	                if(value > mid) {
	                    t_right = t_mid;
	                } else {
	                    t_left = t_mid + 1;
	                }
	            }
	            count += t_left;
	        }

	        if (count < k) {
	            left = mid + 1;
	        } else {
	            right = mid;
	        }
	    }
	    
	    return left;
	}
	
	public int kthSmallest2(final int[][] matrix, int k) {
        int row = matrix.length;
        int col = row == 0 ? 0 : row;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(row, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return matrix[arr1[0]][arr1[1]] - matrix[arr2[0]][arr2[1]];
            }
        });
        
        for(int i = 0; i < col; i++){
            int[] cur = {0, i};
            pq.offer(cur);
        }
        
        for(int i = 0; i < k - 1; i++){
            int[] cur = pq.poll();
            if(cur[0] == row - 1){
                continue;
            }
            pq.offer(new int[]{cur[0] + 1, cur[1]});
        }
        
        int[] cur = pq.poll();
        return matrix[cur[0]][cur[1]];
    }
	
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		//将第一行元素加入优先级队列
		for (int j = 0;j < n;j ++)
			pq.offer(new Tuple(0, j, matrix[0][j]));
		
		//移除k - 1次
		for (int i = 1; i < k;i ++) {
			//被移除元素的下一行相邻元素被压入队列(万流齐进)
			Tuple t = pq.poll();
			if (t.x == n - 1)
				continue;
			pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
		}
		
		return pq.poll().val;
	}
	
	private class Tuple implements Comparable<Tuple> {
		int x, y, val;

		public Tuple(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		public int compareTo(Tuple that) {
			return this.val - that.val;
		}
	}
}


