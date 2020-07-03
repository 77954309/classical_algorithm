package com.algorithm.structure.link;

/**
 * @Classname LruList2
 * @Description TODO
 * @Date 2020/6/29 23:00
 * @Created by limeng
 * lru
 * 维护一个有序单链表，越靠近链表尾部节点，越早之前访问的。当有一个新的数据访问时，我们从链表头开始顺序遍历链表。
 * 1.如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来位置删除，然后再插入到链表头部。
 * 2.如果此数据没有在缓存链表中，又分为两种情况
 * 如果此时缓存未满，则将此结点直接插入到链表的头部
 * 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 *
 */
public class LruList2 {

}
