package com.kaustavn.binaryTree;

public class LowestCommonAncestor {

	public static NodeSimple lca(NodeSimple root, NodeSimple n1, NodeSimple n2) {

		if (root == null)
			return null;
		if (root == n1 || root == n2)
			return root;

		NodeSimple left = lca(root.getLeft(), n1, n2);
		NodeSimple right = lca(root.getRight(), n1, n2);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;

	}

	public static NodeSimple lcaInBST(NodeSimple root, int p, int q) {

		if (root == null)
			return null;
		if (root.getData() > Math.max(p, q))
			return lcaInBST(root.getLeft(), p, q);
		else if (root.getData() < Math.min(p, q))
			return lcaInBST(root.getRight(), p, q);
		else
			return root;

	}

}
