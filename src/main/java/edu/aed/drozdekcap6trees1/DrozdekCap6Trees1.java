package edu.aed.drozdekcap6trees1;

public class DrozdekCap6Trees1 {

    public static void main(String[] args) {
        IntBST arbol = new IntBST();//BST:Binary Search Tree
        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);      
        System.out.println("Recorrido InOrder del arbol");
        arbol.inorder();
//        System.out.println("Recorrido PreOrder del arbol");
//        arbol.preorder();
//        System.out.println("Recorrido PostOrder del arbol");
//        arbol.postorder();
//        System.out.println("Recorrido primero en amplitud del arbol");
//        arbol.breadthFirst();
//        System.out.println("Buscando el elemento 40");
//        arbol.visit(arbol.search(40));
        System.out.println("Eliminando un nodo por el metodo deleteByMerging");
        arbol.deleteByCopying(70);
        arbol.inorder();
        
        
    }
}
