package Algorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * 拓扑排序
 * 适用于有向无环图
 * @author MG
 *
 */
public class TopologySort {
	private List<Integer> res = new ArrayList<Integer>();
		
	/**
	 * 
	 * @param v 节点个数
	 * @param prerequisites 偏序关系(二维数组的形式)(如果直接给邻接表的形式，则更简单)
	 * @return 如果图无环，则返回拓扑排序的结果;如果有环，则返回空的Stack<Integer>
	 * 	访问过的节点在dfs中不会加入结果集，因此结果集不会出现重复的元素(即时x既为y的前驱也为z的前驱)
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> topologySort(int v, int[][] prerequisites){
	    ArrayList<Integer>[] graph = new ArrayList[v];
	    //初始化为numCourses个链表
	    for(int i = 0;i < v;i ++)
	        graph[i] = new ArrayList();
	    
	    //未处理的节点标记为0
	    int[] visited = new int[v];
	    
	    //将二维数组表示的偏序关系转化成```邻接表```的形式
	    for(int i = 0;i < prerequisites.length;i ++){
	        graph[prerequisites[i][0]].add(prerequisites[i][1]);
	    }

	    //如果存在环，则不能进行拓扑排序,结果也会为空
	    for(int i = 0;i < v;i ++){
	        if(!dfs(graph, visited, i)){
	        	res.clear();
	            return res;
	        }
	    }
	    
	    return res;
	}
	
	/**
	 * 对图进行 
	 * @param graph
	 * @param visited
	 * @param current
	 * @return	(如果有环，则返回false, 没有环则返回true)
	 */
	private boolean dfs(List<Integer>[] graph, int[] visited, int current){
		//如果当前节点为正在访问节点(则出现环状结构，返回false)
		if(visited[current] == -1){
			return false;
		}
		
		//如果当前节点为已访问过得节点(则直接返回，前面已经访问过，返回true)
		if(visited[current] == 1){
			return true;
		}
		
		//标记当前节点为正在访问节点
		visited[current] = -1;
		for(int i = 0;i < graph[current].size();i ++){
			if(!dfs(graph, visited, graph[current].get(i))){
				return false;
			}
		}
		//这个节点的所有前驱节点访问完后，这个节点状态被置为访问过
		visited[current] = 1;
		
		//压入的是节点的编号
		res.add(current);
		
		return true;
	}

}
