package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 解决方法 :
 * 	1.拓扑排序的思想(超时了)
 * 	2.BFS，每次将叶子节点和它连的树枝节点合并成一个叶子点
 * 
 * @author MG
 *
 */
public class MinimumHeightTrees310 {
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    if (n == 1) return Collections.singletonList(0);

	    List<Set<Integer>> adj = new ArrayList<Set<Integer>>(n);
	    for (int i = 0; i < n; ++i) adj.add(new HashSet<Integer>());
	    
	    //将偏序关系转换成```邻接表```的形式
	    for (int[] edge : edges) {
	        adj.get(edge[0]).add(edge[1]);
	        adj.get(edge[1]).add(edge[0]);
	    }
	    
	    //存储叶子节点
	    List<Integer> leaves = new ArrayList<Integer>();
	    for (int i = 0; i < n; ++i)
	        if (adj.get(i).size() == 1) leaves.add(i);

	    while (n > 2) {
	        n -= leaves.size();
	        List<Integer> newLeaves = new ArrayList<Integer>();
	        for (int i : leaves) {
	        	//j是唯一的，因为叶子节点的度为1，连接叶子节点的只有一个节点
	            int j = adj.get(i).iterator().next();
	            adj.get(j).remove(i);     
	            //判断等于1是把所有叶子节点都已经移除了(等于1是证明j是叶子节点了)
	            if (adj.get(j).size() == 1) newLeaves.add(j);
	        }
	        
	        leaves = newLeaves;
	    }
	    
	    return leaves;
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
