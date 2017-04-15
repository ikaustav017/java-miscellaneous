package com.kaustavn.binaryTree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree and a sum, find all root to leaf paths where each path's sum ==given sum
 */

public class PathSum {

	public List<List<Integer>> pathSum(NodeSimple root, int sum) {

		List<Integer> currentPath = new ArrayList<Integer>();
		List<List<Integer>> resultPath = new ArrayList<>();
		pathSumUtil(root, sum, resultPath, currentPath);

		return resultPath;

	}

	private void pathSumUtil(NodeSimple root, int sum, List<List<Integer>> result, List<Integer> current) {
		if (root == null)
			return;

		if (root.getLeft() == null && root.getRight() == null) {
			if (root.getData() == sum) {
				current.add(root.getData());
				result.add(new ArrayList<>(current));
				current.remove(current.size() - 1);

			}
			return;
		}

		current.add(root.getData());
		pathSumUtil(root.getLeft(), sum - root.getData(), result, current);
		pathSumUtil(root.getRight(), sum - root.getData(), result, current);
		current.remove(current.size() - 1);

	}

	public boolean hasPathSum(NodeSimple root, int sum) {

		if (root == null)
			return false;
		if (root.getLeft() == null && root.getRight() == null)
			return root.getData() == sum;

		return hasPathSum(root.getLeft(), sum - root.getData()) || hasPathSum(root.getRight(), sum - root.getData());

	}

}
