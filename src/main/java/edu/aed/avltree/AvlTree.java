package edu.aed.avltree;
public class AvlTree {
    AvlTreeNode root;
    private int getBalance(AvlTreeNode node){
        if(node==null)
            return 0;
        return height(node.left)-height(node.right);
    }
    public int height(AvlTreeNode node){
        if (node==null)
            return 0;
        return node.height;
    }
    private int countNodes(AvlTreeNode node){
        if (node==null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    public int size(){
        return countNodes(root);
    }
    
            
}
