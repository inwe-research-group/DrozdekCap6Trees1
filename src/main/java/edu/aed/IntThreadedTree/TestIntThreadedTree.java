package edu.aed.IntThreadedTree;

public class TestIntThreadedTree {
    public static void main(String[] args) {
        IntThreadedTree tree = new IntThreadedTree();
        tree.insert(3);
        tree.insert(5);
        tree.insert(6);
        tree.insert(21);
        tree.insert(65);
        tree.insert(19);
        System.out.println("Size: " + tree.size()); 
        System.out.println("threadInOrder");
        tree.threadInOrder(System.out);
        System.out.println("printInOrder");
        tree.printInOrder(System.out);
    }    
}
