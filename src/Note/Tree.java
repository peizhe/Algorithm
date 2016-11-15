package Note;

/**
 * 树的一些性质：
 * 	1.满二叉树：一棵满二叉树(所有非叶子节点都有两个孩子)的中间节点比叶子节点少1个，总结点数是(2 * 叶子节点 - 1)
 * 		位置为i节点的左孩子位置是 2*i + 1,右孩子是2*i + 2(国内定义的满二叉树满足)
 * 		国际上定义的满二叉树(每个节点有0或者2个孩子)和国内定义的满二叉树(每一层节点数是2 ^ h(h为高度))不同
 * 	2.完全二叉树：所有叶子节点集中在树的最低两层，且所有叶子节点在该层的左边
 *		位置为i节点的左孩子位置是 2*i + 1,右孩子是2*i + 2
 * 	3.最优二叉树：一般和编码有关，要求编码平均长度最短
 * 	4.最小生成树：权重最小，解决实际运输问题
 *  5.平衡树：每一个节点左右孩子高度差不超过1
 *  	AVL树(使用较少，调整平衡花销很大) : 高度平衡的二叉树 (早期应用于Linux的内核上，后来被红黑树替代;windows对进程地址空间的管理用到了AVL树)
 *  6.二叉搜索树：左节点值  < 根节点值  < 右节点值
 *		红黑树(搜索效率比二叉搜索树更高) ： 平衡的二叉搜索树(广泛用在C++的STL中。map和set都是用红黑树实现的。)
 *	7.Trie树 : 字典树(用在统计和排序大量字符串)
 *	8.B/B+ 树 ：用在磁盘文件组织 数据索引和数据库索引
 *	9.有根树：
 *		(1)二叉树中节点有指向父节点的指针
 *		(2)分支无限制的有根树(数据结构的表示用```左孩子右兄弟```表示方法，这种方法表示的树遍历自己写一下)
 *	10.二叉索引树 (弄清楚它的存储结构): RangeSumQueryMutable307 CountOfSmallerNumbersAfterSelf315
 *		支持动态连续区间和的查询,BIT含有N个结点，每个结点存储一段区间的和。
 *		每次更新数组A的一个元素，只需要更新BIT中的LogN个结点；每次查询A的前缀区间和，只需要查询BIT中的LogN个节点；
 *		BIT树用数组表示，下标区间为[1..N]，左孩子i其父结点为i + lowbit(i)，右孩子i其父节点为 i - lowbit(i)，
 *		***(重点看懂这个) 每个BIT结点i代表的区间和为 :
 *				A[i - lowbit(i) + 1] + A[i - lowbit(i) + 2] + ... + A[i]。
 *		其中lowbit(i) = i & (-i) 即i的最低非0位代表的值(1,2,4,8,...)。
 *
 *		解决类似问题:
 * 			给定N元数组A[0]...A[N-1]，设计一个数据结构，支持两种操作：
 * 				1. add(i,v) 将A[i]元素值增加v，下标i区间为[0..N-1]
 * 				2. sum(L,R) 查询连续区间和 A[L] + A[L+1] + ... + A[R], 下标L,R区间为[0..N-1]
 * 
 *	11.二叉线索树 : 每一个节点需要保存5个变量  (LeftFlag leftNode val rightNode RightFlag)
 *		LeftFlag : 标记当前是否存在左孩子,LeftFlag = 0 表示没有左孩子,LeftFlag = 1 表示有左孩子
 *		leftNode : LeftFlag = 0时,指向该节点的前驱节点,LeftFlag = 1时,指向该节点的左孩子
 *		val : 当前节点的值
 *		rightNode : RightFlag = 0时,指向该节点的前驱节点,RightFlag = 1时,指向该节点的左孩子
 *		RightFlag :	标记当前是否存在右孩子,RightFlag = 0 表示没有右孩子,RightFlag = 1 表示有右孩子
 *
 *	12.哈希树 : 根据质数分辨定理(n个不同的质数可以“分辨”的连续整数的个数和这n个不同质数的乘积相等)建立的一种数据结构(和Trie树类似)
 *		2 * 3 * 5 * 7 * 11 * 13.......
 *		插入节点时 : 首先%2,决定在0,1哪个分支,如果该分支已存在数(即产生冲突),
 *				     然后%3,界定在0,1,2哪个分支,如果该分支已存在数
 *				  ...%5
 *				  .....
 *		缺点 : 无序,想通过遍历的方式进行排序有些困难
 *		优点 : 空间需求仅和所需要存储的对象个数有关,结构简单、查找迅速、结构不变(删除节点会树结构不变)
 *		用途 : 哈希树可以广泛应用于那些需要对大容量数据进行快速匹配操作的地方。例如：数据库索引系统、短信息中的收条匹配、大量号码路由匹配、信息过滤匹配。哈希树不需要额外的平衡和防止退化的操作，效率十分理想。		
 *
 *	13.基数树(Trie树的更普遍情况) : Trie树一般用于字符串到对象的映射，Radix树一般用于长整数到对象的映射。
 *
 */
public class Tree {
	/**
	 * 二叉有根树(有指向父节点的二叉树)
	 * @author MG
	 *
	 */
	public class TreePointToParent {
		int val;
		Tree parent;
		Tree left;
		Tree right;
		TreePointToParent(int x) { val = x; }
	}
	
	/**
	 * 分支无限制的有根树(每个节点的孩子数目不相同，并且数目不确定)
	 * 	左孩子右兄弟表示法(Page138)
	 *  
	 * @author MG
	 *
	 */
	public class TreeBranchNoLimit{
		int val;
		Tree parent;//指向父节点
		Tree left;//指向自己最左边的孩子节点
		Tree right;//指向自己的下一个兄弟节点
		TreeBranchNoLimit(int x) { val = x; }
	}
}
