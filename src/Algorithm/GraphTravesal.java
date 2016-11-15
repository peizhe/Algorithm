package Algorithm;

import java.util.*;

/**
 * ͼ��������ȱ����͹�����ȱ���
 * @author MG
 *
 */
public class GraphTravesal {
	
	public static void main(String[] mh){
		int n = 8;//�ֱ����������ͱߵ���Ŀ
        String labels[]={"1","2","3","4","5","6","7","8"};//���ı�ʶ
        boolean[] isVisited = new boolean[n];
        GraphTravesal graph = new GraphTravesal(n);
        for(String label : labels) {
            graph.insertVertex(label);//������
        }
        //���������
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        graph.insertEdge(7, 3, 1);
        graph.insertEdge(7, 4, 1);
        graph.insertEdge(6, 2, 1);
        graph.insertEdge(5, 2, 1);
        graph.insertEdge(6, 5, 1);
        
        System.out.println("���������������Ϊ��");
        graph.depthFirstSearch(isVisited);
        
        System.out.println();
        Arrays.fill(isVisited, false);
        System.out.println("���������������Ϊ��");
        graph.broadFirstSearch(isVisited);
    }
	
	@SuppressWarnings("unchecked")
	private ArrayList vertexList;//�洢�������
    private int[][] edges;//�ڽӾ��������洢��
    private int numOfEdges;//�ߵ���Ŀ

    @SuppressWarnings("unchecked")
	public GraphTravesal(int n) {
        //��ʼ������һά���飬�ͱߵ���Ŀ
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges = 0;
    }
    
    /**
     * 1.���ʳ�ʼ���v������ǽ��vΪ�ѷ��ʡ�
	 * 2.���ҽ��v�ĵ�һ���ڽӽ��w��
	 * 3.��w���ڣ������ִ��4�������㷨������
	 * 4.��wδ�����ʣ���w����������ȱ����ݹ飨����w������һ��v��Ȼ����в���123����
	 * 5.���ҽ��v��w�ڽӽ�����һ���ڽӽ�㣬ת������3
     * @param isVisited
     */
    public void depthFirstSearch(boolean[] isVisited) {
        for(int i = 0;i < getNumOfVertex();i ++) {
            //��Ϊ���ڷ���ͨͼ��˵��������ͨ��һ������һ�����Ա������н��ġ�
            if (!isVisited[i]) {
                depthFirstSearch(isVisited, i);
            }
        }
    }
    
    private void depthFirstSearch(boolean[] isVisited, int i) {
        //���ȷ��ʸý�㣬�ڿ���̨��ӡ����
        System.out.print(getValueByIndex(i) + " ");
        //�øý��Ϊ�ѷ���
        isVisited[i] = true;
        
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                depthFirstSearch(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }
    
    /**
     * 1.���ʳ�ʼ���v����ǽ��vΪ�ѷ��ʡ�
	 * 2.���v�����
	 * 3.�����зǿ�ʱ������ִ�У������㷨������
	 * 4.�����У�ȡ�ö�ͷ���u��
	 * 5.���ҽ��u�ĵ�һ���ڽӽ��w��
	 * 6.�����u���ڽӽ��w�����ڣ���ת������3������ѭ��ִ�������������裺
	 * 		1). �����w��δ�����ʣ�����ʽ��w�����Ϊ�ѷ��ʡ�
	 * 		2). ���w�����
	 * 		3). ���ҽ��u�ļ�w�ڽӽ������һ���ڽӽ��w��ת������6��
     * @param isVisited
     */
    public void broadFirstSearch(boolean[] isVisited) {
        for(int i = 0;i < getNumOfVertex();i ++) {
            if(!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
    }
    
    //˽�к�����������ȱ���
    private void broadFirstSearch(boolean[] isVisited, int i) {
        int u,w;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        //���ʽ��i
        System.out.print(getValueByIndex(i) + " ");
        isVisited[i] = true;
        //��������
        queue.add(i);
        while (!queue.isEmpty()) {
            u = ((Integer)queue.removeFirst()).intValue();
            w = getFirstNeighbor(u);
            while(w != -1) {
                if(!isVisited[w]) {
                    //���ʸý��
                    System.out.print(getValueByIndex(w) + " ");
                    //����ѱ�����
                    isVisited[w]=true;
                    //�����
                    queue.addLast(w);
                }
                //Ѱ����һ���ڽӽ��
                w = getNextNeighbor(u, w);
            }
        }
    }
    
    //�õ����ĸ���
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //�õ��ߵ���Ŀ
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //���ؽ��i������
    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //����v1,v2��Ȩֵ
    public int getWeight(int v1,int v2) {
        return edges[v1][v2];
    }

    //������
    @SuppressWarnings("unchecked")
	public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(), vertex);
    }

    //������
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        numOfEdges ++;
    }

    //ɾ�����
    public void deleteEdge(int v1, int v2) {
        edges[v1][v2] = 0;
        numOfEdges --;
    }

    //�õ���һ���ڽӽ����±�
    public int getFirstNeighbor(int index) {
        for(int j = 0;j < vertexList.size();j ++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //����ǰһ���ڽӽ����±���ȡ����һ���ڽӽ��
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1;j < vertexList.size();j ++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }
}
