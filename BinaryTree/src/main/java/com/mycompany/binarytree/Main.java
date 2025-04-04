
package com.mycompany.binarytree;

/**
 *
 * @author ronal
 */
public class Main {
    private TreeNode root;
    
    private class TreeNode{
        private TreeNode left = null;
        private TreeNode rigth = null;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
        
    }
    
    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third= new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth= new TreeNode(5);
        
        root = first;
        first.left = second;
        first.rigth = third;
        second.left = fourth;
        second.rigth = fifth;
        
    }
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data+"");
        preOrder(root.left);
        preOrder(root.rigth);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(0);
        tree.insert(9);
        
        tree.inOrder();
        
        
        
        
        
    }
}
