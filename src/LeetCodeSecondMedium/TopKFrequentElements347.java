package LeetCodeSecondMedium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ѱ�������г���Ƶ����ߵ�K������ 
 * 	1.mapʵ�֣���ѭ��һ��ͳ�Ƹ�����Ȼ��������Ȼ��ȡǰk��(Ч����Ȼ������ĿҪ�󣬵��ǱȽ���)
 * 	2.�ȽϿ�ķ���(����)
 * 
 * @author MG
 *
 */
public class TopKFrequentElements347 {

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, NumFreq> map = new HashMap<Integer, NumFreq>();

		for (int i = 0; i < nums.length; i++) {
			NumFreq nf = map.get(nums[i]);
			if (nf == null) {
				map.put(nums[i], new NumFreq(nums[i], 1));
			} else {
				nf.freq += 1;
			}
		}
		List<NumFreq> list = new ArrayList<NumFreq>(map.values());
		// Sort the elements by its frequence.
		Collections.sort(list);
		List<Integer> r = new ArrayList<Integer>(k);
		for (int i = 0; i < k; i++) {
			r.add(list.get(i).num);
		}
		return r;
	}

	class NumFreq implements Comparable<NumFreq> {
		int num;
		int freq;

		public NumFreq(int n, int f) {
			num = n;
			freq = f;
		}

		public int compareTo(NumFreq another) {
			return another.freq - freq;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
