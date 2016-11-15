package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * �ص�����������(��������Ч��ΪO(|V|+|E|))(���ͼ���ڻ�·��������������������壬�ڽ�����������ǰҪ�ж��Ƿ��л�����)
 * 
 * (AOV):�����ʾ����߱�ʾ����Ⱥ��ϵ������ͼ����������(Activity On Vertex network)�����AOV��
 * AOV�������������е����������㷨��Ҫ��ѭ��ִ������������ֱ�����������Ϊ0�Ķ���Ϊֹ��
 * 	(1) ѡ��һ�����Ϊ0�Ķ��㲢���֮��
 * 	(2) ������ɾ���˶��㼰���г��ߡ�
 * ѭ��������������Ķ�����С�����еĶ���������������л�·����Ϣ����������Ķ������о���һ���������С�
 * 
 * ÿ���γ̶��������γ̣���Ҫ��A�γ�,��������B�γ�,һ����n�ſγ̣����ܷ����([0,1]��ʾҪ��0�γ̱�������1�γ�)
 * 	�ҵ���⣺��Ȧ������(�ж�һ��ͼ���Ƿ���Ȧ)
 * 
 * @author MG
 *
 */
public class CourseSchedule207 {
	
	@SuppressWarnings("unchecked")
	public boolean canFinishDFS(int numCourses, int[][] prerequisites){
	    ArrayList<Integer>[] graph = new ArrayList[numCourses];
	    //��ʼ��ΪnumCourses������
	    for(int i = 0;i < numCourses;i ++)
	        graph[i] = new ArrayList<Integer>();
	    
	    //δ����Ľڵ���Ϊ0
	    int[] visited = new int[numCourses];
	    for(int i = 0;i < prerequisites.length;i ++){
	        graph[prerequisites[i][0]].add(prerequisites[i][1]);
	    }

	    //ÿ���ڵ������û�й��ɻ����򲻴��ڻ�,���ܹ�������пγ�
	    for(int i = 0;i < numCourses;i ++){
	        if(!dfs(graph, visited, i))
	            return false;
	    }
	    
	    return true;
	}
	
	//ÿ���ڵ���������ȶ���1
	private boolean dfs(List<Integer>[] graph, int[] visited, int current){
		//�����ǰ�ڵ�Ϊ���ڷ��ʽڵ�(����ֻ�״�ṹ������false)
		if(visited[current] == -1){
			return false;
		}
		
		//�����ǰ�ڵ�Ϊ�ѷ��ʹ��ýڵ�(��ֱ�ӷ��أ�ǰ���Ѿ����ʹ�������true)
		if(visited[current] == 1){
			return true;
		}
		
		//��ǵ�ǰ�ڵ�Ϊ���ڷ��ʽڵ�
		visited[current] = -1;
		for(int i = 0;i < graph[current].size();i ++){
			if(!dfs(graph, visited, graph[current].get(i))){
				return false;
			}
		}
		//����ڵ������Ǯȥ�ڵ�����������ڵ�״̬����Ϊ���ʹ�
		visited[current] = 1;
		
		return true;
	}
	
	
	/**
	 * BFS�ķ���(һ�����дBFS���ú�ѧϰһ��)
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
