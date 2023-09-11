package org.caranus.sort;
public class BinaryTreeTraversal {

	public static <K> void inOrderTraversal(TreeNode<K> root) {
		if (root == null) {
			return;
		}

		inOrderTraversal(root.left);
		System.out.print(root.val + " ");
		inOrderTraversal(root.right);
	}

	public static <K> void preOrderTraversal(TreeNode<K> root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	public static <K> void postOrderTraversal(TreeNode<K> root) {
		if (root == null) {
			return;
		}

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.val + " ");
	}
}
