package edu.aed.avltree;

public class TestAvlTree {
    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        System.out.println("--- indica nodo izquierdo, +++ indica nodo derecho");
        
        System.out.println("insertando 1 nodo al BST");
        tree.insert(10);
        System.out.print(tree.toString());
        
        System.out.println("insertando 1 nodo al BST");
        tree.insert(20);
        System.out.print(tree.toString());
        
        System.out.println("insertando 1 nodo al BST");
        tree.insert(30);
        System.out.print(tree.toString());
        
        System.out.println("insertando 1 nodo al BST");
        tree.insert(40);
        System.out.print(tree.toString());
        
        System.out.println("insertando 1 nodo al BST");
        tree.insert(50);
        System.out.print(tree.toString());
        
        System.out.println("insertando 1 nodo al BST");
        tree.insert(25);
        System.out.print(tree.toString());
        
        System.out.println("El tamaño del arbol es: " + tree.size());   
                
        System.out.println("preOrder(VLR) traversal of constructed tree is : ");
        System.out.println(tree.preOrder());//VLR
        
        System.out.println("In-order(LVR) traversal of constructed tree is : ");
        System.out.println(tree.inOrder());//LVR     
        
        System.out.println("postOrder(LRV) traversal of constructed tree is : ");
        System.out.println(tree.postOrder());//LRV
    }
}
