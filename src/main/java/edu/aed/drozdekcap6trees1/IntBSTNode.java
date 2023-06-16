package edu.aed.drozdekcap6trees1;

public class IntBSTNode {
    protected int key;
    protected IntBSTNode left,right;
    
    public IntBSTNode(){
        left=right=null;
    }    
    public IntBSTNode(int key){
        this.key=key;
    }
    public IntBSTNode(int key, IntBSTNode left, IntBSTNode right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
    
    
    
}
