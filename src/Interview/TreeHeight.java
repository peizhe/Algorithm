package Interview;

import java.util.ArrayList;
import java.util.List;

public class TreeHeight {
	private static int maxHeight = 1;
	
	@SuppressWarnings({ "unchecked"})
	public static int getTreeHeight(int v, int[][] prerequisites){
		if(v < 1){
			return 0;
		}
		
		if(v == 1){
			return 1;
		}
		
	    ArrayList<Integer>[] graph = new ArrayList[v];
	    
	    for(int i = 0;i < v;i ++)
	        graph[i] = new ArrayList();
	    
	    //将二维数组表示的偏序关系转化成```邻接表```的形式
	    for(int i = 0;i < prerequisites.length;i ++){
	        graph[prerequisites[i][0]].add(prerequisites[i][1]);
	    }

	    for(int i = 0;i < v;i ++){
	    	dfs(graph, i, 1);
	    }
	    
	    return maxHeight;
	}
	
	private static void dfs(List<Integer>[] graph, int current, int height){
		if(graph[current].size() == 0){
			maxHeight = height > maxHeight ? height : maxHeight;
			return;
		}
		
		for(int i = 0;i < graph[current].size();i ++){
			dfs(graph, graph[current].get(i), height + 1);
		}
	}
	
	
	public static void main(String[] mh){
		int[][] x = new int[][]{{0,1},{0,2},{1,3},{1,4},{4,5}};
		System.out.println(getTreeHeight(6, x));
	}
}
