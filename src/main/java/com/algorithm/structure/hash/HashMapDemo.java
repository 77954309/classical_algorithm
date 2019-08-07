package com.algorithm.structure.hash;

import scala.collection.mutable.Node;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * https://blog.csdn.net/m0_37914588/article/details/82287191
 * https://www.cnblogs.com/xiaoxi/p/7233201.html
 * @Author: limeng
 * @Date: 2019/8/2 10:49
 */
public class HashMapDemo<K,V> extends AbstractMap<K,V>
        implements Map<K,V>, Cloneable, Serializable {
    /**
     * 默认容量
     * 1向左移位4个
     * 2的4次方
     */
    static final int DEFAULT_INITIAL_CAPACITY=1<<4;
    //最大容量
    static final int MAXIMUM_CAPACITY = 1 << 30;
    //加载因子，用于扩容使用
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    //当某个桶节点数量大于8时，会转换红黑树
    static final int  TREEIFY_THRESHOLD =8;
    //当某个桶节点数量小于6时，会转变为链表，前提红黑树结构
    static final int UNTREEIFY_THRESHOLD = 6;
    //当整个hashmap中元素数量大于64，也会进行红黑树结构
    static final int MIN_TREEIFY_CAPACITY=64;

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return null;
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {

    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {

    }

    @Override
    public V putIfAbsent(K key, V value) {
        return null;
    }

    @Override
    public boolean remove(Object key, Object value) {
        return false;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return false;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return null;
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return null;
    }

    //存储元素的数组，transient元素不被序列化

    static class Node<K,V> implements Map.Entry<K,V>{
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }


}
