//Brandon Kreiser

import java.util.*;
public class BinaryTreeNode<E>
{
    private E data;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;


    public BinaryTreeNode(E d, BinaryTreeNode<E> left, BinaryTreeNode<E> right)
    {
        data = d;
        leftChild = left;
        rightChild = right;
    }

    public BinaryTreeNode(E d)
    {
        this(d, null, null);
    }

    public BinaryTreeNode()
    {
        this(null, null, null);
    }



    public E getData()
    {
        return data;
    }

    public void setData(E d)
    {
        data = d;
    }

    public BinaryTreeNode<E> getLeftChild()
    {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<E> lc)
    {
        leftChild = lc; 
    }

    public BinaryTreeNode<E> getRightChild()
    {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode<E> rc)
    {
        rightChild = rc;
    }

    public int height()
    {
        if(leftChild == null && rightChild == null)
            return 0;
        else
        {
            int leftHeight;
            int rightHeight;

            //If a child is null, set the hight to zero. Otherwise, recursively check the childs height.
            if(leftChild == null)
                leftHeight = 0;
            else
                leftHeight = leftChild.height();

            if(rightChild == null)
                rightHeight = 0;
            else
                rightHeight = rightChild.height();

            //Whichever height is higher is the height of the current node. Return this value and account for the height of the current node.
            if(leftHeight > rightHeight)
                return leftHeight + 1;
            else
                return rightHeight + 1;
        }
    }

    public String toString()
    {
        if(data == null)
            return "Null";
        else
            return "" + data;
    }
 
    public ArrayList<BinaryTreeNode<E>> preorder()
    {
        ArrayList<BinaryTreeNode<E>> visitedNodes = new ArrayList<BinaryTreeNode<E>>();
        
        visitedNodes.add(this);

        if(leftChild != null)
            visitedNodes.addAll(leftChild.preorder());
        
        if(rightChild != null)
            visitedNodes.addAll(rightChild.preorder());
          
        return visitedNodes;
    }

    public ArrayList<BinaryTreeNode<E>> postorder()
    {
        ArrayList<BinaryTreeNode<E>> visitedNodes = new ArrayList<BinaryTreeNode<E>>();
        
        if(leftChild != null)
            visitedNodes.addAll(leftChild.postorder());

        if(rightChild != null)
            visitedNodes.addAll(rightChild.postorder());
        
        visitedNodes.add(this);
        
        return visitedNodes;
    }

    public ArrayList<BinaryTreeNode<E>> inorder()
    {
        ArrayList<BinaryTreeNode<E>> visitedNodes = new ArrayList<BinaryTreeNode<E>>();

        if(leftChild != null)
            visitedNodes.addAll(leftChild.inorder());

        visitedNodes.add(this);

        if(rightChild != null)
            visitedNodes.addAll(rightChild.inorder());

        return visitedNodes;
    }

    public ArrayList<BinaryTreeNode<E>> levelorder()
    {
        ArrayList<BinaryTreeNode<E>> visitedNodes = new ArrayList<BinaryTreeNode<E>>();
        LinkedList<BinaryTreeNode<E>> queue = new LinkedList<BinaryTreeNode<E>>();
        BinaryTreeNode<E> node;
        queue.add(this);

        while(queue.peek() != null)
        {
            node = queue.peek();
            visitedNodes.add(node);
            queue.remove();

            /*Make sure the current node's child isnt null before adding it to the queue.
             If a null child is added, the while loop would stop before completeing the queue.*/
            if(node.getLeftChild() != null)
                queue.add(node.getLeftChild());
            if(node.getRightChild() != null)
                queue.add(node.getRightChild());
        }
        
        return visitedNodes;
    }  
}
