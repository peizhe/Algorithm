package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 重点是拓扑排序(线性排序，效率为O(|V|+|E|))(如果图存在环路，则进行拓扑排序无意义，在进行拓扑排序前要判断是否有环存在)
 * 
 * (AOV):顶点表示活动、边表示活动间先后关系的有向图称做顶点活动网(Activity On Vertex network)，简称AOV网
 * AOV网构造拓扑序列的拓扑排序算法主要是循环执行以下两步，直到不存在入度为0的顶点为止。
 * 	(1) 选择一个入度为0的顶点并输出之；
 * 	(2) 从网中删除此顶点及所有出边。
 * 循环结束后，若输出的顶点数小于网中的顶点数，则输出“有回路”信息，否则输出的顶点序列就是一种拓扑序列。
 * 
 * 每个课程都有先驱课程，即要修A课程,必须先修B课程,一共有n门课程，问能否完成([0,1]表示要修0课程必须先修1课程)
 * 	我的理解：找圈的问题(判断一个图中是否有圈)
 * 
 * @author MG
 *
 */
public class CourseSchedule207 {
	
	@SuppressWarnings("unchecked")
	public boolean canFinishDFS(int numCourses, int[][] prerequisites){
	    ArrayList<Integer>[] graph = new ArrayList[numCourses];
	    //初始化为numCourses个链表
	    for(int i = 0;i < numCourses;i ++)
	        graph[i] = new ArrayList<Integer>();
	    
	    //未处理的节点标记为0
	    int[] visited = new int[numCourses];
	    for(int i = 0;i < prerequisites.length;i ++){
	        graph[prerequisites[i][0]].add(prerequisites[i][1]);
	    }

	    //每个节点出发都没有构成环，则不存在环,则能够完成所有课程
	    for(int i = 0;i < numCourses;i ++){
	        if(!dfs(graph, visited, i))
	            return false;
	    }
	    
	    return true;
	}
	
	//每个节点后面链表长度都是1
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
		//这个节点的所有钱去节点访问完后，这个节点状态被置为访问过
		visited[current] = 1;
		
		return true;
	}
	
	
	/**
	 * BFS的方法(一般很少写BFS，好好学习一下)
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
		// O(V + E)
	    List<Integer>[] matrix = new List[numCourses];
	    int[] indegree = new int[numCourses];

	    // E part
	    for (int[] pre : prerequisites) {
	        int preCourse = pre[1];
	        int readyCourse = pre[0];
	        List<Integer> list = matrix[preCourse];
	        if (list == null) {
		        list = new LinkedList<Integer>();   
		        matrix[preCourse] = list;
	        }
	        list.add(readyCourse);
	        indegree[readyCourse]++;
	    }
	    
	    Queue<Integer> queue = new LinkedList<Integer>();
	    for (int i = 0;i < numCourses;i ++) {
	        if (indegree[i] == 0) queue.offer(i);
	    }
	    int count = 0;
	    // V part
	    while (!queue.isEmpty()) {
	        int vertex = queue.poll();
	        count ++;
	        List<Integer> adjacent = matrix[vertex];
	        if (adjacent == null) continue;
	        for (int neighbor : adjacent) {
	            indegree[neighbor]--;
	            if (indegree[neighbor] == 0)
	                queue.offer(neighbor);
	        }
	    }
	    return count == numCourses;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
