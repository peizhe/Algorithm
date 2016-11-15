package Leetcode;

import java.util.*;
/**
 * ��temp��Ϊ�����ͽ�temp��Ϊȫ�ֱ����ǲ�һ����
 * @author MG
 *
 */
public class PathSumII {
	
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if(root == null){
			return res;
		}
		List<Integer> temp = new ArrayList<Integer>();
		
		dfs(root,0,temp,sum);
		
		return res;
    }
	
	public void dfs(TreeNode root,int sum,List<Integer> temp,int target){
		
		if(root == null){
			return;
		}
		//����Ԫ��
		temp.add(root.val);
		sum += root.val;
		
		if(root.left == null && root.right == null && sum == target){
			res.add(new ArrayList<Integer>(temp));
		}
		
		if(root.left != null){
			dfs(root.left,sum,temp,target);
		}
		
		if(root.right != null){
			dfs(root.right,sum,temp,target);
		}
		
		//���������Ҫ��(��list��ȥ��Ԫ��)
		temp.remove(temp.size() - 1);
		sum -= root.val;
	}
	
	public static void main(String[] mh){
		
	}
}

