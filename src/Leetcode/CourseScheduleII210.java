package Leetcode;

import java.util.ArrayList;
import java.util.List;
/**
 * ÍØÆËÅÅĞòµÄË¼Ïë
 * @author MG
 *
 */
public class CourseScheduleII210 {
	List<Integer> res = new ArrayList<Integer>();
	@SuppressWarnings("unchecked")
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        
        List<Integer>[] adjacencyList = new ArrayList[numCourses];
        for(int i = 0;i < numCourses;i ++){
        	adjacencyList[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0;i < prerequisites.length;i ++){
        	adjacencyList[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i = 0;i < numCourses;i ++){
        	if(!dfs(adjacencyList, visited, i)){
        		res.clear();
        		break;
        	}
        }
        
        int[] result = new int[numCourses];
        int size = res.size();
        for(int i = 0;i < size;i ++){
        	result[i] = res.get(i);
        }
		
		return size > 0 ? result : new int[]{};
    }
	
	private boolean dfs(List<Integer>[] adjacencyList, int[] visited, int current){
		if(visited[current] == -1){
			return false;
		}
		
		if(visited[current] == 1){
			return true;
		}
		
		visited[current] = -1;
		for(int i = 0;i < adjacencyList[current].size();i ++){
			if(!dfs(adjacencyList, visited, adjacencyList[current].get(i))){
				return false;
			}
		}
		
		res.add(current);
		visited[current] = 1;
		
		return true;
	}
}
