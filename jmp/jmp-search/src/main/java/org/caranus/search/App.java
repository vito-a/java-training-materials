package org.caranus.search;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.caranus.sort.BinaryTreeTraversal;
import org.caranus.sort.TreeNode;

import org.caranus.search.binary.IterativeBinarySearchImpl;
import org.caranus.search.binary.RecursiveBinarySearchImpl;
import org.caranus.search.generic.GenericSearchImpl;

public class App
{
	protected static Logger logger = Logger.getLogger(App.class.getName());
	public static void main(String[] args)
	{
		GenericSearchImpl<Element<Integer>, Integer> genericSearchImpl =
			  new GenericSearchImpl<>(GenericSearchImpl.ElementToGet.LAST);
		RecursiveBinarySearchImpl<Element<Integer>, Integer> recursiveBinarySearchImpl =
			  new RecursiveBinarySearchImpl<>(GenericSearchImpl.ElementToGet.LAST);
		IterativeBinarySearchImpl<Element<Integer>, Integer> iterativeBinarySearchImpl =
			  new IterativeBinarySearchImpl<>(GenericSearchImpl.ElementToGet.LAST);

		List<Element<Integer>> elementList1 = new ArrayList<>();
		elementList1.add(new Element<>(6));
		elementList1.add(new Element<>(7));
		elementList1.add(new Element<>(8));
		elementList1.add(new Element<>(100));

		List<Element<Integer>> elementList2 = new ArrayList<>();
		elementList2.add(new Element<>(7));
		elementList2.add(new Element<>(8));
		elementList2.add(new Element<>(8));
		elementList2.add(new Element<>(8));
		elementList2.add(new Element<>(9));
		elementList2.add(new Element<>(100));

		System.out.println(genericSearchImpl.search(new Element<>(7), elementList1));
		System.out.println(genericSearchImpl.search(new Element<>(8), elementList2));

		System.out.println(iterativeBinarySearchImpl.search(new Element<>(7), elementList1));
		System.out.println(iterativeBinarySearchImpl.search(new Element<>(8), elementList2));

		System.out.println(recursiveBinarySearchImpl.search(new Element<>(7), elementList1));
		System.out.println(recursiveBinarySearchImpl.search(new Element<>(8), elementList2));

		// Create a sample binary tree
		TreeNode<Integer> root = new TreeNode<>(1);
		root.setLeft(new TreeNode<Integer>(2));
		root.setRight(new TreeNode<>(3));
		root.getLeft().setLeft(new TreeNode<>(4));
		root.getLeft().setRight(new TreeNode<>(5));
		root.getRight().setLeft(new TreeNode<>(6));
		root.getRight().setRight(new TreeNode<>(7));

		System.out.println("Pre-order Traversal:");
		BinaryTreeTraversal.preOrderTraversal(root);
		System.out.println();

		System.out.println("Post-order Traversal:");
		BinaryTreeTraversal.postOrderTraversal(root);
		System.out.println();
	}
}