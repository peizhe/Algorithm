机器学习 :
	1.监督式学习 : 监督式学习的常见应用场景如分类问题和回归问题。常见算法有逻辑回归（Logistic Regression）和反向传递神经网络（Back Propagation Neural Network）。
	2.非监督式学习 : 常见的应用场景包括关联规则的学习以及聚类等。常见算法包括Apriori算法以及k-Means算法。
	3.半监督学习 : 应用场景包括分类和回归，算法包括一些对常用监督式学习算法的延伸，这些算法首先试图对未标识数据进行建模，在此基础上再对标识的数据进行预测。如图论推理算法（Graph Inference）或者拉普拉斯支持向量机（Laplacian SVM.）等。
	4.强化学习 : 一般应用于机器人中


	算法分类 :
		1.回归算法 : 最小二乘法（Ordinary Least Square），逻辑回归（Logistic Regression），逐步式回归（Stepwise Regression），多元自适应回归样条（Multivariate Adaptive Regression Splines）以及本地散点平滑估计（Locally Estimated Scatterplot Smoothing）。

			(1).最小二乘法 : 一般用于函数拟合
				*1.一次函数线性拟合使用polyfit（x, y, 1）
				*2.多项式函数线性拟合使用 polyfit（x, y, n），n为次数
				*3.非线性函数拟合	lsqcurvefit(fun,x0,x,y)		a = nlinfit(x, y, fun, b0)

			(2).逻辑回归(Y = 1 / (1 + e ^ (-X))型) : 在matlab程序中(已经实现)
				Logistic 回归与多重线性回归实际上有很多相同之处，最大的区别就在于它们的因变量不同，其他的基本都差不多。正是因为如此，这两种回归可以归于同一个家族，即广义线性模型
					如果是连续的，就是多重线性回归；
					如果是二项分布，就是Logistic回归；
					如果是Poisson分布，就是Poisson回归；
					如果是负二项分布，就是负二项回归。

				Logistic 回归的因变量可以是二分类的，也可以是多分类的，但是二分类的更为常用，也更加容易解释。所以实际中最常用的就是二分类的 Logistic 回归。

			(3).逐步回归 : 逐步回归的命令是stepwise()函数，它提供了一个交互式画面，通过此工具可以自由地选择变量，进行统计分析。调用格式为：
				    stepwise(x，y，inmodel，alpha) : 其中x是自变量数据，y是因变量数据，分别为n×m和n×l矩阵，inmodel是矩阵的列数指标(缺省时为全部自变量)，alpha,为显著性水平(缺省时为0.5)

			(4).多元线性回归 : 在Matlab统计工具箱中使用命令regress()实现多元线性回归，调用格式为
    				b = regress(y，x) 或 [b，bint，r，rint，stats] = regess(y，x，alpha)
    				
    				对一元线性回归，取k = 1即可。alpha为显著性水平(缺省时设定为 0.05)，
    					输出向量
    						b，bint为回归系数估计值和它们的置信区间，
    						r，rint为残差及其置信区间，
    						stats是用于检验回归模型的统计量，有四个数值 : 第一个是 R2，其中 R 是相关系数，第二个是 F 统计量值，第三个是与统计量 F 对应的概率 P，第四个是 an estimate of the error variance（一个错误的方差估计）。

    		

		2.基于实例的算法 : 常见的算法包括 k-Nearest Neighbor(KNN), 学习矢量量化（Learning Vector Quantization， LVQ），以及自组织映射算法（Self-Organizing Map ， SOM）。
		3.正则化算法 : 常见的算法包括：Ridge Regression， Least Absolute Shrinkage and Selection Operator（LASSO），以及弹性网络（Elastic Net）。
		4.决策树学习 : 决策树模型常常用来解决分类和回归问题,常见的算法包括：分类及回归树（Classification And Regression Tree， CART）， ID3 (Iterative Dichotomiser 3)， 
					   C4.5， Chi-squared Automatic Interaction Detection(CHAID), Decision Stump, 随机森林（Random Forest）， 多元自适应回归样条（MARS）以及梯度推进机（Gradient Boosting Machine， GBM）
		5.贝叶斯方法 : 常见算法包括：朴素贝叶斯算法，平均单依赖估计（Averaged One-Dependence Estimators， AODE），以及Bayesian Belief Network（BBN）。
		6.基于核的算法 : 常见的基于核的算法包括：支持向量机（Support Vector Machine， SVM）， 径向基函数（Radial Basis Function ，RBF)， 以及线性判别分析（Linear Discriminate Analysis ，LDA)等。
		7.关联规则学习 : 关联规则学习通过寻找最能够解释数据变量之间关系的规则，来找出大量多元数据集中有用的关联规则。常见算法包括 Apriori算法和Eclat算法等。
		8.遗传算法 : 遗传算法适用于非常复杂和困难的环境，比如，带有大量噪声和无关数据、事物不断更新、问题目标不能明显和精确地定义，以及通过很长的执行过程才能确定当前行为的价值等
		9.人工神经网络 : 人工神经网络是机器学习的一个庞大的分支，有几百种不同的算法。（其中深度学习就是其中的一类算法，我们会单独讨论），
					   重要的人工神经网络算法包括：感知器神经网络（Perceptron Neural Network）, 反向传递（Back Propagation）， Hopfield网络，自组织映射（Self-Organizing Map, SOM）。
		10.深度学习 : 深度学习算法是对人工神经网络的发展。常见的深度学习算法包括：受限波尔兹曼机（Restricted Boltzmann Machine， RBN）， Deep Belief Networks（DBN），卷积网络（Convolutional Network）, 堆栈式自动编码器（Stacked Auto-encoders）。
		11.降低维度算法 : 常见的算法包括：主成份分析（Principle Component Analysis， PCA），偏最小二乘回归（Partial Least Square Regression，PLS）， Sammon映射，多维尺度（Multi-Dimensional Scaling, MDS）,  投影追踪（Projection Pursuit）等。
		12.集成算法 : 常见的算法包括：Boosting， Bootstrapped Aggregation（Bagging）， AdaBoost，堆叠泛化（Stacked Generalization， Blending），梯度推进机（Gradient Boosting Machine, GBM），随机森林（Random Forest），GBDT（Gradient Boosting Decision Tree）。

matlab :
	1.fminunc() : 最小值函数
	2.fittype() : 函数拟合中的拟合类型
	3.fit() : 拟合函数
	4.size(,) : 计算矩阵的行数或列数
			