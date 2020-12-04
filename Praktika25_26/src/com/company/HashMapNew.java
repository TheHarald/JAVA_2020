package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class HashMapNew<K,V> implements HashMapInterface<K,V>{

   private final ArrayList<ArrayList<Unit<K,V>>> map;
   private static final int hashSize=16;
   private Unit<K,V> temp = new Unit<>();

    public HashMapNew() {
        map=new ArrayList<>();
        for (int i = 0; i < hashSize; i++)
            map.add(new ArrayList<Unit<K,V>>());

    }

    @Override
    public void add(K key, V value) {
        int index = key.hashCode() % map.size();
        if(map.get(index).size()!=0){
            for(int i = 0; i < map.get(index).size(); i++)
            {
                Unit<K,V> unit = map.get(index).get(i);
                if(key.hashCode() == unit.getKey().hashCode())
                {
                    unit = new Unit<>(key, value);
                    map.get(index).set(i, unit);
                    break;
                }
                else
                {
                    map.get(index).add(new Unit<>(key,value));
                    break;
                }
            }
        }
        else if(map.get(index).size()==0){
            map.get(index).add(new Unit<>(key,value));
        }

    }

    @Override
    public V get(K key) {
        temp=search(key);
        return temp != null ? temp.getValue() : null;
    }

    @Override
    public V remove(K key) {
        int index = key.hashCode()%map.size();
        temp=search(key);
        if(temp!=null){

            map.get(index).remove(temp);
            return temp.getValue();
        }
        return null;
    }

    private Unit<K,V> search(K key){
        int index = key.hashCode()%map.size();
        for (int i = 0; i < map.get(index).size(); i++) {
            if(key.hashCode()==map.get(index).get(i).getKey().hashCode())
                temp.setValue(map.get(index).get(i).getValue());
            return temp;
        }
        return null;
    }

    @Override
    public Iterator<V> iterator() {
        return (new Iterator<V>() {
            int currentIndexOfValues=0,currentIndexOfArray=0;
            @Override
            public boolean hasNext() {

                if(currentIndexOfArray==hashSize-1)
                    return false;

                while (map.get(currentIndexOfArray+1).size()==0){
                    currentIndexOfArray++;
                    currentIndexOfValues=0;
                    if(currentIndexOfArray==hashSize-1)
                        return false;
                }

                if(currentIndexOfValues==map.get(currentIndexOfArray).size()) {
                    currentIndexOfArray++;
                    currentIndexOfValues=0;
                }
                return (currentIndexOfArray<hashSize) &&
                        (currentIndexOfValues < map.get(currentIndexOfArray).size());
            }
            @Override
            public V next() {
                return map.get(currentIndexOfArray).get(currentIndexOfValues++).getValue();
            }
        });
    }
}
