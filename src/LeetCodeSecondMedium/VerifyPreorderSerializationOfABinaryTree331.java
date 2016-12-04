package LeetCodeSecondMedium;

public class VerifyPreorderSerializationOfABinaryTree331 {
	public boolean isValidSerialization(String preorder) {
		if(preorder == null || preorder.length() == 0) return true;
		String[] nodes = preorder.split(",");
		int len = nodes.length, count = 0;
		
		for(int i = len - 1; i >= 0; i--) {
			if(nodes[i].equals("#")) count ++;
			else {
				count -= 2;
				if(count < 0) return false;
				count += 1;
			}
		}
		
        return count == 1;
    }
}
