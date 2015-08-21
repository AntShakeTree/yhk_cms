package com.ykh.common.cache;

public class Pair<K, V> {
    public K key;

    public V value;
    
    public Pair() {}
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}