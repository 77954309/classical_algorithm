# classical_algorithm
经典算法

程序设计=数据结构+算法

数据结构分为逻辑结构和物理结构

逻辑结构：是指数据对象中数据元素之间相互关系，也是我们今后最需要关注和讨论的问题。

物理结构：是指数据的逻辑结构在计算机中存储形式。

集合结构：集合结构中的数据元素除了同属一个集合。

线性结构：数据元素一对一的关系。

树形结构：数据元素之间存在一对多关系。

图形结构：图形数据元素是多对多关系。

数据存储方式：顺序存储结构和链式存储结构。

顺序存储结构比如数组。

链式存储结构比如队列。

## 算法效率

时间复杂度

T(n)为增长最慢的算法

推到大O阶：
* 用常数1取代运行时间中的所有加法常数。
* 修改后运行次数函数中，只保留最高阶项。
* 如果最高阶项存在且不是1，则去除与这个项相乘的常数。
* 结果就是大O阶。

常见时间复杂度

O(1) ：
常数复杂度，最快的算法。

O(logN)：
对数复杂度，假设有一个有序数组，以二分查找。

O(n):
线性复杂度，假设有一个数组，一遍历的方式在其中查找元素。

O(nlogn)：
求两个数组的交集，其中一个是有序数组，A数组每一个元素都要在B数组中进行查找操作，每次查找如果使用二分法则，则复杂度是logN

O(n2)：
平方复杂度
求两个无序数组的交集

常用时间复杂度所耗费时间：

O(1) < O(logn) < O(n) < O(nlogn) <O(n^2) < O(n^3) < O(2^n) < O(n!) < O(n^n)

空间复杂度

S(n)=O(f(n))
n为问题规模,f(n)为语句所占存储空间的函数。


## 线性表
定义（List）：由零个或者多个数据元素组成的有限序列。

特点：第一个元素无前驱，最后的元素无后继，其他元素有且只有1个前驱和后继。线性表分为顺序存储和链式存储结构。



## 栈
线性表的一种应用，特点：后进先出

## 队列

## 八皇后问题
## KMP模式匹配

## 树
树(Tree)是n(n>0)个结点的有限集。当n=0时成为空树，在任意一棵非空树：根和子树\
结点拥有子树称为结点的度。\
树中结点最大层称为树的深度或高度。\
树中结点的各子树看成从左至右有次序，不能交换，称该树为有序树。\
森林是m(m>=0)棵互不相交的树的集合。对每棵树而言，其子树集合即为森林。

### 树的存储结构
双亲表示法\
孩子表示法 \
双亲孩子表示法\

### 二叉树
1.在二叉树的第i层至多有2^(i-1)个结点（i>=1）。\
2.深度k的二叉树至多有2^k-1个结点（k>=1）。\
3.任意一棵二叉树T,如果其终端结点数n0,度为2结点数为n2,则n0=n2+1,连接数=n-1=n1+2*n2。\
4.具有n个结点的完全二叉树的深度为logn取下限+1

### 线索二叉树

### 转换
普通树转换二叉树：\
1.兄弟结点加一条线。\
2.对树中每个结点，只保留它与第一孩子结点的连线，删除它与其他孩子结点之间的连线。

### 树与森林遍历
森林遍历分为前序和后序遍历，其实就是按照树的先根遍历和后根遍历依次访问森林的每一棵树。\
树、森林的前根遍历和二叉树前序遍历结果相同，树、森林的后根遍历和二叉树中序遍历结果相同。

### 赫夫曼树
赫夫曼树编码是首个实用的压缩编码方案。\


## 图
最短路径：\
网图（带权）是两项顶点经过的边上权值之和最小的路径。\
非网图是两顶点之间经过的边数最小的路径。\

拓扑序列：\
设G=(V,E)是一个具有n个顶点的有向图，V中的顶点序列V1,V2......Vn满足若从Vi到Vj有一条路径，
则在顶点序列中顶点Vi必在顶点Vj之前。这样的顶点序列为拓扑序列。

拓扑排序：\
一个无环的有向图称为无环图，简称DAG图。\
所有工程或者某种流程都可以分为若干个小的工程或者阶段，我们称这些小的工程或阶段为活动。\
在一个表示工程的有向图中，用顶点表示活动，用弧表示活动之间的优先级关系，这样的有向图为顶点表示活动的网，我们称AOV网。(不能存在回路)\
在一个表示工程的带权有向图中，用顶点表示事件，用有向边表示活动，用边上的权值表示活动的持续时间，我们称AOE网。
所谓拓扑排序，其实就是对一个有向图构造拓扑序列的过程。


<!--  
排序 

插入排序类

选择排序类

交换排序类 
-->

