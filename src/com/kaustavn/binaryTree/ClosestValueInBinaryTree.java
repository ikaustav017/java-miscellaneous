package com.kaustavn.binaryTree;

public class ClosestValueInBinaryTree {

	public int closesetValue(NodeSimple root, double target) {

		int closest = target > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

		return closestValueUtil(root, target, closest);

	}

	private int closestValueUtil(NodeSimple root, double target, int closestNode) {

		if (root == null)
			return closestNode;
		if (target == root.getData())
			return root.getData();

		if (Math.abs(target - root.getData()) < Math.abs(target - closestNode)) {
			closestNode = root.getData();
		}
		if (target < root.getData())
			return closestValueUtil(root.getLeft(), target, closestNode);
		else {
			return closestValueUtil(root.getRight(), target, closestNode);
		}

	}
}
