package edu.aed.avltree;
 /* El árbol AVL es un árbol de búsqueda binaria (BST) autoequilibrado donde la diferencia 
 * entre las alturas de los subárboles izquierdo y derecho no puede ser más de uno para 
 * todos los nodos.*/
public class AvlTree {
    AvlTreeNode root;
    // Obtener el factor de balance del nodo N
    private int getBalance(AvlTreeNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }
    private int countNodes(AvlTreeNode node) {
        //caso base
        if (node == null)
            return 0;        
        //llamada recursiva al hijo izquierdo y al hijo derecho 
        //y sume el resultado de estos con 1 (1 para contar la raíz)
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    public int size() {
        return countNodes(root);
    }
    // Una función de utilidad para obtener la altura del árbol.
    public int height(AvlTreeNode n) {
        if (n == null)
            return 0;
        return n.height;
    }
    public void insert(int key) {
        root = insertNode(root, key);
    }
    private AvlTreeNode insertNode(AvlTreeNode node, int key) {
        /* 1.  Realiza la insercion normal BST*/
        if (node == null)
            return (new AvlTreeNode(key));

        if (key < node.key)
            node.left = insertNode(node.left, key);
        else if (key > node.key)
            node.right = insertNode(node.right, key);
        else // keys duplicados no esta permitido
            return node;

        /* 2. Actualiza el height del su nodo superior*/
        node.height = 1 + Math.max(height(node.left), height(node.right));
        /* 3. Obtiene el factor de balance de su nodo superior para verificar 
              si este nodo se desbalanceo */        
        int balance = getBalance(node);
        // Si este nodo se desbalanceo, entonces tenemos 4 casos
        // left-left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // right-right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // left-right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }       
        return node;
    }

    //Una función de utilidad para rotar a la izquierda el subárbol rooted con x    
    private AvlTreeNode leftRotate(AvlTreeNode a) {
        AvlTreeNode b = a.right;
        AvlTreeNode t2 = b.left;

        // Realiza la rotacion
        b.left = a;
        a.right = t2;

        //  Actualiza heights
        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;

        // Retorna nuevo root
        return b;
    }

    // Una funcion para imprimir recorrido preorder del arbol, incluye los height de cada nodo    
    private String preOrder(AvlTreeNode node) {
        StringBuilder tree = new StringBuilder();
        if (node != null) {
            tree.append(node.key);
            tree.append(" ");
            tree.append(preOrder(node.left));
            tree.append(preOrder(node.right));
        }
        return tree.toString();
    }

    //Una funcion para imprimir recorrido inOrder del arbol, incluye los height de cada nodo    
    private String inOrder(AvlTreeNode node) {
        StringBuilder tree = new StringBuilder();        
        if (node != null) {
            tree.append(inOrder(node.left));
            tree.append(node.key);
            tree.append(" ");
            tree.append(inOrder(node.right));
        }
        return tree.toString();
    }

    //Una funcion para imprimir recorrido postOrder del arbol, incluye los height de cada nodo    
    private String postOrder(AvlTreeNode node) {
        StringBuilder tree = new StringBuilder();        
        if (node != null) {
            tree.append(postOrder(node.left));
            tree.append(postOrder(node.right));
            tree.append(node.key);
            tree.append(" ");
        }        
        return tree.toString();
    }

    @Override
    public String toString(){
        return root.toString();
    }

    public String preOrder(){
        return preOrder(root);
    }

    public String postOrder(){
        return postOrder(root);
    }

    public String inOrder(){
        return inOrder(root);
    }

    // Una funcion para rotar a la derercha el subarbol rooted with y    
    private AvlTreeNode rightRotate(AvlTreeNode b) {
        AvlTreeNode a = b.left;
        AvlTreeNode t2 = a.right;
        // Realiza la rotacion
        a.right = b;
        b.left = t2;
        //Actualiza heights
        b.height = Math.max(height(b.left),
                height(b.right)) + 1;
        a.height = Math.max(height(a.left),
                height(a.right)) + 1;

        // Retorna nuevo root
        return a;
    }
}
