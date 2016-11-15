package Leetcode;
/**
 * subString(begin,end);������ȡ���ַ����Ȱ���begin��Ҳ����end��
 */
public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs == null){
			return null;
		}
		if(strs.length == 0){
			return "";
		}
		if(strs.length == 1){
			return strs[0];
		}
		
		int minLength = strs[0].length();
		int index = 0;
		//�ҵ�������̵��ַ������ȼ��±�
		for(int i = 1;i < strs.length;i ++){
			if(strs[i].length() < minLength){
				minLength = strs[i].length();
				index = i;
			}
		}
		
		String temp = strs[index];
		if(temp == ""){
			return "";
		}
		//��������ַ���������ǰ׺
		for(int j = 1;j < temp.length() + 1;j ++){
			String prefix = temp.substring(0,j);
			for(int i = 0;i < strs.length;i ++){
				if(!strs[i].startsWith(prefix)){
					return prefix.substring(0,j - 1);
				}
			}
		}
		
		return temp;
    }
}
