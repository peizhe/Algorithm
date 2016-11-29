package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.List;

import Structure.NestedInteger;

public class FlattenNestedListIterator341 {
	private List<Integer> element;
    private int current;
	
	public FlattenNestedListIterator341(List<NestedInteger> nestedList) {
		element = new ArrayList<Integer>();
		current = 0;
		dfs(nestedList);
	}
	
	public Integer next() {
		return element.get(current ++);
	}

	public boolean hasNext() {
		return element.size() != current;
	}
	
	private void dfs(List<NestedInteger> list){
		for(NestedInteger i : list){
			if(i.isInteger()) element.add(i.getInteger());
			else dfs(i.getList());
		}
	}
}
