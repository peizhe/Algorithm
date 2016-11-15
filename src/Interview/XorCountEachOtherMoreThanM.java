package Interview;
/**
 * 
 * @author MG
 *
 */
public class XorCountEachOtherMoreThanM {
	
	class Node {
		Node[] son;
		int count;
		int val;
		
		Node(){
			son = new Node[2];
			count = 1;
		}
	}
	
	private void insert(Node root, int num){
		Node node = root;
		
		for(int i = 31;i >= 0;i --){
			int bit = (num >> i) & 1;
			if(node.son[bit] == null){
				node.son[bit] = new Node();
				node.son[bit].val = bit;
			} else {
				node.son[bit].count ++;
			}
			
			node = node.son[bit];
		}
	}
	
	private int matchBest(Node root, int num, int target){
		int count = 0;
		Node node = root;
		for(int i = 31;i >= 0;i ++){
			int numBit = (num >> i) & 1;
			int targetBit = (target >> i) & 1;
			if(targetBit == 1){
				node = node.son[1 ^ numBit];
			} else {
				//if (p[now].next[1^a[i]] != -1) ret += p[p[now].next[1^a[i]]].count;
	            //now = p[now].next[a[i]];
				if(node.son[1 ^ numBit] != null) count += node.son[1 ^ numBit].count;
				
				node = node.son[numBit];
			}
		}
		
		return count;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
