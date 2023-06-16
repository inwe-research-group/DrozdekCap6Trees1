package edu.aed.drozdekcap6trees1;

import java.util.LinkedList;

public class Queue<T> {
    private final LinkedList<T> list;

    public Queue() {
        this.list = new LinkedList<>();
    }
    public void clear(){
        list.clear();
    }
    public void enqueue(T element){//encolar
        list.addLast(element);
    }
    public T dequeue(){//desencolar
        return list.removeFirst();
    }
    public T firstElement(){
        return list.getFirst();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int size(){
        return list.size();
    }
    @Override
    public String toString(){
        return list.toString();
    }
}
