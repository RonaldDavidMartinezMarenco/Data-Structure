
package com.mycompany.binarytree;

class Node{
    int data;
    Node Rigth;
    Node left;
    
    public Node (int data){
        this.data = data;
    }
}

public class BinaryTree {
    private Node root;
    public void insert(int data){
        
        root = insertRec(root,data);  
    }
    public Node insertRec(Node root, int data){
         if(root == null){
             root = new Node(data);
         }else if(data < root.data){
             root.left = insertRec(root.left, data);
         }else if (data > root.data){
             root.Rigth = insertRec(root.Rigth,data);
         }
         return root;
        
    }
    //I,R,D
    public void inOrder(){
        
        inOrderRec(root);
    }
    public void inOrderRec(Node root){
        if(root != null){
            inOrderRec(root.left);
            System.out.println(root.data+" ");
            inOrderRec(root.Rigth); 
        }
    }
    
}

