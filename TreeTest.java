//Brandon Kreiser

import java.util.*;
public class TreeTest
{
    public static void main(String args[])
    {
        BinaryTreeNode<Integer> node10 = new BinaryTreeNode<Integer>(10);
        BinaryTreeNode<Integer> node9 = new BinaryTreeNode<Integer>(9);
        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<Integer>(8);
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<Integer>(7, null, node10);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<Integer>(4, node8, node9);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(3, node6, node7);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(2, node4, node5);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1, node2, node3);
        
     
        ArrayList<BinaryTreeNode<Integer>> list = new ArrayList<BinaryTreeNode<Integer>>();
        System.out.println();

        System.out.println("Prorder");
        list = root.preorder(); 
        System.out.println(list);
        System.out.println("");

        System.out.println("Postorder");
        list = root.postorder(); 
        System.out.println(list);
        System.out.println("");

        System.out.println("Inorder");
        list = root.inorder(); 
        System.out.println(list);
        System.out.println("");

        System.out.println("Level Order");
        list = root.levelorder(); 
        System.out.println(list);
        System.out.println("");

        System.out.print("Height @ root: ");
        System.out.println(root.height());
        System.out.println("");
    }
}
