package com.algorithm.structure.hash;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 拉链法
 *
 * https://blog.csdn.net/qq_35580883/article/details/79150509
 * @Author: limeng
 * @Date: 2019/8/7 20:43
 */
public class HashMapDemo2 {

    @Test
    public void HashTableTest(){
        HashTable<String, String> hashTableTest = new HashTable<>();
        hashTableTest.put("t1","v1");
        hashTableTest.put("t2","v2");
        hashTableTest.put("t3","v3");
        hashTableTest.put("t4","v4");
        hashTableTest.put("t5","v5");
        hashTableTest.put("t6","v6");

    }




    @Test
    public void hashFunction(){
        double DEFAULT_CONSTANT = 0.6180339887;
        Object k=new Object();
        System.out.println(DEFAULT_CONSTANT * k.hashCode());
        System.out.println((int) DEFAULT_CONSTANT * k.hashCode());
    }

}
class HashTable<K,V>{
    public static class Entry<K,V>{
        private K key;
        private V value;

        public Entry() {
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final boolean equals(Object o) {
            if(o == this){
                return true;
            }
            if(o instanceof Entry){
                Entry<?, ?> o1 = (Entry<?, ?>) o;
                if(Objects.equals(key,o1.getKey()) &&
                        Objects.equals(value,o1.getValue())
                ){
                    return true;
                }
            }
            return false;
        }


    }
    private LinkedList<Entry<K,V>>[] elements;
    private HashFunctionHost hashFunctionHost;
    private int capacity;
    private static final int DEFAULT_SIZE = 4;
    public static final HashFunctionHost DEFAULT_HASH_FUNCTION_HOST = new DivisionHashFunctionHost();
    public HashTable(int size,HashFunctionHost hashFunctionHost){
        elements = new LinkedList[size];
        for (int i=0;i<size;i++){
            elements[i] = new LinkedList<Entry<K,V>>();
        }
        this.hashFunctionHost = hashFunctionHost;
        this.capacity = 0;
    }

    public HashTable(){
        this(DEFAULT_SIZE,DEFAULT_HASH_FUNCTION_HOST);
    }

    private Entry<K,V> getEntry(K key){
        int index = DEFAULT_HASH_FUNCTION_HOST.hashFunction(this, key);
        Iterator<Entry<K, V>> iterator = elements[index].iterator();
        while (iterator.hasNext()){
            //链表，不推荐集合get
            Entry<K, V> next = iterator.next();
            if(key.equals(next.getKey())){
                return next;
            }
        }
        return null;
    }

    public void put(K key,V value){
        int index = DEFAULT_HASH_FUNCTION_HOST.hashFunction(this, key);
        Entry<K, V> kvEntry = new Entry<>(key, value);
        if(elements[index].size() == 0){
            elements[index].add(kvEntry);
            capacity++;
        }else {
            //发生了哈希碰撞则需求遍历链表判断k值是不是已经存在了
            Entry<K, V> entry = getEntry(key);
            if(entry != null){
                entry.value = value;
                return;
            }
            //执行这里说明没有发现重复的key,插入链表头部
            elements[index].addFirst(kvEntry);
        }
    }

    public boolean delete(K key){
        int index = DEFAULT_HASH_FUNCTION_HOST.hashFunction(this, key);
        Iterator<Entry<K, V>> iterator = elements[index].iterator();
        while (iterator.hasNext()){
            Entry<K, V> next = iterator.next();
            if(next.getKey() == key){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public V get(K key){
        Entry<K, V> entry = getEntry(key);
        if(entry == null){
            return null;
        }
        return entry.getValue();
    }

    public int bucketNum(){
        return elements.length;
    }

    public int size(){
        return capacity;
    }
}

interface HashFunctionHost{
    //接口约定根据index确定hash
    public <K,V> int hashFunction(HashTable<K,V> hashTable, K x);
}


class DivisionHashFunctionHost implements HashFunctionHost {

    @Override
    public <K,V> int hashFunction(HashTable<K,V> hashTable, K x) {
        int h;
        //减少碰撞，高位和低位
        // hash%(桶数)
        int hash=(x == null) ? 0:(h = x.hashCode()) ^ (h >>> 16);
       // return Math.abs(x.hashCode())%hashTable.bucketNum();
        int i=(hashTable.bucketNum() -1 ) & hash;
        return i;
    }
}
