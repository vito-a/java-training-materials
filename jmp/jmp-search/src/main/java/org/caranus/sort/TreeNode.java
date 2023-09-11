package org.caranus.sort;

public class TreeNode<K> {
	K val;
	TreeNode<K> left;
	TreeNode<K> right;

	public TreeNode(K val) {
		this.val = val;
	}

	public K getVal()
	{
		return val;
	}

	public void setVal(final K val)
	{
		this.val = val;
	}

	public TreeNode<K> getLeft()
	{
		return left;
	}

	public void setLeft(final TreeNode<K> left)
	{
		this.left = left;
	}

	public TreeNode<K> getRight()
	{
		return right;
	}

	public void setRight(final TreeNode<K> right)
	{
		this.right = right;
	}
}