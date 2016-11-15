package Algorithm;

/**
 * 堆这种数据结构： 
 * 	最大堆：是一棵完全二叉树，但是数据存储形式是一个数组 
 * 	最小堆：是一棵完全二叉树，同样数据存储形式是一个数组
 * 
 * @author MG
 * 
 */
public class Heap {
	
	@SuppressWarnings("unused")
	private class MaxHeap {// 数据存储形式为数组，访问形式如下，这也是为什么是完全二叉树，不是全二叉树

		// 根据i节点下标寻找其左孩子下标
		public int left(int i) {
			return (i + 1) * 2 - 1;
		}

		// 根据i节点下标寻找其右孩子下标
		public int right(int i) {
			return (i + 1) * 2;
		}

		// 根据i节点下标寻找父节点下标
		public int parent(int i) {
			// i为根结点
			if (i == 0) {
				return -1;
			}
			return (i - 1) / 2;
		}

		// 调整堆
		public void heapModify(int[] a, int i, int heapLength) {
			int l = left(i);
			int r = right(i);

			if (l >= heapLength && r >= heapLength) {
				return;
			}

			int largest = -1;
			/**
			 * 下面两个if条件句用来找到三个元素中的最大元素的位置largest； l < heapLength说明l在数组内，i非叶子结点；
			 */
			if (l < heapLength && a[i] - a[l] < 0) {
				largest = l;
			} else {
				largest = i;
			}
			// r < heapLength说明r在数组内
			if (r < heapLength && a[largest] - a[r] < 0) {
				largest = r;
			}
			// 如果i处元素不是最大的，就把i处的元素与最大处元素交换，交换会使元素下降
			if (i != largest) {
				int temp = a[i];
				a[i] = a[largest];
				a[largest] = temp;
				// 交换元素后，以a[i]为根的树可能不在满足大根堆性质，于是递归调用该方法
				heapModify(a, largest, heapLength);
			}
		}
		
		//建立最大堆
		public  void buildMaxHeap(int[] a, int heapLength) {
	        // 从后往前看，lengthParent - 1处的元素是第一个有孩子节点的节点
	        int lengthParent = parent(heapLength - 1);
	        // 最初，parent(length)之后的所有元素都是叶子结点；
	        // 因为大于length/2处元素的孩子节点如果存在，那么
	        // 它们的数组下标值必定大于length，这与事实不符；
	        // 在数组中，孩子元素必定在父亲元素的后面，从后往前
	        // 对元素调用maxHeapify，保证了元素的孩子都是
	        // 大根堆
	        for(int i = lengthParent; i >= 0; i--){
	        	heapModify(a, i, heapLength);
	        }
	    }
	}

	@SuppressWarnings("unused")
	private class MinHeap {

		// 根据i节点下标寻找其左孩子下标
		public int left(int i) {
			return (i + 1) * 2 - 1;
		}

		// 根据i节点下标寻找其右孩子下标
		public int right(int i) {
			return (i + 1) * 2;
		}

		// 根据i节点下标寻找父节点下标
		public int parent(int i) {
			// i为根结点
			if (i == 0) {
				return -1;
			}
			return (i - 1) / 2;
		}

		public void heapModify(int[] a, int i, int heapLength) {
			int l = left(i);
			int r = right(i);
			
			if (l >= heapLength && r >= heapLength) {
				return;
			}
			
			int smallest = -1;
			/**
			 * 下面两个if条件句用来找到三个元素中的最小元素的位置smallest； s < heapLength说明l在数组内，i非叶子结点；
			 */
			if (l < heapLength && a[i] - a[l] > 0) {
				smallest = l;
			} else {
				smallest = i;
			}
			// r < heapLength说明r在数组内
			if (r < heapLength && a[smallest] - a[r] > 0) {
				smallest = r;
			}
			// 如果i处元素不是最小的，就把i处的元素与最小处元素交换，交换会使元素下降
			if (i != smallest) {
				int temp = a[i];
				a[i] = a[smallest];
				a[smallest] = temp;
				// 交换元素后，以a[i]为根的树可能不在满足大根堆性质，于是递归调用该方法
				heapModify(a, smallest, heapLength);
			}
		}
		
		//建立最小堆
		public void buildMinHeap(int[] a, int heapLength) {
	        // 从后往前看，lengthParent - 1处的元素是第一个有孩子节点的节点
	        int lengthParent = parent(heapLength - 1);
	        // 最初，parent(length)之后的所有元素都是叶子结点；
	        // 因为大于length/2处元素的孩子节点如果存在，那么
	        // 它们的数组下标值必定大于length，这与事实不符；
	        // 在数组中，孩子元素必定在父亲元素的后面，从后往前
	        // 对元素调用maxHeapify，保证了元素的孩子都是
	        // 大根堆
	        for(int i = lengthParent; i >= 0; i--){
	        	heapModify(a, i, heapLength);
	        }
	    }
	}
}
