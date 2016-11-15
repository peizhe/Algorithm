package Leetcode;
/**
 * 回溯法（隐式深度优先搜索算法）
 * 
 * 循环里面套递归。这是一种方法，要记住！
 */
import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	List<List<Integer>> ans = new ArrayList<List<Integer>>();  
    int n = 0;  
    int k = 0;  
      
    public List<List<Integer>> combine(int n, int k) {  
        this.n = n;  
        this.k = k;  
        List<Integer> list = new ArrayList<Integer>();  
        backTracking(list, 1);  
        return ans;  
    }  
      
    public void backTracking(List<Integer> list, int from) {  
        if (list.size() == k) {  
            List<Integer> newList = new ArrayList<Integer>(list);  
            ans.add(newList);  
            return;  
        }  
        for (int i = from; i <= n; i ++) {  
            list.add(i);  
            backTracking(list, i + 1);  
            list.remove(new Integer(i));  
        }  
    }  
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Combinations c = new Combinations();
		int n = 4,k = 2;
		c.combine(n, k);
		for(int i = 0;i < c.ans.size();i ++){
			for(int j = 0;j < c.ans.get(i).size();j ++){
				System.out.print(c.ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
