package Leetcode;

import java.util.LinkedList;

public class SimplifyPath71 {

	public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
        	return "/";
        }
        
        LinkedList<String> stack = new LinkedList<String>();
        for(String str : path.split("/")){
        	if(str.equals("..")){
        		if(!stack.isEmpty()) stack.removeLast();
        			
        	} else if(!str.equals(".") && !str.equals("")){
        		stack.add(str);
        	}
        }    
        
        //jdk1.8ÐÂº¯Êý "/" + String.join("/", stack);
        return null;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
