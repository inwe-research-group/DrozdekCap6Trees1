package edu.aed.maximumheap;

public class MaximumHeapTest {
    
    public static void main(String[] args) {
        MaximumHeap heap;
        boolean ret;
        int max;
        heap=new MaximumHeap(5);
        ret =heap.insertKey(5);
        ret =heap.insertKey(7);
        ret =heap.insertKey(153);
        ret =heap.insertKey(9);
        ret =heap.insertKey(16);
        if(!ret)
            System.out.println("El heap esta lleno.");                
        
//        System.out.println("Integer.MIN_VALUE "+Integer.MIN_VALUE);
//        System.out.println("Integer.MAX_VALUE "+Integer.MAX_VALUE);
        
        System.out.println("Visualizando el heap");
        System.out.println (heap.toString());        
        
        max = heap.extractMax();          
        System.out.println("The maximum extracted es. " + max);
        System.out.println ("heap.extractMax() "+ heap.toString());
        
        max = heap.getMax();        
        System.out.println("heap.getMax()" + max);
        System.out.println ("heap.getMax() "+ heap.toString());        
        
        heap.deleteKey(2);        
        max = heap.getMax();
        System.out.println("The maximum extracted es. " + max);
        System.out.println ("heap.deleteKey(2) "+heap.toString());        
        
        heap.changeValueOnAKey (0, 18);        
        max = heap.getMax();
        System.out.println("The maximum extracted es." + max);
        System.out.println ("heap.changeValueOnAKey (0, 18) "+heap.toString());        
        
        heap.decreaseKey(0,10);        
        max = heap.getMax();
        System.out.println("The maximum extracted es. " + max);        
        System.out.println ("heap.decreaseKey(0,100) "+ heap.toString());
        
    }    
}
