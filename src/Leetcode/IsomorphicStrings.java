package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
	
	public boolean isIsomorphic(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        
        //���ڴ洢�ַ���s���ַ���t��ӳ���ϵ
        Map<Character,Character> map = new HashMap<Character,Character>();
        //�洢t�ַ����е�ÿ���ַ�
        Set<Character> set = new HashSet<Character>();
        
        for(int i = 0;i < schar.length;i ++){
        	//���ǰ���ӳ���ϵ���Ѵ���schar[i]ӳ��
        	if(map.containsKey(schar[i])){
        		//�Ƚ�ǰ��洢schar[i]ӳ����ַ����ʱtchar[i]�Ƿ���ͬ
        		//����ͬ�򷵻�false
        		if(map.get(schar[i]) != tchar[i]){
        			return false;
        		}
        	}
        	//������schar[i]��ӳ���ϵ
        	else{
        		//���set�д�����tchar[i],֤��ǰ��tchar[k]�Ѿ���Ӧһ��schar[k]
        		//֤����ǰschar[i]��schar[k]��Ӧһ��tchar[k]
        		if(set.contains(tchar[i])){
        			return false;
        		}
        		//set�в�����tchar[i]
        		else{
        			map.put(schar[i],tchar[i]);
        			set.add(tchar[i]);
        		}
        	}
        }
        
        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
