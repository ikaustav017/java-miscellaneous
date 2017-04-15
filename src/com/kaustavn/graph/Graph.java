package com.kaustavn.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

	private HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();

	public static class Node {
		private int id;
		LinkedList<Node> adjacent = new LinkedList<Node>();

		private Node(int id) {
			this.id = id;
		}

	}

	private Node getNode(int id) {
		return nodeLookup.get(id);
	}

	public void addEdge(int source, int destination) {
		Node src = getNode(source);
		Node dest = getNode(destination);
		src.adjacent.add(dest);
	}

	public boolean hasPathDFS(int source, int destination) {

		Node src = getNode(source);
		Node dest = getNode(destination);
		HashSet<Integer> visited = new HashSet<Integer>();

		return hasPathDFS(src, dest, visited);
	}

	private boolean hasPathDFS(Node src, Node dest, HashSet<Integer> visited) {

		if (visited.contains(src.id))
			return false;

		visited.add(src.id);
		if (src == dest)
			return true;

		for (Node node : src.adjacent) {
			if (hasPathDFS(node, dest, visited))
				return true;
		}
		return false;
	}

	public boolean hasPathBFS(int source, int destination) {

		Node src = getNode(source);
		Node dest = getNode(destination);
		HashSet<Integer> visited = new HashSet<Integer>();

		return hasPathBFS(src, dest, visited);
	}

	public boolean hasPathBFS(Node source, Node destination, HashSet<Integer> visited) {

		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		nextToVisit.add(source);

		while (!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			if (node == destination) {
				return true;
			}
			if (visited.contains(node.id))
				continue;

			visited.add(node.id);
			nextToVisit.addAll(node.adjacent);
		}
		return false;
	}

}
