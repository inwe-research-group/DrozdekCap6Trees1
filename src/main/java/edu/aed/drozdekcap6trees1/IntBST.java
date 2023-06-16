package edu.aed.drozdekcap6trees1;

public class IntBST {
    protected IntBSTNode root;

    public IntBST() {
        this.root = null;
    }    
    protected void visit(IntBSTNode p){
        System.out.println(p.key +" ");
    }
    public void insert(int e1){
      IntBSTNode p=root, prev=null;
      while(p!=null){
          prev=p;
          if(p.key<e1)
              p=p.right;
          else p=p.left;
      }
      if (root==null)
          root=new IntBSTNode(e1);
      else if(prev.key<e1)
          prev.right=new IntBSTNode(e1);
      else
          prev.left=new IntBSTNode(e1);
    }
    
    protected void inorder(){
        inorder(root);
    }
    //LVR
    protected void inorder(IntBSTNode p){
        if(p!=null){
           inorder(p.left);
           visit(p);
           inorder(p.right);
        }     
    }    
    protected void preorder(){//VLR
        preorder(root);
    }
    protected void preorder(IntBSTNode p){//VLR
        if(p!=null){
           visit(p);
           preorder(p.left);           
           preorder(p.right);
        } }    
    protected void postorder(){//LRV
        postorder(root);
    }
    protected void postorder(IntBSTNode p){//LRV
        if(p!=null){           
           postorder(p.left);           
           postorder(p.right);
           visit(p);
        }
    }
    //recorrido en amplitud
    public void breadthFirst(){
        IntBSTNode p=root;
        Queue queue=new Queue();
        if(p!=null){
            queue.enqueue(p);
            while(!queue.isEmpty()){
                p=(IntBSTNode)queue.dequeue();
                visit(p);
                if(p.left!=null)
                    queue.enqueue(p.left);
                if(p.right!=null)
                    queue.enqueue(p.right);            
            }
        }
        
    }
    
    public IntBSTNode search(int e1){
        return search(root,e1);
    }
    protected IntBSTNode search(IntBSTNode p,int e1){
        while(p!=null){
            if(e1==p.key)
                return p;
            else if(e1<p.key)
                p=p.left;
            else
                p=p.right;
        }
        return null;
    }
    
    public void deleteByMerging(int e1){
        IntBSTNode tmp,node,p=root,prev=null;
        while(p!=null && p.key!=e1){
            prev=p;
            if(p.key<e1) p=p.right;
            else p=p.left;}
        node=p;
        if(p!=null && p.key==e1){
            if(node.right==null)
                node=node.left;
            else if (node.left==null)
                node=node.right;
            else{
                tmp=node.left;
                while(tmp.right!=null)
                    tmp=tmp.right;
                tmp.right=node.right;
                node=node.left;}
            if(p==root)
                root=node;
            else if(prev.left==p)
                prev.left=node;
            else prev.right=node;                
        }
        else if(root!=null)
            System.out.println("llave "+e1+ "no se encuentra en el arbol");
        else System.out.println("el arbol esta vacio");
    }
    public void deleteByCopying(int e1){
        IntBSTNode tmp,node,p=root,prev=null,previous;
        while(p!=null && p.key!=e1){
            prev=p;
            if(p.key<e1) p=p.right;
            else p=p.left;}
        node=p;
        if(p!=null && p.key==e1){
            if(node.right==null)
                node=node.left;
            else if (node.left==null)
                node=node.right;
            else{
                tmp=node.left;
                previous=node;
                while(tmp.right!=null){
                    previous=tmp;
                    tmp=tmp.right;
                }
                node.key=tmp.key;//Realiza el copiado
                if(previous==node)
                    previous.left=tmp.left;
                else previous.right=tmp.left;                    
            }
            if(p==root)
                root=node;
            else if(prev.left==p)
                prev.left=node;
            else prev.right=node;
        }
        else if(root!=null)
            System.out.println("llave "+e1+ "no se encuentra en el arbol");
        else System.out.println("el arbol esta vacio");
    }
    
}
