package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ������� :
 * 	1.���������˼��(��ʱ��)
 * 	2.BFS��ÿ�ν�Ҷ�ӽڵ����������֦�ڵ�ϲ���һ��Ҷ�ӵ�
 * 
 * @author MG
 *
 */
public class MinimumHeightTrees310 {
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    if (n == 1) return Collections.singletonList(0);

	    List<Set<Integer>> adj = new ArrayList<Set<Integer>>(n);
	    for (int i = 0; i < n; ++i) adj.add(new HashSet<Integer>());
	    
	    //��ƫ���ϵת����```�ڽӱ�```����ʽ
	    for (int[] edge : edges) {
	        adj.get(edge[0]).add(edge[1]);
	        adj.get(edge[1]).add(edge[0]);
	    }
	    
	    //�洢Ҷ�ӽڵ�
	    List<Integer> leaves = new ArrayList<Integer>();
	    for (int i = 0; i < n; ++i)
	        if (adj.get(i).size() == 1) leaves.add(i);

	    while (n > 2) {
	        n -= leaves.size();
	        List<Integer> newLeaves = new ArrayList<Integer>();
	        for (int i : leaves) {
	        	//j��Ψһ�ģ���ΪҶ�ӽڵ�Ķ�Ϊ1������Ҷ�ӽڵ��ֻ��һ���ڵ�
	            int j = adj.get(i).iterator().next();
	            adj.get(j).remove(i);     
	            //�жϵ���1�ǰ�����Ҷ�ӽڵ㶼�Ѿ��Ƴ���(����1��֤��j��Ҷ�ӽڵ���)
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
