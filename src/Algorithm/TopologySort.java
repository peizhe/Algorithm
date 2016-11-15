package Algorithm;

import java.util.ArrayList;
import java.util.List;
/**
 * ��������
 * �����������޻�ͼ
 * @author MG
 *
 */
public class TopologySort {
	private List<Integer> res = new ArrayList<Integer>();
		
	/**
	 * 
	 * @param v �ڵ����
	 * @param prerequisites ƫ���ϵ(��ά�������ʽ)(���ֱ�Ӹ��ڽӱ����ʽ�������)
	 * @return ���ͼ�޻����򷵻���������Ľ��;����л����򷵻ؿյ�Stack<Integer>
	 * 	���ʹ��Ľڵ���dfs�в��������������˽������������ظ���Ԫ��(��ʱx��Ϊy��ǰ��ҲΪz��ǰ��)
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> topologySort(int v, int[][] prerequisites){
	    ArrayList<Integer>[] graph = new ArrayList[v];
	    //��ʼ��ΪnumCourses������
	    for(int i = 0;i < v;i ++)
	        graph[i] = new ArrayList();
	    
	    //δ����Ľڵ���Ϊ0
	    int[] visited = new int[v];
	    
	    //����ά�����ʾ��ƫ���ϵת����```�ڽӱ�```����ʽ
	    for(int i = 0;i < prerequisites.length;i ++){
	        graph[prerequisites[i][0]].add(prerequisites[i][1]);
	    }

	    //������ڻ������ܽ�����������,���Ҳ��Ϊ��
	    for(int i = 0;i < v;i ++){
	        if(!dfs(graph, visited, i)){
	        	res.clear();
	            return res;
	        }
	    }
	    
	    return res;
	}
	
	/**
	 * ��ͼ���� 
	 * @param graph
	 * @param visited
	 * @param current
	 * @return	(����л����򷵻�false, û�л��򷵻�true)
	 */
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
		//����ڵ������ǰ���ڵ�����������ڵ�״̬����Ϊ���ʹ�
		visited[current] = 1;
		
		//ѹ����ǽڵ�ı��
		res.add(current);
		
		return true;
	}

}
