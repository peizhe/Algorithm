package LeetCodeSecondMedium;

public class MaximumXOROfTwoNumbersInAnArray421 {
	
	class Node {
		Node[] sons;
        public Node() {
            sons = new Node[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
    	
        Node root = new Node();
        
        int res = 0;
        for (int num : nums) {
            int bit = num;
            int tmp = 0;
            Node setNode = root;
            Node findNode = root;
            
            for(int pos = 30; pos >= 0; pos--) {
            	bit = (num >> pos) & 1;
            	
            	//≤Â»Î
            	if(setNode.sons[bit] == null) {
            		setNode.sons[bit] = new Node();
            	}
            	setNode = setNode.sons[bit];

            	//≤È’“
                if (bit == 1) {
                    if (findNode.sons[0] != null) {
                        tmp |= (1 << pos);
                        findNode = findNode.sons[0];
                    } else {
                        findNode = findNode.sons[1];
                    }
                } else {
                    if (findNode.sons[1] != null) {
                        tmp |= 1 << pos;
                        findNode = findNode.sons[1];
                    } else {
                        findNode = findNode.sons[0];
                    }
                }
            }
           
            res = Math.max(res, tmp);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
