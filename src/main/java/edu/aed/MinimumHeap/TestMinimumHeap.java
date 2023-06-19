package edu.aed.MinimumHeap;

public class TestMinimumHeap {
    public static void main(String[] args) {
        MinimumHeap heap=new MinimumHeap(5);
        boolean ret;
        int min;
        ret =heap.insertKey(5);
        ret =heap.insertKey(7);
        ret =heap.insertKey(1);
        ret =heap.insertKey(9);
        ret =heap.insertKey(16);

        if(!ret)
            System.out.println("The heap is full.");
        System.out.println (heap.toString());
        min = heap.extractMin();
        System.out.println("heap.extractMin()" + min);
        System.out.println (heap.toString());
        
        min = heap.getMin();
        System.out.println("heap.getMin()" + min);
        
        heap.deleteKey(0);
        min = heap.getMin();
        System.out.println("heap.deleteKey(0)-heap.getMin()" + min);
        System.out.println (heap.toString());
        
        heap.changeValueOnAKey (0, 18);
        min = heap.getMin();
        System.out.println("heap.changeValueOnAKey(0,18)-heap.getMin()" + min);
        System.out.println (heap.toString());
        
        heap.decreaseKey(1,-1);
        min = heap.getMin();
        System.out.println("heap.decreaseKey(1,-1)-heap.getMin()" + min);
        System.out.println (heap.toString());
    }
}
