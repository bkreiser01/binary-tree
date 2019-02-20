//Brandon Kreiser

import java.util.*;
public class TreeReconstructor
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);

		String preorderString = keyboard.nextLine();
		String inorderString = keyboard.nextLine();
	
		Scanner preorderStringScanner = new Scanner(preorderString);
		ArrayList<Integer> preorderInts = new ArrayList<Integer>();

		Scanner inorderStringScanner = new Scanner(inorderString);
		ArrayList<Integer> inorderInts = new ArrayList<Integer>();
		
		//Transfer the traversal strings to an ArrayList using a scanner.
		while(preorderStringScanner.hasNextInt())
		{
			preorderInts.add(preorderStringScanner.nextInt());
		}

		while(inorderStringScanner.hasNextInt())
		{
			inorderInts.add(inorderStringScanner.nextInt());
		}

		BinaryTreeNode<Integer> root = reconstuct(preorderInts, inorderInts);

		printTree(root);
	}

	public static BinaryTreeNode<Integer> reconstuct(ArrayList<Integer> preorderInts, ArrayList<Integer> inorderInts)
	{
		if(preorderInts == null || inorderInts == null)
			return null;
		else if(preorderInts.size() <= 3)
		{
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorderInts.get(0));
			BinaryTreeNode<Integer> rightChild  = new BinaryTreeNode<Integer>();
            BinaryTreeNode<Integer> leftChild  = new BinaryTreeNode<Integer>();

			//2 elements in the inorder traveral means there is one parent and one child.
			if(inorderInts.size() == 2)
			{
				//If the root is the first element, the rightChild is the other. Otherwise it's the leftChild.		
				if(inorderInts.get(0) == preorderInts.get(0))
				{
					rightChild.setData(inorderInts.get(1));
					root.setRightChild(rightChild);
				}
				else
				{
					leftChild.setData(inorderInts.get(0));
					root.setLeftChild(leftChild);
				}
			}

			//3 elements in the inorder traveral means there is one parent and two children.
			if(inorderInts.size() == 3)
			{
				//Whatever is to the left of the middle is the leftChild and vice versa for the rightChild.
				leftChild.setData(inorderInts.get(0));
				root.setLeftChild(leftChild);

				rightChild.setData(inorderInts.get(2));
				root.setRightChild(rightChild);
			}

			return root;
		}
		else
		{
			BinaryTreeNode<Integer> rootNode = new BinaryTreeNode<Integer>(preorderInts.get(0));		
			int root = preorderInts.get(0);

			//Make a sublist to corrispond to the left portion of the tree's preorder and inorder traversals.
			ArrayList<Integer> leftPreorderInts = new ArrayList<Integer>(preorderInts.subList(1, (inorderInts.indexOf(root) + 1)));
			ArrayList<Integer> leftInorderInts = new ArrayList<Integer>(inorderInts.subList(0, inorderInts.indexOf(root)));
			rootNode.setLeftChild(reconstuct(leftPreorderInts, leftInorderInts));

			//Make a sublist to corrispond to the right portion of the tree's preorder and inorder traversals.
			ArrayList<Integer> rightPreorderInts = new ArrayList<Integer> (preorderInts.subList((inorderInts.indexOf(root) + 1), preorderInts.size()));
			ArrayList<Integer> rightInorderInts = new ArrayList<Integer> (inorderInts.subList((inorderInts.indexOf(root)+ 1), inorderInts.size()));
			rootNode.setRightChild(reconstuct(rightPreorderInts, rightInorderInts));

			return rootNode;
		}
	}

	public static void printTree(BinaryTreeNode<Integer> root)
	{
		ArrayList<BinaryTreeNode<Integer>> traversedTree = root.levelorder();
		
		for(int placeInTraversedTree = 0; placeInTraversedTree < traversedTree.size(); placeInTraversedTree++)
		{
			BinaryTreeNode<Integer> currentNode = traversedTree.get(placeInTraversedTree);

			System.out.print(currentNode);
			
			if(currentNode.getLeftChild() == null)
				System.out.print(" " + "-1" + " ");
			else
				System.out.print(" " + currentNode.getLeftChild() + " ");
			
			if(currentNode.getRightChild() == null)
				System.out.println("-1");
			else
				System.out.println(currentNode.getRightChild());
		}
	}
}
