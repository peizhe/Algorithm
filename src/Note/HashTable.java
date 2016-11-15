package Note;
/**
 * 哈希表的形式：
 * 	直接寻址表：最坏查找时间是O(1)
 * 		分配的数组大小是(最大值-最小值 + 1)
 * 	散列表：平均查找时间是O(1)
 * 		分配数组大小是固定的(关键字K对应的地址通过散列函数h(k)计算得到散列地址,散列函数的好坏很重要)这样会产生冲突
 * 			解决冲突的办法：
 * 				1.链接法：(每一个地址后面是一个链表)每次在头部插入节点 ，可以删除!
 * 				2.开放寻址法：如果要删除元素，则不要采取这种解决冲突的办法，因为删除比较困难。
 *			常用的散列函数：
 *				1.除法散列法(取模的方法) h(k) = k % 一个素数(这个素数尽量不接近2的幂)
 *				2.乘法散列法 h(k) = [m(kA % 1)] (0< A < 1, 一般取黄金分隔比例(sqrt(5) - 1) / 2; kA % 1为取小数部分，长见识; m一般取2的幂)
 * 				3.全局散列法 首先创建一些散列函数，每次随机选择散列函数，这样就避免了出现所有元素放入一个槽的情况
 */	
public class HashTable {
	
}
