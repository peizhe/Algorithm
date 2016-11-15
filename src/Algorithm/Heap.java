package Algorithm;

/**
 * ���������ݽṹ�� 
 * 	���ѣ���һ����ȫ���������������ݴ洢��ʽ��һ������ 
 * 	��С�ѣ���һ����ȫ��������ͬ�����ݴ洢��ʽ��һ������
 * 
 * @author MG
 * 
 */
public class Heap {
	
	@SuppressWarnings("unused")
	private class MaxHeap {// ���ݴ洢��ʽΪ���飬������ʽ���£���Ҳ��Ϊʲô����ȫ������������ȫ������

		// ����i�ڵ��±�Ѱ���������±�
		public int left(int i) {
			return (i + 1) * 2 - 1;
		}

		// ����i�ڵ��±�Ѱ�����Һ����±�
		public int right(int i) {
			return (i + 1) * 2;
		}

		// ����i�ڵ��±�Ѱ�Ҹ��ڵ��±�
		public int parent(int i) {
			// iΪ�����
			if (i == 0) {
				return -1;
			}
			return (i - 1) / 2;
		}

		// ������
		public void heapModify(int[] a, int i, int heapLength) {
			int l = left(i);
			int r = right(i);

			if (l >= heapLength && r >= heapLength) {
				return;
			}

			int largest = -1;
			/**
			 * ��������if�����������ҵ�����Ԫ���е����Ԫ�ص�λ��largest�� l < heapLength˵��l�������ڣ�i��Ҷ�ӽ�㣻
			 */
			if (l < heapLength && a[i] - a[l] < 0) {
				largest = l;
			} else {
				largest = i;
			}
			// r < heapLength˵��r��������
			if (r < heapLength && a[largest] - a[r] < 0) {
				largest = r;
			}
			// ���i��Ԫ�ز������ģ��Ͱ�i����Ԫ�������Ԫ�ؽ�����������ʹԪ���½�
			if (i != largest) {
				int temp = a[i];
				a[i] = a[largest];
				a[largest] = temp;
				// ����Ԫ�غ���a[i]Ϊ���������ܲ��������������ʣ����ǵݹ���ø÷���
				heapModify(a, largest, heapLength);
			}
		}
		
		//��������
		public  void buildMaxHeap(int[] a, int heapLength) {
	        // �Ӻ���ǰ����lengthParent - 1����Ԫ���ǵ�һ���к��ӽڵ�Ľڵ�
	        int lengthParent = parent(heapLength - 1);
	        // �����parent(length)֮�������Ԫ�ض���Ҷ�ӽ�㣻
	        // ��Ϊ����length/2��Ԫ�صĺ��ӽڵ�������ڣ���ô
	        // ���ǵ������±�ֵ�ض�����length��������ʵ������
	        // �������У�����Ԫ�رض��ڸ���Ԫ�صĺ��棬�Ӻ���ǰ
	        // ��Ԫ�ص���maxHeapify����֤��Ԫ�صĺ��Ӷ���
	        // �����
	        for(int i = lengthParent; i >= 0; i--){
	        	heapModify(a, i, heapLength);
	        }
	    }
	}

	@SuppressWarnings("unused")
	private class MinHeap {

		// ����i�ڵ��±�Ѱ���������±�
		public int left(int i) {
			return (i + 1) * 2 - 1;
		}

		// ����i�ڵ��±�Ѱ�����Һ����±�
		public int right(int i) {
			return (i + 1) * 2;
		}

		// ����i�ڵ��±�Ѱ�Ҹ��ڵ��±�
		public int parent(int i) {
			// iΪ�����
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
			 * ��������if�����������ҵ�����Ԫ���е���СԪ�ص�λ��smallest�� s < heapLength˵��l�������ڣ�i��Ҷ�ӽ�㣻
			 */
			if (l < heapLength && a[i] - a[l] > 0) {
				smallest = l;
			} else {
				smallest = i;
			}
			// r < heapLength˵��r��������
			if (r < heapLength && a[smallest] - a[r] > 0) {
				smallest = r;
			}
			// ���i��Ԫ�ز�����С�ģ��Ͱ�i����Ԫ������С��Ԫ�ؽ�����������ʹԪ���½�
			if (i != smallest) {
				int temp = a[i];
				a[i] = a[smallest];
				a[smallest] = temp;
				// ����Ԫ�غ���a[i]Ϊ���������ܲ��������������ʣ����ǵݹ���ø÷���
				heapModify(a, smallest, heapLength);
			}
		}
		
		//������С��
		public void buildMinHeap(int[] a, int heapLength) {
	        // �Ӻ���ǰ����lengthParent - 1����Ԫ���ǵ�һ���к��ӽڵ�Ľڵ�
	        int lengthParent = parent(heapLength - 1);
	        // �����parent(length)֮�������Ԫ�ض���Ҷ�ӽ�㣻
	        // ��Ϊ����length/2��Ԫ�صĺ��ӽڵ�������ڣ���ô
	        // ���ǵ������±�ֵ�ض�����length��������ʵ������
	        // �������У�����Ԫ�رض��ڸ���Ԫ�صĺ��棬�Ӻ���ǰ
	        // ��Ԫ�ص���maxHeapify����֤��Ԫ�صĺ��Ӷ���
	        // �����
	        for(int i = lengthParent; i >= 0; i--){
	        	heapModify(a, i, heapLength);
	        }
	    }
	}
}
