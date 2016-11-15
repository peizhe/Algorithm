package Leetcode;
/**
 * �����������
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	
	List<List<Integer>> ls = new ArrayList<List<Integer>>();
	List<Integer> temp = new ArrayList<Integer>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0){
			return null;
		}        
        if(target <= 0){
			return ls; 
		}
        Arrays.sort(candidates);
        
        wideSearch(candidates,target,0);
        
        return ls;
    }
	
	//��Ϥ���ֻ��ݷ���(dfs)
	public void wideSearch(int[] candidates,int target,int begin){
		//���㵱ǰ��temp�еĺ�
		int sum = 0;
		for(int i = 0;i < temp.size();i ++){
			sum += temp.get(i);
		}
		
		if(sum == target){
			ArrayList<Integer> newlist = new ArrayList<Integer>(temp); 
			ls.add(newlist);
		}
		else if(sum > target){
			return;
		}
		else{
			for(int i = begin;i < candidates.length;i ++){
				//���if�ж�ȥ���˺ܶ಻��Ҫ��ѭ��
				if(candidates[i] > target){
					return;
				}
				else{
					temp.add(candidates[i]);
					wideSearch(candidates, target,i + 1);
					temp.remove(temp.size() - 1);
					//�����ظ���Ԫ��(��ϰ��һ�����ͦ�Ի��˵�)
					while(i < (candidates.length - 1) && candidates[i] == candidates[i + 1]){
						i ++;
					}
				}
			}
		}
	} 
}
