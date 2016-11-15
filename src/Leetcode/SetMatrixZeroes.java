package Leetcode;
/**
 * �����space���ӶȽ�������ͣ�ͨ����һ�е�һ�����洢0��λ��
 * 1.��ȷ����һ�к͵�һ���Ƿ���Ҫ����,����������һ�����Ƿ���0����������Ҳͬʱ��������һ������û��0��
 * 2.ɨ��ʣ�µľ���Ԫ�أ����������0���ͽ���Ӧ�ĵ�һ�к͵�һ���ϵ�Ԫ�ظ�ֵΪ0
 * ���ﲻ�õ��ĻὫ������һ�л��һ�е�1�ĳ���0����Ϊ��Щֵ���ע��Ҫ��Ϊ0�ģ�����matrix[i][j]==0����ômatrix[i][0]���ڵ�i�У�matrix[0][j]���ڵ�j�У����Ҫ����Ϊ0�ġ�
 * 3.���ݵ�һ�к͵�һ�е���Ϣ���Ѿ����Խ�ʣ�µľ���Ԫ�ظ�ֵΪ��������ֵ�˼����õ�һ��Ϊ�������ɨ�赽һ��0���ͽ���һ�ж���0.
 * 4.����1��ȷ����״̬�������һ�к͵�һ�С�����ʼ�õ��ĵ�һ������0�Ļ������������㡣ͬ����н��д���
 * @author MG
 *
 */
public class SetMatrixZeroes {
	
	public void setZeroes(int[][] matrix) {
		int row = matrix.length;
		if(row == 0){
			return;
		}
		int col = matrix[0].length;
		if(col == 0){
			return;
		}
		
		boolean firstRowIsZero = false;
		boolean firstColIsZero = false;
		
		//�жϵ�һ���Ƿ���0
		for(int i = 0;i < matrix[0].length;i ++){
			if(matrix[0][i] == 0){
				firstRowIsZero = true;
				break;
			} 
		}
		//�жϵ�һ���Ƿ�����
		for(int i = 0;i < matrix.length;i ++){
			if(matrix[i][0] == 0){
				firstColIsZero = true;
				break;
			}
		}
		
		for(int i = 1;i < matrix.length;i ++){
			for(int j = 1;j < matrix[0].length;j ++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		//������һ���е�0
		for(int i = 1;i < matrix.length;i ++){
			if(matrix[i][0] == 0){
				//��һ���еĵ�i��Ԫ��Ϊ0���򽫵�i��ȫ����ֵΪ0
				for(int j = 1;j < matrix[0].length;j ++){
					matrix[i][j] = 0;
				}
			}
		}
		
		//������һ���е�0
		for(int i = 1;i < matrix[0].length;i ++){
			//��һ���еĵ�i��Ԫ��Ϊ0���򽫵�i��ȫ����ֵΪ0
			if(matrix[0][i] == 0){
				for(int j = 1;j < matrix.length;j ++){
					matrix[j][i] = 0;
				}
			}
		}
		
		//�����ʼ��һ�д���0
		if(firstRowIsZero){
			for(int i = 0;i < matrix[0].length;i ++){
				matrix[0][i] = 0;
			}
		}
		
		//�����ʼ��һ�д���0
		if(firstColIsZero){
			for(int i = 0;i < matrix.length;i ++){
				matrix[i][0] = 0;
			}
		}
    }
}
