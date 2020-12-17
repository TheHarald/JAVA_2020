package com.company;

import java.util.Objects;

public class Unit<K,V> {
    private K key;
    private V value;

    public Unit(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Unit() {
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
    public String toString() {
        return "Unit{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit<?, ?> unit = (Unit<?, ?>) o;
        return Objects.equals(key, unit.key) &&
                Objects.equals(value, unit.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
