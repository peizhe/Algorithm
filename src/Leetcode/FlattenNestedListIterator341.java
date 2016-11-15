package Leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator341 implements Iterator<Integer>{

	List<Integer> element;
	
	public FlattenNestedListIterator341(List<NestedInteger> nestedList) {
		element = new ArrayList<Integer>();
		dfs(nestedList, 0, nestedList.size());
	}
	
	
	public Integer next() {
		return element.remove(0);
	}

	public boolean hasNext() {
		return element.size() > 0;
	}
	
	private void dfs(List<NestedInteger> list, int position, int size){
		for(int i = position;i < size;i ++){
			NestedInteger temp = list.get(i);
			if(temp.isInteger()){
				element.add(temp.getInteger());
			} else {
				dfs(temp.getList(), 0, temp.getList().size());
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {

		// @return true if this NestedInteger holds a single integer, rather
		// than a nested list.
		public boolean isInteger();

		// @return the single integer that this NestedInteger holds, if it holds
		// a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();

		// @return the nested list that this NestedInteger holds, if it holds a
		// nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

	public void remove() {
		// TODO Auto-generated method stub
	}
}
